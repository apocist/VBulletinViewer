package com.inverseinnovations.VBulletinViewer.ForumComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.inverseinnovations.VBulletinAPI.Functions;
import com.inverseinnovations.VBulletinViewer.Action;

public class ForumAction {
	public static final int	FORUM_HOME		= Action.FORUM_HOME,
							FORUM_DISPLAY	= Action.FORUM_DISPLAY,
							THREAD_DISPLAY	= Action.THREAD_DISPLAY;
	private int action;
	private List<String> values = new ArrayList<String>();

	public ForumAction(int action) {
		this(action, "");
	}
	
	public ForumAction(int action, int... vals) {
		this(action, convertIntToStrings(vals));
	}
	
	public ForumAction(int action, String... vals) {
		this.action = action;
		if(vals != null){
			if(vals.length > 0){
				values = new ArrayList<String>(Arrays.asList(vals));
			}
		}
	}
	
	public int getAction(){
		return action;
	}
	
	/**
	 * Returns the String assigned to a value
	 * @param index greater than 0 (1-4)
	 * @return
	 */
	public String getVal(int index){
		if(index > 0){
			index--;
			if(values.size() > index){
				return values.get(index);
			}
		}
		return "";
	}
	private static String[] convertIntToStrings(int... vals){
		if(vals != null){
			if(vals.length > 0){
				List<String> stringList = new ArrayList<String>();
				for(int val : vals){
					stringList.add(Functions.convertToString(val));
				}
				String[] strings = new String[stringList.size()];
				strings = stringList.toArray(strings);
				return strings;
			}
		}
		return new String[]{};
	}
}
