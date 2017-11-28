package sumin.game.common.enemy;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import sumin.game.engine.math.Rect;
import sumin.game.engine.math.Rnd;
import sumin.game.engine.utils.Regions;

/**
 * Created by andrey on 27.11.2017.
 */

public class EnemiesEmitter {
    private static final float ENEMY_SMALL_VY = -0.2f;
    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_SMALL_BULLET_VY = -0.3f;
    private static final int ENEMY_SMALL_BULLET_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_SMALL_HP = 1;

    private static final float ENEMY_MEDIUM_VY = -0.03f;
    private static final float ENEMY_MEDIUM_HEIGHT = 0.1f;
    private static final float ENEMY_MEDIUM_BULLET_HEIGHT = 0.02f;
    private static final float ENEMY_MEDIUM_BULLET_VY = -0.25f;
    private static final int ENEMY_MEDIUM_BULLET_DAMAGE = 5;
    private static final float ENEMY_MEDIUM_RELOAD_INTERVAL = 4f;
    private static final int ENEMY_MEDIUM_HP = 5;

    private static final float ENEMY_BIG_VY = -0.05f;
    private static final float ENEMY_BIG_HEIGHT = 0.2f;
    private static final float ENEMY_BIG_BULLET_HEIGHT = 0.04f;
    private static final float ENEMY_BIG_BULLET_VY = -0.3f;
    private static final int ENEMY_BIG_BULLET_DAMAGE = 10;
    private static final float ENEMY_BIG_RELOAD_INTERVAL = 1f;
    private static final int ENEMY_BIG_HP = 20;

    private int stage = 1;
    private int prevStage = stage;

    private Rect worldBounds;
    private Sound bulletSound;

    private float generateInterval = 4f;
    private float generateTimer;

    private final TextureRegion[] enemySmallRegion;
    private final TextureRegion[] enemyMediumRegion;
    private final TextureRegion[] enemyBigRegion;

    private final Vector2 enemySmallV = new Vector2(0f, ENEMY_SMALL_VY);
    private final Vector2 enemyMediumV = new Vector2(0f, ENEMY_MEDIUM_VY);
    private final Vector2 enemyBigV = new Vector2(0f, ENEMY_BIG_VY);

    private TextureRegion bulletRegion;

    private final EnemyPool enemyPool;

    public EnemiesEmitter(EnemyPool enemyPool, Rect worldBounds, TextureAtlas atlas, Sound bulletSound) {
        this.enemyPool = enemyPool;
        this.worldBounds = worldBounds;
        this.bulletSound = bulletSound;
        TextureRegion textureRegion0 = atlas.findRegion("enemy0");
        this.enemySmallRegion = Regions.split(textureRegion0, 1, 2, 2);
        TextureRegion textureRegion1 = atlas.findRegion("enemy1");
        this.enemyMediumRegion = Regions.split(textureRegion1, 1, 2, 2);
        TextureRegion textureRegion2 = atlas.findRegion("enemy2");
        this.enemyBigRegion = Regions.split(textureRegion2, 1, 2, 2);
        this.bulletRegion = atlas.findRegion("bulletEnemy");

    }

    public void setToNewGame() {
        stage = 1;
    }

    /**
     * Генерация врагов в зависимости от времени
     * @param deltaTime дельта
     */
    public void generateEnemies(float deltaTime, int frags) {
        if(stage == 1)generateInterval = 4f;
        stage = frags / 5 + 1;
        if(prevStage!=stage){
            generateInterval*=0.95f;
            prevStage = stage;
        }
        generateTimer += deltaTime;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            float type = (float)Math.random();
            if (type < 0.7f) {
                enemy.set(
                        enemySmallRegion,
                        enemySmallV.set(0f,ENEMY_SMALL_VY*(stage+1)/2f),
                        bulletRegion,
                        ENEMY_SMALL_BULLET_HEIGHT,
                        ENEMY_SMALL_BULLET_VY*((stage+1)/2f),
                        ENEMY_SMALL_BULLET_DAMAGE*stage,
                        ENEMY_SMALL_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_SMALL_HEIGHT,
                        ENEMY_SMALL_HP
                );
            } else if (type < 0.9f) {
                enemy.set(
                        enemyMediumRegion,
                        enemyMediumV.set(0f,ENEMY_MEDIUM_VY*(stage+1)/2f),
                        bulletRegion,
                        ENEMY_MEDIUM_BULLET_HEIGHT,
                        ENEMY_MEDIUM_BULLET_VY*((stage+1)/2f),
                        ENEMY_MEDIUM_BULLET_DAMAGE*stage,
                        ENEMY_MEDIUM_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_MEDIUM_HEIGHT,
                        ENEMY_MEDIUM_HP
                );
            } else {
                enemy.set(
                        enemyBigRegion,
                        enemyBigV.set(0f,ENEMY_BIG_VY*(stage+1)/2f),
                        bulletRegion,
                        ENEMY_BIG_BULLET_HEIGHT,
                        ENEMY_BIG_BULLET_VY*((stage+1)/2f),
                        ENEMY_BIG_BULLET_DAMAGE*stage,
                        ENEMY_BIG_RELOAD_INTERVAL,
                        bulletSound,
                        ENEMY_BIG_HEIGHT,
                        ENEMY_BIG_HP
                );
            }
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }

    public int getStage() {
        return stage;
    }
}
