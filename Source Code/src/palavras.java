/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vitor
 */
public class palavras {
    
    public String getNome(String a){
        
        int indice = 5;        
        String aux="";
        
        while(a.charAt(indice)!=','){
            aux = aux+a.charAt(indice);
            indice++;
        } 
        
        return aux;        
    }
    
    public String getTopico(String a){
        
        int indice = 5;        
        String aux="";
        
        while(a.charAt(indice)!=','){            
            indice++;
        } 
        
        indice++;
        
        while(a.charAt(indice)!=','){      
            aux = aux+a.charAt(indice);
            indice++;
        }
        
        return aux;
        
              
    }
    
    
    
    public int achar(String texto){
        
       	if (texto.indexOf("post") >=0) return 1;
	if ( texto.indexOf("follow") >=0 ) return 2;
	if ( texto.indexOf("unsubscribe") >=0 ) return 3;
	if ( texto.indexOf("retrievetime") >=0 ) return 4;
	if ( texto.indexOf("retrievetopic") >=0 ) return 5;
	if ( texto.indexOf("help")>=0) return 6;
        if ( texto.indexOf("info")>=0) return 7;
        if ( texto.indexOf("abdicar")>=0) return 8;
        if ( texto.indexOf("setTime")>=0) return 9;
        
	else return 0;        
    }
    
    public String ajudar(){
        
        String help1 = " post(@username,#topic,text)     |  follow(@username,#topic)\n";
	String help4 = " ----------------------------------------------------------------\n";
	String help5 = "\n                          Formato:                     \n";
	String help2 = " unsubscribe(@username,#topic)   |  retrievetime(@username,date)\n";
	String help3 = " retrievetopic(@username,#topic,date)\n";

	String posta = "\n Post: Voce postar sobre um determinado topico e os\n outros usuarios que seguem esse topico podem ver";
	String segui = "\n Follow: Ao seguir um determinado topico voce podera\n ver todos os posts relacionada a esse topico\n";
	String unsegui = "\n Unsubscribe: Voce para de seguir determinado topico\n";
	String retri = "\n Retrieve Time: Voce pode ver todos os posts feitos\n a partir da data informada dos topicos que segue\n";
	String retrit = "\n Retrieve Topic: Voce pode ver todos os posts feitos de\n determinado topico a partir da data informada\n";
       
	

	return (help5+help4+help1+help2+help3+help4+posta+"\n"+segui+unsegui+retri+retrit);
    }
    
    public String getData(String data){
       
        String ano = ""+data.charAt(0)+data.charAt(1)+data.charAt(2)+data.charAt(3);
        String mes = ""+data.charAt(5)+data.charAt(6);
        String dia = ""+data.charAt(8)+data.charAt(9);
        
        String aux = dia+"/"+mes+"/"+ano;
        
        
        return aux;
    }
    
    public void limpar(){
        String ESC = "\033[";
        System.out.print(ESC + "2J"); 
    }
    
}
