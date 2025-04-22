package com.hookitstabit.controller;

import com.hookitstabit.dao.CategoriaDAO;
import com.hookitstabit.model.Categoria;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet ("/api/categorias")
public class CategoriaController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final String APPLICATION_JSON = "application/json";
    private static  final Jsonb JSONB = JsonbBuilder.create();
    private static final CategoriaDAO DAO = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configuración de encabezados para CORS
        response.setHeader("Access-Control-Allow-Origin", "*"); // Permite solicitudes desde cualquier origen
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS"); // Métodos permitidos
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        response.setContentType(APPLICATION_JSON);
        PrintWriter out = response.getWriter();

        List<Categoria> categorias = DAO.obtenerCategorias(); // Llamada directa al DAO
        String json = JSONB.toJson(categorias);

        out.write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
