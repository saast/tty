package ee.tty.praktikum2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {
	private Calc calc;
    
	@Before
	public void creatCalc(){
		calc = new Calc();
	}

	@Test
	public void testPayJuniorZero() {
		int hours = 0;
		assertEquals(0, calc.pay(Calc.JUNIOR, hours));
	}

	@Test
	public void testPayJuniorNormal() {
		int hours = 6;
		assertEquals(60, calc.pay(Calc.JUNIOR, hours));
	}

	@Test
	public void testPayJunior8() {
		int hours = 8;
		assertEquals(80, calc.pay(Calc.JUNIOR, hours));
	}

	@Test
	public void testPayJunior8Plus() {
		int hours = 9;
		assertEquals(100, calc.pay(Calc.JUNIOR, hours));
	}

	@Test
	public void testPayJunior20Plus() {
		int hours = 21;
		assertEquals(350, calc.pay(Calc.JUNIOR, hours));
	}
	
	// SENIOR

	
	@Test
	public void testPaySeniorZero() {
		int hours = 0;
		assertEquals(0, calc.pay(Calc.SENIOR, hours));
	}

	@Test
	public void testPaySeniorNormal() {
		int hours = 6;
		assertEquals(90, calc.pay(Calc.SENIOR, hours));
	}

	@Test
	public void testPaySenior8() {
		int hours = 8;
		assertEquals(120, calc.pay(Calc.SENIOR, hours));
	}

	@Test
	public void testPaySenior8Plus() {
		int hours = 9;
		assertEquals(150, calc.pay(Calc.SENIOR, hours));
	}

	@Test
	public void testPaySenior20Plus() {
		int hours = 21;
		assertEquals(530, calc.pay(Calc.SENIOR, hours));
	}	
	
	// SPECIALIST
	
	@Test
	public void testPaySpecialistZero() {
		int hours = 0;
		assertEquals(0, calc.pay(Calc.SPECIALIST, hours));
	}

	@Test
	public void testPaySpecialistNormal() {
		int hours = 6;
		assertEquals(132, calc.pay(Calc.SPECIALIST, hours));
	}

	@Test
	public void testPaySpecialist8() {
		int hours = 8;
		assertEquals(176, calc.pay(Calc.SPECIALIST, hours));
	}

	@Test
	public void testPaySpecialist9() {
		int hours = 9;
		assertEquals(198, calc.pay(Calc.SPECIALIST, hours));
	}

	@Test
	public void testPaySpecialist9Plus() {
		int hours = 10;
		assertEquals(264, calc.pay(Calc.SPECIALIST, hours));
	}

	@Test
	public void testPaySpecialist20Plus() {
		int hours = 21;
		assertEquals(1020, calc.pay(Calc.SPECIALIST, hours));
	}		
}
