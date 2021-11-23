package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public  class FileHandler extends Thread {
	private volatile HashMap<String,Integer> data = new HashMap<>();
	private String fileName;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	FileHandler(String fileName) {
		this.fileName = fileName;
	}
	public void run () {
		Path path = Paths.get(fileName);
		try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
			String currentLine = null;
			while((currentLine = reader.readLine()) != null){
				Scanner parse = new Scanner(currentLine);
				parse.useDelimiter(" ");
				while (parse.hasNext()) {
					String temp = parse.next();
					//temp.replace("."," ");
					if (data.containsKey(temp)) {
						int counter = data.get(temp);
						data.replace(temp, counter, counter + 1);
					} else {
						data.put(temp, 1);
					}
				}
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public HashMap<String,Integer> getData() {
		return data;
	}
	public void display(){
		for (var itr : data.entrySet()) {
			System.out.println("IN:" + itr.getKey());
			//vocabulary.addNode(vocabulary.getRoot(),itr.getKey());
		}

	}
}
