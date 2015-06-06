package dadosGovernamentais.model;

import java.text.DecimalFormat;
import java.util.Calendar;


public class ConsultaValorInputBean
{

    public ConsultaValorInputBean(String tipoLicitacao, Double valorMin,
            Double valorMax, Calendar dtInicio, Calendar dtFim) {
        this.tipoLicitacao = tipoLicitacao;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.page = 0;
    }
    public ConsultaValorInputBean()
    {
        this.valorMin = null;
        this.valorMax = null;
        this.dtInicio = null;
        this.dtFim = null;
        this.tipoLicitacao = "";
    }
    private Integer  page;
    private Double valorMin, valorMax;
    private Calendar dtInicio, dtFim;
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

    public Calendar getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Calendar dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Calendar getDtFim() {
        return dtFim;
    }

   
    public void setDtFim(Calendar dtFim) {
        this.dtFim = dtFim;
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
