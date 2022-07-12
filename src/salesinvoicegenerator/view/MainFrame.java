package salesinvoicegenerator.view;

import salesinvoicegenerator.controller.SalesInvoiceGenerator_Listener;
import salesinvoicegenerator.model.InvoiceHeaderData;
import salesinvoicegenerator.model.InvoiceHeaderTableModel;
import salesinvoicegenerator.model.InvoiceLineTableModel;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoices_Table = new javax.swing.JTable();
        invoices_Table.getSelectionModel().addListSelectionListener(listener);
        createNewInvoice_Button = new javax.swing.JButton();
        createNewInvoice_Button.addActionListener(listener);
        deleteSpecificInvoice_Button = new javax.swing.JButton();
        deleteSpecificInvoice_Button.addActionListener(listener);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerName_TextField = new javax.swing.JTextField();
        invoiceDate_TextField = new javax.swing.JTextField();
        invoiceNumber_Label = new javax.swing.JLabel();
        invoiceTotal_Label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceLines_Table = new javax.swing.JTable();
        createNewLine_Button = new javax.swing.JButton();
        createNewLine_Button.addActionListener(listener);
        deleteSpecificLine_Button = new javax.swing.JButton();
        deleteSpecificLine_Button.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFiles_MenuItem = new javax.swing.JMenuItem();
        loadFiles_MenuItem.addActionListener(listener);
        saveFiles_MenuItem = new javax.swing.JMenuItem();
        saveFiles_MenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoices_Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));
        jScrollPane1.setViewportView(invoices_Table);

        createNewInvoice_Button.setText("Create New Invoice");
        createNewInvoice_Button.setActionCommand("CreateNewInvoice");

        deleteSpecificInvoice_Button.setText("Delete Invoice");
        deleteSpecificInvoice_Button.setActionCommand("DeleteInvoice");

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoide Date");

        jLabel3.setText("Customer name");

        jLabel4.setText("Invoice Total");

        invoiceLines_Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));
        jScrollPane2.setViewportView(invoiceLines_Table);

        createNewLine_Button.setText("Create New Line");
        createNewLine_Button.setActionCommand("CreateNewLine");

        deleteSpecificLine_Button.setText("Delete Line");
        deleteSpecificLine_Button.setActionCommand("DeleteLine");

        jMenu1.setText("File");

        loadFiles_MenuItem.setText("Load File");
        loadFiles_MenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadFiles_MenuItem);

        saveFiles_MenuItem.setText("Save File");
        saveFiles_MenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveFiles_MenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(createNewLine_Button)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                        .addComponent(deleteSpecificLine_Button)
                                        .addGap(113, 113, 113))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel4))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(customerName_TextField)
                                                                .addComponent(invoiceDate_TextField)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(invoiceNumber_Label)
                                                                                .addComponent(invoiceTotal_Label))
                                                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(createNewInvoice_Button)
                        .addGap(85, 85, 85)
                        .addComponent(deleteSpecificInvoice_Button)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(invoiceNumber_Label))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(invoiceDate_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(customerName_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4)
                                                .addComponent(invoiceTotal_Label))
                                        .addGap(29, 29, 29)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(createNewLine_Button)
                                                .addComponent(deleteSpecificLine_Button)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(createNewInvoice_Button)
                                .addComponent(deleteSpecificInvoice_Button))
                        .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNewInvoice_Button;
    private javax.swing.JButton createNewLine_Button;
    private javax.swing.JTextField customerName_TextField;
    private javax.swing.JButton deleteSpecificInvoice_Button;
    private javax.swing.JButton deleteSpecificLine_Button;
    private javax.swing.JTextField invoiceDate_TextField;
    private javax.swing.JTable invoiceLines_Table;
    private javax.swing.JLabel invoiceNumber_Label;
    private javax.swing.JLabel invoiceTotal_Label;
    private javax.swing.JTable invoices_Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFiles_MenuItem;
    private javax.swing.JMenuItem saveFiles_MenuItem;
    // End of variables declaration//GEN-END:variables

    private InvoiceHeaderTableModel invoiceHeaderTableModel;
        private InvoiceLineNewWindow lineDialog;
    private InvoiceLineTableModel invoiceLinesTableModel;
        private List<InvoiceHeaderData> invoicesList = new ArrayList<>();
        private SalesInvoiceGenerator_Listener listener = new SalesInvoiceGenerator_Listener(this);
    private InvoiceHeaderNewWindow headerDialog;

    public SalesInvoiceGenerator_Listener getListener() {
        return listener;
    }

    public void setHeaderDialog(InvoiceHeaderNewWindow headerDialog) {
        this.headerDialog = headerDialog;
    }

    public void setLineDialog(InvoiceLineNewWindow lineDialog) {
        this.lineDialog = lineDialog;
    }

    public void setInvoiceHeaderTableModel(InvoiceHeaderTableModel invoiceHeaderTableModel) {
        this.invoiceHeaderTableModel = invoiceHeaderTableModel;
    }

    public void setInvoiceLinesTableModel(InvoiceLineTableModel invoiceLinesTableModel) {
        this.invoiceLinesTableModel = invoiceLinesTableModel;
    }

    public JButton getCreateNewInvoice_Button() {
        return createNewInvoice_Button;
    }

    public JButton getCreateNewLine_Button() {
        return createNewLine_Button;
    }

    public JTextField getCustomerName_TextField() {
        return customerName_TextField;
    }

    public JButton getDeleteSpecificInvoice_Button() {
        return deleteSpecificInvoice_Button;
    }

    public JButton getDeleteSpecificLine_Button() {
        return deleteSpecificLine_Button;
    }

    public JTextField getInvoiceDate_TextField() {
        return invoiceDate_TextField;
    }

    public JTable getInvoiceLines_Table() {
        return invoiceLines_Table;
    }

    public JLabel getInvoiceNumber_Label() {
        return invoiceNumber_Label;
    }

    public JLabel getInvoiceTotal_Label() {
        return invoiceTotal_Label;
    }

    public JTable getInvoices_Table() {
        return invoices_Table;
    }

    public JMenuItem getLoadFiles_MenuItem() {
        return loadFiles_MenuItem;
    }

    public JMenuItem getSaveFiles_MenuItem() {
        return saveFiles_MenuItem;
    }

    public List<InvoiceHeaderData> getInvoicesList() {
        return invoicesList;
    }

    public InvoiceHeaderTableModel getInvoiceHeaderTableModel() {
        return invoiceHeaderTableModel;
    }

    public InvoiceLineTableModel getInvoiceLinesTableModel() {
        return invoiceLinesTableModel;
    }

    public InvoiceHeaderNewWindow getHeaderDialog() {
        return headerDialog;
    }

    public InvoiceLineNewWindow getLineDialog() {
        return lineDialog;
    }
}
