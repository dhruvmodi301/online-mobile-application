package com.test.book.online_mobile_application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "member")
public class MemberData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "membership_date")
    private LocalDateTime membershipDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}