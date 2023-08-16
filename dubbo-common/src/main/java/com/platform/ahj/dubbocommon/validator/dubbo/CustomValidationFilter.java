package com.platform.ahj.dubbocommon.validator.dubbo;

import com.alibaba.dubbo.rpc.RpcException;
import com.platform.ahj.dubbocommon.entity.CommonResult;
import com.platform.ahj.dubbocommon.exception.BusinessEnum;
import com.platform.ahj.dubbocommon.exception.NotifyCode;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.common.utils.ConfigUtils;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.validation.Validation;
import org.apache.dubbo.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import java.util.Set;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;
import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;
import static org.apache.dubbo.common.constants.FilterConstants.VALIDATION_KEY;

/**
 * @Description: 自定义Dubbo的Filter   用于解决ConstraintViolationException异常无法反序列化的问题
 * @Author: ZiYu
 * @Created on: 2023/08/15 15:57
 * @Since:
 */
@Activate(group = {CONSUMER, PROVIDER}, value = "customValidationFilter", order = 10000)
public class CustomValidationFilter implements Filter {

    private Validation validation;

    public void setValidation(Validation validation) { this.validation = validation; }

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (validation != null && !invocation.getMethodName().startsWith("$")
                && ConfigUtils.isNotEmpty(invoker.getUrl().getMethodParameter(invocation.getMethodName(), VALIDATION_KEY))) {
            try {
                Validator validator = validation.getValidator(invoker.getUrl());
                if (validator != null) {
                    validator.validate(invocation.getMethodName(), invocation.getParameterTypes(), invocation.getArguments());
                }
            } catch (RpcException e) {
                throw e;
            } catch (ConstraintViolationException e) {
                // 与Dubbo默认的filter不同 这边细化了异常类型的处理
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                if (CollectionUtils.isNotEmpty(violations)) {
                    ConstraintViolation<?> violation = violations.iterator().next();
                    // 取第一个进行提示,并封装进统一的Result
                    CommonResult facadeResult = CommonResult.fail(Integer.parseInt(NotifyCode.INVALID_PARAM.getCode()), violation.getMessage());
                    return AsyncRpcResult.newDefaultAsyncResult(facadeResult, invocation);
                }
                return AsyncRpcResult.newDefaultAsyncResult(new ValidationException(e.getMessage()), invocation);
            } catch (Throwable t) {
                return AsyncRpcResult.newDefaultAsyncResult(t, invocation);
            }
        }
        return invoker.invoke(invocation);
    }
}


