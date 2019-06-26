package com.gxy.entity;

import java.util.Date;

public class DangDangAddress {

	private int addressId;//主键
	private String addressReceiveName;//收件人
	private String addressAdd;//收件地址
	private String addressMobile;//收件人电话
	private String addressZipcode;//邮政编码
	private int addressState;//地址状态
	private int ddUserId;//外键，用户
	private Date addressCreateDate;//时间戳
	public DangDangAddress() {
		super();
	}
	public DangDangAddress(int addressId, String addressReceiveName, String addressAdd, String addressMobile,
			String addressZipcode, int addressState, int ddUserId, Date addressCreateDate) {
		super();
		this.addressId = addressId;
		this.addressReceiveName = addressReceiveName;
		this.addressAdd = addressAdd;
		this.addressMobile = addressMobile;
		this.addressZipcode = addressZipcode;
		this.addressState = addressState;
		this.ddUserId = ddUserId;
		this.addressCreateDate = addressCreateDate;
	}
	@Override
	public String toString() {
		return "DangDangAddress [addressId=" + addressId + ", addressReceiveName=" + addressReceiveName
				+ ", addressAdd=" + addressAdd + ", addressMobile=" + addressMobile + ", addressZipcode="
				+ addressZipcode + ", addressState=" + addressState + ", ddUserId=" + ddUserId + ", addressCreateDate="
				+ addressCreateDate + "]";
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressReceiveName() {
		return addressReceiveName;
	}
	public void setAddressReceiveName(String addressReceiveName) {
		this.addressReceiveName = addressReceiveName;
	}
	public String getAddressAdd() {
		return addressAdd;
	}
	public void setAddressAdd(String addressAdd) {
		this.addressAdd = addressAdd;
	}
	public String getAddressMobile() {
		return addressMobile;
	}
	public void setAddressMobile(String addressMobile) {
		this.addressMobile = addressMobile;
	}
	public String getAddressZipcode() {
		return addressZipcode;
	}
	public void setAddressZipcode(String addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public int getAddressState() {
		return addressState;
	}
	public void setAddressState(int addressState) {
		this.addressState = addressState;
	}
	public int getDdUserId() {
		return ddUserId;
	}
	public void setDdUserId(int ddUserId) {
		this.ddUserId = ddUserId;
	}
	public Date getAddressCreateDate() {
		return addressCreateDate;
	}
	public void setAddressCreateDate(Date addressCreateDate) {
		this.addressCreateDate = addressCreateDate;
	}
	
}
