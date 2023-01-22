package view;

import model.InvoiceHeader;
import model.InvoiceLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Printer {
    public void print(InvoiceHeader invoiceInvoiceHeader, InvoiceLine invoiceLine) {
        List<InvoiceHeader> invoiceHeadersList;
        List<InvoiceHeader> finallyinvoiceHeadersList = null;
        try {
            invoiceHeadersList = invoiceInvoiceHeader.performReadAction();
            finallyinvoiceHeadersList = invoiceLine.performReadAction(invoiceHeadersList);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File path is wrong");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("there is an error in reading/writing file");
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            System.out.println("there is an error in parsing dates");
        }
        for (int i = 0; i < finallyinvoiceHeadersList.size(); i++) {
            InvoiceHeader header = finallyinvoiceHeadersList.get(i);
            System.out.println(header);
            for (int j = 0; j < finallyinvoiceHeadersList.get(i).getLines().size(); j++) {
                InvoiceLine line = header.getLines().get(j);
                System.out.println(line);
            }
            System.out.println("}");
        }

    }
}
