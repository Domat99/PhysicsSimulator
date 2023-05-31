/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author elias
 */
public class ViewProject extends Pane {
    
    //Classes
    ControlProject c1;
    EffectsProject e1;

    //Images
    ImageView mainLogo = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Transparent Resized.png")));
    ImageView iconMenuSave = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Save Icon.png")));
    ImageView iconSave2 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Save Icon.png")));
    ImageView iconMenuImport = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Import Icon.png")));
    ImageView iconMenuStart = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Start Icon.png")));
    ImageView iconStart = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Start Icon.png")));
    ImageView iconStart2 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Start Icon.png")));
    ImageView iconPause = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Pause Icon.png")));
    ImageView iconPause2 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Pause Icon.png")));
    ImageView iconMenuResetValues = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Reset Values Icon 1.png")));
    ImageView iconMenuShortcuts = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Shortcuts Icon.png")));
    ImageView iconResetValues2 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Reset Values Icon.png")));
    ImageView iconResetValues3 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Reset Values Icon.png")));
    ImageView iconResetValues4 = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Reset Values Icon.png")));
    ImageView iconColors = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Colors Icon.png")));
    ImageView iconThemes = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Themes Icon.png")));
    ImageView iconFonts = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Fonts Icon.png")));
    ImageView iconResetSettings = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Reset Settings Icon.png")));
    ImageView iconFAQ = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/FAQ Icon.png")));
    ImageView iconMainBackground = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Main Background Icon.png")));
    ImageView iconGreyBackground = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Gray Background Icon.png")));
    ImageView iconYellowBackground = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Yellow Background Icon.png")));
    ImageView iconMainFont = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Main Font Icon.png")));
    ImageView iconGaramondFont = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Garamond Font Icon.png")));
    ImageView iconForteFont = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Forte Font Icon.png")));
    ImageView iconGreyTheme = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Grey Theme Icon.png")));
    ImageView iconEasterTheme = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Easter Theme Icon.png")));
    ImageView iconChristmasTheme = new ImageView(
            new Image(FinalProject.class.getResourceAsStream("graphics/Christmas Theme Icon.png")));

    //Labels
    Group labelGroup = new Group();
    Label positionLbl = new Label("Position");
    Label velocityLbl = new Label("Velocity");
    Label accelerationLbl = new Label("Acceleration");
    Label metLbl = new Label("m");
    Label metSecLbl = new Label("m/s");
    Label metSec2Lbl = new Label("m/s\u00B2");
    Label timeLbl = new Label("Time");
    Label valuesLbl = new Label("Final Values after __ seconds:");
    Label posIniValueLbl = new Label("Initial Position:");
    Label velIniValueLbl = new Label("Initial Velocity:");
    Label accValueLbl = new Label("Initial Acceleration:");
    Label posFinValueLbl = new Label("Final Position:");
    Label velFinValueLbl = new Label("Final Velocity:");

    //Buttons
    Group buttonsGroup1 = new Group();
    Group buttonsGroup2 = new Group();
    Button calc = new Button("   Open\nCalculator");
    Button moreApps = new Button("More\nApps");
    Button btnResetAll = new Button("Reset All");
    Button btnStart = new Button("Start");
    Button btnResetV = new Button("Reset");
    Button btnResetA = new Button("Reset");
    Button btnResetP = new Button("Reset");
    Button btnSave = new Button("Save");
    Button btnImport = new Button("Import");

    //Text Fields
    Group textFieldsGroup = new Group();
    TextField positionTF = new TextField();
    TextField velocityTF = new TextField();
    TextField accelerationTF = new TextField();

    //Rectangles
    Group rectanglesGroup = new Group();

    Rectangle rct0 = new Rectangle(232, 92);

    Rectangle rct1 = new Rectangle(1000, 227);
    Rectangle rct2 = new Rectangle(1000, 226);
    Rectangle rct3 = new Rectangle(1000, 227);

    Rectangle rct4 = new Rectangle(375, 110);
    Rectangle rct5 = new Rectangle(375, 110);
    Rectangle rct6 = new Rectangle(375, 110);

