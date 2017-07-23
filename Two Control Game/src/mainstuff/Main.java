package mainstuff;

import enums.GameState;
import graphics.Cloud;
import graphics.GGeneral;
import inputs.KeyListenerGame;
import inputs.MouseUpDown;
import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import logic.MainTick;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main extends JPanel {

    public static HashMap<String, BufferedImage[]> allAnimations = new HashMap<>();
    public static HashMap<String, BufferedImage> allImages = new HashMap<>();
    public static HashMap<String, Sound> allSounds = new HashMap<>();
    public static HashMap<String, Music> allSongs = new HashMap<>();

    public static JFrame frame = new JFrame("Jump the thing");

    public static GameState state = GameState.INMENU;

    public static Main game;

    public static boolean initialised = false;

    @Override
    public void paint(Graphics g) {
        if (initialised) {
            GGeneral.gogo((Graphics2D) g);
        }
    }

    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Marmaladal Projectios");

        game = new Main();

        TinySound.init();

        JTextField textField = new JTextField();
        textField.setFocusTraversalKeysEnabled(false);
        textField.addKeyListener(new KeyListenerGame());
        game.addMouseListener(new MouseUpDown());
        frame.add(textField);
        frame.add(game);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                GGeneral.clouds.clear();
                for (int i = 0; i < 30; i++) {
                    GGeneral.clouds.add(new Cloud());
                }
            }
        });

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("VCR_OSD_MONO_1.001.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }

        for (File f : new File("Songs").listFiles()) {
            String s = f.getName().split("\\.")[0];
            allSongs.put(s, TinySound.loadMusic(f));
        }
        for (File f : new File("Sounds").listFiles()) {
            String s = f.getName().split("\\.")[0];
            allSounds.put(s, TinySound.loadSound(f));
        }

        for (File f : new File("Images").listFiles()) {
            try {
                String s = f.getName().split("\\.")[0];
                allImages.put(s, ImageIO.read(f));
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        for (File f : new File("Animations").listFiles()) {
            try {
                String s = f.getName().split("\\.")[0];
                BufferedImage img = ImageIO.read(f);
                int width = img.getWidth();
                int height = img.getHeight();
                BufferedImage[] frames = new BufferedImage[height/width];
                for (int i = 0; i < height/width; i++) {
                    frames[i] = img.getSubimage(0, i*width, width, width);
                }
                allAnimations.put(s, frames);
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        Init.onGameStart();

        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 100;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastFpsTime = 0;
        long fps = 0;

        while (true) {
            initialised = true;
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000) {
                //System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            // draw everyting
            game.repaint();

            // update the game logic
            MainTick.goUpdates(delta);

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (Exception e) {

            }
        }
    }
}