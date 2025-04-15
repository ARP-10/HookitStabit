package com.hookitstabit.main;

import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("Todos los usuarios: " + usuarioDAO.obtenerUsuarios());
        System.out.println("Usuario con el id 1: " + usuarioDAO.obtenerUsuariosId(1));
    }
}
