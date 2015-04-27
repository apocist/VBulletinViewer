package com.inverseinnovations.VBulletinViewer;

import java.awt.Color;
import java.awt.Component;

public class Functions {
	
	public static float getAlignment(String key){
		key = key.toLowerCase();
		float retur = 0;
		if(key.equals("center")){
			retur = Component.CENTER_ALIGNMENT;
		}
		else if(key.equals("right")){
			retur = Component.RIGHT_ALIGNMENT;
		}
		else{
			retur = Component.LEFT_ALIGNMENT;
		}
		return retur;
	}
	
	public static Color getColor(String key){
		return getColor(key, 100);
	}
	
	public static Color getColor(String key, int opacity){
		if(key != null){
			if(!key.isEmpty()){
				try{
					if(!key.startsWith("#")){
						key = "#"+key; 
					}
					Color color = Color.decode(key);
					if(opacity < 100){
						color = Functions.setOpacity(color, opacity);
					}
					return color;
				}
				catch(NumberFormatException e){e.printStackTrace();}
			}
		}
		return Color.BLACK;
	}

	/**Sets the Alpha/Opacity of a color
	 * @param color Color
	 * @param alpha Alpha percent 0-100
	 * @return
	 */
	public static Color setOpacity(Color color, float alpha) {
		alpha = (alpha/100) * 255;
		if (alpha < 0) {alpha = 0;}
		else if (alpha > 255) {alpha = 255;}
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)alpha);
	}
}
