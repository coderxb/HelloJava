package com.china.gavin.newfeatures.jdk7;

public class NewFeature {

    public String stringSwitch(String name, String gender) {
        String title = "";
        switch (gender) {
            case "男":
                title = name + " 先生";
                break;
            case "女":
                title = name + " 女士";
                break;
            default:
                title = name;
        }
        return title;
    }
    
    public void displayBinaryIntegerLiteral() {
        System.out.println(0b001001);
        System.out.println(0B001110);
    }

    public void displayLiteral() {
        System.out.println(1_500_000);
        double value1 = 5_6.3_4;
        int value2 = 89_3__1;
        System.out.println(value1);
        System.out.println(value2);
    }

    public static void main(String[] args) {
        NewFeature feature = new NewFeature();
        String str = feature.stringSwitch("xiao li", "男");
        System.out.println(str);
        feature.displayBinaryIntegerLiteral();
        feature.displayLiteral();
    }
}
