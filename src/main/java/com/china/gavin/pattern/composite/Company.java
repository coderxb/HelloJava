package com.china.gavin.pattern.composite;

public abstract class Company {

    private String name;
    private Integer level;
    
    public Company(String name, Integer level) {
        super();
        this.name = name;
        this.level = level;
    }
    
    public abstract void addCompany(Company company);
    
    public abstract void removeCompany(Company company);

    public void display() {
        for (int i = 1; i <= level; i++) {
            System.out.print("---");
        }
        System.out.println(name);
    }
}