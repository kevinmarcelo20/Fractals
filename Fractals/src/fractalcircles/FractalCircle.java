package fractalcircles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
	private static Ellipse ellipse;
	private static Line line;
	
	static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		canvas = new Canvas(600,600);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root,Color.BLACK);
		stage.setScene(scene);
		
//		drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2, 1);
		cantorFractal(10,50,canvas.getWidth()-20);
		
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
	static void drawCircle(double x, double y, double radius, int level) {
		ellipse = new Ellipse(x,y,radius ,radius);
		ellipse.setFill(null);
		ellipse.setStroke(Color.BLUE);
//		ellipse.setStroke(new Color(0.1,0,0,0.8));
		ellipse.setStrokeWidth(1);
		root.getChildren().add(ellipse);
		
		if(radius > 8) {
			//		    drawCircle(d, e, radius);
			//AS PROFESSOR STONEDAHL ABOUT THE VITALITY OF THE 0.5F
		    radius *= 0.95;
		    
		    drawCircle(x - radius/2, y, radius/2, level + 1);
		    drawCircle(x + radius/2, y, radius/2, level+ 1);
		    drawCircle(x, y - radius/2, radius/2, level + 1);			
		    drawCircle(x, y + radius/2, radius/2,level + 1);
		}
	}
	
	static void drawHtree() {
		
	}
}

