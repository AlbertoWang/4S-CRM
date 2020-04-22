package cn.edu.cqu.CRM.Pojo;

public class EmployeeInfo {
    private Integer employeeId;

    private String employeeName;

    private String userTypeName;

    private String permissionName;

    private Long employeeTel;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName == null ? null : userTypeName.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public Long getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(Long employeeTel) {
        this.employeeTel = employeeTel;
    }
}