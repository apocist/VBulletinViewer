package com.inverseinnovations.VBulletinViewer.Style;

import java.awt.Color;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.inverseinnovations.VBulletinViewer.Functions;
import com.inverseinnovations.VBulletinViewer.VBulletinViewer;

public class Style {
	public ListItem style;

	private Style(){
		
		YamlReader reader;
		try {
			InputStream in = VBulletinViewer.class.getResourceAsStream("style.yml");
			Reader r = new InputStreamReader(in, "UTF-8");//TODO detect no file then make new one
			reader = new YamlReader(r);
			try {
				this.style = reader.read(ListItem.class);
				init();
				
			} catch (YamlException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    
	    
	}
	
	private static class Instance{
		private static final Style INSTANCE = new Style();
	}
	
	public static Style INST(){
		return Instance.INSTANCE;
	}
	
	public void init(){
		style.init();
	}
	
	public static class ListItem {
	    public int paddingBottom;
	    public String bgColor = "";
	    public Forum forum;
	    public Forum subforum;
	    public Forum thread;
	    //Processed only
	    public Color backgroundColor;
	    
	    public static class Forum {
		    public String bgColor = "";
		    public boolean bgOpaque = false;
		    public Title title;
		    //Processed only
		    public Color backgroundColor;
		    
		    public void init(){
		    	title.init();
		    	this.backgroundColor = Functions.getColor(bgColor);
		    }
		    
		}
	    
	    public static class Title {
		    public LabelStyle font;
		    public int	marginTop,
		   				marginBottom,
		    			marginLeft,
		    			marginRight;
		    public String align	= "";
		    //Processed only
		    public float alignment;
		    
		    public void init(){
		    	font.init();
		    	this.alignment = Functions.getAlignment(align);
		    }
		}
	    
	    public void init(){
	    	forum.init();
	    	subforum.init();
	    	thread.init();
	    	
	    	this.backgroundColor = Functions.getColor(bgColor);
	    }
	}
	
	public static class SubContact {
	    public String id;
	}
	
}

