package com.test.book.online_mobile_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.book.online_mobile_application.entity.BookData;

public interface BookDataRepository extends JpaRepository<BookData, Integer> {

    @Query("select b from BookData b join BookIssueData bi on b.bookId = bi.bookId where b.bookId= :bookId and bi.orderId = :orderId")
    BookData getBookDataByBookIdAndOrderId(Integer bookId, Integer orderId);
}