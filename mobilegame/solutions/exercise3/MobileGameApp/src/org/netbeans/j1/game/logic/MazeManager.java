/*
 * Copyright (c) 2008, Lukas Hasik, Sun Microsystems, Inc.
 * Copyright (c) 2007, Carol Hamer, Apress
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
package org.netbeans.j1.game.logic;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;
import org.netbeans.j1.game.MazeCanvas;
import org.netbeans.j1.game.MazeGameDesign;


/**
 * 
 * @author Carol Hamer, Lukas Hasik
 */
public class MazeManager extends LayerManager {

    //---------------------------------------------------------
    //   dimension fields
    //  (constant after initialization)
    /**
     * The x-coordinate of the place on the game canvas where 
     * the LayerManager window should appear, in terms of the 
     * coordiantes of the game canvas.
     */
    static int CANVAS_X;
    /**
     * The y-coordinate of the place on the game canvas where 
     * the LayerManager window should appear, in terms of the 
     * coordiantes of the game canvas.
     */
    static int CANVAS_Y;
    /**
     * The width of the display window.
     */
    static int DISP_WIDTH;
    /**
     * The height of this object's visible region. 
     */
    static int DISP_HEIGHT;
    /**
     * the (right or left) distance the player 
     * goes in a single keystroke.
     */
    static int MOVE_LENGTH = 6;
    /**
     * the minimum (right or left) distance the player 
     * must stay away from the walls (to avoid getting 
     * stuck when the sprite image changes).
     */
    static int MOVE_BUFFER = 4;
    /**
     * The width of the square tiles that this game is divided into.
     * This is the width of the stone walls as well as the duke.
     */
    static int SQUARE_WIDTH = 32; //64
    /**
     * The number of background tiles per row.
     */
    static int BACK_TILES;
    /**
     * A constant number of pixels to use in calculating the 
     * height of a jump.
     */
    static int JUMP_INT = 2;
    /**
     * A constant number of pixels to use in calculating the 
     * height of a jump.
     */
    static int JUMP_FRAC_NUM = 1;
    /**
     * A constant number of pixels to use in calculating the 
     * height of a jump.
     */
    static int JUMP_FRAC_DENOM = 2;
    /**
     * The jump index that indicates that no jump is 
     * currently in progress..
     */
    static final int NO_JUMP = -6;
    /**
     * The maximum speed for the player's fall.
     */
    static final int MAX_FREE_FALL = 3;
    /**
     * The maximum horizontal running speed.
     */
    static final int MAX_SPEED = 3;

    //---------------------------------------------------------
    //   game object fields
    /**
     * the handle back to the canvas.
     */
    MazeCanvas myCanvas;
    /**
     * the walls of the dungeon.
     */
    TiledLayer myWalls;
    /**
     * the tiled layer that goes behind the walls.
     */
    TiledLayer myBackground;
    /**
     * the player.
     */
    Sprite dukeSprite;
    /**
     * The leftmost x-coordinate that should be visible on the 
     * screen in terms of this objects internal coordinates.
     */
    int myViewWindowX;
    /**
     * The top y-coordinate that should be visible on the 
     * screen in terms of this objects internal coordinates.
     */
    int myViewWindowY;
    /**
     * Where the duke is in the jump sequence.
     */
    int myIsJumping = NO_JUMP;
    /**
     * Where the duke is moving horizontally.
     */
    int myIsRunning = 0;
    /**
     * James Goslings sprite
     */
    private Sprite jamesSprite;
    /**
     * remember the latest directions
     */
    private int lastVertDirection = 0;
    private int lastHorDirection = 0;
    /**
     *  animate the duke sprite
     */
    private MazeManager.SpriteAnimationTask dukeSpriteAnimator;
    /*
     * 
     */
    private Timer timer;
    private MazeGameDesign mazeDesign;

//TODO:    private MazeDesign mazeDesign;
    //-----------------------------------------------------
    //    initialization
    //    set up or save game data.
    /**
     * Constructor merely sets the data.
     * @param x The x-coordinate of the place on the game canvas where 
     * the LayerManager window should appear, in terms of the 
     * coordiantes of the game canvas.
     * @param y The y-coordinate of the place on the game canvas where 
     * the LayerManager window should appear, in terms of the 
     * coordiantes of the game canvas.
     * @param width the width of the region that is to be 
     * occupied by the LayoutManager.
     * @param height the height of the region that is to be 
     * occupied by the LayoutManager.
     * @param customizer the object that loads the correct 
     * custom data for the current platform.
     * @param canvas the MazeCanvas that this LayerManager 
     * should appear on.
     */
    public MazeManager(int x, int y, int width, int height, MazeCanvas canvas) {
        myCanvas = canvas;
        CANVAS_X = x;
        CANVAS_Y = y;
        DISP_WIDTH = width;
        DISP_HEIGHT = height;
    }

