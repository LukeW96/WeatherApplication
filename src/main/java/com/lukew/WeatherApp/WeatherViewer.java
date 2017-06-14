package com.lukew.WeatherApp;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;


/*
Program Title: WeatherViewer
Author:  Luke Williams
Created: 10-Mar-2016
Version: 1.0
*/

public class WeatherViewer extends javax.swing.JFrame {

    private WeatherReader wr;
    private LinkedList dates;
    private ListIterator list;
    /**
     * Creates new form WeatherViewer
     */
    public WeatherViewer() 
    {

        wr = new WeatherReader();
        initComponents();
        

       
        forecast_tree_today.setRootVisible(false);
        forecast_tree_tomorrow.setRootVisible(false);
        forecast_tree_overmorrow.setRootVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        url_textfield = new javax.swing.JTextField();
        url_label = new javax.swing.JLabel();
        forecast_button = new javax.swing.JButton();
        image_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        forecast_tree_today = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        forecast_tree_tomorrow = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        forecast_tree_overmorrow = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 255));
        setForeground(new java.awt.Color(153, 51, 255));

        url_textfield.setName("url_textfield"); // NOI18N

        url_label.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        url_label.setText("Location :");

        forecast_button.setText("Forecast");
        forecast_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forecast_buttonActionPerformed(evt);
            }
        });

        image_label.setPreferredSize(new java.awt.Dimension(48, 48));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        forecast_tree_today.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(forecast_tree_today);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        forecast_tree_tomorrow.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(forecast_tree_tomorrow);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        forecast_tree_overmorrow.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(forecast_tree_overmorrow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(url_label)
                                .addGap(2, 2, 2)
                                .addComponent(url_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(forecast_button, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(url_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(url_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forecast_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*    
    http://www.flaticon.com/
    http://www.flaticon.com/authors/google
    
    */
    
    /**
     * on click it gets text from textbox, and calls methods that 
     * check the location inputted, and returns results based on input
     * @param evt - checks event occurring (on click for the button)
     */
    private void forecast_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forecast_buttonActionPerformed
              
        wr.setLocation(url_textfield.getText());
        JTree temptree = new JTree();
        
        
        for (int i = 1; i < 4; i++) {
        if(i == 1)
        {
            temptree = forecast_tree_today;
        }
        
        else if(i == 2)
        {
            temptree = forecast_tree_tomorrow;
        }
        
        else
            temptree = forecast_tree_overmorrow;
        
        wr.setForecastDetails(i);        
        image_label.setIcon(wr.getWeatherImage());

  
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(url_textfield.getText());
        temptree.setRootVisible(true);
        forecast_tree_today.setRootVisible(true);    
        
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        String imageURI = "src/main/resources/images/list icons/";
        renderer.setOpenIcon(new ImageIcon(imageURI + "city.png"));
        renderer.setClosedIcon(new ImageIcon(imageURI + "city.png"));
        renderer.setLeafIcon(new ImageIcon(imageURI + "point.png"));
        temptree.setCellRenderer(renderer);
        
        for(String n : wr.getWeatherDescription())
        {
            root.add(new DefaultMutableTreeNode(n));
        }                
        
        DefaultTreeModel model = new DefaultTreeModel(root);        
        temptree.setModel(model);
        }
        
    }//GEN-LAST:event_forecast_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(WeatherViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater
            (new Runnable() 
                {
                    public void run() 
                    {
                        WeatherViewer wv = new WeatherViewer();
                        wv.setVisible(true);
                        wv.setTitle("Weather Viewer");
                        wv.setLocationRelativeTo(null);
                        
                    }
                }
            );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forecast_button;
    private javax.swing.JTree forecast_tree_overmorrow;
    private javax.swing.JTree forecast_tree_today;
    private javax.swing.JTree forecast_tree_tomorrow;
    private javax.swing.JLabel image_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel url_label;
    private javax.swing.JTextField url_textfield;
    // End of variables declaration//GEN-END:variables
}