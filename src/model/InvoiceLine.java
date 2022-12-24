package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        return this.getItemName()
                + ", " + this.getItemPrice() + ", "
                + this.getCount() + "";
    }

    public List<InvoiceHeader> performReadAction(List<InvoiceHeader> invoiceHeadersList) throws IOException {
        FileOperations file = new FileOperations("src/InvoiceLines.csv");
        BufferedReader br  = file.readFile();
        String line = file.getLine();
        String splitBy = file.getSplitBy();
        try {
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] readInvoiceLines = line.split(splitBy);
                int invoiceNumber = Integer.parseInt(readInvoiceLines[0]);
                String itemName = readInvoiceLines[1];
                int itemPrice = Integer.parseInt(readInvoiceLines[2]);
                InvoiceHeader invoiceHeader = invoiceHeadersList
                        .stream()
                        .filter(p -> p.getInvoiceNumber() == invoiceNumber).findFirst().get();
                InvoiceLine invoiceLine = new InvoiceLine(invoiceNumber, itemName, itemPrice);
                invoiceHeader.setLines(invoiceLine);
            }
        } catch (IOException e)
        {
            throw new IOException(e);
        }
        finally {
            return invoiceHeadersList;
        }
    }
}
