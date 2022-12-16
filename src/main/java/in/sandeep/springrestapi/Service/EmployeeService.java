package in.sandeep.springrestapi.Service;

import java.util.List;

import org.springframework.data.domain.Sort;

import in.sandeep.springrestapi.Model.Employee;

public interface EmployeeService {

	//Paging&sorting
	  List<Employee> getEmployee(int pageNumber,int pageSize);
	 // 
	  Employee saveEmployee(Employee employee);
	  
	  Employee getSingleEmployee(Long id);
	  
	  void deleteEmployee(Long id);
	  
	  Employee updateEmployee(Employee employee);
	  
	  //Finder method
	  List<Employee> getEmployeesByName(String name);
	  List<Employee> getEmployeesByNameAndLocation(String name,String location);
	  List<Employee> getEmployeesByKeyword(String name);
	  
	  //JPQL method
	  List<Employee> getEmployeesByNameOrLocation(String name,String location);
	  Integer deleteByEmployeeName(String name);
}
