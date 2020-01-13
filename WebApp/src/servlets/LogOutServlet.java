package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		System.out.println("************************************");
		System.out.println("ID" + session.getId());
		System.out.println("Maximum Interval - " + session.getMaxInactiveInterval());
		System.out.println("Creation Time - " + new Date(session.getCreationTime()));
		System.out.println("Last Time - " + new Date(session.getLastAccessedTime()));
		System.out.println("Is session - " + session.isNew());
		
		if(session.getAttribute("isUser") != null){
//			session.invalidate();
//			response.setContentType("text/html;charset=UTF-8");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
//			dispatcher.forward(request, response);
//			return;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/logout.html");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
