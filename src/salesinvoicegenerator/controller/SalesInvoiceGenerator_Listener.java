package salesinvoicegenerator.controller;

import salesinvoicegenerator.model.InvoiceHeaderData;
import salesinvoicegenerator.model.InvoiceHeaderTableModel;
import salesinvoicegenerator.model.InvoiceLineData;
import salesinvoicegenerator.model.InvoiceLineTableModel;
import salesinvoicegenerator.view.MainFrame;
import salesinvoicegenerator.view.InvoiceHeaderNewWindow;
import salesinvoicegenerator.view.InvoiceLineNewWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class SalesInvoiceGenerator_Listener implements ActionListener, ListSelectionListener {

    private MainFrame frame;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public SalesInvoiceGenerator_Listener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                displayNewInvoiceDialog();
                break;
            case "DeleteInvoice":
                deleteSpecificInvoice();
                break;
            case "CreateNewLine":
                displayNewLineWindow();
                break;
            case "DeleteLine":
                deleteSpecificLine();
                break;
            case "LoadFile":
                loadSpecificFile();
                break;
            case "SaveFile":
                saveSpecificData();
                break;
            case "createInvCancel":
                createNewInvoiceCancel();
                break;
            case "createInvOK":
                createNewInvoiceOK();
                break;
            case "createLineCancel":
                createNewLineCancel();
                break;
            case "createLineOK":
                createNewLineOK();
                break;
        }
    }

    private void loadSpecificFile() {
        //JOptionPane.showMessageDialog(frame, "Please, select header file", "Attension", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerTableFile = openFile.getSelectedFile();
            try {
                FileReader headerFileReader = new FileReader(headerTableFile);
                BufferedReader headerBufferedReader = new BufferedReader(headerFileReader);
                String headerLineStr = null;

                while ((headerLineStr = headerBufferedReader.readLine()) != null) {
                    String[] headerPartsStr = headerLineStr.split(",");
                    String invoiceHeaderNumStr = headerPartsStr[0];
                    String invoiceHeaderDateStr = headerPartsStr[1];
                    String invoiceHeaderCustomerName = headerPartsStr[2];

                    int invoiceHeaderInvoiceNum = Integer.parseInt(invoiceHeaderNumStr);
                    Date invoiceHeaderInvoiceDate = df.parse(invoiceHeaderDateStr);

                    InvoiceHeaderData InvoiceHeaderDataObject = new InvoiceHeaderData(invoiceHeaderInvoiceNum, invoiceHeaderCustomerName, invoiceHeaderInvoiceDate);
                    frame.getInvoicesList().add(InvoiceHeaderDataObject);
                }

                //JOptionPane.showMessageDialog(frame, "Please, select lines file", "Attension", JOptionPane.INFORMATION_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] linePartsStr = linesLine.split(",");
                        //System.out.println("j = " + lineParts);
                        String invoiceLineInvoiceNumberStr = linePartsStr[0];
                        String invoiceLineItemName = linePartsStr[1];
                        String invoiceLineItemPriceStr = linePartsStr[2];
                        String invoiceLineItemCountStr = linePartsStr[3];

                        int invoiceLineInvoiceNumber = Integer.parseInt(invoiceLineInvoiceNumberStr);
                        double invoiceLineItemPrice = Double.parseDouble(invoiceLineItemPriceStr);
                        int invoiceLineItemCount = Integer.parseInt(invoiceLineItemCountStr);
                        InvoiceHeaderData InvoiceHeaderDataObject = findInvoiceByNum(invoiceLineInvoiceNumber);
                        InvoiceLineData InvoiceLineDataObject = new InvoiceLineData(invoiceLineItemName, invoiceLineItemPrice, invoiceLineItemCount, InvoiceHeaderDataObject);
                        InvoiceHeaderDataObject.getInvoiceHeaderData_InvoiceDataLines().add(InvoiceLineDataObject);
                    }
                    frame.setInvoiceHeaderTableModel(new InvoiceHeaderTableModel(frame.getInvoicesList()));
                    frame.getInvoices_Table().setModel(frame.getInvoiceHeaderTableModel());
                    frame.getInvoices_Table().validate();
                }
                //System.out.println("Done");
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error In Date Format \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error In Number Format \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error In File \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error In Read \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //displayInvoices();
    }

    private void saveSpecificData() {
        String headersStr = "";
        String linesStr = "";
        for (InvoiceHeaderData InvoiceHeaderDataObject : frame.getInvoicesList()) {
            headersStr += InvoiceHeaderDataObject.dateConvertion();
            headersStr += "\n";
            for (InvoiceLineData InvoiceLineDataObject : InvoiceHeaderDataObject.getInvoiceHeaderData_InvoiceDataLines()) {
                linesStr += InvoiceLineDataObject.dataConvertion();
                linesStr += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please, Choose File To Save Header Table Data!", "Foucs", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerTableFile = fileChooser.getSelectedFile();
            try {
                FileWriter headerFileWriter = new FileWriter(headerTableFile);
                headerFileWriter.write(headersStr);
                headerFileWriter.flush();
                headerFileWriter.close();

                JOptionPane.showMessageDialog(frame, "Please, Choose File To Save Line Table Data!", "Foucs", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineTableFile = fileChooser.getSelectedFile();
                    FileWriter lineFileWriter = new FileWriter(lineTableFile);
                    lineFileWriter.write(linesStr);
                    lineFileWriter.flush();
                    lineFileWriter.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frame, "successfully, Data Saved!", "Done", JOptionPane.INFORMATION_MESSAGE);
    }

    private InvoiceHeaderData findInvoiceByNum(int invNum) {
        InvoiceHeaderData InvoiceHeaderData_Object = null;
        for (InvoiceHeaderData indexInInvoiceHeaderData : frame.getInvoicesList()) {
            if (invNum == indexInInvoiceHeaderData.getInvoiceHeaderData_InvoiceNumber()) {
                InvoiceHeaderData_Object = indexInInvoiceHeaderData;
                break;
            }
        }
        return InvoiceHeaderData_Object;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("You're Select Invoice.");
        invoicesTableRowSelected();
    }

    private void invoicesTableRowSelected() {
        int invoiceHedaerSelectedRowIndex = frame.getInvoices_Table().getSelectedRow();
        if (invoiceHedaerSelectedRowIndex >= 0) {
            InvoiceHeaderData invoiceHeaderRow = frame.getInvoiceHeaderTableModel().getInvoicesList().get(invoiceHedaerSelectedRowIndex);
            frame.getCustomerName_TextField().setText(invoiceHeaderRow.getInvoiceHeaderData_InvoiceCustomerName());
            frame.getInvoiceDate_TextField().setText(df.format(invoiceHeaderRow.getInvoiceHeaderData_InvoiceDate()));
            frame.getInvoiceNumber_Label().setText("" + invoiceHeaderRow.getInvoiceHeaderData_InvoiceNumber());
            frame.getInvoiceTotal_Label().setText("" + invoiceHeaderRow.getInvoiceHeaderData_InvoiceTotal());
            ArrayList<InvoiceLineData> lines = invoiceHeaderRow.getInvoiceHeaderData_InvoiceDataLines();
            frame.setInvoiceLinesTableModel(new InvoiceLineTableModel(lines));
            frame.getInvoiceLines_Table().setModel(frame.getInvoiceLinesTableModel());
            frame.getInvoiceLinesTableModel().fireTableDataChanged();
        }
    }

    private void displayNewInvoiceDialog() {
        frame.setHeaderDialog(new InvoiceHeaderNewWindow(frame));
        frame.getHeaderDialog().setVisible(true);
    }

    private void displayNewLineWindow() {
        frame.setLineDialog(new InvoiceLineNewWindow(frame));
        frame.getLineDialog().setVisible(true);
    }

    private void createNewInvoiceCancel() {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void createNewInvoiceOK() {
        String invoiceHeader_invoiceDateStr = frame.getHeaderDialog().getNewInvH_invoiceDate_TextField().getText();
        String invoiceHeader_customerName = frame.getHeaderDialog().getCustomerName_TextField().getText();

        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
        try {
            int invoiceHeader_invoiceNumber = getNextInvoiceNum();
            Date invoiceDateConvertion = df.parse(invoiceHeader_invoiceDateStr);
            InvoiceHeaderData InvoiceHeaderDataObject = new InvoiceHeaderData(invoiceHeader_invoiceNumber, invoiceHeader_customerName, invoiceDateConvertion);
            frame.getInvoicesList().add(InvoiceHeaderDataObject);
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "You Enter Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        //displayInvoices();
    }

    private int getNextInvoiceNum() {
        int maxIndexOfTable = 0;
        for (InvoiceHeaderData InvoiceHeaderData_Object : frame.getInvoicesList()) {
            if (InvoiceHeaderData_Object.getInvoiceHeaderData_InvoiceNumber() > maxIndexOfTable) {
                maxIndexOfTable = InvoiceHeaderData_Object.getInvoiceHeaderData_InvoiceNumber();
            }
        }
        return maxIndexOfTable + 1;
    }

    private void createNewLineCancel() {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }

    private void createNewLineOK() {
        String invoiceLine_itemName = frame.getLineDialog().getNewInvL_itemName_TextField().getText();
        String invoiceLine_itemPriceStr = frame.getLineDialog().getNewInvL_itemPrice_TextField().getText();
        String invoiceLine_itemCountStr = frame.getLineDialog().getNewInvL_itemCount_TextField().getText();

        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);

        int invoiceLine_itemCount = Integer.parseInt(invoiceLine_itemCountStr);
        int invoiceHeaderIndex = frame.getInvoices_Table().getSelectedRow();
        double invoiceLine_itemPrice = Double.parseDouble(invoiceLine_itemPriceStr);
        InvoiceHeaderData invoice = frame.getInvoiceHeaderTableModel().getInvoicesList().get(invoiceHeaderIndex);

        InvoiceLineData invoiceLineObject = new InvoiceLineData(invoiceLine_itemName, invoiceLine_itemPrice, invoiceLine_itemCount, invoice);
        invoice.getInvoiceHeaderData_AddDataLine(invoiceLineObject);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvoiceTotal_Label().setText("" + invoice.getInvoiceHeaderData_InvoiceTotal());
        //displayInvoices();
    }

    private void deleteSpecificInvoice() {
        int IndexOfInvoiceData = frame.getInvoices_Table().getSelectedRow();
        InvoiceHeaderData InvoiceHeaderData_Object = frame.getInvoiceHeaderTableModel().getInvoicesList().get(IndexOfInvoiceData);
        frame.getInvoiceHeaderTableModel().getInvoicesList().remove(IndexOfInvoiceData);
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.setInvoiceLinesTableModel(new InvoiceLineTableModel(new ArrayList<InvoiceLineData>()));
        frame.getInvoiceLines_Table().setModel(frame.getInvoiceLinesTableModel());
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getCustomerName_TextField().setText("");
        frame.getInvoiceDate_TextField().setText("");
        frame.getInvoiceNumber_Label().setText("");
        frame.getInvoiceTotal_Label().setText("");
        //displayInvoices();
    }

    private void deleteSpecificLine() {
        int IndexOfLine = frame.getInvoiceLines_Table().getSelectedRow();
        InvoiceLineData IndexDataLine = frame.getInvoiceLinesTableModel().getInvoiceLines().get(IndexOfLine);
        frame.getInvoiceLinesTableModel().getInvoiceLines().remove(IndexOfLine);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvoiceTotal_Label().setText("" + IndexDataLine.getInvoiceHeaderDataObject().getInvoiceHeaderData_InvoiceTotal());
        //displayInvoices();
    }

    /*private void displayInvoices() {
     System.out.println("***************************");
     for (InvoiceHeaderData header : frame.getInvoicesList()) {
     System.out.println(header);
     }
     System.out.println("***************************");
     }*/
}
