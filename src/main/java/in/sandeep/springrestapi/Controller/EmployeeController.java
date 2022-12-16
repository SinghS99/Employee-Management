package in.sandeep.springrestapi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sandeep.springrestapi.Model.Employee;
import in.sandeep.springrestapi.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
    @GetMapping("/employees")
	public ResponseEntity<List<Employee>>getEmployees(@RequestParam Integer pageNumber,@RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>>(employeeService.getEmployee(pageNumber,pageSize),HttpStatus.OK);
	}
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable ("id") Long id) {
    	return new ResponseEntity<Employee>(employeeService.getSingleEmployee(id),HttpStatus.OK);
    }
    
    //http://localhost:8080/employees?id=34
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus>  deleteEmployees(@RequestParam ("id") Long id) {
    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee( @Valid @RequestBody Employee employee) {
    	return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    	
    }
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable ("id")Long id) {
    	employee.setId(id);
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }
    
    //Finder method Controller
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
    	return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name),HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,String location){
    	return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location),HttpStatus.OK);
    	
    }
    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword( @RequestParam String name){
    	return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByKeyword(name),HttpStatus.OK);
    	
    }
    //JPQL methods controller
    @GetMapping("/employees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name,@PathVariable String location){
    	return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocation(name, location),HttpStatus.OK);
    }
    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
    	return new ResponseEntity<String>(employeeService.deleteByEmployeeName(name)+"No. of recored deleted",HttpStatus.OK);
    }
}






















