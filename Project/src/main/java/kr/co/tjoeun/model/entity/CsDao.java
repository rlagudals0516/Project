package kr.co.tjoeun.model.entity;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CsDao {
	
	@Select("select * from cs_table order by csno desc")
	List<CsVo> selectAll() throws SQLException;
	@Select("select * from cs_table where csno=#{csno}")
	CsVo selectOne(int csno) throws SQLException;
	@Insert("insert into cs_table (cssub,cscontent,csid) values (#{cssub},#{cscontent},#{csid})")
	void insertOne(CsVo bean) throws SQLException;
	@Update("update cs_table set cssub=#{cssub}, cscontent=#{cscontent} where csno=#{csno}")
	int updateOne(int csno, String cssub, String cscontent) throws SQLException;
	@Delete("delete from cs_table where csno=#{csno}")
	int deleteOne(int csno) throws SQLException;
}
