package in.bloodsync.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");
    	PrintWriter pw=resp.getWriter();
    	
    	String emailId=req.getParameter("email");
    	String password=req.getParameter("password");
    	
    	ServletConfig sc=super.getServletConfig();
    	String email=sc.getInitParameter("emailId");
    	String pwd=sc.getInitParameter("password");
    	
    	if(emailId.equals(email) && password.equals(pwd)) {
             resp.sendRedirect("html/admin/admin_dashboard.html");
    	}else {
    		RequestDispatcher rd=req.getRequestDispatcher("html/response_handling.html");
   		    
    		pw.println("<title>Login denied!</title>");
	    	pw.println("<div class='wrapper'>");
	    	pw.println("<div class='container'>");
	    	pw.println("<h1 class='red'>login  Failed!</h1>");
	    	pw.println("<p>Invaild username and password</p>");	    	
	    	pw.println("<a href='html/admin/admin.html' class='btn'>Try again!</a>");
	    	pw.println("</div></div>");
	    	pw.flush();
	    	rd.include(req, resp);
    	}

    }
}
