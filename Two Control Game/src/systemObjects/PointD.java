package systemObjects;

import java.awt.Point;
import java.awt.geom.Point2D;

public class PointD extends Point2D {
	public PointD(){
		x = 0;
		y = 0;
	}
	public PointD(double i, double j) {
		x = i;
		y = j;
	}
	public PointD(Point p){
		x = p.getX();
		y = p.getY();
	}
	public PointD tran(PointD point){
		this.x += point.x;
		this.y += point.y;
		return this;
	}
	
	public double x;
	public double y;
	@Override
	public double getX() {
		return x;
	}
	@Override
	public double getY() {
		return y;
	}
	@Override
	public void setLocation(double arg0, double arg1) {
		x = arg0;
		y = arg1;
	}
	public Integer getXI(){
		return (int) this.getX();
	}
	public Integer getYI(){
		return (int) this.getY();
	}
	public Point toPoint(){
		Point p = new Point();
		p.x = (int) this.x;
		p.y = (int) this.y;
		return p;
	}
	public Point2D D2Point(){
		return new Point2D.Double(x,y);
	}
}