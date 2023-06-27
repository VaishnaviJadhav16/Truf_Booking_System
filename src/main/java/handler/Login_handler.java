package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_dao.Login_dao;


/**
 * Servlet implementation class Login_handler
 */
@WebServlet("/Login_handler")
public class Login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");
	        PrintWriter pw=response.getWriter();
	        
	        String name= request.getParameter("name");
	        String pass= request.getParameter("pss");
	        
	        if(Login_dao.login(name, pass))
	        {
	        	RequestDispatcher rd=request.getRequestDispatcher("Admin_Welcome.html");
		          rd.forward(request, response);
	        }
	        
	        else {
		    	 pw.print("Username or password wrong!!!");
		    	 RequestDispatcher rd=request.getRequestDispatcher("Admin_Login.html");
		          rd.include(request, response);
		     }
	}

}
