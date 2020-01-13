package servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import impl.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/update.html");
		if (session.getAttribute("isUser") != null) {
			// request.getContextPath() = /app
			User isUser = (User) session.getAttribute("isUser");
			out.append("<h1>You are here!</h1>");
			out.append("<p>Your id in DB " + isUser.getId() + "</p>");
			out.append("<p>Your name " + isUser.getName() + "</p>");
			out.append("<p>Your Email " + isUser.getEmail() + "</p>");
			out.append("<p>You PASSWORD " + isUser.getPass() + "</p>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.html");
			dispatcher.include(request, response);

		} else {
			
			out.append("<h1>OOOPS!</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
			dispatcher.include(request, response);
		}

		

		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/update.html");
		// dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User updateUser = new User();

		updateUser.setName(request.getParameter("updateUser"));
		updateUser.setPass(request.getParameter("updatePSW"));
		// request.getParameter("pass2");
		updateUser.setEmail(request.getParameter("updateEmail"));

		UserDAO dao = new UserDAOImpl();
		if (dao.createUser(updateUser)) {
			response.getWriter().print("INSERTED.You can LOGIN!");
		} else {
			response.getWriter().print("NOT INSERTED.See LOGS!");

		}
	}

}
