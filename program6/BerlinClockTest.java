package program6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinClockTest {
@Test
public void testTime1() {// this tests for berlin clock's top yellow light blinks every couple of even seconds
	String aTime="13:15:04";
	String expectedResult="Y\r\n"
			+ "RROO\r\n"
			+ "RRRO\r\n"
			+ "YYROOOOOOOO\r\n"
			+ "OOOO";
	BerlinClock berlinClock = new BerlinClock();
	String actualResult=berlinClock.convertTime(aTime);
	assertEquals(expectedResult,actualResult);
	
}
@Test

public void testTime2() {//// this tests for berlin clock's top yellow light getting off every couple of odd seconds
	String aTime="13:15:05";
	String expectedResult="O\r\n"
			+ "RROO\r\n"
			+ "RRRO\r\n"
			+ "YYROOOOOOOO\r\n"
			+ "OOOO";
	BerlinClock berlinClock = new BerlinClock();
	String actualResult=berlinClock.convertTime(aTime);
	assertEquals(expectedResult,actualResult);
	
}


}
