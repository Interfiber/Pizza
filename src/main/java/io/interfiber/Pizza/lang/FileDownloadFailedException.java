package io.interfiber.Pizza.lang;

public class FileDownloadFailedException extends Exception{

	public FileDownloadFailedException(String outputFile, String url) {
		super("Connected to server " + url + " But failed to retrive data!");
	}
}
