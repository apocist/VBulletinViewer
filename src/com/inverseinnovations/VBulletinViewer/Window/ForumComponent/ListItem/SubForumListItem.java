package com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ListItem;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinAPI.Forum;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ForumAction;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.SLabel;

public class SubForumListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle 	style;
	private SLabel 	title;

	public SubForumListItem(Forum subForum){
		this(subForum, null);
	}
	
	public SubForumListItem(Forum subForum, ForumAction action){
		super();
		setLabelStyle(Style.INST().style.subforum.title.font);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		title = new SLabel(subForum.getTitle(), getLabelStyle(), action);
		
		repaintStyle();
		this.add(title);
	}
	
	public void setLabelStyle(LabelStyle labelStyle){
		this.style = labelStyle;
	}
	public LabelStyle getLabelStyle(){
		return style;
	}
	/**
	 * Sets StyleLabel
	 * Will need to still need to call repaintStyle()
	 * @param style StyleLabel
	 * @return this
	 */
	/*public SubForumListItem setStyle(LabelStyle style){
		this.style = style;
		return this;
	}*/
	
	/**
	 * Reloads base settings within set Styling
	 * @return this
	 */
	public SubForumListItem repaintStyle(){
		title.setAlignmentX(Style.INST().style.subforum.title.alignment);/*Style.INST().getAlignment("list_subForumTitleAlign"));*/
		this.setBackground(Style.INST().style.subforum.backgroundColor);/*Style.INST().getColor("list_subForumBackgroundColor"));*/
		this.setOpaque(Style.INST().style.subforum.bgOpaque);/*Style.INST().getBoolean("list_subForumBackgroundOpaque"));*/
		return this;
	}
	
	/**
	 * Reloads base Style settings of inner SLabel
	 * @return this
	 */
	public SubForumListItem repaintTitle(){
		title.repaintStyle();
		return this;
	}
	
}
