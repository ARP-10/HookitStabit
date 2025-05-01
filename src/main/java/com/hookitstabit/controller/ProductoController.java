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
        // Respuesta en JSON
        response.setContentType(APPLICATION_JSON);
        PrintWriter out = response.getWriter();

        // Vemos si nos han pasado un ID, recogemos lo que viene después de api/productos
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.length() > 1) {
            try {
                // Si existe un ID, lo convertimos a número
                int id = Integer.parseInt(pathInfo.substring(1)); // Elimina la primera '/' y parsea el número
                Producto producto = DAO.obtenerProductosId(id);

                // Si existe el producto, lo convertimos a JSON y mandamos la respuesta
                if (producto != null) {
                    String json = JSONB.toJson(producto);
                    out.write(json);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.write("{\"error\":\"Producto no encontrado\"}");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"error\":\"ID invalido\"}");
            }
        } else {
            // Si no hay un ID, se devuelve la lista de productos completa
            List<Producto> productos = DAO.obtenterProductos();
            String json = JSONB.toJson(productos);
            out.write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType(APPLICATION_JSON);
        PrintWriter out = response.getWriter();

        // ?id=1

        try {
            // Leemos el JSON del cliente
            Producto nuevoProducto = JSONB.fromJson(request.getInputStream(), Producto.class);

            // Guardamos el producto en la bbdd
            Producto productoCreado = DAO.crearProducto(nuevoProducto);

            if (productoCreado != null) {
                response.setStatus(HttpServletResponse.SC_CREATED); // 201
                String json = JSONB.toJson(productoCreado);
                out.write(json);
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.write("{\"error\":\"No se pudo crear el producto\"}");
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{\"error\":\"Datos del producto invalidos\"}");
            e.printStackTrace();
        }
    }

}
