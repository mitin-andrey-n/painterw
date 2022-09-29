package painterw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class PainterCanvas extends JPanel{
  private PainterPolyLine pline;
  private boolean firstrun = true;
  private PainterLinesStore linestore;
  private boolean clear = false;
  private BasicStroke stroke;
    
  
  public PainterCanvas(PainterLinesStore store) {
    linestore = store;
  }

  
  void setFirstRun(boolean fr){
    firstrun = fr;
  }
  
  
  void clearCanvas(){
    clear = true;
  }
  
  
  private void canvasDraw(Graphics2D g2d){
    
    if(clear){
      g2d.setBackground(new Color(255, 255, 255));
      g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
      clear = false;
      linestore.clear();
      return;
    }

    for(PainterPolyLine pline: linestore.getLines()){
      PainterPoint pp = pline.getPoint(0);
      stroke = new BasicStroke(pp.getWidth());
      g2d.setStroke(stroke);
      g2d.setColor(pp.getColor());
      int x = pp.getX();
      int y = pp.getY();
      
      g2d.drawOval(x-2, y-2, 5, 5);
      g2d.fillOval(x-2, y-2, 5, 5);
      for(int i=1; i < pline.getPointsCount(); i++){
        pp = pline.getPoint(i);
        stroke = new BasicStroke(pp.getWidth());
        g2d.setStroke(stroke);
        g2d.setColor(pp.getColor());
        g2d.drawOval(pp.getX()-2, pp.getY()-2, 5, 5);
        g2d.fillOval(pp.getX()-2, pp.getY()-2, 5, 5);
        g2d.drawLine(x, y, pp.getX(), pp.getY());
        x = pp.getX();
        y = pp.getY();
      }
    }
    
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    if ( ! firstrun ) canvasDraw(g2d);
  }
  
  
}
