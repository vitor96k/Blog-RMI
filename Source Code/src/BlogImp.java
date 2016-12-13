import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
import java.util.ArrayList;
import java.util.List;
   
public class BlogImp extends UnicastRemoteObject implements Blog{ 

    Banco database = new Banco();
    int id = 0; //ID PARA DESTRIBUIR
    int meuId = 0;
    int idLider = -1;
    int forcaLider = -1;
    int forca = 1;
    int permitir=1;
    int solicitaUpdate = 0; int galera = 0;
    
    int horao=0;
    
    int escrita=0;
    int leitura=0;
    
    
    List<Eleitores> lista = new ArrayList<Eleitores>(); 
    List<oraoraSherlock> listatime = new ArrayList<oraoraSherlock>();
   

    protected BlogImp() throws RemoteException{         
        super();         
    }
    
    public int pegarMedia() throws RemoteException{
        return horao;
    }
    
    public int jesus() throws RemoteException{
        return horao;
    }
    
    public int calcularMedia() throws RemoteException{
         int total = 0;
         int i = 0;
         for(oraoraSherlock x : listatime){
             total = total + x.getHora();
             i++;            
         }
         horao = (total/i) + 1;
         return horao;
        
    }
    
    public int getLider() throws RemoteException{
        return idLider;
    }
    
     public int getEscrita() throws RemoteException{
        return escrita;
    }
     
      public void setEscrita(int a) throws RemoteException{
        escrita = a;
    }
      
       public int getLeitura() throws RemoteException{
        return leitura;
    }
     
      public void setLeitura(int a) throws RemoteException{
        leitura = a;
    }
    
    public void setUpdate(int i) throws RemoteException{
       solicitaUpdate = i;
    }    
    
    public int getUpdate() throws RemoteException{
        return solicitaUpdate;
        
    }
    
    public void setPermitir(int a) throws RemoteException{
       permitir=a;
    }
    
    public int getPermitir() throws RemoteException{
        return permitir;
    }
    
    public void zerarLista()throws RemoteException{
        listatime = new ArrayList<oraoraSherlock>();
    }
     
    
     public void setTime(int id, int time) throws RemoteException{
        
         oraoraSherlock e = new oraoraSherlock();
         e.setHora(time);
         e.setId(id);
         listatime.add(e);       
    } 
     
    public int eleger() throws RemoteException{
        for(Eleitores x : lista){
            if(x.getForca()>forcaLider){
                idLider = x.getId();
                forcaLider = x.getForca();
            }
        }
        
        if(forcaLider==-1){
            idLider = 0;
            forcaLider = forca;
        }
        return idLider;        
    }
    
    public String apresentar() throws RemoteException{
        String help1 = " post(@username,#topic,text)     |  follow(@username,#topic)\n";
	String help4 = " ----------------------------------------------------------------\n";
	String help5 = "\n                          Formato:                     \n";
	String help2 = " unsubscribe(@username,#topic)   |  retrievetime(@username,date)\n";
	String help3 = " retrievetopic(@username,#topic,date)\n";

	String apresenta = "\n        Bem vindo ao Blog RPC, digite quit para sair,\n";
	String apresenta2 = "       caso tenha duvidas digite help para saber mais.\n";

	return (apresenta+apresenta2+help5+help4+help1+help2+help3+help4);
       
    }

     public String postar(String usuario, String topico, String texto) throws RemoteException{
        database.postar(usuario, topico, texto);
     	return "Postado com sucesso !";
     }

      public String seguir(String usuario, String topico) throws RemoteException{
          database.seguir(usuario, topico);
     	return "Voce esta seguindo o topico " + topico;
     }

      public String pararseguir(String usuario, String topico) throws RemoteException{
        database.pararDeseguir(usuario, topico);
     	return "Voce parou de seguir o topico "  + topico;
     }
      
       public List<String> pegarPosts(String usuario, String dia, String mes, String ano) throws RemoteException {
        return database.pegarPosts(usuario, dia, mes, ano);
    }

     
      public List<String> pegarPostsTop(String usuario, String topico, String dia, String mes, String ano) throws RemoteException{
          return database.pegarPostsTopico(usuario, topico, dia, mes, ano);
     }  
      
     public int definirId () throws RemoteException{
         id = id+1;
         return id;           
     }
     
     public int definirLider(int id, int forca) throws RemoteException{
         
         
            Eleitores e = new Eleitores();
            e.setForca(forca);
            e.setId(id);
         
            lista.add(e);
             
         
         return eleger();
     }
     
     public int abdicarLideranca(int id) throws RemoteException{
         int i = 0;
         for(Eleitores a : lista){
             if(a.getId()==id){
                 a.setForca(-1);
                 lista.set(i, a);
                 forcaLider = -1;
             }
             i++;
         }
         
         return eleger();
     }
     
     public void printar() throws RemoteException{
     for(Eleitores a : lista){
             System.out.println("id: "+a.getId()+" - forca: "+a.getForca());
            
         }
     }
     

     
     

    
   
  

     

     
}