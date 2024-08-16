package com.apple.shop;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Announce {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String title;
    public Date date;

}
