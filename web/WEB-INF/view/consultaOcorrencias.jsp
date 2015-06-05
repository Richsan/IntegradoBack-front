
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dados Abertos Governamentais</title>
        <link rel="stylesheet" type="text/css" href="resources/style.css">
        <link rel="stylesheet" type="text/css" href="resources/form.css">
    </head>


    <body>
        <div class='wrapper'>
        <aside class='sidebar'>
            <header class='title'>
             Dados Abertos Governamentais
            </header>
            <nav>
            <ul class='nav'>
                <li><a href="index.htm">Home</a></li>
                <li><a href="consultaValor.html">Consulta Valor</a></li>
                <li><a class="active">Consulta Ocorrências</a></li>
                <li><a href="help.html">Help</a></li>
                <li><a href="about.html">About</a></li>
            </ul>
            </nav>
        </aside>
     <section class='content isOpen'>
            <h1>Consulta Ocorrências</h1>
            <h2>Descubra a recorrência de cada natureza de despesa em um determinado tipo de licitação</h2>
            <form action="" method="GET" name="consultaOcorrencia">
                <label for="tipoLicitacao">Tipo Licitação:<br>
                <select for="consultaOcorrencia">
                  <option value="licitacao2">Adiantamento</option>
                  <option value="licitacao3">Contrato de Obras</option>
                  <option value="licitacao4">Material Permanente</option>
                  <option value="licitacao5">Contrato Outros</option>
                  <option value="licitacao6">Contrado de Locação</option>
                  <option value="licitacao7">Registro de Preços</option>
                  <option value="licitacao8">Contratos de Fornecimento de Material</option>
                  <option value="licitacao9">Contrato de Fornecimento de Serviços</option>
                  <option value="licitacao10">Pessoal</option>
                  <option value="licitacao11">Serviços/Outros</option>
                  <option value="licitacao12">Material de Consumo</option>
                  <option value="licitacao13">Contrato de Termo de Parceria</option>
                </select>
                </label>

                <button>Buscar</button>

                <table>
                    <tr>
                        <th>Natureza da Despesa</th>
                        <th>Ocorrências</th>
                    </tr>
                    <tr>
                        <td>Exemplo1</td>
                        <td>Exemplo 2</td>
                    </tr>
                </table>
            </form>
       </section>
       </div>
    </body>
</html>
