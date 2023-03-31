package input;

import Map.PlayerPos;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        // Implementer koden for tastetrykk her
        if (e.getKeyChar() == 'w') {
            PlayerPos.move("w");
        } else if (e.getKeyChar() == 'a') {
            PlayerPos.move("a");
        } else if (e.getKeyChar() == 's') {
            PlayerPos.move("s");
        } else if (e.getKeyChar() == 'd') {
            PlayerPos.move("d");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

