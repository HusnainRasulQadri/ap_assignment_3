package com.company;

import java.util.HashMap;

public class Word {
	private String word;
	private int frequency;
	HashMap<String,Integer> file_frequency;
	Word() {
		frequency=0;
	}
	Word(String word,HashMap<String,Integer> file_frequency) {
		this.word = word;
		this.file_frequency = file_frequency;
		this.frequency = file_frequency.get("Total");
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public void increaseFrequency() {
		this.frequency += 1;
	}
	public void setValues(String word,int frequency) {
		this.word = word;
		this.frequency =frequency;
	}
	public String getWord(){
		return word;
	}
	public int getFrequency() {
		return frequency;
	}
	public HashMap<String,Integer> getFile_frequency() {
		return file_frequency;
	}
}
