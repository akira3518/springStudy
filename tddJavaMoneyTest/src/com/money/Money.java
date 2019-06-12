package com.money;

public abstract class Money {
	
	protected int amount;
	protected String currency;
	
	protected Money (int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}

	public Money times(int multiplier) {
		return null;
	}
	
	public static Money dollar(int amount) {
		return new Dollar( amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Franc( amount, "CHF");
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount
				&& getClass().equals(money.getClass());
	}
	
	public String currency() {
		return currency;
	}
	
	public String toString() {
		return amount + "   " + currency;
	}
}
