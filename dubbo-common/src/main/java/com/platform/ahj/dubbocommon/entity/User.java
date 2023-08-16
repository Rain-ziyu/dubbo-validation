package com.platform.ahj.dubbocommon.entity;


import com.platform.ahj.dubbocommon.anno.Phone;
import com.platform.ahj.dubbocommon.service.UserService;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @Description: 用户
 * @Author: ZiYu
 * @Created on: 2023/08/08 16:08
 * @Since:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 7158903718568000392L;
    // 仅GetUser方法验证
    @NotNull(groups = UserService.GetUser.class)
    private String name;
    // UserService内的方法都验证
    @NotNull(groups = UserService.class)
    private String password;
    // 仅VerifyUserPhoneNumber方法验证
    @Phone(groups = UserService.VerifyUserPhoneNumber.class)
    private String phone;
}
