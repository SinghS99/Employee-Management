package in.sandeep.springrestapi.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.sandeep.springrestapi.Model.Employee;
import in.sandeep.springrestapi.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployee(int pageNumber, int pageSize) {
		Pageable pages= PageRequest.of(pageNumber, pageSize,Direction.DESC,"id");
		return employeeRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for id" +id);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	return employeeRepository.save(employee);
	}
	
	
		//These Are Finder Methods
	
	@Override
	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		return employeeRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		Sort sort= Sort.by(Sort.Direction.DESC, "id");
		return employeeRepository.findByNameContaining(name,sort);
	}
	
	//JPQL Methods

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		return employeeRepository.getEmployeesByNameOrLocation(name, location);
	}

	@Override
	public Integer deleteByEmployeeName(String name) {
		 return employeeRepository.deleteEmployeeByName(name);
	}

	
}



















































































