package com.ikpb.domain;

import java.sql.Date;

public class ApprovedForm {
	private int approvedId;
	private int approvedBy;
	private Date dateApproved;
	private int formId;
	public int getApprovedId() {
		return approvedId;
	}
	public void setApprovedId(int approvedId) {
		this.approvedId = approvedId;
	}
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approvedBy;
		result = prime * result + approvedId;
		result = prime * result + ((dateApproved == null) ? 0 : dateApproved.hashCode());
		result = prime * result + formId;
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
		ApprovedForm other = (ApprovedForm) obj;
		if (approvedBy != other.approvedBy)
			return false;
		if (approvedId != other.approvedId)
			return false;
		if (dateApproved == null) {
			if (other.dateApproved != null)
				return false;
		} else if (!dateApproved.equals(other.dateApproved))
			return false;
		if (formId != other.formId)
			return false;
		return true;
	}
	public ApprovedForm(int approvedId, int approvedBy, Date dateApproved, int formId) {
		super();
		this.approvedId = approvedId;
		this.approvedBy = approvedBy;
		this.dateApproved = dateApproved;
		this.formId = formId;
	}
	public ApprovedForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
