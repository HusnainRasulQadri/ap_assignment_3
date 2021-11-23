package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class UI {
	public static int menu() {
		while (true) {
			try {
				System.out.println("Press 1 Displaying BST build from Vocabulary File.");
				System.out.println("Press 2 Displaying Vectors build from Input files.");
				System.out.println("Press 3 Viewing Match words and its frequency ");
				System.out.println("Press 4 Searching a query->It should display all the files query found in.");
				System.out.println("Press 5 For Exiting");
				Scanner input = new Scanner(System.in);
				return input.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
		}
	}
	public static void inorder(Node root) {
		System.out.println("Displaying data in Inorder Format");
		inorderFunc(root);
		System.out.println("\n=================================");
	}
	static void inorderFunc(Node root) {
		if (root == null) {
			return;
		}

		inorderFunc(root.getLeft());

		System.out.print(root.getData() + " ");

		inorderFunc(root.getRight());
	}
	public static void printFileData(String fileName,HashMap<String,Integer> data){
		System.out.println("FileName: " + fileName);
		System.out.println("Word->Frequency");
		for (var itr : data.entrySet()) {
			System.out.println(itr.getKey() + "->" + itr.getValue());
		}
		System.out.println("=================");
	}
	public static int wordMatchInitializer() {
		System.out.print("You can run multiple queries simultaneously. Enter the number of queries you want to run:");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	public static String getWord(){
		System.out.print("Enter Word:");
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	public static void printWordMatchResult(HashMap<String,Integer> result,String word){
		System.out.println("Word: "+word);
		System.out.println("File Name->Frequency");
		for (var itr : result.entrySet()) {
			System.out.println(itr.getKey() + "->" + itr.getValue());
		}
		System.out.println("=================");

	}
	public static String queryIntialiser() {
		System.out.print("Enter the query:");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	public static void printWords(Vector<Word> words) {
		Iterator value = words.iterator();

		int i=0;
		while (value.hasNext()) {
			//Word temp = value.next();
			System.out.println("Word: " + words.elementAt(i).getWord());
			System.out.println("Frequency: " + words.elementAt(i).getFrequency());
			System.out.println("File Name->Frequency");
			for (var itr :  words.elementAt(i).getFile_frequency().entrySet()) {
				System.out.println(itr.getKey() + "->" + itr.getValue());
			}
			System.out.println("=================");
			i++;
			value.next();
		}
	}
}
