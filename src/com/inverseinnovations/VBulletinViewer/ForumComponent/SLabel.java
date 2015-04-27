package com.inverseinnovations.VBulletinViewer.ForumComponent;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.inverseinnovations.VBulletinViewer.Action;
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
		super(string);
		setStyle(labelStyle);
		if(string.equals("sex snapchats")){System.out.println(style.textColor.toString());}
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
						Action.INST().doAction(action);
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
	public SLabel setStyle(LabelStyle labelStyle){
		this.style = labelStyle;
		return this;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        /*int width = getWidth() - 1;
        int height = getHeight() - 1;

        int radius = Math.min(width, height) / 10;

        Path2D p = new Path2D.Float();
        p.moveTo(0, radius / 2);
        p.curveTo(0, 0, 0, 0, radius / 2, 0);
        p.curveTo(width / 4, radius, width / 4, radius, (width / 2) - radius, radius / 2);
        p.curveTo(width / 2, 0, width / 2, 0, (width / 2) + radius, radius / 2);
        p.curveTo(width - (width / 4), radius, width - (width / 4), radius, width - (radius / 2), 0);
        p.curveTo(width, 0, width, 0, width, radius / 2);

        p.curveTo(width - radius, height / 4, width - radius, height / 4, width - (radius / 2), (height / 2) - radius);
        p.curveTo(width, height / 2, width, height / 2, width - (radius / 2), (height / 2) + radius);
        p.curveTo(width - radius, height - (height / 4), width - radius, height - (height / 4), width, height - (radius / 2));
        p.curveTo(width, height, width, height, width - (radius / 2), height);

        p.curveTo(width - (width / 4), height - radius, width - (width / 4), height - radius, (width / 2) + radius, height - (radius / 2));
        p.curveTo(width / 2, height, width / 2, height, (width / 2) - radius, height - (radius / 2));
        p.curveTo((width / 4), height - radius, (width / 4), height - radius, (radius / 2), height);
        p.curveTo(0, height, 0, height, 0, height - (radius / 2));

        p.curveTo(radius, height - (height / 4), radius, height - (height / 4), (radius / 2), (height / 2) + radius);
        p.curveTo(0, height / 2, 0, height / 2, (radius / 2), (height / 2) - radius);
        p.curveTo(radius, (height / 4), radius, (height / 4), 0, (radius / 2));

        p.closePath();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setColor(getBackground());
        g2d.fill(p);
        g2d.dispose();*/
        
    	/*//gradient
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = this.getBackground();//new Color(226, 218, 145);
        Color color2 = color1.brighter();
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        super.paintComponent(g); // *** added*/
        
		/*//Border
        super.paintComponent(g);
        int height = this.getHeight();
        int width = this.getWidth();
        g.drawRect(0, 0, width - 1, height - 1);*/

    }
}
