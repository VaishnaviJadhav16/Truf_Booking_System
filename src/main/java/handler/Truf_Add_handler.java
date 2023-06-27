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
 * Servlet implementation class Truf_Add_handler
 */
@WebServlet("/Truf_Add_handler")
public class Truf_Add_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Truf_Add_handler() {
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
	     String name=request.getParameter("name");
	     String location=request.getParameter("location");
	     String description=request.getParameter("des");
	     
	     
	   
	     
	     Truf ab=new Truf(id,name, location, description);
	     
	    int status= Login_dao.add_truf(ab);
	    
	    if(status>0) {
	    	
	    	
	    	pw.print("Truf inserted successfully!!!");
	    	 RequestDispatcher rd=request.getRequestDispatcher("View_Book_Truf");
	    	 rd.forward(request, response);
	    	
	    }else {
	    	pw.print("Something went wrong!!!");
	    	RequestDispatcher rd=request.getRequestDispatcher("Insert_Truf.html");
	    	 rd.include(request, response);
	    }
	}

}
