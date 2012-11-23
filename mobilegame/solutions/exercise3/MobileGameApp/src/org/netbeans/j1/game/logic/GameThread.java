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

package org.netbeans.j1.game.logic;

import org.netbeans.j1.game.GameMIDlet;
import org.netbeans.j1.game.MazeCanvas;


/**
 * This class contains the loop that keeps the game running.
 *
 * @author Carol Hamer, Lukas Hasik
 */
public class GameThread extends Thread {

  //---------------------------------------------------------
  //   fields

  /**
   * Whether or not the main thread would like this thread 
   * to pause.
   */
  boolean myShouldPause;

  /**
   * Whether or not the main thread would like this thread 
   * to stop.
   */
  static boolean myShouldStop;

  /**
   * A handle back to the splashscreen.
   */


  /**
   * A handle back to the graphical components.
   */
  MazeCanvas myDungeonCanvas;

  /**
   * A handle back to the midlet object.
   */
  GameMIDlet myDungeon;

  /**
   * The System.time of the last screen refresh, used 
   * to regulate refresh speed.
   */
  private long myLastRefreshTime;

  /**
   * The minimum amount of time to wait between frames.
   */
  private static long MIN_WAIT = 100; 

  //----------------------------------------------------------
  //   initialization

  /**
   * standard constructor.
   */
  public GameThread(MazeCanvas canvas, 
      GameMIDlet dungeon) {
    myDungeonCanvas = canvas;
    myDungeon = dungeon;
  }

  //----------------------------------------------------------
  //   utilities

  /**
   * Get the amount of time to wait between screen refreshes.
   * Normally we wait only a single millisecond just to give 
   * the main thread a chance to update the keystroke info, 
   * but this method ensures that the game will not attempt 
   * to show more than 20 frames per second.
   */
  private long getWaitTime() {
    long retVal = 1;
    long difference = System.currentTimeMillis() - myLastRefreshTime;
    if(difference < MIN_WAIT) {
      retVal = MIN_WAIT - difference;
    }
    return(retVal);
  }

  //----------------------------------------------------------
  //   actions

  /**
   * pause the game.
   */
  public void pause() {
    myShouldPause = true;
  }

  /**
   * restart the game after a pause.
   */
  synchronized void resumeGame() {
    myShouldPause = false;
    notify();
  }

  /**
   * stops the game.
   */
  public synchronized void requestStop() {
    myShouldStop = true;
    this.notify();
  }

  /**
   * start the game..
   */
  public void run() {
    try {
      // first initialize the custom data
      myDungeonCanvas.getManager().init();

    } catch(Exception e) {
      myDungeon.errorMsg(e);
    }

    // the actual game begins
    // flush any keystrokes that occurred before the 
    // game started:
    try {
      myDungeonCanvas.start();
    } catch(Exception e) {
      myDungeon.errorMsg(e);
    }
    myDungeonCanvas.flushKeys();
    myShouldStop = false;
    myShouldPause = false;
    // this is the main animation loop of the 
    // game which advances the animation 
    // and checks for keystrokes:
    while(true) {
      if(myShouldStop) {
        break;
      }
      myLastRefreshTime = System.currentTimeMillis();
      myDungeonCanvas.checkKeys();
      myDungeonCanvas.updateScreen();
      // pause to make sure not more than 20 frames 
      // per second are shown:
      synchronized(this) {
        try {
          wait(getWaitTime());
        } catch(Exception e) {}
      }
      // don't advance while the game is paused:
      if(myShouldPause) {
        synchronized(this) {
          try {
            wait();
          } catch(Exception e) {}
        }
      }
    }
  }

}
