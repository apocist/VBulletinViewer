package com.inverseinnovations.VBulletinViewer;

import com.inverseinnovations.VBulletinViewer.Style.Style;
import com.inverseinnovations.VBulletinViewer.Window.Window;

public class VBulletinViewer {
	
	protected Window Window;
	protected Data Data;

	public VBulletinViewer(){
		Action.INST().setReference(this);
		Data = new Data(this);
		Window = new Window(this);
		Window.setVisible(true);
		@SuppressWarnings("unused")
		boolean nul = Data.waitUntilConnected();//before taking any other action
		Data.forumHome();
		Style.INST();
		/*System.out.println(Style.INST().style.thread.title.font);
		System.out.println(Style.INST().style.thread.title.font.size);
		System.out.println(Style.INST().style.thread.title.font.color);*/
	}
	
	public static void main(String[] arguments){
		new VBulletinViewer();
	}

		
}


