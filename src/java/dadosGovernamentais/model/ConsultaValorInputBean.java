package dadosGovernamentais.model;

import java.text.DecimalFormat;
import java.util.Calendar;


public class ConsultaValorInputBean
{


    public ConsultaValorInputBean(String tipoLicitacao, Double valorMin,
            Double valorMax, Integer dataInicio, Integer dataFim) {
        this.tipoLicitacao = tipoLicitacao;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.page = 0;
    }
    public ConsultaValorInputBean()
    {
        this.valorMin = null;
        this.valorMax = null;
        this.dataInicio = null;
        this.dataFim = null;
        this.tipoLicitacao = "";
    }
    private Integer  page;
    private Double valorMin, valorMax;
    private Integer dataInicio, dataFim;
    private String tipoLicitacao;

   
    public String getTipoLicitacao() {
        return tipoLicitacao;
    }

    
    public void setTipoLicitacao(String tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }

   
    public Double getValorMin() {
        return valorMin;
    }
    
    public String getValorMinString()
    {       
        if(this.valorMin != null)
        {
            DecimalFormat df = new DecimalFormat("#.00");
            return "R$ " + df.format(this.valorMin);
        }
        else
            return null;
    }

    
    public void setValorMin(Double valorMin) {
        this.valorMin = valorMin;
    }

    public Double getValorMax() {
        return valorMax;
    }
    
        public String getValorMaxString()
    {       
        if(this.valorMax != null)
        {
            DecimalFormat df = new DecimalFormat("#.00");
            return "R$ " + df.format(this.valorMax);
        }
        else
            return null;
    }

 
    public void setValorMax(Double valorMax) {
        this.valorMax = valorMax;
    }

    public Integer getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Integer dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDataFim() {
        return dataFim;
    }

   
    public void setDataFim(Integer dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        if(this.page == null)
            return 0;
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }
    
}
