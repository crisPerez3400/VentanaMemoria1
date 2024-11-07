package dad.VentanaMemoria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Interfaz extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        //ROJO
        HBox hboxRed = new HBox();
        Label labelRed = new Label("ROJO: ");
        Slider redSlider = createColorSlider();
        hboxRed.getChildren().addAll(labelRed, redSlider);

        //VERDE
        HBox hboxGreen = new HBox();
        Label labelGreen= new Label("VERDE: ");
        Slider greenSlider = createColorSlider();
        hboxGreen.getChildren().addAll(labelGreen, greenSlider);

        //AZUL
        HBox hboxBlue = new HBox();
        Label labelBlue= new Label("AZUL: ");
        Slider blueSlider = createColorSlider();
        hboxBlue.getChildren().addAll(labelBlue, blueSlider);





        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(hboxRed, hboxGreen, hboxBlue);

        //LISTENERS
        //valueproperty obtiene la propiedad del valor del slider
        //el listener "escucha" los cambios en el value, y se activa con los cambios  de este
         redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateBackground(root, redSlider, greenSlider, blueSlider);
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateBackground(root, redSlider, greenSlider, blueSlider);
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateBackground(root, redSlider, greenSlider, blueSlider);
        });

        Scene scene = new Scene(root, 320, 240);

        stage.setTitle("VentanaMemoria");
        stage.setScene(scene);
        stage.show();

    }

    private Slider createColorSlider() {
        Slider slider = new Slider(0, 255, 0);
                //valor minimo, maximo, inicial
                //esta info la toma el valueproperty() del listener

        return slider;
    }

    //fondo

    private void updateBackground(VBox root,  Slider redSlider, Slider greenSlider, Slider blueSlider) {
        int red = (int) redSlider.getValue();
        int green = (int) greenSlider.getValue();
        int blue = (int) blueSlider.getValue();
        Color color = Color.rgb(red, green, blue);
        root.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue + ");");
    }
}
