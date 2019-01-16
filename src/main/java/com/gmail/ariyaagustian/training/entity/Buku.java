package com.gmail.ariyaagustian.training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "master_buku")
public class Buku {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "kode", nullable = false, unique = true, length = 64)
    private String id;

    @Column(name = "isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String judul;

    @Column(name = "nama_pengarang")
    private String namaPengarang;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;

    @Column(name = "nama_penerbit")
    private String namaPenerbit;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "last_update_date")
    private Timestamp lastUpdateDate;

    @Column(name = "last_update_by")
    private String lastUpdateBy;
}
