package handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Login_bo;

import com_dao.Login_dao;


/**
 * Servlet implementation class User_view_handler
 */
@WebServlet("/User_view_handler")
public class User_view_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_view_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   
		   pw.print("<a href='Admin_Welcome.html'>Back Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		   
		   pw.print("<a href='Insert.html' class='btn'>Add New Data</a><br><br>");
		   
		   
		   pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		   pw.print("<centre><div style=\"border: solid 2px; background-color: #2dcaf912;color: #c7b0e3; height: fit-content;width: fit-content;margin-left: 250px;margin-top: 100px;border-radius: 20px;padding: 20px;\">");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Name </th> <th> Email </th> <th> Phone No </th> <th> Phone </th> <th> Address</th></tr>");
		   
		   
		   
		  List<Login_bo> list= Login_dao.view_user();
		   
		  for(Login_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhoneNo()+"</td><td>"+eb.getAddress()+"</td></tr>"); 
		  }
		  
		   
		  pw.print("</table>");
	}

}
