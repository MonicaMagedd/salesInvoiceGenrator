package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int invoiceNumber;
    private Date invoiceDate;
    private String customerName;
    //TODO
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader() {}

    public InvoiceHeader(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public InvoiceHeader(int invoiceNumber, Date invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "Invoice Number=" + getInvoiceNumber() +
                ", Invoice Date=" + getInvoiceDate() +
                ", Customer Name='" + getCustomerName() + '\'' +
                '}';
    }
}
