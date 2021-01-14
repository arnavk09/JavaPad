package com.arnavk09;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName, fileAddress;

    public Function_File(GUI gui) {
        this.gui = gui;
    }

    public void newFile() {
        gui.window.setTitle("JavaPad - A Notepad Clone : New");
        gui.textArea.setText(" ");
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);

        }
        System.out.println("FILE ADDRESS & NAME :" + fileAddress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText(" ");
            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();


        } catch (Exception e) {
            System.out.println(e + "FILE NOT OPENED");

        }


    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileName + fileAddress);
                fw.write(gui.textArea.getText());
                fw.close();
                fileAddress = null;
                fileName = null;


            } catch (Exception e) {
                System.out.println("Some problem occured :" + e.getMessage());
            }
        }
    }

    public void saveAs() {

        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            fileName = fd.getFile();  
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName); //
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();


        } catch (Exception evr) {
            System.out.println("ERROR" + evr.getMessage());
        }

    }

    public void exit() {
        System.exit(0);
    }
}
