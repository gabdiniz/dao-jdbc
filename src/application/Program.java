package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = new DaoFactory().createSellerDao();
		Seller seller;
		Department department;
		List<Seller> list;
		
		System.out.println("=== TEST 1: seller findById =====");
		seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDeparment =====");	
		department = new Department(2, null);	
		list = sellerDao.findByDepartment(department);
		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 3: seller findAll =====");	
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 4: seller insert =====");	
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(seller);
		System.out.println("Inserted! new id = " + seller.getId());
		
		System.out.println("\n=== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.print("Enter id for delete teste: ");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Delete completed");
		
		sc.close();
	}
}
