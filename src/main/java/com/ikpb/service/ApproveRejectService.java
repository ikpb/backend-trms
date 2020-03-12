package com.ikpb.service;

import java.util.List;

import com.ikpb.domain.ApproveRejectForm;
import com.ikpb.domain.ApprovedForm;

public interface ApproveRejectService {
	public void createApproveRejectForm(ApproveRejectForm form);
	public ApproveRejectForm editApproveRejectForm();
	public ApproveRejectForm getFormByAppId(int appid);
	public List<ApproveRejectForm> getAllFormsByFormId(int formid);
	public List<ApproveRejectForm> getAllForms();
	public List<ApprovedForm> getAllApporvedForms(String userid);
}
