import java.sql.*;

public class Connexion {
    
private Connection con=null;
private Statement stm=null;
private ResultSet RS=null;

public Connexion(String server, String db_name, String user, String password){
try{
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Chargement du driver avec réussite .....");
con=DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db_name,user,password);
System.out.println("Connexion OK .....");
}catch(Exception ex){
System.out.println(ex.getMessage());
}
}

public int IUD(String sql){
try{
stm=con.createStatement();
return stm.executeUpdate(sql);
}catch(Exception ex){
System.out.println(ex.getMessage());
}

return 0;
}

public ResultSet Select(String sql){
try{
stm=con.createStatement();
return stm.executeQuery(sql);
}catch(Exception ex){
System.out.println(ex.getMessage());
}
return null;
}

public void Fermeture_espaces()
{
  if(con!=null)
  {
   try{
   con.close();
   con=null;
   }catch(Exception ex){
     System.out.println(ex.getMessage());
   }
  }
  
 if(stm!=null)
  {
   try{
   stm.close();
   stm=null;
   }catch(Exception ex){
     System.out.println(ex.getMessage());
   }
  }
    
  if(RS!=null)
  {
   try{
   RS.close();
   RS=null;
   }catch(Exception ex){
     System.out.println(ex.getMessage());
   }
  }
  
}

}
