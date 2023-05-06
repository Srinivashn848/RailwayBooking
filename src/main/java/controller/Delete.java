package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;

@WebServlet("/deletetrain")
public class Delete extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int number=Integer.parseInt(req.getParameter("number"));
	TrainDao dao=new TrainDao();
	dao.delete(number);
	res.getWriter().print("<h1>Deleted Successfully</h1>");
	req.setAttribute("list", dao.fetchAll());
	req.getRequestDispatcher("FetchRailwayInfo.jsp").include(req, res);
}
	}

