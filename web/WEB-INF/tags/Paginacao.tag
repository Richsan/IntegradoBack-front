<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ attribute name="start" required="true" %>
<%@ attribute name="npages" required="true" %>

<%-- any content can be specified here e.g.: --%>
<tr class="pageRow"><td colspan="4"><ul>
<% if(Integer.parseInt(start) > 0) { %>
    <%
        int i = Integer.parseInt(start) - 2;
        int numpgs = Integer.parseInt(npages);
        String  url = request.getQueryString();


        if(i <= 1)
            i = 1;
        else
        {
            int n = url.indexOf("&page");
            if(n  != -1)
                url = url.substring(0,n);

    %>
            <li><a href="/DadosGovernamentais/consultaValor.htm?<%= url %>&page=<%= i-1 %>"> Anterior </a></li>
    <%
        }
        for(int count = 0;i <= numpgs && count < 6; i++, count++)
        {   
            int n = url.indexOf("&page");
            if(n  != -1)
                url = url.substring(0,n);
    %>
             <li><a href="/DadosGovernamentais/consultaValor.htm?<%= url %>&page=<%= i %>"> <%= i %> </a></li>
    <%
        }
        if(i <= numpgs)
        {
            int n = url.indexOf("&page");
            if(n  != -1)
                url = url.substring(0,n);

    %>
            <li><a href="/DadosGovernamentais/consultaValor.htm?<%= url %>&page=<%= i %>"> Mais </a></li>
    <% } 
    }%>
</ul></td></tr>