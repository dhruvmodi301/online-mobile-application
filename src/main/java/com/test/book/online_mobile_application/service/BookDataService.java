package com.test.book.online_mobile_application.service;

import com.test.book.online_mobile_application.dto.BookRequestDTO;
import com.test.book.online_mobile_application.entity.BookData;

public interface BookDataService {
    String createBook(BookRequestDTO bookRequestDTO);

    String updateBook(Integer id, BookRequestDTO bookRequestDTO);

    String deleteBook(Integer id);

    BookData getBookDataByBookIdAndOrderId(Integer bookId, Integer orderId);
}
