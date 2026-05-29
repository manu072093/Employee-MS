package in.manu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.manu.ems.entity.Employee;
import in.manu.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void saveEmployee(Employee employee) {
		repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) { 
		return repo.findById(id).orElse(null);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}
}
