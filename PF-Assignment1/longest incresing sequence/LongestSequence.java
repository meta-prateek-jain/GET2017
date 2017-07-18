/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 * 
 * 		Finding Longest Increasing Sequence
 * 
 */
public class LongestSequence {
	
	 int[] getLS(int[] input){
		int start_index=0;
		int end_index=0;
		int length=1;
		int max_length=1;
		int max_start=0;
		int max_end=0;
		for(int i = 0; i <(input.length-1); i++){		//This loop checks the for longest sequence 
			if(input[i] < input[i+1]){
				end_index++;
				length++;
			}
			else{
				 if(length>max_length){
						max_start=start_index;
						max_end=end_index;
					}
				start_index=i+1;
				end_index=start_index;
				length=0;
				}
			}
		if(length>max_length){						//This block compare the length of two sequence
			max_start=start_index;
			max_end=end_index;
		}
		int[] res=new int[max_end-max_start+1];
		for(int i=max_start,k=0;i<=max_end;i++){        //This loop store the longest sequence into result array
			res[k++]=input[i];
		}
		
		return res;
	}


}
