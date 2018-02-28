package com.fxmltryproject.views;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.fxmltryproject.FXMLTryProject;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RotateTransitionTestPresenter {

    @FXML
    private View rotationTest;

    @FXML
    private ImageView ImageView1;
    
    @FXML
    private TextField tfAngle;
    
    @FXML
    private TextField tfCycleCount;
    
    @FXML
    private ChoiceBox cbAutoReverse;
    
    @FXML
    private TextField tfDuration;
    
    @FXML
    private ChoiceBox cbAxis;
    
    private ObservableList<String> olAutoReverse = FXCollections.observableArrayList();
    private ObservableList<String> olAxis = FXCollections.observableArrayList();
    
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
        olAutoReverse.add("YES");
        olAutoReverse.add("NO");
        cbAutoReverse.setItems(olAutoReverse);
        
        olAxis.add("A");
        olAxis.add("B");
        olAxis.add("C");
        cbAxis.setItems(olAxis);
    }

    @FXML
    void button1Click() {
        String strAngle = tfAngle.getText();
        String strCycleCount = tfCycleCount.getText();
        String strAutoReverse = cbAutoReverse.getValue().toString();
        String strDuration = tfDuration.getText();
        String strAxis = cbAxis.getValue().toString();
        
        
        RotateTransition rt = new RotateTransition(Duration.seconds(3), ImageView1);
        rt.setByAngle(180);
        rt.setAutoReverse(true);
        
        rt.play();
    }

}
