package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Manage_turf;
import com_bo.Truf;
import com_dao.Login_dao;

/**
 * Servlet implementation class Edit_Manage_Truf
 */
@WebServlet("/Edit_Manage_Truf")
public class Edit_Manage_Truf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_Manage_Truf() {
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
		
		 
	      String id=request.getParameter("id");
        
	      
	    
	      Manage_turf eb= Login_dao.edit_Managetruf(id);
	  
	    
		 
		pw.print("<form  action='Update_Manage_Truf' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getNo()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Time: </td> <td><input type='text' name='time' value='"+eb.getTime()+"'/></td></tr>");
	   	pw.print("<tr><td>Price : </td> <td><input type='text' name='price' value='"+eb.getPrice()+"'/></td></tr>");
	   	pw.print("<tr><td>Status : </td> <td><input type='text' name='select' value='"+eb.getStatus()+"'/></td></tr>");
	   	
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
