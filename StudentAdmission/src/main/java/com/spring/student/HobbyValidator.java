package com.spring.student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

	@Override
	public void initialize(IsValidHobby arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches("Music")) {
			return true;
		}
		else {
			return false;
		}
	}
}
