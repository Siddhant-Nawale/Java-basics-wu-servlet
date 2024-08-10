package com.wu.ecommerce.dto;

import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Product
//implements Comparable<Product> 
{
	public Product(String productId, String productName, int price, String categoryName)
			throws InvalidIdException, InvalidPriceException {
		super();
		this.setProductId(productId);
		this.productName = productName;
		this.setPrice(price);
		this.categoryName = categoryName;
	}

	private String productId;
	@Setter
	private String productName;
	@Exclude
	private int price;
	@Setter
	private String categoryName;

	public void setProductId(String productId) throws InvalidIdException {
		if (productId == null || productId.equals("") || productId.length() < 3) {
			// raise the exception
			throw new InvalidIdException("Given id is invalid");
		}

		this.productId = productId;
	}

	public void setPrice(int price) throws InvalidPriceException {
		if (price < 1) {
			throw new InvalidPriceException("Given price whould be greater then 0");
		}
		this.price = price;
	}
//	@Override
//	public int compareTo(Product arg0) {
//		// TODO Auto-generated method stub
//		return this.productId.compareTo(arg0.productId);
//	}

}
