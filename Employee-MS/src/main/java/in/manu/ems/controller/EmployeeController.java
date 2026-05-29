package in.manu.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.manu.ems.entity.Employee;
import in.manu.ems.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("employeeId");
		Employee emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "employee-dashboard";
	}

	@GetMapping("/edit-profile")
	public String editProfilePage(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("employeeId");
		Employee emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "employee-edit-profile"; 
	}

	@PostMapping("/edit-profile")
	public String editProfile(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String mobileNumber) {
		Employee emp = employeeService.getEmployeeById(id); 
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setMobileNumber(mobileNumber);
		employeeService.saveEmployee(emp);
		return "redirect:/employee/dashboard";
	}
}
