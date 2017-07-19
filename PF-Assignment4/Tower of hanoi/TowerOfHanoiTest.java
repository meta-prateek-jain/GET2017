import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This is test class  for Tower of hanoi 
 * @author Prateek Jain
 * Dated 18/07/2017
 */
public class TowerOfHanoiTest {
	TowerOfHanoi towerOfHanoi = new TowerOfHanoi();

	// This test case tests for moving a single disk
	@Test
	public void singleDiskTest() {
		List<String> hanoiTower = towerOfHanoi.towerOfHanoi("A", "B", "C", 1);
		List<String> movements = new ArrayList<>(Arrays.asList("Move disk 1 from A to B\n"));
		// Displaying the Movements steps
		System.out.println("Steps of Movement(s) of Single Disk");
		for (String string : hanoiTower) {
			System.out.println(string);
		}
		assertEquals(movements, hanoiTower);
	}

	// This test case tests for moving a two disks
	@Test
	public void twoDiskTest() {
		List<String> hanoiTower = towerOfHanoi.towerOfHanoi("A", "B", "C", 2);
		List<String> movements = new ArrayList<>();
		movements.add("Move disk 1 from A to C\n");
		movements.add("Move disk 2 from A to B\n");
		movements.add("Move disk 1 from C to B\n");
		// Displaying the Movements steps
		System.out.println("Steps of Movement(s) of Two Disks");
		for (String string : hanoiTower) {
			System.out.println(string);
		}
		assertEquals(movements, hanoiTower);
	}

	// This test case tests for moving a three disks
	@Test
	public void threeDiskTest() {
		List<String> hanoiTower = towerOfHanoi.towerOfHanoi("A", "B", "C", 3);
		List<String> movements = new ArrayList<>();
		movements.add("Move disk 1 from A to B\n");
		movements.add("Move disk 2 from A to C\n");
		movements.add("Move disk 1 from B to C\n");
		movements.add("Move disk 3 from A to B\n");
		movements.add("Move disk 1 from C to A\n");
		movements.add("Move disk 2 from C to B\n");
		movements.add("Move disk 1 from A to B\n");
		// Displaying the Movements steps
		System.out.println("Steps of Movement(s) of Three Disks");
		for (String string : hanoiTower) {
			System.out.println(string);
		}
		assertEquals(movements, hanoiTower);
	}
}
