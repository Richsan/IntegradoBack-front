package dadosGovernamentais.model;

public class ConsultaValorOutputBean 
{
    public ConsultaValorOutputBean()
    {
        
    }

    public ConsultaValorOutputBean(String naturezaDespesa, double valor, int mes, int ano) {
        this.naturezaDespesa = naturezaDespesa;
        this.valor = valor;
        this.mes = mes;
        this.ano = ano;
    }
    
    private String naturezaDespesa;
    private double valor;
    private int mes, ano;

    public String getNaturezaDespesa() {
        return naturezaDespesa;
    }

    public void setNaturezaDespesa(String naturezaDespesa) {
        this.naturezaDespesa = naturezaDespesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
