package sumin.game.screen.menu.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import sumin.game.engine.math.Rect;
import sumin.game.engine.ui.ActionListener;
import sumin.game.engine.ui.ScaledTouchUpButton;

/**
 * Created by andrey on 27.11.2017.
 */

public class ButtonExit extends ScaledTouchUpButton {
    /**
     * Конструктор
     *
     * @param atlas     атлас
     * @param listener   слушатель событий
     * @param pressScale на сколько уменьшить кнопку при нажатии
     */
    public ButtonExit(TextureAtlas atlas, ActionListener listener, float pressScale) {
        super(atlas.findRegion("btExit"), listener, pressScale);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
