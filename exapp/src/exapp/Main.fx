/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exapp;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author willy
 */
Stage {
    title: "Facil Declaracion"
    width: 249
    height: 251
    visible: true
    scene: Scene {
        content: [            
            Circle{
                centerX: 118
                centerY: 110
                radius: 83
                fill: Color.WHITE //color de fondo
                stroke: Color.RED //color de borde
            },
            Rectangle {
                x: 45 y: 45
                width: 150 height: 150
                arcHeight: 15 arcWidth: 15 //bordes redondeados
                fill: Color.GREEN
            }
        ]
    }
}
