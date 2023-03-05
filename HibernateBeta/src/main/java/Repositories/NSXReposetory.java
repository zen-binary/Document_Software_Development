/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
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
public class NSXReposetory {
    private static Session session = HibernateConfig.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    public List<NSX> getLstDb() {
        List<NSX> lst = new ArrayList<>();
        Query query = session.createQuery("SELECT nsx FROM NSX nsx");
        lst = query.getResultList();
        return lst;

    }

    public boolean save(NSX nsx) {

        try {
            transaction.begin();
            session.saveOrUpdate(nsx);
            transaction.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        
    }

    public boolean delete(NSX nsx) {

        try {
            transaction.begin();
            session.delete(nsx);
            transaction.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }

        
    }
    
    public NSX getObj(String ma){
        NSX nsx = new NSX();
        try {
            Query query = session.createQuery("SELECT nsx FROM NSX nsx WHERE nsx.ma = :ma");
            query.setParameter("ma", ma);
            nsx = (NSX) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return nsx;
    }
    
    
}
