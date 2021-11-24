package kr.co.tjoeun.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class DetailVo {
	private int detailno;
	private String detailcontent, detailid;
	private Timestamp detailnalja;
	
	public DetailVo() {
	}
	
	public int getDetailno() {
		return detailno;
	}
	public void setDetailno(int detailno) {
		this.detailno = detailno;
	}
	public String getDetailcontent() {
		return detailcontent;
	}
	public void setDetailcontent(String detailcontent) {
		this.detailcontent = detailcontent;
	}
	public String getDetailid() {
		return detailid;
	}
	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}
	public Timestamp getDetailnalja() {
		return detailnalja;
	}
	public void setDetailnalja(Timestamp detailnalja) {
		this.detailnalja = detailnalja;
	}
	@Override
	public int hashCode() {
		return Objects.hash(detailcontent, detailid, detailnalja, detailno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailVo other = (DetailVo) obj;
		return Objects.equals(detailcontent, other.detailcontent) && Objects.equals(detailid, other.detailid)
				&& Objects.equals(detailnalja, other.detailnalja) && detailno == other.detailno;
	}
	public DetailVo(int detailno, String detailcontent, String detailid, Timestamp detailnalja) {
		super();
		this.detailno = detailno;
		this.detailcontent = detailcontent;
		this.detailid = detailid;
		this.detailnalja = detailnalja;
	}
	@Override
	public String toString() {
		return "DetailVo [detailno=" + detailno + ", detailcontent=" + detailcontent + ", detailid=" + detailid
				+ ", detailnalja=" + detailnalja + "]";
	}
}
