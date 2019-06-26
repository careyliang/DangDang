package com.gxy.entity;

import java.util.Date;

public class DangDangOrderDetail {

	private int detailId;//主键
	private String detailProductName;//图书名称
	private String detailSsid;//订单详情编号
	private int detailCount;//每本图书的数量
	private double detailDdprice;//每本图书的当当价
	private int ddProductId;//外键，图书
	private String orderSsid;//外键，订单
	private int addressId;//外键，地址
	private int ddUserId;//外键，用户
	private Date detailCreateDate;//时间戳
	public DangDangOrderDetail() {
		super();
	}
	@Override
	public String toString() {
		return "DangDangOrderDetail [detailId=" + detailId + ", detailSsid=" + detailSsid + ", detailCount="
				+ detailCount + ", detailDdprice=" + detailDdprice + ", ddProductId=" + ddProductId + ", orderSsid="
				+ orderSsid + ", addressId=" + addressId + ", ddUserId=" + ddUserId + ", detailCreateDate="
				+ detailCreateDate + "]";
	}
	
	public DangDangOrderDetail(int detailId, String detailProductName, String detailSsid, int detailCount,
			double detailDdprice, int ddProductId, String orderSsid, int addressId, int ddUserId,
			Date detailCreateDate) {
		super();
		this.detailId = detailId;
		this.detailProductName = detailProductName;
		this.detailSsid = detailSsid;
		this.detailCount = detailCount;
		this.detailDdprice = detailDdprice;
		this.ddProductId = ddProductId;
		this.orderSsid = orderSsid;
		this.addressId = addressId;
		this.ddUserId = ddUserId;
		this.detailCreateDate = detailCreateDate;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getDetailSsid() {
		return detailSsid;
	}
	public void setDetailSsid(String detailSsid) {
		this.detailSsid = detailSsid;
	}
	public int getDetailCount() {
		return detailCount;
	}
	public void setDetailCount(int detailCount) {
		this.detailCount = detailCount;
	}
	public double getDetailDdprice() {
		return detailDdprice;
	}
	public void setDetailDdprice(double detailDdprice) {
		this.detailDdprice = detailDdprice;
	}
	public int getDdProductId() {
		return ddProductId;
	}
	public void setDdProductId(int ddProductId) {
		this.ddProductId = ddProductId;
	}
	public String getOrderSsid() {
		return orderSsid;
	}
	public void setOrderSsid(String orderSsid) {
		this.orderSsid = orderSsid;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getDdUserId() {
		return ddUserId;
	}
	public void setDdUserId(int ddUserId) {
		this.ddUserId = ddUserId;
	}
	public Date getDetailCreateDate() {
		return detailCreateDate;
	}
	public void setDetailCreateDate(Date detailCreateDate) {
		this.detailCreateDate = detailCreateDate;
	}
	public String getDetailProductName() {
		return detailProductName;
	}
	public void setDetailProductName(String detailProductName) {
		this.detailProductName = detailProductName;
	}
	
}
