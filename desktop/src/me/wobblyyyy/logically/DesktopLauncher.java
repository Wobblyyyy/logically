package me.wobblyyyy.logically;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.useVsync(true);
        config.setForegroundFPS(60);
        config.setWindowedMode(800, 480);
        config.setTitle("logically");

        new Lwjgl3Application(new LogicallyGame(), config);
    }
}
