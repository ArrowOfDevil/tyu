package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			NumberAxis x = new NumberAxis();
			NumberAxis y = new NumberAxis();
			LineChart<Number, Number> line = new LineChart<>(x,y);
			
			XYChart.Series<Number,Number> series_sin= new XYChart.Series<Number, Number>();
			series_sin.setName ("sin(x)");
			ObservableList<XYChart.Data<Number,Number>> list_sin = FXCollections.observableArrayList();
			for(int i = -1000 ; i < 1000; i++) {
				list_sin.add(new Data(i,Math.sin(Math.toRadians(i))));
			}
			series_sin.setData(list_sin);
			
			XYChart.Series<Number,Number> series_cos= new XYChart.Series<Number, Number>();
			series_cos.setName ("cos(x)");
			ObservableList<XYChart.Data<Number,Number>> list_cos = FXCollections.observableArrayList();
			for(int i = -1000 ; i < 1000; i++) {
				list_cos.add(new Data(i,Math.cos(Math.toRadians(i))));
			}
			series_cos.setData(list_cos);
			
			line.getData().addAll(series_sin,series_cos);
			Scene scene = new Scene(line, 600, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
