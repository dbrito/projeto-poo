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
import poo.sb.model.ContaPoupanca;
import poo.sb.utils.Utils;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "BuscarConta", urlPatterns = {"/buscar-conta"})
public class BuscarConta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Conta conta;
        try {            
            conta = ContaDAO.obter(Integer.valueOf(request.getParameter("numero_conta")));
            if (conta == null) {
                response.sendError(500, "Conta nao encontrado");
                return;
            }

            String tipo = "";
            if (conta instanceof ContaCorrente) tipo = "corrente";
            else tipo = "poupanca";
                        
            response.setContentType("application/json");                    
            PrintWriter resposta = response.getWriter();            
            resposta.println("{");
            resposta.println(geraLinha("id_conta", conta.getId()) + ",");
            resposta.println(geraLinha("tipo_conta", tipo) + ",");
            resposta.println(geraLinha("nome_cliente", conta.getTitular().getNome()) + ",");
            resposta.println(geraLinha("saldo", Utils.numToBrl(conta.getSaldo())));
            resposta.println("}");                        
        } catch (Exception ex) {
            Logger.getLogger(BuscarConta.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
        }
    }
    
    static String geraLinha(String key, String value) {                
        return " \"" + key + "\": \"" + value + "\"";
    }
    
    static String geraLinha(String key, Integer value) {                
        return " \"" + key + "\": \"" + value + "\"";
    }

}
