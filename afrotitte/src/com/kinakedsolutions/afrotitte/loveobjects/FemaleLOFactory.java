package com.kinakedsolutions.afrotitte.loveobjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;

import com.kinakedsolutions.afrotitte.loveobjects.Woman.WomanBuilder;

public class FemaleLOFactory implements LoveObjectFactory {

	/**
	 * Generates a random woman, using the name as a base of randomization of the other properties. 
	 */
	@Override
	public LoveObject getRandomLoveObject() {
		
		
		String name = getRandomName();
		WomanBuilder builder = new WomanBuilder(name);
		
		// use name as seed for RNG
		Random rng = new Random(name.hashCode());
		
		// generate mostly legal and sane values
		builder.setAge(18 + rng.nextInt(82));
		builder.setHeight(1 + rng.nextFloat());
		builder.setWeight(40 + rng.nextFloat() * 210);
		
		return builder.build();
	}
	
	/**
	 * Reads a random name from the configured name file.
	 * @return a random name
	 */
	private String getRandomName() {
		String randomName = "";
		try {
			// TODO: locate name file via properties setting
			FileReader input = new FileReader("data/names_f.txt");
			LineNumberReader lineReader = new LineNumberReader(input);
			while(lineReader.readLine() != null);
			
			// choose random name
			int nameNumber = (int) Math.round(Math.random() * lineReader.getLineNumber());
			
			// read again to extract the chosen name
			lineReader.close();
			input = new FileReader("data/names_f.txt");
			lineReader = new LineNumberReader(input);
			
			for(int i = 0; i < nameNumber; i++) {
				randomName = lineReader.readLine();
			}
			lineReader.close();
			
		} catch (FileNotFoundException ex) {
			// TODO wrap exceptions
			ex.printStackTrace();
		} catch(IOException ex) {
			// TODO wrap exceptions
			ex.printStackTrace();
		}
		return randomName;
	}

}