    /**
     * Set up all of the data.
     * 
     * This is called from a separate init method in order
     * to limit the amount of resource loading that is done 
     * by the thread that called the startApp method.
     */
    public void init() throws Exception {
        mazeDesign = new MazeGameDesign(); //ex3
        jamesSprite = mazeDesign.getJamesS();//ex3
        dukeSprite = mazeDesign.getDukeS();//ex3
        dukeSprite.defineReferencePixel(dukeSprite.getWidth() / 2, 0);//ex3
        dukeSpriteAnimator = new SpriteAnimationTask(dukeSprite, false);
        myWalls = mazeDesign.getMaze1();//ex3
        mazeDesign.updateLayerManagerForLevel1(this);//ex3

        timer = new Timer();
        timer.scheduleAtFixedRate(dukeSpriteAnimator, 0, mazeDesign.dukeSseq001Delay);
        // this sets the view screen so that the player is 
        // in the center.
        myViewWindowX = dukeSprite.getX() - ((DISP_HEIGHT - SQUARE_WIDTH) / 2);
        myViewWindowY = dukeSprite.getY() - ((DISP_HEIGHT - SQUARE_WIDTH) / 2);

        System.gc();
    }

    /**
     * sets all variables back to their initial positions.
     */
    public void reset() {
        remove(jamesSprite);
        remove(dukeSprite);
        remove(myWalls);
        dukeSpriteAnimator.cancel();//stop the duke animator
        
        lastVertDirection = 0;
        lastHorDirection = 0;
        myIsRunning = 0;
        myIsJumping = NO_JUMP;
        
        System.gc();
    }

    //-------------------------------------------------------
    //  graphics methods
    /**
     * paint the game graphic on the screen.
     */
    public void paint(Graphics g) throws Exception {
        g.setColor(MazeCanvas.WHITE);
        // paint the background white to cover old game objects
        // that have changed position since last paint.
        // here coordinates are given 
        // with respect to the graphics (canvas) origin:
        g.fillRect(0, 0, DISP_WIDTH, DISP_HEIGHT);
        // here coordinates are given 
        // with respect to the LayerManager origin:
        setViewWindow(myViewWindowX, myViewWindowY, DISP_WIDTH, DISP_HEIGHT);
        // call the paint funstion of the superclass LayerManager
        // to paint all of the Layers
        paint(g, CANVAS_X, CANVAS_Y);
    }

