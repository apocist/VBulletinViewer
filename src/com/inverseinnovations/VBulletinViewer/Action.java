package com.inverseinnovations.VBulletinViewer;

import com.inverseinnovations.VBulletinAPI.Functions;
import com.inverseinnovations.VBulletinViewer.ForumComponent.ForumAction;

public class Action {
	private VBulletinViewer App;
	public static final int	FORUM_HOME		= ForumAction.FORUM_HOME,//TODO since calling action.FORUM_HOME is not considered a constant
							FORUM_DISPLAY	= ForumAction.FORUM_DISPLAY,
							THREAD_DISPLAY	= ForumAction.THREAD_DISPLAY;
	
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
			break;
		}
	}
}
