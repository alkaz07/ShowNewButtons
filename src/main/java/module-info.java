module com.example.shownewbuttons {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shownewbuttons to javafx.fxml;
    exports com.example.shownewbuttons;
}