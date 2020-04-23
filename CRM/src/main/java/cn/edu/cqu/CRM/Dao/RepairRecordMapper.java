package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.RepairRecord;
import cn.edu.cqu.CRM.Pojo.RepairRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RepairRecordMapper {
	long countByExample(RepairRecordExample example);

	int deleteByExample(RepairRecordExample example);

	int deleteByPrimaryKey(Integer recordId);

	int insert(RepairRecord record);

	int insertSelective(RepairRecord record);

	List<RepairRecord> selectByExample(RepairRecordExample example);

	RepairRecord selectByPrimaryKey(Integer recordId);

	int updateByExampleSelective(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

	int updateByExample(@Param("record") RepairRecord record, @Param("example") RepairRecordExample example);

	int updateByPrimaryKeySelective(RepairRecord record);

	int updateByPrimaryKey(RepairRecord record);
}