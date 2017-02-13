package com.Barclays.TheatreSeating;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Section {
	private int row;
	private int section;
	// int numberOfSeats;
	private int availableSeats;
	private HashMap<String, Integer> seatAssignment = new LinkedHashMap<String, Integer>();

	public Section(int row, int section, int availableSeats) {
		this.row = row;
		this.section = section;
		// this.numberOfSeats = numberOfSeats;
		this.availableSeats = availableSeats;
	}

	public int getRow() {
		return row;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int reserve(Student student, TheaterConfiguration theaterconfigurtion) {
		int section = 0;
		// System.out.println("+++++" + section + "++++");
		if (availableSeats >= student.getNoofseatrequest()) {
			// System.out.println("-----------" + section + "-----------");
			availableSeats = availableSeats - student.getNoofseatrequest();
			theaterconfigurtion.setTotalseats(theaterconfigurtion.getTotalseats() - student.getNoofseatrequest());
			// seatAssignment.put(name, seats);
			student.setSection(this.getSection());
			student.setRow(this.getRow());

			section = student.getSection();
			// System.out.println("-----------" + section + "-----------");
		}
		return section;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public void print() {
		if (!seatAssignment.isEmpty()) {
			Iterator<String> names = seatAssignment.keySet().iterator();
			String name;
			while (names.hasNext()) {
				name = names.next();
				System.out.println(name + "has " + seatAssignment.get(name) + " seat(s) assigned in Row " + row
						+ " Section " + section);
			}
		}
	}

}
