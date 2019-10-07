package com.virtusa.jpmc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.jpmc.management.models.Book;

/**
 * @author oktay
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
