/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 * 
 * 		Checking Array Sorted or Not
 * 		@author Prateek Jain
 * 
 */
public class ArraySort {

	public int arrayCheck(int a[])
	{
		int i;
		int n;
		int size1=1;							//length of ascending sorted array
		int size2=1;							//length of descending sorted array
		boolean st1 = true;
		boolean st2 = true;
		
		for(i = 0; i < (a.length-1); i++)
		{
			if(a[i]<a[i+1])						// checking  array next element is greater or not
			{
				st2 = false;
				size1++;
			}
			else if (a[i]>a[i+1])				//checking array next element is smaller or not
			{
				st1 = false;
				size2++;
			
			}
					
		}
		if(size1==a.length)						// if length is equal then array is sorted in ascending order
		{
			n=1;
			
		}
		else if(size2==a.length)				// if length is equal then array is sorted in descending order
		{
			n=2;
		}
		else									// array is not sorted
		{
			n=0;
		}
		return n;
	}
}
