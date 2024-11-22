package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.SpriteFilter;
import net.thevpc.gaming.atom.engine.maintasks.MoveToPointSpriteMainTask;
import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.model.Orientation;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.*;

public class SpriteController2 extends DefaultSceneController {




    private SpriteFilter sprite;

    private KeyCodeSet up = KeyCodeSet.of(KeyCode.UP);
    private KeyCodeSet down = KeyCodeSet.of(KeyCode.DOWN);
    private KeyCodeSet left = KeyCodeSet.of(KeyCode.LEFT);
    private KeyCodeSet right = KeyCodeSet.of(KeyCode.RIGHT);

    private boolean crossMode = false;


    public SpriteController2(SpriteFilter sprite) {
        this.sprite = sprite;
        if (sprite == null) {
            throw new NullPointerException("null sprite condition");
        }
    }

    @Override
    public void mouseClicked(SceneMouseEvent e) {
        for (Sprite sp : e.getScene().getSceneEngine().findSprites(sprite)) {
            mouseChanged(sp, e);
        }
    }

    public void mouseChanged(Sprite sprite, SceneMouseEvent e) {
        ModelPoint targetPoint = e.getPoint();
        MoveToPointSpriteMainTask moveTask = new MoveToPointSpriteMainTask(targetPoint);
        sprite.setMainTask(moveTask);
    }

}