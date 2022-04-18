package me.wobblyyyy.logically;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LogicallyGame extends ApplicationAdapter {
    public static int TILE_SIZE = 32;
    public static int VIEW_WIDTH = 0;
    public static int VIEW_HEIGHT = 0;

    Board board;
    SpriteBatch batch;
    Texture img;
    Texture cellOverlay;
    Texture emptyCell;

    public static int translationAmount = 32;
    public static OrthographicCamera camera;
    public static LogicallyInputProcessor inputProcessor;

    private void initializeCamera() {
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        VIEW_WIDTH = width;
        VIEW_HEIGHT = height;
    }

    private void initializeInputProcessor() {
        inputProcessor = new LogicallyInputProcessor();
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void create() {
        board = new Board();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        cellOverlay = new Texture("tile_overlay.png");
        emptyCell = new Texture("empty_tile.png");

        initializeCamera();
        initializeInputProcessor();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        board.render(batch);
        // batch.draw(img, 0, 0);
        // batch.draw(emptyCell, 0, 0);
        // batch.draw(cellOverlay, 0, 0);
        batch.setProjectionMatrix(camera.combined);
        batch.end();
        // Gdx.gl.glClearColor(1, 0, 0, 1);
        // Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
