package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Login_bo;

import com_dao.Login_dao;


/**
 * Servlet implementation class Signup_handler
 */
@WebServlet("/Signup_handler")
public class Signup_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_handler() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("mail");
		int pass=Integer.parseInt(request.getParameter("pss"));
		String ph=request.getParameter("phone");
		
		Login_bo lb=new Login_bo();
		
		lb.setName(name);
		lb.setEmail(email);
		lb.setPassword(pass);
		lb.setPhoneNo(ph);
		
		int status=Login_dao.sign_up(lb);
		
		
		if(status>0)
		{
			pw.print("Signup successfully");
			
			RequestDispatcher rd=request.getRequestDispatcher("Admin_Login.html");
			
			rd.forward(request, response);
		}
		
		else
		{
			pw.print("Something went wrong");
			
			RequestDispatcher rd=request.getRequestDispatcher("Sign_Up.html");
			
			rd.include(request, response);
		}
	}

}
