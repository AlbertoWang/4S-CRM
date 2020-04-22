package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.EmployeeInfo;
import cn.edu.cqu.CRM.Pojo.EmployeeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeInfoMapper {
    long countByExample(EmployeeInfoExample example);

    int deleteByExample(EmployeeInfoExample example);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);

    List<EmployeeInfo> selectByExample(EmployeeInfoExample example);

    int updateByExampleSelective(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByExample(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);
}