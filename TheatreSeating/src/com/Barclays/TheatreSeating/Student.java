package com.Barclays.TheatreSeating;

public class Student {
	private String name;
	private int noofseatrequest;
	private int section;
	private int row;

	public Student(String name, int seatrequest, int section, int row) {
		super();
		this.name = name;
		this.noofseatrequest = seatrequest;
		this.section = section;
		this.row = row;
	}

	public String getName() {
		return name;
	}

	public int getNoofseatrequest() {
		return noofseatrequest;
	}

	public void setNoofseatrequest(int noofseatrequest) {
		this.noofseatrequest = noofseatrequest;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
