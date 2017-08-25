package com.metacube.printjob.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	List<Job> documentsToPrint = new ArrayList<Job>();
	
	public void addDocument(Job job){
		documentsToPrint.add(job);
		heapify(documentsToPrint.size(), 0);
	}
	private void heapify(int size, int index) {
		int largest = index;
		int left = 2*index + 1;
		int right = 2*index + 2;
		
		if(left < size && documentsToPrint.get(left).compareTo(documentsToPrint.get(largest)) > 0){
			largest = index;
		}
		if(right < size && documentsToPrint.get(right).compareTo(documentsToPrint.get(largest)) > 0){
			largest = index;
		}
		if(largest != index){
			swap(largest, index);
			
			//Recursively heapify the sub-tree
			heapify(size, largest);
		}
	}
	private void swap(int largest, int index) {
		Job temp = documentsToPrint.get(index);
		documentsToPrint.set(index, documentsToPrint.get(largest));
		documentsToPrint.set(largest, temp);
	}
	public void sort(){
		
		int size = documentsToPrint.size();
		
		//loop is used to build the heap
		for(int index = size / 2 -1; index >= 0; index--){
			heapify(size, index);
		}
		
		for(int index = size - 1; index >= 0; index--){
			swap(index, 0);
			heapify(index, 0);
		}
	}
	public List<Job> getDocumentsToPrint() {
		return documentsToPrint;
	}
	public void setDocumentsToPrint(List<Job> documentsToPrint) {
		this.documentsToPrint = documentsToPrint;
	}
}
