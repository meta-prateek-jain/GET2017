package com.metacube.printjob.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import com.metacube.printjob.heap.JobHeap;
import com.metacube.printjob.model.Job;

/**
 * Test class to test the Functioning of the job printing application
 * 
 * @author Prateek Jain
 *
 */
public class TestPrintingJob {

	JobHeap jobHeap;
	/**
	 * Setting up the instance of class object before start testing
	 */
	@Before
	public void setUp(){
		jobHeap = new JobHeap();
	}
	/**
	 * Test printer when no job to print
	 */
	@Test
	public void TestWhenNoJobIsAvailable() {
		assertTrue(jobHeap.getDocumentsToPrint().isEmpty());
	}

	/**
	 * Test printer when Job is available
	 */
	@Test
	public void TestWhenJobIsAvailable() {
		jobHeap.addDocument(new Job("Chairman", "Assistant Chairman"));
		assertFalse(jobHeap.getDocumentsToPrint().isEmpty());
	}
	
	/**
	 * Test job printing based on priority
	 */
	@Test
	public void TestJobPrintingBasedOnPriority() {
		jobHeap.addDocument(new Job("Professor", "Hindi Professor"));
		jobHeap.addDocument(new Job("Chairman", "Assistant Chairman"));
		jobHeap.addDocument(new Job("Graduate", "master degree"));
		List<Job> jobsList = jobHeap.getDocumentsToPrint();
		String actual = "";
		//loop continue till all jobs are printed
		for (Job job : jobsList) {
			actual += job.getJobTitle()+" ";
		}
		String expected = "Assistant Chairman Hindi Professor master degree ";
		assertEquals(expected, actual);
	}
	
	/**
	 * Test job heap when Empty value is Entered in Department and in Job
	 */
	@Test
	public void TestPrinterWhenEmptyValueEnteredInDepartmentAndInJob() {
		jobHeap.addDocument(new Job("", ""));
		assertTrue(jobHeap.getDocumentsToPrint().isEmpty());
	}
}
