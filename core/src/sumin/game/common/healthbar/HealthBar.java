package sumin.game.common.healthbar;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import sumin.game.engine.math.Rect;
import sumin.game.engine.sprite.Sprite;
import sumin.game.screen.game.MainShip;

/**
 * Created by andrey on 27.11.2017.
 */

public class HealthBar extends Sprite {
    private MainShip mainShip;
    private static final float MARGIN_LEFT = 0.1f;
    private static final float MARGIN_TOP = 0.02f;

    public HealthBar(TextureRegion region, int rows, int cols, int frames, MainShip mainShip) {
        super(region, rows, cols, frames);
        this.mainShip = mainShip;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[0], // текущий регион
                getLeft(), getBottom(), // точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по оси x и оси y
                angle // угол вращения
        );
        batch.draw(
                regions[1], // текущий регион
                getLeft(), getBottom(), // точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth()*(mainShip.getHp()/100f), getHeight(), // ширина и высота
                scale, scale, // масштаб по оси x и оси y
                angle // угол вращения
        );
    }

    public void resize(Rect worldbounds) {
        this.pos.set(worldbounds.getLeft()+MARGIN_LEFT,worldbounds.getTop()-MARGIN_TOP);
        setHeightProportion(0.03f);
    }
}
