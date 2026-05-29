package in.manu.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.manu.ems.entity.Employee;
import in.manu.ems.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		Employee emp = employeeService.getEmployeeByEmail(email);
		if (emp != null && emp.getPassword().equals(password)) {
			session.setAttribute("userId", emp.getId());
			session.setAttribute("role", emp.getRole());
			if (emp.getRole().equals("ADMIN")) {
				session.setAttribute("adminId", emp.getId()); 
				return "redirect:/admin/dashboard";
			} else {
				session.setAttribute("employeeId", emp.getId());
				return "redirect:/employee/dashboard";
			}
		}
		model.addAttribute("error", "Invalid credentials");
		return "login";
	}

	@GetMapping("/register") 
	public String registerPage() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String mobileNumber, @RequestParam String department,
			Model model) {

		if (employeeService.getEmployeeByEmail(email) != null) {
			model.addAttribute("error", "Email already exists!");
			return "register";
		}

		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setMobileNumber(mobileNumber);
		emp.setDepartment(department);
		emp.setRole("EMPLOYEE");
		employeeService.saveEmployee(emp);

		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/login";
	}
}
