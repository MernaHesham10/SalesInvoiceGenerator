package salesinvoicegenerator.view;

import java.awt.GridLayout;
import javax.swing.*;

public class InvoiceLineNewWindow extends JDialog{
    private JTextField newInvL_itemName_TextField;
    private JTextField newInvL_itemCount_TextField;
    private JTextField newInvL_itemPrice_TextField;
    private JLabel newInvL_itemName_Label;
    private JLabel newInvL_itemCount_Label;
    private JLabel newInvL_itemPrice_Label;
    private JButton newInvL_ok_Button;
    private JButton newInvL_cancel_Button;
    
    public InvoiceLineNewWindow(MainFrame frame) {
        newInvL_itemName_TextField = new JTextField(18);
        newInvL_itemName_Label = new JLabel("Item Name");
        
        newInvL_itemCount_TextField = new JTextField(18);
        newInvL_itemCount_Label = new JLabel("Item Count");
        
        newInvL_itemPrice_TextField = new JTextField(18);
        newInvL_itemPrice_Label = new JLabel("Item Price");
        
        newInvL_ok_Button = new JButton("OK");
        newInvL_cancel_Button = new JButton("Cancel");
        
        newInvL_ok_Button.setActionCommand("createLineOK");
        newInvL_cancel_Button.setActionCommand("createLineCancel");
        
        newInvL_ok_Button.addActionListener(frame.getListener());
        newInvL_cancel_Button.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));
        
        add(newInvL_itemName_Label);
        add(newInvL_itemName_TextField);
        add(newInvL_itemCount_Label);
        add(newInvL_itemCount_TextField);
        add(newInvL_itemPrice_Label);
        add(newInvL_itemPrice_TextField);
        add(newInvL_ok_Button);
        add(newInvL_cancel_Button);
  
        pack();
    }

    public JTextField getNewInvL_itemName_TextField() {
        return newInvL_itemName_TextField;
    }

    public JTextField getNewInvL_itemCount_TextField() {
        return newInvL_itemCount_TextField;
    }

    public JTextField getNewInvL_itemPrice_TextField() {
        return newInvL_itemPrice_TextField;
    }
}