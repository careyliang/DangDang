package com.gxy.entity;

import java.util.List;

public class DangDangCategory1 {

	private int ddCategory1Id;
	private String ddCategory1Name;
	private String ddCategory1CreateDate;
	private int ddCategory1Count;
	private List<DangDangCategory2> listCategory2;
	
	public DangDangCategory1() {
		super();
	}

	public DangDangCategory1(int ddCategory1Id, String ddCategory1Name, String ddCategory1CreateDate,
			int ddCategory1Count, List<DangDangCategory2> listCategory2) {
		super();
		this.ddCategory1Id = ddCategory1Id;
		this.ddCategory1Name = ddCategory1Name;
		this.ddCategory1CreateDate = ddCategory1CreateDate;
		this.ddCategory1Count = ddCategory1Count;
		this.listCategory2 = listCategory2;
	}

	@Override
	public String toString() {
		return "DangDangCategory1 [ddCategory1Id=" + ddCategory1Id + ", ddCategory1Name=" + ddCategory1Name
				+ ", ddCategory1CreateDate=" + ddCategory1CreateDate + ", ddCategory1Count=" + ddCategory1Count
				+ ", listCategory2=" + listCategory2 + "]";
	}

	public int getDdCategory1Id() {
		return ddCategory1Id;
	}

	public void setDdCategory1Id(int ddCategory1Id) {
		this.ddCategory1Id = ddCategory1Id;
	}

	public String getDdCategory1Name() {
		return ddCategory1Name;
	}

	public void setDdCategory1Name(String ddCategory1Name) {
		this.ddCategory1Name = ddCategory1Name;
	}

	public String getDdCategory1CreateDate() {
		return ddCategory1CreateDate;
	}

	public void setDdCategory1CreateDate(String ddCategory1CreateDate) {
		this.ddCategory1CreateDate = ddCategory1CreateDate;
	}

	public int getDdCategory1Count() {
		return ddCategory1Count;
	}

	public void setDdCategory1Count(int ddCategory1Count) {
		this.ddCategory1Count = ddCategory1Count;
	}

	public List<DangDangCategory2> getListCategory2() {
		return listCategory2;
	}

	public void setListCategory2(List<DangDangCategory2> listCategory2) {
		this.listCategory2 = listCategory2;
	}
	
}
