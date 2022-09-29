package painterw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class PainterW extends javax.swing.JFrame {
  private PainterCanvas pcanvas;
  private PainterPolyLine pline = null;
  private PainterLinesStore linestore;
  private PainterPoint selected_point = null;
  private PainterPolyLine selected_line = null;
  private int begin_x, begin_y;
  private Color selected_color;
  
  
  public PainterW() {
    initComponents();
    setTitle("PainterW");
    selected_color = new Color(0, 0, 0);
    linestore = new PainterLinesStore();
    panMain.setLayout(new BorderLayout());
    pcanvas = new PainterCanvas(linestore);
    pcanvas.setBackground(new Color(255, 255, 255));
    panMain.add(pcanvas, BorderLayout.CENTER);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panTools = new javax.swing.JPanel();
    tbtDrawLine = new javax.swing.JToggleButton();
    btnClear = new javax.swing.JButton();
    tbtMoveLine = new javax.swing.JToggleButton();
    cmbWidth = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    btnColor = new javax.swing.JButton();
    txfColor = new javax.swing.JTextField();
    tbtDeleteLine = new javax.swing.JToggleButton();
    tbtSelectLine = new javax.swing.JToggleButton();
    panMain = new javax.swing.JPanel();
    txfMode = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    txfStatus = new javax.swing.JTextField();
    mnuMainBar = new javax.swing.JMenuBar();
    mniFileSave = new javax.swing.JMenu();
    MenuFileSave = new javax.swing.JMenuItem();
    mniFileLoad = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    mniFileExit = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    tbtDrawLine.setText("<html><center><font size=\"-1\">Нарисовать<br>линию</font></html>");
    tbtDrawLine.setToolTipText("после фиксации этой копки, клик на холсте левой кнопкой мыши отмечает место узла линии, правая кнопка мыши указывает пследний узел");
    tbtDrawLine.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tbtDrawLineActionPerformed(evt);
      }
    });

    btnClear.setText("<html><center><font size=\"-1\">Очистить<br>холст</font></html>");
    btnClear.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnClearActionPerformed(evt);
      }
    });

    tbtMoveLine.setText("<html><center><font size=\"-1\">Перенести<br>линию</font></html>");

    cmbWidth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
    cmbWidth.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbWidthActionPerformed(evt);
      }
    });

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("<html><center><font size=\"-1\">  Толщина линии</font></html>");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("<html><center><font size=\"-1\">Цвет линии</font></html>");

    btnColor.setText(". . .");
    btnColor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnColorActionPerformed(evt);
      }
    });

    txfColor.setEditable(false);
    txfColor.setBackground(new java.awt.Color(0, 0, 0));
    txfColor.setFocusable(false);

    tbtDeleteLine.setText("<html><center><font size=\"-1\">Удалить<br>линию</font></html>");

    tbtSelectLine.setText("<html><center><font size=\"-1\">Выбрать<br>линию</font></html>");

    javax.swing.GroupLayout panToolsLayout = new javax.swing.GroupLayout(panTools);
    panTools.setLayout(panToolsLayout);
    panToolsLayout.setHorizontalGroup(
      panToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panToolsLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(cmbWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(12, 12, 12))
      .addGroup(panToolsLayout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(panToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(panToolsLayout.createSequentialGroup()
            .addGroup(panToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tbtDrawLine, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tbtSelectLine, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tbtMoveLine, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tbtDeleteLine, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(panToolsLayout.createSequentialGroup()
            .addComponent(txfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12))
          .addGroup(panToolsLayout.createSequentialGroup()
            .addComponent(jLabel3)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(panToolsLayout.createSequentialGroup()
            .addComponent(jLabel2)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    panToolsLayout.setVerticalGroup(
      panToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panToolsLayout.createSequentialGroup()
        .addComponent(tbtDrawLine, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cmbWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(panToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnColor)
          .addComponent(txfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(tbtSelectLine, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(tbtMoveLine, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(tbtDeleteLine, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(36, 36, 36))
    );

    panMain.setBackground(new java.awt.Color(254, 254, 254));
    panMain.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        panMainMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        panMainMouseReleased(evt);
      }
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        panMainMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
    panMain.setLayout(panMainLayout);
    panMainLayout.setHorizontalGroup(
      panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    panMainLayout.setVerticalGroup(
      panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    txfMode.setEditable(false);
    txfMode.setBackground(new java.awt.Color(220, 220, 220));
    txfMode.setFocusable(false);

    jLabel1.setText("Режим");

    txfStatus.setEditable(false);
    txfStatus.setBackground(new java.awt.Color(220, 220, 220));
    txfStatus.setFocusable(false);

    mniFileSave.setText("Файл");

    MenuFileSave.setText("Сохранить в файл");
    MenuFileSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MenuFileSaveActionPerformed(evt);
      }
    });
    mniFileSave.add(MenuFileSave);

    mniFileLoad.setText("Загрузить из файла");
    mniFileLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mniFileLoadActionPerformed(evt);
      }
    });
    mniFileSave.add(mniFileLoad);
    mniFileSave.add(jSeparator1);

    mniFileExit.setText("Выход");
    mniFileExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        mniFileExitActionPerformed(evt);
      }
    });
    mniFileSave.add(mniFileExit);

    mnuMainBar.add(mniFileSave);

    setJMenuBar(mnuMainBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(panTools, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txfMode, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txfStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(panTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txfMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1)
              .addComponent(txfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  
  
  private void mniFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFileExitActionPerformed
    System.exit(0);
  }//GEN-LAST:event_mniFileExitActionPerformed

  
  private void panMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseClicked
    if(evt.getClickCount() >1){
      linestore.insertPoint(evt.getX(), evt.getY(), cmbWidth.getSelectedIndex() + 1, null);
      pcanvas.setFirstRun(false);
      pcanvas.repaint();
      return;
    }
    
    if( ! tbtDrawLine.isSelected()){
      //findPoint(evt);
      return;
    }
    
    int bt=evt.getButton();
    if(pline == null) pline = new PainterPolyLine();
    
    if(bt == 1){
      pline.addPoint(new PainterPoint(evt.getX(), evt.getY(), cmbWidth.getSelectedIndex() + 1, selected_color ));
    }
    
    if(bt == 3){
      pline.addPoint(new PainterPoint(evt.getX(), evt.getY(), cmbWidth.getSelectedIndex() +1, selected_color));
      linestore.addLine(pline);
      pcanvas.setFirstRun(false);
      pcanvas.repaint();
      pline = null;
      tbtDrawLine.setSelected(false);
      txfMode.setText("");
    }
    
  }//GEN-LAST:event_panMainMouseClicked

  
  PainterPoint findPoint(java.awt.event.MouseEvent evt){
    PainterPoint point = null;
    point = linestore.findPoint(evt.getX(), evt.getY());
//    if( point != null){
//      txfStatus.setText("Найдена точка");
//    }else{
//      txfStatus.setText("мимо");
//    }
    return point;
  }
  
  
  void insertPoint(java.awt.event.MouseEvent evt){
    //linestore.isPointOnLine( evt.getX(), evt.getY());
  }
  
  
  private void MenuFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileSaveActionPerformed
    JFileChooser fch=new JFileChooser();
    fch.setDialogTitle("Сохранения рисунка в файл");
    int result = fch.showSaveDialog(null);
    if(result == 0){
      try{
        FileOutputStream outputStream = new FileOutputStream(fch.getSelectedFile());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(linestore.getLines());
      }catch(IOException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    }
    
  }//GEN-LAST:event_MenuFileSaveActionPerformed

  
  private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    pcanvas.clearCanvas();
    pcanvas.repaint();
  }//GEN-LAST:event_btnClearActionPerformed

  
  private void mniFileLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFileLoadActionPerformed
    JFileChooser fch=new JFileChooser();
    fch.setDialogTitle("Загрузка рисунка из файл");
    int result = fch.showOpenDialog(null);
    if(result == 0){
      try{
        FileInputStream fis = new FileInputStream(fch.getSelectedFile());
        ObjectInputStream ois = new ObjectInputStream(fis);
        linestore.setLines( (ArrayList) ois.readObject());
        pcanvas.setFirstRun(false);
        pcanvas.repaint();
      }catch(IOException | ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    }
    
  }//GEN-LAST:event_mniFileLoadActionPerformed

  
  private void tbtDrawLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtDrawLineActionPerformed
    if(tbtDrawLine.isSelected()){
      txfMode.setText("Рисование (правая кнопка мыши - завершить)");
      txfStatus.setText("");
    }
  }//GEN-LAST:event_tbtDrawLineActionPerformed

  
  private void panMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMousePressed
    if( tbtDrawLine.isSelected() ) return;
    selected_point = findPoint(evt);
    selected_line = linestore.findLine(evt.getX(), evt.getY());
    begin_x = evt.getX();
    begin_y = evt.getY();
    if( tbtMoveLine.isSelected() )txfMode.setText("Перемещение");
    if(selected_line != null & tbtSelectLine.isSelected()) txfStatus.setText("Выбрана линия");
  }//GEN-LAST:event_panMainMousePressed

  
  private void panMainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseReleased
    if(selected_point != null){
      selected_point.setX(evt.getX());
      selected_point.setY(evt.getY());
      selected_point = null;
    }
    
    // удаление линии
    if(selected_line != null & tbtDeleteLine.isSelected()){
      UIManager.put("OptionPane.yesButtonText", "Да");
      UIManager.put("OptionPane.noButtonText", "Не в коем случае !");
      int response = JOptionPane.showConfirmDialog(null, "Удалить линию ?", "Внимание !", JOptionPane.YES_NO_OPTION);
      if(response == 0) linestore.deleteLine(selected_line);
      tbtDeleteLine.setSelected(false);
    }
    
    // перемещение линии
    if(selected_line != null & tbtMoveLine.isSelected()){
      //txfStatus.setText("Линия");
      selected_line.moveLine(evt.getX() - begin_x, evt.getY() - begin_y);
      pcanvas.setFirstRun(false);
      pcanvas.repaint();
      tbtMoveLine.setSelected(false);
    }
    
    pcanvas.repaint();
    //txfStatus.setText("");
    if( ! tbtDrawLine.isSelected() )txfMode.setText("");
  }//GEN-LAST:event_panMainMouseReleased

  
  private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
    Color c = txfColor.getBackground();
    selected_color = JColorChooser.showDialog(this, "Выберите цвет линии", Color.yellow);
    if(selected_color != null) {
      txfColor.setBackground(selected_color);
    }else{
      txfColor.setBackground(c);
    }
    //if(selected_color == null) txfColor.setBackground(c);
    if(selected_line != null & tbtSelectLine.isSelected()) {
      if(selected_color != null){
        selected_line.setColor(selected_color);
      }else{
        selected_line.setColor(c);
      }
      pcanvas.repaint();
      tbtSelectLine.setSelected(false);
      txfStatus.setText("");
    }
  }//GEN-LAST:event_btnColorActionPerformed

  
  private void cmbWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWidthActionPerformed
    if(selected_line != null & tbtSelectLine.isSelected()){
      selected_line.setWidth(cmbWidth.getSelectedIndex() + 1);
      pcanvas.setFirstRun(false);
      pcanvas.repaint();
      tbtSelectLine.setSelected(false);
    }
  }//GEN-LAST:event_cmbWidthActionPerformed

  
  
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
            java.util.logging.Logger.getLogger(PainterW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainterW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainterW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainterW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainterW().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem MenuFileSave;
  private javax.swing.JButton btnClear;
  private javax.swing.JButton btnColor;
  private javax.swing.JComboBox<String> cmbWidth;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JMenuItem mniFileExit;
  private javax.swing.JMenuItem mniFileLoad;
  private javax.swing.JMenu mniFileSave;
  private javax.swing.JMenuBar mnuMainBar;
  private javax.swing.JPanel panMain;
  private javax.swing.JPanel panTools;
  private javax.swing.JToggleButton tbtDeleteLine;
  private javax.swing.JToggleButton tbtDrawLine;
  private javax.swing.JToggleButton tbtMoveLine;
  private javax.swing.JToggleButton tbtSelectLine;
  private javax.swing.JTextField txfColor;
  private javax.swing.JTextField txfMode;
  private javax.swing.JTextField txfStatus;
  // End of variables declaration//GEN-END:variables

}