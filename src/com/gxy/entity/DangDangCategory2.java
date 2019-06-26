package com.gxy.entity;

public class DangDangCategory2 {

	private int ddCategory2Id;
	private String ddCategory2Name;
	private int ddCategory1Id;
	private String ddCategory2CreateDate;
	private int ddCategory2Count;
	
	public DangDangCategory2() {
		super();
	}

	public DangDangCategory2(int ddCategory2Id, String ddCategory2Name, int ddCategory1Id, String ddCategory2CreateDate,
			int ddCategory2Count) {
		super();
		this.ddCategory2Id = ddCategory2Id;
		this.ddCategory2Name = ddCategory2Name;
		this.ddCategory1Id = ddCategory1Id;
		this.ddCategory2CreateDate = ddCategory2CreateDate;
		this.ddCategory2Count = ddCategory2Count;
	}

	@Override
	public String toString() {
		return "DangDangCategory2 [ddCategory2Id=" + ddCategory2Id + ", ddCategory2Name=" + ddCategory2Name
				+ ", ddCategory1Id=" + ddCategory1Id + ", ddCategory2CreateDate=" + ddCategory2CreateDate
				+ ", ddCategory2Count=" + ddCategory2Count + "]";
	}

	public int getDdCategory2Id() {
		return ddCategory2Id;
	}

	public void setDdCategory2Id(int ddCategory2Id) {
		this.ddCategory2Id = ddCategory2Id;
	}

	public String getDdCategory2Name() {
		return ddCategory2Name;
	}

	public void setDdCategory2Name(String ddCategory2Name) {
		this.ddCategory2Name = ddCategory2Name;
	}

	public int getDdCategory1Id() {
		return ddCategory1Id;
	}

	public void setDdCategory1Id(int ddCategory1Id) {
		this.ddCategory1Id = ddCategory1Id;
	}

	public String getDdCategory2CreateDate() {
		return ddCategory2CreateDate;
	}

	public void setDdCategory2CreateDate(String ddCategory2CreateDate) {
		this.ddCategory2CreateDate = ddCategory2CreateDate;
	}

	public int getDdCategory2Count() {
		return ddCategory2Count;
	}

	public void setDdCategory2Count(int ddCategory2Count) {
		this.ddCategory2Count = ddCategory2Count;
	}
	
	
	
}
