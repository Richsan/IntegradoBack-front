
var pieChartDataSource = [];
$(document).ready(function()
{
    var tabela = $("#OcorrenciaTable").get(0);
    var qtdeLinhas = tabela.rows.length - 1;
    
    for(i = 1; i < qtdeLinhas; i++)
    {
        var celulas = tabela.rows.item(i).cells;       
         pieChartDataSource.push({
                category: celulas.item(0).innerHTML,
                value: parseInt(celulas.item(1).innerHTML)
         });
        
    }
    var texto = 'Gráfico de Distribuição';
    if(qtdeLinhas <= 1)
        texto = '';
    if(qtdeLinhas > 1)
        {$(function () {
        $("#pieChartContainer").dxPieChart({
            dataSource: pieChartDataSource,
            series: {
                argumentField: 'category',
                valueField: 'value',
                label: {
                    visible: true,
                    connector: {
                        visible: true
                    }
                }
            },
            pathModified: true,
            tooltip: {
                enabled: true,
                percentPrecision: 2,
                customizeTooltip: function (value) {
                    return {
                        text: value.percentText
                    };
                }
            },
            title: {
                text: texto
            },
            legend: {
                horizontalAlignment: 'right',
                verticalAlignment: 'top',
                position: 'outside'
            }
        });
    });
}
});
/*var pieChartDataSource = [
    { category: 'Oceania', value: 35 },
    { category: 'Africa', value: 1016 },
    { category: 'Americas', value: 936 },
    { category: 'Asia', value: 4149 },
    { category: 'Europe', value: 728 }
];*/


