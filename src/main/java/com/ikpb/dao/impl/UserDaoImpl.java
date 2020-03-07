package com.ikpb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ikpb.dao.UserDAO;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.domain.User;
import com.ikpb.util.ConnectionFactory;

public class UserDaoImpl implements UserDAO {
	private static final String USER_TABLE = "employee";
	private static final String SELECT_ALL_EMPLOYEE = "select * from " + USER_TABLE;
	private static final String SELECT_USER_BY_EMAIL = "select * from " + USER_TABLE + " where email=?";
	private static final String SELECT_USER_BY_ID = "select * from " + USER_TABLE + " where id=?";
	private static final String INSERT_INTO_USER = "insert into "+ USER_TABLE+ 
			" (firstname ,lastname,email,password ,reportsto,title,reimburseamountleft,usertype) "
					+"values(?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_USERS_SUPERVIOR_BY_ID = "select * from " + USER_TABLE + " where title=?";
	@Override
	public void createUser(User user) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_INTO_USER);
			ps.setInt(1,user.getId());
			ps.setString(2,user.getFirstName());
			ps.setString(3,user.getLastName());
			ps.setString(4,user.getEmail());
			ps.setString(5,user.getPassword());
			ps.setInt(6,user.getReportsTo());
			ps.setInt(7,user.getTitle());
			ps.setInt(8,user.getRemainingAmount());
			ps.setString(9,user.getUserType().toString());
			ps.execute();
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public User editUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userid) {
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, userid);
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
	public User getUserById(int userid) {
		User tempUser=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			if(rs.next()) {
				tempUser= new User(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"), User.UserType.valueOf(rs.getString("userType")) );
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempUser;
	}

	@Override
	public User getUserByEmail(String email) {
		User tempUser=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			if(rs.next()) {
				tempUser= new User(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"), User.UserType.valueOf(rs.getString("userType")) );
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempUser;
	}

	@Override
	public List<User> getAllUsers() {
		List <User> tempUsers= new ArrayList<User>();
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPLOYEE);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			while(rs.next()) {
				tempUsers.add(new User(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"), User.UserType.valueOf(rs.getString("usertype"))));
			}
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempUsers;
	}
	public int	getSupervisorIdByTitle(int title) {
		User tempUser=null;
		try{
			Connection conn = ConnectionFactory.getConnection();
			//putting in a native sql query utilizing a prepared statement
			PreparedStatement ps = conn.prepareStatement(SELECT_USERS_SUPERVIOR_BY_ID);
			ps.setInt(1, title);
			ResultSet rs = ps.executeQuery();
			//we are executing the query and storing the result set in 
			//a Resultset
			if(rs.next()) {
				tempUser= new User(rs.getInt("id"), rs.getString("firstname"),rs.getString("lastname"),
						rs.getString("email"),rs.getString("password"), User.UserType.valueOf(rs.getString("userType")) );
			}
			
			ps.execute();
			//allows us to execute a query without a result
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return tempUser.getId();
		
		
	}

}
