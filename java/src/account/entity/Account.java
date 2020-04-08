package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	//default constructor
	public Account() {
		
	}

	public Account(String custId, String acctId, int balance) {
		super();
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금
	public void deposite(int amount) {
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) {
		if(balance >= amount)
		this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + " , balance=" + balance+"]";
	}
}
