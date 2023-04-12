public class Tshirt extends Artigo{
    protected String tamanho;
    protected String padrao;

    public Tshirt(String tamanho , String padrao , String descricao , String marca , String codigo , double precoBase , int correcaoPreco , int numeroDonos , int estadoUtilizacao , boolean usado){
        super(descricao , marca , codigo , precoBase , correcaoPreco, usado);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }
}