package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Manage_turf;
import com_bo.Truf;
import com_dao.Login_dao;

/**
 * Servlet implementation class Update_Manage_Truf
 */
@WebServlet("/Update_Manage_Truf")
public class Update_Manage_Truf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Manage_Truf() {
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
        
       
       String no=request.getParameter("id"); 
        
       String name= request.getParameter("name");
       String time = request.getParameter("time");
       String price= request.getParameter("price");
       String status= request.getParameter("select");
       
       
      Manage_turf eb=new Manage_turf();
       eb.setNo(no);
       eb.setName(name);
       eb.setTime(time);
       eb.setPrice(price);
       eb.setStatus(status);
       
       
      int sta= Login_dao.Update_Managetruf(eb);
      
      if(sta>0) {
    	   
    	  RequestDispatcher rd=request.getRequestDispatcher("View_manage_Truf");
    	    rd.forward(request, response);
	}
	}

}
