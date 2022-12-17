package view;

import model.InvoiceHeader;
import model.InvoiceLine;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Printer {
    public void print(InvoiceHeader invoiceInvoiceHeader, InvoiceLine invoiceLine) {
        List<InvoiceHeader> invoiceHeadersList;
        List<InvoiceHeader> finallyinvoiceHeadersList;
        try {
            invoiceHeadersList = invoiceInvoiceHeader.performReadAction();
            finallyinvoiceHeadersList = invoiceLine.performReadAction(invoiceHeadersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
