package com.china.gavin.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {

    private List<Company> companys = new ArrayList<Company>();

    public ConcreteCompany(String name, Integer level) {
        super(name, level);
    }

    @Override
    public void addCompany(Company company) {
        companys.add(company);
    }

    @Override
    public void removeCompany(Company company) {
        companys.remove(company);
    }

    @Override
    public void display() {
        super.display();
        for (Company cp : companys) {
            cp.display();
        }
    }

}
