package allianz.project.challenge.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import allianz.project.challenge.employee.dao.EmployeeDao;
import allianz.project.challenge.employee.exception.EmployeeNotFoundException;
import allianz.project.challenge.employee.model.Employee;


/**
 * Service Implementation class for methods of operation
 * 
 * @author harshada
 *
 */
@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
		
		
	
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
		
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + employeeId));
		return employee;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
		
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employeeDetails)
			throws EmployeeNotFoundException {
		
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setDept(employeeDetails.getDept());
		employee.setSalary(employeeDetails.getSalary());
		final Employee updatedEmployee = employeeDao.save(employee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long employeeId) throws EmployeeNotFoundException {
		
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " + employeeId));

		employeeDao.delete(employee);		
		
	}
	
	

}
