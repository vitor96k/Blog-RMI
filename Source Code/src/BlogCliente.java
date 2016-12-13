import static java.lang.Math.floor;
import static java.lang.StrictMath.random;
import java.rmi.Naming; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlogCliente{ 
    
    public static void main(String[] args){
        
        try{ 
            
            
            
            Blog c = (Blog) Naming.lookup("rmi://localhost:1099/CalculatorService"); 
            palavras p = new palavras();
            
            
            
            
           
            String entrada="";
            
            Scanner post = new Scanner (System.in);
            
            System.out.println(c.apresentar());
            
            System.out.print("Usuario: ");            
            Scanner scanner = new Scanner(System. in); 
            String nome = scanner. nextLine();
            
            eleitor e = new eleitor(c);
            
            System.out.print("Horario: ");            
            scanner = new Scanner(System. in); 
            String horario = scanner. nextLine();
            
            if(horario.equals("auto")){
                //String hora =  new SimpleDateFormat("HH:mm:ss").format(new Date());
                e.setAuto(1);
                //System.out.println(hora);                
            }else{              
                e.setAuto(0);
                e.setHora(horario);
            }
            
           
           
            e.definirId();
            e.definirLider();
            
            
            Thread threadEleicao = new Thread(e);
            threadEleicao.start();
            
            
            System.out.println("Logado com sucesso ! ");  
            System.out.println("");
            Scanner scan = new Scanner (System.in);
            System.out.print ("-> ");
            
            entrada = scan.nextLine();
            while (!entrada.equals("quit")){
                
               if(p.achar(entrada)==1){
                   
                   if(c.getEscrita()==1){   //TEM GENTE ESCREVENDO
                       System.out.println("Alguem esta realizando operacao de escrita, aguarde...");
                   }                   
                   while(c.getEscrita()==1){
                       
                   }
                   
                   if(c.getLeitura()==1){
                       System.out.println("Alguem esta realizando operacao de leitura, aguarde...");
                   }                   
                   while(c.getLeitura()==1){
                       
                   }
                   
                   c.setEscrita(1);                  
                    
                   System.out.print("Topico: ");         
                   String topico = post. nextLine();
                   
                   System.out.print("Texto: ");         
                   String texto = post. nextLine();
                   
                  
                   System.out.println(c.postar(nome, topico, texto));  
                   
                  c.setEscrita(0);        
                          
               }else if(p.achar(entrada)==2){
                   
                   System.out.print("Topico: ");         
                   String topico = post. nextLine();                   
                  
                  System.out.println(c.seguir(nome, topico));            
                          
                                     
               }else if(p.achar(entrada)==3){
                   
                   System.out.println("Topico: ");         
                   String topico = post. nextLine();                   
                  
                   System.out.println(c.pararseguir(nome, topico));     
                                   
               }else if(p.achar(entrada)==4){
                   
                    if(c.getEscrita()==1){
                       System.out.println("Alguem esta realizando operacao de escrita, aguarde...");
                   }
                   
                   while(c.getEscrita()==1){
                       
                   }
                   
                   c.setLeitura(1);
                                    
                   System.out.print("Dia: ");         
                   String dia = post. nextLine(); 
                   
                   System.out.print("Mes: ");         
                   String mes = post. nextLine(); 
                   
                   System.out.print("Ano: ");         
                   String ano = post. nextLine();                    
                 
                   List<String> lista = c.pegarPosts(nome, dia, mes, ano);
                   
                   
                   
                   System.out.println("---------------------------------------------");
                   System.out.println("");
                    for(int i = 0; i < lista.size();) {
                        System.out.println("Usuario: "+lista.get(i)+" - Topico: "+ lista.get(i+1) + " - "+ p.getData(lista.get(i+3)));
                        System.out.println("Texto: "+lista.get(i+2));
                        System.out.println("---------------------------------------------");                   
                        i=i+4;                           
                    } 
                    
                    c.setLeitura(0);
                    
                    System.out.println("");
                    
                    
               }else if(p.achar(entrada)==5){
                   
                   if(c.getEscrita()==1){
                       System.out.println("Alguem esta realizando operacao de escrita, aguarde...");
                   }
                   
                   while(c.getEscrita()==1){
                       
                   }
                   
                   c.setLeitura(1);
                   
                   System.out.print("Topico: ");         
                   String topi = post. nextLine(); 
                   
                   System.out.print("Dia: ");         
                   String dia = post. nextLine(); 
                   
                   System.out.print("Mes: ");         
                   String mes = post. nextLine(); 
                   
                   System.out.print("Ano: ");         
                   String ano = post. nextLine();                    
                 
                   List<String> lista = c.pegarPostsTop(nome,topi, dia, mes, ano);
                  
                   System.out.println("\n\nPosts:\n");
                   System.out.println("---------------------------------------------");
                   System.out.println("");
                    for(int i = 0; i < lista.size();) {
                        System.out.println("Usuario: "+lista.get(i)+" - Topico: "+ lista.get(i+1) + " - "+ p.getData(lista.get(i+3)));
                        System.out.println("Texto: "+lista.get(i+2));
                        System.out.println("---------------------------------------------");                   
                        i=i+4;                           
                    }  
                    
                    c.setLeitura(0);
                    
                    System.out.println("");
                                      
               }else if(p.achar(entrada)==6){
                  System.out.println(p.ajudar());
               }else if(p.achar(entrada)==7){
                   e.getId();
                   e.souLider();
                   e.printa();
                                  
               }else if(p.achar(entrada)==8){
                   e.abdicar();
                   
               }else if(p.achar(entrada)==9){
                   e.updateRelogio();                   
                   
               }else System.out.println("Comando Invalido"); 
                
                
                System.out.print("-> ");
                entrada = scan.nextLine();
          }
            
            
                    
         
           
        }catch (Exception e){ 
            System.out.println(e); 
        } 
    } 
}