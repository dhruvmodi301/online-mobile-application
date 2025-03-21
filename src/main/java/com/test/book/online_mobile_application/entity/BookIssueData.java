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
@Table(name= "book_issue")
public class BookIssueData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_issue_id")
    private Integer bookIssueId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "date_returned")
    private LocalDateTime dateReturned;

    @Column(name = "borrow_amount")
    private Double borrowAmount;

    @Column(name = "late_return_fee_amount")
    private Double lateReturnFeeAmount;

    @Column(name = "order_id")
    private Integer orderId;
}