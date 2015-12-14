package ee.tty.praktikum2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalc {
	private Calc calc;

    public static final int JUNIOR = 1;
    public static final int SENIOR = 2;
    public static final int SPECIALIST = 3;
    
	@Before
	public void creatCalc(){
		calc = new Calc();
	}

	@Test
	public void testPayJuniorZero() {
		int type = JUNIOR;
		int hours = 0;
		assertEquals(0, calc.pay(type, hours));
	}

	@Test
	public void testPayJuniorNormal() {
		int type = JUNIOR;
		int hours = 6;
		assertEquals(60, calc.pay(type, hours));
	}

	@Test
	public void testPayJunior8() {
		int type = JUNIOR;
		int hours = 8;
		assertEquals(80, calc.pay(type, hours));
	}

	@Test
	public void testPayJunior8Plus() {
		int type = JUNIOR;
		int hours = 9;
		assertEquals(100, calc.pay(type, hours));
	}

	@Test
	public void testPayJunior20Plus() {
		int type = JUNIOR;
		int hours = 21;
		assertEquals(350, calc.pay(type, hours));
	}
	
	// SENIOR

	
	@Test
	public void testPaySeniorZero() {
		int type = SENIOR;
		int hours = 0;
		assertEquals(0, calc.pay(type, hours));
	}

	@Test
	public void testPaySeniorNormal() {
		int type = SENIOR;
		int hours = 6;
		assertEquals(90, calc.pay(type, hours));
	}

	@Test
	public void testPaySenior8() {
		int type = SENIOR;
		int hours = 8;
		assertEquals(120, calc.pay(type, hours));
	}

	@Test
	public void testPaySenior8Plus() {
		int type = SENIOR;
		int hours = 9;
		assertEquals(150, calc.pay(type, hours));
	}

	@Test
	public void testPaySenior20Plus() {
		int type = SENIOR;
		int hours = 21;
		assertEquals(530, calc.pay(type, hours));
	}	
	
	// SPECIALIST
	
	@Test
	public void testPaySpecialistZero() {
		int type = SPECIALIST;
		int hours = 0;
		assertEquals(0, calc.pay(type, hours));
	}

	@Test
	public void testPaySpecialistNormal() {
		int type = SPECIALIST;
		int hours = 6;
		assertEquals(132, calc.pay(type, hours));
	}

	@Test
	public void testPaySpecialist8() {
		int type = SPECIALIST;
		int hours = 8;
		assertEquals(176, calc.pay(type, hours));
	}

	@Test
	public void testPaySpecialist9() {
		int type = SPECIALIST;
		int hours = 9;
		assertEquals(198, calc.pay(type, hours));
	}

	@Test
	public void testPaySpecialist9Plus() {
		int type = SPECIALIST;
		int hours = 10;
		assertEquals(264, calc.pay(type, hours));
	}

	@Test
	public void testPaySpecialist20Plus() {
		int type = SPECIALIST;
		int hours = 21;
		assertEquals(1020, calc.pay(type, hours));
	}		
}
