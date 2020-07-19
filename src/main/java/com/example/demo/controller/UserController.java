package com.example.demo.controller;

import com.example.demo.object.Person;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

  // @GetMapping("/getUserDetails")
  // public String getUserDetails(@RequestHeader String name){
  // return "Req name "+name;
  // }

  // @PostMapping("/createUser")
  // public String createNewUser(@RequestBody Person person){
  // return "Created new user"+person.getName();
  // }
  // @PutMapping("/updateUser")
  // public String updateUser(){
  // return "Updated";
  // }
  // @DeleteMapping("/deleteUser")
  // public String deleteUser(){
  // return "Deleted";
  // }

  // to get data from database Mysql

  // @Autowired
  // UsersRepository userRepository;

  // @GetMapping(value = "/all")
  // public List<Person> getAll(){
  // return userRepository.findAll();
  // }

  // @PostMapping(value ="/load")
  // public List<Person> persist(@RequestBody Person person ){
  // userRepository.save(person);
  // return userRepository.findAll();
  // }

  // using javascript client
  @Autowired
  UsersRepository repository;

  @GetMapping("/persons")
  public List<Person> getAllCustomers() {
    System.out.println("Get all persons...");

    List<Person> person = new ArrayList<>();
    repository.findAll().forEach(person::add);

    return person;
  }

  @GetMapping("/persons/{id}")
  public Optional<Person> findById(@PathVariable Long id) {
    Optional<Person> person = repository.findById(id);
      return person;
    }

    @GetMapping(value = "persons/name/{name}")
    public List<Person> findByName(@PathVariable String name) {
 
    List<Person> person = repository.findByName(name);
    return person;
  }

  @PostMapping("persons/create")
  public Person create(@RequestBody Person person) {
    System.out.println("Adding...");
    Person person1 = repository.save(new Person(person.getName(),person.getMail()));
    return person1;
}

// @PutMapping("/update/{id}")
// public Person updateEmployee(@PathVariable long id, @RequestBody Person person) {
//         System.out.println("Updating...");
//         person.setId(id);
//         repository.save(person);
//         return person;
// }

@PutMapping("/persons/{id}")
public ResponseEntity<Person> updateEmployee(@PathVariable(value = "id") Long id,
     @RequestBody Person person) {
    Optional<Person> person1 = repository.findById(id);
    
    Person person2 = person1.get();
    person2.setId(person.getId());
    person2.setName(person.getName());
    person2.setMail(person.getMail());
    final Person Update = repository.save(person);
    return ResponseEntity.ok(Update);
}
 

    
}