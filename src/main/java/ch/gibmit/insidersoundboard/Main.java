package ch.gibmit.insidersoundboard;

import ch.gibmit.insidersoundboard.gui.Frame;

public class Main {

    public static void main(String[] args) {

        new Frame(Sound.fetchSonds("http://soundboard.byethost14.com/example.json"));

    }

}
