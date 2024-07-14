<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="医生姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入医生姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="pid">
        <el-input
          v-model="queryParams.pid"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="UUID" prop="uuid">
        <el-input
          v-model="queryParams.uuid"
          placeholder="请输入UUID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医生性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择医生性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="医生电话" prop="tel">
        <el-input
          v-model="queryParams.tel"
          placeholder="请输入医生电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医生邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入医生邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否在小程序上推荐" prop="recommended">
        <el-select v-model="queryParams.recommended" placeholder="请选择是否在小程序上推荐" clearable>
          <el-option
            v-for="dict in dict.type.hospital_doctor_recommend_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.hospital_doctor_status_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hospital:doctor:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hospital:doctor:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hospital:doctor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hospital:doctor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="doctorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="医生姓名" align="center" prop="name" />
      <el-table-column label="身份证号" align="center" prop="pid" />
      <el-table-column label="医生性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="医生照片地址" align="center" prop="photo" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.photo" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="医生生日" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="医生毕业学校" align="center" prop="school" />
      <el-table-column label="医生学位" align="center" prop="degree" />
      <el-table-column label="医生电话" align="center" prop="tel" />
      <el-table-column label="医生地址" align="center" prop="address" />
      <el-table-column label="医生邮箱" align="center" prop="email" />
      <el-table-column label="医生职务" align="center" prop="job" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="详细介绍" align="center" prop="description" />
      <el-table-column label="入职日期" align="center" prop="hiredate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.hiredate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="特点标签" align="center" prop="tag" />
      <el-table-column label="是否在小程序上推荐" align="center" prop="recommended">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hospital_doctor_recommend_type" :value="scope.row.recommended"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hospital_doctor_status_type" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hospital:doctor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:doctor:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改医生对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入医生姓名" />
        </el-form-item>
        <el-form-item label="身份证号" prop="pid">
          <el-input v-model="form.pid" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="UUID" prop="uuid">
          <el-input v-model="form.uuid" placeholder="请输入UUID" />
        </el-form-item>
        <el-form-item label="医生性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择医生性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="医生照片地址" prop="photo">
          <image-upload v-model="form.photo"/>
        </el-form-item>
        <el-form-item label="医生生日" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择医生生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="医生毕业学校" prop="school">
          <el-input v-model="form.school" placeholder="请输入医生毕业学校" />
        </el-form-item>
        <el-form-item label="医生电话" prop="tel">
          <el-input v-model="form.tel" placeholder="请输入医生电话" />
        </el-form-item>
        <el-form-item label="医生地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入医生地址" />
        </el-form-item>
        <el-form-item label="医生邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入医生邮箱" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="详细介绍" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="入职日期" prop="hiredate">
          <el-date-picker clearable
            v-model="form.hiredate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="特点标签" prop="tag">
          <el-input v-model="form.tag" placeholder="请输入特点标签" />
        </el-form-item>
        <el-form-item label="是否在小程序上推荐" prop="recommended">
          <el-select v-model="form.recommended" placeholder="请选择是否在小程序上推荐">
            <el-option
              v-for="dict in dict.type.hospital_doctor_recommend_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option
              v-for="dict in dict.type.hospital_doctor_status_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDoctor, getDoctor, delDoctor, addDoctor, updateDoctor } from "@/api/hospital/doctor";

export default {
  name: "Doctor",
  dicts: ['hospital_doctor_recommend_type', 'sys_user_sex', 'hospital_doctor_status_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 医生表格数据
      doctorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        pid: null,
        uuid: null,
        sex: null,
        tel: null,
        email: null,
        job: null,
        recommended: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医生列表 */
    getList() {
      this.loading = true;
      listDoctor(this.queryParams).then(response => {
        this.doctorList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        pid: null,
        uuid: null,
        sex: null,
        photo: null,
        birthday: null,
        school: null,
        degree: null,
        tel: null,
        address: null,
        email: null,
        job: null,
        remark: null,
        description: null,
        hiredate: null,
        tag: null,
        recommended: null,
        status: null,
        createTime: null,
        createBy: null,
        updateTime: null,
        updateBy: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医生";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDoctor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改医生";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDoctor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDoctor(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除医生编号为"' + ids + '"的数据项？').then(function() {
        return delDoctor(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hospital/doctor/export', {
        ...this.queryParams
      }, `doctor_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
