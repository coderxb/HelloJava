package com.china.gavin.pattern.composite;

public class TestCompany {

    public static void main(String[] args) {

        ConcreteCompany company = new ConcreteCompany("总公司", 1);
        ConcreteCompany shenzhen = new ConcreteCompany("深圳分公司", 2);
        ConcreteCompany wuhan = new ConcreteCompany("武汉分公司", 2);
        ConcreteCompany beijing = new ConcreteCompany("北京分公司", 2);
        ConcreteCompany wuchang = new ConcreteCompany("武昌分公司", 3);
        ConcreteCompany baoan = new ConcreteCompany("宝安分公司", 3);
        ConcreteCompany luohu = new ConcreteCompany("罗湖分公司", 3);
        ConcreteCompany nanshan = new ConcreteCompany("南山分公司", 3);

        company.addCompany(shenzhen);
        company.addCompany(wuhan);
        company.addCompany(beijing);

        wuhan.addCompany(wuchang);

        shenzhen.addCompany(baoan);
        shenzhen.addCompany(luohu);
        shenzhen.addCompany(nanshan);

        company.display();
    }
}
