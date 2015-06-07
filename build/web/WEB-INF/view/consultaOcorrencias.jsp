
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dados Abertos Governamentais</title>
        <link rel="stylesheet" type="text/css" href="resources/style.css">
        <link rel="stylesheet" type="text/css" href="resources/form.css">
       
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/globalize/0.1.1/globalize.min.js"></script>
        <script type="text/javascript" src="http://cdn3.devexpress.com/jslib/15.1.3/js/dx.chartjs.js"></script>
        <script type="text/javascript" src="resources/pieChart.js"></script>
 
    </head>


    <body>
        <div class='wrapper'>
        <section class='sidebar'>
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
        </section>
     <section class='content isOpen'>
            <h1>Consulta Ocorrências</h1>
            <aside><h2>Descubra a recorrência de cada natureza de despesa em um determinado tipo de licitação</h2></aside>
            <form action="consultaOcorrencias.htm" method="GET" name="consultaOcorrencia">
                <label for="tipoLicitacao">Tipo Licitação:<br>
                <select for="consultaOcorrencia" name="tipoLicitacao" title="${param.tipoLicitacao}">
                   <c:forEach items="${listaLicitacoes}" var="licitacao">
                       <c:set value="${licitacao.getDescricao()}" var="l" />
                        <c:set value="${param.tipoLicitacao}" var="p" />
                         <c:choose>
                         <c:when test="${p eq l}" >
                            <option value="${licitacao.getDescricao()}" selected>${licitacao.getDescricao()}</option>
                         </c:when>
                         <c:otherwise>
                            <option value="${licitacao.getDescricao()}">${licitacao.getDescricao()}</option>
                         </c:otherwise>
                         </c:choose>
                  </c:forEach>
                </select>
                </label>

                <button type="submit">Buscar</button>

                <table id="OcorrenciaTable">
                    <tr>
                        <th>Natureza da Despesa</th>
                        <th>Ocorrências</th>
                    </tr>
                    <c:forEach items="${listaOcorrencias}" var="result" >
                        <tr>
                            <td>${result.getNaturezaDespesa()}</td>
                            <td>${result.getOcorrencias()}</td>
                        </tr>
                    </c:forEach>
                        <tr><td id="pieChartContainer" colspan="2" style="height: 350px;  margin: auto"></td></tr>
                </table>
                
            </form>
       </section>
             
       </div>
    </body>
</html>
