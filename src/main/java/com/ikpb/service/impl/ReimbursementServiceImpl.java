package com.ikpb.service.impl;


import java.util.List;
import java.sql.Timestamp;
import com.ikpb.dao.ReimbursementDAO;
import com.ikpb.dao.impl.ReimbursementDaoImpl;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.exception.ReimbursementFormException;
import com.ikpb.service.ReimbursementService;


public class ReimbursementServiceImpl implements ReimbursementService {
	ReimbursementDAO reimburseDao = new ReimbursementDaoImpl();
	@Override
	public void createReimbursementForm(ReimbursementForm form) throws ReimbursementFormException{
		Timestamp startDate = form.getDateOfEvent();
		int twoWeeks = 14*24*60*60*1000;
		Timestamp twoWeekDate = new Timestamp(System.currentTimeMillis()+twoWeeks);
		if(startDate.before(twoWeekDate)) {
			form.setUrgent(true);
		}
		int courseCost = form.getCost();
		double estimatedReimbursement = 0;
		int eventType = Integer.parseInt(form.getTypeOfEvent());
		switch(eventType) {
		case 1:
			estimatedReimbursement = courseCost*.8;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		case 2:
			estimatedReimbursement = courseCost*.6;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		case 3:
			estimatedReimbursement = courseCost*.75;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		case 4:
			estimatedReimbursement = courseCost*1;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		case 5:
			estimatedReimbursement = courseCost*.9;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		case 6:
			estimatedReimbursement = courseCost*.3;
			form.setEstimateReimburse(estimatedReimbursement);
			break;
		}
		
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
	public ReimbursementForm getFormUserId(String userid) {
		
		return reimburseDao.getFormUserId(userid);
	}

	@Override
	public List<ReimbursementForm> getAllUsersForms() {
		return reimburseDao.getAllUserForms();
	}

	@Override
	public List<ReimbursementForm> getAllFormsUserId(String userId) {

		return reimburseDao.getAllFormsUserId(userId);
	}

}
