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
	
	VBulletinAPI api;
	
	public Data(VBulletinViewer ref){
		App = ref;
		api = new VBulletinAPI(apiUrl, apiKey, "ForumApp", "0.02");//TODO make connect funct
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
	
	public void forumHome(){//TODO badly needs to be refactored
		//Forum Title
		LabelStyle forumTitleStyle = Style.INST().style.forum.title.font;
				/*new LabelStyle();
			forumTitleStyle.textColor = Style.INST().getColor("list_forumTitleColor");
			forumTitleStyle.textColorHover = Style.INST().getColor("list_forumTitleColorHover");
			forumTitleStyle.textColorClick = Style.INST().getColor("list_forumTitleColorClick");
			forumTitleStyle.bgOpaque = Style.INST().getBoolean("list_forumTitleBGOpaque");
			forumTitleStyle.backgroundTextColor = Style.INST().getColor("list_forumTitleBGColor","list_forumTitleBGAlpha");
			forumTitleStyle.backgroundTextColorHover = Style.INST().getColor("list_forumTitleBGColorHover","list_forumTitleBGAlphaHover");
			forumTitleStyle.backgroundTextColorClick = Style.INST().getColor("list_forumTitleBGColorHoverClick","list_forumTitleBGClick");
			forumTitleStyle.font = Style.INST().getString("list_forumTitleFont");
			forumTitleStyle.style = Style.INST().getInt("list_forumTitleStyle");
			forumTitleStyle.size = Style.INST().getInt("list_forumTitleSize");*/
			
		//SubForum Title
		LabelStyle subForumTitleStyle = Style.INST().style.subforum.title.font;
				/*new LabelStyle();
			subForumTitleStyle.textColor = Style.INST().getColor("list_subForumTitleColor");
			subForumTitleStyle.textColorHover = Style.INST().getColor("list_subForumTitleColorHover");
			subForumTitleStyle.textColorClick = Style.INST().getColor("list_subForumTitleColorClick");
			subForumTitleStyle.bgOpaque = Style.INST().getBoolean("list_forumTitleBGOpaque");
			subForumTitleStyle.backgroundTextColor = Style.INST().getColor("list_subForumTitleBGColor","list_subForumTitleBGAlpha");
			subForumTitleStyle.backgroundTextColorHover = Style.INST().getColor("list_subForumTitleBGColorHover","list_subForumTitleBGAlphaHover");
			subForumTitleStyle.backgroundTextColorClick = Style.INST().getColor("list_subForumTitleBGColorHoverClick","list_subForumTitleBGClick");
			subForumTitleStyle.font = Style.INST().getString("list_subForumTitleFont");
			subForumTitleStyle.style = Style.INST().getInt("list_subForumTitleStyle");
			subForumTitleStyle.size = Style.INST().getInt("list_subForumTitleSize");*/
		ArrayList<Forum> subForums = getHome().getSubForums();
		ArrayList<Component> panelList = new ArrayList<Component>();
		for(Forum forum : subForums){
			panelList.add(new ForumListItem(forum, forumTitleStyle, subForumTitleStyle));
		}
		//TODO clear list?
		App.Window.addToList(panelList);
		App.Window.revalidate();
	}
	
}
