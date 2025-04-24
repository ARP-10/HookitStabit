package com.hookitstabit.main;

import com.hookitstabit.dao.CategoriaDAO;
import com.hookitstabit.dao.UsuarioDAO;
import com.hookitstabit.model.Categoria;
import com.hookitstabit.model.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        // Obtener las categorías
        List<Categoria> categorias = categoriaDAO.obtenerCategorias();

        // Imprimir las categorías en la consola
        if (categorias != null && !categorias.isEmpty()) {
            System.out.println("Categorías obtenidas:");
            for (Categoria categoria : categorias) {
                System.out.println("- " + categoria.getNombre()); // Asegúrate de que 'getNombre' es un método de tu clase Categoria
            }
        } else {
            System.out.println("No se encontraron categorías.");
        }
    }
}
