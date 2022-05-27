package com.bank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.resource.UserAcctResource;
import com.bank.account.service.UserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
/**
*
* @author Yogya Hewavidana
*
*/
@RestController
@RequestMapping("/v1/user")
@Api(tags = "User Controller")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * In real application userId won't define as @RequestParam. It will retrieve
	 * from auth token.
	 * 
	 */
	@GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserAcctResource>> userAccounts(@RequestParam("userId") Long userId) {

		log.info("Retrieving accounts for user: " + userId);

		return ResponseEntity.ok(userService.getUserAccounts(userId));
	}

}


//override the sensitiveHeaders property and exclude the Authorization from the comma-delimited list.
//
//sensitiveHeaders: Cookie,Set-Cookie

//
//@RequestHeader("Authorization") String authorization
//
//if (authorization != null && authorization.startsWith("bearer "))
//{
//    String substring = getBearerToken(authorization);
//    Jwt jwt = JwtHelper.decode(substring);
//    String claimsStr = jwt.getClaims();
//    Map<String, Object> claims = (Map<String, Object>) mapper.readValue(claimsStr, Object.class);
//    return ""+claims.get("user_name");