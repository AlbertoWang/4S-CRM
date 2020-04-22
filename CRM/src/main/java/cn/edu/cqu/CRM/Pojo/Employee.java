package cn.edu.cqu.CRM.Pojo;

public class Employee extends EmployeeKey {
    private Integer permissionId;

    private Integer userTypeId;

    private String employeePassword;

    private String employeeName;

    private Long employeeTel;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword == null ? null : employeePassword.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Long getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(Long employeeTel) {
        this.employeeTel = employeeTel;
    }
}