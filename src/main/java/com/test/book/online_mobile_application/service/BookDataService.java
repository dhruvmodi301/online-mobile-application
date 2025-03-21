package com.test.book.online_mobile_application.service;

import com.test.book.online_mobile_application.dto.BookRequestDTO;

public interface BookDataService {
    String createBook(BookRequestDTO bookRequestDTO);

    String updateBook(Integer id, BookRequestDTO bookRequestDTO);

    String deleteBook(Integer id);
}
