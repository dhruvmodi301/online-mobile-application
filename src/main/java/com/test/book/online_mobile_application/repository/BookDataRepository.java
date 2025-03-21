package com.test.book.online_mobile_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.book.online_mobile_application.entity.BookData;

public interface BookDataRepository extends JpaRepository<BookData, Integer> {

}