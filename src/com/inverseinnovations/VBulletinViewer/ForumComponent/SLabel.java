package com.inverseinnovations.VBulletinViewer.ForumComponent;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
//Styled Label
public class SLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private LabelStyle 	style;
	private ForumAction action;
	
	public SLabel(String string, LabelStyle style){
		this(string, style, null);
	}
	public SLabel(String string, LabelStyle labelStyle, ForumAction forumAction){
		//TODO Add function for onClick to perform said action
		super(string);
		setStyle(labelStyle);
		setAction(forumAction);
		
		repaintStyle();
		
		//Actions
		addMouseListener(new MouseListener() {
			Boolean mouseHover = false;
			Boolean mouseDown = false;
			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mouseHover = true;
				if(mouseDown){//return to pressed down state if still clicking
					setForeground(style.textColorClick);
					setBackground(style.backgroundTextColorClick);
				}
				else{//normal hover
					setForeground(style.textColorHover);
					setBackground(style.backgroundTextColorHover);
				}
				repaintParent();
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mouseHover = false;
				setForeground(style.textColor);
				setBackground(style.backgroundTextColor);
				repaintParent();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseDown = true;
				setForeground(style.textColorClick);
				setBackground(style.backgroundTextColorClick);
				repaintParent();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				mouseDown = false;
				if(mouseHover){//change color back to hover if hovering
					setForeground(style.textColorHover);
					setBackground(style.backgroundTextColorHover);
					repaintParent();
					if(action != null){
						//TODO do action
					}
				}
			}
        });
	}
	
	/**
	 * Reloads base settings within set Styling
	 * @return this
	 */
	public SLabel repaintStyle(){
		//Font and Size
		String fontName = getFont().getName();
		if(!style.font.isEmpty()){
			fontName = style.font;
		}
		int fontStyle = style.style;
		int fontSize = getFont().getSize();
		if(style.size > 0){
			fontSize = style.size;
		}
		setFont(new Font(fontName, fontStyle, fontSize));
		setForeground(style.textColor);
		setBackground(style.backgroundTextColor);
		setOpaque(style.bgOpaque);
	
		return this;
	}
	
	/**
	 * Repaints parent component
	 * @return this
	 */
	public SLabel repaintParent(){	
		// Get the parent of the component.
		JComponent parentComponent = (JComponent)SwingUtilities.getAncestorOfClass(JComponent.class, this);
		// Could we find a parent?
		if (parentComponent != null){
			// Repaint the parent.
			//parentComponent.revalidate();
			parentComponent.repaint();
		}
		else{
			// Repaint the component itself.
			//this.revalidate();
			this.repaint();
		}
		return this;
	}
	
	/**
	 * Sets ForumAction
	 * @param action ForumAction
	 * @return this
	 */
	public SLabel setAction(ForumAction action){
		this.action = action;
		return this;
	}
	
	/**
	 * Sets StyleLabel (should auto change the MouseListeners)
	 * Will need to still need to call repaintStyle()
	 * @param style StyleLabel
	 * @return this
	 */
	public SLabel setStyle(LabelStyle style){
		this.style = style;
		return this;
	}
}
