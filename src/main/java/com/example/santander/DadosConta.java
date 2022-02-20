package com.example.santander;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Dados da Conta",urlPatterns = "/dadosConta")
public class DadosConta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String telefone = req.getParameter("telefone");

        req.setAttribute("nome",nome);
        req.setAttribute("email",email);
        req.setAttribute("senha",senha);
        req.setAttribute("telefone",telefone);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("dadosConta.jsp");
        requestDispatcher.forward(req,res);
    }
}
