
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateMenuTree {
 Connection con = null;

 String menuTreeString="";
 String intendation="\t";
 CreateMenuTree() throws ClassNotFoundException, SQLException {
  Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://35.154.151.16:3306/hrms", "erpuser", "erpuser");
  
 }
 
 public void createMenuItem(int parentMenuId) throws SQLException{
  ResultSet resultSet0 = con.createStatement().executeQuery("select count(*) from menu_master where parentid="+parentMenuId);
  if(resultSet0.next()){
   if(resultSet0.getInt(1)==0)
   {
    return;
   }
  }
  
  menuTreeString=menuTreeString+"\n<ul>\n";
  ResultSet resultSet = con.createStatement().executeQuery("select * from menu_master where parentid="+parentMenuId);
  while(resultSet.next()){
   menuTreeString=menuTreeString+"\n<li><a href=\"#\">"+resultSet.getString(2)+"</a>";
   int currentMenuId=resultSet.getInt(1);
   createMenuItem(currentMenuId);
   menuTreeString=menuTreeString+"</li>";
  }
  intendation=intendation+"\t";
  menuTreeString=menuTreeString+"\n</ul>\n";
 }
 
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
  CreateMenuTree c=new CreateMenuTree();
  c.createMenuItem(0);
  System.out.println(c.menuTreeString);
 }
}

