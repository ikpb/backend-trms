package com.ikpb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ikpb.dao.ApproveRejectDAO;
import com.ikpb.domain.ApproveRejectForm;
import com.ikpb.domain.ApprovedForm;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.util.ConnectionFactory;

public class ApproveRejectDaoImpl implements ApproveRejectDAO {
	private static final String APP_REJECT_TABLE = "firstapproval";
	private static final String SELECT_ALL_APPROVE_REJECT_FORMS = "select * from " + APP_REJECT_TABLE;
	private static final String INSERT_APP_REJECT_FORM ="insert into "+ APP_REJECT_TABLE + 
	" (formid,approvedby,timeapp_rejected,rejected,rejectedby,moreinfo)"
		+"values(?,?,?,?,?,?)";
	private static final String SELECT_ALL_FORMS_BY_FORMID = "select * from " + APP_REJECT_TABLE + " where formid=?"; 
	private static final String SELECT_ALL_FORMS_BY_APPID = "select * from " + APP_REJECT_TABLE + " where appid=?";
	private static final String SELECT_ALL_APPROVED_FORMS_BY_USERID = "select * from getMyEmployeesApprovedForms(?)";
	@Override
	public void createApproveRejectForm(ApproveRejectForm form) {
		try{
			Connection conn = ConnectionFactory.getConnection();
			//Putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(INSERT_APP_REJECT_FORM);
			ps.setInt(1,form.getFormid());
	
			ps.setInt(2, form.getApprovedby());

			ps.setTimestamp(3,form.getTimeAppReject());

			ps.setBoolean(4,form.isRejected());

			ps.setInt(5, form.getRejectedby());

			ps.setString(6, form.getInfoNeeded());
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ApproveRejectForm editApproveRejectForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApproveRejectForm getFormByAppId(int appid) {
		ApproveRejectForm tempForm=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_FORMS_BY_APPID);
			ps.setInt(1, appid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempForm = new ApproveRejectForm(rs.getInt("appid"), rs.getInt("formid"),rs.getInt("approvedby"),
						rs.getTimestamp("timeapp_rejected"),rs.getBoolean("rejected"),rs.getInt("rejectedby"),rs.getString("moreinfo"));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempForm;
	}



	@Override
	public List<ApproveRejectForm> getAllFormsByFormId(int formid) {
		List<ApproveRejectForm> tempForm= new ArrayList<ApproveRejectForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_FORMS_BY_FORMID);
			ps.setInt(1, formid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempForm.add( new ApproveRejectForm(rs.getInt("appid"), rs.getInt("formid"),rs.getInt("approvedby"),
						rs.getTimestamp("timeapp_rejected"),rs.getBoolean("rejected"),rs.getInt("rejectedby"),rs.getString("moreinfo")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempForm;
	}

	@Override
	public List<ApproveRejectForm> getAllForms() {
		List<ApproveRejectForm> tempForm= new ArrayList<ApproveRejectForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_APPROVE_REJECT_FORMS);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempForm.add( new ApproveRejectForm(rs.getInt("appid"), rs.getInt("formid"),rs.getInt("approvedby"),
						rs.getTimestamp("timeapp_rejected"),rs.getBoolean("rejected"),rs.getInt("rejectedby"),rs.getString("moreinfo")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempForm;
	}

	@Override
	public List<ApprovedForm> getAllApporvedForms(String userid) {
		List<ApprovedForm> tempForm= new ArrayList<ApprovedForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_APPROVED_FORMS_BY_USERID);
			ps.setString(1, userid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempForm.add( new ApprovedForm(rs.getInt("t_approveid"), rs.getInt("t_approvedby"),rs.getDate("t_dateapproved"),
						rs.getInt("t_formid")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempForm;
	}


	}


