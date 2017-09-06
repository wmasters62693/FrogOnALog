import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main
{
    private static ArrayList<Frog> frogList = new ArrayList<Frog>();
    public static void main (String[] args)
    {
        try {
            getDataFromFile();
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
        System.out.println(Frog.getFrogCout());
        
        
        launchFX();
    }
    
    public static void launchFX()
    {
        //initialise JavaFX
        new JFXPanel();
        
        Platform.runLater(() -> initialiseGUI());
    }
    
    public static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Frogs on a log");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(720);
        stage.setHeight(720);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();
        
        Frog a = frogList.get(0);
        System.out.println(a.getName());
    }
    
    public static void moveFrogRight(Frog frog)
    {
        int frogPos = frog.getPosition();
        int newPos = frogPos;
        if (frogPos == 5) {
            System.out.println("Already all the way to the right side");
        } else {
            newPos = frogPos + 1;
        }
        System.out.println("newPos: " + newPos);
        frog.setPosition(newPos);
    }
    
    public static void moveFrogLeft(Frog frog)
    {
        int frogPos = frog.getPosition();
        int newPos = frogPos;
        if (frogPos == 0) {
            System.out.println("Already all the way to the left side");
        } else {
            newPos = frogPos - 1;
        }
        System.out.println("newPos: " + newPos);
        frog.setPosition(newPos);
    }

    public static void copyColour(Frog frog)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("what frog to you want to copy the colour of?");
        int i = 1;
        for (Frog x : frogList) {
            System.out.println(i+") " + x);
            i++;
        }
        int index = input.nextInt()-1;
        frog.setColour(frogList.get(index).getColour());
    }
    
    private static void getDataFromFile() throws IOException     //this method gets the data from the text file and puts it into uniList
    {
        FileReader fr = new FileReader("Frogs.txt");     //file included in same folder as project so no path required, data is separated by commas
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null ) {
           String[] Values = line.split(", ");  // splits lines by comma into a String array called values
           Frog frogTMP = new Frog(Values[0], Values[1], Integer.parseInt(Values[2]));      // create a new University object with data from values array
           frogList.add(frogTMP);           //add the object to the arrayList
        }
        br.close();
    }
    
    public static void terminate() {
        System.exit(0);
    }
}
