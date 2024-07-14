import request from '@/utils/request'

// 查询诊室管理列表
export function listSub(query) {
  return request({
    url: '/hospital/sub/list',
    method: 'get',
    params: query
  })
}

// 查询诊室管理详细
export function getSub(id) {
  return request({
    url: '/hospital/sub/' + id,
    method: 'get'
  })
}

// 新增诊室管理
export function addSub(data) {
  return request({
    url: '/hospital/sub',
    method: 'post',
    data: data
  })
}

// 修改诊室管理
export function updateSub(data) {
  return request({
    url: '/hospital/sub',
    method: 'put',
    data: data
  })
}

// 删除诊室管理
export function delSub(id) {
  return request({
    url: '/hospital/sub/' + id,
    method: 'delete'
  })
}
