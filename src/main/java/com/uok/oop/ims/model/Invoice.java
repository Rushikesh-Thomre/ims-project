package com.uok.oop.ims.model;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Invoice {
/*
    private String invoiceNumber;
    private String date;
    private String customerName;
    private List<String> items;
    private double totalAmount;

    // Constructor
    
    public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
    
   
	public Invoice(String invoiceNumber, String date, String customerName, List<String> items, double totalAmount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		this.customerName = customerName;
		this.items = items;
		this.totalAmount = totalAmount;
	}


	// Getters and Setters
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    

	public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // For easier printing and debugging
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
    */
	
	public class InvoiceItem {
		
//		@GeneratedValue(strategy= GenerationType.IDENTITY)
	    private String itemId;
	    private String itemName;
	    private double sellPrice;
	    private int quantity;
	    private double discount;
	    private double amount;

	    
	    public InvoiceItem() {
			super();
		}
	    
		public InvoiceItem(String itemId, String itemName, double sellPrice, int quantity, double discount,
				double amount) {
			super();
			this.itemId = itemId;
			this.itemName = itemName;
			this.sellPrice = sellPrice;
			this.quantity = quantity;
			this.discount = discount;
			this.amount = amount;
		}

	    public String getItemId() {
	        return itemId;
	    }

	    public void setItemId(String itemId) {
	        this.itemId = itemId;
	    }

	    public String getItemName() {
	        return itemName;
	    }

	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }

	    public double getSellPrice() {
	        return sellPrice;
	    }

	    public void setSellPrice(double sellPrice) {
	        this.sellPrice = sellPrice;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public double getDiscount() {
	        return discount;
	    }

	    public void setDiscount(double discount) {
	        this.discount = discount;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }
	}
}



