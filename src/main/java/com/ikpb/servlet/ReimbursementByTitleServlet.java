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
import com.ikpb.service.ReimbursementService;
import com.ikpb.service.impl.ReimbursementServiceImpl;

/**
 * Servlet implementation class ReimbursementByTitleServlet
 */
public class ReimbursementByTitleServlet extends HttpServlet {
	  private ReimbursementService reimburseService = new ReimbursementServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementByTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int title = Integer.parseInt(request.getParameter("title"));
		System.out.println(title);
		List<ReimbursementForm> usersFormLists = reimburseService.getAllFormsByTitle(title);
		String formListJSON = new GsonBuilder().create().toJson(usersFormLists);
		
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
