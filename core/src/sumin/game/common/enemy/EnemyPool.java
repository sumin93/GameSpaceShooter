package sumin.game.common.enemy;

import sumin.game.common.bullet.BulletPool;
import sumin.game.common.explosion.ExplosionPool;
import sumin.game.engine.math.Rect;
import sumin.game.engine.pool.SpritesPool;
import sumin.game.screen.game.MainShip;

/**
 * Created by andrey on 27.11.2017.
 */

public class EnemyPool extends SpritesPool<Enemy> {

    private final BulletPool bulletPool;
    private final ExplosionPool explosionPool;
    private final Rect worldBounds;
    private final MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, worldBounds, mainShip);
    }

    @Override
    protected void debugLog() {
        System.out.println("EnemyPool change active/free: " + activeObjects.size() + "/" + freeObjects.size());
    }
}

