package com.hookitstabit.dao;

import com.hookitstabit.model.Usuario;
import com.hookitstabit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {
    //TODO: Borrar los metodos que no se usen
// Crear
    public void crearUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            // Si ocurre un error, se revierte la transacción (rollback) y se imprime la traza del error.
            if (transaction != null) transaction.rollback();
            System.err.println("Error al guardar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Leer (por ID)
    public Usuario obtenerUsuariosId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        }
    }

    public Usuario obtenerUsuarioPorEmail(String email){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM Usuario WHERE email = :email", Usuario.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    // Actualizar
    public void actualizarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Borrar por ID
    public void eliminarUsuario(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);

            if (usuario != null) {
                session.remove(usuario);
                transaction.commit();
                System.out.println("Usuario con ID: " + id + " ha sido eliminado.");
            } else {
                System.out.println("No se encontró un usuario con el id " + id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
