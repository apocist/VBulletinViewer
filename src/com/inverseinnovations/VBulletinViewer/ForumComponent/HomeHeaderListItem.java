package com.inverseinnovations.VBulletinViewer.ForumComponent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;

public class HomeHeaderListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle style = Style.INST().style.forum.title.font;//will later need to be the header styles
	private SLabel 	home;
	
	public HomeHeaderListItem(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		home = new SLabel("Home", style, new ForumAction(
				ForumAction.FORUM_HOME
			));
		
		repaintStyle();
		this.add(home);
	}
	
	/**
	 * Reloads base settings within set Styling
	 * @return this
	 */
	public HomeHeaderListItem repaintStyle(){
		home.setAlignmentX(Style.INST().style.forum.title.alignment);/*Style.INST().getAlignment("list_subForumTitleAlign"));*/
		this.setBackground(Style.INST().style.forum.backgroundColor);/*Style.INST().getColor("list_subForumBackgroundColor"));*/
		this.setOpaque(Style.INST().style.forum.bgOpaque);/*Style.INST().getBoolean("list_subForumBackgroundOpaque"));*/
		return this;
	}
	
}
