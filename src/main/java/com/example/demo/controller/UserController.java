package com.example.demo.controller;

import com.example.demo.object.Person;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    // @GetMapping("/getUserDetails")
    // public String getUserDetails(@RequestHeader String name){
    //     return "Req name "+name;
    // }
   
    // @PostMapping("/createUser")
    // public String createNewUser(@RequestBody Person person){
    //     return "Created new user"+person.getName();
    // }
    // @PutMapping("/updateUser")
    // public String updateUser(){
    //     return "Updated";
    // }
    // @DeleteMapping("/deleteUser")
    // public String deleteUser(){
    //     return "Deleted";
    // }

    //to get data from database Mysql

    // @Autowired
    // UsersRepository userRepository;

    // @GetMapping(value = "/all")
    // public List<Person> getAll(){
    //     return userRepository.findAll();
    // }

    // @PostMapping(value ="/load")
    // public List<Person> persist(@RequestBody Person person ){
    //     userRepository.save(person);
    //     return userRepository.findAll();
    // }

    //using javascript client
    @Autowired
    UsersRepository repository;
   
    @GetMapping("/persons")
    public List<Person> getAllCustomers() {
      System.out.println("Get all persons...");
   
      List<Person> person = new ArrayList<>();
      repository.findAll().forEach(person::add);
   
      return person;
    }

    @GetMapping(value = "persons/name/{name}")
    public List<Person> findByName(@PathVariable String name) {
 
    List<Person> person = repository.findByName(name);
    return person;
  }
 

    
}