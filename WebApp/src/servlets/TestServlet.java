package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        System.out.println("3.TestServlet init()");
    }
    
    static {
        System.out.println("1.TestServlet loaded");
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        System.out.println("2.TestServlet instance created");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // TODO Auto-generated method stub
        super.service(req, resp);
         System.out.println("4. service method to delegate");
        
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        
        String num1 = request.getParameter("NUM1");
        String num2 = request.getParameter("NUM2");
        
        
        String show = request.getParameter("SHOW");
        //1.Can be NULL if it's not exists (User not send this param) 
        //2.Can be AbraCadabRa
        //3.Can be Yes / No / True / False / TRUE / FALSE
        
        String part = "<div class='space' id='extra'>" + 
                        "THE CONTENT IS DISABLED! PLEASE SET 'SHOW' PARAMETHER LIKE 'Yes / True ' " + 
                      "</div>";
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>");
        writer.append("<html lang=\"en\">");
        writer.append("<head>\r\n" + 
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
                "    <title>����</title>\r\n" + 
                "    <style type=\"text/css\">\r\n" + 
                "        .space {\r\n" + 
                "            padding: 20px; /* ���� */\r\n" + 
                "            background: #E5D3BD; /* ���� ���� */\r\n" + 
                "            border: 2px solid #E81E25; /* ��������� ����� */\r\n" + 
                "        }\r\n" + 
                "        #extra{\r\n" + 
                "            background: gray;\r\n" + 
                "        }\r\n" + 
                "        P.line {\r\n" + 
                "            border-left: 1px dotted red;\r\n" + 
                "            padding: 10px;\r\n" + 
                "        }\r\n" + 
                "        .layer1, .layer2 {\r\n" + 
                "            background: #F2EFE6;\r\n" + 
                "            border: 1px solid #B25538;\r\n" + 
                "            padding: 10px;\r\n" + 
                "            margin: 20px;\r\n" + 
                "        }\r\n" + 
                "        div {\r\n" + 
                "            width: 100%; /* ������ */\r\n" + 
                "            background: grey; /* ���� ���� */\r\n" + 
                "            padding: 20px; /* ���� */\r\n" + 
                "            -moz-box-sizing: border-box; /* ��� Firefox */\r\n" + 
                "            -webkit-box-sizing: border-box; /* ��� Safari � Chrome */\r\n" + 
                "            box-sizing: border-box; /* ��� IE � Opera */\r\n" + 
                "        }\r\n" + 
                "        .wrap {\r\n" + 
                "            width: 50%; /* ������ */\r\n" + 
                "        }\r\n" + 
                "        .wrap div {\r\n" + 
                "            background: #fc0;\r\n" + 
                "            margin: 10px;\r\n" + 
                "            padding: 20px;\r\n" + 
                "            border: 1px solid #000;\r\n" + 
                "        }\r\n" + 
                "    </style>\r\n" + 
                "</head>\r\n");
                
        //BODY
        writer.append("<body>"); 
        //CONTENT
        // IS 'SHOW' TRUE?
        
        boolean notShow = (show == null) || (show.toLowerCase().trim().equals("no")) || (show.toLowerCase().trim().equals("false"));
        
        writer.append(
                notShow? part :
                "<div class=\"space\">\r\n" + 
                "    ��� ���, ����� �������� ���, ����� ������ ��� � ������� ������ �� �������,\r\n" + 
                "    ��� ���, ����� ������� � ����, �������� �����������, �� �� �����, ���\r\n" + 
                "    ������ ������ � ��������� �������.\r\n" + 
                "</div>\r\n" + 
                "<div class=\"space\" id=\"extra\">\r\n" + 
                "    some txt.\r\n" + 
                "</div>\r\n" + 
                "<p class=\"line\">��� ����� ������ � ��� ������, ����� ��������, ���\r\n" + 
                "    ���������� ����������� ��� ��� ������������� ���� ����� �������.</p>\r\n" + 
                "<div class=\"layer1\">��� ����� ������ � ��� ������, ����� ��������, ���\r\n" + 
                "    ���������� ����������� ��� ��� ������������� ���� ����� �������.</div>\r\n" + 
                "<div class=\"layer2\">��������� ������� ���� ����� ����� ����� � ������\r\n" + 
                "    �� �������� ����������.</div>\r\n" + 
                
                "<div class=\"layer2\">PARAMS FROM CLIENT: A = "+num1+" , B = "+num2+".</div>\r\n" +
                
                "<div>������ ����� 100%</div>\r\n" + 
                "<div class=\"wrap\">\r\n" + 
                "    <div>������ ���� 100%</div>\r\n" + 
                "</div>");
                
        writer.append("</body>");
        writer.append("</html>");
        
        
        System.out.println("doGet() -> " + Thread.currentThread().getId());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
        System.out.println("5. Destroy Servlet");
    }

}
