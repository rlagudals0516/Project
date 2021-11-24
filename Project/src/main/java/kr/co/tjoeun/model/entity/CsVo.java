package kr.co.tjoeun.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class CsVo {
	private int csno;
	private String cssub, cscontent, csid;
	private Timestamp csnalja;
	
	public CsVo() {
	}

	public int getCsno() {
		return csno;
	}

	public void setCsno(int csno) {
		this.csno = csno;
	}

	public String getCssub() {
		return cssub;
	}

	public void setCssub(String cssub) {
		this.cssub = cssub;
	}

	public String getCscontent() {
		return cscontent;
	}

	public void setCscontent(String cscontent) {
		this.cscontent = cscontent;
	}

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public Timestamp getCsnalja() {
		return csnalja;
	}

	public void setCsnalja(Timestamp csnalja) {
		this.csnalja = csnalja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cscontent, csid, csnalja, csno, cssub);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CsVo other = (CsVo) obj;
		return Objects.equals(cscontent, other.cscontent) && Objects.equals(csid, other.csid)
				&& Objects.equals(csnalja, other.csnalja) && csno == other.csno && Objects.equals(cssub, other.cssub);
	}

	public CsVo(int csno, String cssub, String cscontent, String csid, Timestamp csnalja) {
		super();
		this.csno = csno;
		this.cssub = cssub;
		this.cscontent = cscontent;
		this.csid = csid;
		this.csnalja = csnalja;
	}

	@Override
	public String toString() {
		return "CsVo [csno=" + csno + ", cssub=" + cssub + ", cscontent=" + cscontent + ", csid=" + csid + ", csnalja="
				+ csnalja + "]";
	}
}
