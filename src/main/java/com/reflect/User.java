package com.reflect;

class User extends Person {

    private String name;
    private String age;
    public String isStudent;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private User(String name, String age, String isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(String isStudent) {
        this.isStudent = isStudent;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", isStudent='" + isStudent + '\'' +
                '}';
    }
}
