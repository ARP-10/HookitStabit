package com.hookitstabit.dao;

import com.hookitstabit.model.Categoria;
import com.hookitstabit.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoriaDAO {
    // Leer todas las categorias
    public List<Categoria> obtenerCategorias() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Categoria", Categoria.class).list();
        }
    }

    // TODO: Filtrar por categorias?
}
