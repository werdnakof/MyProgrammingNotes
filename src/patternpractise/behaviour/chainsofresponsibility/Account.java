package patternpractise.behaviour.chainsofresponsibility;

abstract class Account {

    protected Account successor;
    protected Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    public void setNext(Account account) {
        this.successor = account;
    }

    public void pay(Double amountToPay) throws Exception {
        if (this.canPay(amountToPay)) {
            System.out.println( String.format("Paid %s using %s" , amountToPay, this.getClass().getName()));
        } else if (this.successor != null) {
            System.out.println( String.format("Cannot pay using %s. Proceeding .." , this.successor.getClass().getName()));
            this.successor.pay(amountToPay);
        } else {
            throw new Exception("None of the accounts have enough balance");
        }
    }

    public boolean canPay(Double amount) {
        return this.balance >= amount;
    }

    public static class Paypal extends Account {
        protected Double balance;

        public Paypal(Double balance) {
            super(balance);
            this.balance = balance;
        }
    }

    public static class Bitcoin extends Account {
        protected Double balance;

        public Bitcoin(Double balance) {
            super(balance);
            this.balance = balance;
        }
    }

    public static class Bank extends Account {
        protected Double balance;

        public Bank(Double balance) {
            super(balance);
            this.balance = balance;
        }
    }

    public static void main(String[] vargs) throws Exception {
        Bank bank = new Bank(100.0);
        Paypal paypal = new Paypal(200.0);
        Bitcoin bitcoin = new Bitcoin(300.0);

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        bank.pay(260.0);
    }
}
