package com.wu.ecommerce.utils;

import java.util.Comparator;

import com.wu.ecommerce.dto.Product;

public class IdComparator implements Comparator<Product> {

	@Override
	public int compare(Product arg0, Product arg1) {
		// TODO Auto-generated method stub
		return arg0.getProductId().compareTo(arg1.getProductId());
	}

}
