package com.example.demo.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "value")
public class Person {
  
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    //private String age;

    public Person(){
        super();
    }

    public Person(Long id,String name,String mail){
        super();
        this.id = id;
        this.name = name;
        this.mail = mail;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;  
    }

    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;  
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;  
    }
}