    //-------------------------------------------------------
    //  game movements
    /**
     * respond to keystrokes by deciding where to move 
     * and then moving the pieces and the view window correspondingly.
     */
    public void requestMove(int hdirection, int vdirection) {
        // vdirection < 0 indicates that the user has 
        // pressed the UP button and would like to jump.
        // therefore, if we're not currently jumping, 
        // we begin the jump.
        if ((myIsJumping == NO_JUMP) && (vdirection < 0)) {
            myIsJumping++;
        } else if (myIsJumping == NO_JUMP) {
            // if we're not jumping at all, we need to check 
            // if the duke should be falling:  
            // we (temporarily) move the duke down and see if that 
            // causes a collision with the floor:
            dukeSprite.move(0, 1);
            // if the duke can move down without colliding 
            // with the floor, then we set the duke to 
            // be falling.  The variable myIsJumping starts 
            // negative while the duke is jumping up and 
            // is zero or positive when the duke is coming 
            // back down.  We therefore set myIsJumping to 
            // zero to indicate that the duke should start 
            // falling.
            if (!checkCollision()) {
                myIsJumping = 0;
            }
            // we move the duke Sprite back to the correct 
            // position she was at before we (temporarily) moved 
            // her down to see if she would fall.
            dukeSprite.move(0, -1);
        }
        // if the duke is currently jumping or falling, 
        // advance the jump (change the vertical distance
        // the duke is supposed to move)
        if ((myIsJumping <= MAX_FREE_FALL) && (myIsJumping != NO_JUMP)) {
            myIsJumping++;
        }
        // also accellerate the horizontal motion if the duke
        // runs runs in the same horizontal direction for more than 
        // one game tick:
        myIsRunning++;
        // But don't accellerate past the maximum speed:
        if (myIsRunning > MAX_SPEED) {
            myIsRunning = MAX_SPEED;
        }
        int horizontal = MOVE_LENGTH * myIsRunning;
        // if the duke is currently jumping or falling, 
        // we calculate the vertical distance she should move.
        // This is a parabola given by y = (x*x) * (a + b/c)
        // where x is how far we have advanced in the jump 
        // or fall (myIsJumping), and a, b, and c are constants
        // based on the screen size. (The actual values are
        // read from a properties file and were originally 
        // computed through trial and error.)
        int vertical = 0;
        if (myIsJumping != NO_JUMP) {
            vertical = myIsJumping * myIsJumping * JUMP_INT + (myIsJumping * myIsJumping * JUMP_FRAC_NUM) / JUMP_FRAC_DENOM;
            // for the first half of the jump we go up, 
            // then for the second half go down:
            if (myIsJumping < 0) {
                vdirection = -1;
            } else {
                vdirection = 1;
            }
        }
        // set the sprite to the correct frame based 
        // on the duke's current motion:
        updateSprite(hdirection, vdirection);
        boolean vcrash = false;
        boolean hcrash = false;
        // now calculate the motion one pixel at a time
        // (vertically then horizontally) to see precisely
        // how far the duke can move in each of the
        // requested directions:
        while ((vertical >= 1 && !vcrash) || (horizontal >= 1 && !hcrash)) {
            dukeSprite.move(0, vdirection);
            if (checkCollision()) {
                dukeSprite.move(0, -vdirection);
                vcrash = true;
            } else {
                vertical -= 1;
                vcrash = false;
                myViewWindowY += vdirection;
            }
            dukeSprite.move(MOVE_BUFFER * hdirection, 0);
            if (checkCollision()) {
                dukeSprite.move(-MOVE_BUFFER * hdirection, 0);
                hcrash = true;
            } else {
                dukeSprite.move(-MOVE_BUFFER * hdirection, 0);
                dukeSprite.move(hdirection, 0);
                horizontal -= 1;
                hcrash = false;
                myViewWindowX += hdirection;
            }
        }
        // If the duke is blocked vertically,
        // then the jump or fall in progress stops:
        if (vcrash) {
            myIsJumping = NO_JUMP;
        }
        // If the duke is blocked horizontally,
        // forget any horizontal accelleration:
        if (hcrash) {
            myIsRunning = 0;
        }

        if (dukeSprite.collidesWith(jamesSprite, true)) {
            myCanvas.setGameOver();
            return;
        }
    }

    /**
     * Internal to requestMove.  Set the duke sprite 
     * to the correct frame depending on her movements..
     */
    private void updateSprite(int hdirection, int vdirection) {
        // if the duke is moving left or right, we set 
        // his image to be facing the right direction:



        if (hdirection > 0) {
            dukeSprite.setTransform(Sprite.TRANS_NONE);
        } else if (hdirection < 0) {
            dukeSprite.setTransform(Sprite.TRANS_MIRROR);
        }

        //in case that duke is moving, change the showing sprite image
        if (lastHorDirection != hdirection) {
            dukeSprite.setFrameSequence(mazeDesign.dukeSseq001); //TODO: [Exercise 3] set to vertical sequence
        }

        if (lastVertDirection != vdirection) {
            if (vdirection > 0) { //he's jumping


                dukeSprite.setFrameSequence(mazeDesign.dukeSfalling);//TODO: [Exercise 3] set to falling sequence
            } else if (vdirection < 0) {

                dukeSprite.setFrameSequence(mazeDesign.dukeSjumping);//TODO: [Exercise 3] set to jumping sequence
            }
        }

        if ((vdirection != 0) || (hdirection != 0)) {
            dukeSpriteAnimator.forward();


        } else {
            dukeSpriteAnimator.setMoving(false);
            dukeSprite.setFrameSequence(mazeDesign.dukeSseq001); //TODO: [Exercise 3] set to vertical sequence

        }

        lastHorDirection = hdirection;
        lastVertDirection = vdirection;

    }

    //-------------------------------------------------------
    //  sprite interactions
    /**
     * Checks of the player hits a stone wall or a door.
     */
    boolean checkCollision() {

        return dukeSprite.collidesWith(myWalls, true);
    }

    /**
     * Animates a sprite.
     */
    private class SpriteAnimationTask extends TimerTask {

        private boolean moving = false;
        private boolean forward = true;
        private Sprite sprite;

        public SpriteAnimationTask(Sprite sprite, boolean forward) {
            this.sprite = sprite;
            this.forward = forward;
        }

        public void run() {
            if (!this.moving) {
                return;
            }
            if (this.forward) {
                this.sprite.nextFrame();
            } else {
                this.sprite.prevFrame();
            }
        }

        public void forward() {
            this.forward = true;
            this.moving = true;
        }

        public void backward() {
            this.forward = false;
            this.moving = true;
        }

        public void setMoving(boolean isMoving) {
            this.moving = isMoving;
        }
    }
}
