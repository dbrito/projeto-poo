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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poo.sb.DAO.ClienteDAO;
import poo.sb.model.Cliente;
import poo.sb.model.ClientePessoaFisica;
import poo.sb.model.ClientePessoaJuridica;

@WebServlet(name = "CadastrarCliente", urlPatterns = {"/cadastrar-cliente"})
public class CadastrarCliente extends HttpServlet {   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Cliente novoCliente;
        try {
            if (request.getParameter("tipo_cliente").equals("pessoa_fisica")) {
                novoCliente = new ClientePessoaFisica();
            } else {
                novoCliente = new ClientePessoaJuridica();
            }

            novoCliente.setNome(request.getParameter("nome"));
            if (novoCliente instanceof ClientePessoaJuridica) {
                ((ClientePessoaJuridica) novoCliente).setCnpj(request.getParameter("cpf_cnpj"));
            } else {
                ((ClientePessoaFisica) novoCliente).setCpf(request.getParameter("cpf_cnpj"));                
            }
            novoCliente.setTelefone(request.getParameter("telefone"));
            novoCliente.setCep(request.getParameter("cep"));
            novoCliente.setEndereco(request.getParameter("endereco"));
            novoCliente.setCidade(request.getParameter("cidade"));
            novoCliente.setEstado(request.getParameter("estado"));            
            ClienteDAO.inserir(novoCliente);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(500, ex.getMessage());
            return;
        }

        PrintWriter resposta = response.getWriter();
        resposta.println("O cliente '" + request.getParameter("nome") + "' foi cadastrado com sucesso.");
    }

}
