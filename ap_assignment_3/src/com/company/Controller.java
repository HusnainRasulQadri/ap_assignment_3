package com.company;

import java.util.HashMap;
import java.util.Vector;

public class Controller {
	BinaryTree vocabulary;
	private FileHandler[] threads;
	private HashMap<String,HashMap<String,Integer>> data;
	private Vector<Word> words;
	Controller(String[] args) throws InterruptedException {
		vocabulary = new BinaryTree();
		threads = new FileHandler[args.length];
		data = new HashMap<String,HashMap<String,Integer>>(args.length);
		words = new Vector<Word>();
		for (int i=0; i< args.length ;i++) {
			threads[i] = new FileHandler(args[i]);
			threads[i].setFileName(args[i]);
			threads[i].setName(args[i]);
			threads[i].start();
		}
		threads[0].join();
		HashMap<String,Integer> vocab = threads[0].getData();
		for (var itr : vocab.entrySet()) {
			//System.out.println("Putting In:" + itr.getKey());
			vocabulary.insert(itr.getKey());
		}

		for (int i=1; i< args.length ;i++) {
			threads[i].join();
			data.put(threads[i].getName(), threads[i].getData());
		}
	}
	public void startProgram() throws InterruptedException {
		while (true) {
			int noOfQueries = 0;
			Query[] queries;
			switch (UI.menu()) {
				case 1:
					UI.inorder(vocabulary.getRoot());
					break;
				case 2:
					for (var itr : data.entrySet()) {
						UI.printFileData(itr.getKey(),itr.getValue());
					}
					break;
				case 3:
					StringBuilder vocabulary_data = new StringBuilder ();
					vocabulary.getDataInInorderFunc(vocabulary.getRoot(), vocabulary_data);
					String vocabularyData = vocabulary_data.toString();
					//System.out.println(vocabularyData);
					String[] vocabularyDataTokens = vocabularyData.split(" ");
					noOfQueries = vocabularyDataTokens.length;

					queries = new Query[noOfQueries];
					for (int x=0; x<noOfQueries;x++) {
						queries[x] = new Query();
						queries[x].run(data,vocabularyDataTokens[x]);
						queries[x].start();
					}
					for (int x=0; x<noOfQueries;x++) {
						queries[x].join();
						if (queries[x].getResult().get("Total") != 0) {
							Word word = new Word(queries[x].getWord(), queries[x].getResult());
							words.add(word);
						}
					}
					UI.printWords(words);
					break;
				case 4:
					String query = UI.queryIntialiser();
					String[] tokens = query.split(" ");
					noOfQueries = tokens.length;
					queries = new Query[noOfQueries];
					for (int x=0; x<noOfQueries;x++){
						queries[x] = new Query();
						queries[x].run(data,tokens[x]);
						queries[x].start();
					}
					HashMap<String,Integer>[] results = new HashMap[noOfQueries];
					for (int x=0; x<noOfQueries;x++) {
						queries[x].join();
						UI.printWordMatchResult(queries[x].getResult(), queries[x].getWord());
					}
					break;
				case 5:
					return;
				default:
					break;
			}
		}
	}
}
