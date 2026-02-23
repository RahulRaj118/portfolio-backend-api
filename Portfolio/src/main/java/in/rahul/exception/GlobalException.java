package in.rahul.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
		LocalDateTime time = LocalDateTime.now();
		ErrorResponse error = new ErrorResponse(exception.getMessage(),HttpStatus.NOT_FOUND.value(),time);
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserCreatedException.class)
	public ResponseEntity<ErrorResponse> handleUserCreatedException(UserCreatedException exception){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(),HttpStatus.BAD_REQUEST.value(),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidException(MethodArgumentNotValidException exception){
		
		Map<String, String> errorMap = new HashMap<>();
		BindingResult result = exception.getBindingResult();
		List<FieldError> errorList = result.getFieldErrors();
		errorList.forEach((s)->errorMap.put(s.getField(), s.getDefaultMessage()));
	
	return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);	
	}
	
	 @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<Object> handleNotFound(
	            NoHandlerFoundException ex,
	            HttpServletRequest request) {

	        Map<String, Object> error = new HashMap<>();
	        error.put("timestamp", LocalDateTime.now());
	        error.put("status", 404);
	        error.put("error", "Not Found");
	        error.put("message", "The requested endpoint does not exist");
	        error.put("path", request.getRequestURI());

	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex){
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(),LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR) ;
	}


}
