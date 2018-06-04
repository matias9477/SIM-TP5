/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BackEnd.Gestor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matia
 */
public class Ventana extends javax.swing.JFrame {
    Gestor g;

    /**
     * Creates new form Ventana
     */
    public Ventana(Gestor g) {
        initComponents();
        this.setVisible(true);
        this.g=g;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtIteraciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad de Iteraciones");

        jButton1.setText("Simular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "reloj", "Evento", "RND llegada cliente", "Tentrellegada", "Prox llegada", "RND compra", "Compra realiz", "RND t atenc", "t atencion", "Fin aten", "RND t prep", "t prep", "Fin prep", "EstadoDueñ", "Cola", "estado ayudante", "t ocioso A", "t cocina D", "t mostrador D"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtIteraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIteracionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
       model.setRowCount(0);
        for (int i = 0; i < Integer.parseInt(this.txtIteraciones.getText()); i++) {
            this.g.newVectorActual();
        this.addRowToJTable();
        }
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIteracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIteracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIteracionesActionPerformed

    /**
     * @param args the command line arguments
     */


        public void addRowToJTable()
    {
        
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        ArrayList list =this.g.crearArrayList();
        Object rowData[] = new Object[28];

            
            rowData[0]=list.get(0);
            rowData[1]=list.get(1);
            rowData[2]=list.get(2);
            rowData[3]=list.get(3);
            rowData[4]=list.get(4);
            rowData[5]=list.get(5);
            rowData[6]=list.get(6);
            rowData[7]=list.get(7);
            rowData[8]=list.get(8);
            rowData[9]=list.get(9);
            rowData[10]=list.get(10);
            rowData[11]=list.get(11);
            rowData[12]=list.get(12);
            rowData[13]=list.get(13);
            rowData[14]=list.get(14);
            rowData[15]=list.get(15);
            rowData[16]=list.get(16);
            rowData[17]=list.get(17);
            rowData[18]=list.get(18);
            

            
            model.addRow(rowData);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIteraciones;
    // End of variables declaration//GEN-END:variables
}