    Rectangle rct7 = new Rectangle(375, 70);
    Rectangle rct8 = new Rectangle(375, 60);
    Rectangle rct9 = new Rectangle(375, 145);

    //Graphs
    Group chartGroup = new Group();

    NumberAxis xAxisPos = new NumberAxis(0, 10, 0.5);
    NumberAxis yAxisPos = new NumberAxis();
    LineChart<Number, Number> posChart = new LineChart<>(xAxisPos, yAxisPos);

    NumberAxis xAxisVel = new NumberAxis(0, 10, 0.5);
    NumberAxis yAxisVel = new NumberAxis();
    LineChart<Number, Number> velChart = new LineChart<>(xAxisVel, yAxisVel);

    NumberAxis xAxisAcc = new NumberAxis(0, 10, 0.5);
    NumberAxis yAxisAcc = new NumberAxis();
    LineChart<Number, Number> accChart = new LineChart<>(xAxisAcc, yAxisAcc);

    //Slider
    Group sliderGroup = new Group();
    Slider sliderPosition = new Slider();
    Slider sliderVelocity = new Slider();
    Slider sliderAcceleration = new Slider();
    Slider sliderTime = new Slider();

    //Menu Bar
    //EXTRA FEATURE: when user press "alt"+the first letter of the menu, the menu opens up.//
    Group menuGroup = new Group();
    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("_File");
    Menu menuSettings = new Menu("_Settings");
    Menu menuHelp = new Menu("_Help");
    Menu menuAbout = new Menu("_About");

    //Menu Items for File
    MenuItem menuSave = new MenuItem("Save");
    MenuItem menuStart = new MenuItem("Start");
    MenuItem menuResetValues = new MenuItem("Reset Values");
    MenuItem menuShortcuts = new MenuItem("Shortcuts");
    MenuItem menuImport = new MenuItem("Import");

    //Menu Items for Settings
    Menu menuColor = new Menu("Background Colors");
    Menu menuFonts = new Menu("Fonts");
    Menu menuThemes = new Menu("Preset Themes");
    MenuItem menuResetSettings = new MenuItem("Reset Settings");

    //Sub-Menu Items for Settings
    //Colors
    RadioMenuItem subColorMain = new RadioMenuItem("Main");
    RadioMenuItem subColorGrey = new RadioMenuItem("Grey");
    RadioMenuItem subColorYellow = new RadioMenuItem("Yellow");
    //Fonts
    RadioMenuItem subFonts1 = new RadioMenuItem("Main");
    RadioMenuItem subFonts2 = new RadioMenuItem("Garamond");
    RadioMenuItem subFonts3 = new RadioMenuItem("Forte");
    //Themes
    RadioMenuItem subThemes1 = new RadioMenuItem("Grey Scale");
    RadioMenuItem subThemes2 = new RadioMenuItem("Easter");
    RadioMenuItem subThemes3 = new RadioMenuItem("Christmas");

    //Menu Items for Help
    MenuItem menuFAQs = new MenuItem("FAQ\'s");
    MenuItem menuContactUs = new MenuItem("Contact Us");

    //Menu Items for About
    MenuItem menuAboutUs = new MenuItem("About us");
    MenuItem menuRate = new MenuItem("Rate us");

    //Separators
    //For the menu
    Group separatorsGroup = new Group();
    SeparatorMenuItem separator1 = new SeparatorMenuItem();
    SeparatorMenuItem separator2 = new SeparatorMenuItem();
    SeparatorMenuItem separator3 = new SeparatorMenuItem();
    //General Separators
    Separator mainSep1 = new Separator();
    Separator mainSep2 = new Separator();

