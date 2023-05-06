package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
int userid=Integer.parseInt(req.getParameter("userid"));
UserDao dao=new UserDao();
User user=dao.find(userid);
if(user==null)
{
	res.getWriter().print("<h1 style='color:red'>Invalid id</h1>");
	req.getRequestDispatcher("ForgotPassword.html").include(req, res);
}	else{
	long mobile=Long.parseLong(req.getParameter("mobile"));
	Date dob=Date.valueOf(req.getParameter("dob"));
	if(mobile==user.getMobile() && dob.equals(user.getDob()))
	{
		user.setPassword(req.getParameter("password"));
		dao.update(user);
		res.getWriter().print("<h1 style='color:green'>Password Updated Successfully</h1>");
		req.getRequestDispatcher("Login.html").include(req, res);
		
	}
	else{
		res.getWriter().print("<h1 style='color:red'>Invalid details</h1>");
		req.getRequestDispatcher("ForgotPassword.html").include(req, res);
	}
}
}
}
