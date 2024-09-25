package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	/**
	 * 
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
