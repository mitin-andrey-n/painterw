package painterw;

import java.awt.Color;
import java.io.Serializable;

public class PainterPoint implements Serializable{
  private int x, y;
  private static final long serialVersionUID = 121212L;
  private Color color;
  private int width;
  
  
  PainterPoint(int x, int y, int w, Color c){
    this.x = x;
    this.y = y;
    width = w;
    color = c;
  }
  
  
  int getWidth(){
    return width;
  }
  
  
  void setWidth(int w){
    width = w;
  }
  
  
  Color getColor(){
    return color;
  }
  
  
  void setColor(Color c){
    color = c;
  }
  
  
  int getX(){
    return x;
  }
  
  
  int getY(){
    return y;
  }
  
  
  void setX(int x){
    this.x = x;
  }
  
  
  void setY(int y){
    this.y = y;
  }
  
  
}
