/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "LoginAgencia", urlPatterns = {"/login-agencia"})
public class LoginAgencia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                                                        
        try {//Verifico se o usuário já está logado            
            Boolean logado = (Boolean) request.getSession().getAttribute("funcionario");                        
            if (logado ==  true) {
                response.sendRedirect("agencia-home");
                return;
            }            
        } catch(Exception ex) { }
        
        RequestDispatcher redir = request.getRequestDispatcher("./agencia/login.jsp");
        redir.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                        
        String user, pass;        
        try {//Verifico se o usuário e senha do funcionário está correto
            user = request.getParameter("user");
            pass = request.getParameter("pass");                        
            if (!user.equals("admin") || !pass.equals("admin")) {
                response.sendError(500, "Login invalido, verifique o seu usuario e senha.");
                return;
            }            
        } catch (Exception ex) {
            System.out.print(ex);
        }                
        request.getSession().setAttribute("funcionario", true);                
        PrintWriter resposta = response.getWriter();
        response.getWriter().println("Login efetuado com sucesso.");
    }

}
