package com_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com_bo.Book_Truf;
import com_bo.Login_bo;
import com_bo.Manage_turf;
import com_bo.Truf;



public class Login_dao {
	
	public static Connection connect()
	{
		Connection cn=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/truf_booking?useSSL=false&allowPublicKeyRetrieval=true";
			String un="root";
			String pss="Pass@123";
			
			cn=DriverManager.getConnection(url, un, pss);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return cn;
	}
	
	public static int sign_up(Login_bo lb)
	{
		int status=0;
		
		try
		{
			Connection cn=Login_dao.connect();
			
			String query="insert into admin_login(name,email,pasword,phoneNo,address) values (?,?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(query);
			
			ps.setString(1, lb.getName());
			ps.setString(2, lb.getEmail());
			ps.setInt(3, lb.getPassword());
			ps.setString(4, lb.getPhoneNo());
			ps.setString(5, lb.getAddress());
			
			status= ps.executeUpdate();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
		
	}
	
	
	
	public static int user_sign_up(Login_bo lb)
	{
		int status=0;
		
		try
		{
			Connection cn=Login_dao.connect();
			
			String query="insert into user_login(name,email,password,phoneNo,address) values (?,?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(query);
			
			ps.setString(1, lb.getName());
			ps.setString(2, lb.getEmail());
			ps.setInt(3, lb.getPassword());
			ps.setString(4, lb.getPhoneNo());
			ps.setString(5, lb.getAddress());
			
			status= ps.executeUpdate();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public static boolean login(String name,String pass)
	{
		 boolean status=false;
		   
	     try {
			
	    	Connection con=Login_dao.connect();
	    	
	    	String sql="select *from admin_login where name=? And pasword=?"; 
	    	
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	
	    	ps.setString(1, name);
	    	ps.setString(2, pass);
	    	
	    	ResultSet rs=ps.executeQuery();
	    	status=rs.next();
	    	 
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
	
	     return status;
	}
	
	public static boolean user_login(String name,String pass)
	{
		 boolean status=false;
		   
	     try {
			
	    	Connection con=Login_dao.connect();
	    	
	    	String sql="select *from user_login where name=? And password=?"; 
	    	
	    	PreparedStatement ps=con.prepareStatement(sql);
	    	
	    	ps.setString(1, name);
	    	ps.setString(2, pass);
	    	
	    	ResultSet rs=ps.executeQuery();
	    	status=rs.next();
	    	 
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
	
	     return status;
	}
	
	public static List view_user( ) {
		   
        List<Login_bo> list= new ArrayList<>();
  try {
	    Connection con=Login_dao.connect();
        PreparedStatement ps=con.prepareStatement("select * from user_login");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()) {
        	Login_bo eb=new Login_bo();
        	
        	
        	eb.setName(rs.getString(1));
        	eb.setEmail(rs.getString(2));
        	eb.setPassword(rs.getInt(3));
        	eb.setPhoneNo(rs.getString(4));
        	eb.setAddress(rs.getString(5));
        	
        	
        	
            list.add(eb);
        	
        }
	  
} catch (Exception e) {
	System.out.println(e);
}
   
   return list;
   
}
	
	
	public static int add_truf(Truf t)
	{
		int status=0;
		
		try
		{
			Connection cn=Login_dao.connect();
			
			String query="insert into truf(id,name,location,description) values (?,?,?,?)";
			
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getLocation());
			ps.setString(4, t.getDescription());
			
			
			status= ps.executeUpdate();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	public static List view_truf( ) {
		   
        List<Truf> list= new ArrayList<Truf>();
  try {
	    Connection con=Login_dao.connect();
        PreparedStatement ps=con.prepareStatement("select * from truf");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()) {
        	Truf eb=new Truf();
        	
        	eb.setId(rs.getString(1));
        	eb.setName(rs.getString(2));
        	eb.setLocation(rs.getString(3));
        	eb.setDescription(rs.getString(4));
        	
        	
            list.add(eb);
        	
        }
	  
} catch (Exception e) {
	System.out.println(e);
}
   
   return list;
   
}
	
public static int delete_truf(String id) {
		
		int status=0;
		  try {
		
			  Connection con=Login_dao.connect();
			  
			  String query="delete from truf where id=?";
			  
			  PreparedStatement ps=con.prepareStatement(query);
			  
			  ps.setString(1, id);
			  
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}

public static Truf edit_truf(String id) {
	 
	Truf eb=new Truf();
	 
	 try
	 {
		 Connection cn=Login_dao.connect();
		 
		 String query="select * from truf where id=?";
		 
		 PreparedStatement ps=cn.prepareStatement(query);
		 
		 ps.setString(1, id);
		 
		 ResultSet rs=ps.executeQuery();
		 
		 if(rs.next())
		 {
			 eb.setId(rs.getString(1));
	        	eb.setName(rs.getString(2));
	        	eb.setLocation(rs.getString(3));
	        	eb.setDescription(rs.getString(4));
		 }
	 }
	 
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
		   
		   
	return eb;	   
	
}




public static int Update_truf(Truf eb) {
	 int status=0;
	 
	 try {
		
		 Connection con=Login_dao.connect();
		 
		 String query="update truf set name=?, location=?, description=? where id=?";
		 PreparedStatement ps=con.prepareStatement(query);
		 
		 ps.setString(1, eb.getId());
		
		 ps.setString(2, eb.getName());
        ps.setString(3, eb.getLocation());
        ps.setString(4, eb.getDescription());
        
		 
        status=ps.executeUpdate();
        
        
        
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
	 
	 
	 return status;
}



public static int manage_truf(Manage_turf t)
{
	int status=0;
	
	try
	{
		Connection cn=Login_dao.connect();
		
		String query="insert into manage_truf(no,turf_name,time,price,status) values (?,?,?,?,?)";
		
		PreparedStatement ps=cn.prepareStatement(query);
		ps.setString(1, t.getNo());
		ps.setString(2, t.getName());
		ps.setString(3, t.getTime());
		ps.setString(4, t.getPrice());
		ps.setString(5,t.getStatus());
		
		
		status= ps.executeUpdate();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return status;
}



public static List view_Managetruf( ) {
	   
    List<Manage_turf> list= new ArrayList<>();
try {
    Connection con=Login_dao.connect();
    PreparedStatement ps=con.prepareStatement("select * from manage_truf");
    ResultSet rs=ps.executeQuery();
    
    while(rs.next()) {
    	Manage_turf eb=new Manage_turf();
    	
    	eb.setNo(rs.getString(1));
    	eb.setName(rs.getString(2));
    	eb.setTime(rs.getString(3));
    	eb.setPrice(rs.getString(4));
    	eb.setStatus(rs.getString(5));
    	
    	
        list.add(eb);
    	
    }
  
} catch (Exception e) {
System.out.println(e);
}

return list;

}

public static int delete_Managetruf(String id) {
	
	int status=0;
	  try {
	
		  Connection con=Login_dao.connect();
		  
		  String query="delete from manage_truf where no=?";
		  
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  ps.setString(1, id);
		  
		  status=ps.executeUpdate();
		  
	} catch (Exception e) {
	
		   System.out.println(e);
	}
	
	return status;
	
}

public static Manage_turf edit_Managetruf(String id) {
 
Manage_turf eb=new Manage_turf();
 
 try
 {
	 Connection cn=Login_dao.connect();
	 
	 String query="select * from truf where no=?";
	 
	 PreparedStatement ps=cn.prepareStatement(query);
	 
	 ps.setString(1, id);
	 
	 ResultSet rs=ps.executeQuery();
	 
	 if(rs.next())
	 {
		 eb.setNo(rs.getString(1));
        	eb.setName(rs.getString(2));
        	eb.setTime(rs.getString(3));
        	eb.setPrice(rs.getString(4));
        	eb.setStatus(rs.getString(5));
	 }
 }
 
 catch(Exception e)
 {
	 System.out.println(e);
 }
	   
	   
return eb;	   

}




public static int Update_Managetruf(Manage_turf eb) {
 int status=0;
 
 try {
	
	 Connection con=Login_dao.connect();
	 
	 String query="update manage_truf set turf_name=?, time=?, price=? ,status=? where no=?";
	 PreparedStatement ps=con.prepareStatement(query);
	 
	 ps.setString(1, eb.getNo());
	
	 ps.setString(2, eb.getName());
    ps.setString(3, eb.getTime());
    ps.setString(4, eb.getPrice());
    ps.setString(5, eb.getStatus());
    
	 
    status=ps.executeUpdate();
    
    
    
} catch (Exception e) {
	
	System.out.println(e);
	
}
 
 
 return status;
}

public static int book_truf(Book_Truf t)
{
	int status=0;
	
	try
	{
		Connection cn=Login_dao.connect();
		
		String query="insert into book_truf(user_name,truf_name,slot,date,price) values (?,?,?,?,?)";
		
		PreparedStatement ps=cn.prepareStatement(query);
		ps.setString(1, t.getUser_name());
		ps.setString(2, t.getTruf_name());
		ps.setString(3, t.getSlot_name());
		ps.setString(4,t.getDate());
		ps.setString(5, t.getPrice());
		
		
		status= ps.executeUpdate();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return status;
}

public static List view_BookTrufPerson( ) {
	   
    List<Book_Truf> list= new ArrayList<Book_Truf>();
try {
    Connection con=Login_dao.connect();
    PreparedStatement ps=con.prepareStatement("select * from book_truf where user_name=?");
    ResultSet rs=ps.executeQuery();
    
    while(rs.next()) {
    	Book_Truf eb=new Book_Truf();
    	
    	eb.setUser_name(rs.getString(1));
    	eb.setTruf_name(rs.getString(2));
    	eb.setSlot_name(rs.getString(3));
    	eb.setDate(rs.getString(4));
    	eb.setPrice(rs.getString(5));
    	
    	
        list.add(eb);
    	
    }
  
} catch (Exception e) {
System.out.println(e);
}

return list;

}


public static List view_BookTruf( ) {
	   
    List<Book_Truf> list= new ArrayList<Book_Truf>();
try {
    Connection con=Login_dao.connect();
    PreparedStatement ps=con.prepareStatement("select * from book_truf");
    ResultSet rs=ps.executeQuery();
    
    while(rs.next()) {
    	Book_Truf eb=new Book_Truf();
    	
    	eb.setUser_name(rs.getString(1));
    	eb.setTruf_name(rs.getString(2));
    	eb.setSlot_name(rs.getString(3));
    	eb.setDate(rs.getString(4));
    	eb.setPrice(rs.getString(5));
    	
    	
        list.add(eb);
    	
    }
  
} catch (Exception e) {
System.out.println(e);
}

return list;

}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
