package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.User;
import com.ikpb.service.UserService;
import com.ikpb.service.impl.UserServiceImpl;

/**
 * Servlet implementation class IndividualUserServlet
 */
public class IndividualUserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		User user = userService.getUserById(userid);
//		String userListJSON = new GsonBuilder().create().toJson(usersList);
//		userListJSON = userListJSON.replace("/[\u0000-\u0019]+/g",""); 
//		PrintWriter pw = response.getWriter();
//		pw.write(userListJSON);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
