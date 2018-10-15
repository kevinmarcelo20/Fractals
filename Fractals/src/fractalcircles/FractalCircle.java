package fractalcircles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
/**
 * A program about fractals the art of fractals in JavaFX.
 * 
 * @author kevin
 *
 */

public class FractalCircle extends Application{

	private static Pane root = new Pane();
	private static Canvas canvas;
	private static GraphicsContext g;
	private static Ellipse ellipse;
	private static Line line;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		canvas = new Canvas(640,360);
		g = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root,Color.WHITE);
		stage.setScene(scene);
		
		drawFourFractalCircle(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/2,canvas.getWidth()/2);
//		drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2, canvas.getHeight()/2);
//		cantorFractal(10,50,canvas.getWidth()-20);
		
		stage.show();
	}
	
	/**
	 * Method creates a cantor set, a famous fractal, in a canvas.
	 * 
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param len - length of the line
	 */
	static void cantorFractal(double  x, double y, double len) {
		line = new Line( x, y, x + len, y);
		line.setFill(null);
		line.setStroke(Color.WHITE);
		line.setStrokeWidth(1);
		root.getChildren().add(line);
		y += 20;
		
		
		if(len>=1) {
		cantorFractal( x,y,len/3);
		cantorFractal( x+len*2/3,y,len/3);
		}
	}

	/**
	 * Creates a fractal circle image in the canvas.
	 * 
	 * @param x - x coordinate in canvas
	 * @param y - y coordinate in canvas
	 * @param radius - radius of the ellipse
	 * @param level - will be used to change color after each level.
	 */
	static void drawFourFractalCircle(double x, double y, double radiusX, double radiusY) {
//		ellipse = new Ellipse(x,y,radius ,radius);
//		ellipse.setFill(null);
//		ellipse.setStroke(Color.BLUE);
//		ellipse.setStrokeWidth(1);
		
		//root.getChildren().add(ellipse);
		g.strokeOval(x-radiusX,y-radiusY,radiusX*2,radiusY*2);
		
		if(radiusX > 2) {
//		    radiusX *= 0.75;
//		    radiusY *= 0.75;
		    drawCircle(x + radiusX / 2, y, radiusX/2, radiusY/2);
		    drawCircle(x - radiusX / 2, y, radiusX/2, radiusY/2);
		   
//		    drawCircle(x, y - radiusY, radiusX/2, radiusY/2);			
//		    drawCircle(x, y + radiusY, radiusX/2, radiusY/2);
		}
	}
	
	static void drawHtree() {
		
	}
//	
	static void drawCircle(double x, double y, double radiusX, double radiusY) {
		g.strokeOval(x-radiusX,y-radiusY,radiusX*2,radiusY*2);
		if (radiusX>2) {
			radiusX *= 0.75;
			radiusY *= 0.75;
			drawCircle(x, y, radiusX, radiusY);
		}
	}
}

