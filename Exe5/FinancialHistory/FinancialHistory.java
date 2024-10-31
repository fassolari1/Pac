package FinancialHistory;

import java.util.Enumeration;
import java.util.Hashtable;

public class FinancialHistory implements FinantialHistoryInterface{
	
	private float cashOnHand;
	private Hashtable<String, Float> incomes, expenditures;
	
	public FinancialHistory(float ammount) {
		if(ammount < 0) throw new NegAmmountException("Ammontare negativo!");
		else {
			cashOnHand = ammount;
			incomes = new Hashtable<String, Float>();
			expenditures = new Hashtable<String, Float>();
		}
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

	/** approccio con StringBuilder*/
	@Override
	public String printIncomes() {
		
		StringBuilder s = new StringBuilder();
		s.append("Incomes: ");
		
		incomes.forEach((k,v) -> {
			s.append("\n" + k + "\t" + v.toString());
		});
		return s.toString();
	}
	
	/** approccio con List<> di chiavi e ciclo While*/
	@Override
	public String printIncomes2() {
		
		StringBuilder s = new StringBuilder();
		Enumeration <String> lista_keys = incomes.keys();
		
		while(lista_keys.hasMoreElements()) {
			String key = lista_keys.nextElement();
			s.append("\n" + key + "\t" + incomes.get(key));
		}
		return s.toString();
	}

	/** approccio con StringBuilder*/
	@Override
	public String printExpenditures() {
		
		StringBuilder s = new StringBuilder();
		s.append("Expenditure: ");
		
		expenditures.forEach((k,v) -> {
			s.append("\n" + k + "\t" + v.toString());
		});
		return s.toString();
	}	
}
