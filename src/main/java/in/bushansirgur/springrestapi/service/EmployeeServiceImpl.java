package in.bushansirgur.springrestapi.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import in.bushansirgur.springrestapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee();
		e.setName("Cristian");
		e.setAge(22);
		e.setDepartment("IT");
		e.setEmail("cmbeltran64@ucatolica.edu.co");
		e.setLocation("Bogota");
		list.add(e);
		
		e = new Employee();
		e.setName("Mauricio");
		e.setAge(21l);
		e.setDepartment("Textile");
		e.setEmail("cmbeltran64@ucatolica.edu.co");
		e.setLocation("India");
		list.add(e);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return list;
	}

}
