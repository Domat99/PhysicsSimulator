/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author elias
 */
class EffectsProject {

    //Class
    ControlProject c1;

    public EffectsProject(ControlProject c) {
        c1 = c;
    }


    //Shadows
    //for buttons
    protected void ButtonShadowOn(Button b) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(8);
        shadow.setColor(Color.YELLOW);

        b.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                b.setEffect(shadow);
            }
        });
        ButtonShadowOff(b);
    }
    private void ButtonShadowOff(Button b2) {

        b2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                b2.setEffect(null);
            }
        });
    }

    //for sliders
    protected void SliderShadowOn(Slider s) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5);
        shadow.setColor(Color.YELLOW);

        s.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                s.setEffect(shadow);
            }
        });
        SliderShadowOff(s);
    }
    private void SliderShadowOff(Slider s2) {
        s2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                s2.setEffect(null);
            }
        });
    }

    //For Images
    protected void PictureShadowOn(ImageView iV1) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(8);

        iV1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                iV1.setEffect(shadow);
            }
        });
        PictureShadowOff(iV1);
    }

    private void PictureShadowOff(ImageView iV2) {
        iV2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                iV2.setEffect(null);
            }
        });
    }

    //For Rectangles
    //In this part, when the cursor enters the rectangle, the image gets a shadow
    protected void RectangleShadowOn(Rectangle r1, ImageView i1) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(8);

        r1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                i1.setEffect(shadow);
            }
        });
        RectangleShadowOff(r1, i1);
    }

    private void RectangleShadowOff(Rectangle r2, ImageView i2) {
        r2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                i2.setEffect(null);
            }
        });
    }

    //Cursors shapes
    //for charts
    protected void ChartCursor(Chart c1) {
        c1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                c1.setCursor(Cursor.CROSSHAIR);
            }
        });
    }

    //for buttons
    protected void CursorToHandOnButton(Button bt) {
        bt.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                bt.setCursor(Cursor.HAND);
            }
        });
    }

    //for sliders
    protected void CursorToHandOnSlider(Slider st) {
        st.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                st.setCursor(Cursor.HAND);
            }
        });
    }

    //For Images
    protected void CursorToHandOnImage(ImageView iV3) {
        iV3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                iV3.setCursor(Cursor.HAND);
            }
        });
    }

    //For Rectangles
    protected void CursorToHandOnRectangle(Rectangle rct1) {
        rct1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                rct1.setCursor(Cursor.HAND);
            }
        });
    }

    
    //Change the Background
    protected void changeBackgroundColor(Scene sc1, String col1, String col2, boolean save) {
        sc1.setFill(new RadialGradient(
                0, 0, 0, 0, 1, true, //sizing
                CycleMethod.NO_CYCLE, //cycling
                new Stop(0, Color.web(col1)), //colors
                new Stop(1, Color.web(col2)))
        );
        
        if(save == true){
            c1.saveBackgroundChange(col1, col2);
        }
    }

    //Change the Fonts
    protected void changeFont(Group labelGrp, String labelFont, Group button1Grp, String button1Font, Group button2Grp, String button2Font,
             Group sliderGrp, String sliderFont, Group menuGrp, String menuFont, Group chartGrp, String chartFont, boolean save) {
        
        labelGrp.setStyle("-fx-font: " + labelFont);
        
        button1Grp.setStyle("-fx-font: " + button1Font);
        
        button2Grp.setStyle("-fx-font: " + button2Font);
        
        sliderGrp.setStyle("-fx-font: " + sliderFont);
        
        menuGrp.setStyle("-fx-font: " + menuFont);
        
        chartGrp.setStyle("-fx-font: " + chartFont);
        
        if(save == true){
            c1.saveFontChange(labelFont, button1Font, button2Font, sliderFont, menuFont, chartFont);
        }
    }
    
    //Add a ToolTip to each data point on the graphs
    protected void addToolTipChart(LineChart<Number, Number> chart, String statement, String unit){
        
         for (XYChart.Series<Number, Number> s : chart.getData()){
             
            for (XYChart.Data<Number, Number> d : s.getData()){
                
                Node point = d.getNode();
                
                String text = statement + String.format("%.2f", d.getYValue()) + unit + " When The Time is " + d.getXValue() + "s";
                
                Tooltip tooltip = new Tooltip(text);                
                
                tooltip.setStyle("-fx-background-color: #2A21CF;" + "-fx-text-fill: #FFFFFF;");
                
                Tooltip.install(point, tooltip);                   
                
            }             
         }       
    }
    
    //Add a ToolTip for the button
    protected void addToolTipButton(Button b1, String s1){
        Tooltip tooltip1 = new Tooltip(s1);
        tooltip1.setStyle("-fx-background-color: #2A21CF;" + "-fx-text-fill: #FFFFFF; -fx-font-size: 15;");
                
        b1.setTooltip(tooltip1);
    }
    
    //Add a ToolTip for the Slider
    protected void addToolTipSlider(Slider sl1, String s1){
        Tooltip tooltip1 = new Tooltip(s1);
        tooltip1.setStyle("-fx-background-color: #2A21CF;" + "-fx-text-fill: #FFFFFF; -fx-font-size: 15;");
                
        sl1.setTooltip(tooltip1);
    }
}