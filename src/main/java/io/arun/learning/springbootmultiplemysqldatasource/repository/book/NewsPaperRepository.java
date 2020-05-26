package io.arun.learning.springbootmultiplemysqldatasource.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import io.arun.learning.springbootmultiplemysqldatasource.model.book.NewsPaper;

public interface NewsPaperRepository extends JpaRepository<NewsPaper, Long>{

}
