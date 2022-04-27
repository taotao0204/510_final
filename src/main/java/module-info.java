module com.taoliu.final510 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

  /*  opens com.taoliu.final510 to javafx.fxml;
    exports com.taoliu.final510;*/
    exports com.taoliu.final510.application;
    opens com.taoliu.final510.application to javafx.fxml;
    exports com.taoliu.final510.controllers;
    opens com.taoliu.final510.controllers to javafx.fxml;
}