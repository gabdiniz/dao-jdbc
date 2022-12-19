package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();
		Department department = null;
		List<Department> list;
		
		System.out.println("=== TEST 1: department findById =====");
		department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll =====");
		list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: department insert =====");
		department = new Department(null, "Jogos");
		departmentDao.insert(department);
		System.out.println("Inserted! new id = " + department.getId());
		
		System.out.println("\n=== TEST 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("PC's");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete =====");
		System.out.print("Enter id for delete teste: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Delete completed");
		
		sc.close();
	}
}
