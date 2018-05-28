/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet.Conta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poo.sb.DAO.ClienteDAO;
import poo.sb.DAO.ContaDAO;
import poo.sb.model.Cliente;
import poo.sb.model.Conta;
import poo.sb.model.ContaCorrente;
import poo.sb.model.ContaPoupanca;
import poo.sb.servlet.cliente.CadastrarCliente;
import poo.sb.utils.Utils;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "CadastrarConta", urlPatterns = {"/cadastrar-conta"})
public class CadastrarConta extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Conta novaConta;
        try {
            if (request.getParameter("tipo_conta").equals("poupanca")) {
                novaConta = new ContaPoupanca();
            } else {
                novaConta = new ContaCorrente();
            }
            Cliente titular = ClienteDAO.obter(request.getParameter("cliente_conta"));            
            novaConta.setTitular(titular);
            novaConta.setSaldo(Utils.brlToNum(request.getParameter("saldo")));
            novaConta.setNumero(Integer.valueOf(request.getParameter("numero_conta")));            
            novaConta.setSenha(request.getParameter("senha"));                                    
            ContaDAO.inserir(novaConta);            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
            return;
        }

        PrintWriter resposta = response.getWriter();
        resposta.println("A conta '" + request.getParameter("numero_conta") + "' foi cadastrada com sucesso.");
    }

}
