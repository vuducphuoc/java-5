package com.laptrinhjava.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
		@Table(name = "DETAIL_BILL")
public class Detail_Bill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMBER")
	private int number;

	@Column(name = "PRICE")
	private int price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BILL")
	private Bill bill;

	@OneToOne
	@JoinColumn(name = "ID_DETAIL_PRODUCT")
	private Detail_Product detail_product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Detail_Product getDetail_product() {
		return detail_product;
	}

	public void setDetail_product(Detail_Product detail_product) {
		this.detail_product = detail_product;
	}
}
