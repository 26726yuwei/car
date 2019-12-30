package com.oracle.cars.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class RenameToJsp {

	public static void main(String[] args) {
		updateSQL();
	/*	File  dir=new File("C:\\JavaEE_Projects\\Cars2\\WebContent");
		
		File[] files=dir.listFiles();
		for(File f:files) {
			if(f.isFile()) {
			String lastname=f.getName().substring(0,f.getName().lastIndexOf("."));
			f.renameTo(new File(dir,lastname+".jsp"));
			}
		}*/
	}

	public static void  updateSQL() {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("D:/datagen1.txt"));
			BufferedReader reader=new BufferedReader(new FileReader("D:/datagen.txt"));
			String message=null;
			int n=1;
			while((message=reader.readLine())!=null) {
				System.out.println(message);
				message=message.replace("1.jpg", n+".jpg");
				System.out.println(message);
				writer.write(message);
				writer.newLine();
				n++;
				if(n>282)n=1;
			}
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
