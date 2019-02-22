package jmri.jmrit.ctc.editor.gui;

import jmri.jmrit.ctc.editor.code.AwtWindowProperties;
import jmri.jmrit.ctc.editor.code.CommonSubs;
import jmri.jmrit.ctc.editor.code.ProgramProperties;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jmri.jmrit.ctc.ctcserialdata.OtherData;
import jmri.jmrit.ctc.ctcserialdata.ProjectsCommonSubs;

/**
 *
 * @author Gregory J. Bedlek Copyright (C) 2018, 2019
 */
public class DlgFleeting extends javax.swing.JDialog {

    /**
     * Creates new form dlgProperties
     */
    private static final String FORM_PROPERTIES = "DlgFleeting";    // NOI18N  
    private final AwtWindowProperties _mAwtWindowProperties;
    private final OtherData _mOtherData;
    private boolean _mClosedNormally = false;
    public boolean closedNormally() { return _mClosedNormally; }
    
    private String _mFleetingToggleInternalSensorOrig;
    private boolean _mDefaultFleetingEnabledOrig;
    
    private void initOrig(OtherData otherData) {
        _mFleetingToggleInternalSensorOrig = otherData._mFleetingToggleInternalSensor;
        _mDefaultFleetingEnabledOrig = otherData._mDefaultFleetingEnabled;
    }
    private boolean dataChanged() {
        if (!_mFleetingToggleInternalSensorOrig.equals(_mFleetingToggleInternalSensor.getText())) return true;
        if (_mDefaultFleetingEnabledOrig != _mDefaultFleetingEnabled.isSelected()) return true;
        return false;
    }
    
    public DlgFleeting(java.awt.Frame parent, boolean modal, AwtWindowProperties awtWindowProperties, OtherData otherData) {
        super(parent, modal);
        initComponents();
        _mAwtWindowProperties = awtWindowProperties;
        _mOtherData = otherData;
        _mFleetingToggleInternalSensor.setText(otherData._mFleetingToggleInternalSensor);
        _mDefaultFleetingEnabled.setSelected(otherData._mDefaultFleetingEnabled);
        initOrig(otherData);
        _mAwtWindowProperties.setWindowState(this, FORM_PROPERTIES);        
        this.getRootPane().setDefaultButton(_mSaveAndClose);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  // NOI18N
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _mSaveAndClose = new javax.swing.JButton();
        _mFleetingToggleInternalSensor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        _mDefaultFleetingEnabled = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Bundle.getMessage("TitleDlgFleet"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        _mSaveAndClose.setText(Bundle.getMessage("ButtonSaveClose"));
        _mSaveAndClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mSaveAndCloseActionPerformed(evt);
            }
        });

        jLabel21.setText(Bundle.getMessage("LabelDlgFleetSensor"));

        jLabel26.setText(Bundle.getMessage("InfoDlgFleet"));

        _mDefaultFleetingEnabled.setText(" ");

        jLabel29.setText(Bundle.getMessage("LabelDlgFleetEnabled"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_mDefaultFleetingEnabled)
                    .addComponent(_mFleetingToggleInternalSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_mSaveAndClose)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mFleetingToggleInternalSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mDefaultFleetingEnabled)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addComponent(_mSaveAndClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        _mAwtWindowProperties.saveWindowState(this, FORM_PROPERTIES);
        if (CommonSubs.allowClose(this, dataChanged())) dispose();
    }//GEN-LAST:event_formWindowClosing

    private void _mSaveAndCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mSaveAndCloseActionPerformed
        _mOtherData._mFleetingToggleInternalSensor = _mFleetingToggleInternalSensor.getText();
        _mOtherData._mDefaultFleetingEnabled = _mDefaultFleetingEnabled.isSelected();
        _mClosedNormally = true;
        _mAwtWindowProperties.saveWindowState(this, FORM_PROPERTIES);
        dispose();
    }//GEN-LAST:event__mSaveAndCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox _mDefaultFleetingEnabled;
    private javax.swing.JTextField _mFleetingToggleInternalSensor;
    private javax.swing.JButton _mSaveAndClose;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    // End of variables declaration//GEN-END:variables
}
