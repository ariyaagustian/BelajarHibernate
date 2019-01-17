package com.gmail.ariyaagustian.training.hibernate.dao;

import com.gmail.ariyaagustian.training.hibernate.entity.Buku;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BukuDao {

    private final Session session;


    /**
     * penggunaan query HQL = Hibernate Query Language
     * sama seperti query
     * select * from master_buku;
     * @return
     */
    public List<Buku> findAll(){
        return this.session.createQuery("from Buku").getResultList();
    }


    /**
     * sama seperti query
     * select * from master_buku where title like ? order by title
     * @param judulBuku
     * @return
     */
    public List<Buku> findByName(String judulBuku) {
        Query query = this.session.createQuery("from Buku where judul like :judul order by judul");
        query.setParameter("judul",
                new StringBuilder("%")
                        .append(judulBuku.toLowerCase())
                        .append("%").toString()
        );

        return query.getResultList();
    }


    /**
     * sama seperti query
     * select * from master_buku where kategory_id = ?
     * @param idKategory
     * @return
     */
    public List<Buku> findByKategoryBuku(Integer idKategory) {
        Query query = this.session.createQuery("from Buku where kategoryBuku.id = :kategoryBukuId");
        query.setParameter("kategoryBukuId", idKategory);
        return query.getResultList();
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
