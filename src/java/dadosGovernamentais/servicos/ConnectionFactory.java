package dadosGovernamentais.servicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{

    public ConnectionFactory()
    {
        this.createConnection();
    }
    private Connection conn;
    private void createConnection()
    {
        String user = "postgres";
        String password = "manezao29";
        String DBName = "Integrado";
        try
        {
            Class.forName("org.postgresql.Driver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:postgresql:"+"//localhost/"+DBName+"?user=" + 
                    user + "&password=" + password);
            
            
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public void openConnection()
    {
        if(this.conn == null)
            this.createConnection();
        else
            throw new RuntimeException("This Connection had already opened!I won't open it again.");
    }
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public void closeConnection()
    {
        if(this.conn != null)
        {
            
            try{this.conn.close();} catch(Exception e){throw new RuntimeException(e);}
            
            this.conn = null;
        }
        else
        {
            throw new RuntimeException("You're trying close a closed connection, don't do this bro!");
        }
    }
}
