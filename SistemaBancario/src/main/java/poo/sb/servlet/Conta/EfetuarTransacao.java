/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet.Conta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poo.sb.DAO.ContaDAO;
import poo.sb.model.Conta;
import poo.sb.model.ContaCorrente;
import poo.sb.model.ContaPoupanca;
import poo.sb.model.Transacao;
import poo.sb.utils.Utils;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "EfetuarTransacao", urlPatterns = {"/efetuar-transacao"})
public class EfetuarTransacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Transacao acao = new Transacao();                
                
        try {
            Conta conta = (Conta) request.getSession().getAttribute("conta");
            if (conta == null) {
                response.sendError(500, "Sessao expirada.");
                return;
            }            
            String tipo = request.getParameter("tipo");
            if (tipo.equals("saque")) {                
                saque(request, response, conta, acao);                
            } else if (tipo.equals("deposito")) {                
                deposito(request, response, conta, acao);                
            } else if (tipo.equals("transferencia")) {                
                transferencia(request, response, conta, acao);                
            } else if (tipo.equals("saldo")) {
                saldo(request, response, conta, acao);                
            }
            return;
        } catch (Exception ex) {
            Logger.getLogger(EfetuarTransacao.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
            return;
        }       
    }
    
    static void saque(HttpServletRequest request, HttpServletResponse response, Conta conta, Transacao acao) throws IOException, SQLException, Exception {
        PrintWriter resposta = response.getWriter();        
        acao.setTipo("Sacou");
        acao.setValor(Utils.brlToNum(request.getParameter("valor")));
        if (!conta.sacar(acao.getValor())) {
            response.sendError(500, "Saldo insuficiente.");
            return;
        }
        ContaDAO.criarTransacao(acao, conta);                
        ContaDAO.atualizarSaldo(conta);
        conta.addTransacao(acao);
        resposta.println("Saque efetuado com sucesso. <br> Retire o dinheiro abaixo.");
    }
    
    static void deposito(HttpServletRequest request, HttpServletResponse response, Conta conta, Transacao acao) throws IOException, SQLException, Exception {
        PrintWriter resposta = response.getWriter();        
        acao.setTipo("Depositou");
        acao.setValor(Utils.brlToNum(request.getParameter("valor")));
        if (!conta.depositar(acao.getValor())) {
            response.sendError(500, "Erro ao realizar o deposito");
            return;
        }
        ContaDAO.criarTransacao(acao, conta);                
        ContaDAO.atualizarSaldo(conta);
        conta.addTransacao(acao);
        resposta.println("Deposito efetuado com sucesso. <br> Saldo Atualizado.");
    }
    
    static void transferencia(HttpServletRequest request, HttpServletResponse response, Conta conta, Transacao acao) throws IOException, SQLException, Exception {
        PrintWriter resposta = response.getWriter();
        acao.setTipo("Transferiu");
        acao.setValor(Utils.brlToNum(request.getParameter("valor")));
        
        Conta destino = ContaDAO.obter(Integer.valueOf(request.getParameter("id_conta")), "id");
        if (!conta.transferir(acao.getValor(), destino)) {
            response.sendError(500, "Saldo insuficiente.");
            return;
        }                
        acao.setConta(destino.getNumero());        
        
        //Crio a transacao na conta destino
        Transacao acaoDestino = new Transacao();                
        acaoDestino.setTipo("Recebeu");
        acaoDestino.setValor(acao.getValor());
        acaoDestino.setConta(conta.getNumero());
                        
        ContaDAO.criarTransacao(acao, conta);
        ContaDAO.criarTransacao(acaoDestino, destino);                
        ContaDAO.atualizarSaldo(conta);
        ContaDAO.atualizarSaldo(destino);
        conta.addTransacao(acao);
        resposta.println("Transferencia efetuada com sucesso.");
    }
    
    static void saldo(HttpServletRequest request, HttpServletResponse response, Conta conta, Transacao acao) throws IOException, SQLException, Exception {
        PrintWriter resposta = response.getWriter();                                        
        resposta.println(Utils.numToBrl((ContaDAO.obter(conta.getId(), "id")).getSaldo()));
    }
}

