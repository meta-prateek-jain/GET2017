/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 * 
 * 		Remove Duplicates From Array
 * 
 */
public class RemoveDuplicate {
	public  int[] removeDuplicate(int input[])
		{					
			int[] n ;
			int k=input.length;
			int i;
			int j;
			int s;
			int m;
			int a;
			for(i = 0; i<k; i++)
				{												/* checking duplicates and removing it*/
					for(j=(i+1); j<k; j++)
						{
							if(input[i]==input[j])
							{
								s = j;
					                for (m = j+1; m < k; m++, s++) {
					                    input[s] = input[m];
					                }
					                k--;
					                j--;
							}
						}
				}
			n= new int[k];									// defining size of array
			for(a = 0; a < k; a++)							/* adding values to array*/
			{
				n[a] = input[a];
			}
			return n;
		}
}
