package controller;

import model.InvoiceHeader;
import model.InvoiceLine;
import view.Printer;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        InvoiceHeader invoiceInvoiceHeader = new InvoiceHeader();
        InvoiceLine invoiceLine = new InvoiceLine();
        Printer printer = new Printer();
        printer.print(invoiceInvoiceHeader, invoiceLine);
    }

}