package sumin.game.common;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import sumin.game.engine.math.Rect;
import sumin.game.engine.sprite.Sprite;

/**
 * Created by andrey on 27.11.2017.
 */

public class Background extends Sprite {

    /**
     * Конструктор
     * @param region регион с текстурой фона
     */
    public Background(TextureRegion region) {
        super(region);
    }

    /**
     * Событие изменения размера экрана
     * @param worldBounds новые границы игрового мира
     */
    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
