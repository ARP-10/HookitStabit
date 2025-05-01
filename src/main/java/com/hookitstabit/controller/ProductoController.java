package com.hookitstabit.controller;

import com.hookitstabit.dao.ProductoDAO;
import com.hookitstabit.model.Producto;
import jakarta.ws.rs.*;

@Path("/productos")
public class ProductoController  {
    private static final ProductoDAO DAO = new ProductoDAO();

    @GET
    public Iterable<Producto> getProductos() {
        return DAO.obtenterProductos();
    }

    @GET
    @Path("/{id}")
    public Producto getProducto(@PathParam("id") int id) {
        return DAO.obtenerProductosId(id);
    }

    @POST
    public Producto postProducto(Producto producto) {
        DAO.crearProducto(producto);
        return producto;
    }

    // TODO: pendiente @PUT y @DELETE

}
