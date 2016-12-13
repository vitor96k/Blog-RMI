
import static java.lang.Math.floor;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vitor
 */
public class eleitor implements Runnable{    

        Blog k;
        private int id=-1;        
        private int lider=-1;
        int max = 19;
        int min = 2; 
        int auto;
        String hora;
        int diferenca;
        
        List<oraoraSherlock> listatime;
        
        Random rand = new Random();
        int forca = rand.nextInt(max - min + 1) + min;
        
        public int getForca(){
            return forca;
        }
        
         public void setAuto(int a){
            auto = a;
        }
         
        public void setHora(String b){
            hora = b;            
        }    
        
        
        public void souLider(){
            if(id==lider) System.out.println("Voce é o lider");
            else System.out.println("O lider é o processo de numero "+lider);        
        }
    
     public void getId(){
            System.out.println("Voce é o processo de numero "+id + " com forca: "+forca);        
    }
    
        
        eleitor(Blog g){
            k = g;  
            try {
                while(k.getPermitir()==0){
                    
                }
                k.setPermitir(0);
                lider = k.getLider();
                 k.setPermitir(1);
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public int definirId(){
            if(id==-1){
                try {                
                    id = k.definirId();
                } catch (RemoteException ex) {
                    Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return id;
        }
        
        public void printa(){
            try {
                k.printar();
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public int definirLider(){
            try {
                int antigo = lider;
                lider = k.definirLider(id, forca);
                if(antigo!=lider) System.out.println("Um novo lider foi defindo !");
                
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lider;
        }
        
        public void abdicar(){
            try {
                while(k.getPermitir()==0){
                    
                }
                
                 k.setPermitir(0);
                 lider = k.abdicarLideranca(id);               
                 k.setPermitir(1);
                
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void run(){
            
            int antigo;
            
             try {
                while(true){
                    while(k.getPermitir()==1){
                        k.setPermitir(0);
                        antigo = lider;
                        lider = k.eleger();
                        if(antigo!=lider) System.out.println("Um novo lider foi defindo !");
                        if(k.getUpdate()==1) k.setTime(id, qual_a_hora());    
                        if(k.getUpdate()==2){
                            int sada= k.jesus();                            
                            System.out.println("Novo horario: "+secs_to_String(sada));
                        }
                        k.setPermitir(1);
                        TimeUnit.SECONDS.sleep(1);
                    }           
                }
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        
        public int qual_a_hora(){
            int hr = 0;
            String base=""; 
            
            if(auto==1) base =  new SimpleDateFormat("HH:mm:ss").format(new Date());  
            else base = hora;
            
            String[] aux = base.split(":");
            
            String h = aux[0];
            String m = aux[1];
            String s = aux[2];
            
            int hh = Integer.parseInt(h);
            int mm = Integer.parseInt(m);
            int ss = Integer.parseInt(s);
            
            hr = ss + (mm*60) + (hh*60*60);
            //System.out.println("Horario: "+secs_to_String(hr));
            
            return hr;          
            
        }
        
        
       
        
        
        public void updateRelogio(){
            try {
                if(id==lider){
                   
                    k.setUpdate(1);
                    TimeUnit.SECONDS.sleep(1);
                    k.setUpdate(0); 
                    int velho = qual_a_hora();
                    hora = secs_to_String(k.calcularMedia());                    
                    System.out.println("Seu horario: "+secs_to_String(velho)+" Horario calculado: "+secs_to_String(k.calcularMedia())); 
                    k.zerarLista();
                    k.setUpdate(2);
                    TimeUnit.SECONDS.sleep(1);
                    k.setUpdate(0);
                }else System.out.println("Voce n é o lider");    
            } catch (RemoteException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(eleitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public String secs_to_String(int x){
            int total = x;
            int h = (int) floor(x/3600);
            total = total - (3600*h);
            int m = (int) floor(total/60);
            total = total - (60*m);      
            
         
            String ss = "";
            if(h<=9) ss = "0"+Integer.toString(h) + ":";
            else ss = Integer.toString(h)+":";
            if(m<=9) ss = ss + "0"+ Integer.toString(m)+":";
            else ss = ss + Integer.toString(m)+":";
            if(total<=9) ss = ss + "0" + Integer.toString(total);
            else ss = ss +Integer.toString(total);
            
           return ss;
        }
       
        
        
        
        
    
}
