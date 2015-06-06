package dadosGovernamentais.model;


public class TipoLicitacaoBean
{

       private String descricao;
       private int id;

    public TipoLicitacaoBean(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }
    
    public TipoLicitacaoBean(){}

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
