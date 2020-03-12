package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.ApproveRejectForm;
import com.ikpb.service.ApproveRejectService;
import com.ikpb.service.impl.ApproveRejectServiceImpl;

/**
 * Servlet implementation class ApproveRejectIndServlet
 */
public class ApproveRejectIndServlet extends HttpServlet {
	private ApproveRejectService appRejectService = new ApproveRejectServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRejectIndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int formid = Integer.parseInt(request.getParameter("formid"));
		List<ApproveRejectForm> formList = appRejectService.getAllFormsByFormId(formid);
		String formListJSON = new GsonBuilder().create().toJson(formList); 
		PrintWriter pw = response.getWriter();
		pw.write(formListJSON);	
	}

}
