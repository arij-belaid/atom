package net.thevpc.gaming.helloworld;
import net.thevpc.gaming.atom.annotations.AtomSprite;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnInit;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.collisiontasks.BounceSpriteCollisionTask;
import net.thevpc.gaming.atom.engine.collisiontasks.StopSpriteCollisionTask;
import net.thevpc.gaming.atom.engine.maintasks.MoveSpriteMainTask;
import net.thevpc.gaming.atom.model.Sprite;




@AtomSprite(
        name = "Ball2",
        kind = "Ball",
        sceneEngine = "hello",
        // x=6,
        //y=2,
        direction = -(Math.PI/4),
        speed = (2*0.2),
        mainTask = MoveSpriteMainTask.class,
        collisionTask = StopSpriteCollisionTask.class
        //   collisionTask2 = BounceSpriteCollisionTask.class

)
public class Ball2 {
    @Inject
    Sprite sprite;
    @Inject
    SceneEngine sceneEngine;

    @OnInit
    private void init() {
        sprite.setLocation(3, 3);
        // Double the size of Ball2
        sprite.setSize(sprite.getWidth() * 2, sprite.getHeight() * 2);
        sprite.setCollisionTask(new Ball2DefaultSpriteCollisionManager());

    }

}