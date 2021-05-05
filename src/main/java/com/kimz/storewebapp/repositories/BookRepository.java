package com.kimz.storewebapp.repositories;

import com.kimz.storewebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
