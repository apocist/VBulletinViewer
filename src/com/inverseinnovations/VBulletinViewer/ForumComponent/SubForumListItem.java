package com.inverseinnovations.VBulletinViewer.ForumComponent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinAPI.Forum;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;

public class SubForumListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle 	style;
	private SLabel 	title;

	public SubForumListItem(Forum subForum, LabelStyle subForumTitleStyle){
		this(subForum, subForumTitleStyle, null);
	}
	
	public SubForumListItem(Forum subForum, LabelStyle subForumTitleStyle, ForumAction action){
		setStyle(subForumTitleStyle);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		title = new SLabel(subForum.getTitle(), style, action);
		
		repaintStyle();
		this.add(title);
	}
	
	/**
	 * Sets StyleLabel
	 * Will need to still need to call repaintStyle()
	 * @param style StyleLabel
	 * @return this
	 */
	public SubForumListItem setStyle(LabelStyle style){
		this.style = style;
		return this;
	}
	
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
