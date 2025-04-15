package com.hookitstabit.main;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setEmail("crochetera@hookit.com");
        nuevoUsuario.setPassword("1234seguro");

        usuarioDAO.crearUsuario(nuevoUsuario);

        System.out.println("Usuario guardado con ID: " + nuevoUsuario.getId());
    }
}
