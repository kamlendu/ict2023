/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/itqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class SecondQueueBean implements MessageListener {
    
    public SecondQueueBean() {
    }
    
    @Override
    public void onMessage(Message message) {
          String msg;
        
        try{
        if(message instanceof TextMessage)
        {
            msg = ((TextMessage) message).getText();
            
            System.out.println("SecondQueueBean has recieved : "+ msg);
        }
        }
        catch(JMSException e)
        {
            
        }
    }
    
}
