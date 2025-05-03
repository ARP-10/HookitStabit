package com.hookitstabit.controller;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    private static final UsuarioDAO DAO = new UsuarioDAO();

    @GET
    @Path("/{id}")
    public Usuario getUsuario(@PathParam("id") int id) {
        return DAO.obtenerUsuariosId(id);
    }

    @POST
    @Path("/nuevo")
    public Usuario postUsuario(Usuario usuario) {
        DAO.crearUsuario(usuario);
        return usuario;
    }

    // Autenticacion
    @POST
    @Path("/validar")
    public Response validarUsuario(Usuario datosLogin) {
        Usuario usuarioExistente = DAO.obtenerUsuarioPorEmail(datosLogin.getEmail());

        // Muestra el error de email o pass o ambos
        if (usuarioExistente == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("email").build();
        } else if (!usuarioExistente.getPassword().equals(datosLogin.getPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("password").build();
        } else {
            return Response.ok(usuarioExistente).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Usuario putUsuario(@PathParam("id") int id, Usuario usuario) {
        DAO.actualizarUsuario(usuario);
        return usuario;
    }

    @DELETE
    @Path("{id}")
    public void deleteUsuario(@PathParam("id") int id) {
        DAO.eliminarUsuario(id);
    }

}
