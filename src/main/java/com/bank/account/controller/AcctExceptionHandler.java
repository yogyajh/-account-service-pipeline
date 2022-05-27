package com.bank.account.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.bank.account.util.exception.AccountsNotFoundException;
import com.bank.account.util.exception.ErrorMessage;

/**
*
* @author Yogya Hewavidana
*
*/

@RestControllerAdvice
public class AcctExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, AccountsNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleInvalidParameter(EntityNotFoundException ex, WebRequest request){
    	
	  return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}


//@ControllerAdvice write global code that can be applied to a wide range of controllers
//
//@ControllerAdvice + @ResponseBody
//
//1.Common place for Error handling
//2.Similar Error Response body with a proper HTTP status code across APIs
//
//ResponseEntity
//
//ResponseEntity represents the whole HTTP response: status code, headers, and body.