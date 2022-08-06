module com.loldle.loldle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.loldle.loldle to javafx.fxml;
    exports com.loldle.loldle;
}