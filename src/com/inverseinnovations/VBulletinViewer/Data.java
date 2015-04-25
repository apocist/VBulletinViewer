package com.inverseinnovations.VBulletinViewer;

import java.awt.Component;
import java.util.ArrayList;

import com.inverseinnovations.VBulletinAPI.Forum;
import com.inverseinnovations.VBulletinAPI.ForumHome;
import com.inverseinnovations.VBulletinAPI.VBulletinAPI;
import com.inverseinnovations.VBulletinAPI.Exception.*;
import com.inverseinnovations.VBulletinViewer.ForumComponent.ForumListItem;
import com.inverseinnovations.VBulletinViewer.Style.LabelStyle;
import com.inverseinnovations.VBulletinViewer.Style.Style;

class Data {
	protected VBulletinViewer App;
	protected String apiUrl = "http://sc2mafia.com/forum/api.php";
	protected String apiKey = "";//non-public key is hidden
	private int lastForum = 0;
	private int currentForum = 0;
	
	VBulletinAPI api;
	
	public Data(VBulletinViewer ref){
		App = ref;
		api = new VBulletinAPI(apiUrl, apiKey, "VBulletinViewer", "0.02");//TODO make connect funct
	}

	
	public boolean waitUntilConnected(){
		while(!api.isConnected()){
			
			//TODO need timeout break
		}
		return true;
	}
	
	public ForumHome getHome(){
		try {
			return api.forumHome();
		} catch (NoPermissionLoggedout e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoPermissionLoggedin e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VBulletinAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Forum getForum(int id){
		try {
			return api.forumView(id);
		} catch (NoPermissionLoggedout e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoPermissionLoggedin e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VBulletinAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void updateForumHistory(int currentForum){
		this.lastForum = this.currentForum;
		this.currentForum = currentForum = 0;
	}
	
	public void forumHome(){//TODO badly needs to be refactored
		
		//Forum Title
		LabelStyle forumTitleStyle = Style.INST().style.forum.title.font;
		//SubForum Title
		LabelStyle subForumTitleStyle = Style.INST().style.subforum.title.font;
		ArrayList<Forum> subForums = getHome().getSubForums();
		ArrayList<Component> panelList = new ArrayList<Component>();
		for(Forum forum : subForums){
			panelList.add(new ForumListItem(forum, forumTitleStyle, subForumTitleStyle));
		}
		
		updateForumHistory(0);
		App.Window.clearWindow();
		App.Window.addHeader();
		App.Window.addToList(panelList);
	}
	
	public void forumView(int id){//TODO badly needs to be refactored
		//Forum Title
		LabelStyle forumTitleStyle = Style.INST().style.forum.title.font;
		//SubForum Title
		LabelStyle subForumTitleStyle = Style.INST().style.subforum.title.font;
		ArrayList<Forum> subForums = getForum(id).getSubForums();
		ArrayList<Component> panelList = new ArrayList<Component>();
		for(Forum forum : subForums){
			panelList.add(new ForumListItem(forum, forumTitleStyle, subForumTitleStyle));
		}
		
		updateForumHistory(id);
		App.Window.clearWindow();
		App.Window.addHeader();
		App.Window.addToList(panelList);
	}
	
}
