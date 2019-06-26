package com.gxy.entity;

public class DangDangUser {

	private int ddUserId;
	private String ddUserEmail;
	private String ddUserPassword;
	private String ddUserNickName;
	private int ddUserState;
	private String ddUserSalt;
	private String ddUserRole;
	private String ddUserCreateDate;
	public DangDangUser() {
		super();
	}
	public DangDangUser(int ddUserId, String ddUserEmail, String ddUserPassword, String ddUserNickName, int ddUserState,
			String ddUserSalt, String ddUserRole, String ddUserCreateDate) {
		super();
		this.ddUserId = ddUserId;
		this.ddUserEmail = ddUserEmail;
		this.ddUserPassword = ddUserPassword;
		this.ddUserNickName = ddUserNickName;
		this.ddUserState = ddUserState;
		this.ddUserSalt = ddUserSalt;
		this.ddUserRole = ddUserRole;
		this.ddUserCreateDate = ddUserCreateDate;
	}
	@Override
	public String toString() {
		return "DangDangUser [ddUserId=" + ddUserId + ", ddUserEmail=" + ddUserEmail + ", ddUserPassword="
				+ ddUserPassword + ", ddUserNickName=" + ddUserNickName + ", ddUserState=" + ddUserState
				+ ", ddUserSalt=" + ddUserSalt + ", ddUserRole=" + ddUserRole + ", ddUserCreateDate=" + ddUserCreateDate
				+ "]";
	}
	public int getDdUserId() {
		return ddUserId;
	}
	public void setDdUserId(int ddUserId) {
		this.ddUserId = ddUserId;
	}
	public String getDdUserEmail() {
		return ddUserEmail;
	}
	public void setDdUserEmail(String ddUserEmail) {
		this.ddUserEmail = ddUserEmail;
	}
	public String getDdUserPassword() {
		return ddUserPassword;
	}
	public void setDdUserPassword(String ddUserPassword) {
		this.ddUserPassword = ddUserPassword;
	}
	public String getDdUserNickName() {
		return ddUserNickName;
	}
	public void setDdUserNickName(String ddUserNickName) {
		this.ddUserNickName = ddUserNickName;
	}
	public int getDdUserState() {
		return ddUserState;
	}
	public void setDdUserState(int ddUserState) {
		this.ddUserState = ddUserState;
	}
	public String getDdUserSalt() {
		return ddUserSalt;
	}
	public void setDdUserSalt(String ddUserSalt) {
		this.ddUserSalt = ddUserSalt;
	}
	public String getDdUserRole() {
		return ddUserRole;
	}
	public void setDdUserRole(String ddUserRole) {
		this.ddUserRole = ddUserRole;
	}
	public String getDdUserCreateDate() {
		return ddUserCreateDate;
	}
	public void setDdUserCreateDate(String ddUserCreateDate) {
		this.ddUserCreateDate = ddUserCreateDate;
	}
	
}