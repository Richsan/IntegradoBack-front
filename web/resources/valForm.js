var keyAscii = {"0":48, "9":57, ",":44};

var  digitaEvento = function(event)
{
	if(event.keyCode < keyAscii["0"] || event.keyCode > keyAscii["9"])
	{
		if(this.value == "")
		{
			event.preventDefault();
			return;
		}

		if(event.keyCode != keyAscii[","])
		{
			event.preventDefault();
			return;
		}
	}

	if(this.value == "")
		this.value = "R$ ";
        
};

var backspaceDetect = function() {
    var regexp = /^R\$\s\d$/;
    var key = event.keyCode || event.charCode;
    var backspace = 8;
    var deletekey = 46;
    
    if( key == backspace || key == deletekey)
    {
        if(regexp.test(this.value))
        this.value = "";
    }
    
};      

var up = function()
{
    var regexp = /R\$\s/;
    var regexp2 = /,/;
  
    if(!regexp.test(this.value))
        this.value = "";
    
    if(!regexp2.test(this.value) && this.value != "")
    {
        this.value = this.value + ",00";
        this.setSelectionRange(this.value.length -3,this.value.length -3);
    }
    
}

var evalEmptyFields = function(form)
{
	var flag = true;
	if(form.valorMin.value == "")
	{
		$("label[for='valorMin']").css('color','red');
                if($("label[for='valorMax']").get(0).style.color != "orange")
                    $("#alerta2").css('visibility', 'hidden');
                    
		flag = false;
	}
	else if($("label[for='valorMin']").get(0).style.color != "orange")
		$("label[for='valorMin']").css('color','#333');

	if(form.valorMax.value == "")
	{
		$("label[for='valorMax']").css('color','red');
                if($("label[for='valorMin']").get(0).style.color != "orange")
                    $("#alerta2").css('visibility', 'hidden');
		flag = false;
	}
	else if($("label[for='valorMax']").get(0).style.color != "orange")
		$("label[for='valorMax']").css('color','#333');

	if(form.dataInicio.value == "")
	{
		$("label[for='dataInicio']").css('color','red');
		flag = false;
	}
	else
		$("label[for='dataInicio']").css('color','#333');

	if(form.dataFim.value == "")
	{
		$("label[for='dataFim']").css('color','red');
		flag = false;
	}
	else
		$("label[for='dataFim']").css('color','#333');

	if(form.cbConsultaVal.value == "empty")
	{
		$("select[for='consultaValor']").css('color', 'red');
		flag = false;
	}
	else
		$("select[for='consultaValor']").css('color','#000');

	if(!flag)
		$("#alerta1").css('visibility', 'visible');
	else
		$("#alerta1").css('visibility', 'hidden');



	return flag;
};

var evalContentFields = function(form)
{
	var regexp = /R\$\s\d+,\d\d/;
        var flag = true;
	if(!regexp.test(form.valorMin.value))
	{
		$("label[for='valorMin']").css('color','orange');
		$("#alerta2").css('visibility', 'visible');
		flag= false;
	}
        if(!regexp.test(form.valorMax.value))
	{
		$("label[for='valorMax']").css('color','orange');
		$("#alerta2").css('visibility', 'visible');
		flag= false;
	}
        return flag;
	
};
var validaValorForm = function(event)
{	
	var form =
        {
                valorMin :  $("#valorMin").get( 0 ),
                valorMax :   $("#valorMax").get( 0 ),
                dataInicio:  $("#dataInicio").get(0),
                dataFim:  $("#dataFim").get(0),
                cbConsultaVal: $("select[for='consultaValor']").get(0),
                submit : function(){$("#formulario").submit();}
          
         };
         
	var flag = true;

	flag = evalEmptyFields(form);

	 if(flag && evalContentFields(form))
         {  
             form.valorMin.value = form.valorMin.value.substring(3).replace(",",".");
             form.valorMax.value = form.valorMax.value.substring(3).replace(",",".");
             form.submit();
         } 
         else
             event.preventDefault();
};

$(document).ready(function()
{
	$("#valorMin").keypress(digitaEvento.bind($("#valorMin").get( 0 )));
	$("#valorMax").keypress(digitaEvento.bind($("#valorMax").get( 0 )));
        $("#valorMin").keydown(backspaceDetect.bind($("#valorMin").get( 0 )));
	$("#valorMax").keydown(backspaceDetect.bind($("#valorMax").get( 0 )));
        $("#valorMin").keyup(up.bind($("#valorMin").get( 0 )));
	$("#valorMax").keyup(up.bind($("#valorMax").get( 0 )));
	$("#dataInicio").keypress(function(evt){evt.preventDefault();});
	$("#dataFim").keypress(function(evt){evt.preventDefault();});
	$("button").click(validaValorForm);
        
        $(function() {
            $('.date-picker-year').datepicker({
                changeYear: true,
                showButtonPanel: true,
                dateFormat: 'yy',
                stepMonths: 12,
                onClose: function(dateText, inst) { 
                    var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                    $(this).datepicker('setDate', new Date(year, 1));
                }
            });
             $(".date-picker-year").focus(function () {
                $(".ui-datepicker-month").hide();
            });
        });
        
        
        
});
