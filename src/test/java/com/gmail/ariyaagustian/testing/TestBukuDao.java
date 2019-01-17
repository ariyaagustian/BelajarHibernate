package com.gmail.ariyaagustian.testing;

import com.gmail.ariyaagustian.training.hibernate.configuration.SessionFactoryUtil;
import com.gmail.ariyaagustian.training.hibernate.dao.BukuDao;
import com.gmail.ariyaagustian.training.hibernate.dao.KategoriBukuDao;
import com.gmail.ariyaagustian.training.hibernate.entity.Buku;
import com.gmail.ariyaagustian.training.hibernate.entity.KategoriBuku;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestBukuDao extends TestCase {

    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        SessionFactoryUtil util = new SessionFactoryUtil();
        this.sessionFactory = util.getSessionFactory();
    }

    @Test
    public void testBukuDao() {
        Session session = sessionFactory.openSession();
        BukuDao dao = new BukuDao(session);
        KategoriBukuDao kategoryDao = new KategoriBukuDao(session);
        session.beginTransaction();

        KategoriBuku it = new KategoriBuku("Ilmu komputer", null);

        KategoriBuku matematika = new KategoriBuku("Matematika", null);


        kategoryDao.save(Arrays.asList(it, matematika));
//        kategoryDao.save(matematika);

        List<KategoriBuku> listKategoryBuku = kategoryDao.findAll();


        Buku pemograman = new Buku(
                "2344-1234324",
                "Bahasa Pemograman",
                "Dimas Maryanto",
                2019,
                "INformatika",
                listKategoryBuku,
                it);

        log.info("before save: {}", pemograman.toString());
        pemograman = dao.save(pemograman);

        log.info("after save: {}", pemograman.toString());
        session.getTransaction().commit();

        assertNotNull(pemograman.getId());
        assertEquals("nama pengarang", pemograman.getNamaPengarang(), "Dimas Maryanto");

        assertEquals("daftar kategory",
                pemograman.getList().size(),
                2);

        List<Buku> daftarBuku = dao.findAll();
        assertEquals("jumlah daftar buku bertambah", daftarBuku.size(), 1);

        session.beginTransaction();
        Buku bukuPemograman = dao.findById(pemograman.getId());
        bukuPemograman.setNamaPengarang("Rega");
        dao.update(bukuPemograman);

        bukuPemograman = dao.findById(bukuPemograman.getId());
        log.info("after update: {}", bukuPemograman);

        assertSame("nama pengarang sama dengan rega",
                bukuPemograman.getNamaPengarang(),
                "Rega");

        session.getTransaction().commit();



        session.beginTransaction();

        daftarBuku = dao.findAll();
        log.info("Buku findAll(): {}", daftarBuku);
        daftarBuku = dao.findByName("kom");
        log.info("Buku findByName(): {}", daftarBuku);
        daftarBuku = dao.findByKategoryBuku(it.getId());
        log.info("Buku findByKategoriId(): {}", daftarBuku);

        List<KategoriBuku> daftarKategori = kategoryDao.findAll();
        log.info("Kategori findAll(): {}", daftarKategori);
        daftarKategori = kategoryDao.findByName("kom");
        log.info("Kategori findByName(): {}", daftarKategori);
        daftarKategori = kategoryDao.findByNameAndDescription("kom", "asdf");
        log.info("Kategori findByNameDesc(): {}", daftarKategori);
        daftarKategori = kategoryDao.findBetweenByCreatedDate(
                Timestamp.valueOf(
                        LocalDateTime.of(2018, 12, 1, 0, 0, 0)
                ),
                Timestamp.valueOf(
                        LocalDateTime.now().plusDays(2)
                )
        );
        log.info("Kategori findBetweenDate(): {}", daftarKategori);

        session.getTransaction().commit();


        session.close();
    }
}
