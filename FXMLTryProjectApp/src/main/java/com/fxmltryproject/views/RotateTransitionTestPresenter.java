package com.fxmltryproject.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.fxmltryproject.FXMLTryProject;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RotateTransitionTestPresenter {

    @FXML
    private View rotationTest;

    @FXML
    private ImageView ImageView1;

    public void initialize() {
        rotationTest.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = MobileApplication.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e
                        -> MobileApplication.getInstance().showLayer(FXMLTryProject.MENU_LAYER)));
                appBar.setTitleText("RotateTransition Test");
                appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e
                        -> System.out.println("Search")));
            }
        });
    }

    @FXML
    void button1Click() {
        RotateTransition rt = new RotateTransition(Duration.seconds(3), ImageView1);
        rt.setByAngle(180);
        rt.setAutoReverse(true);
        
        rt.play();
    }

}
