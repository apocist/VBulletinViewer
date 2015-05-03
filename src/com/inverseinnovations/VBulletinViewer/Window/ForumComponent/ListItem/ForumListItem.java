package com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ListItem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinAPI.Forum;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ForumAction;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.SLabel;

public class ForumListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle style;
	//private LabelStyle subForumTitleStyle;//TODO why are we even storing the style....? just have it load once...right?

	
	public ForumListItem(Forum forum){
		super();
		setLabelStyle(Style.INST().style.forum.title.font);
		//setTitleStyle(style);
		//setSubTitleStyle(Style.INST().style.subforum.title.font);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.gridwidth = gbc.gridheight = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.weightx = gbc.weighty = 1;
			gbc.insets = new Insets(Style.INST().style.forum.title.marginTop, Style.INST().style.forum.title.marginLeft, Style.INST().style.forum.title.marginBottom, Style.INST().style.forum.title.marginRight);/*Style.INST().getInt("list_forumTitleMarginTop"), Style.INST().getInt("list_forumTitleMarginLeft"), Style.INST().getInt("list_forumTitleMarginBottom"), Style.INST().getInt("list_forumTitleMarginRight"));*/
		GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridx = 0;
			gbc.gridy = 1;
			gbc2.gridwidth = gbc.gridheight = 1;
			gbc2.fill = GridBagConstraints.HORIZONTAL;
			gbc2.anchor = GridBagConstraints.NORTH;
			gbc2.weightx = gbc.weighty = 1;
			gbc2.insets = new Insets(Style.INST().style.subforum.title.marginTop, Style.INST().style.subforum.title.marginLeft, Style.INST().style.subforum.title.marginBottom, Style.INST().style.subforum.title.marginRight);/*Style.INST().getInt("list_subForumTitleMarginTop"), Style.INST().getInt("list_subForumTitleMarginLeft"), Style.INST().getInt("list_subForumTitleMarginBottom"), Style.INST().getInt("list_subForumTitleMarginRight"));*/
        
		paintStyle();
		JPanel mainTitlePanel = new JPanel();
		mainTitlePanel.setLayout(new BoxLayout(mainTitlePanel, BoxLayout.Y_AXIS));
			ForumAction action = null;
			if(!forum.getStatusIcon().equals("link")){
				action = new ForumAction(ForumAction.FORUM_DISPLAY, forum.getForumId());
			}
			SLabel mainTitle = new SLabel(
					forum.getTitle(), getLabelStyle(), action
			);
			mainTitle.setAlignmentX(Style.INST().style.forum.title.alignment);
			mainTitlePanel.add(mainTitle);
			mainTitlePanel.setOpaque(false);
			this.add(mainTitlePanel, gbc);
		if(!forum.getSubForums().isEmpty()){
			for(Forum subForum : forum.getSubForums()){
				ForumAction subAction = null;
				if(!subForum.getStatusIcon().equals("link")){
					subAction = new ForumAction(ForumAction.FORUM_DISPLAY, subForum.getForumId());
				}
				this.add(new SubForumListItem(
						subForum, subAction
						)
				, gbc2);
				gbc.gridy++;
			}
		}
	}
	/*public void setTitleStyle(LabelStyle style){
		this.style = style;
	}*/
	
	public void setLabelStyle(LabelStyle labelStyle){
		this.style = labelStyle;
	}
	public LabelStyle getLabelStyle(){
		return style;
	}
	/*public void setSubTitleStyle(LabelStyle style){
		this.subForumTitleStyle = style;
	}
	public LabelStyle getSubTitleStyle(){
		return this.subForumTitleStyle;
	}*/
	protected void paintStyle(){
		this.setBackground(Style.INST().style.forum.backgroundColor);
		this.setOpaque(Style.INST().style.forum.bgOpaque);
	}

}
