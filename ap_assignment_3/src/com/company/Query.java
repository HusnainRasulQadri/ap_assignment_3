package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class Query extends Thread{
	private volatile HashMap<String,Integer> result;
	private volatile String word;
	public HashMap<String,Integer> run(HashMap<String,HashMap<String,Integer>> data,String word) {
		result = new HashMap<String,Integer>();
		this.word = word;
		int counter =0;
		HashMap<String,Integer> temp;
		for (var itr : data.entrySet()) {
			temp = itr.getValue();
			if (temp.containsKey(word)) {
				counter += temp.get(word);
				result.put(itr.getKey(),temp.get(word));
			}
		}
		result.put("Total",counter);
		//super.run();
		return result;
	}
	public HashMap<String,Integer> getResult() {
		return result;
	}
	public String getWord() {
		return word;
	}
}
