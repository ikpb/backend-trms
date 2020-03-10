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
import com.ikpb.exception.ReimbursementFormException;
import com.ikpb.service.ReimbursementService;
import com.ikpb.service.impl.ReimbursementServiceImpl;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
       private ReimbursementService reimburseService = new ReimbursementServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ReimbursementForm> usersFormLists = reimburseService.getAllUsersForms();
		String formListJSON = new GsonBuilder().create().toJson(usersFormLists);
		
		PrintWriter pw = response.getWriter();
		pw.write(formListJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reimbursementForm = request.getReader().readLine();
		System.out.println(reimbursementForm);
		ReimbursementForm myForm = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create().fromJson(reimbursementForm, ReimbursementForm.class);
		System.out.println(myForm);
		try {
			reimburseService.createReimbursementForm(myForm);
		} catch (ReimbursementFormException e) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
