package in.kce.main;

import java.util.Scanner;

import in.kce.bean.Employee;
import in.kce.service.EmployeeService;

public class TestEmployee {
public static void main(String[] args) {
	System.out.println("Employee Management");
	System.out.println("1. Store Employee");
	System.out.println("2. Update Employee");
	System.out.println("3. Fetch one Employee");
	System.out.println("4. Fetch All Employee");
	System.out.println("5. Delete Employee");
	Scanner sc=new Scanner(System.in);
	int option=sc.nextInt();
	EmployeeService employeeService=new EmployeeService();
	switch(option) {
	case 1:{
		System.out.println("Enter Employee Id");
		int empId=sc.nextInt();
		System.out.println("Enter Employee Name");
		String empName=sc.next();
		System.out.println("Enter Designation");
		String desig=sc.next();
		boolean result=employeeService.saveEmployee(empId,empName,desig);
		if(result) {
			System.out.println("Employee Stored Successfully");
		}
		else {
			System.out.println("Employee Not Stored");
		}
		break;
	}
	case 2:{
		System.out.println("Enter Employee Id");
		int empId=sc.nextInt();

		System.out.println("Enter Employee Name");
		String empName=sc.next();

		System.out.println("Enter Designation");
		String desig=sc.next();
		boolean result=employeeService.updateEmployee(empId,empName,desig);
		if(result) {
			System.out.println("Employee Updated Successfully");
		}
		else {
			System.out.println("Employee Not Updated");
		}
		break;
	}
	case 3:{
		System.out.println("Enter Employee Id");
		int empId=sc.nextInt();
		Employee emp=employeeService.getEmployee(empId);
		if(emp!=null) {
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getDesignation());
		}
		else {
			System.out.println("Employee Not Found");
		}
		break;
	}
	case 4:{
		for(Employee emp:employeeService.getAllEmployees()) {
			System.out.println(emp.getEmpId());
			System.out.println(emp.getEmpName());
			System.out.println(emp.getDesignation());
			System.out.println("----------------");
		}
		break;
	}
	case 5:{
		System.out.println("Enter Employee Id");
		int empId=sc.nextInt();

		boolean result=employeeService.deleteEmployee(empId);

		if(result) {
			System.out.println("Employee Deleted Successfully");
		}
		else {
			System.out.println("Employee Not Deleted");
		}
		break;
	}
	default:
		System.out.println("Invalid Option");
	}
}
}
