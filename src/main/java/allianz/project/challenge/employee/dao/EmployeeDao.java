package allianz.project.challenge.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allianz.project.challenge.employee.model.Employee;

/**
 * @author harshada
 *
 */

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
