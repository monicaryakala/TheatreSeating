package com.Barclays.TheatreSeating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TheaterConfiguration {
	// int totalseats=0;
	private int numberOfRows = 0;
	private int totalseats = 0;
	HashMap<Integer, List<Section>> layout = new HashMap<>();
	HashMap<Integer, List<Integer>> TheaterLayout = new HashMap<>();

	public TheaterConfiguration(int numberOfRows, List<Section> sections, int totalseats) {
		this.totalseats = totalseats;
		this.numberOfRows = numberOfRows;
		for (Section section : sections) {
			fillRow(section);
		}
	}

	private void fillRow(Section section) {
		if (section != null) {
			int row = section.getRow();
			List<Section> sectionList = layout.get(row);
			if (sectionList == null) {
				sectionList = new ArrayList<Section>();
				TheaterLayout.put(row, null);
			}
			sectionList.add(section);
			layout.put(row, sectionList);
		}
	}

	public void reserve(Student student)// String name, int numberOfSeats)
	{
		if (student.getNoofseatrequest() < totalseats) {
			boolean result = false;
			// System.out.println("tconfig--" + result + "--tconfig");
			for (int i = 1; i <= numberOfRows; i++) {
				// System.out.println("tinner--" + result + "--tconfig");
				for (Section section : layout.get(i)) {
					// System.out.println("tinner--" + result + "--tconfig");
					if (section.reserve(student, this) != 0) {
						System.out.println(
								student.getName() + " Row " + student.getRow() + " Section " + student.getSection());
						break;
					}
				}
				if (student.getSection() != 0) {
					break;
				}
			}
			if (student.getSection() == 0) {
				System.out.println(student.getName() + " you will have to call for split");
			}
		} else {
			System.out.println(student.getName() + " sorry! we cannot handle a request of your size");
		}
	}

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public void print() {
		for (Entry<Integer, List<Section>> entry : layout.entrySet()) {
			System.out.println("key : " + entry.getKey() + "Value : " + entry.getValue());
		}
	}

	public void printsectionlayout() {
		for (Entry<Integer, List<Section>> entry : layout.entrySet()) {
			for (Entry<Integer, List<Integer>> theaterlayout : TheaterLayout.entrySet()) {
				if (entry.getKey() == theaterlayout.getKey()) {
					List<Integer> sectionlist = new ArrayList<Integer>();
					for (Section section : entry.getValue()) {
						sectionlist.add(section.getAvailableSeats());
					}
					TheaterLayout.put(theaterlayout.getKey(), sectionlist);
				}
			}
		}
		for (Entry<Integer, List<Integer>> theaterlayout : TheaterLayout.entrySet()) {
			System.out.println(theaterlayout.getValue());
		}
	}

}
