package dadosGovernamentais.dao;

import dadosGovernamentais.model.ConsultaOcorrenciasBean;
import dadosGovernamentais.model.TipoLicitacaoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaOcorrenciasDAO 
{

    public ConsultaOcorrenciasDAO(Connection conn) {
        this.conn = conn;
    }
    
    private Connection conn;
    
    public List<ConsultaOcorrenciasBean> getSearchResult(String licitacao)
    {
        ArrayList<ConsultaOcorrenciasBean> lista = new ArrayList<>();
        String sqlQuery = "SELECT * FROM selecionaDadosComLog(?)";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = this.conn.prepareStatement(sqlQuery);
            stmt.setString(1,licitacao);
            rs = stmt.executeQuery();           
             while(rs.next())
             {
                ConsultaOcorrenciasBean c = new ConsultaOcorrenciasBean();
                c.setNaturezaDespesa(rs.getString("descricaonatureza"));
                c.setOcorrencias(rs.getInt("qtdecodigos"));
                lista.add(c);
                        
              }                     
              if(!rs.isClosed())
                 rs.close();
              if(!stmt.isClosed());
                 stmt.close();
                        
                        
	} catch (SQLException e) {
            throw new RuntimeException(e);
                      
        }
        return lista;
    }
}
