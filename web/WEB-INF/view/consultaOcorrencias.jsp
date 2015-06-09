
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dados Abertos Governamentais</title>
        <link rel="stylesheet" type="text/css" href="resources/style.css">
        <link rel="stylesheet" type="text/css" href="resources/form.css">
       
        <script type="text/javascript" src="resources/jquery.min.js"></script>
        <script type="text/javascript" src="resources/globalize.min.js"></script>
        <script type="text/javascript" src="resources/dx.chartjs.js"></script>
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
                <li><a href="consultaValor.html">Natureza das Depesas</a></li>
                <li><a class="active">Ocorrências das Licitações</a></li>
                <li><a href="about.html">Sobre</a></li>
            </ul>
            </nav>
        </section>
     <section class='content isOpen'>
            <h1>Ocorrências das Licitações</h1>
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
            </form>
                <table id="OcorrenciaTable">
                <c:set value="${listaOcorrencias}" var="lista" />
                <c:choose>
                <c:when test="${not empty lista}" >
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
                            <td id="pieChartContainer" colspan="2" style="height: 350px;  margin: auto"></td></tr>
                    
                </c:when>
                    <c:otherwise>
                        <tr style="font-size: 16px; font-weight: bold;"><td style="padding-left: 450px; padding-right: 400px;"> Sem Resultados </td></tr>
                    </c:otherwise>
                </c:choose>
                </table>
       </section>
             
       </div>
    </body>
</html>
