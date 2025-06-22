package in.bloodsync.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import in.bloodsync.dao.BloodRequestDao;
import in.bloodsync.pojo.BloodRequestPojo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HospitalRequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		String  hospitalname=req.getParameter("hospital_name");
		String bloodType=req.getParameter("blood_type");
		String strunit=req.getParameter("blood_units");
		int bloodUnits=Integer.parseInt(strunit);
		String urgency=req.getParameter("urgency_level");
		String email=req.getParameter("email");
		
		BloodRequestPojo request=new BloodRequestPojo();
		request.setHospitalName(hospitalname);
		request.setBloodType(bloodType);
		request.setRequestedUnits(bloodUnits);
		request.setUrgency(urgency);
		request.setEmail(email);
		
		 RequestDispatcher rd=req.getRequestDispatcher("html/response_handling");

		
		 try {
		    boolean ans=BloodRequestDao.addBloodRequest(request);	
		    if(ans==true) {
		    	pw.println("<title>Registration sucessful</title>");
		    	pw.println("<div class='wrapper'>");
		    	pw.println("<div class='container'>");
		    	pw.println("<h1 class='green'>Request Submitted Sucessfully!</h1>");
		    	pw.println("<p>Your blood request has been sucessfully registered </p>");
		    	pw.println("<p>We appreciate your support in saving Life</p>");
		    	pw.println("<a href='html/Home.html' class='btn'>Go to Home</a>");
		    	pw.println("</div></div>");
		   }
		    else {
		    	pw.println("<title>Registration Failed!</ti;tle>");
		    	pw.println("<div class='wrapper'>");
		    	pw.println("<div class='container'>");
		    	pw.println("<h1 class='red'>Registration Failed!</h1>");
		    	pw.println("<p>Somthing went wrong ,Please try later</p>");
		    	pw.println("<p>If problem persists,contact support.</p>");
		    	pw.println("<a href='html/index.html' class='btn'>Go to Home</a>");
		    	pw.println("</div></div>");
		    }
		    }catch(SQLException ex){
		    	pw.println("<title>Server error</title>");
		    	pw.println("<div class='wrapper'>");
		    	pw.println("<div class='container'>");
		    	pw.println("<h1 class='red'>Server error</h1>");
		    	pw.println("<p>"+ex.getMessage()+"</p>");
	
		    	pw.println("<a href='html/hospital_request.html' class='btn'>Try again!</a>");
		    	pw.println("</div></div>");
		    }
		
		 finally {
			 pw.flush();
			 rd.include(req, resp);
		 }
	}
}
