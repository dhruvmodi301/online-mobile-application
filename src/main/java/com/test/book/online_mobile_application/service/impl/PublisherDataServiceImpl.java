package com.test.book.online_mobile_application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.book.online_mobile_application.entity.PublisherData;
import com.test.book.online_mobile_application.repository.PublisherDataRepository;
import com.test.book.online_mobile_application.service.PublisherDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PublisherDataServiceImpl implements PublisherDataService {

    private final PublisherDataRepository repository;

    @Override
    public List<PublisherData> getPublisherDataByPublisherName(String publisherName) {
        return repository.findByPublisherNameIgnoreCase(publisherName);
    }

    @Override
    public PublisherData createPublisherData(String publisherName) {
        PublisherData publisherData = new PublisherData();
        publisherData.setPublisherName(publisherName);
        publisherData = repository.save(publisherData);
        return publisherData;
    }

}
