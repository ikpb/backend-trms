package com.ikpb.service.impl;


import java.util.List;

import com.ikpb.dao.ReimbursementDAO;
import com.ikpb.dao.impl.ReimbursementDaoImpl;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.exception.ReimbursementFormException;
import com.ikpb.service.ReimbursementService;


public class ReimbursementServiceImpl implements ReimbursementService {
	ReimbursementDAO reimburseDao = new ReimbursementDaoImpl();
	@Override
	public void createReimbursementForm(ReimbursementForm form) throws ReimbursementFormException{
		
			reimburseDao.createReimbursementForm(form);
	}

	@Override
	public ReimbursementForm editReimbursementForm(int formid) {
		
		return reimburseDao.editReimbursementForm(formid);
	}

	@Override
	public void markFormApproved(int formid) {
		reimburseDao.markFormApproved(formid);

	}

	@Override
	public ReimbursementForm getFormById(int formid) {
		
		return reimburseDao.getFormById(formid);
	}

	@Override
	public void deleteForm(int formid) {
		reimburseDao.deleteForm(formid);

	}

	@Override
	public ReimbursementForm getFormUserId(int id) {
		
		return reimburseDao.getFormUserId(id);
	}

	@Override
	public List<ReimbursementForm> getAllUsersForms() {
		return reimburseDao.getAllUserForms();
	}

}
