//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.interfiber.Pizza.installer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Installer {
    public static JTextField installDir;

    public Installer() {
    }

    public static void main(String[] args) {
        System.out.println("Starting Installer...");
        System.out.println("Creating Componets For Window...");
        JPanel jp = new JPanel();
        JButton install = new JButton("Install");
        JLabel boldStart = new JLabel("Pizza Runtime Installer 0.3");
        Font f = boldStart.getFont();
        boldStart.setFont(new Font(f.getName(), 1, 24));
        JLabel desc = new JLabel("This Program Will Install Pizza Onto Your Computer.");
        JLabel clickTell = new JLabel("Click Install To Install");
        installDir = new JTextField();
        String home = System.getProperty("user.home");
        String fetchUrl = "https://github.com/Interfiber/Pizza/releases/download/v0.3/pizza-dist.tar.gz";
        double version = 0.3D;
        String defaultInstall = home + "/Library/Pizza/" + version;
        installDir.setText(defaultInstall);
        System.out.println("Creating Blank Window");
        JFrame j = new JFrame("Pizza Runtime Installer 0.3");
        j.setSize(492, 124);
        System.out.println("Adding Components To JPanel...");
        install.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Calling ProgressWindow Class..");
                ProgressWindow.start();
            }
        });
        jp.add(boldStart);
        jp.add(desc);
        jp.add(clickTell);
        jp.add(installDir);
        jp.add(install);
        System.out.println("Packing JPanel to Window...");
        System.out.println("Setting Window To Be Visible...");
        j.add(jp);
        j.setVisible(true);
        System.out.println("Waiting for The Install JButton to be Updated...");
    }
}
