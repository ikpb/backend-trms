package com.ikpb.dao;

import java.util.List;

import com.ikpb.domain.ReimbursementForm;
import com.ikpb.exception.ReimbursementFormException;

public interface ReimbursementDAO {
	public void createReimbursementForm(ReimbursementForm form) throws ReimbursementFormException;
	public ReimbursementForm editReimbursementForm(int formid);
	public void markFormApproved(int formid);
	public ReimbursementForm getFormById(int formid);
	public void deleteForm(int formid);
	public ReimbursementForm getFormUserId(String userId);
	public List<ReimbursementForm> getAllUserForms();
	

}
