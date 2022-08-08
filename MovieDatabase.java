import java.util.*;
import java.lang.*;
import java.sql.*;

public class MovieDatabase 
{
  public void getDetails()
 {
  try
  {

  
Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("java:mysql://localhost:3306/mydb","root","root");
  
  
  PreparedStatement ps=con.prepareStatement("selct * from Movies;");
  
   ResultSet rs=ps.executeQuery();
    ResultSetMetaData rsmd=rs.getMetaData();
  
  
  for(int i=1;i<=rsmd.getColumnCount();i++)
  {
    System.out.println(rsmd.getColumnName(i)+"\t");
  }
 

  while(rs.next())
  {
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
  }
 }
 catch(Exception e)
 {
   System.out.println(e.StackTrace());
 }
 finally
 {
   con.close();
 }

}

}

    