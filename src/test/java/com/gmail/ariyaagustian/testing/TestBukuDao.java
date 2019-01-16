package com.gmail.ariyaagustian.testing;

import com.gmail.ariyaagustian.training.configuration.SessionFactoryUtil;
import com.gmail.ariyaagustian.training.dao.BukuDao;
import com.gmail.ariyaagustian.training.entity.Buku;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

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
        session.beginTransaction();

        Buku pemograman = new Buku(
                "2344-1234324",
                "Bahasa Pemograman",
                "Dimas Maryanto",
                2019,
                "INformatika");

        log.info("before save: {}", pemograman.toString());
        pemograman = dao.save(pemograman);

        log.info("after save: {}", pemograman.toString());
        session.getTransaction().commit();

        assertNotNull(pemograman.getId());
        assertEquals("nama pengarang", pemograman.getNamaPengarang(), "Dimas Maryanto");

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
        session.close();
    }
}
