package dadosGovernamentais.dao;

import dadosGovernamentais.model.TipoLicitacaoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoLicitacaoDAO 
{

    public TipoLicitacaoDAO(Connection conn)
    {
        this.conn = conn;
    }
    
    public List<TipoLicitacaoBean> getListaLicitacoes()
    {
        ArrayList<TipoLicitacaoBean> lista = new ArrayList<>();
        String sqlQuery = "SELECT * FROM tipolicitacao";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = this.conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
                        
            while(rs.next())
            {
                TipoLicitacaoBean licitacao = new TipoLicitacaoBean();
                licitacao.setId(rs.getInt("codigo"));
                licitacao.setDescricao(rs.getString("descricao"));
                lista.add(licitacao);
            }
         }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return lista;
    }
    private Connection conn;
}
