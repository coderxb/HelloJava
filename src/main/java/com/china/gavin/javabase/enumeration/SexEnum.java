package com.china.gavin.javabase.enumeration;

public enum SexEnum implements SexIntf {
	MALE("男"), FEMALE("女");

	private String cName;
	
	private SexEnum(String cName) {
	    this.cName = cName;
	}
	
    @Override
    public void show() {
       System.out.println("SexEnum Show() = " + this.cName);
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

}
