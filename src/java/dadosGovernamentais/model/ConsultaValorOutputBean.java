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
    private static String mesNome[] = {"janeiro","Fevereiro", "Março", "Abril",
    "Maio", "Junho", "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};

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
    
    public String getNomeMes()
    {
        return mesNome[mes-1];
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
