package com.inverseinnovations.VBulletinViewer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import com.inverseinnovations.VBulletinViewer.Style.Style;

class Window extends JFrame {
	
	protected VBulletinViewer App;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	//JPanel rightPane = new JPanel();
	//JPanel topPane = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	JLabel testText = new JLabel("Test");
	JLabel testText2 = new JLabel("Test");
	JLabel testText3 = new JLabel("Test");
	JLabel testText4 = new JLabel("Test");
	JLabel testText5 = new JLabel("Test");
	JPanel wPanel = new JPanel();
	JPanel wPanel2 = new JPanel();
	JPanel wPanel3 = new JPanel();
	JPanel wPanel4 = new JPanel();
	JPanel wPanel5 = new JPanel();
	
	
	public Window(VBulletinViewer ref){
		super("Forum List");
		App = ref;
	    setSize(1000, 750);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(new BorderLayout());
	    scrollPane.setViewportView(contentPane);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(5);
	    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	    // important to call revalidate here so leftPane will notify scrollPane to update accordingly
	    contentPane.revalidate();
	    getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	public void clearWindow(){
		contentPane.removeAll();
	}
	
	public void addToList(Component comp){//TODO outdated
		JPanel listItem = new JPanel();
		//listItem.setLayout(new BorderLayout());
		listItem.setLayout(new BorderLayout());
		listItem.setBackground(Style.INST().style.backgroundColor);/*Style.INST().getColor("listItemBackgroundColor"));*/
		listItem.setBorder(new BevelBorder(BevelBorder.RAISED));//TODO needs to be an option
		
		//need to get the size of comp and then set the max height
		
		listItem.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent arg0) {
            	listItem.setMaximumSize(new java.awt.Dimension(9999, comp.getHeight()+Style.INST().style.paddingBottom/*Style.INST().getInt("listItemPaddingBottom")*/));
            }

            public void componentMoved(ComponentEvent arg0) {
            }

            public void componentShown(ComponentEvent arg0) {
            	listItem.setMaximumSize(new java.awt.Dimension(9999, comp.getHeight()+Style.INST().style.paddingBottom/*Style.INST().getInt("listItemPaddingBottom")*/));
            }

            public void componentHidden(ComponentEvent arg0) {
            }
        });
		listItem.add(comp, BorderLayout.PAGE_START);
		contentPane.add(listItem);	
	}
	public void addToList(ArrayList<Component> comps){
		for(Component comp : comps){
			addToList(comp);
		}
		revalidate();	
	}
	public void revalidate(){
		contentPane.revalidate();
		this.setVisible(true);
	}
		
}