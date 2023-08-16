package com.platform.ahj.dubbocommon.entity;

import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用于集合验证，验证集合对象中的每一个元素
 * @Author: wwl
 * @Created on: 2023/8/15-14:04
 * @Since:
 */
public class ValidationList<E> implements List<E> {

    @Delegate // @Delegate是lombok注解
    @Valid // 一定要加@Valid注解
    public List<E> list = new ArrayList<>();

    // 一定要记得重写toString方法
    @Override
    public String toString() {
        return list.toString();
    }
}
