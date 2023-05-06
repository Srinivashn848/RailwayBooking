package controller;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import dto.User;

@WebServlet("/Register")
public class RegisterUser extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstName=req.getParameter("first");
		String lastName=req.getParameter("last");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		Date dob=Date.valueOf(req.getParameter("dob"));
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		if(password1.equals(password2))
			if(age>18)
		{
		 User user=new User();
		 user.setAge(age);
		 user.setDob(dob);
		 user.setEmail(email);
		 user.setFirstname(firstName);
		 user.setLastname(lastName);
		 user.setMobile(mobile);
		 user.setPassword(password1);
		
		 
		 UserDao dao=new UserDao();
		 dao.save(user);
		 res.getWriter().print("<h1 style='color:green'>Account Created successfully <br> Your UserId is:"+user.getId()+"</h1>");
		 req.getRequestDispatcher("Home.html").include(req, res);
		}
		else{
			res.getWriter().print("<h1 style='color:red'>Password Mismatch</h1>");
			req.getRequestDispatcher("Register.html").include(req, res);
		}
		
	}
}
