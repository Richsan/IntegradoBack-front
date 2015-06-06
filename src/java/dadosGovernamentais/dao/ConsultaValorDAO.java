package dadosGovernamentais.dao;

import dadosGovernamentais.model.ConsultaValorInputBean;
import dadosGovernamentais.model.ConsultaValorOutputBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConsultaValorDAO 
{
    public ConsultaValorDAO(Connection conn)
    {
        this.conn = conn;
    }
    
    private Connection conn;
    
    public List<ConsultaValorOutputBean> getSearchResult(ConsultaValorInputBean consulta)
    {
        ArrayList<ConsultaValorOutputBean> lista = new ArrayList<ConsultaValorOutputBean>();
        String sqlQuery = "SELECT * FROM ConsultaValor(?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
			stmt = this.conn.prepareStatement(sqlQuery);
                        if(consulta.getPage() != 0)
                            stmt.setInt(1, consulta.getPage());
                        else
                            stmt.setInt(1,1);
                        stmt.setInt(2,7);
                        stmt.setString(3, consulta.getTipoLicitacao());
                        stmt.setString(4, "20[0-1][1-5]");
                        stmt.setString(5, "[0-9][0-9][0-9][0-9].[0-9][0-9]");
			rs = stmt.executeQuery();
                        
                        while(rs.next())
                        {
                            ConsultaValorOutputBean tableRow = new ConsultaValorOutputBean();
                            tableRow.setAno(rs.getInt("data"));
                            tableRow.setMes(rs.getInt("mes"));
                            tableRow.setValor(rs.getDouble("valor"));
                            tableRow.setNaturezaDespesa(rs.getString("descricaonatureza"));
                            
                            lista.add(tableRow);
                            
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
    public int getSerachLines(ConsultaValorInputBean consulta)
    {
         String sqlQuery = "SELECT count(*) AS qtde FROM ConsultaValor(?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int nrows = 0;
        try {
		stmt = this.conn.prepareStatement(sqlQuery);
                stmt.setInt(1, 2);
                stmt.setInt(2, 0);
                stmt.setString(3, consulta.getTipoLicitacao());
                stmt.setString(4, "20[0-1][1-5]");
                stmt.setString(5, "[0-9][0-9][0-9][0-9].[0-9][0-9]");
                rs = stmt.executeQuery();
                if(rs.next())
                {
                  nrows = rs.getInt("qtde");
                            
                }                      
               if(!rs.isClosed())
                  rs.close();
                if(!stmt.isClosed());
                  stmt.close();
                        
                        
	} catch (SQLException e) {
        	throw new RuntimeException(e);
                      
        }
        return nrows;            
    }
}
