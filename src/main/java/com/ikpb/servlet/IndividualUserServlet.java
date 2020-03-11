package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.ReimbursementForm;
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
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//				request.getSession();
		String header = request.getHeader("Authorization");
		if (header ==null || !header.startsWith("Bearer ")) {
			String userError = new GsonBuilder().create().toJson("User Not Authorized");
			response.setStatus(response.SC_UNAUTHORIZED);
			PrintWriter pw = response.getWriter();
			pw.write(userError);
		}
		System.out.println("getting the tokens");
		String authToken = header.toString();
		String [] authSplit = authToken.split(" ");	
		String sessId =authSplit[1].toString();
		System.out.println("getting user sessionid");
		System.out.println(sessId);
		String firstName=authSplit[2].toString();
		System.out.println("getting firstname");
		System.out.println(firstName);
		String userId= authSplit[3].toString();
		System.out.println("getting email");
		System.out.println(userId);
		String userType= authSplit[4].toString();
		System.out.println("getting userType");
		System.out.println(userType);
		if(firstName!=null) {
			System.out.println("session validated individual");
		User user= userService.getUserByEmail(userId);
		System.out.println(user);
		String formListJSON = new GsonBuilder().create().toJson(user);
		PrintWriter pw = response.getWriter();
		pw.write(formListJSON);
		}else {
			PrintWriter pw = response.getWriter();
			pw.write("Not validated");
		}
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
