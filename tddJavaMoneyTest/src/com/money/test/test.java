package com.money.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.money.Franc;
import com.money.Money;

public class test {
	
	@Test
	public void testMultiplication () {
		Money five = Money.dollar(5);  
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}

	@Test
	public void testFrancMultiplication () {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertTrue(Money.dollar(5).equals(Money.dollar(6)));
		assertTrue(Money.franc(5).equals(Money.franc(5)));
		assertTrue(Money.franc(5).equals(Money.franc(6)));
		assertTrue(new Franc(5, null).equals(Money.dollar(6)));
	}
	
	@Test
	public void testCurrency() {
		assertEquals("USD",Money.dollar(1).currency());
		assertEquals("CHF",Money.franc(1).currency());
	}
	
}
