package allianz.project.challenge.employee;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import allianz.project.challenge.employee.dao.EmployeeDao;
import allianz.project.challenge.employee.model.Employee;
import allianz.project.challenge.employee.service.EmployeeService;
import allianz.project.challenge.employee.service.EmployeeServiceImpl;

/**
 * Junit test cases with mockito 
 * 
 * @author harshada
 *
 */
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	public EmployeeServiceTest() {
		
	}
	
	@Test
	public void testGetAllEmployeeData() {
		EmployeeService empServiceMock = mock(EmployeeService.class);
		EmployeeDao empDaoMock = mock(EmployeeDao.class);
		Employee employee = new Employee();
		ArrayList<Employee> employeeList = new ArrayList<>();
		employee.setEmailId("testmail@Gmail.com");
		employee.setLastName("testLastName");
		employee.setFirstName("testFirstName");
		employee.setDept("testDept");
		employee.setSalary(20000.0);
		employeeList.add(employee);
		when(empServiceMock.getAllEmployees()).thenReturn(employeeList);
		when(empDaoMock.findAll()).thenReturn(employeeList);
		EmployeeServiceImpl empDetails = new EmployeeServiceImpl(empDaoMock);		
		assertEquals("testDept", empDetails.getAllEmployees().get(0).getDept());
	}
	

	@Test
	public void testGetEmployeeDetails() {
		EmployeeService empServiceMock = mock(EmployeeService.class);
		EmployeeDao empDaoMock = mock(EmployeeDao.class);
		Employee employee = new Employee();
		ArrayList<Employee> employeeList = new ArrayList<>();
		employee.setEmailId("test2mail@Gmail.com");
		employee.setLastName("test2LastName");
		employee.setFirstName("test2FirstName");
		employee.setDept("test2Dept");
		employee.setSalary(30000.0);
		employeeList.add(employee);
		when(empServiceMock.getAllEmployees()).thenReturn(employeeList);
		when(empDaoMock.findAll()).thenReturn(employeeList);
		EmployeeServiceImpl empDetails = new EmployeeServiceImpl(empDaoMock);		
		assertEquals("test2mail@Gmail.com", empDetails.getAllEmployees().get(0).getEmailId());
	}
	

}
