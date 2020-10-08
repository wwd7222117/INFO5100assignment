package Assignment4;

class Circle {
	private double radius;
	private String color;
	public Circle(){
		radius = 1.0;
		color = "red";
	}
	
	public Circle(double radius){
		this.radius = radius;
		color = "red";
	}
	
	public Circle(double radius,String color){
		this.radius = radius;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
}

class Cylinder extends Circle{
	private double height;
	public Cylinder(){
		super();
		height = 1.0;
	}
	
	public Cylinder(double height){
		super();
		this.height = height;
	}
	
	public Cylinder(double height, double radius){
		super(radius);
		this.height = height;
	}
	
	public Cylinder(double height, double radius, String color){
		super(radius,color);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getVolume() {
		return height*super.getArea();
	}
	
	@Override
	//we have overridden the getArea memthod, so the subclass can not get base area correctly if we use getArea() again. 
	//In the assignment the methods and attributes have been set, nor a new method and a attribute can be added into Class.
	//To solve the problem, using getVolume()/getHeight() can help users get the base area.
	public double getArea() {
		return 2.0*Math.PI*this.getRadius()*(this.getRadius()+height);
	}
}

public class TestCylinder {
	public static void main(String[] args) {
		Circle one = new Circle();
		one.setRadius(2.0);
		one.setColor("yellow");
		System.out.println("Radius is "+one.getRadius()+", Color is "+one.getColor()+", Base area is "+one.getArea());
	
		Cylinder two = new Cylinder();
		System.out.println("Radius is "+two.getRadius()+", Height is "+two.getHeight()+", Color is "+two.getColor()+", Base area is "+two.getVolume()/two.getHeight()+", Volume is "+two.getVolume());
		
		Cylinder three = new Cylinder(5.0,2.0);
		System.out.println("Radius is "+three.getRadius()+", Height is "+three.getHeight()+", Color is "+three.getColor()+", Base area is "+three.getVolume()/three.getHeight()+", Volume is "+three.getVolume());	
	
	}

}