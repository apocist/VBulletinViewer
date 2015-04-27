package com.inverseinnovations.VBulletinViewer.Window;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.inverseinnovations.VBulletinViewer.ForumComponent.HomeHeaderListItem;
import com.inverseinnovations.VBulletinViewer.Style.Style;

public class ContentArea extends JPanel{
	private static final long serialVersionUID = 1L;
	private Window Window;

	public ContentArea(Window window){
		this.Window = window;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addHeader(){
		addToList(new HomeHeaderListItem());
	}
	
	public void addToList(Component comp){
		JPanel listItem = new JPanel();
		//listItem.setLayout(new BorderLayout());
		listItem.setLayout(new BorderLayout());
		listItem.setBackground(Style.INST().style.backgroundColor);/*Style.INST().getColor("listItemBackgroundColor"));*/
		listItem.setBorder(new BevelBorder(BevelBorder.RAISED));//TODO needs to be an option
		
		//need to get the size of comp and then set the max height
		
		listItem.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent arg0) {
            	resizeComp(listItem, comp);
            }

            public void componentMoved(ComponentEvent arg0) {
            }

            public void componentShown(ComponentEvent arg0) {
            	resizeComp(listItem, comp);
            }

            public void componentHidden(ComponentEvent arg0) {
            }
        });
		listItem.add(comp, BorderLayout.PAGE_START);
		this.add(listItem);
	}
	public void addToList(ArrayList<Component> comps){
		for(Component comp : comps){
			addToList(comp);
		}
		resize();	
	}
	public void clearWindow(){
		this.removeAll();
	}
	private void resizeComp(JPanel listItem, Component parentComp){
		listItem.setMaximumSize(new java.awt.Dimension(9999, parentComp.getHeight()+Style.INST().style.paddingBottom));
	}
	private void resize(){
		Window.setVisible(true);
		for(Component listItem : this.getComponents()){//TODO hacky way to force componentShown...since its not doing it...
			if(listItem instanceof JPanel){
				for(ComponentListener listener : listItem.getComponentListeners()){
					listener.componentShown(new ComponentEvent (listItem,ComponentEvent.COMPONENT_SHOWN));
				}
			}
		}
		this.revalidate();
		
	}
	
}
