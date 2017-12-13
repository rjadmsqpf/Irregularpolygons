
/**
 * Write a description of class asd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon
{
    private ArrayList<Point2D.Double> myPolygon;
    private SketchPad myPaper;
    private DrawingTool myPencil;
    // constructors
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
        myPaper = new SketchPad(500,500);
        myPencil = new DrawingTool(myPaper);
    }

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public String getName() {
        return "Andy Jung";    
    }

    public void draw()
    {
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {
            if(i<myPolygon.size()-1) {
                x1 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(i+1).getX();
                y2 = myPolygon.get(i+1).getY();
            }
            else {
                x1= myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(0).getX();
                y2 = myPolygon.get(0).getY();
            }
            myPencil.up();
            myPencil.move(x1,y1);
            myPencil.down();
            myPencil.move(x2,y2);
        }
    }

    public double perimeter()
    {
        double perimeter = 0;
        double x1 = 0;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;
        double distance = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {
            if(i<myPolygon.size()-1) {
                x1 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(i+1).getX();
                y2 = myPolygon.get(i+1).getY();
            }
            else {
                x1= myPolygon.get(i).getX();
                y1 = myPolygon.get(i).getY();
                x2 = myPolygon.get(0).getX();
                y2 = myPolygon.get(0).getY();
            }
            distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
            perimeter += distance;
        }
        return perimeter;
    }

    public double area()
    {
        double x = 0;
        double y = 0;
        double x0 = 0;
        double y1 = 0;
        double y0 = 0;
        double x1 = 0;
        for(int i=0; i<myPolygon.size(); i++)
        {            
            if(i<myPolygon.size()-1) {
                x0 = myPolygon.get(i).getX();
                y1 = myPolygon.get(i+1).getY();
                y0 = myPolygon.get(i).getY();
                x1 = myPolygon.get(i+1).getX();
                x += x0*y1;
                y += y0*x1;            
            }
            else {
                x0= myPolygon.get(i).getX();
                y0 = myPolygon.get(i).getY();
                x1 = myPolygon.get(0).getX();
                y1 = myPolygon.get(0).getY();
                x += x0*y1;
                y += y0*x1; 
            }
        }
        return Math.abs((x-y)/2);
    }

    public static void main()
    {
        IrregularPolygon polygon = new IrregularPolygon();
        Point2D.Double pt1 = new Point2D.Double((double)20,(double)10);
        Point2D.Double pt2 = new Point2D.Double((double)70,(double)20);
        Point2D.Double pt3 = new Point2D.Double((double)50,(double)50);
        Point2D.Double pt4 = new Point2D.Double((double)0,(double)40);
        polygon.add(pt1);
        polygon.add(pt2);
        polygon.add(pt3);
        polygon.add(pt4);

        polygon.draw();
        System.out.println("Perimeter: "+polygon.perimeter());
        System.out.println("Area: "+polygon.area());
    }
}


