package me.anil.geektrust.lengaburu.exception;

import me.anil.geektrust.lengaburu.utils.Constants;

/*
 * Exception thrown when a person is not found
 */
public class PersonNotFoundException extends LengaburuBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		System.out.println(Constants.PERSON_NOT_FOUND);
	}

}
