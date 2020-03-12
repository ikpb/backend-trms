package com.ikpb.dao;

import java.util.List;

import com.ikpb.domain.ApproveRejectForm;
import com.ikpb.domain.ApprovedForm;

public interface ApproveRejectDAO {
	public void createApproveRejectForm(ApproveRejectForm form);
	public ApproveRejectForm editApproveRejectForm();
	public ApproveRejectForm getFormByAppId(int appid);
	public List<ApproveRejectForm> getAllFormsByFormId(int formid);
	public List<ApproveRejectForm> getAllForms();
	public List<ApprovedForm> getAllApporvedForms(String userid);
	

}
