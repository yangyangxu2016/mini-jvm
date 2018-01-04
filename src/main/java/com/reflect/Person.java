package com.reflect;

class Person {
    private String pName;
    private String pAge;
    public String isPerson;

    public Person() {
    }

    public Person(String pName, String pAge) {
        this.pName = pName;
        this.pAge = pAge;
    }

    private Person(String pName) {
        this.pName = pName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pName='" + pName + '\'' +
                ", pAge='" + pAge + '\'' +
                ", isPerson='" + isPerson + '\'' +
                '}';
    }
}
