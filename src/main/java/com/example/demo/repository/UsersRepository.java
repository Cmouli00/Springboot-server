package com.example.demo.repository;

import java.util.List;

import com.example.demo.object.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String Name);
}