package gerenciamento;

public class Pedido{
    private int codigo;
    private String saborPizza;
    private int instante;
    private int tempoPreparo;
    private int tempoTotalProcessamento;


    // Certo!
    public Pedido(int codigo, String saborPizza, int instante, int tempoPreparo){
        this.codigo = codigo;
        this.saborPizza = saborPizza;
        this.instante = instante;
        this.tempoPreparo = tempoPreparo;
        this.tempoTotalProcessamento = 0;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getSaborPizza() {
        return saborPizza;
    }

    public int getInstante(){
        return instante;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    @Override
    public String toString() {
        return "Codigo:" + getCodigo() + ", Sabor: " + getSaborPizza() + ", Instante:" + getInstante() + ", Tempo de preparo:"
                + getTempoPreparo();
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}