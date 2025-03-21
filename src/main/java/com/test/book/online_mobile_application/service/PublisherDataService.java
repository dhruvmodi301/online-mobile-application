package com.test.book.online_mobile_application.service;

import java.util.List;

import com.test.book.online_mobile_application.entity.PublisherData;

public interface PublisherDataService {

    List<PublisherData> getPublisherDataByPublisherName(String publisherName);

    PublisherData createPublisherData(String publisherName);
}