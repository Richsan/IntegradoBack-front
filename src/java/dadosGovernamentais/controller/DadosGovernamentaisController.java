package dadosGovernamentais.controller;

import dadosGovernamentais.dao.ConsultaOcorrenciasDAO;
import dadosGovernamentais.dao.ConsultaValorDAO;
import dadosGovernamentais.dao.TipoLicitacaoDAO;
import dadosGovernamentais.model.ConsultaOcorrenciasBean;
import dadosGovernamentais.model.ConsultaValorInputBean;
import dadosGovernamentais.model.ConsultaValorOutputBean;
import dadosGovernamentais.model.TipoLicitacaoBean;
import dadosGovernamentais.servicos.ConnectionFactory;
import static java.lang.Math.ceil;
import java.sql.Connection;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DadosGovernamentaisController 
{
    @RequestMapping("/about")
    public String about()
    {
        return "about";
    }
    
    @RequestMapping("/consultaOcorrencias")
    public ModelAndView consultaOcorrencias(String tipoLicitacao)
    {
        ModelAndView mv = new ModelAndView("consultaOcorrencias");
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conexao = connFactory.getConnection();
        TipoLicitacaoDAO tipoLicitacaoDAO = new TipoLicitacaoDAO(conexao);
        ConsultaOcorrenciasDAO dao = new ConsultaOcorrenciasDAO(conexao);
        ArrayList<ConsultaOcorrenciasBean> occorencias = null;
        if(tipoLicitacao != null)
           occorencias = (ArrayList<ConsultaOcorrenciasBean>)dao.getSearchResult(tipoLicitacao);
        ArrayList<TipoLicitacaoBean> listaLicitacoes = (ArrayList<TipoLicitacaoBean>)tipoLicitacaoDAO.getListaLicitacoes();
        connFactory.closeConnection();
        mv.addObject("listaLicitacoes", listaLicitacoes);
        mv.addObject("listaOcorrencias", occorencias);
        
        return mv;
    }
    
       
    @RequestMapping("/consultaValor")
    public ModelAndView consultaValor(ConsultaValorInputBean input)
    {
        
        ModelAndView mv = new ModelAndView("consultaValor");
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conexao = connFactory.getConnection();
        ConsultaValorDAO dao = new ConsultaValorDAO(conexao);
        TipoLicitacaoDAO tipoLicitacaoDAO = new TipoLicitacaoDAO(conexao);
        ArrayList<TipoLicitacaoBean> listaLicitacoes = (ArrayList<TipoLicitacaoBean>)tipoLicitacaoDAO.getListaLicitacoes();
        
        if(!"".equals(input.getTipoLicitacao()))
        {   
            ArrayList<ConsultaValorOutputBean> searchResult = (ArrayList<ConsultaValorOutputBean>)dao.getSearchResult(input);
            mv.addObject("searchResult",searchResult);
            mv.addObject("rows", (int)ceil(dao.getSerachLines(input)/7.0));
        }
        else
        {
            mv.addObject("rows", 0);
        } 
        
        if(input.getPage() != 0)
            mv.addObject("page",input.getPage());
        else
            mv.addObject("page", 1);
        
        
        
        connFactory.closeConnection();
       
        mv.addObject("listaLicitacoes", listaLicitacoes);
        mv.addObject("getInput", input);
        return mv;
    }
    
    @RequestMapping("/help")
    public String help()
    {
        return "help";
    }
}
