package com.bank.account.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Yogya Hewavidana
 *
 */

@Configuration
@EntityScan({ "com.bank.account.domain" })
@EnableJpaRepositories({ "com.bank.account.repository" })
//@EnableJpaAuditing
public class JpaDataConfig {

	/**
	 * To enable JpaAuditing retrieve userId from oauth token and return it in the
	 * SpringSecurityAuditorAware getCurrentAuditor()
	 * 
	 * @Bean public AuditorAware<Long> auditorProvider() { 
	 * return new SpringSecurityAuditorAware(); }
	 */
	
	

//	 @Override
//	    public Optional<Long> getCurrentAuditor()
//	    {
//	        Optional<Long> op = Optional.empty();
//	        
//	        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//	        if(requestAttributes instanceof ServletRequestAttributes)
//	        {
//	            HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
//	            String header = servletRequest.getHeader("authorization");
//	            if(StringUtil.isNotEmpty(header))
//	            {
//	                Long userIdBearerToken = HeaderUtil.getUserIdBearerToken(header);
//	                return Optional.ofNullable(userIdBearerToken);
//	            }
//	        }
//	        return op;
//	    }
}
