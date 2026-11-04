

package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Main layout
        BorderPane root = new BorderPane();

        // Top - HBox
        Label title = new Label("College Student Registration");
        HBox top = new HBox(title);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20));
        root.setTop(top);

        // Left - VBox
        VBox left = new VBox(10);
        left.getChildren().addAll(
            new Button("Dashboard"),
            new Button("Registration"),
            new Button("Courses"),
            new Button("Help")
        );
        left.setPadding(new Insets(20));
        root.setLeft(left);

        // Form - GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField id = new TextField();
        TextField name = new TextField();
        TextField email = new TextField();

        // Program - ComboBox
        ComboBox<String> program = new ComboBox<>();

        program.getItems().addAll(
            "Electrical Engineering",
            "Computer Science",
            "AI-Software Engineering",
            "Business Administration",
            "Mechanical Engineering"
        );

        program.setPromptText("Select Program");

        // Add fields to GridPane
        grid.add(new Label("Student ID:"), 0, 0);
        grid.add(id, 1, 0);

        grid.add(new Label("Full Name:"), 0, 1);
        grid.add(name, 1, 1);

        grid.add(new Label("Email:"), 0, 2);
        grid.add(email, 1, 2);

        grid.add(new Label("Program:"), 0, 3);
        grid.add(program, 1, 3);

        // Buttons - HBox
        Button register = new Button("Register");
        Button clear = new Button("Clear");

        HBox buttons = new HBox(10, register, clear);
        buttons.setAlignment(Pos.CENTER);

        Label message = new Label();

        // Register function
        register.setOnAction(e -> {

            if (id.getText().trim().isEmpty() ||
                name.getText().trim().isEmpty() ||
                email.getText().trim().isEmpty() ||
                program.getValue() == null) {

                message.setText("Please fill in all fields!");
                message.setStyle("-fx-text-fill: red;");

            } else {

                message.setText("Registration Successful!");
                message.setStyle("-fx-text-fill: green;");
            }
        });

        // Clear function
        clear.setOnAction(e -> {

            id.clear();
            name.clear();
            email.clear();
            program.getSelectionModel().clearSelection();
            program.setValue(null);
            message.setText("");

        });

        // Center - VBox
        VBox center = new VBox(20,
            new Label("Student Registration Form"),
            grid,
            buttons,
            message
        );

        center.setPadding(new Insets(30));
        center.setAlignment(Pos.TOP_CENTER);
        root.setCenter(center);

        // Show window
        Scene scene = new Scene(root, 800, 500);

        stage.setTitle("Student Registration");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
