package com.Symbiosis.ProjectJPAwithHibernate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id
	private int id;
	
	private String name;
	private String film;
	
	public Actor()
	{
		super();
	}
	public Actor(int id, String name, String film) {
		super();
		this.id = id;
		this.name = name;
		this.film = film;
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
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	
}
