import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	Database dbs;
	@Override
	public void init() throws ServletException {
		String url=getInitParameter("url");
		String user=getInitParameter("user");
		String pass=getInitParameter("password");
		dbs = new Database(url,user,pass);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("texthtml,charset=UTF-8");
		String userEmail = req.getParameter("user_email");
		String userPass = req.getParameter("user_password");
		PrintWriter out = resp.getWriter();
		
		if(dbs.check_credentaial(userEmail, userPass)) {
			System.out.println("login");
			resp.sendRedirect("/Home.html");
		}
		else {
			System.out.println("not login");
			out.print("<h1>Invalid Information </h1>");
		}
	}
	

}
