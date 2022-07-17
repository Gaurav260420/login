import java.sql.*;
public class Database {
	Connection conn=null;
	Statement stm =null;
	
	public Database(String url, String user, String pass){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn= DriverManager.getConnection(url,user,pass);
		conn.createStatement();
		System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
	}
	
	public boolean insert(String FirstName,String LastName,String password,String ConformPassword,String gender,String email,String phone,String question,String answer)
	{
		try {
		PreparedStatement pstm = conn.prepareStatement("insert into signup(first_name,last_name,password,conf_password,gender,email,phone,question,answer) values(?,?,?,?,?,?,?,?,?)");
		pstm.setString(1, FirstName);
		pstm.setString(2, LastName);
		pstm.setString(3, password);
		pstm.setString(4, ConformPassword);
		pstm.setString(5, gender);
		pstm.setString(6, email);
		pstm.setString(7, phone);
		pstm.setString(8, question);
		pstm.setString(9, answer);
		return pstm.execute();
		}
		catch(Exception e) {
			System.out.println("Not Inserted"+e);
			return false;
		}
	}
	
	public boolean check_credentaial(String userEmail,String userPass)
	{
		String query="select * from signup where email= "+userEmail+" and password = "+userPass;
		try {             
		ResultSet result = stm.executeQuery(query);
		return result.next();
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	

}
