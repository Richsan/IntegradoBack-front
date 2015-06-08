package dadosGovernamentais.dao;

import dadosGovernamentais.model.ConsultaValorInputBean;
import dadosGovernamentais.model.ConsultaValorOutputBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.python.util.PythonInterpreter;
import org.python.core.*; 


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
                        stmt.setString(4, getAnoRegex(consulta));
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

    public int getSearchLines(ConsultaValorInputBean consulta)
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
                stmt.setString(4, getAnoRegex(consulta));
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
	
	
	
	
	private String getAnoRegex(ConsultaValorInputBean consulta)
	{
		PyObject result = regex_for_rage.__call__(new PyInteger(consulta.getDataInicio()),
												  new PyInteger(consulta.getDataFim()));
		String regEx = (String) result.__tojava__(String.class);
		
		return regEx;
	}
	
	static PythonInterpreter pyInterp = null;
	static PyObject regex_for_rage = null;
	static
	{
		pyInterp = new PythonInterpreter();

		// https://github.com/dimka665/range-regex
		pyInterp.exec(""
			+ "import math\n" +
			"\n" +
			"# coding=utf8\n" +
			"\n" +
			"#  Split range to ranges that has its unique pattern.\n" +
			"#  Example for 12-345:\n" +
			"#\n" +
			"#  12- 19: 1[2-9]\n" +
			"#  20- 99: [2-9]\\d\n" +
			"# 100-299: [1-2]\\d{2}\n" +
			"# 300-339: 3[0-3]\\d\n" +
			"# 340-345: 34[0-5]\n" +
			"\n" +
			"\n" +
			"def bounded_regex_for_range(min_, max_):\n" +
			"    return r'\\b({})\\b'.format(regex_for_range(min_, max_))\n" +
			"\n" +
			"\n" +
			"def regex_for_range(min_, max_):\n" +
			"    \"\"\"\n" +
			"    > regex_for_range(12, 345)\n" +
			"    '1[2-9]|[2-9]\\d|[1-2]\\d{2}|3[0-3]\\d|34[0-5]'\n" +
			"    \"\"\"\n" +
			"    positive_subpatterns = []\n" +
			"    negative_subpatterns = []\n" +
			"\n" +
			"    if min_ < 0:\n" +
			"        min__ = 1\n" +
			"        if max_ < 0:\n" +
			"            min__ = abs(max_)\n" +
			"        max__ = abs(min_)\n" +
			"\n" +
			"        negative_subpatterns = split_to_patterns(min__, max__)\n" +
			"        min_ = 0\n" +
			"\n" +
			"    if max_ >= 0:\n" +
			"        positive_subpatterns = split_to_patterns(min_, max_)    \n" +
			"\n" +
			"    negative_only_subpatterns = ['-' + val for val in negative_subpatterns if val not in positive_subpatterns]\n" +
			"    positive_only_subpatterns = [val for val in positive_subpatterns if val not in negative_subpatterns]\n" +
			"    intersected_subpatterns = ['-?' + val for val in negative_subpatterns if val in positive_subpatterns]\n" +
			"\n" +
			"    subpatterns = negative_only_subpatterns + intersected_subpatterns + positive_only_subpatterns\n" +
			"    return '|'.join(subpatterns)\n" +
			"\n" +
			"\n" +
			"def split_to_patterns(min_, max_):\n" +
			"    subpatterns = []\n" +
			"\n" +
			"    start = min_\n" +
			"    for stop in split_to_ranges(min_, max_):\n" +
			"        subpatterns.append(range_to_pattern(start, stop))\n" +
			"        start = stop + 1\n" +
			"\n" +
			"    return subpatterns\n" +
			"\n" +
			"\n" +
			"def split_to_ranges(min_, max_):\n" +
			"    stops = {max_}\n" +
			"\n" +
			"    nines_count = 1\n" +
			"    stop = fill_by_nines(min_, nines_count)\n" +
			"    while min_ <= stop < max_:\n" +
			"        stops.add(stop)\n" +
			"\n" +
			"        nines_count += 1\n" +
			"        stop = fill_by_nines(min_, nines_count)\n" +
			"\n" +
			"    zeros_count = 1\n" +
			"    stop = fill_by_zeros(max_ + 1, zeros_count) - 1\n" +
			"    while min_ < stop <= max_:\n" +
			"        stops.add(stop)\n" +
			"\n" +
			"        zeros_count += 1\n" +
			"        stop = fill_by_zeros(max_ + 1, zeros_count) - 1\n" +
			"\n" +
			"    stops = list(stops)\n" +
			"    stops.sort()\n" +
			"\n" +
			"    return stops\n" +
			"\n" +
			"\n" +
			"def fill_by_nines(integer, nines_count):\n" +
			"    return int(str(integer)[:-nines_count] + '9' * nines_count)\n" +
			"\n" +
			"\n" +
			"def fill_by_zeros(integer, zeros_count):\n" +
			"    return integer - integer % 10 ** zeros_count\n" +
			"\n" +
			"\n" +
			"def range_to_pattern(start, stop):\n" +
			"    pattern = ''\n" +
			"    any_digit_count = 0\n" +
			"\n" +
			"    for start_digit, stop_digit in zip(str(start), str(stop)):\n" +
			"        if start_digit == stop_digit:\n" +
			"            pattern += start_digit\n" +
			"        elif start_digit != '0' or stop_digit != '9':\n" +
			"            pattern += '[{}-{}]'.format(start_digit, stop_digit)\n" +
			"        else:\n" +
			"            any_digit_count += 1\n" +
			"\n" +
			"    if any_digit_count:\n" +
			"        pattern += r'\\d'\n" +
			"\n" +
			"    if any_digit_count > 1:\n" +
			"        pattern += '{{{}}}'.format(any_digit_count)\n" +
			"\n" +
			"    return pattern");
		// execute a function that takes a string and returns a string
		regex_for_rage = pyInterp.get("regex_for_range");
	}
}
