package allianz.project.challenge.employee.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allianz.project.challenge.employee.exception.EmployeeNotFoundException;
import allianz.project.challenge.employee.model.Employee;
import allianz.project.challenge.employee.service.EmployeeService;


/**
 * Rest Controller for Employee
 * 
 * @author harshada
 *
 */
@RestController
@CrossOrigin()
@RequestMapping("/allianz/api")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		
		List<Employee> getAllEmployees = employeeService.getAllEmployees();
		LOGGER.info("Employee Details of all employees {}", getAllEmployees);
		return getAllEmployees;
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
		Employee employee = employeeService.getEmployeeById(employeeId);
		LOGGER.info("Employee Details for employeeId {}", employeeId);
		LOGGER.info("Employee Details for employee {}", employee);
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeDetails = employeeService.createEmployee(employee);
		LOGGER.info("Employee created {}", employeeDetails);
		return employeeDetails;
		
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
		Employee updatedEmployee = employeeService.updateEmployee(employeeId, employeeDetails) ;
		LOGGER.info("Update Employee Details for employeeId {}", employeeId);
		LOGGER.info("Update Employee Details copleted {}", updatedEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws EmployeeNotFoundException {
	employeeService.deleteEmployee(employeeId);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	LOGGER.info("Delete Employee Details for employeeId {}", employeeId);
	return response;
	}
}