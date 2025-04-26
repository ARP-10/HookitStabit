package com.hookitstabit.controller;

import com.hookitstabit.dao.ProductoDAO;
import com.hookitstabit.model.Producto;
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

@WebServlet("/api/productos/*")
public class ProductoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String APPLICATION_JSON = "application/json";
    private static final Jsonb JSONB = JsonbBuilder.create();
    private static final ProductoDAO DAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType(APPLICATION_JSON);
        PrintWriter out = response.getWriter();

        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                Producto producto = DAO.obtenerProductosId(id);

                if (producto != null) {
                    String json = JSONB.toJson(producto);
                    out.write(json);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.write("{\"error\":\"Producto no encontrado\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"error\":\"ID inválido\"}");
            }
        } else {
            List<Producto> productos = DAO.obtenterProductos();
            String json = JSONB.toJson(productos);
            out.write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
