package cn.edu.cqu.CRM.Pojo;

public class EmployeeKey {
    private Integer employeeId;

    private String employeeAccount;

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
}