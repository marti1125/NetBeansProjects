/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circulo;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * @author familia
 */
Stage {
    scene: Scene {
        content: [
            Circle {
                centerX: 50, centerY: 50
                radius: 50
                fill: Color.RED
            }
        ]
    }
}
