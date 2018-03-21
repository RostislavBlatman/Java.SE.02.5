package main.java;

public class Student {
    private String name;
    private String lastName;

    public Student(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){this.name = name;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " | Last name: " + getLastName();
    }
}
