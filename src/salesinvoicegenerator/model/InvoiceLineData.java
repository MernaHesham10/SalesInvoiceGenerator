package salesinvoicegenerator.model;

public class InvoiceLineData {

    private double InvoiceLineData_itemPrice;
    private String InvoiceLineData_itemName;
    private InvoiceHeaderData InvoiceHeaderDataObject;
    private int InvoiceLineData_itemCounter;

    public InvoiceLineData(String InvoiceLineData_itemName, double InvoiceLineData_itemPrice, int InvoiceLineData_itemCounter, InvoiceHeaderData InvoiceHeaderDataObject) {
        this.InvoiceLineData_itemName = InvoiceLineData_itemName;
        this.InvoiceLineData_itemPrice = InvoiceLineData_itemPrice;
        this.InvoiceLineData_itemCounter = InvoiceLineData_itemCounter;
        this.InvoiceHeaderDataObject = InvoiceHeaderDataObject;
    }

    public String getInvoiceLineData_itemName() {
        return InvoiceLineData_itemName;
    }

    public void setInvoiceLineData_itemName(String InvoiceLineData_itemName) {
        this.InvoiceLineData_itemName = InvoiceLineData_itemName;
    }

    public double getInvoiceLineData_itemPrice() {
        return InvoiceLineData_itemPrice;
    }

    public void setInvoiceLineData_itemPrice(double InvoiceLineData_itemPrice) {
        this.InvoiceLineData_itemPrice = InvoiceLineData_itemPrice;
    }

    public int getInvoiceLineData_itemCounter() {
        return InvoiceLineData_itemCounter;
    }

    public void setInvoiceLineData_itemCounter(int InvoiceLineData_itemCounter) {
        this.InvoiceLineData_itemCounter = InvoiceLineData_itemCounter;
    }

    public InvoiceHeaderData getInvoiceHeaderDataObject() {
        return InvoiceHeaderDataObject;
    }

    public void setInvoiceHeaderDataObject(InvoiceHeaderData InvoiceHeaderDataObject) {
        this.InvoiceHeaderDataObject = InvoiceHeaderDataObject;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "itemName=" + InvoiceLineData_itemName + ", itemprice=" + InvoiceLineData_itemPrice + ", itemCount=" + InvoiceLineData_itemCounter + '}';
    }

    public double getInvoiceLineData_Total() {
        return InvoiceLineData_itemCounter * InvoiceLineData_itemPrice;
    }

    public String dataConvertion() {
        return "" + getInvoiceHeaderDataObject().getInvoiceHeaderData_InvoiceNumber() + "," + getInvoiceLineData_itemName() + "," + getInvoiceLineData_itemPrice() + "," + getInvoiceLineData_itemCounter();
    }
}
