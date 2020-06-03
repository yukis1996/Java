package jp.co.aivick.firstweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jdk.internal.net.http.frame.Http2Frame;

@WebServlet(urlPatterns = {"/firstcalculater"})
public class FirstCalculaterServlet extends HttpServlet{

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        req.setAttribute("num1", 0);
        req.setAttribute("num2", 0);
        req.setAttribute("calculater", "");
        req.setAttribute("result", 0);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/firstcalculater.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int sum = 0;
        String calculater = req.getParameter("calculater");

        switch (calculater) {
        case "+":
        	sum = num1 + num2;
        	break;
        case "-":
        	sum = num1 - num2;
        	break;
        case "*":
        	sum = num1 * num2;
        	break;
        case "/":
        	sum = num1 / num2;
        	break;
        }

        req.setAttribute("num1", num1);
        req.setAttribute("calculater", calculater);
        req.setAttribute("num2", num2);
        req.setAttribute("result", sum);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/firstcalculater.jsp");
        requestDispatcher.forward(req, resp);
    }}
