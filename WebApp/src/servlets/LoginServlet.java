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

import impl.UserDAOImpl;
import model.User;
import utils.AppSettings;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("******************************");
		System.out.println("ID - " + session.getId());
		System.out.println("Maximum Interval - " + session.getMaxInactiveInterval());
		System.out.println("Creation Time - " + new Date(session.getCreationTime()));
		System.out.println("Last Time - " + new Date(session.getLastAccessedTime()));
		System.out.println("Is session - " + session.isNew());
		
		if(session.getAttribute("isUser") == null){
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("home");
			dispatcher.forward(request, response);
		}
//		} else {
//			response.getWriter().append("ERROR");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.html");
//			dispatcher.include(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String userName = request.getParameter("regUser");
			String userPass = request.getParameter("regPSW");
			//CHECK DB
			UserDAOImpl dao = new UserDAOImpl();
			User isUser = dao.getUserByLogin(new User(userName, userPass));

			HttpSession session = request.getSession();
			System.out.println("ID" + session.getId());
			System.out.println("Maximum Interval - " + session.getMaxInactiveInterval());
			System.out.println("Creation Time - " + new Date(session.getCreationTime()));
			System.out.println("Last Time - " + new Date(session.getLastAccessedTime()));
			System.out.println("Is session - " + session.isNew());
			
			if (isUser != null) {
				if (isUser.getPass().equals(userPass)) {
					session.setAttribute("isUser", isUser);
//					response.setContentType("text/html;charset=UTF-8");
//					PrintWriter out = response.getWriter();
//					out.append("<h1>Hello, " + isUser.getName() + "!</h1>");
//					session.setMaxInactiveInterval(Integer.valueOf(AppSettings.getInstance().getProperty("session_int")));
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("home");
					dispatcher.forward(request, response);
				} else {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out = response.getWriter();
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
					out.append("<b><font color=red>Incorrect Password!</font></b>");

					dispatcher.include(request, response);
				}

			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
				out.append("<b><font color=red>Incorrect User Name!</font></b>");

				dispatcher.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/InternalError.html");
		}

	}

}
