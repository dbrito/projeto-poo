/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.sb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "Agencia", urlPatterns = {"/agencia-home"})
public class Agencia extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                                                
        try {//Verifico se o funcionario de fato efetuou o login                        
            Object logado = request.getSession().getAttribute("funcionario");
            if (logado == null || (Boolean) logado != true) {
                response.sendRedirect("login-agencia");
                return;
            }
        } catch(Exception ex) { System.out.print("Agencia:" + ex); }        
        RequestDispatcher redir = request.getRequestDispatcher("./agencia/agencia.jsp");
        redir.forward(request, response);
    }
}
