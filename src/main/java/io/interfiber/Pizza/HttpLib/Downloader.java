package io.interfiber.Pizza.HttpLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import io.interfiber.Pizza.lang.FileDownloadFailedException;

import java.io.*;
public class Downloader {
	/**
	 * Download File From the Internet And Save It to the
	 * Local Computer.
	 * @apiNote By default the Program will follow redirects
	 * @author Interfiber
	 * @since 0.4
	 * @param url
	 * @param outputFile
	 * @throws IOException 
	 */
    public static void downloadFile(String url, String outputFile) throws IOException{
    	// Set the String url to a URL
    	URL downloadUrl = new URL(url);
    	ReadableByteChannel rbc = Channels.newChannel(downloadUrl.openStream());
    	FileOutputStream fos = new FileOutputStream(outputFile);
    	fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    	File out = new File(outputFile);
    	if(!out.exists()) {
    		try {
    		throw new FileDownloadFailedException(outputFile, url);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
}
