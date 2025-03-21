package com.test.book.online_mobile_application.service.impl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.book.online_mobile_application.dto.BookRequestDTO;
import com.test.book.online_mobile_application.entity.BookData;
import com.test.book.online_mobile_application.entity.PublisherData;
import com.test.book.online_mobile_application.repository.BookDataRepository;
import com.test.book.online_mobile_application.service.BookDataService;
import com.test.book.online_mobile_application.service.PublisherDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookDataServiceImpl implements BookDataService {

    private final BookDataRepository repository;
    private final PublisherDataService publisherDataService;

    @Override
    public String createBook(BookRequestDTO bookRequestDTO) {
        log.debug("Inside createBook");

        try {
            BookData bookData = new BookData();
            bookData.setBookTitle(bookRequestDTO.getBookTitle());
            bookData.setIsbn(bookRequestDTO.getIsbn());
    
            List<PublisherData> publisherDataList = publisherDataService.getPublisherDataByPublisherName(bookRequestDTO.getPublisherName());
    
            PublisherData publisherData = null;
            if (publisherDataList.isEmpty()) {
                publisherData = publisherDataService.createPublisherData(bookRequestDTO.getPublisherName());
            } else {
                publisherData = publisherDataList.get(0);
            }
    
            bookData.setPublisherId(publisherData.getPublisherId());
    
            MultipartFile file = bookRequestDTO.getFile();
            String fileName = bookRequestDTO.getIsbn() + "_" + file.getOriginalFilename();
            file.transferTo(new File("D:\\" + fileName));

            bookData.setBookFileName(fileName);
            bookData.setBorrowDuration(bookRequestDTO.getBorrowDuration());
            bookData.setBorrowPrice(bookRequestDTO.getBorrowPrice());
            bookData = repository.save(bookData);
    
            log.debug("Leaving createBook bookData: {}", bookData);
            return "Success";
        } catch (Exception exception) {
            log.error("Exception occurred while creating book. Error Message: {}", exception.getMessage(), exception);
            return exception.getMessage();
        }
    }

    @Override
    public String updateBook(Integer id, BookRequestDTO bookRequestDTO) {
        Optional<BookData> optionalBookData = repository.findById(id);

        if (optionalBookData.isEmpty()) {
            return "Invalid book id";
        }

        return "";
    }
}
