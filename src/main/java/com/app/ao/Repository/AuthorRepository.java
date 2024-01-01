package com.app.ao.Repository;

import com.app.ao.Entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
