package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceHeader {
    private int invoiceNumber;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader() {}

    public InvoiceHeader(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public InvoiceHeader(int invoiceNumber, Date invoiceDate, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.lines = new ArrayList<>();
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(InvoiceLine line) {
        this.lines.add(line);
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
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
        return +this.getInvoiceNumber() +" \n{\n("
                +this.getInvoiceDate().getDay()+"/"
                +this.getInvoiceDate().getMonth()+"/"
                +(this.getInvoiceDate().getYear()+1900)+"),"
                +this.getCustomerName();
    }
    public List<InvoiceHeader> performReadAction() throws IOException, ParseException {
        FileOperations file = new FileOperations("./src/view/files/InvoiceHeader.csv");
        BufferedReader br  = file.readFile();
        String line = file.getLine();
        String splitBy = file.getSplitBy();
        List<InvoiceHeader> invoiceHeadersList = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] readInvoiceHeader = line.split(splitBy);
                int invoiceNumber = Integer.parseInt(readInvoiceHeader[0]);
                Date invoiceDate = new SimpleDateFormat("dd/MM/yyyy").parse(readInvoiceHeader[1]);
                InvoiceHeader invoiceHeader = new InvoiceHeader(invoiceNumber, invoiceDate, readInvoiceHeader[2]);
                invoiceHeadersList.add(invoiceHeader);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();

        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
         finally
        {
            return invoiceHeadersList;
        }
    }
}
