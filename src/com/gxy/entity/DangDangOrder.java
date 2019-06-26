package com.gxy.entity;

import java.util.Date;

public class DangDangOrder {

	private int orderId;//主键
	private String orderSsid;//订单编号
	private double orderTotalprice;//该订单商品总价
  	private int orderState;//订单状态
	private int ddUserId;//外键，用户
	private Date orderCreatedate;//时间戳
	
	public DangDangOrder(int orderId, String orderSsid, double orderTotalprice, int orderState, int ddUserId,
			Date orderCreatedate) {
		super();
		this.orderId = orderId;
		this.orderSsid = orderSsid;
		this.orderTotalprice = orderTotalprice;
		this.orderState = orderState;
		this.ddUserId = ddUserId;
		this.orderCreatedate = orderCreatedate;
	}
	public DangDangOrder() {
		super();
	}
	@Override
	public String toString() {
		return "DANGDANG_ORDER [orderId=" + orderId + ", orderSsid=" + orderSsid + ", orderTotalprice="
				+ orderTotalprice + ", orderState=" + orderState + ", ddUserId=" + ddUserId + ", orderCreatedate="
				+ orderCreatedate + "]";
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderSsid() {
		return orderSsid;
	}
	public void setOrderSsid(String orderSsid) {
		this.orderSsid = orderSsid;
	}
	public double getOrderTotalprice() {
		return orderTotalprice;
	}
	public void setOrderTotalprice(double orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getDdUserId() {
		return ddUserId;
	}
	public void setDdUserId(int ddUserId) {
		this.ddUserId = ddUserId;
	}
	public Date getOrderCreatedate() {
		return orderCreatedate;
	}
	public void setOrderCreatedate(Date orderCreatedate) {
		this.orderCreatedate = orderCreatedate;
	}
	
}
