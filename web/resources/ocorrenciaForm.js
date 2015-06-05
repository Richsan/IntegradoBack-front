var validaOcorrenciaForm = function()
{
	var cbConsultaOcorrencia = $("select[for='consultaOcorrencia']").get(0);

	if(cbConsultaOcorrencia.value == "empty")
	{
		$("select[for='consultaOcorrencia']").css('color', 'red');
		return false;
	}
	else
		$("select[for='consultaOcorrencia']").css('color','#000');

	return true;
}

$(document).ready(function()
{

});