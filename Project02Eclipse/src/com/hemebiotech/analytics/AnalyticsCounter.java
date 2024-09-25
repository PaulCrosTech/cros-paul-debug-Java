package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private ISymptomReader ISymptomReader;
	private ISymptomWriter ISymptomWriter;

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
