package com.tw.menu;

import java.util.ArrayList;
import java.util.List;
public class MenuTree{
	private List<MenuUtils> menuList = new ArrayList<MenuUtils>();
	public MenuTree(List<MenuUtils> menuList) {
		this.menuList=menuList;
	}

	//建立树形结构
	public List<MenuUtils> builTree(){
		List<MenuUtils> treeMenus =new  ArrayList<MenuUtils>();
		for(MenuUtils menuNode : getRootNode()) {
			menuNode=buildChilTree(menuNode);
			treeMenus.add(menuNode);
		}
		return treeMenus;
	}

	//递归，建立子树形结构
	public MenuUtils buildChilTree(MenuUtils pNode){
		List<MenuUtils> chilMenus =new  ArrayList<MenuUtils>();
		for(MenuUtils menuNode : menuList) {
			if(menuNode.getPid().equals(pNode.getId().toString())) {
				chilMenus.add(buildChilTree(menuNode));
			}
		}
		pNode.setChildren(chilMenus);
		return pNode;
	}

	//获取根节点(获取所有的父节点)
	public List<MenuUtils> getRootNode() {
		List<MenuUtils> rootMenuLists =new  ArrayList<MenuUtils>();
		for(MenuUtils menuNode : menuList) {
			if(menuNode.getPid().equals("0")) {
				rootMenuLists.add(menuNode);
			}
		}
		return rootMenuLists;
	}
}