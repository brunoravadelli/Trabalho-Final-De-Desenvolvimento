package smartconsertos;

/**
 *
 * @author Bruno Ravadelli
 */
public class Tablet {
    
    private int id;
    private String nome;
    private Marca marca;
    private double valor;

    public Tablet() {
    }

    public Tablet(int id, String nome, Marca marca, double valor) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
