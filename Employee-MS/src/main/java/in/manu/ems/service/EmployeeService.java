package in.manu.ems.service;

import java.util.List;

import in.manu.ems.entity.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	Employee getEmployeeByEmail(String email);
	List<Employee> getAllEmployees();
	void deleteEmployee(Long id); 
}
