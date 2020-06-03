package jp.co.aivick.firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet(urlPatterns = {"/firstaccess"})
public class FirstAccessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		req.setAttribute("count", 0);
		int count = 0;
		int visited = 0;

		resp.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);

		if (session == null) {
			session = req.getSession(true);
			session.setAttribute("count2", "0");
		} else {
			String visitedStr = (String)session.getAttribute("count2");
		    visited = Integer.parseInt(visitedStr);
		    visited++;

		    session.setAttribute("count2", Integer.toString(visited));

		}
//
		req.setAttribute("count", Integer.toString(visited));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/firstaccess.jsp");
        requestDispatcher.forward(req, resp);
	}
}
