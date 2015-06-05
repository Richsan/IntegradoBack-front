package dadosGovernamentais.dao;

import dadosGovernamentais.model.TipoLicitacao;
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
    
    public List<TipoLicitacao> getListaLicitacoes()
    {
        ArrayList<TipoLicitacao> lista = new ArrayList<>();
        String sqlQuery = "SELECT * FROM tipolicitacao";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            stmt = this.conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
                        
            while(rs.next())
            {
                TipoLicitacao licitacao = new TipoLicitacao();
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
