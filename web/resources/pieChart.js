

var pieChartDataSource = [
    { category: 'Oceania', value: 35 },
    { category: 'Africa', value: 1016 },
    { category: 'Americas', value: 936 },
    { category: 'Asia', value: 4149 },
    { category: 'Europe', value: 728 }
];

$(function () {
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
            text: 'Continental Population by 2010 (in millions)'
        },
        legend: {
            horizontalAlignment: 'center',
            verticalAlignment: 'bottom'
        }
    });
});