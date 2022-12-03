package com.changgou.goods.pojo;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:admin
 * @Description:RoleMenu构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="tb_role_menu")
public class RoleMenu implements Serializable{

	@Id
    @Column(name = "role_id")
	private Integer roleId;//

    @Column(name = "menu_id")
	private String menuId;//



	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	//get方法
	public String getMenuId() {
		return menuId;
	}

	//set方法
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


}
