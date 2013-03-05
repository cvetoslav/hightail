package org.hightail.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.hightail.Testcase;

public class TestcaseJDialog extends javax.swing.JDialog {

    protected Testcase testcase;
    protected boolean isNew; // only used for some UI formatting
    protected boolean hasTextChanged = false;
    protected boolean returnValue = false; // false = no changes made, or user canceled

    public boolean getReturnValue() {
        return returnValue;
    }

    public TestcaseJDialog(JFrame parent, Testcase testcase, boolean isNew) {
        super(parent,true); // makes it modal
        this.isNew = isNew;
        this.testcase = testcase;

        initComponents();

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }
            private void update() {
                hasTextChanged = true;
                saveButton.setEnabled(true);
            }
        };

        inputTextarea.setText(testcase.getInput());
        expectedOutputTextarea.setText(testcase.getExpectedOutput());
        if (!isNew) {
            programOutputTextarea.setText(testcase.getProgramOutput()); // this is read-only
        } else {
            programOutputTextarea.setEnabled(false);
            programOutputTextarea.setBackground(new java.awt.Color(220,220,220));
            // TODO: find a better way to show that this textarea is disabled (or remove it altogether)
        }
        executionResultLabel.setText(testcase.getExecutionResult().getFormattedResult()); // this is read-only
        executionResultLabel.setForeground(testcase.getExecutionResult().getColor());
        executionTimeLabel.setText(testcase.getExecutionResult().getFormattedTime()); // this is read-only

        inputTextarea.getDocument().addDocumentListener(documentListener);
        expectedOutputTextarea.getDocument().addDocumentListener(documentListener);
    }

    private void confirmAndClose () {
        boolean doClose = !hasTextChanged; // if there was no change, we will just close

        if (!doClose) {
            // If there are unsaved changes, display confirm dialog
            int confirmed = JOptionPane.showConfirmDialog(this,
                    "There are unsaved changes. Are you sure?",
                    "Confirm cancel",
                    JOptionPane.YES_NO_OPTION);
            doClose = (confirmed == JOptionPane.YES_OPTION);
        }

        if (doClose) {
            // returnValue will be = false
            this.dispose();
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        executionResultLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        executionTimeLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputTextarea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        expectedOutputTextarea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        programOutputTextarea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Test case");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Execution result:");

        executionResultLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        executionResultLabel.setText("jLabel2");

        jLabel3.setText("Execution time:");

        executionTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        executionTimeLabel.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Input:");

        inputTextarea.setColumns(20);
        inputTextarea.setFont(new java.awt.Font("Courier New", 0, 12));
        inputTextarea.setRows(5);
        jScrollPane2.setViewportView(inputTextarea);

        expectedOutputTextarea.setColumns(20);
        expectedOutputTextarea.setFont(new java.awt.Font("Courier New", 0, 12));
        expectedOutputTextarea.setRows(5);
        jScrollPane1.setViewportView(expectedOutputTextarea);

        programOutputTextarea.setColumns(20);
        programOutputTextarea.setEditable(false);
        programOutputTextarea.setFont(new java.awt.Font("Courier New", 0, 12));
        programOutputTextarea.setRows(5);
        jScrollPane3.setViewportView(programOutputTextarea);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Expected output:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Program output:");

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(executionResultLabel)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(executionTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(executionResultLabel)
                        .addComponent(jLabel3)
                        .addComponent(executionTimeLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmAndClose();
    }//GEN-LAST:event_formWindowClosing

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        confirmAndClose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        testcase.setInput(inputTextarea.getText());
        testcase.setExpectedOutput(expectedOutputTextarea.getText());
        testcase.save();
        this.returnValue = true;
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel executionResultLabel;
    private javax.swing.JLabel executionTimeLabel;
    private javax.swing.JTextArea expectedOutputTextarea;
    private javax.swing.JTextArea inputTextarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea programOutputTextarea;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

}
