package com.ikpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;
import com.ikpb.domain.User;
import com.ikpb.service.AuthenticationService;
import com.ikpb.service.impl.AuthenticationServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static AuthenticationService authService = new AuthenticationServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userLogin = request.getReader().readLine();
		System.out.println(userLogin);
		String userLogins = userLogin.replace("/[\u0000-\u0019]+/g",""); 
		User newUser = new GsonBuilder().create().fromJson(userLogins, User.class);
		String username = newUser.getEmail();
		String password = newUser.getPassword();
		System.out.println("Username: " + username + " Password: " + password);
		User user = authService.validateUser(username, password);
		System.out.println("User: " + user);
		if (user == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
		} else {
			HttpSession oldSession = request.getSession(false);
			if(oldSession !=null) {
				oldSession.invalidate();
			}
			HttpSession sess = request.getSession(true);
			response.setStatus(200);
			String userSent = new GsonBuilder().create().toJson("id:"+user.getId()+" firstName:" + user.getFirstName() + " lastName:" +user.getLastName()+ " email:"+user.getEmail()+ " userType:"+user.getUserType() + " sessionid:"+sess.getId());
			PrintWriter pw = response.getWriter();
			pw.write(userSent);
		}
	}

}
