/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 *  	
 *  	@Author Prateek Jain
 * 	
 * 		This class is used to Join Sorted array
 * 
 * 		Assumptions : Input array is sorted in ascending order
 * 	
 * 
 */
public class JoinSortedArray {
	public int[] join(int a[], int asize, int b[], int bsize, int c[])
	{
			int m = 0;
			int n = 0;
			int i=0;
	
			while(m<asize && n<bsize)
			{							/* While loop is used to add values to resulting array  */
				if(a[m] < b[n])
			
				{
					c[i] = a[m];
					m++;
				}
				else
				{
					c[i] = b[n];
					n++;
				}
				i++;
			}
			
			while(m<asize)				/* Adding remaining elements of array 1 in final array*/
			{
				c[i++] = a[m++];
			}
			while(n<bsize)				/* Adding remaining elements of array 2 in final array*/
			{
				c[i++] = b[n++];
			}
		return c;
	}
	/*
	 * This function checks whether array is sorted in ascending order or not
	 * 
	 */
	public boolean isSorted(int[] data) {
		boolean status = false;
		for(int h = 1; h< data.length; h++)
		{
			if(data[h-1]>data[h])
			{
				status = true;
			}
		}
		return status;
	}
}
