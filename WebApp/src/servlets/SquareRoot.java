package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SquareRoot
 */
@WebServlet("/SquareRoot")
public class SquareRoot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SquareRoot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter pw = response.getWriter();
        pw.append("<!DOCTYPE html>");
        pw.append("<html lang=\"en\">");
        //HEAD START
        pw.append("<head>");
        pw.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        pw.append("<title> вадратные уравнени€</title>");
        pw.append("</head>");
        //HEAD END
        
        //BODY START
        pw.append("<body>");
        pw.append("<h1>SquareRoot</h1>");
        pw.append("<p> A*x*x + B*x + C</p>");
        pw.append("<p> D = B*B - 4*A*C</p>");
        
        
        pw.append("</body>");
        //BODY END
        pw.append("</html>");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
