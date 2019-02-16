package TransportManagementSystem;

//import Model.ConnectDBThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //public static Connection con;

    public final static int LoginWidth = 600;
    public final static int LoginHeight = 450;

    public final static int HomeWidth = 1366;
    public final static int HomeHeight = 710;

    public static boolean isAdmin = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        primaryStage.setTitle("Transport Management System - Login");
        primaryStage.setScene(new Scene(root, LoginWidth, LoginHeight));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //ConnectDBThread connectDBThread = new ConnectDBThread();
        launch(args);

//        try {
//            con.close();
//            System.out.println("DB Connection closed");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
