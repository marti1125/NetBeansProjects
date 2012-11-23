/*
 * Copyright (c) 2008, Sun Microsystems, Inc.
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in
 *      the documentation and/or other materials provided with the
 *      distribution.
 *    * Neither the name of Sun Microsystems, Inc. nor the names of its
 *      contributors may be used to endorse or promote products derived
 *      from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.netbeans.j1.game;

import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.m2g.SVGImage;
import org.netbeans.j1.game.logic.GameThread;
import org.netbeans.microedition.svg.SVGMenu;
import org.netbeans.microedition.svg.SVGMenu;
import org.netbeans.microedition.svg.SVGSplashScreen;
import org.netbeans.microedition.svg.SVGSplashScreen;
import org.netbeans.microedition.svg.SVGSplashScreen;
import org.netbeans.microedition.svg.SVGSplashScreen;
import org.netbeans.microedition.svg.SVGWaitScreen;
import org.netbeans.microedition.svg.SVGWaitScreen;
import org.netbeans.microedition.svg.SVGWaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;
import org.netbeans.microedition.util.SimpleCancellableTask;
import org.netbeans.microedition.util.SimpleCancellableTask;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Fabiola Gallegos Rios, Lukas Hasik
 */
public class GameMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private SVGMenu svgMainMenu;
    private SVGSplashScreen svgGameSplashScreen;
    private SVGWaitScreen svgGameScoresWaitScreen;
    private Form formUserAndScore;
    private TextField nameTextField;
    private TextField scoreTextField;
    private Alert alert;
    private SVGSplashScreen svgSplashScreenAbout;
    private SVGWaitScreen svgNewScoreWaitScreen;
    private SVGSplashScreen svgScoresTable;
    private Command okCommand1;
    private Command cancelCommand;
    private Command okCommand2;
    private SVGImage svgMenuImage;
    private SVGImage svgWaitImage;
    private SVGImage svgSplashImage;
    private SimpleCancellableTask addHighScoreTask;
    private SVGImage svgAboutImage;
    private SimpleCancellableTask highScoresTask;
    private SVGImage svgScoresImage;
    //</editor-fold>//GEN-END:|fields|0|
    private GameThread myGameThread;

    /**
     * The GameMIDlet constructor.
     */
    public GameMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
    // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
    // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSvgGameSplashScreen().getSvgCanvas());//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
    // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
    // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == formUserAndScore) {//GEN-BEGIN:|7-commandAction|1|42-preAction
            if (command == cancelCommand) {//GEN-END:|7-commandAction|1|42-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgGameScoresWaitScreen().getSvgCanvas());//GEN-LINE:|7-commandAction|2|42-postAction
            // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|3|40-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgNewScoreWaitScreen().getSvgCanvas());//GEN-LINE:|7-commandAction|4|40-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|33-preAction
        } else if (displayable == svgGameScoresWaitScreen) {
            if (command == SVGWaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|5|33-preAction
                // write pre-action user code here
                switchDisplayable(getAlert(), getSvgMainMenu().getSvgCanvas());//GEN-LINE:|7-commandAction|6|33-postAction
            // write post-action user code here
            } else if (command == SVGWaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|7|32-preAction
                //update the svg with the new values of the high scores
                updateSvgWithHighScores();
                switchDisplayable(null, getSvgScoresTable().getSvgCanvas());//GEN-LINE:|7-commandAction|8|32-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|26-preAction
        } else if (displayable == svgGameSplashScreen) {
            if (command == SVGSplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|9|26-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgMainMenu().getSvgCanvas());//GEN-LINE:|7-commandAction|10|26-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|15-preAction
        } else if (displayable == svgMainMenu) {
            if (command == SVGMenu.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|15-preAction
                // write pre-action user code here
                svgMainMenuAction();//GEN-LINE:|7-commandAction|12|15-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|78-preAction
        } else if (displayable == svgNewScoreWaitScreen) {
            if (command == SVGWaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|13|78-preAction
                // write pre-action user code here
                switchDisplayable(getAlert(), getSvgMainMenu().getSvgCanvas());//GEN-LINE:|7-commandAction|14|78-postAction
            // write post-action user code here
            } else if (command == SVGWaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|15|77-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgScoresTable().getSvgCanvas());//GEN-LINE:|7-commandAction|16|77-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|81-preAction
        } else if (displayable == svgScoresTable) {
            if (command == SVGSplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|17|81-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgMainMenu().getSvgCanvas());//GEN-LINE:|7-commandAction|18|81-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|68-preAction
        } else if (displayable == svgSplashScreenAbout) {
            if (command == SVGSplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|19|68-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgMainMenu().getSvgCanvas());//GEN-LINE:|7-commandAction|20|68-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|7-postCommandAction
        }//GEN-END:|7-commandAction|21|7-postCommandAction
    // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|22|
    //</editor-fold>//GEN-END:|7-commandAction|22|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgMainMenu ">//GEN-BEGIN:|13-getter|0|13-preInit
    /**
     * Returns an initiliazed instance of svgMainMenu component.
     * @return the initialized component instance
     */
    public SVGMenu getSvgMainMenu() {
        if (svgMainMenu == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            svgMainMenu = new SVGMenu(getSvgMenuImage(), getDisplay());//GEN-BEGIN:|13-getter|1|13-postInit
            svgMainMenu.setTitle("svgMenu");
            svgMainMenu.addCommand(SVGMenu.SELECT_COMMAND);
            svgMainMenu.setCommandListener(this);
            svgMainMenu.setFullScreenMode(true);
            svgMainMenu.addMenuElement("menuItem_0");
            svgMainMenu.addMenuElement("menuItem_1");
            svgMainMenu.addMenuElement("menuItem_2");
            svgMainMenu.addMenuElement("menuItem_3");//GEN-END:|13-getter|1|13-postInit

            //following is update of the time on top of the menu
            TimerTask svgUpdateTask = new TimerTask() {
                public void run() {
                    getSvgMainMenu().setTraitSafely("dateTime", "#text", new java.util.Date().toString());
                }
            };
            //we have to schedule the updater
            new Timer().scheduleAtFixedRate(svgUpdateTask, 0, 1000);
        }//GEN-BEGIN:|13-getter|2|
        return svgMainMenu;
    }
    //</editor-fold>//GEN-END:|13-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: svgMainMenuAction ">//GEN-BEGIN:|13-action|0|13-preAction
    /**
     * Performs an action assigned to the selected SVG menu element in the svgMainMenu component.
     */
    public void svgMainMenuAction() {//GEN-END:|13-action|0|13-preAction
        // enter pre-action user code here
        String __selectedElement = getSvgMainMenu().getMenuElementID(getSvgMainMenu().getSelectedIndex());//GEN-BEGIN:|13-action|1|19-preAction
        if (__selectedElement != null) {
            if (__selectedElement.equals("menuItem_0")) {//GEN-END:|13-action|1|19-preAction
            // write pre-action user code here
//GEN-LINE:|13-action|2|19-postAction
            // write post-action user code here
            //TODO: [Exercise 1][step4] It starts the game thread
 
            } else if (__selectedElement.equals("menuItem_1")) {//GEN-LINE:|13-action|3|20-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgGameScoresWaitScreen().getSvgCanvas());//GEN-LINE:|13-action|4|20-postAction
            // write post-action user code here
            } else if (__selectedElement.equals("menuItem_2")) {//GEN-LINE:|13-action|5|21-preAction
                // write pre-action user code here
                switchDisplayable(null, getSvgSplashScreenAbout().getSvgCanvas());//GEN-LINE:|13-action|6|21-postAction
            // write post-action user code here
            } else if (__selectedElement.equals("menuItem_3")) {//GEN-LINE:|13-action|7|22-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|13-action|8|22-postAction
            // write post-action user code here
            }//GEN-BEGIN:|13-action|9|13-postAction
        }//GEN-END:|13-action|9|13-postAction
    // enter post-action user code here
    }//GEN-BEGIN:|13-action|10|
    //</editor-fold>//GEN-END:|13-action|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgMenuImage ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of svgMenuImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgMenuImage() {
        if (svgMenuImage == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|18-getter|1|18-@java.io.IOException
                svgMenuImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/menu.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|18-getter|1|18-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|18-getter|2|18-postInit
        // write post-init user code here
        }//GEN-BEGIN:|18-getter|3|
        return svgMenuImage;
    }
    //</editor-fold>//GEN-END:|18-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgGameSplashScreen ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of svgGameSplashScreen component.
     * @return the initialized component instance
     */
    public SVGSplashScreen getSvgGameSplashScreen() {
        if (svgGameSplashScreen == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            svgGameSplashScreen = new SVGSplashScreen(getSvgSplashImage(), getDisplay());//GEN-BEGIN:|24-getter|1|24-postInit
            svgGameSplashScreen.setTitle("");
            svgGameSplashScreen.setCommandListener(this);
            svgGameSplashScreen.setFullScreenMode(true);
            svgGameSplashScreen.setTimeout(4000);//GEN-END:|24-getter|1|24-postInit
        // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return svgGameSplashScreen;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgGameScoresWaitScreen ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of svgGameScoresWaitScreen component.
     * @return the initialized component instance
     */
    public SVGWaitScreen getSvgGameScoresWaitScreen() {
        if (svgGameScoresWaitScreen == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            svgGameScoresWaitScreen = new SVGWaitScreen(getSvgWaitImage(), getDisplay());//GEN-BEGIN:|29-getter|1|29-postInit
            svgGameScoresWaitScreen.setTitle("");
            svgGameScoresWaitScreen.setCommandListener(this);
            svgGameScoresWaitScreen.setFullScreenMode(true);
            svgGameScoresWaitScreen.setTask(getHighScoresTask());//GEN-END:|29-getter|1|29-postInit
        // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return svgGameScoresWaitScreen;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgWaitImage ">//GEN-BEGIN:|23-getter|0|23-preInit
    /**
     * Returns an initiliazed instance of svgWaitImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgWaitImage() {
        if (svgWaitImage == null) {//GEN-END:|23-getter|0|23-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|23-getter|1|23-@java.io.IOException
                svgWaitImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/waitscreen.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|23-getter|1|23-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|23-getter|2|23-postInit
        // write post-init user code here
        }//GEN-BEGIN:|23-getter|3|
        return svgWaitImage;
    }
    //</editor-fold>//GEN-END:|23-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgSplashImage ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of svgSplashImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgSplashImage() {
        if (svgSplashImage == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|28-getter|1|28-@java.io.IOException
                svgSplashImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/splashscreen.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|28-getter|1|28-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|28-getter|2|28-postInit
        // write post-init user code here
        }//GEN-BEGIN:|28-getter|3|
        return svgSplashImage;
    }
    //</editor-fold>//GEN-END:|28-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: addHighScoreTask ">//GEN-BEGIN:|34-getter|0|34-preInit
    /**
     * Returns an initiliazed instance of addHighScoreTask component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getAddHighScoreTask() {
        if (addHighScoreTask == null) {//GEN-END:|34-getter|0|34-preInit
            // write pre-init user code here
            addHighScoreTask = new SimpleCancellableTask();//GEN-BEGIN:|34-getter|1|34-execute
            addHighScoreTask.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|34-getter|1|34-execute
//#if ONLINE == "true"                    
//#                     //TODO: [Exercise 4][step 3] set High score
//#                     //upload the score to WS
//#                     //get the high scores from WS again to synchronize with server side
//#else
                    //just add the score to the scores table
                    addScoreToScoreTable(lastHighScore, getNameTextField().getString());
//#endif
                    //anyway update the High scores table
                    updateSvgWithHighScores();
                }//GEN-BEGIN:|34-getter|2|34-postInit
            });//GEN-END:|34-getter|2|34-postInit
        // write post-init user code here
        }//GEN-BEGIN:|34-getter|3|
        return addHighScoreTask;
    }
    //</editor-fold>//GEN-END:|34-getter|3|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: formUserAndScore ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of formUserAndScore component.
     * @return the initialized component instance
     */
    public Form getFormUserAndScore() {
        if (formUserAndScore == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            formUserAndScore = new Form("Add Your Name to High Scores", new Item[] { getNameTextField(), getScoreTextField() });//GEN-BEGIN:|36-getter|1|36-postInit
            formUserAndScore.addCommand(getOkCommand1());
            formUserAndScore.addCommand(getCancelCommand());
            formUserAndScore.setCommandListener(this);//GEN-END:|36-getter|1|36-postInit
        // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return formUserAndScore;
    }
    //</editor-fold>//GEN-END:|36-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|39-getter|0|39-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|39-getter|0|39-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|39-getter|1|39-postInit
        // write post-init user code here
        }//GEN-BEGIN:|39-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|39-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of cancelCommand component.
     * @return the initialized component instance
     */
    public Command getCancelCommand() {
        if (cancelCommand == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|41-getter|1|41-postInit
        // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return cancelCommand;
    }
    //</editor-fold>//GEN-END:|41-getter|2|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: nameTextField ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of nameTextField component.
     * @return the initialized component instance
     */
    public TextField getNameTextField() {
        if (nameTextField == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            nameTextField = new TextField("Username", null, 10, TextField.ANY);//GEN-LINE:|51-getter|1|51-postInit
        // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return nameTextField;
    }
    //</editor-fold>//GEN-END:|51-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            alert = new Alert("alert", "Cannot connect to the server.", null, null);//GEN-BEGIN:|62-getter|1|62-postInit
            alert.setTimeout(Alert.FOREVER);//GEN-END:|62-getter|1|62-postInit
        // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|62-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgSplashScreenAbout ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initiliazed instance of svgSplashScreenAbout component.
     * @return the initialized component instance
     */
    public SVGSplashScreen getSvgSplashScreenAbout() {
        if (svgSplashScreenAbout == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            svgSplashScreenAbout = new SVGSplashScreen(getSvgAboutImage(), getDisplay());//GEN-BEGIN:|67-getter|1|67-postInit
            svgSplashScreenAbout.setTitle("");
            svgSplashScreenAbout.setCommandListener(this);
            svgSplashScreenAbout.setTimeout(7000);//GEN-END:|67-getter|1|67-postInit
        // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return svgSplashScreenAbout;
    }
    //</editor-fold>//GEN-END:|67-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgAboutImage ">//GEN-BEGIN:|69-getter|0|69-preInit
    /**
     * Returns an initiliazed instance of svgAboutImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgAboutImage() {
        if (svgAboutImage == null) {//GEN-END:|69-getter|0|69-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|69-getter|1|69-@java.io.IOException
                svgAboutImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/about.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|69-getter|1|69-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|69-getter|2|69-postInit
        // write post-init user code here
        }//GEN-BEGIN:|69-getter|3|
        return svgAboutImage;
    }
    //</editor-fold>//GEN-END:|69-getter|3|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgNewScoreWaitScreen ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of svgNewScoreWaitScreen component.
     * @return the initialized component instance
     */
    public SVGWaitScreen getSvgNewScoreWaitScreen() {
        if (svgNewScoreWaitScreen == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            svgNewScoreWaitScreen = new SVGWaitScreen(getSvgWaitImage(), getDisplay());//GEN-BEGIN:|76-getter|1|76-postInit
            svgNewScoreWaitScreen.setTitle("");
            svgNewScoreWaitScreen.setCommandListener(this);
            svgNewScoreWaitScreen.setFullScreenMode(true);
            svgNewScoreWaitScreen.setTask(getAddHighScoreTask());//GEN-END:|76-getter|1|76-postInit
            // write post-init user code here
            System.out.println("getSvgNewScoreWaitScreen");
        }//GEN-BEGIN:|76-getter|2|
        return svgNewScoreWaitScreen;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgScoresTable ">//GEN-BEGIN:|80-getter|0|80-preInit
    /**
     * Returns an initiliazed instance of svgScoresTable component.
     * @return the initialized component instance
     */
    public SVGSplashScreen getSvgScoresTable() {
        if (svgScoresTable == null) {//GEN-END:|80-getter|0|80-preInit
            // write pre-init user code here
            svgScoresTable = new SVGSplashScreen(getSvgScoresImage(), getDisplay());//GEN-BEGIN:|80-getter|1|80-postInit
            svgScoresTable.setTitle("");
            svgScoresTable.setCommandListener(this);
            svgScoresTable.setFullScreenMode(true);
            svgScoresTable.setTimeout(-1);//GEN-END:|80-getter|1|80-postInit
        // write post-init user code here
        }//GEN-BEGIN:|80-getter|2|
        return svgScoresTable;
    }
    //</editor-fold>//GEN-END:|80-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand2 ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initiliazed instance of okCommand2 component.
     * @return the initialized component instance
     */
    public Command getOkCommand2() {
        if (okCommand2 == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            okCommand2 = new Command("Ok", Command.OK, 0);//GEN-LINE:|82-getter|1|82-postInit
        // write post-init user code here
        }//GEN-BEGIN:|82-getter|2|
        return okCommand2;
    }
    //</editor-fold>//GEN-END:|82-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: highScoresTask ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initiliazed instance of highScoresTask component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getHighScoresTask() {
        if (highScoresTask == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            highScoresTask = new SimpleCancellableTask();//GEN-BEGIN:|79-getter|1|79-execute
            highScoresTask.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|79-getter|1|79-execute
                    // write task-execution user code here
//#if (ONLINE == "true")
//#                    //TODO: [Exercise 4][step 3] get High Scores                  
//#                    //connect to WS and get the latest scores
//#                    //update the high score table
//#else 
                    //this code is used when the ONLINE ability value isn't true
                    //nothing to do. The high scores are in the highScoresValues array already
                    Thread.sleep(10);                    
//#endif

                }//GEN-BEGIN:|79-getter|2|79-postInit
            });//GEN-END:|79-getter|2|79-postInit
        // write post-init user code here
        }//GEN-BEGIN:|79-getter|3|
        return highScoresTask;
    }
    //</editor-fold>//GEN-END:|79-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: svgScoresImage ">//GEN-BEGIN:|88-getter|0|88-preInit
    /**
     * Returns an initiliazed instance of svgScoresImage component.
     * @return the initialized component instance
     */
    public SVGImage getSvgScoresImage() {
        if (svgScoresImage == null) {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|88-getter|1|88-@java.io.IOException
                svgScoresImage = (SVGImage) SVGImage.createImage(getClass().getResourceAsStream("/scoreTable.svg"), null);
            } catch (java.io.IOException e) {//GEN-END:|88-getter|1|88-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|88-getter|2|88-postInit
        // write post-init user code here
        }//GEN-BEGIN:|88-getter|3|
        return svgScoresImage;
    }
    //</editor-fold>//GEN-END:|88-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: scoreTextField ">//GEN-BEGIN:|90-getter|0|90-preInit
    /**
     * Returns an initiliazed instance of scoreTextField component.
     * @return the initialized component instance
     */
    public TextField getScoreTextField() {
        if (scoreTextField == null) {//GEN-END:|90-getter|0|90-preInit
            // write pre-init user code here
            scoreTextField = new TextField("Your Score is", null, 32, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|90-getter|1|90-postInit
        // write post-init user code here
        }//GEN-BEGIN:|90-getter|2|
        return scoreTextField;
    }
    //</editor-fold>//GEN-END:|90-getter|2|
    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {

            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    /**
     * Converts an exception to a message and displays 
     * the message..
     */
    public void errorMsg(Exception e) {
        e.printStackTrace();
        if (e.getMessage() == null) {
            getAlert().setString(e.getClass().getName());
            switchDisplayable(getAlert(), getSvgMainMenu().getSvgCanvas());
            alert = null;
        } else {
            getAlert().setString(e.getClass().getName() + ":" + e.getMessage());
            switchDisplayable(getAlert(), getSvgMainMenu().getSvgCanvas());
            alert = null;
        }
    }

    /**
     * set all the things up when the game is over
     * @param score
     */
    public void gameOver(int score) {

        lastHighScore = score;
        getScoreTextField().setString(Integer.toString(score));
        if (myGameThread != null) {
            myGameThread.requestStop();//pause();
        }
    }

    /**
     * updates the svg score table image with the high scores
     * TODO: this can be achieved by the databinding 
     */
    protected void updateSvgWithHighScores() {
        for (int i = 0; i < highScoreNames.length; i++) {
            getSvgScoresTable().setTraitSafely("Name" + (i + 1), "#text", highScoreNames[i]);
            getSvgScoresTable().setTraitSafely("Score" + (i + 1), "#text", Integer.toString(highScoreValues[i]));

        }
    }
    /////////
    private final int HIGH_SCORES = 9;
    private String[] highScoreNames = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    private int[] highScoreValues = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int lastHighScore = 0;

    /**
     * can the high score be add to the high score table?
     * @return
     */
    protected boolean isLastScoreHighEnough() {
        if (lastHighScore > highScoreValues[highScoreValues.length - 1]) {
            return true;
        }
        return false;
    }

    /**
     * this method is used only when the game is in OFFLINE mode (ONLINE == false)
     * adds the high score to high score table
     * @param newScore value
     * @param playerName
     */
    public void addScoreToScoreTable(int newScore, String playerName) {
        int buble = newScore;
        String bubleName = playerName;
        //this is simple buble sort
        for (int i = 0; i < highScoreValues.length; i++) {
            if (highScoreValues[i] == 0) {
                highScoreNames[i] = bubleName;
                highScoreValues[i] = buble;
                break; //we expect that the rest are nulls
            }
            if (buble < highScoreValues[i]) {
                int temp = highScoreValues[i];
                String tempName = highScoreNames[i];
                highScoreValues[i] = buble;
                highScoreNames[i] = bubleName;
                buble = temp;
                bubleName = tempName;
            }
        }
    }
    
     /**
     * this method is used only when the game is in ONLINE mode (ONLINE == true)
     * updates the high score table with data from the web service
     * @param scores 
     */
    void updateHighScoresTable(String [] scores) {
        for (int i = 0; i < scores.length; i++) {
            int split = scores[i].indexOf(':');
            highScoreNames[i] = scores[i].substring(0, split);
            highScoreValues[i] = Integer.parseInt(scores[i].substring(split + 1, scores[i].length()));                    
        }
    }
    
    
    //TODO: [Exercise 4][step 3] add the getMobileClient() method
}
