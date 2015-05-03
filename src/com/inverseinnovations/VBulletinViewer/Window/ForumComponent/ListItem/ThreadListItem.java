package com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ListItem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinAPI.ForumThread;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ForumAction;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.SLabel;

public class ThreadListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle style;
	
	
	public ThreadListItem(ForumThread thread){
		super();
		setLabelStyle(Style.INST().style.thread.title.font);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.gridwidth = gbc.gridheight = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.weightx = gbc.weighty = 1;
			gbc.insets = new Insets(Style.INST().style.thread.title.marginTop, Style.INST().style.thread.title.marginLeft, Style.INST().style.thread.title.marginBottom, Style.INST().style.thread.title.marginRight);
		paintStyle();
		JPanel mainTitlePanel = new JPanel();
		mainTitlePanel.setLayout(new BoxLayout(mainTitlePanel, BoxLayout.Y_AXIS));
		ForumAction action = null;
		//if(!thread.getStatusIcon().equals("link")){
			action = new ForumAction(ForumAction.THREAD_DISPLAY, thread.getThreadId());
		//}
		SLabel title = new SLabel(
				thread.getTitle(), getLabelStyle(), action
		);
		title.setAlignmentX(Style.INST().style.thread.title.alignment);
		mainTitlePanel.add(title);
		mainTitlePanel.setOpaque(false);
		this.add(mainTitlePanel, gbc);

	}

	public void setLabelStyle(LabelStyle labelStyle){
		this.style = labelStyle;
	}
	public LabelStyle getLabelStyle(){
		return style;
	}
	protected void paintStyle(){
		this.setBackground(Style.INST().style.thread.backgroundColor);
		this.setOpaque(Style.INST().style.thread.bgOpaque);
	}

}

