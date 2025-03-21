package com.test.book.online_mobile_application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.book.online_mobile_application.dto.BookRequestDTO;
import com.test.book.online_mobile_application.entity.BookData;
import com.test.book.online_mobile_application.service.BookDataService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        return bookDataService.updateBook(id, bookRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        log.debug("id: {}", id);
        return bookDataService.deleteBook(id);
    }

    @GetMapping("/download-book/{orderId}/{bookId}")
    public void downlaodBook(@PathVariable Integer orderId, @PathVariable Integer bookId, HttpServletResponse response) throws IOException {
        BookData bookData = bookDataService.getBookDataByBookIdAndOrderId(bookId, orderId);

        if (bookData == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book is not exist for download");
            return;
        }

        String fileName = bookData.getBookFileName();
        Path filePath = Paths.get("D:/" + fileName);
    File file = filePath.toFile();

    if (!file.exists()) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
        return;
    }
    
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    Files.copy(filePath, response.getOutputStream());
    response.getOutputStream().flush();
    }
    
}