package com.laptrinhjava.Model;

import javax.persistence.*;
import java.io.Serializable;

public class DetailBillDTO implements Serializable {

	private int id;
	private int number;
	private int price;
	private BillDTO billDTO;
	private DetailProductDTO detailProduct;

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

	public BillDTO getBillDTO() {
		return billDTO;
	}

	public void setBillDTO(BillDTO billDTO) {
		this.billDTO = billDTO;
	}

	public DetailProductDTO getDetailProduct() {
		return detailProduct;
	}

	public void setDetailProduct(DetailProductDTO detailProduct) {
		this.detailProduct = detailProduct;
	}
}
