package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Analytics application : Counts the number of symptom occurrences contained in a text file.
 * @author Paul CROS
 */
public class Main {

	/**
	 * Application entry point.
	 * @param args Command line arguments (not used)
	 */
	public static void main(String[] args)
	{
		// Full path to the symptom file that should be read.
		String pathToFile = "symptoms.txt";
		
		ISymptomReader reader = new ReadSymptomDataFromFile(pathToFile);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter  = new AnalyticsCounter(reader, writer);
		
		List<String> symptomsList = analyticsCounter.getSymptoms();
		if(symptomsList.isEmpty())
		{
			System.out.println("Le fichier " + pathToFile + " ne contient aucun symptômes.");
			System.exit(0);
		}
		
		Map<String, Integer> symptomsQuantity = analyticsCounter.countSymptoms(symptomsList);
		
		symptomsQuantity = analyticsCounter.sortSymptoms(symptomsQuantity);
		
		analyticsCounter.writeSymptoms(symptomsQuantity);
	}
}
