import request from '@/utils/request'

// 查询科室管理列表
export function listDept(query) {
  return request({
    url: '/hospital/dept/list',
    method: 'get',
    params: query
  })
}

// 查询科室管理详细
export function getDept(id) {
  return request({
    url: '/hospital/dept/' + id,
    method: 'get'
  })
}

// 新增科室管理
export function addDept(data) {
  return request({
    url: '/hospital/dept',
    method: 'post',
    data: data
  })
}

// 修改科室管理
export function updateDept(data) {
  return request({
    url: '/hospital/dept',
    method: 'put',
    data: data
  })
}

// 删除科室管理
export function delDept(id) {
  return request({
    url: '/hospital/dept/' + id,
    method: 'delete'
  })
}
