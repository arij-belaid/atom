/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.examples.kombla.main.shared.prensentation;

import net.thevpc.gaming.atom.annotations.AtomSceneController;
import net.thevpc.gaming.atom.model.Orientation;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AbstractMainEngine;

import java.io.IOException;

/**
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
@AtomSceneController(
        scene = "mainLocal,mainClient,mainServer"
)
public class MainController extends DefaultSceneController {


    public MainController() {
    }
    @Override
    public void keyPressed(SceneKeyEvent e) {
        keyPressedTask(e);
    }

    public void keyPressedTask(SceneKeyEvent e) {
        AbstractMainEngine scene = e.getScene().getSceneEngine();
        switch (e.getKeyCode()) {
            case LEFT: {
                try {
                    scene.move(Orientation.WEST);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            case RIGHT: {
                try {
                    scene.move(Orientation.EAST);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            case UP: {
                try {
                    scene.move(Orientation.NORTH);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            case DOWN: {
                try {
                    scene.move(Orientation.SOUTH);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
            case SPACE: {
                try {
                    scene.releaseBomb();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
        }
    }



}
