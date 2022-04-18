package me.wobblyyyy.logically;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Board {
    public static class BoardMap extends HashMap<Coord, Cell> {
        public BoardMap(int initialCapacity) {
            super(initialCapacity);
        }
    }

    public BoardMap map = new BoardMap(100);
    public Coord cursorPos = new Coord(0, 0);

    public Texture cursorOverlay;
    public Texture cellOverlay;
    public Texture emptyCell;

    public Board() {
        cursorOverlay = new Texture("cursor_overlay.png");
        cellOverlay = new Texture("tile_overlay.png");
        emptyCell = new Texture("empty_tile.png");

        map.put(new Coord(0, 0), new Cell(emptyCell));
        map.put(new Coord(1, 0), new Cell(emptyCell));
        map.put(new Coord(2, 0), new Cell(emptyCell));

        map.put(new Coord(0, 1), new Cell(emptyCell));
        map.put(new Coord(1, 1), new Cell(emptyCell));
        map.put(new Coord(2, 1), new Cell(emptyCell));

        map.put(new Coord(0, 2), new Cell(emptyCell));
        map.put(new Coord(1, 2), new Cell(emptyCell));
        map.put(new Coord(2, 2), new Cell(emptyCell));
    }

    private void render(SpriteBatch batch, Coord coord, Texture texture) {
        int x = coord.x() * LogicallyGame.TILE_SIZE;
        int y = coord.y() * LogicallyGame.TILE_SIZE;

        batch.draw(texture, x, y);
        batch.draw(cellOverlay, x, y);
    }

    public void render(SpriteBatch batch) {
        for (Map.Entry<Coord, Cell> e : map.entrySet()) {
            Coord coord = e.getKey();
            Cell cell = e.getValue();

            render(batch, coord, cell.texture());
        }

        render(batch, cursorPos, cursorOverlay);
    }
}
