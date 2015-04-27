package com.inverseinnovations.VBulletinViewer.ForumComponent;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.inverseinnovations.VBulletinAPI.ForumThread;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;

public class ThreadListItem extends JPanel{
	private static final long serialVersionUID = 1L;
	private LabelStyle 	style;
						//subForumTitleStyle;
	public ThreadListItem(ForumThread thread){
		this(thread, Style.INST().style.thread.title.font);
	}
	
	public ThreadListItem(ForumThread thread, LabelStyle labelStyle){
		setTitleStyle(labelStyle);
		//setSubTitleStyle(subStyle);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.gridwidth = gbc.gridheight = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.weightx = gbc.weighty = 1;
			gbc.insets = new Insets(Style.INST().style.thread.title.marginTop, Style.INST().style.thread.title.marginLeft, Style.INST().style.thread.title.marginBottom, Style.INST().style.thread.title.marginRight);
		/*GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridx = 0;
			gbc.gridy = 1;
			gbc2.gridwidth = gbc.gridheight = 1;
			gbc2.fill = GridBagConstraints.HORIZONTAL;
			gbc2.anchor = GridBagConstraints.NORTH;
			gbc2.weightx = gbc.weighty = 1;
			gbc2.insets = new Insets(Style.INST().style.subforum.title.marginTop, Style.INST().style.subforum.title.marginLeft, Style.INST().style.subforum.title.marginBottom, Style.INST().style.subforum.title.marginRight);
        */
		paintStyle();
		JPanel mainTitlePanel = new JPanel();
		mainTitlePanel.setLayout(new BoxLayout(mainTitlePanel, BoxLayout.Y_AXIS));
		ForumAction action = null;
		//if(!thread.getStatusIcon().equals("link")){
			action = new ForumAction(ForumAction.THREAD_DISPLAY, thread.getThreadId());
		//}
		SLabel title = new SLabel(
				thread.getTitle(), style, action
		);
		title.setAlignmentX(Style.INST().style.thread.title.alignment);
		mainTitlePanel.add(title);
		mainTitlePanel.setOpaque(false);
		this.add(mainTitlePanel, gbc);

	}
	public void setTitleStyle(LabelStyle labelStyle){
		this.style = labelStyle;
	}

	private void paintStyle(){
		this.setBackground(Style.INST().style.thread.backgroundColor);
		this.setOpaque(Style.INST().style.thread.bgOpaque);
	}

}

