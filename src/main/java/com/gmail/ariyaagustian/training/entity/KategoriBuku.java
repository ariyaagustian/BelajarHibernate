package com.gmail.ariyaagustian.training.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "master_kategori_buku")
public class KategoriBuku {

    public KategoriBuku(String nama, String description) {
        this.nama = nama;
        this.description = description;
        this.createdDate = Timestamp.valueOf(LocalDateTime.now());
        this.createdBy = "admin";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kode", nullable = false, unique = true, length = 64)
    private Integer id;

    @Column(name = "kategori", length = 50, nullable = false)
    private String nama;

    @Lob
    @Column(name = "keterangan")
    private String description;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "last_update_date")
    private Timestamp lastUpdateDate;

    @Column(name = "last_Update_by")
    private String lastUpdateBy;
}