package sumin.game.common.bullet;

import sumin.game.engine.pool.SpritesPool;

/**
 * Created by andrey on 27.11.2017.
 */

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void debugLog() {
        System.out.println(" Bullet pool change active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}
