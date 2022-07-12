package salesinvoicegenerator.view;

import java.awt.GridLayout;
import javax.swing.*;

public class InvoiceHeaderNewWindow extends JDialog {

    private JTextField newInvH_invoiceDate_TextField;
    private JTextField newInvH_customerName_TextField;
    private JLabel newInvH_invDate_Label;
    private JLabel newInvH_customerName_Label;
    private JButton newInvH_cancel_Button;
    private JButton newInvH_ok_Button;

    public InvoiceHeaderNewWindow(MainFrame frame) {
        newInvH_customerName_Label = new JLabel("Customer Name:");
        newInvH_customerName_TextField = new JTextField(18);
        newInvH_invDate_Label = new JLabel("Invoice Date:");
        newInvH_invoiceDate_TextField = new JTextField(18);
        newInvH_ok_Button = new JButton("OK");
        newInvH_cancel_Button = new JButton("Cancel");

        newInvH_ok_Button.setActionCommand("createInvOK");
        newInvH_cancel_Button.setActionCommand("createInvCancel");

        newInvH_ok_Button.addActionListener(frame.getListener());
        newInvH_cancel_Button.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));

        add(newInvH_invDate_Label);
        add(newInvH_invoiceDate_TextField);
        add(newInvH_customerName_Label);
        add(newInvH_customerName_TextField);
        add(newInvH_ok_Button);
        add(newInvH_cancel_Button);

        pack();
    }

    public JTextField getCustomerName_TextField() {
        return newInvH_customerName_TextField;
    }

    public JTextField getNewInvH_invoiceDate_TextField() {
        return newInvH_invoiceDate_TextField;
    }

}
