package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	public void writeSymptoms(Map<String, Integer> symptoms)
	{
		StringBuilder builder = new StringBuilder();
		symptoms.forEach((symptom, quantite) -> {
			builder.append(symptom + " = " + quantite + "\n");
		});
		
		try {
			FileWriter writer = new FileWriter("result.out");
			writer.write(builder.toString());
			writer.close();	
		} catch (IOException e) {
			System.out.println("Impossible d'écrire dans le fichier result.out");
		}
	}
}
