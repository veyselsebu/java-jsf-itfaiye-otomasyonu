/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class yollar {

    public String LoginGit(){
          return "/login?faces-redirect=true";

    }
    
}
