package code.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DriverExceptionController {
	
	@ExceptionHandler(value= DriverNotFoundException.class)
	public @ResponseBody String exception(DriverNotFoundException exception) {
		return "No ride Found";
	}
	

}
