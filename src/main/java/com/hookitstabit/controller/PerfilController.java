package com.hookitstabit.controller;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/perfil")
public class PerfilController {
    private static final UsuarioDAO DAO = new UsuarioDAO();

    // Este endpoint devuelve el perfil del usuario autenticado
    @GET
    public Response getPerfil(@HeaderParam("Authorization") String authHeader) {
        // Aquí debes obtener el ID del usuario desde el token o sesión
        int userId = obtenerUsuarioIdDesdeToken(authHeader);  // Función que parsea el JWT o sesión

        if (userId == -1) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario no autenticado").build();
        }

        // Obtiene el perfil del usuario a partir de su ID
        Usuario usuario = DAO.obtenerUsuariosId(userId);

        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
        }

        // Devuelve los datos del perfil
        return Response.ok(usuario).build();
    }

    // Este método simula la obtención del ID desde el token (deberías hacerlo de forma segura)
    private int obtenerUsuarioIdDesdeToken(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);  // Obtener token sin la palabra "Bearer "
            // Aquí deberías decodificar el JWT y obtener el ID del usuario
            return 123;  // Simulando un ID de usuario para pruebas
        }
        return -1;  // Si no hay token, retornamos un ID no válido
    }
}
