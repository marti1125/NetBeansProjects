/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.j1.game;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.IOException;

/**
 * @author Lukas
 */
public class MazeGameDesign {

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Image duke;
    private Sprite dukeS;
    public int dukeSseq001Delay = 200;
    public int[] dukeSseq001 = {0, 1, 0, 2};
    public int dukeSfallingDelay = 200;
    public int[] dukeSfalling = {3, 4};
    public int dukeSjumpingDelay = 200;
    public int[] dukeSjumping = {5};
    private Image bigG;
    private Sprite jamesS;
    public int jamesSseq001Delay = 200;
    public int[] jamesSseq001 = {0, 1, 2, 2, 3};
    private Image wall;
    private TiledLayer maze1;
    //</editor-fold>//GEN-END:|fields|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    public Image getDuke() throws java.io.IOException {//GEN-BEGIN:|1-getter|0|1-preInit
        if (duke == null) {//GEN-END:|1-getter|0|1-preInit
            // write pre-init user code here
            duke = Image.createImage("/duke.png");//GEN-BEGIN:|1-getter|1|1-postInit
        }//GEN-END:|1-getter|1|1-postInit
        // write post-init user code here
        return this.duke;//GEN-BEGIN:|1-getter|2|
    }
//GEN-END:|1-getter|2|

    public Sprite getDukeS() throws java.io.IOException {//GEN-BEGIN:|2-getter|0|2-preInit
        if (dukeS == null) {//GEN-END:|2-getter|0|2-preInit
            // write pre-init user code here
            dukeS = new Sprite(getDuke(), 25, 25);//GEN-BEGIN:|2-getter|1|2-postInit
            dukeS.setFrameSequence(dukeSseq001);//GEN-END:|2-getter|1|2-postInit
            // write post-init user code here
        }//GEN-BEGIN:|2-getter|2|
        return dukeS;
    }
//GEN-END:|2-getter|2|

    public Image getBigG() throws java.io.IOException {//GEN-BEGIN:|4-getter|0|4-preInit
        if (bigG == null) {//GEN-END:|4-getter|0|4-preInit
            // write pre-init user code here
            bigG = Image.createImage("/bigG.png");//GEN-BEGIN:|4-getter|1|4-postInit
        }//GEN-END:|4-getter|1|4-postInit
        // write post-init user code here
        return this.bigG;//GEN-BEGIN:|4-getter|2|
    }
//GEN-END:|4-getter|2|

    public Sprite getJamesS() throws java.io.IOException {//GEN-BEGIN:|5-getter|0|5-preInit
        if (jamesS == null) {//GEN-END:|5-getter|0|5-preInit
            // write pre-init user code here
            jamesS = new Sprite(getBigG(), 23, 32);//GEN-BEGIN:|5-getter|1|5-postInit
            jamesS.setFrameSequence(jamesSseq001);//GEN-END:|5-getter|1|5-postInit
            // write post-init user code here
        }//GEN-BEGIN:|5-getter|2|
        return jamesS;
    }
//GEN-END:|5-getter|2|

    public Image getWall() throws java.io.IOException {//GEN-BEGIN:|9-getter|0|9-preInit
        if (wall == null) {//GEN-END:|9-getter|0|9-preInit
            // write pre-init user code here
            wall = Image.createImage("/wall.png");//GEN-BEGIN:|9-getter|1|9-postInit
        }//GEN-END:|9-getter|1|9-postInit
        // write post-init user code here
        return this.wall;//GEN-BEGIN:|9-getter|2|
    }
//GEN-END:|9-getter|2|

    public TiledLayer getMaze1() throws java.io.IOException {//GEN-BEGIN:|10-getter|0|10-preInit
        if (maze1 == null) {//GEN-END:|10-getter|0|10-preInit
            // write pre-init user code here
            maze1 = new TiledLayer(10, 10, getWall(), 32, 32);//GEN-BEGIN:|10-getter|1|10-midInit
            int[][] tiles = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
            };//GEN-END:|10-getter|1|10-midInit
            // write mid-init user code here
            for (int row = 0; row < 10; row++) {//GEN-BEGIN:|10-getter|2|10-postInit
                for (int col = 0; col < 10; col++) {
                    maze1.setCell(col, row, tiles[row][col]);
                }
            }
        }//GEN-END:|10-getter|2|10-postInit
        // write post-init user code here
        return maze1;//GEN-BEGIN:|10-getter|3|
    }
//GEN-END:|10-getter|3|

    public void updateLayerManagerForLevel1(LayerManager lm) throws java.io.IOException {//GEN-LINE:|11-updateLayerManager|0|11-preUpdate
        // write pre-update user code here
        getJamesS().setPosition(203, 224);//GEN-BEGIN:|11-updateLayerManager|1|11-postUpdate
        getJamesS().setVisible(true);
        lm.append(getJamesS());
        getDukeS().setPosition(90, 37);
        getDukeS().setVisible(true);
        lm.append(getDukeS());
        getMaze1().setPosition(0, 0);
        getMaze1().setVisible(true);
        lm.append(getMaze1());//GEN-END:|11-updateLayerManager|1|11-postUpdate
        // write post-update user code here
    }//GEN-BEGIN:|11-updateLayerManager|2|
//GEN-END:|11-updateLayerManager|2|

}
