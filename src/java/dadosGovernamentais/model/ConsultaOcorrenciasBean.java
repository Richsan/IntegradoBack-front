package dadosGovernamentais.model;

public class ConsultaOcorrenciasBean {

    public ConsultaOcorrenciasBean(String naturezaDespesa, int ocorrencias) {
        this.naturezaDespesa = naturezaDespesa;
        this.ocorrencias = ocorrencias;
    }

    public ConsultaOcorrenciasBean() {
    }

    private String naturezaDespesa;
    private int ocorrencias;

    public String getNaturezaDespesa() {
        return naturezaDespesa;
    }

    public void setNaturezaDespesa(String naturezaDespesa) {
        this.naturezaDespesa = naturezaDespesa;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
    
}
