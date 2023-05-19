package com.spring.util;

import com.example.demo.entity.Category;
import com.example.demo.entity.Ordemanage;
import com.example.demo.entity.Product;
import com.example.demo.entity.Seller;
import com.example.demo.entity.User;

public class Validator {

	public static boolean isAlphaNumerical(String input) {

		if (input != null && input != "") {
			if (input.matches("[a-zA-Z0-9]*")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumerical(String input) {
		if (input != null && input != "") {
			if (input.matches("[0-9]*")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidEmail(String input) {
		if (input != null && input != "") {
			if (input.matches("^[a-zA-Z0-9._]*@[a-zA-Z0-9.-]*$")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isImageFile(String input) {
		if (input != null && input != "") {
			input = input.toLowerCase();
			if (input.endsWith(".png") || input.endsWith(".jpg") || input.endsWith(".jpeg") || input.endsWith(".gif")) {
				return true;
			}
		}
		return false;
	}

	public static String removeSpaces(String input) {
		String filterInput = "";
		if (input != null && input != "") {
			filterInput = input.replace(" ", "");
		}
		return filterInput;
	}

	public static boolean isUserEmpty(User user) {
		if (user.getEluser_id() == 0) {
			return true;
		}
		if (user.getUserpassword() == null || user.getUserpassword() == "") {
			return true;
		}
		if (user.getUser_name() == null || user.getUser_name() == "") {
			return true;
		}
		if (user.getFirst_name() == null || user.getFirst_name() == "") {
			return true;
		}
		if (user.getLast_name() == null || user.getLast_name() == "") {
			return true;
		}
		if (user.getUser_address1() == null || user.getUser_address1() == "") {
			return true;
		}
		if (user.getUser_address2() == null || user.getUser_address2() == "") {
			return true;
		}
		return false;
	}

	public static boolean isAddressEmpty(Seller address) {
		if (address.getSeller_name() == null || address.getSeller_name() == "") {
			return true;
		}
		if (address.getSeller_id() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isProductEmpty(Product prod) {

		if (prod.getProductname()== null || prod.getProductname() == "") {
			return true;
		}
		if (prod.getElproduct_description() == null || prod.getElproduct_description() == "") {
			return true;
		}
		if (prod.getAvailable_stock() == 0) {
			return true;
		}
		if (prod.getElmart_category_id() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isPlaceOrderEmpty(Ordemanage plaOrd) {

		if (plaOrd.getProductid() == 0 ) {
			return true;
		}
		if (plaOrd.getOrders() == 0) {
			return true;
		}
		if (plaOrd.getUserid() == 0) {
			return true;
		}
		
		return false;
	}

	public static boolean isCartEmpty(Category cart) {

		if (cart.getCategory_name() == null || cart.getCategory_name() == "") {
			return true;
		}
		
		if (cart.getCategory_id() == 0) {
			return true;
		}
		
		return false;
	}

	public static boolean isStringEmpty(String input) {
		if (input == null || input.equals("")) {
			return true;
		}
		return false;
	}
}
