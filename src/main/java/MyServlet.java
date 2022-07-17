import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet  extends HttpServlet{
	Database dbs=null;
	@Override
	public void init() throws ServletException {
		String url=getInitParameter("url");
		String user=getInitParameter("user");
		String pass=getInitParameter("password");
		dbs = new Database(url,user,pass);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
	
		
		String FirstName= request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String password= request.getParameter("password");
		String ConformPassword= request.getParameter("ConformPassword");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String question=request.getParameter("option");
		String answer= request.getParameter("answer");
		
		dbs.insert(FirstName, LastName, password, ConformPassword, gender, email, phone, question, answer);
//		PrintWriter out = response.getWriter();
//		out.println("<h1> SignUp Successfully </h1>");
		
		
		
		
		
		
		
	}
	
	
	

}
