/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.vpc.games.atom.examples.tanks.shared.presentation.controller;

import java.awt.event.KeyEvent;
import net.vpc.gaming.atom.presentation.SceneKeyEvent;
import net.vpc.games.atom.examples.tanks.server.business.ServerBattleFieldEngine;
import net.vpc.gaming.atom.presentation.DefaultSceneController;

/**
 *
 * @author Taha Ben Salah
 */
public class BattleFieldController extends DefaultSceneController {

    @Override
    public void keyPressed(SceneKeyEvent e) {
        ServerBattleFieldEngine business = e.getScene().getSceneEngine();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: {
                business.rotateRight(e.getPlayerId());
                break;
            }
            case KeyEvent.VK_LEFT: {
                business.rotateLeft(e.getPlayerId());
                break;
            }
            case KeyEvent.VK_SPACE: {
                business.fire(e.getPlayerId());
                break;
            }
        }
    }
}
