package com.LtAo.common.core.domain.model;


import lombok.Data;

@Data
public class MiniLoginBody extends LoginBody {
    /*wx登录code*/
    private String code;

    /*昵称*/
    private String nickname;

    /*头像*/
    private String photo;

    /*性别*/
    private String sex;

}
