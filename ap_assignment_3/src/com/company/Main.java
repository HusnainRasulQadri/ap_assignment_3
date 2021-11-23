package com.company;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			try {
				Controller program = new Controller(args);
				program.startProgram();
				return;
			}
			catch (Exception e) {
				System.out.println("No arguments given to the program\n");
				System.out.println("Either enter arugemts or press 'q' to quit and retry with arguments\n");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				if (str.equalsIgnoreCase("q")) {
					return;
				}
				else {
					args = str.split(" ");
				}
			}
		}
	}
}
