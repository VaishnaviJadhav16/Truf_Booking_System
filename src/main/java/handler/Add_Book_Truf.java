package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_bo.Book_Truf;
import com_bo.Manage_turf;
import com_dao.Login_dao;

/**
 * Servlet implementation class Add_Book_Truf
 */
@WebServlet("/Add_Book_Truf")
public class Add_Book_Truf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Book_Truf() {
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
	    
	    String user_name=request.getParameter("na");
	    String truf_name=request.getParameter("name");
	     String slot_name=request.getParameter("slot");
	     String date=request.getParameter("date");
	     String price=request.getParameter("price");
	     
	     
	     
	   
	     
	     Book_Truf ab=new Book_Truf(user_name,truf_name, slot_name, date,price);
	     
	    int sta= Login_dao.book_truf(ab);
	    
	    if(sta>0) {
	    	
	    	
	    	pw.print("Truf Manage successfully!!!");
	    	 RequestDispatcher rd=request.getRequestDispatcher("View_Book_Truf");
	    	 rd.forward(request, response);
	    	
	    }else {
	    	pw.print("Something went wrong!!!");
	    	RequestDispatcher rd=request.getRequestDispatcher("Add_Book_Truf");
	    	 rd.include(request, response);
	    }
		
		
	}

}
