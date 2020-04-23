package cn.edu.cqu.CRM.Pojo;

import java.util.Date;

public class RepairRecord {
    private Integer recordId;

    private Integer customerId;

    private Integer employeeId;

    private String employeeAccount;

    private String recordItem;

    private Date recordTime;

    private String carType;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount == null ? null : employeeAccount.trim();
    }

    public String getRecordItem() {
        return recordItem;
    }

    public void setRecordItem(String recordItem) {
        this.recordItem = recordItem == null ? null : recordItem.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }
}