/*		PF & Unit Test Assignment 1
 * 
 * 		Dated: 13/07/2017
 * 
 * 		Converting Binary numbers to octal
 * 
 */
public class BinaryToOctal {
	public int convertBinaryToOctal(int n)
	{				
		 int rem;							//reminder
		 int decnum=0;						//decimal number
		 int quot;							//quotient
		 int i=1;							
		 int octnum[] = new int[10];
		 String value = "";
		 while(n > 0)
	        {								/* converts binary number to decimal*/
	            rem = n % 10;
	            decnum = decnum + rem*i;
	            i = i*2;
	            n = n/10;
	        }   

			i=1;
	        quot = decnum;
			
	        while(quot > 0)
	        {								/* converts decimal to octal */
	            octnum[i++] = quot % 8;
	            quot = quot / 8;
	        }
	      
	        for (int j = (octnum.length-1); j>0; j--)
	        {
	            value += octnum[j]; 		//using string to convert integer array into number 
	        }

	        int octalnumber = Integer.parseInt(value); // converting string into integer
	        return octalnumber;
	}
	public boolean checkBinary(int binary)
	{											/* checking number is a binary or not*/
		boolean status = true;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                if(tmp > 1){
                    status = false;
                    break;
                }
                binary = binary/10;
            }
        }
		return status;
	}
}
