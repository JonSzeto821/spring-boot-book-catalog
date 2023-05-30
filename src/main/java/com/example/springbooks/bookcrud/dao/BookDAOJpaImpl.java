package com.example.springbooks.bookcrud.dao;

import com.example.springbooks.bookcrud.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOJpaImpl implements BookDAO {

    private final EntityManager entityManager;

    @Autowired
    public BookDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);

        return query.getResultList();
    }

    @Override
    public Book findById(int theId) {
        return entityManager.find(Book.class, theId);
    }
}
