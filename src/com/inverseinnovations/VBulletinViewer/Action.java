package com.inverseinnovations.VBulletinViewer;

import com.inverseinnovations.VBulletinViewer.ForumComponent.ForumAction;

public class Action {
	private VBulletinViewer App;
	
	private Action(){}
	
	private static class Instance{
		private static final Action INSTANCE = new Action();
	}
	
	public static Action INST(){
		return Instance.INSTANCE;
	}
	
	/**
	 * Needs to be called at least once, at first in the program.
	 * @param forumApp ForumApp
	 */
	public void setReference(VBulletinViewer forumApp){
		if(this.App != null){
			this.App = forumApp;
		}
	}
	
	public void doAction(ForumAction action){
		//TODO action
	}
}
