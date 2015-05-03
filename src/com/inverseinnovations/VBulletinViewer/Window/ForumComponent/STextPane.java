package com.inverseinnovations.VBulletinViewer.Window.ForumComponent;

import javax.swing.JTextPane;
import java.awt.Dimension; 

import javax.swing.*; 
import javax.swing.text.Element; 
import javax.swing.text.View; 
import javax.swing.text.ViewFactory; 
import javax.swing.text.html.HTMLEditorKit; 
import javax.swing.text.html.InlineView; 
import javax.swing.text.html.ParagraphView;

public class STextPane extends JTextPane {

		private static final long serialVersionUID = 1L;
		public HTMLEditorKit kit = new HTMLEditorKit();
		
		//public HTMLDocument doc = new HTMLDocument();
		public String lastMsg;

		
		public STextPane(){
			this(null);
		}
		public STextPane(String message){
			//setEditorKit(kit);
			//setDocument(doc);
			if(message != null){this.setMessage(message);}
			//setBackground(new Color(240,240,240));
			//DefaultCaret caret = (DefaultCaret)this.getCaret();
			//caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);//this will make it auto scroll to bottom
			
			this.setEditorKit(new HTMLEditorKit(){ 
				private static final long serialVersionUID = 1L;

				@Override 
		           public ViewFactory getViewFactory(){ 
		 
		               return new HTMLFactory(){ 
		                   public View create(Element e){ 
		                      View v = super.create(e); 
		                      if(v instanceof InlineView){ 
		                          return new InlineView(e){ 
		                              public int getBreakWeight(int axis, float pos, float len) { 
		                                  return GoodBreakWeight; 
		                              } 
		                              public View breakView(int axis, int p0, float pos, float len) { 
		                                  if(axis == View.X_AXIS) { 
		                                      checkPainter(); 
		                                      int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len); 
		                                      if(p0 == getStartOffset() && p1 == getEndOffset()) { 
		                                          return this; 
		                                      } 
		                                      return createFragment(p0, p1); 
		                                  } 
		                                  return this; 
		                                } 
		                            }; 
		                      } 
		                      else if (v instanceof ParagraphView) { 
		                          return new ParagraphView(e) { 
		                              protected SizeRequirements calculateMinorAxisRequirements(int axis, SizeRequirements r) { 
		                                  if (r == null) { 
		                                        r = new SizeRequirements(); 
		                                  } 
		                                  float pref = layoutPool.getPreferredSpan(axis); 
		                                  float min = layoutPool.getMinimumSpan(axis); 
		                                  // Don't include insets, Box.getXXXSpan will include them. 
		                                    r.minimum = (int)min; 
		                                    r.preferred = Math.max(r.minimum, (int) pref); 
		                                    r.maximum = Integer.MAX_VALUE; 
		                                    r.alignment = 0.5f; 
		                                  return r; 
		                                } 
		 
		                            }; 
		                        } 
		                      return v; 
		                    } 
		                }; 
		            } 
		        }); 
			
			this.setContentType("text/html");
			this.setMinimumSize(new Dimension(0, 0)); 
		}
		public void setMessage(String s){
			this.setText(s);
			/*try {
				//lastMsg = s;
				//System.out.print(s);
				kit.insertHTML(doc, 0, s, 0, 0, null);
				//this.select(this.getHeight(),0);
			}
			catch (BadLocationException e) {}
			catch (IOException e) {}*/
		}
}
