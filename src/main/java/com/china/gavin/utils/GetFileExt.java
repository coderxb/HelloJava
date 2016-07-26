package com.china.gavin.utils;

public class GetFileExt {
	    
	    public static int getFileType(String fileName){
	    	 //File file = new File(fileUri);
	    	 //String fineName = file.getName();
	    	 String[] str = {"doc","txt","ini","ic"}; 
	    	 String fileType = fileName.substring(fileName.lastIndexOf('.')+1,fileName.length());
	    	 int t=-1;
	    	 for(int i=0;i<str.length;i++){
	    		 if(fileType.equals(str[i])){
	    			 t=i;
	    		 }	    			 
	    	 }
	    	 return t;
	    	} 
	    public static void main(String[] args){
	    	String fileName = "lixuebing.ff";
	    	int tt= GetFileExt.getFileType(fileName);
	    	System.out.println(tt);
	    }
}