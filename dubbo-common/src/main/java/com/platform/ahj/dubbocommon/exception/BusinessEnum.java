package com.platform.ahj.dubbocommon.exception;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/14 15:41
 * @Since:
 */

public enum BusinessEnum {
    COMMON("00", "响应业务");
    private String business;
    private String businessName;

    private BusinessEnum() {
    }

    private BusinessEnum(String business, String businessName) {
        this.business = business;
        this.businessName = businessName;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}

