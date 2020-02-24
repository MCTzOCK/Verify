package de.mctzock.verify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigFiles {
	
	public void createFilesIfNotExists()
	{
		File dir = new File("plugins/verify");
		if(!dir.exists())
		{
			dir.mkdir();
		}
	}
	
	public String read(String playername) throws Exception
	{
		String str = "";
		File f = new File("plugins/verify/" + playername);
		if(!f.exists())
		{
			f.createNewFile();
		}
		Scanner s = new Scanner(f);
		while(s.hasNextLine())
		{
			str = s.nextLine();
		}
		s.close();
		System.out.println(str);
		return str;
	}
	public void write(String playername, String write) throws IOException
	{
		File f = new File("plugins/verify/" + playername);
		FileWriter writer = new FileWriter(f);
		if(!f.exists())
		{
			f.createNewFile();
		}
		writer.write(write);
		writer.close();
	}
}
