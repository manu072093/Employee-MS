package in.manu.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.manu.ems.entity.Employee;
import in.manu.ems.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long adminId = (Long) session.getAttribute("adminId");
		Employee admin = employeeService.getEmployeeById(adminId);
		model.addAttribute("admin", admin);
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "admin-dashboard";
	}

	@GetMapping("/add-employee")
	public String addEmployeePage() {
		return "admin-add-employee";
	}

	@PostMapping("/add-employee")
	public String addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String mobileNumber, @RequestParam String department) {

		Employee emp = new Employee();
		emp.setFirstName(firstName); 
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setMobileNumber(mobileNumber);
		emp.setDepartment(department);
		emp.setRole("EMPLOYEE");
		employeeService.saveEmployee(emp);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/edit-profile")
	public String editProfilePage(HttpSession session, Model model) {
		Long adminId = (Long) session.getAttribute("adminId");
		Employee admin = employeeService.getEmployeeById(adminId);
		model.addAttribute("admin", admin);
		return "admin-edit-profile";
	}

	@PostMapping("/edit-profile")
	public String editProfile(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String mobileNumber) {
		Employee admin = employeeService.getEmployeeById(id);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setMobileNumber(mobileNumber);
		employeeService.saveEmployee(admin);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/admin/dashboard";
	}
}
