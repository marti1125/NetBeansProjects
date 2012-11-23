/*
 * Copyright (c) 2008, Lukas Hasik, Sun Microsystems, Inc.
 * Copyright (c) 2007, Carol Hamer, Apress
 * 
 * The source code is based on sample code from Carol Hamer's book 
 * "Creating Mobile Games: Using Java ME Platform to Put the Fun 
 * into Your Mobile Device and Cell Phone" published by Apress
 * Book info at http://apress.com/book/view/1590598806
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

import java.io.IOException;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import org.netbeans.j1.game.logic.MazeManager;

/**
 * This class is the display of the game.
 * 
 * @author Carol Hamer, Lukas Hasik
 */
public class MazeCanvas extends GameCanvas
        implements CommandListener {

    //---------------------------------------------------------
    //   dimension fields
    //  (constant after initialization)
    /**
     * the top corner x coordinate according to this 
     * object's coordinate system:.
     */
    static int CORNER_X = 0;
    /**
     * the top corner y coordinate according to this 
     * object's coordinate system:.
     */
    static int CORNER_Y = 0;
    /**
     * the width of the portion of the screen that this 
     * canvas can use.
     */
    static int DISP_WIDTH;
    /**
     * the height of the portion of the screen that this 
     * canvas can use.
     */
    static int DISP_HEIGHT;
    /**
     * the height of the font used for this game.
     */
    static int FONT_HEIGHT;
    /**
     * the font used for this game.
     */
    static Font FONT;
    /**
     * color constant
     */
    public static final int BLACK = 0;
    /**
     * color constant
     */
    public static final int WHITE = 0xffffffff;
    /**
     * color constant
     */
    public static final int OPAQUE_BLACK = 0xff000000;
    /**
     * color constant
     */
    public static final int OPAQUE_BLUE = 0xff0000ff;

    //---------------------------------------------------------
    //   game object fields
    /**
     * a handle to the display.
     */
    Display myDisplay;
    /**
     * a handle to the MIDlet object (to keep track of buttons).
     */
    GameMIDlet myDungeon;
    /**
     * the LayerManager that handles the game graphics.
     */
    MazeManager myManager;
    /**
     * whether or not the game has ended.
     */
    static boolean myGameOver;
    /**
     * the number of game ticks that have passed since the 
     * beginning of the game.
     */
    int myGameTicks = 0;
    /**
     * The button to exit the game.
     */
    Command myExitCommand;
    /**
     * The button to display the command menu.
     */
    Command myMenuCommand;
    /**
     * The button to go to the next board.
     */
    Command myOkCommand;

    //---------------------------------------------------------
    //   menu-related fields
    /**
     * Whether the menu is currently displayed.
     */
    boolean myMenuMode;
    /**
     * The index (in the menu vector) of the currently focused
     * command.
     */
    int myFocusedIndex;

    //-----------------------------------------------------
    //    gets/sets
    /**
     * This is called when the game ends.
     */
    public void setGameOver() {
        myGameOver = true;
        myDungeon.gameOver(myGameTicks);
    }

    /**
     * Get the MazeManager.
     */
    public MazeManager getManager() {
        return myManager;
    }

    /**
     * Find out if the game has ended.
     */
    static boolean getGameOver() {
        return (myGameOver);
    }


    //-----------------------------------------------------
    //    initialization and game state changes
    /**
     * Constructor sets the data, performs dimension calculations, 
     * and creates the graphical objects.
     * @param midlet 
     */
    public MazeCanvas(GameMIDlet midlet) {
        super(false);
        myDisplay = Display.getDisplay(midlet);
        myDungeon = midlet;
        // calculate the dimensions based on the full screen
        setFullScreenMode(true);
        DISP_WIDTH = getWidth();
        DISP_HEIGHT = getHeight();
        // create the LayerManager (where all of the interesting 
        // graphics go!) and give it the dimensions of the 
        // region it is supposed to paint:
        if (myManager == null) {
            myManager = new MazeManager(CORNER_X, CORNER_Y, DISP_WIDTH, DISP_HEIGHT, this);
        }
    }

    /**
     * Once the customizer has been initialized, this 
     * method loads and initializes the graphical objects 
     * for the timer.  
     * @throws java.io.IOException 
     */
    public void start() throws IOException {
        myGameOver = false;
        myGameTicks = 0;
        // Now that the timer and softkeys are ready, 
        // this screen can be displayed (since the menu is 
        // not shown initially)
        myDisplay.setCurrent(this);

    }

    /**
     * sets all variables back to their initial positions.
     */
    public void reset() {
        // most of the variables that need to be reset 
        // are held by the LayerManager:
        myManager.reset();
        myGameOver = false;
    }

    /**
     * clears the key states.
     */
    public void flushKeys() {
        getKeyStates();
    }

    /**
     * If the game is hidden by another app (or a menu)
     * ignore it since not much happens in this game 
     * when the user is not actively interacting with it.
     */
    protected void hideNotify() {
    }

    /**
     * There's nothing to do when it comes back into 
     * view either.
     */
    protected void showNotify() {
    }

    //-------------------------------------------------------
    //  graphics methods
    /**
     * paint the game graphics on the screen.
     * @param g 
     */
    public void paint(Graphics g) {
        // The LayerManager paints the 
        // interesting part of the graphics:
        try {
            myManager.paint(g);
        } catch (Exception e) {
            myDungeon.errorMsg(e);
            return;
        }
        // the timer is painted on top of 
        // the game graphics. 
        g.setColor(BLACK);
        g.fillRect(0, 0, getWidth(), 15);
        g.setColor(WHITE);
        g.drawString(String.valueOf(myGameTicks), getWidth(), 0, Graphics.TOP | Graphics.RIGHT);
        g.drawString("Time: ", getWidth() - 30, 0, Graphics.TOP | Graphics.RIGHT);
        g.drawString("Look for James", 0, 0, Graphics.TOP | Graphics.LEFT);

        //when the game is over show it on the screen
        if (myGameOver) {
            g.setColor(OPAQUE_BLUE);
            g.fillRect(DISP_WIDTH/2 - DISP_WIDTH/3, DISP_HEIGHT/2 - DISP_HEIGHT/4, DISP_WIDTH*2/3, DISP_HEIGHT/2);
            g.setColor(WHITE);
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.drawString("GAME OVER", DISP_WIDTH/2, DISP_HEIGHT/2 - 20, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("Your score is " + myGameTicks, DISP_WIDTH/2, DISP_HEIGHT/2, Graphics.HCENTER | Graphics.BOTTOM);
            g.drawString("Press any key", DISP_WIDTH/2, DISP_HEIGHT/2 + 30, Graphics.HCENTER | Graphics.BOTTOM);
        }
    }


    //-------------------------------------------------------
    //  game movements and commands
    /**
     * update the display.
     */
    public void updateScreen() {
        // paint the display:
        try {
            paint(getGraphics());
            flushGraphics(CORNER_X, CORNER_Y, DISP_WIDTH, DISP_HEIGHT);
        } catch (Exception e) {
            myDungeon.errorMsg(e);
        }
        myGameTicks++;
    }

    /**
     * Respond to keystrokes.
     */
    public void checkKeys() {
        if (!myGameOver) {
            // determine which moves the user would like to make:
            int keyState = getKeyStates();
            int vertical = 0;
            int horizontal = 0;
            if ((keyState & LEFT_PRESSED) != 0) {
                horizontal = -1;
            }
            if ((keyState & RIGHT_PRESSED) != 0) {
                horizontal = 1;
            }
            if ((keyState & UP_PRESSED) != 0) {
                vertical = -1;
            }
            if ((keyState & DOWN_PRESSED) != 0) {
            //nothing happens
            }
            // tell the manager to move the duke 
            // accordingly if possible:
            myManager.requestMove(horizontal, vertical);
        } 
    }

    public void commandAction(Command arg0, Displayable arg1) {

    }

    /**
     * Respond to softkeys.
     * The keystates value won't give information 
     * about softkeys, so the keypressed method
     * must be implemented separately:
     */
    public void keyPressed(int keyCode) {
        //when the game is over
        if (myGameOver) {
            try {
                reset();
                flushKeys();   
                //switch to the screen where user can enter the high score
                myDungeon.switchDisplayable(null, myDungeon.getFormUserAndScore());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
