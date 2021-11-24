package kr.co.tjoeun.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CsDaoImpl implements CsDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	RowMapper<CsVo> rowMapper=new RowMapper<CsVo>() {
		
		@Override
		public CsVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CsVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5));
		}
	};
	@Override
	public List<CsVo> selectAll() throws SQLException {
		String sql="select * from cs_table";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public CsVo selectOne(int csno) throws SQLException {
		String sql="select * from cs_table where csno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, csno);
	}
	
	@Override
	public void insertOne(CsVo bean) throws SQLException {
		String sql="insert into cs_table (cssub,cscontent,csid) values (?,?,?)";
		jdbcTemplate.update(sql, bean.getCssub(), bean.getCscontent(), bean.getCsid());
	}
	
	@Override
	public int updateOne(int csno, String cssub, String cscontent) throws SQLException {
		String sql="update cs_table set cssub=?, cscontent=? where csno=?";
		return jdbcTemplate.update(sql, cssub, cscontent);
	}
	
	@Override
	public int deleteOne(int csno) throws SQLException {
		String sql="delete from cs_table where csno=?";
		return jdbcTemplate.update(sql, csno);
	}
}
