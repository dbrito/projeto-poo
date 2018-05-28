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
import poo.sb.DAO.ContaDAO;
import poo.sb.model.Conta;
import poo.sb.model.ContaCorrente;
import static poo.sb.servlet.Conta.BuscarConta.geraLinha;
import poo.sb.utils.Utils;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "FecharConta", urlPatterns = {"/fechar-conta"})
public class FecharConta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Conta conta;
        try {            
            conta = ContaDAO.obter(Integer.valueOf(request.getParameter("id_conta")), "id");
            if (conta == null) {
                response.sendError(500, "Conta nao encontrado");
                return;
            }
            ContaDAO.fechar(conta);
                                    
            PrintWriter resposta = response.getWriter();            
            resposta.println("Conta fechada com sucesso.");            
        } catch (Exception ex) {
            response.sendError(500, ex.getMessage());
            Logger.getLogger(BuscarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
