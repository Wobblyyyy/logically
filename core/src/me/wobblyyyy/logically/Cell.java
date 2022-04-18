package me.wobblyyyy.logically;

import com.badlogic.gdx.graphics.Texture;

public class Cell {
    private Texture texture;

    public Cell(Texture texture) {
        this.texture = texture;
    }

    public Texture texture() {
        return texture;
    }
}
