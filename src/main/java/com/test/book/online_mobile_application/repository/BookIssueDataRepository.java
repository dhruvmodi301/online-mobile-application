package com.test.book.online_mobile_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.book.online_mobile_application.entity.BookIssueData;

public interface BookIssueDataRepository extends JpaRepository<BookIssueData, Integer> {

}
