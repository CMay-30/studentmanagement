package com.tw.menu;

import java.util.List;


public class MenuUtils {
	private Long id;
	private String pid;
	private String authName;
	private String path;
	private String role;
	private List<MenuUtils> children;

	public MenuUtils(Long id, String pid, String authName, String path, String role, List<MenuUtils> children) {
		this.id = id;
		this.pid = pid;
		this.authName = authName;
		this.path = path;
		this.role = role;
		this.children = children;
	}

	public MenuUtils() {
	}

	@Override
	public String toString() {
		return "Menu{" +
				"id=" + id +
				", pid=" + pid +
				", authName='" + authName + '\'' +
				", path='" + path + '\'' +
				", role='" + role + '\'' +
				", children=" + children +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<MenuUtils> getChildren() {
		return children;
	}

	public void setChildren(List<MenuUtils> children) {
		this.children = children;
	}
}