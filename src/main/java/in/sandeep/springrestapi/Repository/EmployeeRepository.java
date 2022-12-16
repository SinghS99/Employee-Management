package in.sandeep.springrestapi.Repository;

import java.util.List;



import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.sandeep.springrestapi.Model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	//SELECT * FROM tbl_emplyoee WHERE name=?
	List<Employee>findByName(String name);
	
	//SELECT * FROM tbl_emplyoee WHERE name=? AND location=?
	List<Employee>findByNameAndLocation(String name,String location);
	
	//SELECT * FROM tbl_emplyoee WHERE name LIKE "%ram%"
	List<Employee> findByNameContaining(String keyword,Sort sort);
	
	//JPQL-No Convention to follow write own methods name @Param is used when we need our own column name
	@Query("FROM Employee WHERE name = :name OR location =:location ")
	List<Employee> getEmployeesByNameOrLocation(String name,String location);
	
	//JPQL for delete create or update return type is int or void and @modifying @transactional is must
	@Transactional
	@Modifying
	@Query("DELETE FROM Employee WHERE name= :name")
	 Integer deleteEmployeeByName(String name);
	

}
