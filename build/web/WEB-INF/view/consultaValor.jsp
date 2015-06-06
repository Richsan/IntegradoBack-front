
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

      <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
      <script src="resources/valForm.js"></script>

  <script>
  $(function() {
    $( "#dataInicio, #dataFim" ).datepicker();

  });
  </script>


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
                <li><a class='active'>Consulta Valor</a></li>
                <li><a href="consultaOcorrencias.html">Consulta Ocorrências</a></li>
                <li><a href="help.html">Help</a></li>
                <li><a href="about.html">About</a></li>
            </ul>
            </nav>
        </aside>
        <section class='content isOpen'>
            <aside id="alerta1" style="color: red; visibility:hidden">Preencha os campos destacados em vermelho!</aside>
            <aside id="alerta2" style="color: orange; visibility: hidden">Valores devem ser informados no formato R$ 00,00</aside>
            <h1>Consulta Valor</h1>
            <h2>Busque todas as naturezas de despesa de uma licitação através de valor máximo, mínimo e data</h2>
            <form id="formulario" action="consultaValor.htm" method="get" name="consultaValor">
                <select for="consultaValor" name="tipoLicitacao">
                  <option value="empty">Tipo de Licitacao</option>
                  <c:forEach items="${listaLicitacoes}" var="licitacao">                  
                     <option value="${licitacao.getDescricao()}">${licitacao.getDescricao()}</option>
                  </c:forEach>
                </select>

                <label for="valorMin">Valor mín: <br><input type="text" name="valorMin" id="valorMin" placeholder="R$ 0,00" value="${getInput.getValorMinString()}" /></label>

                <label for="valorMax">Valor max: <br><input type="text" name="valorMax" id="valorMax" placeholder="R$ 0,00" value="${getInput.getValorMaxString()}"/></label>

                <label for="dataInicio">Data de início: <br><input type="text" name="dataInicio" id="dataInicio" placeholder="dd/mm/aaaa"/></label>
                <label for="dataFim">Data limite: <br><input type="text" name="dataFim" id="dataFim" placeholder="dd/mm/aaaa"/></label>

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
                            <td>${result.getMes()}</td>
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
