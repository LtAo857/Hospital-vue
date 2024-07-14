import request from '@/utils/request'

// 查询学位列表
export function listDegree(query) {
  return request({
    url: '/hospital/degree/list',
    method: 'get',
    params: query
  })
}

// 查询学位详细
export function getDegree(id) {
  return request({
    url: '/hospital/degree/' + id,
    method: 'get'
  })
}

// 新增学位

export function addDegree(data) {
  return request({
    url: '/hospital/degree',
    method: 'post',
    data: data
  })
}

// 修改学位

export function updateDegree(data) {
  return request({
    url: '/hospital/degree',
    method: 'put',
    data: data
  })
}

// 删除学位

export function delDegree(id) {
  return request({
    url: '/hospital/degree/' + id,
    method: 'delete'
  })
}
