import request from '@/utils/request'

// 查询患者信息卡列表
export function listCard(query) {
  return request({
    url: '/hospital/card/list',
    method: 'get',
    params: query
  })
}

// 查询患者信息卡详细
export function getCard(id) {
  return request({
    url: '/hospital/card/' + id,
    method: 'get'
  })
}

// 新增患者信息卡
export function addCard(data) {
  return request({
    url: '/hospital/card',
    method: 'post',
    data: data
  })
}

// 修改患者信息卡
export function updateCard(data) {
  return request({
    url: '/hospital/card',
    method: 'put',
    data: data
  })
}

// 删除患者信息卡
export function delCard(id) {
  return request({
    url: '/hospital/card/' + id,
    method: 'delete'
  })
}
