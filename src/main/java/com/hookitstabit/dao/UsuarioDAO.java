package com.hookitstabit.dao;

import com.hookitstabit.model.Usuario;
import com.hookitstabit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UsuarioDAO {

    public void guardar(Usuario usuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(usuario);
            tx.commit();
        }
    }

    public Usuario buscarPorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        }
    }

    public List<Usuario> obtenerTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Usuario", Usuario.class).list();
        }
    }

    public void eliminar(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Usuario usuario = buscarPorId(id);
            if (usuario != null) {
                session.remove(usuario);
            }
            tx.commit();
        }
    }
}
