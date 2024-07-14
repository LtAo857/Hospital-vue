import request from '@/utils/request'

// 查询健康科普列表
export function listKnowledge(query) {
  return request({
    url: '/hospital/knowledge/list',
    method: 'get',
    params: query
  })
}

// 查询健康科普详细
export function getKnowledge(id) {
  return request({
    url: '/hospital/knowledge/' + id,
    method: 'get'
  })
}

// 新增健康科普
export function addKnowledge(data) {
  return request({
    url: '/hospital/knowledge',
    method: 'post',
    data: data
  })
}

// 修改健康科普
export function updateKnowledge(data) {
  return request({
    url: '/hospital/knowledge',
    method: 'put',
    data: data
  })
}

// 删除健康科普
export function delKnowledge(id) {
  return request({
    url: '/hospital/knowledge/' + id,
    method: 'delete'
  })
}
