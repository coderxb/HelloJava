package com.china.gavin.javabase.init;

public class C extends A {
    static {
        System.out.println("static C load");
    }
    {
        System.out.println("initial C's object parameter");
    }
    
    public C() {
        System.out.println("C's Constructor");
        count++;
    }

    static public void printStatic() {
        System.out.println("B's static function call");
    }
    
    public void printVirtual() {
        System.out.println("C's function call");
    }
}