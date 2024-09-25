package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ej.blocs.Type;

public class AnalyticsCounter {

	private ISymptomReader ISymptomReader;
	private ISymptomWriter ISymptomWriter;
	
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	
	public AnalyticsCounter(ISymptomReader ISymptomReader, ISymptomWriter ISymptomWriter)
	{
		this.ISymptomReader = ISymptomReader;
		this.ISymptomWriter = ISymptomWriter;
	}
	
	public List<String> getSymptoms()
	{
		return ISymptomReader.GetSymptoms();
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms)
	{
		ISymptomWriter.writeSymptoms(symptoms);
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms)
	{
		Map<String, Integer> quantiteSymptom = new TreeMap<String, Integer>();
		
		symptoms.forEach((symptom) -> {
			quantiteSymptom.merge(symptom, 1, Integer::sum);
		});
		
		return quantiteSymptom;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return symptoms;
	}
	
}
