package com.arnavk09;

public class Function_Format {
    GUI gui;

    public Function_Format(GUI gui) {
        this.gui = gui;

    }

    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap : ON");


        } else if (gui.wordWrapOn == true) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap : OFF");


        }
    }

}
