package sumin.game.screen.game.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import sumin.game.engine.ui.ActionListener;
import sumin.game.engine.ui.ScaledTouchUpButton;

/**
 * Created by andrey on 27.11.2017.
 */

public class ButtonNewGame extends ScaledTouchUpButton {

    private static final float HEIGHT = 0.05f;
    private static final float TOP = -0.012f;
    private static final float PRESS_SCALE = 0.9f;


    public ButtonNewGame(TextureAtlas atlas, ActionListener listener) {
        super(atlas.findRegion("button_new_game"), listener, PRESS_SCALE);
        setHeightProportion(HEIGHT);
        setTop(TOP);
    }
}
