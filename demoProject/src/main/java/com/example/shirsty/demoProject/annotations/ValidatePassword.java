package com.example.shirsty.demoProject.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.shirsty.demoProject.validation.PasswordValidatorLogic;

@Constraint(validatedBy = {PasswordValidatorLogic.class})
@Target({ ElementType.TYPE,ElementType.FIELD
	})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePassword {
	
	String message() default "Password Field Value don't match";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String pwd();
	String cfmpwd();
	
	@Target({ ElementType.TYPE, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
		ValidatePassword[] value();
    }

}
