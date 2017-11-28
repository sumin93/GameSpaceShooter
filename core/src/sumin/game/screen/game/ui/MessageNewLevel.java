package sumin.game.screen.game.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import sumin.game.engine.math.Rect;
import sumin.game.engine.sprite.Sprite;

/**
 * Created by andrey on 27.11.2017.
 */

public class MessageNewLevel extends Sprite {
    private Rect worldBounds;

    public void setNewLevel(boolean newLevel) {
        isNewLevel = newLevel;
    }

    private boolean isNewLevel = false;
    private int timer = 60;
    private static final float HEIGHT = 0.2f;
    private final Vector2 v = new Vector2();

    public MessageNewLevel(TextureRegion textureRegion, Rect worldBounds) {
        super(textureRegion);
        setHeightProportion(HEIGHT);
        setTop(worldBounds.getBottom()-0.5f);
        this.worldBounds = worldBounds;
        v.set(0,1f);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if(isNewLevel) {
            if (pos.y < worldBounds.pos.y) {
                pos.mulAdd(v, deltaTime);
            } else if (timer > 0) {
                timer--;
            } else {
                pos.mulAdd(v, deltaTime);
                if(getBottom()>worldBounds.getTop()){
                    timer = 60;
                    isNewLevel = false;
                    setTop(worldBounds.getBottom());
                }
            }
        }
    }
}
