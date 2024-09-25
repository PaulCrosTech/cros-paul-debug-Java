package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args)
	{
		String pathToFile = "symptoms.txt";
		
		ISymptomReader reader = new ReadSymptomDataFromFile(pathToFile);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyticsCounter  = new AnalyticsCounter(reader, writer);
		
		List<String> symptomesListe = analyticsCounter.getSymptoms();
		if(symptomesListe.isEmpty())
		{
			System.out.println("Le fichier ne contient " + pathToFile + " ne contient aucun symptômes.");
			System.exit(0);
		}
		
		Map<String, Integer> symptomesQuantite = analyticsCounter.countSymptoms(symptomesListe);
		
		analyticsCounter.writeSymptoms(symptomesQuantite);
	}
}
