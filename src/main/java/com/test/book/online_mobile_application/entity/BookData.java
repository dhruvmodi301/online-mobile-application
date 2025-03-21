package com.test.book.online_mobile_application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "book")
public class BookData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publisher_id")
    private Integer publisherId;

    @Column(name = "book_file_name")
    private String bookFileName;

    @Column(name = "borrow_duration")
    private Integer borrowDuration;

    @Column(name = "borrow_price")
    private Double borrowPrice;
}