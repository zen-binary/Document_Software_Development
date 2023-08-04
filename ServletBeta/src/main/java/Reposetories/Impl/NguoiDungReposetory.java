package Reposetories.Impl;

import Config.HibernateConfig;
import Entity.ChucVu;
import Entity.NguoiDung;
import Reposetories.IReposetory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungReposetory implements IReposetory<NguoiDung> {
    @Override
    public List<NguoiDung> getAll() {
        List<NguoiDung> lst = new ArrayList<>();

        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NguoiDung ");
            lst = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public NguoiDung getObjById(long id) {
        NguoiDung nd = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            nd = session.get(NguoiDung.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }

    @Override
    public NguoiDung getObjByMa(String ma) {
        NguoiDung nd = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("select nd from NguoiDung nd where nd.ma = :ma");
            query.setParameter("ma", ma);
            nd = (NguoiDung) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }

    @Override
    public boolean save(NguoiDung entity) {
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
    public boolean update(NguoiDung entity) {
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
    public boolean delete(NguoiDung entity) {
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

    public NguoiDung getNguoiDungLogin(String user, String pass) {
        NguoiDung nd = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("select nd from NguoiDung nd where nd.ma = :user and nd.matKhau = :pass");
            query.setParameter("user", user);
            query.setParameter("pass", pass);
            nd = (NguoiDung) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }
}
