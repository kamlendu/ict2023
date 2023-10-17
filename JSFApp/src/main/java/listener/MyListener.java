/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author root
 */
public class MyListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
    if(event.getPhaseId()== PhaseId.RESTORE_VIEW)
    {
        System.out.println("After Restore View");     
    }
     if(event.getPhaseId()== PhaseId.APPLY_REQUEST_VALUES)
    {
        System.out.println("After Apply Request value");     
    }
     if(event.getPhaseId()== PhaseId.PROCESS_VALIDATIONS)
    {
        System.out.println("After process VAlidation");     
    }
      if(event.getPhaseId()== PhaseId.UPDATE_MODEL_VALUES)
    {
        System.out.println("After Update Model values");     
    }
      if(event.getPhaseId()== PhaseId.RENDER_RESPONSE)
    {
        System.out.println("After render response");     
    }
    
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     if(event.getPhaseId()== PhaseId.RESTORE_VIEW)
    {
        System.out.println("Before Restore View");     
    }
     if(event.getPhaseId()== PhaseId.APPLY_REQUEST_VALUES)
    {
        System.out.println("Before Apply Request value");     
    }
     if(event.getPhaseId()== PhaseId.PROCESS_VALIDATIONS)
    {
        System.out.println("Before process VAlidation");     
    }
      if(event.getPhaseId()== PhaseId.UPDATE_MODEL_VALUES)
    {
        System.out.println("Before Update Model values");     
    }
      if(event.getPhaseId()== PhaseId.RENDER_RESPONSE)
    {
        System.out.println("Before render response");     
    }
    
    }

    @Override
    public PhaseId getPhaseId() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return PhaseId.ANY_PHASE;
    }
    
    
    
}
