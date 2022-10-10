package painterw;

import java.awt.Color;
import java.io.Serializable;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;


public class PainterPolyLine implements Serializable{
  private ArrayList<PainterPoint> points;
  private static final long serialVersionUID = 131313L;
  private Color color;
  private int width = 1;
  
  
  public PainterPolyLine() {
    points = new ArrayList<>();
  }
  
  
  void addPoint(PainterPoint p){
    points.add(p);
  }
   
  
  int getPointsCount(){
    return points.size();
  }
   
  
  PainterPoint getPoint(int index){
    return (PainterPoint) points.get(index);
  }
  
  
  PainterPoint findPoint(int x, int y){
    PainterPoint point = null;
    for(PainterPoint p: points){
      if( abs(p.getX() - x) < 5 & abs(p.getY() - y) < 5 ){
        point = p;
        break;
      }
    }
    return point;
  }
  
  /**
   *  если insert_point истинно то значит мы просто проверяем принадлежность точки этой полилинии
   *  иначе - добавляем узел (точку) на эту полилинию
   *
   */
  boolean insertOrFindPoint(int x, int y, int w, Color c, boolean insert_point){
    boolean result = false;
    PainterPoint point = null;
    int px1 = points.get(0).getX(); // х начальной точки отрезка
    int py1 = points.get(0).getY(); // y начальной точки отрезка
    int px2, py2; // х и y конечной точки отрезка
    int ab, ac, bc;
    
    for(int i = 1; i < points.size(); i++){
      px2 = points.get(i).getX();
      py2 = points.get(i).getY();
      
      ab = (int) sqrt(pow(px2 - px1, 2.0) + pow(py2 - py1, 2.0));
      ac = (int) sqrt(pow(x - px1, 2.0) + pow(y - py1, 2.0));
      bc = (int) sqrt(pow(px2 - x, 2.0) + pow(py2 - y, 2.0));
      //z = "ab=" + ab + "  ac=" +ac + "  bc=" + bc + "  -  " + (ac+bc);
      if( abs( (ac + bc) - ab ) < 2){
        if(insert_point){
          point = new PainterPoint(x, y, w, c);
          points.add(i , point );
        }
        result = true;
        break;
      }
      
      px1 = px2;
      py1 = py2;
    }
    return result;
  }
  
  
  PainterPolyLine selectLine(int x, int y){
    PainterPolyLine pline = null;
    
    return pline;
  }
  
  
  void setWidth(int w){
    for(PainterPoint p: points){
      p.setWidth(w);
    }
  }
  
  
  void moveLine(int x, int y){
    for(PainterPoint point: points){
      point.setX(point.getX() + x );
      point.setY(point.getY() + y );
    }
  }
  
  
  void setColor(Color c){
    for(PainterPoint p: points){
      p.setColor(c);
    }
  }
  
  
}
