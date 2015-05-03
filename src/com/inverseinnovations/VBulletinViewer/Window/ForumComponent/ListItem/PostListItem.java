package com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ListItem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.inverseinnovations.VBulletinAPI.Post;
import com.inverseinnovations.VBulletinViewer.Style.Style;
import com.inverseinnovations.VBulletinViewer.Window.Window;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.STextPane;

public class PostListItem extends JPanel{

	private static final long serialVersionUID = 1L;
	private STextPane message = new STextPane();//use JTextPane instead
	private String messageString = "";
	private JPanel mainTitlePanel = new JPanel();
	
	
	public PostListItem(Post post){//TODO try a simple JEditor with no special formatting (expect html)
		super();
		//setLabelStyle(Style.INST().style.thread.title.font);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.gridwidth = gbc.gridheight = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.weightx = gbc.weighty = 1;
			//TODO separate paddings
			gbc.insets = new Insets(Style.INST().style.thread.title.marginTop, Style.INST().style.thread.title.marginLeft, Style.INST().style.thread.title.marginBottom, Style.INST().style.thread.title.marginRight);
		paintStyle();
		//JPanel mainTitlePanel = new JPanel();
		mainTitlePanel.setLayout(new BoxLayout(mainTitlePanel, BoxLayout.Y_AXIS));
		//JTextArea message = new JTextArea();
		message.setEditable(false);
		//message.setLineWrap(true);
		//message.setWrapStyleWord(true);

		message.setMessage(post.getMessageBbcode());
		messageString = post.getMessage();
		message.setAlignmentX(Style.INST().style.thread.title.alignment);
		mainTitlePanel.add(message);
		mainTitlePanel.setOpaque(false);
		this.add(mainTitlePanel, gbc);

	}

	/*public void setLabelStyle(LabelStyle labelStyle){
		this.style = labelStyle;
	}
	public LabelStyle getLabelStyle(){
		return style;
	}*/
	protected void paintStyle(){
		this.setBackground(Style.INST().style.thread.backgroundColor);
		this.setOpaque(Style.INST().style.thread.bgOpaque);
	}
	public void reval(Window window){
		//message.setSize(0,0);
		message.setMaximumSize(new java.awt.Dimension(window.getWidth(), message.getMaximumSize().height));
		//message.revalidate();
	}
}
