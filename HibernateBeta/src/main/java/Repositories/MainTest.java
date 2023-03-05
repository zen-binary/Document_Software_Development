/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.Loai;
import DomainModels.NSX;
import DomainModels.SanPham;
import HibernateConfig.HibernateConfig;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class MainTest {

    public static void main(String[] args) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Transaction transaction = session.getTransaction();

//        SanPham sp = new SanPham();
//        sp.setTen("Tesst");
//        sp.setMa("SP00T2");
//        
//        Loai l = session.get(Loai.class, 1);
//        sp.setIdLoai(l);
//        
//        NSX n = session.get(NSX.class, 1);
//        System.out.println(n.toString());
//        Set<NSX> nsx = new HashSet<>();
//        nsx.add(n);
//        nsx.add(session.get(NSX.class, 2));
//        sp.setNsx(nsx);
//        transaction.begin();
//        session.save(sp);
//        transaction.commit();
//        
//          NSX n = session.get(NSX.class, 1);
//          n.getSanPhams().forEach(p -> System.out.printf("%s %s\n-----------", p.getTen(), p.getNsx()));
//        
//
//          -------Criteria Query API--------thuoc java persisten api (jpa)
        //b1 tao CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();
        //b2 tao CriteriaQuery
        CriteriaQuery<SanPham> query = builder.createQuery(SanPham.class);
        //b3 tao root muon join 2 bang tao 2 root va tuong duong
        Root root = query.from(SanPham.class);
        //Lay sp co dk
        //b1: tao Predicate
        Predicate p1 = builder.like(root.get("ma").as(String.class), "%01");
        Predicate p2 = builder.like(root.get("ma").as(String.class), "%04");
//        Predicate p3 = builder.lessThan(root.get("gia").as(double.class),1000);
//        Predicate p4 = builder.between(root.get("gia").as(double.class), 0, 1000);

        query = query.where(builder.or(p1, p2));

        //Lay all sp
        query = query.select(root);
        Query q = session.createQuery(query);

        List<SanPham> lst = q.getResultList();
        for (SanPham sp : lst) {
            System.out.println(sp.toString());
        }

        //có di?u kien
//        CriteriaQuery<Object[]> queryy = builder.createQuery(Object[].class);
////        Root root = queryy.from(SanPham.class);
//        query = query.multiselect(builder.count(root.get("id").as(Integer.class)),
//                builder.max(root.get("gia").as(double.class)));
            //https://www.youtube.com/watch?v=TD3wFQOzYFI&list=PLlVHoHHccp29X8UyT5O10fKjnu1KM8cac&index=4

    }
}
