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

@WebServlet("/api/productos")
public class ProductoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String APPLICATION_JSON = "application/json";
    private static final Jsonb JSONB = JsonbBuilder.create();
    private static final ProductoDAO DAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType(APPLICATION_JSON);
        PrintWriter out = response.getWriter();

        List<Producto> productos = DAO.obtenterProductos();
                String json = JSONB.toJson(productos);

        out.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(APPLICATION_JSON);
        try {
            // TODO: Asegurarnos que categoria entra sin problemas, es donde da error
            // Leer la petición
            Producto producto = JSONB.fromJson(request.getReader(), Producto.class);
            DAO.crearProducto(producto);

            // Responder
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("{\"message\": \"Producto creado con éxito\"}");
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Error al crear el producto\"}");
        }
    }

}
