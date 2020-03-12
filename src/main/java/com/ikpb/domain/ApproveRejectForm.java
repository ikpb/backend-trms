package com.ikpb.domain;

import java.sql.Timestamp;

public class ApproveRejectForm {
private int appid;
private int formid;
private int approvedby;
private Timestamp timeAppReject;
private boolean rejected;
private int rejectedby;
private String infoNeeded;

public int getAppid() {
	return appid;
}
public void setAppid(int appid) {
	this.appid = appid;
}
public int getFormid() {
	return formid;
}
public void setFormid(int formid) {
	this.formid = formid;
}
public int getApprovedby() {
	return approvedby;
}
public void setApprovedby(int approvedby) {
	this.approvedby = approvedby;
}
public boolean isRejected() {
	return rejected;
}
public void setRejected(boolean rejected) {
	this.rejected = rejected;
}
public String getInfoNeeded() {
	return infoNeeded;
}
public void setInfoNeeded(String infoNeeded) {
	this.infoNeeded = infoNeeded;
}

public Timestamp getTimeAppReject() {
	return timeAppReject;
}
public void setTimeAppReject(Timestamp timeAppReject) {
	this.timeAppReject = timeAppReject;
}
public int getRejectedby() {
	return rejectedby;
}
public void setRejectedby(int rejectedby) {
	this.rejectedby = rejectedby;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + appid;
	result = prime * result + approvedby;
	result = prime * result + formid;
	result = prime * result + ((infoNeeded == null) ? 0 : infoNeeded.hashCode());
	result = prime * result + (rejected ? 1231 : 1237);
	
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ApproveRejectForm other = (ApproveRejectForm) obj;
	if (appid != other.appid)
		return false;
	if (approvedby != other.approvedby)
		return false;
	if (formid != other.formid)
		return false;
	if (infoNeeded == null) {
		if (other.infoNeeded != null)
			return false;
	} else if (!infoNeeded.equals(other.infoNeeded))
		return false;
	if (rejected != other.rejected)
		return false;
	return true;
}


@Override
public String toString() {
	return "ApproveRejectForm [appid=" + appid + ", formid=" + formid + ", approvedby=" + approvedby
			+ ", timeAppReject=" + timeAppReject + ", rejected=" + rejected + ", rejectedby=" + rejectedby
			+ ", infoNeeded=" + infoNeeded + "]";
}

public ApproveRejectForm(int appid, int formid, int approvedby, Timestamp timeAppReject, boolean rejected,
		int rejectedby, String infoNeeded) {
	super();
	this.appid = appid;
	this.formid = formid;
	this.approvedby = approvedby;
	this.timeAppReject = timeAppReject;
	this.rejected = rejected;
	this.rejectedby = rejectedby;
	this.infoNeeded = infoNeeded;
}
public ApproveRejectForm() {
	super();
	// TODO Auto-generated constructor stub
}


}
