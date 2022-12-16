package in.sandeep.springrestapi.Exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String,Object> body= new LinkedHashMap<>();
		body.put("timeStamp", System.currentTimeMillis());
		body.put("status", status.value());
		
		//get All the error
		List<String> errors=ex.getBindingResult()
							.getAllErrors()
							.stream()
							.map(x ->x.getDefaultMessage())
							.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<Object>(body,status);
	}
	

	
	
}
