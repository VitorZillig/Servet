package com.example.santander;

import com.example.santander.model.ClienteModel;
import com.example.santander.model.ListaClientes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

    @WebServlet(name = "Cadastro", value = "/cadastro")
    public class Cadastro extends HttpServlet {

//        @Override
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("clienteCadastrado.jsp");
////            request.setAttribute("cliente", cliente.getNome());
//            requestDispatcher.forward(request, response);
//
//        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//            request.setAttribute("clientes", clientes);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastro.jsp");
            requestDispatcher.forward(request, response);

        }

    }


