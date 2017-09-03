import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testWhackAMole {
	WhackAMole wam;
	
	@Before
	public void setUp() {
		wam = new WhackAMole(50, 10);
	}


	@Test
	public void testWhackAMole() {
		wam.printGrid();
	}
	
	@Test
	public void testRandowmPlaceAll() {
		wam.randomPlaceAll(10);
		wam.printGrid();
		System.out.println("---------");
		wam.printGridToUser();
	}

}
