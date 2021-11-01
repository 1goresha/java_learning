package sample.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button enterField;

    @FXML
    private Button signUp;

    @FXML
    private TextField gosNumber;

    @FXML
    private TextArea carListText;

    @FXML
    private Button enterId;

    @FXML
    void initialize() {

        signUp.setOnAction(event -> {

            signUp.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("/sample/views/signUp.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        enterId.setOnAction(event -> {
            if (this.signIn("Maratkaz1988@yandex.ru", "F6crigug6") != null){                        // не забудь поменять чтение с полей!
                System.out.println(this.signIn("Maratkaz1988@yandex.ru", "F6crigug6"));
            }

            enterId.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("/sample/views/privateOffice.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        enterField.setOnAction(event -> {
            String url = "https://agents.pampadu.ru/dict/mark";

            try {
                URL obj = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

//                System.out.println(response.toString());
                String jsonString = response.toString();
//                Gson g = new Gson();
//                CarList cars = (CarList)g.fromJson(jsonString, CarList.class);
//                for (Car c : cars.listCar){
//                    System.out.println(c.id + " : " + c.name);
//                }
                JSONArray jsonArray = new JSONArray(jsonString);
                JSONObject jsonObject = new JSONObject();
                List<String> list = new ArrayList<String>();
                for (Object s :
                        jsonArray) {
                    list.add(s.toString());
                    jsonObject = (JSONObject) s;
                    carListText.appendText("id : " + jsonObject.get("id") + "     " + "mark : " + jsonObject.get("title") + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        });

    }

    String signIn(String login, String pass){

        String url = "https://agents.pampadu.ru/auth";
        StringBuffer response = new StringBuffer();

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestMethod("POST");

            String jsonInputString = "{'login': '" + login +"', 'password': '" + pass + "'}";
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }


        String jsonString = response.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        String s = jsonObject.getString("token");
        return s;
    }


}


