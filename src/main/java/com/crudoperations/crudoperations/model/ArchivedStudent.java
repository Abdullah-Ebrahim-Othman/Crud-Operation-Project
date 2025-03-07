package com.crudoperations.crudoperations.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students_archive")

public class ArchivedStudent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String name;
    private String level;
    private double gpa;
    private int age;
    private String gender;
    private String address;
    private String phone;

    public ArchivedStudent() {};

   public ArchivedStudent(Student student) {
       this.id = String.valueOf(student.getId());
       this.name = student.getName();
       this.level = student.getLevel();
       this.gpa = student.getGpa();
       this.age = student.getAge();
       this.gender = student.getGender();
       this.address = student.getAddress();
       this.phone = student.getPhone();
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MongoStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", gpa=" + gpa +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
