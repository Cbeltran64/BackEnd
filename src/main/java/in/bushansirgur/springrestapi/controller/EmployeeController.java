package in.bushansirgur.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.bushansirgur.springrestapi.model.Employee;
import in.bushansirgur.springrestapi.service.EmployeeService;
import in.bushansirgur.springrestapi.service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
	
	//localhost:8080/api/v1//
	
	@Autowired
	private EmployeeService eService;
	
	@GetMapping ("/employees")
	 public List<Employee> getEmployees(){
	     return eService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable Long id) {
		return "Fetching theemployee details for the id " + id;
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return "Save the employee details to the database "+employee;
	}
	
	@PutMapping ("/employees/{id}")
	public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
	     System.out.println("updating the emp loyee data for the id "+id);
	     return employee;
	}

	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam Long id) {
		return "Deleting the employee details for the id "+id;
	}
	
}
