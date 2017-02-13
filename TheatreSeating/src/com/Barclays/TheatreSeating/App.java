package com.Barclays.TheatreSeating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		int totalseats = 0;
		// HashMap<Integer, List<Integer>> SeatingData = new HashMap<Integer,
		// List<Integer>>();
		// HashMap<String, Integer> ReserveRequest = new LinkedHashMap<String,
		// Integer>();
		System.out.println("Enter the number of Rows");
		Scanner scanData = new Scanner(System.in);
		int numberOfRows = scanData.nextInt();

		TheaterConfiguration theaterLayout = null;
		List<Student> students = new ArrayList<Student>();
		List<Section> sections = new ArrayList<Section>();
		for (int i = 0; i < numberOfRows; i++) {
			int k = i + 1;
			System.out.println("Enter number of  Sections in " + k + "th row.");
			int numberOfSections = scanData.nextInt();
			System.out.println("Enter size of each section seperated by space.Then hit 'Enter' To add next row");
			for (int j = 0; j < numberOfSections; j++) {
				int numberOfSeats = scanData.nextInt();
				totalseats = totalseats + numberOfSeats;
				int s = i + 1;
				int d = j + 1;
				Section section = new Section(s, d, numberOfSeats);
				sections.add(section);
			}
		}

		theaterLayout = new TheaterConfiguration(numberOfRows, sections, totalseats);
		System.out.println("============Theater Layout==========");
		theaterLayout.printsectionlayout();
		// Ask for name and number of seats

		// -----------------taking reservations------------------------begin
		System.out.println("Enter number of Reservations");
		int numres = scanData.nextInt();
		System.out.println("Enter current Resevration.Hit enter to Enter next Reservation.");
		scanData.nextLine();
		for (int i = 0; i < numres; i++) {
			String res = scanData.nextLine();
			Scanner lineScanner = new Scanner(res);
			String name = "";
			int x = 0;
			while (lineScanner.hasNextLine()) {
				// String line = scanrows.nextLine();
				// Scanner lineScanner = new Scanner(line);
				if (lineScanner.hasNextInt()) {
					x = lineScanner.nextInt();
				} else {
					name = name + " " + lineScanner.next();
				}
				// if no int is found, print "Not Found:" and the token
			}
			Student student = new Student(name, x, 0, 0);
			students.add(student);

			lineScanner.close();
		}
		scanData.close();

		for (Student student : students) {
			theaterLayout.reserve(student);
		}

		System.out.println("===========================================================");
	

	}

}
