package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.User;
import com.wu.ecommerce.exception.DataNotFoundException;
import com.wu.ecommerce.exception.IdNotFoundException;
import com.wu.ecommerce.exception.InvalidIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.exception.UserIdInvalidException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

public class Main {
	public static void main(String[] arg) {
//		try {
//			interfacesCheck();
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		ProductService productService = ProductServiceImpl.getInstance();
		UserService userService = UserServiceImpl.getInstanve();

		try {

			Scanner scanner = new Scanner(System.in);
			int choice = 0;
			while (true) {
				System.out.println("1: Insert product\n" + "2: Search product by product id \n"
						+ "3: Display all products\n" + "4: Search product by category\n" + "5: Update product by id\n"
						+ "6: remove product by id\n" + "7: Create User\n" + "8: Display all users\n"
						+ "9: Search user by id\n" + "10: remove user by id\n" + "11: Update by id\n");
				System.out.println("enter the choice");
				choice = scanner.nextInt();
//				productService.addProduct(new Product("pid1", "pen3", 18, "cat"));
//				productService.addProduct(new Product("pid2", "pen1", 10, "cat"));
//				productService.addProduct(new Product("pid3", "pen2", 14, "cat"));
//				productService.addProduct(new Product("pid4", "pen4", 13, "cat"));
//				productService.addProduct(new Product("pid5", "pen5", 17, "cat"));

//				userService.addUser(new User("user1", "Siddhant", "Nawale", "nawalewadi",41324));
				userService.addUser(new User("user2", "Siddhu","pass"));

				switch (choice) {
				case 1:
					// add new product
					System.out.println("ProductId: ");
					String productId = scanner.next();
					System.out.println("name: ");
					String name = scanner.next();
					System.out.println("price: ");
					int price = scanner.nextInt();
					System.out.println("category ");
					String category = scanner.next();
					productService.addProduct(new Product(productId, name, price, category));
					break;
				case 2:
					System.out.println("ProductId: ");
					String productIdToSearch = scanner.next();
					System.out.println(productService.getProductByProductId(productIdToSearch));
					break;
				case 3:
					System.out.println(productService.getProducts());
					break;
				case 4:
					System.out.println("Category: ");
					String categoryToSearch = scanner.next();
					System.out.println(productService.getAllProductByCatgory(categoryToSearch));
					break;
				case 5:
					// updateproduct
					System.out.println("ProductId: ");
					String productIdToUpdate = scanner.next();
					System.out.println("name: ");
					String nameToUpdate = scanner.next();
					System.out.println("price: ");
					int priceToUpdate = scanner.nextInt();
					System.out.println("category ");
					String categoryToUpdate = scanner.next();
					productService.updateProductByProjectId(productIdToUpdate,
							new Product(productIdToUpdate, nameToUpdate, priceToUpdate, categoryToUpdate));
					break;
				case 6:
					System.out.println("ProductId: ");
					String productIdToDelete = scanner.next();
					System.out.println(productService.removeProductByProductId(productIdToDelete));
					break;
				case 7:
					System.out.println("UserId: ");
					String userId = scanner.next();
					System.out.println("email: ");
					String email = scanner.next();
					System.out.println("password: ");
					String password = scanner.next();
//					System.out.println("Contact number: ");
//					int contactNumber = scanner.nextInt();
//					System.out.println("Address ");
					String address = scanner.next();
					userService.addUser(new User(userId, email, password));
					break;
				case 8:
					System.out.println(userService.getUsers());
					break;
				case 9:
					System.out.println("User Id: ");
					String userIdToSearch = scanner.next();
					System.out.println(userService.getUserById(userIdToSearch));
					break;
				case 10:
					System.out.println("User Id: ");
					String userIdToDelete = scanner.next();
					System.out.println(userService.removeUserById(userIdToDelete));
					break;
				case 11:
					System.out.println("UserId: ");
					String userIdToChange = scanner.next();
					System.out.println("email: ");
					String firstNameToChange = scanner.next();
					System.out.println("password: ");
					String lastNameToChange = scanner.next();
//					System.out.println("Contact number: ");
//					int contactNumberToChange = scanner.nextInt();
//					System.out.println("Address ");
//					String addressToChange = scanner.next();
					userService.updateUserById(userIdToChange,new User(userIdToChange, firstNameToChange, lastNameToChange));
					break;
				default:
					scanner.close();
					break;
				}
			}

//			Product product  = new Product("asdh3","Pens",100,"stationary");
//			productService.addProduct(product);
//			productService.addProduct(new Product("asdh3","Pens12",1200,"stationary1"));
//			
//			System.out.println( productService.getProductByProductId("asdh3"));
//			System.out.println( productService.getProducts());
//			
//
//			System.out.println( productService.getAllProductByCatgory("stationary"));
//			
//			System.out.println(productService.removeProductByProductId("asdh3"));
//			System.out.println(productService.getProducts());
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserIdInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		UserService userService = UserServiceImpl.getInstanve();
//		User user;
//		try {
//			user = new User("user1", "Siddhant", "Nawale", "nawalewadi",31241324);
//			userService.addUser(user);
//			user = new User("user2", "Ajit", "Nawale", "akol",3124134);
//			userService.addUser(user);
//			
//			System.out.println(userService.getUserById("user1"));
//			System.out.println();
//			System.out.println(userService.getUsers());
//			
////			userService.removeUserById("user1");
//			userService.updateUserById("user1", user);
//			System.out.println(userService.getUsers());
//			
//			
//		} catch (UserIdInvalidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static int exceptionTesting() {
		int a = 0;
		int b[] = new int[10];
		try {
			a = 10 / 5;
			b[11] = 12;
			System.out.println("Inside the try block");
			return a;
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return a;
		} catch (ArithmeticException e) {
			a = 10 / 2;
			System.out.println("Inside the catch block");
			return a;
		} catch (RuntimeException e) {
			System.out.println("Runtime: " + e.getMessage());
			return a;
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return a;
		} catch (Throwable e) {
			System.out.println("Throwable: " + e.getMessage());
			return a;
		}
//		catch(Object e) {
//			No exception of type Object can be thrown; an exception type must be a subclass of Throwable	
//		}
		finally {
			System.out.println(a);
			System.out.println("hello");
		}

	}

	private static void interfacesCheck()
			throws InvalidIdException, IdNotFoundException, DataNotFoundException, SQLException, InvalidPriceException {
		ProductService productService = ProductServiceImpl.getInstance();

		Product[] products = new Product[15];

		System.out.println("Adding and Printing added products: ");
		for (int i = 0; i < 11; i++) {
			try {
				products[i] = productService.addProduct(new Product("product" + i, "Pen" + i, 2 * i, "stationary"));
			} catch (InvalidIdException | InvalidPriceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
		}

		System.out.println("Get products with id: ");
		System.out.println(productService.getProductByProductId("product4"));
//		productService.printProducts(null);

		System.out.println("Get products with cat: ");
		System.out.println(productService.getAllProductByCatgory("stationary"));

		System.out.println("Get All Product by category: ");
//		productService.printProducts(productService.getAllProductByCatgory("stationary"));

		System.out.println("Remove Product with id: ");
		System.out.println(productService.removeProductByProductId("product4"));
//		productService.printProducts(null);

		System.out.println("Update Product with id: ");
		try {
			System.out.println(productService.updateProductByProjectId("product5",
					new Product("product5", "Pencil", 901, "stationary")));
		} catch (InvalidIdException | InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		productService.printProducts(null);
	}
}
