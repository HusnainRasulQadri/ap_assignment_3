package com.company;

public class Node {
	private String data;
	private int frequency = 0;
	Node right;
	Node left;
	Node(String data) {
		this.data = data;
		left = right = null;
	}
	public void setData(String data) {
		this.data = data;
		this.frequency++;
	}
	public String getData(){
		return data;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getFrequency() {
		return frequency;
	}
	public void increamentFrequency(){
		this.frequency++;
	}
	public void setRight(Node node){
		right = node;
	}
	public void setLeft(Node node) {
		left = node;
	}
	public Node getRight(){
		return right;
	}
	public Node getLeft() {
		return left;
	}
}
