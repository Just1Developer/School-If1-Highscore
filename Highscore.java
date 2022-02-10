import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 08.02.2022
 * @author JustOneDeveloper
 */

public class Highscore extends Application {
  // Anfang Attribute
  private Button bAusgabe = new Button();
  private Button bHinzufuegen = new Button();
  private Label lAusgabe = new Label();
  private TextField tfEingabe = new TextField();
  
  private int[] highscores = new int[10];
  private Button bReset = new Button();
  // Ende Attribute
  
  public void start(Stage primaryStage) { 
    Pane root = new Pane();
    Scene scene = new Scene(root, 791, 145);
    // Anfang Komponenten
    
    bAusgabe.setLayoutX(24);
    bAusgabe.setLayoutY(24);
    bAusgabe.setPrefHeight(25);
    bAusgabe.setPrefWidth(107);
    bAusgabe.setOnAction(
      (event) -> {bAusgabe_Action(event);} 
    );
    bAusgabe.setText("Ausgabe");
    root.getChildren().add(bAusgabe);
    bHinzufuegen.setLayoutX(272);
    bHinzufuegen.setLayoutY(24);
    bHinzufuegen.setPrefHeight(25);
    bHinzufuegen.setPrefWidth(107);
    bHinzufuegen.setOnAction(
      (event) -> {bHinzufuegen_Action(event);} 
    );
    bHinzufuegen.setText("Hinzufügen");
    root.getChildren().add(bHinzufuegen);
    lAusgabe.setLayoutX(23);
    lAusgabe.setLayoutY(68);
    lAusgabe.setPrefHeight(44);
    lAusgabe.setPrefWidth(718);
    lAusgabe.setText("");
    root.getChildren().add(lAusgabe);
    tfEingabe.setLayoutX(144);
    tfEingabe.setLayoutY(24);
    tfEingabe.setPrefHeight(25);
    tfEingabe.setPrefWidth(118);
    root.getChildren().add(tfEingabe);
    bReset.setLayoutX(392);
    bReset.setLayoutY(24);
    bReset.setPrefHeight(25);
    bReset.setPrefWidth(83);
    bReset.setOnAction(
      (event) -> {bReset_Action(event);} 
    );
    bReset.setText("Reset");
    root.getChildren().add(bReset);
    // Ende Komponenten
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("Highscore");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    resetValues();
  } // end of public Highscore
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void resetValues() {
    for (int i = 0; i < 10; i++) {
      highscores[i] = 950 - (i*50);
    }
  }
  
  public void setAusgabe() {
    String out = "";
    for(int i = 0; i < highscores.length; i++) {
      //Bei Verwendung von += statt = wird definiert, dass der Text out hinten angehängt wird.
      out += ", "/*P" + (i+1) + ": "*/ + highscores[i];            //wird zu , Px: 219, erstes Komma kommt später weg
    }
    out = out.replaceFirst(", ", "");     //Erstes Komma wegmachen
    //Ausgabe
    lAusgabe.setText(out);
  }
  
  
  public int Einlesen() {     //Extra Methode weil Herr Jandt will das so
    try {
      return Integer.parseInt(tfEingabe.getText());
    } catch(NumberFormatException e) {
      lAusgabe.setText("Bitte gib eine Zahl ein.");
      e.printStackTrace();
    }
    return 0;
  }
  
  public void Einfuegen(int n) {
    if(n <= highscores[highscores.length-1]) return;                              //n not big enough
    
    int index = highscores.length-2;
    
    while(highscores[index] <= n) {
      highscores[index+1] = highscores[index];
      highscores[index] = n;
      index--;
    }
    
    setAusgabe();
  }

  
  public void bAusgabe_Action(Event evt) {
    // TODO hier Quelltext einfügen
    
    lAusgabe.setText("");
    setAusgabe();
    
  } // end of bAusgabe_Action

  public void bHinzufuegen_Action(Event evt) {
    // TODO hier Quelltext einfügen
    
    int neu = Einlesen();
    
    Einfuegen(neu);
    
  } // end of bHinzufuegen_Action

  public void bReset_Action(Event evt) {
    // TODO hier Quelltext einfügen
    resetValues();
  } // end of bReset_Action

  // Ende Methoden
} // end of class Highscore

