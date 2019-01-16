package com.gmail.ariyaagustian.training.dao;

import com.gmail.ariyaagustian.training.entity.Buku;
import org.hibernate.Session;

import java.util.List;

public class BukuDao {

    private final Session session;


    public List<Buku> findAll(){
        return this.session.createQuery("from Buku").getResultList();
    }

    public BukuDao(Session session) {
        this.session = session;
    }


    public Buku findById(String id) {
        return this.session.get(Buku.class, id);
    }

    public Buku save(Buku buku) {
        String primaryKey = (String) this.session.save(buku);
        buku = findById(primaryKey);
        return buku;
    }

    public Buku update(Buku buku) {
        this.session.update(buku);
        return buku;
    }

    public void deleteById(String id) {
        Buku buku = findById(id);
        this.session.delete(buku);
    }
}
