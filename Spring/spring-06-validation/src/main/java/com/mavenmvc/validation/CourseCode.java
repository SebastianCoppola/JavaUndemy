package com.mavenmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//default couser code:
	public String value() default "LUV";
	
	//default error messages:
	public String message() default "must start with LUV";
	
	//default groups:
	public Class<?>[] groups() default {};
	
	//default payloads:
	public Class <? extends Payload>[] payload() default {};
}
