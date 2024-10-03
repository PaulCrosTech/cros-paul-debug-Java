package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Write symptoms occurrences into a file. This class implements ISymptomWriter.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * Write the couple symptom / occurrence in a text file.
	 * 
	 * @param Object Map of symptom / occurrence.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// Generate a string like symptom = quantity
		StringBuilder builder = new StringBuilder();
		symptoms.forEach((symptom, quantity) -> {
			builder.append(symptom + " = " + quantity + "\n");
		});

		// Write content to file
		try {
			FileWriter writer = new FileWriter("result.out");
			writer.write(builder.toString());
			writer.close();
		} catch (IOException e) {
			System.out.println("Impossible d'écrire dans le fichier result.out");
		}
	}
}
