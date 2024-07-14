import request from '@/utils/request'

// 查询职位管理列表
export function listJob(query) {
  return request({
    url: '/hospital/job/list',
    method: 'get',
    params: query
  })
}

// 查询职位管理详细
export function getJob(id) {
  return request({
    url: '/hospital/job/' + id,
    method: 'get'
  })
}

// 新增职位管理
export function addJob(data) {
  return request({
    url: '/hospital/job',
    method: 'post',
    data: data
  })
}

// 修改职位管理
export function updateJob(data) {
  return request({
    url: '/hospital/job',
    method: 'put',
    data: data
  })
}

// 删除职位管理
export function delJob(id) {
  return request({
    url: '/hospital/job/' + id,
    method: 'delete'
  })
}
