/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 * 
 * 		This class is used to Join Sorted array
 * 
 * 		Assumptions : Input array is sorted in ascending order
 * 
 * 		@Author Prateek Jain
 */
public class fcfs {
	
	public int[][] FCFS(int arrival_time[],int job_size[])
	{
		int[][] job = null ;						//Resulting array
		int i;
		int j;
		int size;	
		int jobSize = 0;
		if(arrival_time.length==job_size.length)
		{	size = arrival_time.length; 
			job = new int[size][5];
			job[0][2] = 0;
			job[0][3] = 1;
			/*
			 * This loop add values in job column
			 */
			for(j=1;j<=size;j++)
			{
				job[j-1][0] = j;
			}
			/*
			 * This loop add values in job arrived time and job finished time column
			 * 
			 */
			for(j = 0; j < size; j++)
			{
				job[j][1] = arrival_time[j];
				jobSize =  job_size[j] + jobSize;
				job[j][4] =jobSize;
				
			}
			/*
			 * This last two blocks add values in job wait time and job start at column by doing calculations
			 */
			for(i = 1; i < size; i++)
			{	
				if(job[i][1] <= job[i-1][4])
				{
					job[i][3] = job[i-1][4] + 1;
				}
				else
				{
					job[i][3] = job[i][1];
				}
				
			}
			for(int q=1; q < size; q++)
			{
				job[q][2] = job[q][3] - job[q][1];
			}
		}
		System.out.println("Job  Job arrived at  Job wait time  Job Start at   Job finished at");
		for(int w = 0; w<arrival_time.length; w++)
		{
			for(int e = 0 ; e<5; e++)
			{
				System.out.print(job[w][e]+" \t      ");
			}
			System.out.println();
		}
		return job;
		
	}
	
}
