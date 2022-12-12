package model;

public class InvoiceLine extends InvoiceHeader {
    private String itemName;
    private double itemPrice;
    static private int count;

    public InvoiceLine() {this.count ++;}
    public InvoiceLine(int invoiceNumber) {
        super(invoiceNumber);
        this.count ++;
    }

    public InvoiceLine(int invoiceNumber, String itemName, double itemPrice) {
        super(invoiceNumber);
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count ++;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public static int getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "InvoiceLine{" +
                "Invoice Number=" + getInvoiceNumber() +
                "Item Name='" + getItemName() + '\'' +
                ", Item Price=" + getItemName() +
                ", Count=" + getCount() +
                '}';
    }
}
