package com.zwc.jpa;


public class CrmUser {
    private static final long serialVersionUID = 1L;
        private String id; // 默认数据ROW_ID
        private String ctime; // 创建时间
        private String createdBy; // 创建者
        private String utime; // 更新时间
        private String lastUpdatedBy; // 更新者
        private Integer versionNum; // 版本号
    private String code; // 用户编号
    private String name; // 用户名称
    private String phone; // 手机号
    private String password; // 密码
    private String organizationId; // 组织id
    private Integer isInvalid; // 是否失效 0 有效 1 失效
    private Integer isDeleted; // 是否删除 0正常  1删除

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(Integer isInvalid) {
        this.isInvalid = isInvalid;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}