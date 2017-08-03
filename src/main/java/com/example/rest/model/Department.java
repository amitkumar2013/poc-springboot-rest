package com.example.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department {
	private int id;
	private String name;
	private int capacity;

	public Department() {
		super();
	}

	public Department(int id, String name, int capacity) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}

}
