import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class Installer {
	
	
	public static void main(String[] args){
		
		
		System.out.println("Starting Installer...");
		System.out.println("Creating Componets For Window...");
		JPanel jp = new JPanel();
		JButton install = new JButton("Install");
		JLabel boldStart = new JLabel("Pizza Runtime Installer 0.3");
		Font f = boldStart.getFont();
		boldStart.setFont(new Font(f.getName(), Font.BOLD, 24));
		JLabel desc = new JLabel("This Program Will Install Pizza Onto Your Computer.");
		JLabel clickTell = new JLabel("Click Install To Install");
		JTextField installDir = new JTextField();
		String home = System.getProperty("user.home");
		// TODO: Update Url
		String fetchUrl = "https://google.com";
		double version = 0.3;
		String defaultInstall = home + "/Library/Pizza/" + version;
		installDir.setText(defaultInstall);
		System.out.println("Creating Blank Window");
		JFrame j = new JFrame("Pizza Runtime Installer 0.3");
		j.setSize(492, 124);
		System.out.println("Adding Components To JPanel...");
		 install.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){  
            /* Make sure a username was entered */
            System.out.println("Starting Install Of Pizza...");
            System.out.println("Getting Install Dir...");
            String pizzaInstallDir = installDir.getText();
            System.out.println(pizzaInstallDir);
            URL website = new URL("http://www.website.com/information.asp");
ReadableByteChannel rbc = Channels.newChannel(website.openStream());
FileOutputStream fos = new FileOutputStream("information.html");
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            
         }
      });
		jp.add(boldStart);
		jp.add(desc);
		jp.add(clickTell);
		jp.add(installDir);
		jp.add(install);
		System.out.println("Packing JPanel to Window...");
		j.add(jp);
		j.setVisible(true);
		}
	
	}
