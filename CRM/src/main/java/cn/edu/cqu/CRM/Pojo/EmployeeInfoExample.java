package cn.edu.cqu.CRM.Pojo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNull() {
            addCriterion("employee_name is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIsNotNull() {
            addCriterion("employee_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameEqualTo(String value) {
            addCriterion("employee_name =", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotEqualTo(String value) {
            addCriterion("employee_name <>", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThan(String value) {
            addCriterion("employee_name >", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("employee_name >=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThan(String value) {
            addCriterion("employee_name <", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLessThanOrEqualTo(String value) {
            addCriterion("employee_name <=", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameLike(String value) {
            addCriterion("employee_name like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotLike(String value) {
            addCriterion("employee_name not like", value, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameIn(List<String> values) {
            addCriterion("employee_name in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotIn(List<String> values) {
            addCriterion("employee_name not in", values, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameBetween(String value1, String value2) {
            addCriterion("employee_name between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andEmployeeNameNotBetween(String value1, String value2) {
            addCriterion("employee_name not between", value1, value2, "employeeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIsNull() {
            addCriterion("user_type_id is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIsNotNull() {
            addCriterion("user_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdEqualTo(Integer value) {
            addCriterion("user_type_id =", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotEqualTo(Integer value) {
            addCriterion("user_type_id <>", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThan(Integer value) {
            addCriterion("user_type_id >", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type_id >=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThan(Integer value) {
            addCriterion("user_type_id <", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_type_id <=", value, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdIn(List<Integer> values) {
            addCriterion("user_type_id in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotIn(List<Integer> values) {
            addCriterion("user_type_id not in", values, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("user_type_id between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type_id not between", value1, value2, "userTypeId");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNull() {
            addCriterion("user_type_name is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIsNotNull() {
            addCriterion("user_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameEqualTo(String value) {
            addCriterion("user_type_name =", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotEqualTo(String value) {
            addCriterion("user_type_name <>", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThan(String value) {
            addCriterion("user_type_name >", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_type_name >=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThan(String value) {
            addCriterion("user_type_name <", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLessThanOrEqualTo(String value) {
            addCriterion("user_type_name <=", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameLike(String value) {
            addCriterion("user_type_name like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotLike(String value) {
            addCriterion("user_type_name not like", value, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameIn(List<String> values) {
            addCriterion("user_type_name in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotIn(List<String> values) {
            addCriterion("user_type_name not in", values, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameBetween(String value1, String value2) {
            addCriterion("user_type_name between", value1, value2, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andUserTypeNameNotBetween(String value1, String value2) {
            addCriterion("user_type_name not between", value1, value2, "userTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Integer value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("permission_name =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("permission_name <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("permission_name like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("permission_name not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("permission_name in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelIsNull() {
            addCriterion("employee_tel is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelIsNotNull() {
            addCriterion("employee_tel is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelEqualTo(Long value) {
            addCriterion("employee_tel =", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelNotEqualTo(Long value) {
            addCriterion("employee_tel <>", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelGreaterThan(Long value) {
            addCriterion("employee_tel >", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelGreaterThanOrEqualTo(Long value) {
            addCriterion("employee_tel >=", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelLessThan(Long value) {
            addCriterion("employee_tel <", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelLessThanOrEqualTo(Long value) {
            addCriterion("employee_tel <=", value, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelIn(List<Long> values) {
            addCriterion("employee_tel in", values, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelNotIn(List<Long> values) {
            addCriterion("employee_tel not in", values, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelBetween(Long value1, Long value2) {
            addCriterion("employee_tel between", value1, value2, "employeeTel");
            return (Criteria) this;
        }

        public Criteria andEmployeeTelNotBetween(Long value1, Long value2) {
            addCriterion("employee_tel not between", value1, value2, "employeeTel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}