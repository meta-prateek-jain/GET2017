import static org.junit.Assert.*;
import org.junit.Test;

public class fcfsTest {
	 @Test
	public void evalueFCFS() {

	 fcfs schedule = new fcfs();
	 int arrival_time[] = new int[]{1,5,9,25};
	 int job_size[] = new int[]{12, 7, 2, 8};
	 int job1[][] = new int[][]{{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
	 int job2[][] = null;
	 job2 = schedule.FCFS(arrival_time, job_size);
	 assertArrayEquals(job1, job2);
	 
 }
}
