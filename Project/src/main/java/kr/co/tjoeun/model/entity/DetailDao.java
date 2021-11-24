package kr.co.tjoeun.model.entity;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DetailDao {

	@Select("select * from detail_table order by detailno")
	List<DetailVo> selectAll() throws SQLException;
	@Select("select * from detail_table where detailno=#{detailno}")
	DetailVo selectOne(int detailno) throws SQLException;
	@Insert("insert into detail_table (detailcontent,detailid) values (#{detailcontent},#{detailid})")
	void insertOne(DetailVo bean) throws SQLException;
	@Update("update detail_table set detailcontent=#{detailcontent} where detailno=#{detailno}")
	int updateOne(DetailVo bean) throws SQLException;
	@Delete("delete from detail_table where detailno=#{detailno}")
	int deleteOne(int detailno) throws SQLException;
}
