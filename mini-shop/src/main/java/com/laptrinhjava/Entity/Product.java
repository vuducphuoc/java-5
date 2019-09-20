package com.laptrinhjava.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "DESCRIBE")
	private String describe;

	@Column(name = "IMAGE")
	private String image;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORY")
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Detail_Product> detailProductList;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Detail_Product> getDetailProductList() {
		return detailProductList;
	}

	public void setDetailProductList(List<Detail_Product> detailProductList) {
		this.detailProductList = detailProductList;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
