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
	private static final String SELECT_ALL_REIMBURSEMENT_BY_TITLE = "select  * from getMyEmployeesForms(?)";
	private static final String SELECT_SINGLE_REIMBURSEMENT_FOR_ADMIN = "select * from getMyEmployeeForm(?,?);";
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
					+ "submissiondate, enddate, reimburseestimate,urgent FROM reimburseform where formid = ?");
			ps.setInt(1, formid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForm = new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"),rs.getBoolean("urgent"));
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
					+ "submissiondate,enddate,reimburseestimate,urgent FROM reimburseform where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForm = new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"),rs.getBoolean("urgent"));
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
					+ "submissiondate,enddate,reimburseestimate,urgent FROM reimburseform"
					);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForms.add(new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"),rs.getBoolean("urgent")));
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
					+ "submissiondate,enddate,reimburseestimate,urgent FROM reimburseform where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForms.add(new ReimbursementForm(rs.getInt("formid"), rs.getString("userid"),rs.getTimestamp("dateofevent"),
						rs.getString("locationaddress"),rs.getString("locationcity"),rs.getString("locationstate"),rs.getInt("costs"),
						rs.getString("gradeformat"),rs.getString("typeofevent"),rs.getString("workjustification"),
						rs.getString("description"),rs.getDate("submissiondate"),rs.getDate("enddate"),rs.getDouble("reimburseestimate"),rs.getBoolean("urgent")));
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
	public List<ReimbursementForm> getAllFormsByTitle(int title) {
		List <ReimbursementForm> tempReimburseForms = new ArrayList<ReimbursementForm>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_REIMBURSEMENT_BY_TITLE);
			ps.setInt(1, title);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForms.add(new ReimbursementForm(rs.getInt("r_formid"), rs.getString("r_userid"),rs.getTimestamp("r_dateofevent"),
						rs.getString("r_locationaddress"),rs.getString("r_locationcity"),rs.getString("r_locationstate"),rs.getInt("r_costs"),
						rs.getString("r_gradeformat"),rs.getString("r_typeofevent"),rs.getString("r_workjustification"),
						rs.getString("r_description"),rs.getDate("r_submissiondate"),rs.getDate("r_enddate"),rs.getDouble("r_reimburseestimate"),rs.getBoolean("r_urgent")));
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
	public ReimbursementForm getFormForAdmin(int title, int formid) {
		ReimbursementForm tempReimburseForm=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_SINGLE_REIMBURSEMENT_FOR_ADMIN);
			ps.setInt(1, title);
			ps.setInt(2, formid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempReimburseForm = new ReimbursementForm(rs.getInt("t_formid"), rs.getString("t_userid"),rs.getTimestamp("t_dateofevent"),
						rs.getString("t_locationaddress"),rs.getString("t_locationcity"),rs.getString("t_locationstate"),rs.getInt("t_costs"),
						rs.getString("t_gradeformat"),rs.getString("t_typeofevent"),rs.getString("t_workjustification"),
						rs.getString("t_description"),rs.getDate("t_submissiondate"),rs.getDate("t_enddate"),rs.getDouble("t_reimburseestimate"),rs.getBoolean("t_urgent"));
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempReimburseForm;
	}

}
