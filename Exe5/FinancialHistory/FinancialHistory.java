package FinancialHistory;

import java.util.Enumeration;
import java.util.Hashtable;

public class FinancialHistory implements FinantialHistoryInterface{
	
	private float cashOnHand;
	private String s;
	private Hashtable<String, Float> incomes, expenditures;
	
	public FinancialHistory(float ammount) {
		if(ammount < 0) throw new NegAmmountException("Ammontare negativo!");
		else cashOnHand = ammount;
	}

	@Override
	public float cashOnhand() {
		return cashOnHand;
	}

	/**
	 * @retrun value of spent 
	 */
	@Override
	public float receivedFrom(String s) {
		if(incomes.contains(s)) return incomes.get(s);
		return -1; //o solleva eccesione
	}

	@Override
	public float spentFor(String s) {
		if(expenditures.contains(s)) return expenditures.get(s);
		return -1; //o solleva eccesione
	}

	@Override
	public void receivedFrom(float ammount, String s) throws NegAmmountException{
		if(ammount < 0) throw new NegAmmountException("Ammontare negativo!");
		incomes.put(s, ammount);
		cashOnHand = cashOnHand + ammount;
	}

	@Override
	public void spendFrom(float ammount, String s) throws NegAmmountException{
		if(ammount < 0) throw new NegAmmountException("Ammontare negativo!");
		expenditures.put(s, ammount);
		cashOnHand = cashOnHand - ammount;
		controllaSaldo();		
	}
	
	public void controllaSaldo() {
		if(cashOnHand < 0) throw new NegCashException("Saldo Negativo!");
	}

	@Override
	public String printIncomes() {
		s = "Incomes: ";
		incomes.forEach((k,v) -> {
			s += "\n" + k + "\t" + v.toString();
		});
		return s;
	}

	@Override
	public String printExpenditures() {
		s = "Expenditures: ";
		expenditures.forEach((k,v) -> {
			s += "\n" + k + "\t" + v.toString();
		});
		return s;
	}
	
	
	
	
}
