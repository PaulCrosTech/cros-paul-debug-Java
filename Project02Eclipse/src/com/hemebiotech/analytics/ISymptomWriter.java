package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface describe how to Write symptoms into a file. 
 */
public interface ISymptomWriter {
	/**
	 * Write the pair symptom / occurrences into a file. 
	 * @param symptoms Object Map of symptom / occurrence.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
