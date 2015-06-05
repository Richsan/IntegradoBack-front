package dadosGovernamentais.model;


public class TipoLicitacao
{

       private String descricao;
       private int id;

    public TipoLicitacao(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }
    
    public TipoLicitacao(){}

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }
}
