package com.example.group.demoArtifact.CustomExceptions;

import com.example.group.demoArtifact.exception.UserNotFoundException;
import com.example.group.demoArtifact.userDao.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
      //  return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));
        //  return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }

 @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status,
            WebRequest request) {
     ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
         "Total Error  " + ex.getErrorCount()+   "First Error  "+ ex.getFieldError().getDefaultMessage(),request.getDescription(false)

             );
     //  return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
     return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
    }
}