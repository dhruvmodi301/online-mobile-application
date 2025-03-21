package com.test.book.online_mobile_application.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookRequestDTO {

    private String bookTitle;
    private String isbn;
    private String publisherName;
    private MultipartFile file;
    private Integer borrowDuration;
    private Double borrowPrice;
}