package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.MaintainRecord;
import cn.edu.cqu.CRM.Pojo.MaintainRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaintainRecordMapper {
	long countByExample(MaintainRecordExample example);

	int deleteByExample(MaintainRecordExample example);

	int deleteByPrimaryKey(Integer recordId);

	int insert(MaintainRecord record);

	int insertSelective(MaintainRecord record);

	List<MaintainRecord> selectByExample(MaintainRecordExample example);

	MaintainRecord selectByPrimaryKey(Integer recordId);

	int updateByExampleSelective(@Param("record") MaintainRecord record,
			@Param("example") MaintainRecordExample example);

	int updateByExample(@Param("record") MaintainRecord record, @Param("example") MaintainRecordExample example);

	int updateByPrimaryKeySelective(MaintainRecord record);

	int updateByPrimaryKey(MaintainRecord record);
}