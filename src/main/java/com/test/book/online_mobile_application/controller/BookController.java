package com.test.book.online_mobile_application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.book.online_mobile_application.dto.BookRequestDTO;
import com.test.book.online_mobile_application.service.BookDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookDataService bookDataService;

    @PostMapping("/create")
    public String createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        log.debug("bookRequestDTO: {}", bookRequestDTO);
        System.out.println(bookRequestDTO);

        return bookDataService.createBook(bookRequestDTO);
    }

    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable Integer id, @RequestBody BookRequestDTO bookRequestDTO) {
        log.debug("id: {} bookRequestDTO: {}", id, bookRequestDTO);
        return "";
    }
}