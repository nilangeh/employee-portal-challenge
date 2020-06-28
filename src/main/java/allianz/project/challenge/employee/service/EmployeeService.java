package allianz.project.challenge.employee.service;

import java.util.List;
import org.springframework.stereotype.Service;


import allianz.project.challenge.employee.exception.EmployeeNotFoundException;
import allianz.project.challenge.employee.model.Employee;


/**
 * Service Interface for methods of operation
 * 
 * @author harshada
 *
 */
@Service
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long employeeId)throws EmployeeNotFoundException;

	Employee createEmployee(Employee employee);
	
	Employee updateEmployee(Long employeeId,Employee employeeDetails) throws EmployeeNotFoundException;

	void deleteEmployee(Long employeeId)throws EmployeeNotFoundException; 
}
