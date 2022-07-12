package salesinvoicegenerator.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class InvoiceHeaderTableModel extends AbstractTableModel {

    private List<InvoiceHeaderData> invoicesList;
    private String[] cols = {"No.", "Customer Name", "Invoice Date", "Invoice Total"};
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceHeaderTableModel(List<InvoiceHeaderData> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public List<InvoiceHeaderData> getInvoicesList() {
        return invoicesList;
    }

    @Override
    public int getRowCount() {
        return invoicesList.size();
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
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
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
        InvoiceHeaderData row = invoicesList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return row.getInvoiceHeaderData_InvoiceNumber();
            case 1:
                return row.getInvoiceHeaderData_InvoiceCustomerName();
            case 2:
                return df.format(row.getInvoiceHeaderData_InvoiceDate());
            case 3:
                return row.getInvoiceHeaderData_InvoiceTotal();
            default:
                return "";
        }
    }
}
