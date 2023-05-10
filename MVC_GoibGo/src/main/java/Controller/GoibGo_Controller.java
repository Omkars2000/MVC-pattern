package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Service;
@WebServlet("/goibgolink")
public class GoibGo_Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		String no1=req.getParameter("no");
		int no=Integer.parseInt(no1);
		String sub=req.getParameter("sub");
		
		if(sub==null) {
        	RequestDispatcher rd=req.getRequestDispatcher("cokie.jsp");
        	rd.forward(req, resp);
        }
		
		Service s1=new Service();
		double price= Service.price(from,to,no);
	        	
		if(price !=0) {
			req.setAttribute("from", from);
			req.setAttribute("to", to);
			req.setAttribute("price", price);
			req.setAttribute("no", no);
			Cookie c1= new Cookie(from,to);
			resp.addCookie(c1);
			RequestDispatcher rd= req.getRequestDispatcher("goibGo.jsp");
			rd.forward(req, resp);
			
		}else
			resp.sendRedirect("index.html");
		
		
	}

}
