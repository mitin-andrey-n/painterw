package painterw;

import java.awt.Color;
import java.util.ArrayList;


public class PainterLinesStore {
  private ArrayList<PainterPolyLine> lines;
  
  
  
  public PainterLinesStore() {
    lines = new ArrayList<>();
  }

  
  void addLine(PainterPolyLine line){
    lines.add(line);
  }
  
  
  ArrayList<PainterPolyLine> getLines(){
    return lines;
  }
  
  
  void setLines(ArrayList lines){
    this.lines = lines;
  }
  
  
  void deleteLine(PainterPolyLine p){
    lines.remove(p);
  }
  
  
  void clear(){
    lines.clear();
  }
  
  
  PainterPoint findPoint(int x, int y){
    PainterPoint point = null;
    
    for(PainterPolyLine pline: lines){
      point = pline.findPoint(x, y);
      if( point != null) break;
    }
    
    return point;
    
  }
  
  
  PainterPolyLine findLine(int x, int y){
    PainterPolyLine line = null;
    for(PainterPolyLine pline: lines){
      if( pline.insertOrFindPoint(x, y, 0, null, false) ){
        line = pline;
        break;
      }
    }
    return line;
  }
  
  
  void insertPoint(int x, int y, int w, Color c){
    for(PainterPolyLine pline: lines){ 
      if( pline.insertOrFindPoint(x, y, w, c, true) )  break;
    }
  }

  
}
