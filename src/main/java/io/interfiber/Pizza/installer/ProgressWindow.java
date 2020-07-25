//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
// Why Do I all ways lose source code for things

package io.interfiber.Pizza.installer;

import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ProgressWindow {
    public ProgressWindow() {
    }

    public static void start() {
        System.out.println("Entered Progress Window Class!");
        System.out.println("Setting Up...");
        JFrame j = new JFrame("Install Progress");
        JPanel jp = new JPanel();
        JLabel proLabel = new JLabel("Downloading");
        JProgressBar progress = new JProgressBar(0, 2000);
        progress.setBounds(40, 40, 160, 30);
        progress.setValue(0);
        progress.setStringPainted(true);
        jp.add(proLabel);
        jp.add(progress);
        j.setSize(250, 150);
        j.add(jp);
        j.setVisible(true);

        try {
            String fetchUrl = "https://github.com/Interfiber/Pizza/releases/download/v0.3/pizza-dist.tar.gz";
            progress.setString("10%");
            progress.setValue(100);
            URL website = new URL(fetchUrl);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("pizza.tar.gz");
            fos.getChannel().transferFrom(rbc, 0L, 9223372036854775807L);
            progress.setValue(500);
            progress.setString("40%");
            proLabel.setText("Extracting");
            Archiver archiver = ArchiverFactory.createArchiver("tar", "gz");
            File f = new File("pizza.tar.gz");
            File dest = new File("out");
            archiver.extract(f, dest);
            proLabel.setText("Moving...");
            progress.setString("90%");
            progress.setValue(2000);
            String installDir = Installer.installDir.getText();
            System.out.println(installDir);
            File install = new File(installDir);
            if (install.exists()) {
                JOptionPane.showMessageDialog((Component)null, installDir + " Already exists Please Remove it!", "Error", 0);
                System.exit(1);
            }

            install.mkdirs();
            File out = new File("out/pizza");
            if (out.renameTo(install)) {
                File pizzaExec = new File(installDir + "/bin/pizza");
                pizzaExec.setExecutable(true);
                JOptionPane.showMessageDialog((Component)null, "Pizza Was Installed At " + installDir + " Please Read The Install Docs here: https://interfiber.github.io/pizza-docs");
                System.exit(0);
            }
        } catch (Exception var15) {
            var15.printStackTrace();
        }

    }
}
