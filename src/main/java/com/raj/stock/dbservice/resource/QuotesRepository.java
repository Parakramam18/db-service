package com.raj.stock.dbservice.resource;

import com.raj.stock.dbservice.model.Quote;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.raj.stock.dbservice.repository")
public interface QuotesRepository extends JpaRepository<Quote, Integer> {

    List<Quote> findByUserName(String userName);

}
