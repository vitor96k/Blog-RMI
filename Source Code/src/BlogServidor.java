import java.rmi.Naming; 
import java.rmi.registry.LocateRegistry;


   
public class BlogServidor{ 
    BlogServidor(){ 
        try{ 
            //NOVO
            Blog k = new BlogImp();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://191.52.64.141:1099/CalculatorService", k);
            
            /* VELHO
            Blog c = new BlogImp();           
            Naming.rebind("//localhost:1099/CalculatorService", c); 
            */
        }catch (Exception e){ 
            e.printStackTrace(); 
        } 
    }

    public static void main(String[] args){        
        new BlogServidor(); 
    } 
}  