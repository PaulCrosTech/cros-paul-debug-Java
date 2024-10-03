package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Analytics application : Counts the number of symptom occurrences contained in
 * a text file.
 * 
 * @author Paul CROS
 */
public class Main {

	/**
	 * Application entry point.
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args) {
		System.out.println("Debut traitement");

		// Full path to the symptom file that should be read.
		String pathToFile = "symptoms.txt";

		// Instantiate objects ISymptomReader, ISymptomWriter, AnalyticsCounter
		ISymptomReader reader = new ReadSymptomDataFromFile(pathToFile);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		// Read symptoms from file
		List<String> symptomsList = analyticsCounter.getSymptoms();

		// Count Symptoms
		Map<String, Integer> symptomsQuantity = analyticsCounter.countSymptoms(symptomsList);

		// Order symptoms by alpha
		symptomsQuantity = analyticsCounter.sortSymptoms(symptomsQuantity);

		// Write symptoms to file result.out
		analyticsCounter.writeSymptoms(symptomsQuantity);

		System.out.println("Fin du traitement");
	}
}
