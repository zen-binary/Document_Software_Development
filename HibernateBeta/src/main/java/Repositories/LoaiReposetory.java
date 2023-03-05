/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.Loai;
import HibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class LoaiReposetory {
    private static Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    public List<Loai> getLstDb() {
        List<Loai> lst = new ArrayList<>();
        Query query = session.createQuery("SELECT l FROM Loai l");
        lst = query.getResultList();
        return lst;

    }

    public boolean save(Loai l) {

        try {
            transaction.begin();
            session.saveOrUpdate(l);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        
    }

    public boolean delete(Loai l) {

        try {
            transaction.begin();
            session.delete(l);
            transaction.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }

        
    }
    
    public Loai getObj(String ma){
        Loai cv = new Loai();
        try {
            Query query = session.createQuery("SELECT l FROM Loai l WHERE l.ma = :ma");
            query.setParameter("ma", ma);
            cv = (Loai) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return cv;
    }
}
