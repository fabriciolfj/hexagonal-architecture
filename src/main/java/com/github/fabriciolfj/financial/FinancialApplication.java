package com.github.fabriciolfj.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@EnableJpaRepositories(basePackages = {"com.github.fabriciolfj.financial.account.adapter.out.persistence"})
@ComponentScan(basePackages = "com.github.fabriciolfj.financial")
@EntityScan(basePackages = {"com.github.fabriciolfj.financial.account.adapter.out.persistence"})
@SpringBootApplication
public class FinancialApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialApplication.class, args);
	}

}
