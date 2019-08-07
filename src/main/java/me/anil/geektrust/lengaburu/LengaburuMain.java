package me.anil.geektrust.lengaburu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import me.anil.geektrust.lengaburu.service.FileInputProcessor;
import me.anil.geektrust.lengaburu.utils.Constants;

/**
 * Main Class used to load Initial Hierarchy and used to take input from file
 * 
 * @author Anil Paul
 * 
 * @version 1.0
 * 
 * 
 */
public class LengaburuMain {

	public static void main(String[] args) {

		// Initialzing hierarchy on application startup
		LengaburuMainLoader.initializeFamliy();

		if (args.length > 0) {
			String filename = args[0];
			try (Stream<String> stream = Files.lines(Paths.get(filename))) {
				stream.forEach(command -> FileInputProcessor.processCommand(command));
			} catch (IOException e) {
				System.out.println(Constants.ERROR_FILE_NOT_FOUND);
			}
		} else {
			System.out.println(Constants.ERROR_FULL_FILE_NAME);
		}
	}
}
