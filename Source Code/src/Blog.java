import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.List;
   
public interface Blog extends Remote{ 
    
    public String apresentar() throws RemoteException;
    public String postar(String usuario, String topico, String texto) throws RemoteException; 
    public String seguir(String usuario, String topico) throws RemoteException;
    public String pararseguir(String usuario, String topico) throws RemoteException;
    public List<String> pegarPosts(String usuario, String dia, String mes, String ano) throws RemoteException;   
    public List<String> pegarPostsTop(String usuario, String topico, String dia, String mes, String ano) throws RemoteException;
    public int definirId () throws RemoteException;
    public int definirLider(int id, int forca) throws RemoteException;
    public int abdicarLideranca(int id) throws RemoteException;
    public void setPermitir(int a) throws RemoteException;
    public int getPermitir() throws RemoteException;
    public int getLider() throws RemoteException;
    public void printar() throws RemoteException;
    public int eleger() throws RemoteException;
    public void setTime(int id, int time) throws RemoteException;
    
    public void setUpdate(int i) throws RemoteException;
    public int getUpdate() throws RemoteException;
    public int calcularMedia() throws RemoteException;
    public void zerarLista()throws RemoteException;
    public int pegarMedia() throws RemoteException;
    public int getEscrita() throws RemoteException;
    public void setEscrita(int a) throws RemoteException;
    public int getLeitura() throws RemoteException;
    public void setLeitura(int a) throws RemoteException;
    
    public int jesus() throws RemoteException;
   
    
}