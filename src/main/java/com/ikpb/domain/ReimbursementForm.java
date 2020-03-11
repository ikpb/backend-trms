package com.ikpb.domain;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;


public class ReimbursementForm {
   
		

	
	private int id;

	private String userid;
	
	private Timestamp dateOfEvent;
	
	
	private String address;
	
	private String city;
	
	private String state;
	
	private int cost;
	
	private Double estimateReimburse;
	
	private String gradeFormat;
	
	private String typeOfEvent;
	
	private String workJustification;
	
	private Date submissionDate;
	
	private boolean isUrgent;
	
	private String description;
	
	private Date endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getDateOfEvent() {
		return dateOfEvent;
	}

	public void setDateOfEvent(Timestamp dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public double getEstimateReimburse() {
		return estimateReimburse;
	}

	public void setEstimateReimburse(double estimateReimburse) {
		this.estimateReimburse = estimateReimburse;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getTypeOfEvent() {
		return typeOfEvent;
	}

	public void setTypeOfEvent(String typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}

	public String getWorkJustification() {
		return workJustification;
	}

	public void setWorkJustification(String workJustification) {
		this.workJustification = workJustification;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + cost;
		result = prime * result + ((dateOfEvent == null) ? 0 : dateOfEvent.hashCode());
		result = prime * result + ((gradeFormat == null) ? 0 : gradeFormat.hashCode());
		result = prime * result + id;
		result = prime * result + (isUrgent ? 1231 : 1237);

		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
	
		result = prime * result + ((typeOfEvent == null) ? 0 : typeOfEvent.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((workJustification == null) ? 0 : workJustification.hashCode());
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
		ReimbursementForm other = (ReimbursementForm) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cost != other.cost)
			return false;
		if (dateOfEvent == null) {
			if (other.dateOfEvent != null)
				return false;
		} else if (!dateOfEvent.equals(other.dateOfEvent))
			return false;
		if (estimateReimburse != other.estimateReimburse)
			return false;
		if (gradeFormat == null) {
			if (other.gradeFormat != null)
				return false;
		} else if (!gradeFormat.equals(other.gradeFormat))
			return false;
		if (id != other.id)
			return false;
		if (isUrgent != other.isUrgent)
			return false;

		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;

		if (typeOfEvent == null) {
			if (other.typeOfEvent != null)
				return false;
		} else if (!typeOfEvent.equals(other.typeOfEvent))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (workJustification == null) {
			if (other.workJustification != null)
				return false;
		} else if (!workJustification.equals(other.workJustification))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ReimbursementForm id=" + id + ", userid=" + userid
				+ ", dateOfEvent=" + dateOfEvent + ", address=" + address + ", city="
				+ city + ", state=" + state + ", cost=" + cost + ", estimateReimburse=" + estimateReimburse
				+ ", gradeFormat=" + gradeFormat + ", typeOfEvent=" + typeOfEvent + ", workJustification="
				+ workJustification + ", submissionDate=" + submissionDate + ", isUrgent=" + isUrgent + ", description="
				+ description + "]";
	}

	public ReimbursementForm(int id, String userid, Timestamp dateOfEvent, String address, String city,String state,
			int cost, String gradeFormat, String typeOfEvent, String workJustification, String description,  Date submitdate,Date endDate, Double esti, boolean bool) {
		super();
		this.id = id;
		this.userid = userid;
		this.dateOfEvent = dateOfEvent;
		this.address = address;
		this.city = city;
		this.state = state;
		this.cost = cost;
		this.gradeFormat = gradeFormat;
		this.typeOfEvent = typeOfEvent;
		this.workJustification = workJustification;
		this.isUrgent = false;
		this.submissionDate = submitdate;
		this.estimateReimburse = esti;
		this.description = description;
		this.endDate = endDate;
		this.isUrgent=bool;
	}
	
}
