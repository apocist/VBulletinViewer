package com.inverseinnovations.VBulletinViewer.Window;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.inverseinnovations.VBulletinViewer.VBulletinViewer;

public class Window extends JFrame {
	
	protected VBulletinViewer App;
	private static final long serialVersionUID = 1L;
	public final ContentArea ContentArea = new ContentArea(this);
	JScrollPane scrollPane = new JScrollPane();

	
	
	public Window(VBulletinViewer ref){
		super("Forum List");
		App = ref;
	    setSize(1000, 750);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(new BorderLayout());
	    scrollPane.setViewportView(ContentArea);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(5);
	    getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	
	/*public void clearWindow(){
		contentPane.removeAll();
	}
	public void addHeader(){
		addToList(new HomeHeaderListItem());
	}
	
	public void addToList(Component comp){
		JPanel listItem = new JPanel();
		//listItem.setLayout(new BorderLayout());
		listItem.setLayout(new BorderLayout());
		listItem.setBackground(Style.INST().style.backgroundColor);
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
		contentPane.add(listItem);
	}
	public void addToList(ArrayList<Component> comps){
		for(Component comp : comps){
			addToList(comp);
		}
		revalidate();	
	}
	private void resizeComp(JPanel listItem, Component parentComp){
		listItem.setMaximumSize(new java.awt.Dimension(9999, parentComp.getHeight()+Style.INST().style.paddingBottom));
	}
	public void revalidate(){
		this.setVisible(true);
		for(Component listItem : contentPane.getComponents()){//TODO hacky way to force componentShown...since its not doing it...
			if(listItem instanceof JPanel){
				for(ComponentListener listener : listItem.getComponentListeners()){
					listener.componentShown(new ComponentEvent (listItem,ComponentEvent.COMPONENT_SHOWN));
				}
			}
		}
		contentPane.revalidate();
	}*/
		
}