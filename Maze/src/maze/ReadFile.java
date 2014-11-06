package Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile{
	List<String> list = new ArrayList<String>();
	static public String[] array;
	
	public ReadFile(File file){
		Scanner scan;
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine())
			list.add(scan.nextLine());
			this.array = list.toArray(new String[0]);
			
			
			/*
			for(int i = 0; i < this.array.length; i++){
				System.out.println(this.array[i]);
			}*/
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}