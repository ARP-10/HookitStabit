package com.hookitstabit.dao;

import com.hookitstabit.model.Producto;
import com.hookitstabit.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public Producto crearProducto(Producto producto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto);  // Cambié persist() por save()
            transaction.commit();
            return producto;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al guardar el producto: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    public List<Producto> obtenterProductos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Producto", Producto.class).list();
        }
    }

    public Producto obtenerProductosId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Producto.class, id);
        }
    }

    public List<Producto> obtenerProductosPorUsuario(int usuarioId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Producto p WHERE p.usuario.id = :usuarioId";
            return session.createQuery(hql, Producto.class)
                    .setParameter("usuarioId", usuarioId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void actualizarProducto(Producto producto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Producto producto = session.get(Producto.class, id);

            if (producto != null) {
                session.remove(producto);
                transaction.commit();
                System.out.println("Producto con ID: " + id + " ha sido eliminado.");
            } else {
                System.out.println("No se encontró un producto con el id " + id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
