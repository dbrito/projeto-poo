/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import poo.sb.DAO.ContaDAO;
import poo.sb.model.Conta;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "LoginConta", urlPatterns = {"/login-conta"})
public class LoginConta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                                                        
        try {//Verifico se o usuário já está logado            
            Conta conta = (Conta) request.getSession().getAttribute("conta");                        
            if (conta != null) {
                response.sendRedirect("conta-home");
                return;
            }            
        } catch(Exception ex) { }
        
        RequestDispatcher redir = request.getRequestDispatcher("./conta/login.jsp");
        redir.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                                
        Conta conta =  null;
        try {//Verifico se a conta e senha procedem
            Integer account = Integer.valueOf(request.getParameter("account"));
            String pass = request.getParameter("pass");                        
            conta = ContaDAO.validarConta(account, pass);
            if (conta == null) {
                response.sendError(500, "Login invalido, verifique o seu usuario e senha.");
                return;
            }            
        } catch (Exception ex) {
            System.out.print(ex);
        }        
        request.getSession().setAttribute("conta", conta);
        PrintWriter resposta = response.getWriter();
        response.getWriter().println("Login efetuado com sucesso.");
    }
    

}
