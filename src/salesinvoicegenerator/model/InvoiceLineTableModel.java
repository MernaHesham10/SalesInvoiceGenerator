package salesinvoicegenerator.model;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import java.text.*;

public class InvoiceLineTableModel extends AbstractTableModel {

    private DateFormat dataFormatObject = new SimpleDateFormat("dd-MM-yyyy");
    private String[] cols = {"Item Name", "Item Price", "Count", "Line Total"};
    private List<InvoiceLineData> invoiceLines;

    public InvoiceLineTableModel(List<InvoiceLineData> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public List<InvoiceLineData> getInvoiceLines() {
        return invoiceLines;
    }

    @Override
    public int getRowCount() {
        return invoiceLines.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cols[columnIndex];
            case 1:
                return cols[columnIndex];
            case 2:
                return cols[columnIndex];
            case 3:
                return cols[columnIndex];
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLineData row = invoiceLines.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return row.getInvoiceLineData_itemName();
            case 1:
                return row.getInvoiceLineData_itemPrice();
            case 2:
                return row.getInvoiceLineData_itemCounter();
            case 3:
                return row.getInvoiceLineData_Total();
            default:
                return "";
        }
    }
}
