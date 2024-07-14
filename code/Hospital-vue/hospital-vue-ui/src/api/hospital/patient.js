import request from '@/utils/request'

// 查询患者小程序账号列表
export function listPatient(query) {
  return request({
    url: '/hospital/patient/list',
    method: 'get',
    params: query
  })
}

// 查询患者小程序账号详细
export function getPatient(id) {
  return request({
    url: '/hospital/patient/' + id,
    method: 'get'
  })
}

// 新增患者小程序账号
export function addPatient(data) {
  return request({
    url: '/hospital/patient',
    method: 'post',
    data: data
  })
}

// 修改患者小程序账号
export function updatePatient(data) {
  return request({
    url: '/hospital/patient',
    method: 'put',
    data: data
  })
}

// 删除患者小程序账号
export function delPatient(id) {
  return request({
    url: '/hospital/patient/' + id,
    method: 'delete'
  })
}
