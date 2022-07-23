# SalesInvoiceGenerator
A sales invoice is an accounting document that records a business transaction. It provides the business with a record of the services they’ve provided to a client, when the services were rendered and how much money the client owes the business.

Typically, a sales invoice will include a description of the service provided and the amount owed. Sales invoices are crucial to small-business accounting because they enable you to record transactions of your sales for bookkeeping purposes.

# Project features:

- Sales Invoice Generator (SIG) App shall display a table for a preview of all the available invoices and another table for each detailed invoice whenever selected

- SIG App shall display the invoices table that shows: Invoice No., Invoice Date, Customer Name, and the Total amount of the invoice in the table that shows a preview of every invoice (See Screenshot 1, left-side panel)

- SIG App shall display the detailed invoice in a table that shows: Invoice No., Invoice Date, Customer Name, Invoice Total amount, and all the Invoice Items (See Screenshot 1, right-side panel)

- SIG App shall have a "Create New Invoice" Button and "Delete Invoice" button for creating new invoices and deleting an existing one whenever selected (See Screenshot 1, left-side panel)

- SIG App shall allow the user to edit and save changes on any selected invoice by having a "Save" button to save changes and a "Cancel button" to discard changes (See Screenshot 1, right-side panel)

- SIG App shall abide by the provided GUI (See Screenshots)
The sales invoice shall follow the provided information in the Invoice Header (or Invoice preview) and Invoice table (or Detailed Invoice) that has the details of the invoice (See Screenshot)

- SIG App shall have the ability to save the latest status, i.e. the latest created/changed/deleted invoices, with a "Save File" button (See Screenshot 2)

- SIG App shall have the ability to load the latest saved status, i.e. the latest created/changed/deleted invoices, with a "Load File" button (See Screenshot 2)

- SIG App shall initially have pre-read invoices that display upon initial booting/starting (See the provided CSV files "in resources" for the initial number of invoices along with their format "Invoice Header + Invoice Line")

# Exception Handling
   Handling reading & writing Exceptions
   
    1- Reading exceptions shall display a descriptive message on the following cases:
      Wrong file format
      Wrong date format
      File not found

    2- Writing exceptions shall display a descriptive message on the following cases:
      Wrong file format
      File not found
      Folder/File path is not found
