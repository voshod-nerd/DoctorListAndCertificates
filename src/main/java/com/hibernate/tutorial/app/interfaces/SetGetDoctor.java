/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.app.interfaces;

import com.hibernate.tutorial.entity.SpisokVrach;

/**
 *
 * @author Талалаев
 */
public interface SetGetDoctor {
   public void setChosenDoctor(SpisokVrach chosenPrvs);
   public SpisokVrach getChosenDoctor();
    
}
