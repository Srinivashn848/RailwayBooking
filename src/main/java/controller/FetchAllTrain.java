package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/fetchalltrain")
public class FetchAllTrain extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		TrainDao dao=new TrainDao();
		List<Train> list=dao.fetchAll();
		
		if(list.isEmpty())
		{
			res.getWriter().print("<h1 style='color:red'>No railway information</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, res);
		}
		else{
			res.getWriter().print("<h1 style='color:red'>Railway information removed Successfully</h1>");
			req.setAttribute("list", list);
			req.getRequestDispatcher("FetchRailwayInfo.jsp").include(req, res);
		}
	}

}
