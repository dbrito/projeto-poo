/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet.cliente;

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
import poo.sb.model.Cliente;
import poo.sb.model.ClientePessoaFisica;
import poo.sb.model.ClientePessoaJuridica;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "BuscaCliente", urlPatterns = {"/buscar-cliente"})
public class BuscarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Cliente novoCliente;
        try {
            String cpf = request.getParameter("cpf_cnpj_conta");
            Cliente cliente = ClienteDAO.obter(cpf);
            if (cliente == null) {
                response.sendError(500, "Usuario nao encontrado");
                return;
            }
                        
            String identificador = "";
            if (cliente instanceof ClientePessoaFisica) {
                identificador = ((ClientePessoaFisica) cliente).getCpf();
            } else {
                identificador = ((ClientePessoaJuridica) cliente).getCnpj();
            }
            
            response.setContentType("application/json");                    
            PrintWriter resposta = response.getWriter();            
            resposta.println("{ \"nome\": \""+ cliente.getNome() + "\", \"cpf_cnpj\": \"" + identificador + "\"}");                                         
        } catch (Exception ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
