package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class read symptoms from a file, count them, and write them to a file.  
 */
public class AnalyticsCounter {
	private ISymptomReader ISymptomReader;
	private ISymptomWriter ISymptomWriter;

	/**
	 * 
	 * @param ISymptomReader
	 * @param ISymptomWriter
	 */
	public AnalyticsCounter(ISymptomReader ISymptomReader, ISymptomWriter ISymptomWriter)
	{
		this.ISymptomReader = ISymptomReader;
		this.ISymptomWriter = ISymptomWriter;
	}
	
	/**
	 * Return the full list of symptom contained in the text file.
	 * @return Symptom list.
	 */
	public List<String> getSymptoms()
	{
		return ISymptomReader.GetSymptoms();
	}
	
	/**
	 * Write in a file the number of occurrences of each symptom.
	 * @param Object Map of symptom / occurrence.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms)
	{
		ISymptomWriter.writeSymptoms(symptoms);
	}
	
	/**
	 * Count the occurrence of each symptom.
	 * @param symptoms List of symptoms.
	 * @return Map of symptom / occurrence.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms)
	{
		Map<String, Integer> quantitySymptom = new HashMap<String, Integer>();
		
		symptoms.forEach((symptom) -> {
			quantitySymptom.merge(symptom, 1, Integer::sum);
		});
		
		return quantitySymptom;
	}
	
	
	/**
	 * Sort symptoms in alphabetical order
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
}
