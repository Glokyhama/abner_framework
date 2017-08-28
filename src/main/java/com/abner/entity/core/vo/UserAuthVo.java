package com.abner.entity.core.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthVo {


    private Long id;

    // 用户id
    private String uid;

    private Integer identityType;

    //手机号 邮箱 用户名或第三方应用的唯一标识
    private String identifier;

    //密码凭证(站内的保存密码，站外的不保存或保存token)
    private String certificate;

    //绑定时间
    private Integer createTime;

    //更新绑定时间
    private Integer updateTime;
}
