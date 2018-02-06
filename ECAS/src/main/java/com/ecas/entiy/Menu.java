package com.ecas.entiy;

import com.ecas.common.base.model.BaseEntiy;

/**
 * Created by lenovo on 2017/12/23.
 */
public class Menu extends BaseEntiy {


    private String menuId;
    private String menuName;
    private String menuLevel;
    private String menuType;
    private String childMenuId;

    public Menu() {
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getChildMenuId() {
        return childMenuId;
    }

    public void setChildMenuId(String childMenuId) {
        this.childMenuId = childMenuId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuType='" + menuType + '\'' +
                ", childMenuId='" + childMenuId + '\'' +
                '}';
    }
}
