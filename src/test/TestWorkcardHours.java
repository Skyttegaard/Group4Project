package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.WorkcardController;

class TestWorkcardHours {
	static WorkcardController wcc;
	@BeforeEach
	public void setUp() {
		wcc = new WorkcardController();
		wcc.createWorkcard(1, 1);
		
	}
	
	@Test
	void testNegativeValues() {
		// Arrange
		int normalHour = -1;
		int overtimeHour = -1;
		String comment = "test";
		
		
		// Act
		wcc.addHours(normalHour, overtimeHour, comment);
		// Assert
		assertNotEquals(normalHour,wcc.testGetWorkcard().getNormalHours());
		assertNotEquals(overtimeHour,wcc.testGetWorkcard().getOvertimeHours());
	}
	void testMaxValues() {
		// Arrange
		int normalHour = 25;
		int overtimeHour = 25;
		String comment = "test";
		
		// Act
		wcc.addHours(normalHour, overtimeHour, comment);
		// Assert
		assertNotEquals(normalHour,wcc.testGetWorkcard().getNormalHours());
		assertNotEquals(overtimeHour,wcc.testGetWorkcard().getOvertimeHours());
	}
	
	void testLowerBorderValues() {
		// Arrange
		int normalHour = 1;
		int overtimeHour = 1;
		String comment = "test";
		
		// Act
		wcc.addHours(normalHour, overtimeHour, comment);
		
		// Assert
		assertEquals(normalHour,wcc.testGetWorkcard().getNormalHours());
		assertEquals(overtimeHour,wcc.testGetWorkcard().getOvertimeHours());
		
	}
	void testMaxBorderValues() {
		// Arrange
		int normalHour = 25;
		int overtimeHour = 25;
		String comment = "test";
		
		// Act
		wcc.addHours(normalHour, overtimeHour, comment);
		
		// Assert
		assertEquals(normalHour,wcc.testGetWorkcard().getNormalHours());
		assertEquals(overtimeHour,wcc.testGetWorkcard().getOvertimeHours());
	}

}
