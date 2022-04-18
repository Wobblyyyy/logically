package me.wobblyyyy.logically;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class LogicallyInputProcessor implements InputProcessor {
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int code) {
        Vector3 initialPosition = LogicallyGame.camera.position;
        switch (code) {
            case Input.Keys.H:
            case Input.Keys.LEFT:
                LogicallyGame.camera.translate(LogicallyGame.translationAmount, 0);
                break;
            case Input.Keys.J:
            case Input.Keys.DOWN:
                LogicallyGame.camera.translate(0, LogicallyGame.translationAmount);
                break;
            case Input.Keys.K:
            case Input.Keys.UP:
                LogicallyGame.camera.translate(0, -LogicallyGame.translationAmount);
                break;
            case Input.Keys.L:
            case Input.Keys.RIGHT:
                LogicallyGame.camera.translate(-LogicallyGame.translationAmount, 0);
                break;
            default:
                return false;
        }
        Vector3 finalPosition = LogicallyGame.camera.position;

        System.out.printf(
            "initial: %s, final: %s, keycode: %s%n",
            initialPosition,
            finalPosition,
            code
        );

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
