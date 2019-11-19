/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;


/**
 *
 * @author Oumayma
 */
@ManagedBean (value="navigationController")
//@ManagedProperty (value="#{param.pageId}")
@Named(value = "navigationController")
@Dependent
public class NavigationController {
    private String pageId;
    public NavigationController() {
    }

    
    public String getPageId() {
        return pageId;
    }

   
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    public String moveToPage1() {
        return "page1";
    }
    public String showPage() {
        if(getPageId() == null ) {return "home";}
        if (getPageId().equals("1")) {return "page1";}
        else if (getPageId().equals("2")) {return "page2";}
        else {return "home";}
    }
    public String processPage1 () {return "page1";}
    public String processPage2 () {return "page2";}
}