    public ViewProject(FinalProject f3) {

        c1 = new ControlProject(this);
        e1 = new EffectsProject(c1);

        this.setPadding(new Insets(50, 50, 50, 50));
        this.getChildren().addAll(menuGroup, separatorsGroup, rectanglesGroup,
                mainLogo, chartGroup, buttonsGroup1, buttonsGroup2, sliderGroup,
                textFieldsGroup, labelGroup);

        menuBar.getMenus().addAll(menuFile, menuSettings, menuHelp, menuAbout);
        menuGroup.getChildren().add(menuBar);

        separatorsGroup.getChildren().addAll(mainSep1, mainSep2);

        rectanglesGroup.getChildren().addAll(rct1, rct2, rct3, rct4, rct5, rct6, rct7, rct8, rct9, rct0);

        chartGroup.getChildren().addAll(posChart, velChart, accChart);

        buttonsGroup1.getChildren().addAll(calc, moreApps);
        buttonsGroup2.getChildren().addAll(btnResetAll, btnStart, btnResetA, btnResetV, btnResetP, btnSave, btnImport);

        sliderGroup.getChildren().addAll(sliderPosition, sliderVelocity, sliderAcceleration, sliderTime);

        textFieldsGroup.getChildren().addAll(positionTF, velocityTF, accelerationTF);

        labelGroup.getChildren().addAll(positionLbl, velocityLbl, accelerationLbl, metLbl, posIniValueLbl, velIniValueLbl,
                accValueLbl, posFinValueLbl, velFinValueLbl, metSecLbl, metSec2Lbl, timeLbl, valuesLbl);

        
        //GRAPHICS
        mainLogo.setLayoutX(25);
        mainLogo.setLayoutY(10);
        c1.OpenLinkPic(mainLogo, "https://sites.google.com/view/noterror404/");

        //BUTTONS on the Top Right corner (buttonGroup1)
        calc.setLayoutX(1265);
        calc.setLayoutY(25);
        calc.setMinSize(80, 70);
        calc.setAlignment(Pos.CENTER);

        moreApps.setLayoutX(1370);
        moreApps.setLayoutY(25);
        moreApps.setMinSize(80, 70);
        moreApps.setAlignment(Pos.CENTER);

        buttonsGroup1.setStyle("-fx-font: 16 arial; -fx-base: #2A21CF;");
        //Functions
        c1.ButtonOpenApp(calc, "calc");
        c1.OpenLinkBtn(moreApps, "https://sites.google.com/view/noterror404/more-apps");

        //Menu Bar
        menuBar.setLayoutX(50);
        menuBar.setLayoutY(110);

        mainSep1.setMinWidth(1500);
        mainSep1.setLayoutX(0);
        mainSep1.setLayoutY(110);

        mainSep2.setMinWidth(1500);
        mainSep2.setLayoutX(0);
        mainSep2.setLayoutY(140);

        //FILE MENU
        //Set icons for File menu items
        menuSave.setGraphic(iconMenuSave);
        menuImport.setGraphic(iconMenuImport);
        menuStart.setGraphic(iconMenuStart);
        menuResetValues.setGraphic(iconMenuResetValues);
        menuShortcuts.setGraphic(iconMenuShortcuts);

        //Set Shortcuts for File menu items 
        menuStart.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        menuSave.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        menuResetValues.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        menuImport.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
        menuShortcuts.setAccelerator(KeyCombination.keyCombination("F2"));

        //File subMenues functions
        menuStart.setOnAction(event -> c1.mainFunction(event));
        menuResetValues.setOnAction(event -> c1.clearGraphs(event, "ALL"));
        menuShortcuts.setOnAction(event -> c1.popUpWindowsShortcuts(event));
        menuSave.setOnAction(event -> c1.save(event));
        menuImport.setOnAction(event -> c1.importData(event));
        
        //Adding menu items to the file menu
        menuFile.getItems().addAll(menuSave, menuImport, separator1, menuStart, menuResetValues, separator2, menuShortcuts);

        //SETTINGS MENU
        //Set icons for Settings menu items
        menuColor.setGraphic(iconColors);
        menuThemes.setGraphic(iconThemes);
        menuFonts.setGraphic(iconFonts);
        menuResetSettings.setGraphic(iconResetSettings);

        //Set shortcuts for Settings menu items
        menuResetSettings.setAccelerator(KeyCombination.keyCombination("F5"));

        //Adding menus and menu items to the Settings menu
        menuSettings.getItems().addAll(menuColor, menuFonts, menuThemes, separator3, menuResetSettings);

        //Setting Graphics for Background Color menu items
        subColorMain.setGraphic(iconMainBackground);
        subColorGrey.setGraphic(iconGreyBackground);
        subColorYellow.setGraphic(iconYellowBackground);

        //putting background color menu items into a ToggleGroup
        final ToggleGroup tGroupColors = new ToggleGroup();
        subColorMain.setToggleGroup(tGroupColors);
        subColorGrey.setToggleGroup(tGroupColors);
        subColorYellow.setToggleGroup(tGroupColors);

        //Setting Graphics for Fonts menu items
        subFonts1.setGraphic(iconMainFont);
        subFonts2.setGraphic(iconGaramondFont);
        subFonts3.setGraphic(iconForteFont);

        //putting Fonts menu items into a ToggleGroup
        final ToggleGroup tGroupFonts = new ToggleGroup();
        subFonts1.setToggleGroup(tGroupFonts);
        subFonts2.setToggleGroup(tGroupFonts);
        subFonts3.setToggleGroup(tGroupFonts);

        //Setting Graphics for Themes menu items
        subThemes1.setGraphic(iconGreyTheme);
        subThemes2.setGraphic(iconEasterTheme);
        subThemes3.setGraphic(iconChristmasTheme);

        //putting Themes menu items into a ToggleGroup
        final ToggleGroup tGroupThemes = new ToggleGroup();
        subThemes1.setToggleGroup(tGroupThemes);
        subThemes2.setToggleGroup(tGroupThemes);
        subThemes3.setToggleGroup(tGroupThemes);

        //Adding menu items to each menu in the Settings menu
        menuColor.getItems().addAll(subColorMain, subColorGrey, subColorYellow);
        menuFonts.getItems().addAll(subFonts1, subFonts2, subFonts3);
        menuThemes.getItems().addAll(subThemes1, subThemes2, subThemes3);

        //Set shortcuts for Help menu Item
        menuFAQs.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
        //Adding menu items to the Help menu
        menuHelp.getItems().addAll(menuFAQs, menuContactUs);
        //Help Menu Event Handlers
        c1.OpenLinkMenuItem(menuFAQs, "https://sites.google.com/view/noterror404/help/faq");
        c1.OpenLinkMenuItem(menuContactUs, "https://sites.google.com/view/noterror404/about-us/contact-us/");

        //Adding menu items to the About menu
        menuAbout.getItems().addAll(menuAboutUs, menuRate);
        //About Menu Event Handlers
        c1.OpenLinkMenuItem(menuAboutUs, "https://sites.google.com/view/noterror404/about-us/");
        c1.OpenLinkMenuItem(menuRate, "https://sites.google.com/view/noterror404/rate-us/");
        
        //RECTANGLE Behind Logo
        rct0.setLayoutX(25);
        rct0.setLayoutY(10);
        rct0.setFill(Color.TRANSPARENT);
        rct0.setStroke(Color.TRANSPARENT);

        //RECTANGLE Behind the Position Graph
        rct1.setLayoutX(50);
        rct1.setLayoutY(150);
        rct1.setFill(Color.TRANSPARENT);
        rct1.setStroke(Color.BLACK);
        //RECTANGLE Behind the Velocity Graph
        rct2.setLayoutX(50);
        rct2.setLayoutY(377);
        rct2.setFill(Color.TRANSPARENT);
        rct2.setStroke(Color.BLACK);
        //RECTANGLE Behind the Acceleration Graph
        rct3.setLayoutX(50);
        rct3.setLayoutY(603);
        rct3.setFill(Color.TRANSPARENT);
        rct3.setStroke(Color.BLACK);

        //GRAPHS
        //Position Graph
        xAxisPos.setLabel("Time (s)");
        yAxisPos.setLabel("Position (m)");
        posChart.setLayoutX(50);
        posChart.setLayoutY(155);
        posChart.setMaxSize(990, 227);
        posChart.setMinSize(990, 227);
        posChart.setLegendVisible(false);

        //Velocity Graph
        xAxisVel.setLabel("Time (s)");
        yAxisVel.setLabel("Velocity (m/s)");
        velChart.setLayoutX(50);
        velChart.setLayoutY(382);
        velChart.setMaxSize(990, 227);
        velChart.setMinSize(990, 227);
        velChart.setLegendVisible(false);

        //Acceleration Graph
        xAxisAcc.setLabel("Time (s)");
        yAxisAcc.setLabel("Acceleration (m/s\u00B2)");
        accChart.setLayoutX(50);
        accChart.setLayoutY(613);
        accChart.setMaxSize(990, 227);
        accChart.setMinSize(990, 227);
        accChart.setLegendVisible(false);

        //BOXES
        //Position Box(4)
        rct4.setLayoutX(1075);
        rct4.setLayoutY(150);
        rct4.setFill(Color.TRANSPARENT);
        rct4.setStroke(Color.BLACK);

        positionLbl.setLayoutX(1085);
        positionLbl.setLayoutY(168);

        positionTF.setLayoutX(1190);
        positionTF.setLayoutY(165);
        positionTF.setMaxSize(115, 30);
        positionTF.setMinSize(115, 30);
        positionTF.setText("0.00");
        positionTF.setTextFormatter(new TextFormatter<>(c1.filter));
        c1.textFieldChartNumPosition(positionTF);

        metLbl.setLayoutX(1285);
        metLbl.setLayoutY(168);

        sliderPosition.setLayoutX(1130);
        sliderPosition.setLayoutY(205);
        sliderPosition.setMin(-20);
        sliderPosition.setMax(20);
        sliderPosition.setShowTickLabels(true);
        sliderPosition.setShowTickMarks(true);
        sliderPosition.setMajorTickUnit(5);
        sliderPosition.setMinorTickCount(1);
        sliderPosition.setMinSize(225, 0);
        //This is to change the value in the text field as the slider's value changes
        sliderPosition.valueProperty().addListener(c1.sliderControlPosition());

        btnResetP.setLayoutX(1320);
        btnResetP.setLayoutY(165);
        btnResetP.setGraphic(iconResetValues2);
        btnResetP.setMaxSize(115, 30);
        btnResetP.setMinSize(115, 30);
        
        //Functions & event handlers
        btnResetP.setOnAction(event -> c1.clearGraphs(event, "POS"));
        
        //Velocity Box(5)
        rct5.setLayoutX(1075);
        rct5.setLayoutY(275);
        rct5.setFill(Color.TRANSPARENT);
        rct5.setStroke(Color.BLACK);

        velocityLbl.setLayoutX(1085);
        velocityLbl.setLayoutY(293);

        velocityTF.setLayoutX(1190);
        velocityTF.setLayoutY(290);
        velocityTF.setMaxSize(115, 30);
        velocityTF.setMinSize(115, 30);
        velocityTF.setText("0.00");        
        velocityTF.setTextFormatter(new TextFormatter<>(c1.filter));
        c1.textFieldChartNumPosition(velocityTF);
        
        metSecLbl.setLayoutX(1273);
        metSecLbl.setLayoutY(293);

        sliderVelocity.setLayoutX(1130);
        sliderVelocity.setLayoutY(330);
        sliderVelocity.setMin(-20);
        sliderVelocity.setMax(20);
        sliderVelocity.setShowTickLabels(true);
        sliderVelocity.setShowTickMarks(true);
        sliderVelocity.setMajorTickUnit(5);
        sliderVelocity.setMinorTickCount(1);
        sliderVelocity.setMinSize(225, 0);
        //This is to change the value in the text field as the slider's value changes
        sliderVelocity.valueProperty().addListener(c1.sliderControlVelocity());

        btnResetV.setLayoutX(1320);
        btnResetV.setLayoutY(290);
        btnResetV.setGraphic(iconResetValues3);
        btnResetV.setMaxSize(115, 30);
        btnResetV.setMinSize(115, 30);
        
        //Functions & event handlers
        btnResetV.setOnAction(event -> c1.clearGraphs(event, "VEL"));

        //Acceleration Box(6)
        rct6.setLayoutX(1075);
        rct6.setLayoutY(400);
        rct6.setFill(Color.TRANSPARENT);
        rct6.setStroke(Color.BLACK);

        accelerationLbl.setLayoutX(1085);
        accelerationLbl.setLayoutY(418);

        accelerationTF.setLayoutX(1190);
        accelerationTF.setLayoutY(415);
        accelerationTF.setMaxSize(115, 30);
        accelerationTF.setMinSize(115, 30);
        accelerationTF.setText("0.00");
        accelerationTF.setTextFormatter(new TextFormatter<>(c1.filter));
        c1.textFieldChartNumPosition(accelerationTF);

        metSec2Lbl.setLayoutX(1268);
        metSec2Lbl.setLayoutY(418);

        sliderAcceleration.setLayoutX(1130);
        sliderAcceleration.setLayoutY(455);
        sliderAcceleration.setMin(-20);
        sliderAcceleration.setMax(20);
        sliderAcceleration.setShowTickLabels(true);
        sliderAcceleration.setShowTickMarks(true);
        sliderAcceleration.setMajorTickUnit(5);
        sliderAcceleration.setMinorTickCount(1);
        sliderAcceleration.setMinSize(225, 0);
        //This is to change the value in the text field as the slider's value changes
        sliderAcceleration.valueProperty().addListener(c1.sliderControlAcceleration());

        btnResetA.setLayoutX(1320);
        btnResetA.setLayoutY(415);
        btnResetA.setGraphic(iconResetValues4);
        btnResetA.setMaxSize(115, 28);
        btnResetA.setMinSize(115, 28);

        //Functions & event handlers
        btnResetA.setOnAction(event -> c1.clearGraphs(event, "ACC"));
        
        //Time Box(7)
        rct7.setLayoutX(1075);
        rct7.setLayoutY(525);
        rct7.setFill(Color.TRANSPARENT);
        rct7.setStroke(Color.BLACK);

        timeLbl.setLayoutX(1085);
        timeLbl.setLayoutY(540);

        sliderTime.setLayoutX(1138);
        sliderTime.setLayoutY(538);
        sliderTime.setMin(1);
        sliderTime.setMax(10);
        sliderTime.setShowTickLabels(true);
        sliderTime.setShowTickMarks(true);
        sliderTime.setMajorTickUnit(1);
        sliderTime.setMinSize(175, 0);
        sliderTime.setBlockIncrement(1);
        sliderTime.setMinorTickCount(0);
        sliderTime.setSnapToTicks(true);

        btnStart.setLayoutX(1325);
        btnStart.setLayoutY(540);
        btnStart.setMinSize(110, 30);
        btnStart.setMaxSize(110, 30);
        btnStart.setGraphic(iconStart2);

        //Functions & event handlers
        btnStart.setOnAction(event -> c1.mainFunction(event));

        //Control Box (8)
        rct8.setLayoutX(1075);
        rct8.setLayoutY(610);
        rct8.setFill(Color.TRANSPARENT);
        rct8.setStroke(Color.BLACK);

        btnSave.setLayoutX(1090);
        btnSave.setLayoutY(625);
        btnSave.setMinSize(105, 30);
        btnSave.setMaxSize(105, 30);

        btnImport.setLayoutX(1210);
        btnImport.setLayoutY(625);
        btnImport.setMinSize(105, 30);
        btnImport.setMaxSize(105, 30);

        btnResetAll.setLayoutX(1330);
        btnResetAll.setLayoutY(625);
        btnResetAll.setMinSize(105, 30);
        btnResetAll.setMaxSize(105, 30);

        //Functions & event handlers
        btnSave.setOnAction(event -> c1.save(event));
        btnImport.setOnAction(event -> c1.importData(event));
        btnResetAll.setOnAction(event -> c1.clearGraphs(event, "ALL"));
        
        //Final Values Box(9)
        rct9.setLayoutX(1075);
        rct9.setLayoutY(685);
        rct9.setFill(Color.BURLYWOOD);
        rct9.setStroke(Color.BLACK);

        valuesLbl.setLayoutX(1085);
        valuesLbl.setLayoutY(688);
        
        posIniValueLbl.setLayoutX(1085);
        posIniValueLbl.setLayoutY(711);
        
        velIniValueLbl.setLayoutX(1085);
        velIniValueLbl.setLayoutY(734);
        
        accValueLbl.setLayoutX(1085);
        accValueLbl.setLayoutY(757);
        
        posFinValueLbl.setLayoutX(1085);
        posFinValueLbl.setLayoutY(780);
        
        velFinValueLbl.setLayoutX(1085);
        velFinValueLbl.setLayoutY(803);

////////////////////////////////////////////////////////////////////////////////
        
        //Effects for Buttons
        e1.ButtonShadowOn(calc);
        e1.CursorToHandOnButton(calc);
        e1.ButtonShadowOn(moreApps);
        e1.CursorToHandOnButton(moreApps);
        e1.ButtonShadowOn(btnResetAll);
        e1.CursorToHandOnButton(btnResetAll);
        e1.ButtonShadowOn(btnStart);
        e1.CursorToHandOnButton(btnStart);
        e1.ButtonShadowOn(btnResetP);
        e1.CursorToHandOnButton(btnResetP);
        e1.ButtonShadowOn(btnResetV);
        e1.CursorToHandOnButton(btnResetV);
        e1.ButtonShadowOn(btnResetA);
        e1.CursorToHandOnButton(btnResetA);
        e1.ButtonShadowOn(btnSave);
        e1.CursorToHandOnButton(btnSave);
        e1.ButtonShadowOn(btnImport);
        e1.CursorToHandOnButton(btnImport);

        //Effects for Sliders
        e1.SliderShadowOn(sliderPosition);
        e1.CursorToHandOnSlider(sliderPosition);
        e1.SliderShadowOn(sliderVelocity);
        e1.CursorToHandOnSlider(sliderVelocity);
        e1.SliderShadowOn(sliderAcceleration);
        e1.CursorToHandOnSlider(sliderAcceleration);
        e1.SliderShadowOn(sliderTime);
        e1.CursorToHandOnSlider(sliderTime);

        //Effects for Charts
        e1.ChartCursor(posChart);
        e1.ChartCursor(velChart);
        e1.ChartCursor(accChart);

        //Effects for Pictures
        e1.PictureShadowOn(mainLogo);
        e1.CursorToHandOnImage(mainLogo);
        e1.RectangleShadowOn(rct0, mainLogo);
        e1.CursorToHandOnRectangle(rct0);
        
        //Adding TOOLTIPS
        //Position Box (4)
        e1.addToolTipButton(btnResetP, "Reset Position");
        e1.addToolTipSlider(sliderPosition, "Enter Initial Position");
        //Velocity Box (5)
        e1.addToolTipButton(btnResetV, "Reset Velocity");
        e1.addToolTipSlider(sliderVelocity, "Enter Initial Velocity");
        //Velocity Box (6)
        e1.addToolTipButton(btnResetA, "Reset Acceleration");
        e1.addToolTipSlider(sliderAcceleration, "Enter Initial Acceleration");
        //Time Box (6)
        e1.addToolTipButton(btnStart, "Run the program");
        e1.addToolTipSlider(sliderTime, "Choose Final Time");
        //Controls Box (7)
        e1.addToolTipButton(btnSave, "Save current values");
        e1.addToolTipButton(btnImport, "Import the last saved values");
        e1.addToolTipButton(btnResetAll, "Reset all values");
        
        //SETTINGS
        //Change Backgrounds
        //Background Color 1
        subColorMain.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#deb887", "#C5DFFB", true));
        subColorMain.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Background Color 2
        subColorGrey.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#BFBFBF", "#A1A1A1", true));
        subColorGrey.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Background Color 3
        subColorYellow.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#FFFFFF", "#D7BE09", true));
        subColorYellow.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Change Fonts
        //Font 1
        subFonts1.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "15 helvetica;", buttonsGroup1, "15 helvetica; -fx-base: #2A21CF;",
                buttonsGroup2, "15 helvetica;", sliderGroup, "15 helvetica;", menuGroup, "15 helvetica;", chartGroup, "15 helvetica;", true));
        subFonts1.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Font 2
        subFonts2.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "18 Garamond;", buttonsGroup1, "16 Garamond; -fx-base: #2A21CF;",
                buttonsGroup2, "15 Garamond;", sliderGroup, "17 Garamond;", menuGroup, "15 Garamond;", chartGroup, "17 Garamond;", true));
        subFonts2.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Font 3
        subFonts3.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "18 forte;", buttonsGroup1, "16 forte; -fx-base: #2A21CF;",
                buttonsGroup2, "17 forte;", sliderGroup, "17 forte;", menuGroup, "17 forte;", chartGroup, "17 forte;", true));
        subFonts3.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());

        //Change Themes
        //Theme 1
        subThemes1.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#BFBFBF", "#A1A1A1", true));
        subThemes1.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "18 Garamond;", buttonsGroup1, "16 Garamond; -fx-base: #2A21CF;",
                buttonsGroup2, "15 Garamond;", sliderGroup, "17 Garamond;", menuGroup, "15 Garamond;", chartGroup, "17 Garamond;", true));
        subThemes1.addEventHandler(ActionEvent.ACTION, (e) -> tGroupColors.getToggles().clear());
        subThemes1.addEventHandler(ActionEvent.ACTION, (e) -> tGroupFonts.getToggles().clear());

        //Theme 2
        subThemes2.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#70AD47", "#D7BE09", true));
        subThemes2.setOnAction(event -> e1.changeFont(labelGroup, "15 helvetica;", buttonsGroup1, "15 helvetica; -fx-base: #2A21CF;",
                buttonsGroup2, "15 helvetica;", sliderGroup, "15 helvetica;", menuGroup, "15 helvetica;", chartGroup, "15 helvetica;", true));
        subThemes2.addEventHandler(ActionEvent.ACTION, (e) -> tGroupColors.getToggles().clear());
        subThemes2.addEventHandler(ActionEvent.ACTION, (e) -> tGroupFonts.getToggles().clear());

        //Theme 3
        subThemes3.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#C00000", "#FF7171", true));
        subThemes3.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "18 forte;", buttonsGroup1, "16 forte; -fx-base: #2A21CF;",
                buttonsGroup2, "17 forte;", sliderGroup, "17 forte;", menuGroup, "17 forte;", chartGroup, "17 forte;", true));
        subThemes3.addEventHandler(ActionEvent.ACTION, (e) -> tGroupColors.getToggles().clear());
        subThemes3.addEventHandler(ActionEvent.ACTION, (e) -> tGroupFonts.getToggles().clear());

        //Reset Themes
        menuResetSettings.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeBackgroundColor(f3.scene1, "#deb887", "#C5DFFB", true));
        menuResetSettings.addEventHandler(ActionEvent.ACTION, (e) -> e1.changeFont(labelGroup, "15 helvetica;", buttonsGroup1, "15 helvetica; -fx-base: #2A21CF;",
                buttonsGroup2, "15 helvetica;", sliderGroup, "15 helvetica;", menuGroup, "15 helvetica;", chartGroup, "15 helvetica;", true));
        menuResetSettings.addEventHandler(ActionEvent.ACTION, (e) -> tGroupThemes.getToggles().clear());
        menuResetSettings.addEventHandler(ActionEvent.ACTION, (e) -> subColorMain.setSelected(true));
        menuResetSettings.addEventHandler(ActionEvent.ACTION, (e) -> subFonts1.setSelected(true));

    }
}