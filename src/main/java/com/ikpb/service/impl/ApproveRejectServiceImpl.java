package com.ikpb.service.impl;

import java.util.List;

import com.ikpb.dao.ApproveRejectDAO;
import com.ikpb.dao.impl.ApproveRejectDaoImpl;
import com.ikpb.domain.ApproveRejectForm;
import com.ikpb.domain.ApprovedForm;
import com.ikpb.service.ApproveRejectService;

public class ApproveRejectServiceImpl implements ApproveRejectService {
	ApproveRejectDAO appRejectDao = new ApproveRejectDaoImpl();
	@Override
	public void createApproveRejectForm(ApproveRejectForm form) {
		appRejectDao.createApproveRejectForm(form);

	}

	@Override
	public ApproveRejectForm editApproveRejectForm() {
		return appRejectDao.editApproveRejectForm();
	}

	@Override
	public ApproveRejectForm getFormByAppId(int appid) {
		return appRejectDao.getFormByAppId(appid);
	}

	@Override
	public List<ApproveRejectForm> getAllFormsByFormId(int formid) {
		return appRejectDao.getAllFormsByFormId(formid);
	}

	@Override
	public List<ApproveRejectForm> getAllForms() {
		return appRejectDao.getAllForms();
	}

	@Override
	public List<ApprovedForm> getAllApporvedForms(String userid) {
		return appRejectDao.getAllApporvedForms(userid);
	}

}
