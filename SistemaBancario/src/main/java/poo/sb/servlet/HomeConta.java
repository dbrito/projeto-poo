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
import poo.sb.model.Conta;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "Conta", urlPatterns = {"/conta-home"})
public class HomeConta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                                                
        try {//Verifico se o funcionario de fato efetuou o login                        
            Conta conta = (Conta) request.getSession().getAttribute("conta");
            if (conta == null) {
                response.sendRedirect("login-conta");
                return;
            }
        } catch(Exception ex) { System.out.print("Agencia:" + ex); }        
        RequestDispatcher redir = request.getRequestDispatcher("./conta/conta.jsp");
        redir.forward(request, response);
    }

}
