package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.collisiontasks.BorderCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollision;
import net.thevpc.gaming.atom.engine.collisiontasks.SpriteCollisionTask;
import net.thevpc.gaming.atom.model.Direction;
import net.thevpc.gaming.atom.model.DirectionTransform;
import net.thevpc.gaming.atom.model.MovementStyles;
import net.thevpc.gaming.atom.model.Sprite;

public class Ball2DefaultSpriteCollisionManager implements SpriteCollisionTask {
    double lastDirection = Double.NaN;
    boolean updatingDirection = false;
    @Override
    public void collideWithBorder(BorderCollision borderCollision) {
        borderCollision.adjustSpritePosition();
        borderCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }
    @Override
    public void collideWithSprite(SpriteCollision spriteCollision) {
        spriteCollision.adjustSpritePosition();
        spriteCollision.getSprite().setDirection(DirectionTransform.BACKWARD);
    }
}
