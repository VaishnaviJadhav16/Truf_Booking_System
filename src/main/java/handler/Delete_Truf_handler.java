package handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_dao.Login_dao;


/**
 * Servlet implementation class Delete_Truf_handler
 */
@WebServlet("/Delete_Truf_handler")
public class Delete_Truf_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Truf_handler() {
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
        
       
		
		 Login_dao.delete_truf(id);
		 
		 response.sendRedirect("Truf_View_handler");
	}

}
