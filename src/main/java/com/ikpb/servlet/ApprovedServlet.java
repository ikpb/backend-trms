package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.ApprovedForm;
import com.ikpb.domain.ReimbursementForm;
import com.ikpb.service.ApproveRejectService;
import com.ikpb.service.ReimbursementService;
import com.ikpb.service.impl.ApproveRejectServiceImpl;
import com.ikpb.service.impl.ReimbursementServiceImpl;

/**
 * Servlet implementation class ApprovedServlet
 */
public class ApprovedServlet extends HttpServlet {
	ApproveRejectService approveService = new ApproveRejectServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		List<ApprovedForm> usersFormLists = approveService.getAllApporvedForms(userid);
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
