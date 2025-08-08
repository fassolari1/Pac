package FinancialHistory;

public class Main {
    public static void main(String[] args) {
        try {
            // Crea un nuovo oggetto FinancialHistory con un saldo iniziale di 1000
            FinancialHistory history = new FinancialHistory(1000);

            // Aggiungi alcune entrate
            history.receivedFrom(500, "Stipendio");
            history.receivedFrom(200, "Vendita oggetti");

            // Aggiungi alcune spese
            history.spendFrom(100, "Spesa alimentare");
            history.spendFrom(50, "Trasporti");

            // Stampa il saldo attuale
            System.out.println("Saldo attuale: " + history.cashOnhand());

            // Stampa le entrate
            System.out.println(history.printIncomes());

            // Stampa le spese
            System.out.println(history.printExpenditures());

        } catch (NegAmmountException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (NegCashException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
