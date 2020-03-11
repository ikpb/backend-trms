package com.ikpb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ikpb.dao.ReimbursementDAO;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.exception.ReimbursementFormException;
import com.ikpb.util.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDAO {
	private static final String REIMBURSEMENT_TABLE = "reimburseform";
	private static final String SELECT_ALL_REIMBURSEMENT_FORMS = "select * from " + REIMBURSEMENT_TABLE;
	private static final String INSERT_REIMBURSEMENT_FORM = "insert into "+ REIMBURSEMENT_TABLE+ 
	" (userid ,dateofevent,locationaddress,locationcity ,locationstate ,costs,gradeformat ,typeofevent ,workjustification ,submissiondate, urgent,description, enddate, reimburseestimate) "
			+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	@Override
	public void createReimbursementForm(ReimbursementForm form) throws ReimbursementFormException{
		
		try{
			Connection conn = ConnectionFactory.getConnection();
			//Putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(INSERT_REIMBURSEMENT_FORM);
			ps.setString(1,form.getUserid());
	
			ps.setTimestamp(2, form.getDateOfEvent());

			ps.setString(3,form.getAddress());

			ps.setString(4,form.getCity());

			ps.setString(5, form.getState());

			ps.setInt(6, form.getCost());

			ps.setString(7, form.getGradeFormat());

			ps.setString(8, form.getTypeOfEvent());

			ps.setString(9, form.getWorkJustification());

			ps.setDate(10, form.getSubmissionDate());

			ps.setBoolean(11, form.isUrgent());

			ps.setString(12, form.getDescription());

			ps.setDate(13, form.getEndDate());

			ps.setDouble(14, form.getEstimateReimburse());

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
	public ReimbursementForm editReimbursementForm(int formid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markFormApproved(int formid) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReimbursementForm getFormById(int formid) {
		ReimbursementForm tempReimburseForm=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT formid,userid,dateofevent,locationaddress,locationcity,"
					+ "locationstate,costs,gradeformat,typeofevent,workjustification,description,"
					+ "submissiondate, enddate, reimburseestimate FROM reimburseform where formid = ?");
			ps.setInt(1, formid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForm = new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForm;
	}

	@Override
	public void deleteForm(int formid) {
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement("DELETE FROM reimburseform WHERE formid=?");
			ps.setInt(1, formid);
			ps.executeUpdate();
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	@Override
	public ReimbursementForm getFormUserId(String userId) {
		ReimbursementForm tempReimburseForm=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT formid,userid,dateofevent,locationaddress,locationcity,"
					+ "locationstate,costs,gradeformat,typeofevent,workjustification,description,"
					+ "submissiondate,enddate,reimburseestimate FROM reimburseform where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForm = new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForm;
	}

	@Override
	public List<ReimbursementForm> getAllUserForms() {
		List <ReimbursementForm> tempReimburseForms = new ArrayList<ReimbursementForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT formid,userid,dateofevent,locationaddress,locationcity,"
					+ "locationstate,costs,gradeformat,typeofevent,workjustification,description,"
					+ "submissiondate,enddate,reimburseestimate FROM reimburseform"
					);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForms.add(new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForms;
		
	}

	@Override
	public List<ReimbursementForm> getAllFormsUserId(String userId) {
		List <ReimbursementForm> tempReimburseForms = new ArrayList<ReimbursementForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT formid,userid,dateofevent,locationaddress,locationcity,"
					+ "locationstate,costs,gradeformat,typeofevent,workjustification,description,"
					+ "submissiondate,enddate,reimburseestimate FROM reimburseform where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForms.add(new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate")));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForms;
	}

}
