package com.china.gavin.utils;

public class DiGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(method(5));
	}
	
	public static int method(int n){
		if( n==1 ){
			return 1;
		}else{
			return n*method(n-1);
		}
	}

}
