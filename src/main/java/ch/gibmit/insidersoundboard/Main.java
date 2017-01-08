package ch.gibmit.insidersoundboard;

import ch.gibmit.insidersoundboard.gui.Frame;

public class Main {

    public static void main(String[] args) {

        new Frame(Sound.fetchSounds("https://raw.githubusercontent.com/Aaronmacaron/insider-soundboard/Files/sounds.json"));

    }

}
