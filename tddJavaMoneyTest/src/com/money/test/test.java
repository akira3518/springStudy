package com.money.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.money.Dollar;

public class test {
	
	@Test
	public void testMultiplication () {
		Dollar five = new Dollar(5);
		five.times(2); 
		assertEquals(10, five.amount);
		five.times(3); 
		assertEquals(15, five.amount);
	}
	
	@Test
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertTrue(new Dollar(5).equals(new Dollar(6)));
	}
	
}
