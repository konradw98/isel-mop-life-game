import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.HostServices;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final int DEFAULT_SIZE = 15;
    private final double DEFAULT_PROB = 0.3;

    @FXML
    private FlowPane base;
    @FXML
    private Label countLabel;
    @FXML
    private Slider countSlider;
    @FXML
    private Button runButton, stopButton, randomizeButton, clearButton;
    @FXML
    private HBox rootBox;

    private Generation generation;

    private JavaFXView display;

    private Timeline loop = null;

    private int windowWidth = 750;
    private int cellSizePx = 30;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        createBoard(DEFAULT_SIZE, DEFAULT_PROB);
        attachResizeListener();

    }

    @FXML
    private void onRun(Event evt) {
        toggleButtons(false);

        loop = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            generation.evolve();
            display.displayGeneration(generation, DEFAULT_SIZE, DEFAULT_SIZE);

        }));

        loop.setCycleCount(100);
        loop.play();
    }

    @FXML
    private void onStop(Event evt) {
        toggleButtons(true);
        loop.stop();
    }

    @FXML
    private void onClear(Event evt) {
        createBoard(DEFAULT_SIZE, 0);
    }

    @FXML
    private void onRandomize(Event evt) {
        createBoard(DEFAULT_SIZE, (double) countSlider.getValue() / 100);
    }


    @FXML
    private void onSlide(Event evt) {
        countSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            countLabel.setText(newValue.intValue() + "%");
            createBoard(DEFAULT_SIZE, (double) newValue.intValue() / 100);
        });
    }

    private void toggleButtons(boolean enable) {
        countSlider.setDisable(!enable);

        runButton.setDisable(!enable);
        clearButton.setDisable(!enable);
        randomizeButton.setDisable(!enable);

        stopButton.setDisable(enable);
    }

    private void createBoard(int size, double prob) {
        Cellules cellules = new Cellules();

        int n = (int) (prob * size * size);
        Random random = new Random();

        for (int j = 0; j < n; j++) {

            LifeCellule lifeCellule = new LifeCellule(random.nextInt(size), random.nextInt(size));

            while (cellules.contains(lifeCellule)) {
                lifeCellule = new LifeCellule(random.nextInt(size), random.nextInt(size));
            }
            cellules.add(lifeCellule);
        }

        generation = new Generation(new LifePrinciples(), cellules);
        createDisplay();
    }

    private void createDisplay() {
        display = new JavaFXView(DEFAULT_SIZE, cellSizePx, generation);

        base.getChildren().clear();
        base.getChildren().add(new Group(display.getPane()));
    }

    private void attachResizeListener() {
        rootBox.widthProperty().addListener((observable, oldValue, newValue) -> {
            int newWidth = newValue.intValue();
            if (newWidth > 250 && Math.abs(newWidth - windowWidth) >= 50) {
                windowWidth = newWidth;
                cellSizePx = newWidth / 25;
                createDisplay();
            }
        });
    }
    @FXML
    private void onAuthor(Event evt) {
        // TEXT //
        Text text1 = new Text("Game of Life Instituto.....\n");
        text1.setFont(Font.font(50));
        Text text2 = new Text(
                "Author i konrad wodnicki etc "
        );
        //Text text3 = new Text("\n\nRules\n");
        //text3.setFont(Font.font(20));
        Text text4 = new Text(
                "Project created for MoP subject etc. "
        );

        String url = "LINK DO REPO";
        Hyperlink link = new Hyperlink(url);
        link.setOnAction(__ -> getHostService().showDocument(url));
        TextFlow tf = new TextFlow(text1, text2, text4, link);
        tf.setPadding(new Insets(10, 10, 10, 10));
        tf.setTextAlignment(TextAlignment.JUSTIFY);

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(new Stage());
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(tf);
        Scene dialogScene = new Scene(dialogVbox, 700, 500);
        dialog.setScene(dialogScene);
        dialog.show();

    }


    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    private HostServices hostServices;

    public HostServices getHostService() {
        return hostServices;
    }

}
