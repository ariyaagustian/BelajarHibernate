package com.gmail.ariyaagustian.training.dao;

import com.gmail.ariyaagustian.training.entity.KategoriBuku;
import org.hibernate.Session;

import java.util.List;

public class KategoriBukuDao {

    private final Session session;

    public KategoriBukuDao(Session session) {
        this.session = session;
    }

    public List<KategoriBuku> findAll() {
        return this.session.createQuery("from KategoriBuku").getResultList();
    }

    public KategoriBuku save(KategoriBuku kategory) {
        Integer primaryKey = (Integer) this.session.save(kategory);
        return this.findById(primaryKey);
    }

    public void save(List<KategoriBuku> list) {
        for (KategoriBuku kategory : list) {
            this.session.save(kategory);
        }
    }

    public KategoriBuku findById(Integer id) {
        return this.session.find(KategoriBuku.class, id);
    }
}
