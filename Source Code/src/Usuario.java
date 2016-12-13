
import java.io.Serializable;

public class Usuario implements Serializable {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the topico
     */
    public String getTopico() {
        return topico;
    }

    /**
     * @param topico the topico to set
     */
    public void setTopico(String topico) {
        this.topico = topico;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    
    private String nome;
    private String topico;
    private String texto;
    private String data;
    
}
