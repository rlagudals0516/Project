package kr.co.tjoeun.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DetailDaoImpl implements DetailDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<DetailVo> rowMapper=new RowMapper<DetailVo>() {
		
		@Override
		public DetailVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new DetailVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
		}
	};
	
	@Override
	public List<DetailVo> selectAll() throws SQLException {
		String sql="select * from detail_table";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void insertOne(DetailVo bean) throws SQLException {
		String sql="insert into detail_table (detailcontent,detailid) values (?,?)";
		jdbcTemplate.update(sql, bean.getDetailcontent(), bean.getDetailid());
	}

	@Override
	public int updateOne(DetailVo bean) throws SQLException {
		String sql="update detail_table set detailcontent=? where detailno=?";
		return jdbcTemplate.update(sql, bean.getDetailcontent(), bean.getDetailno());
	}

	@Override
	public int deleteOne(int detailno) throws SQLException {
		String sql="delete from detail_table where detailno=?";
		return jdbcTemplate.update(sql, detailno);
	}

	@Override
	public DetailVo selectOne(int detailno) throws SQLException {
		String sql="select * from detail_table where detailno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, detailno);
	}
}
