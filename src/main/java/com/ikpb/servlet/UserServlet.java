package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.domain.User;
import com.ikpb.domain.User.UserType;
import com.ikpb.exception.ReimbursementFormException;
import com.ikpb.service.UserService;
import com.ikpb.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> usersList = userService.getAllUsers();
		String userListJSON = new GsonBuilder().create().toJson(usersList);
		userListJSON = userListJSON.replace("/[\u0000-\u0019]+/g",""); 
		PrintWriter pw = response.getWriter();
		pw.write(userListJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getReader().readLine();
		System.out.println(user);
		User newUser = new GsonBuilder().create().fromJson(user, User.class);
		System.out.println(newUser);
		
		try {
			userService.createUser(newUser);
			response.getWriter().write(newUser.getFirstName() + "Was successfully added");
		} catch (Exception e) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Form could not be created");
		}
	}

}
