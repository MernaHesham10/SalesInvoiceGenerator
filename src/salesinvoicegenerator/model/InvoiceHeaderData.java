package salesinvoicegenerator.model;

import java.util.*;
import java.text.*;

public class InvoiceHeaderData {
    private ArrayList<InvoiceLineData> InvoiceHeaderData_InvoiceDataLines;
    private int InvoiceHeaderData_InvoiceNumber;
    private Date InvoiceHeaderData_InvoiceDate;
    private String InvoiceHeaderData_InvoiceCustomerName;

    public InvoiceHeaderData(int InvoiceHeaderData_InvoiceNumber, String InvoiceHeaderData_InvoiceCustomerName, Date InvoiceHeaderData_InvoiceDate) {
        this.InvoiceHeaderData_InvoiceNumber = InvoiceHeaderData_InvoiceNumber;
        this.InvoiceHeaderData_InvoiceCustomerName = InvoiceHeaderData_InvoiceCustomerName;
        this.InvoiceHeaderData_InvoiceDate = InvoiceHeaderData_InvoiceDate;
    }

    public Date getInvoiceHeaderData_InvoiceDate() {
        return InvoiceHeaderData_InvoiceDate;
    }

    public void setInvoiceHeaderData_InvoiceDate(Date InvoiceHeaderData_InvoiceDate) {
        this.InvoiceHeaderData_InvoiceDate = InvoiceHeaderData_InvoiceDate;
    }

    public int getInvoiceHeaderData_InvoiceNumber() {
        return InvoiceHeaderData_InvoiceNumber;
    }

    public void setInvoiceHeaderData_InvoiceNumber(int InvoiceHeaderData_InvoiceNumber) {
        this.InvoiceHeaderData_InvoiceNumber = InvoiceHeaderData_InvoiceNumber;
    }

    public String getInvoiceHeaderData_InvoiceCustomerName() {
        return InvoiceHeaderData_InvoiceCustomerName;
    }

    public void setInvoiceHeaderData_InvoiceCustomerName(String InvoiceHeaderData_InvoiceCustomerName) {
        this.InvoiceHeaderData_InvoiceCustomerName = InvoiceHeaderData_InvoiceCustomerName;
    }

    @Override
    public String toString() {
        String str = "InvoiceHeader{" + "invNum=" + InvoiceHeaderData_InvoiceNumber + ", customerName=" + InvoiceHeaderData_InvoiceCustomerName + ", invDate=" + InvoiceHeaderData_InvoiceDate + '}';
        for (InvoiceLineData line : getInvoiceHeaderData_InvoiceDataLines()) {
            str += "\n\t" + line;
        }
        return str;
    }

    public ArrayList<InvoiceLineData> getInvoiceHeaderData_InvoiceDataLines() {
        if (InvoiceHeaderData_InvoiceDataLines == null) {
            InvoiceHeaderData_InvoiceDataLines = new ArrayList<>();
        }
        return InvoiceHeaderData_InvoiceDataLines;
    }

    public void setInvoiceHeaderData_InvoiceDataLines(ArrayList<InvoiceLineData> InvoiceHeaderData_InvoiceDataLines) {
        this.InvoiceHeaderData_InvoiceDataLines = InvoiceHeaderData_InvoiceDataLines;
    }

    public double getInvoiceHeaderData_InvoiceTotal() {
        double calculatedTotal = 0.0;
        for (InvoiceLineData dataLineArray : getInvoiceHeaderData_InvoiceDataLines()) {
            calculatedTotal += dataLineArray.getInvoiceLineData_Total();
        }
        return calculatedTotal;
    }

    public void getInvoiceHeaderData_AddDataLine(InvoiceLineData line) {
        getInvoiceHeaderData_InvoiceDataLines().add(line);
    }

    public String dateConvertion() {
        DateFormat dataFormatObject = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceHeaderData_InvoiceNumber() + "," + dataFormatObject.format(getInvoiceHeaderData_InvoiceDate()) + "," + getInvoiceHeaderData_InvoiceCustomerName();
    }
}
