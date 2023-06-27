package handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Manage_turf;
import com_bo.Truf;
import com_dao.Login_dao;

/**
 * Servlet implementation class View_manage_Truf
 */
@WebServlet("/View_manage_Truf")
public class View_manage_Truf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_manage_Truf() {
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
		   
		   
		   pw.print("<a href='Admin_Welcome.html'>Back Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		   
		   pw.print("<a href='Insert.html' class='btn'>Add New Data</a><br><br>");
		   
		   
		   pw.print("<body style=\"background-color: rgb(229 208 217 / 18%); backdrop-filter: blur(1px);\">");
		   pw.print("<centre><div style=\"border: solid 2px; background-color: #2dcaf912;color: #c7b0e3; height: fit-content;width: fit-content;margin-left: 250px;margin-top: 100px;border-radius: 20px;padding: 20px;\">");
		   
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr><th> No </th> <th> Name </th> <th> Time </th><th> Price </th><th> Status </th><th>Delete </th><th> Edit </th></tr>");
		   
		   
		   
		  List<Manage_turf> list= Login_dao.view_Managetruf();
		   
		  for(Manage_turf eb:list) {
			  
			   pw.print("<tr><td>"+eb.getNo()+"</td><td>"+eb.getName()+"</td><td>"+eb.getTime()+"</td><td>"+eb.getPrice()+"</td><td>"+eb.getStatus()+"</td><td><a href='Delete_Manage_Truf?id="+eb.getNo()+"'>delete </a></td><td><a href ='Edit_Manage_Truf?id="+eb.getNo()+"'>edit </a></td></tr>"); 
		  }
		  
		   
		  pw.print("</table>");
	}

}
