
<%@page import="dadosGovernamentais.model.ConsultaValorOutputBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="pags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dados Abertos Governamentais</title>
        <link rel="stylesheet" type="text/css" href="resources/style.css">
        <link rel="stylesheet" type="text/css" href="resources/form.css">

      <script src='resources/jquery.js'></script>
      <link rel="stylesheet" href="resources/jquery-ui.css">
      <script src="resources/jquery-1.10.2.js"></script>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
      <script src="resources/jquery-ui.js"></script>
      

      <script src="resources/valForm.js"></script>
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
                <li><a class='active'>Natureza das Depesas</a></li>
                <li><a href="consultaOcorrencias.html">Ocorrências das Licitações</a></li>
                <li><a href="about.html">Sobre</a></li>
            </ul>
            </nav>
        </aside>
        <section class='content isOpen'>
            <h1>Natureza das Depesas</h1>
            <aside><h2>Busque todas as naturezas de despesa de uma licitação através de valor máximo, mínimo e data</h2>
                <br/>OBS: Todos os campos são de preenchimento obrigatório.</aside>
            
			<aside id="alerta1"><img src="resources/alertaIcon.png" /> Preencha os campos destacados em vermelho!</aside>
            <aside id="alerta2"><img src="resources/alertaIcon.png" /> Valores devem ser informados no formato R$ 00,00</aside>
			
			<form id="formulario" action="consultaValor.htm" method="get" name="consultaValor">
                <select for="consultaValor" name="tipoLicitacao" title="${param.tipoLicitacao}">
                  <option value="empty">Tipo de Licitacao</option>
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

                <label for="valorMin">Valor mín: <br><input type="text" name="valorMin" id="valorMin" placeholder="R$ 0,00" value="${getInput.getValorMinString()}" /></label>

                <label for="valorMax">Valor max: <br><input type="text" name="valorMax" id="valorMax" placeholder="R$ 0,00" value="${getInput.getValorMaxString()}"/></label>

                <label for="dataInicio">Ano de início: <br><input type="text" name="dataInicio" id="dataInicio" placeholder="yyyy" class="date-picker-year" value="${param.dataInicio}"/></label>
                <label for="dataFim">Ano limite: <br><input type="text" name="dataFim" id="dataFim" placeholder="yyyy" class="date-picker-year" value="${param.dataFim}" /></label>

                <button type="submit">Buscar</button>

                <table>
                    <tr>
                        <th>Natureza da Despesa</th>
                        <th>Valor</th>
                        <th>Mes</th>
                        <th>Ano</th>
                    </tr>
                    
                    <c:forEach items="${searchResult}" var="result" >
                        <tr>
                            <td>${result.getNaturezaDespesa()}</td>
                            <td>${result.getValor()}</td>
                            <td>${result.getNomeMes()}</td>
                            <td>${result.getAno()}</td>
                        </tr>
                    </c:forEach>
                    <pags:Paginacao npages="${rows}" start="${page}" />
                </table>
                
            </form>
       </section>
       </div>
    </body>
</html>
