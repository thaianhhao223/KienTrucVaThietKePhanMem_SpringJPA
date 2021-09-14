package com.example.springjpa;

import com.example.springjpa.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);

    }
    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }
    @Bean
    public CommandLineRunner run(EmployeeRepository repository){
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
        };
    }
}
