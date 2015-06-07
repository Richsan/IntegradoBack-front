# IntegradoBack-front
Trabalho integrado para curso de Laboratorio de Bacno de Dados + Desenvolvimeno Wev + Engenharia de Software 2

#SQL Procedures

#Procedure de ConsultaValor
CREATE TYPE tabela AS (valor numeric, mes int, data int, descricaoNatureza varchar(255));

CREATE OR REPLACE FUNCTION ConsultaValor(npage int, rowsperpage int, descricao text, ano text, valor text) RETURNS setof 

tabela  AS $BODY$

DECLARE

	searchsql text := '';

	r tabela%rowtype;

BEGIN

	searchsql := ' Select d.Valor as Valor, d.DataMes as Mes, d.DataAno as Data, d.descricaonatureza
	
	FROM Despesa d
	
	WHERE TO_CHAR(d.DataAno, ''0999'') ~ '''||ano || ''' 
	
	AND TO_CHAR(d.Valor, ''0999.09'') ~ '''|| valor || ''' 
	
	AND d.descricaotipolicitacao = '''|| descricao || '''
	
	ORDER BY Mes, Valor ASC';

	if rowsperpage > 0  then
	
		searchsql := searchsql || ' LIMIT ' || rowsperpage || ' OFFSET ' ||(npage-1)* rowsperpage;
	
	end if;

	for r IN EXECUTE(searchsql) LOOP
	
		RETURN NEXT r;
	
	END LOOP;
	
	RETURN;

END;

$BODY$ LANGUAGE plpgsql;

#Procedure de ConsultaOcorrencia
create or replace function selecionaDadosComLog(busca varchar(255) )

RETURNS table(

	descricaonatureza character varying(255),

	qtdeCodigos bigint,

	tlDescricao character varying(100)

) as $log$

begin

	insert into logTipoLicitacao(tipoLicitacao) values(busca);
	
	return query 

	select * from licitacoes where descricao = busca;
		
end

$log$ language plpgsql;
