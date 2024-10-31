package FinancialHistory;

public interface FinantialHistoryInterface {
	
	public float cashOnhand();
	public float receivedFrom(String s);
	public float spentFor(String s);
	public void receivedFrom(float ammount, String s) throws NegAmmountException;
	public void spendFrom(float ammount, String s) throws NegAmmountException;
	public void controllaSaldo() throws NegCashException;
	public String printIncomes();
	public String printExpenditures();

}
