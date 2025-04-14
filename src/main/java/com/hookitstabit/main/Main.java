package com.hookitstabit.main;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instancia del DAO
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // 1️⃣ Crear un nuevo usuario
        Usuario nuevoUsuario = new Usuario(0, "correo@example.com", "12345");
        usuarioDAO.guardar(nuevoUsuario);
        System.out.println("✅ Usuario guardado: " + nuevoUsuario.getEmail());

        // 2️⃣ Buscar usuario por ID
        Usuario usuarioEncontrado = usuarioDAO.buscarPorId(1);
        if (usuarioEncontrado != null) {
            System.out.println("🔍 Usuario encontrado: " + usuarioEncontrado.getEmail());
        } else {
            System.out.println("⚠️ No se encontró el usuario con ID 1.");
        }

        // 3️⃣ Obtener todos los usuarios
        List<Usuario> usuarios = usuarioDAO.obtenerTodos();
        System.out.println("📋 Lista de usuarios:");
        usuarios.forEach(u -> System.out.println(" - " + u.getEmail()));

        // 4️⃣ Eliminar usuario por ID
        usuarioDAO.eliminar(1);
        System.out.println("🗑️ Usuario con ID 1 eliminado.");

    }
}
