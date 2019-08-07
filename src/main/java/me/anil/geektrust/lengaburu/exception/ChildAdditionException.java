package me.anil.geektrust.lengaburu.exception;

import me.anil.geektrust.lengaburu.utils.Constants;

/*
 * Exception thrown when a child cannot be added
 */
public class ChildAdditionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChildAdditionException() {
		System.out.println(Constants.CHILD_ADDITION_FAILED);
	}

}
