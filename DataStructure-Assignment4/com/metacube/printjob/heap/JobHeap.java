package com.metacube.printjob.heap;

import java.util.ArrayList;
import java.util.List;

import com.metacube.printjob.model.Job;

/**
 * This is a heap class which is used to create a heap or we can say max-heap
 * 
 * @author Prateek Jain
 *
 */
public class JobHeap {

	List<Job> documentsToPrint = new ArrayList<Job>();

	/**
	 * Method is used to add each element to the documents to print
	 * 
	 * @param job
	 */
	public void addDocument(Job job) {
		//if job is present then add it to documents to print
		if (job.getPriorityIndex() != -1) {
			documentsToPrint.add(job);
		}
		heapify(documentsToPrint.size(), 0);
		sort();
	}

	/**
	 * Method is used to make the tree a binary heap;
	 * 
	 * @param size
	 * @param index
	 */
	private void heapify(int size, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		/*
		 * if left index is less than size of heap and if priority of this job
		 * is greater than job at root node then set largeest variable this
		 * index value
		 */
		if (left < size && documentsToPrint.get(left).compareTo(documentsToPrint.get(largest)) < 0) {
			largest = left;
		}
		/*
		 * if left index is less than size of heap and if priority of this job
		 * is greater than job at root node then set largeest variable this
		 * index value
		 */
		if (right < size && documentsToPrint.get(right).compareTo(documentsToPrint.get(largest)) < 0) {
			largest = right;
		}
		/*
		 * if largest is not equal to the main index then swap both the values
		 */
		if (largest != index) {
			swap(largest, index);

			// Recursively heapify the sub-tree
			heapify(size, largest);
		}
	}

	/**
	 * Method is used to sort the arrayList heap
	 * 
	 * @param largest
	 * @param index
	 */
	private void swap(int largest, int index) {
		Job temp = documentsToPrint.get(index);
		documentsToPrint.set(index, documentsToPrint.get(largest));
		documentsToPrint.set(largest, temp);
	}

	/**
	 * Method is used to sort the list
	 */
	public void sort() {

		int size = documentsToPrint.size();

		// loop is used to build the heap
		for (int index = size / 2 - 1; index >= 0; index--) {
			heapify(size, index);
		}

		// loop continue to take out value one at a time
		for (int index = size - 1; index >= 0; index--) {
			swap(index, 0);
			heapify(index, 0);
		}
	}

	// getters and setters
	public List<Job> getDocumentsToPrint() {
		return documentsToPrint;
	}

	public void setDocumentsToPrint(List<Job> documentsToPrint) {
		this.documentsToPrint = documentsToPrint;
	}
}
