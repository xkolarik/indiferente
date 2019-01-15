package br.com.teste.kolarik.model;

import org.bson.types.ObjectId;

public class Bot {
	
	private ObjectId id;
	
	private String name;
	
	public Bot() {
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
