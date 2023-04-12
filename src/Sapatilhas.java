public class Sapatilhas extends Artigo {
    protected float tamanho;
    protected boolean temAtacadores;
    protected String cor;
    protected int anoLancamento;
    public Sapatilhas(String descricao, String marca, String codigo, double precoBase, int correcaoPreco, int numeroDonos, int estadoUtilizacao, float tamanho, boolean temAtacadores, String cor, int anoLancamento, boolean usado) {
        super(descricao, marca, codigo, precoBase, correcaoPreco, usado);
        this.tamanho = tamanho;
        this.temAtacadores = temAtacadores;
        this.cor = cor;
        this.anoLancamento = anoLancamento;
    }
}