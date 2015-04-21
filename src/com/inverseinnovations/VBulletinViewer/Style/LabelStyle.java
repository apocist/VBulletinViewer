package com.inverseinnovations.VBulletinViewer.Style;

import java.awt.Color;

import com.inverseinnovations.VBulletinViewer.Functions;

/**
 * Used to define the Styling of an SLabel
 */
public class LabelStyle {//all variables will be optional
	public int		size = 0,//0 is default
					style = 0;//0 is default
	public String 	font = "";//blank for default
	public String	color,
					colorHover,
					colorClick,
				
					bgColor,
					bgColorHover,
					bgColorClick;
	public boolean	bgOpaque = false;
	public int		bgAlpha,
					bgAlphaHover,
					bgAlphaClick;
	//processed only
	
	public Color	textColor,
					textColorHover,
					textColorClick,
	
					backgroundTextColor,
					backgroundTextColorHover,
					backgroundTextColorClick;
	
	//yet to add
	
	
	public void init(){
		this.textColor = Functions.getColor(color);
		this.textColorHover = Functions.getColor(colorHover);
		this.textColorClick = Functions.getColor(colorClick);
		this.backgroundTextColor = Functions.getColor(bgColor, bgAlpha);
		this.backgroundTextColorHover = Functions.getColor(bgColorHover, bgAlphaHover);
		this.backgroundTextColorClick = Functions.getColor(bgColorClick, bgAlphaClick);
	}
	
	
}
