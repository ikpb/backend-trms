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
import com.ikpb.service.ReimbursementService;
import com.ikpb.service.impl.ReimbursementServiceImpl;

/**
 * Servlet implementation class ReimbursementIndServlet
 */
public class ReimbursementIndServlet extends HttpServlet {
	private ReimbursementService reimburseService = new ReimbursementServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementIndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession();
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
		System.out.println(sessId);
		String firstName=authSplit[2].toString();
		System.out.println(firstName);
		String userId= authSplit[3].toString();
		System.out.println(userId);
		int formid = Integer.parseInt(request.getParameter("id"));
		System.out.println(formid);
		ReimbursementForm indiviualForm = reimburseService.getFormById(formid);
		String formListJSON = new GsonBuilder().create().toJson(indiviualForm);
		
		PrintWriter pw = response.getWriter();
		pw.write(formListJSON);
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
