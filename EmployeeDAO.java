package in.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.kce.bean.Employee;
import in.kce.util.DBUtil;

public class EmployeeDAO {

	public boolean saveEmployee(Employee employee) {
		Connection connection=DBUtil.getConnection();
		String query="insert into employee2 values(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,employee.getEmpId());
			preparedStatement.setString(2,employee.getEmpName());
			preparedStatement.setString(3,employee.getDesignation());
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployee(Employee employee) {
		Connection connection=DBUtil.getConnection();
		String query="update employee2 set emp_name=?,designation=? where emp_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,employee.getEmpName());
			preparedStatement.setString(2,employee.getDesignation());
			preparedStatement.setInt(3,employee.getEmpId());
			int row=preparedStatement.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteEmployee(String empId) {
		Connection connection=DBUtil.getConnection();
		String query="delete from employee2 where emp_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,empId);
			int row=preparedStatement.executeUpdate();
			if(row>0) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee getEmployee(String empId) {
		Connection connection=DBUtil.getConnection();
		String query="select * from employee2 where emp_id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,empId);
			ResultSet rs=preparedStatement.executeQuery();

			if(rs.next()) {
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setDesignation(rs.getString(3));
				return employee;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Employee> getAllEmployees() {
		Connection connection=DBUtil.getConnection();
		String query="select * from employee2";
		ArrayList<Employee> list=new ArrayList<Employee>();

		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet rs=preparedStatement.executeQuery();

			while(rs.next()) {
				Employee employee=new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpName(rs.getString(2));
				employee.setDesignation(rs.getString(3));
				list.add(employee);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
