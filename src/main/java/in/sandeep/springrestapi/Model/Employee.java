package in.sandeep.springrestapi.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotEmpty(message="Please enter name")
	private String name;
	
	@NotNull(message="please neter age")
	private Long age=0L;
	
	@NotNull(message="please enter location")
	private String location;
	
	@NotBlank
	@Email(message="please enter valid email")
	private String email;
	
	@NotEmpty(message="please enter department")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at",nullable = false,updatable = false)
	private Date created_at;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updated_at;

}
