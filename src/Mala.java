public class Mala extends Artigo {
    protected String tamanho;
    protected int desconto;
    protected String material;
    protected int anoLancamento;
    protected int valorizacao;

    public Mala(String descricao, String marca, String codigo, double precoBase, int correcaoPreco, int numeroDonos, int estadoUtilizacao, String tamanho, int desconto, String material, int anoLancamento, int valorizacao, boolean usado) {
        super(descricao, marca, codigo, precoBase, correcaoPreco, usado);
        this.tamanho = tamanho;
        this.desconto = desconto;
        this.material = material;
        this.anoLancamento = anoLancamento;
        this.valorizacao = valorizacao;
    }
}