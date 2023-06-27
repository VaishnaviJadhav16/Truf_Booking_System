package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Truf;

import com_dao.Login_dao;


/**
 * Servlet implementation class Update_Truf_controller
 */
@WebServlet("/Update_Truf_controller")
public class Update_Truf_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Truf_controller() {
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
        
       String name= request.getParameter("name");
       String email= request.getParameter("email");
       String location= request.getParameter("location");
       String description= request.getParameter("des");
       
       
       Truf eb=new Truf();
       eb.setId(id);
       eb.setName(name);
       eb.setLocation(location);
       eb.setDescription(description);
       
       
      int status= Login_dao.Update_truf(eb);
      
      if(status>0) {
    	   
    	  RequestDispatcher rd=request.getRequestDispatcher("Truf_View_handler");
    	    rd.forward(request, response);
	}
	}

}
