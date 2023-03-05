/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
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
public class SanPhamReposetory {
    private static Session session = HibernateConfig.getFACTORY().openSession();
   private Transaction transaction = session.getTransaction();
   
   public List<SanPham> getLstDb(){
       List<SanPham> lst = new ArrayList<>();
       Query query = session.createQuery("FROM SanPham");
       lst = query.getResultList();
       return lst;
   }
   
   public boolean save(SanPham sp){
       try {
           transaction.begin();
           session.saveOrUpdate(sp);
           transaction.commit();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           transaction.rollback();
       }
       return false;
   }
   public boolean delete(SanPham sp){
       try {
           transaction.begin();
           session.delete(sp);
           transaction.commit();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           transaction.rollback();
       }
       return false;
   }
   
   public SanPham getObj(String ma){
       SanPham sp = null;
       Query query = session.createQuery("SELECT sp FROM SanPham sp WHERE sp.ma = :ma");
       query.setParameter("ma", ma);
       sp = (SanPham) query.getSingleResult();
       return sp;
       
   }
}
