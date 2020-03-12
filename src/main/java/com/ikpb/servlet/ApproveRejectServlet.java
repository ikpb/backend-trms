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
import com.ikpb.domain.User;
import com.ikpb.service.ApproveRejectService;
import com.ikpb.service.impl.ApproveRejectServiceImpl;

/**
 * Servlet implementation class ApproveRejectServlet
 */
public class ApproveRejectServlet extends HttpServlet {
	private ApproveRejectService appRejectService = new ApproveRejectServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ApproveRejectForm> formList = appRejectService.getAllForms();
		String formListJSON = new GsonBuilder().create().toJson(formList); 
		PrintWriter pw = response.getWriter();
		pw.write(formListJSON);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = request.getReader().readLine();
		System.out.println(form);
		ApproveRejectForm newForm = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create().fromJson(form, ApproveRejectForm.class);
		System.out.println(newForm);
		
		try {
			appRejectService.createApproveRejectForm(newForm);
			String formSent = new GsonBuilder().create().toJson("Form Id: "+ newForm.getFormid() + "Has been Successfully submitted");
			response.getWriter().write(formSent);
		} catch (Exception e) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Form could not be created");
		}
	}

}
