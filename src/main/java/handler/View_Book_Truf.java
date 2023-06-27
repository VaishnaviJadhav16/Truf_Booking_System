package handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Book_Truf;
import com_bo.Manage_turf;
import com_dao.Login_dao;

/**
 * Servlet implementation class View_Book_Truf
 */
@WebServlet("/View_Book_Truf")
public class View_Book_Truf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Book_Truf() {
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
		   
		   
		   pw.print("<a href='User_Welcome.html'>Back Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		   
		   pw.print("<a href='Book_Truf.html' class='btn'>Add New Data</a><br><br>");
		   
		   
		   pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		   pw.print("<centre><div style=\"border: solid 2px; background-color: #2dcaf912;color: #c7b0e3; height: fit-content;width: fit-content;margin-left: 250px;margin-top: 100px;border-radius: 20px;padding: 20px;\">");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr><th> User Name </th> <th> Truf Name </th> <th> Slot Name </th><th> Date </th><th> Price </th></tr>");
		   
		   
		   
		  List<Book_Truf> list= Login_dao.view_BookTruf();
		   
		  for(Book_Truf eb:list) {
			  
			   pw.print("<tr><td>"+eb.getUser_name()+"</td><td>"+eb.getTruf_name()+"</td><td>"+eb.getSlot_name()+"</td><td>"+eb.getDate()+"</td><td>"+eb.getPrice()+"</td></tr>"); 
		  }
		  
		   
		  pw.print("</table>");
	}

}
