package com.fxmltryproject.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.fxmltryproject.FXMLTryProject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RotationTestPresenter {

    @FXML
    private View rotationTest;

    @FXML
    private Label label;

    public void initialize() {
        rotationTest.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> 
                        MobileApplication.getInstance().showLayer(FXMLTryProject.MENU_LAYER)));
                appBar.setTitleText("Rotation Test");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> 
                        System.out.println("Search")));
            }
        });
    }
    
    @FXML
    void buttonClick() {
        label.setText("Hello JavaFX Universe!");
    }
    
}
