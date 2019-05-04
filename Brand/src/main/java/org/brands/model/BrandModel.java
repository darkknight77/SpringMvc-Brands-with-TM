package org.brands.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name = "Brand")
@Table(name = "Brand")
public class BrandModel {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brandid")
	int id;
	@Column(name = "brandname")
	String name;
	@Column(name = "brandcategory")
	String category;

	public BrandModel() {
		
	}
	
	public BrandModel( String name, String category) {
		super();
		
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BrandModel [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

}
