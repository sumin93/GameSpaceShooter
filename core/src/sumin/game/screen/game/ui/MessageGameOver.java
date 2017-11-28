package sumin.game.screen.game.ui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import sumin.game.engine.sprite.Sprite;

/**
 * Created by andrey on 27.11.2017.
 */

public class MessageGameOver extends Sprite {

    private static final float HEIGHT = 0.07f;
    private static final float BOTTOM_MARGIN = 0.009f;

    public MessageGameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);
    }
}
