/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet.Conta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poo.sb.DAO.ContaDAO;
import poo.sb.model.Conta;
import poo.sb.model.Transacao;
/**
 *
 * @author Douglas
 */
@WebServlet(name = "PegarExtrato", urlPatterns = {"/extrato"})
public class PegarExtrato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                        
        System.out.print("HERE");
        try {
            Conta conta = (Conta) request.getSession().getAttribute("conta");
            if (conta == null) {
                response.sendError(500, "Sessao expirada.");
                return;
            }            
            
            List<Transacao> teste = ContaDAO.obter(conta.getNumero()).getExtrato();                
            request.setAttribute("transacoes", teste);        
            RequestDispatcher meuk = request.getRequestDispatcher("./conta/extrato.jsp");
            meuk.forward(request, response);                        
        } catch (Exception ex) {
            Logger.getLogger(EfetuarTransacao.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
            return;
        }       
    }

}
