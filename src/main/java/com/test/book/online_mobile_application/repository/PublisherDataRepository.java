package com.test.book.online_mobile_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.book.online_mobile_application.entity.PublisherData;

public interface PublisherDataRepository extends JpaRepository<PublisherData, Integer>{

    List<PublisherData> findByPublisherNameIgnoreCase(String publisherName);
}