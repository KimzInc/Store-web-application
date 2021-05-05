package com.kimz.storewebapp.repositories;

import com.kimz.storewebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
