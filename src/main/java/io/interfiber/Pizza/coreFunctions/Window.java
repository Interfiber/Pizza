package io.interfiber.Pizza.coreFunctions;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.parsers.YamlParser;

public class Window {
	/**
	 * Create Windows With java.awt
	 * In Pizza. Runs on parsing a yaml file containing the property's and elements of the window
	 * @author Interfiber
	 * @since 0.4
	 * @version 1.0
	 * @param yamlInput
	 * @throws FileNotFoundException
	 * @throws SyntaxException
	 */
	public static void createWindow(String yamlInput) throws FileNotFoundException, SyntaxException {
		// Sadly We need to use java.awt
		YamlParser y = new YamlParser();
		String title = y.getValue("title", yamlInput);
		// width and height
		if(!y.valueExists("height", yamlInput)) {
			throw new SyntaxException("Height Varible Dosent Exists! But is mandatory for execution");

		}
		String height = y.getValue("height", yamlInput);
		if(!y.valueExists("width", yamlInput)) {
			throw new SyntaxException("Width Varible Dosent Exists! But is mandatory for execution");
		}
		// color
		Color color = null;
		Frame f = new Frame(title);
		Panel p = new Panel();
		// Test for background colors 
		if(y.valueExists("background-color", yamlInput)) {
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("blue")) {
				 color = Color.BLUE;
			 }
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("red")) {
				 color = Color.RED;
			 }
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("green")) {
				 color = Color.GREEN;
			 }
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("pink")) {
				 color = Color.pink;
			 }
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("black")) {
				 color = Color.BLACK;
			 }
			 if(y.getValue("background-color", yamlInput).equalsIgnoreCase("cyan")) {
				 color = Color.CYAN;
			 }
			 f.setBackground(color);
		}
		if(y.valueExists("element.button", yamlInput)) {
			Button b = new Button(y.getValue("element.button", yamlInput));
			p.add(b);
		}
		// Visible
		if(y.valueExists("visible", yamlInput)) {
			f.setVisible(Boolean.parseBoolean(y.getValue("visible", yamlInput)));
		}
		// open window
		String width = y.getValue("width", yamlInput);
		f.add(p);
		f.setSize(Integer.valueOf(height), Integer.valueOf(width));
		
	}
	public void createPopup(String popupMessage) {
		JOptionPane.showMessageDialog(null, popupMessage);
	}
}