package cn.edu.cqu.CRM.Dao;

import cn.edu.cqu.CRM.Pojo.BuyRecord;
import cn.edu.cqu.CRM.Pojo.BuyRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuyRecordMapper {
	long countByExample(BuyRecordExample example);

	int deleteByExample(BuyRecordExample example);

	int deleteByPrimaryKey(Integer recordId);

	int insert(BuyRecord record);

	int insertSelective(BuyRecord record);

	List<BuyRecord> selectByExample(BuyRecordExample example);

	BuyRecord selectByPrimaryKey(Integer recordId);

	int updateByExampleSelective(@Param("record") BuyRecord record, @Param("example") BuyRecordExample example);

	int updateByExample(@Param("record") BuyRecord record, @Param("example") BuyRecordExample example);

	int updateByPrimaryKeySelective(BuyRecord record);

	int updateByPrimaryKey(BuyRecord record);
}