import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banco{

   private Connection c = null;
   private Statement stmt = null;  


   Banco(){      

      try{
         
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetormi", "user1", "user1");
         c.setAutoCommit(false);
         System.out.println("Conectado ao Banco");  
      } catch (Exception e) {
          System.out.println("Erro ao conectar ao banco"); 
          System.err.println( e.getClass().getName()+": "+ e.getMessage() ); 
         
      }    
   }

   public void postar(String usuario, String topico, String texto) {

       try {
           stmt = c.createStatement();
           String banco_inserir_post = "insert into posts3 (usuario,topico,texto) values ('"+usuario+"','"+topico+"','"+texto+"')";
           stmt.executeUpdate(banco_inserir_post);
           
           stmt.close();
           c.commit();
           
       } catch (SQLException ex) {
           Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void seguir(String usuario, String topico) {

       try {
           stmt = c.createStatement();
           String sql = "insert into follow (usuario,topico) values ('"+usuario+"','"+topico+"')";
           stmt.executeUpdate(sql);
           
           stmt.close();
           c.commit();
          
       } catch (SQLException ex) {
           Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void pararDeseguir(String usuario, String topico) {

       try {
           stmt = c.createStatement();
           String sql = "delete from follow where usuario = '" + usuario + "' and topico='"+topico+"'";
           stmt.executeUpdate(sql);
           
           stmt.close();
           c.commit();
          
       } catch (SQLException ex) {
           Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public  List<String>  pegarPosts(String usuario, String dia, String mes, String ano) {
       
       List<String> lista = new ArrayList<String>();
       
       String data = "'" + ano+"-"+mes+"-"+dia+"'";
       String user = "'"+usuario+"'";
       
       String us = "";
       String top = "";
       String texto  = "";
       String hr = "";
       try {
           stmt = c.createStatement();
           String sql = "select usuario,topico,texto,datahora from posts3 where datahora >= "+ data+" and topico in ( select topico from follow where usuario = "+user+")";
           
           ResultSet rs = stmt.executeQuery(sql);
           
            while ( rs.next() ){
                
                 lista.add(rs.getString("usuario"));
                 lista.add(rs.getString("topico"));
                 lista.add(rs.getString("texto")); 
                 lista.add(rs.getTimestamp("datahora").toString());   
                
                
         }
           
           stmt.close();
           c.commit();
           rs.close();
          
       } catch (SQLException ex) {
           Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return lista;
   }
   
   public  List<String>  pegarPostsTopico(String usuario, String topico, String dia, String mes, String ano) {
       
       List<String> lista = new ArrayList<String>();
       
       String data = "'" + ano+"-"+mes+"-"+dia+"'";
       String user = "'"+usuario+"'";
       String top2 = "'"+topico+"'";
       
       
       String us = "";
       String top = "";
       String texto  = "";
       String hr = "";
       try {
           stmt = c.createStatement();
           String sql = "select usuario,topico,texto,datahora from posts3 where datahora >= "+ data+" and topico in ( select topico from follow where usuario = "+user+")" +" and topico = " + top2;
           
           ResultSet rs = stmt.executeQuery(sql);
           
            while ( rs.next() ){
                
                 lista.add(rs.getString("usuario"));
                 lista.add(rs.getString("topico"));
                 lista.add(rs.getString("texto")); 
                 lista.add(rs.getTimestamp("datahora").toString());   
                
                
         }
           
           stmt.close();
           c.commit();
           rs.close();
          
       } catch (SQLException ex) {
           Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return lista;
   }
   
   
   
   
    
   
}