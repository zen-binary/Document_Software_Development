package Reposetories.Impl;

import Config.HibernateConfig;
import Entity.ChucVu;
import Reposetories.IReposetory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ChucVuReposetory implements IReposetory<ChucVu> {
//    private Session session;
//    private Transaction transaction;
//
//    public ChucVuReposetory() {
//        session = HibernateConfig.getFACTORY().openSession();
//        transaction = session.getTransaction();
//    }

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> lst = new ArrayList<>();

        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ");
            lst = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    @Override
    public ChucVu getObjById(long id) {
        ChucVu cv = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            cv = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    @Override
    public ChucVu getObjByMa(String ma) {
        ChucVu cv = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT cv from ChucVu cv where cv.ma = :ma");
            query.setParameter("ma", ma);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    @Override
    public boolean save(ChucVu entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ChucVu entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(ChucVu entity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.delete(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
