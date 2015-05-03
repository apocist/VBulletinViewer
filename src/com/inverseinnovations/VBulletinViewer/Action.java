package com.inverseinnovations.VBulletinViewer;

import com.inverseinnovations.VBulletinAPI.Functions;
import com.inverseinnovations.VBulletinViewer.Window.ForumComponent.ForumAction;

public class Action {
	private VBulletinViewer App;
	public static final int	FORUM_HOME		= 1,
							FORUM_DISPLAY	= 2,
							THREAD_DISPLAY	= 3;
	
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
		if(this.App == null){
			this.App = forumApp;
		}
	}
	
	public void doAction(ForumAction action){
		//TODO action
		switch(action.getAction()){
		case FORUM_HOME:
			App.Data.forumHome();
			break;
		case FORUM_DISPLAY:
			App.Data.forumView(Functions.convertToInt(action.getVal(1)));
			break;
		case THREAD_DISPLAY:
			//TODO
			System.out.println("Open Thread "+action.getVal(1));
			App.Data.threadView(Functions.convertToInt(action.getVal(1)));
			break;
		}
	}
}
