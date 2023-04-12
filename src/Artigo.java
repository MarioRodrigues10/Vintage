public abstract class Artigo {
    protected String descricao;
    protected String marca;
    protected String codigo;
    protected double precoBase;
    protected int correcaoPreco;
    protected boolean usado;

    // TO DO: donos && premium

    public Artigo(String descricao, String marca, String codigo, double precoBase, int correcaoPreco, boolean usado) {
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = codigo;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.usado = usado;
    }
}