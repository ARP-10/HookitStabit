package com.hookitstabit.controller;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/perfil")
public class PerfilController {
    private static final UsuarioDAO DAO = new UsuarioDAO();

    @GET
    @Path("/{id}")
    public Response getPerfilPorId(@PathParam("id") int id) {
        Usuario usuario = DAO.obtenerUsuariosId(id);

        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
        }

        return Response.ok(usuario).build();
    }
}
