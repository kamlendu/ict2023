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
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "client1"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/icttopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/icttopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class FirstTopicBean implements MessageListener {
    
    public FirstTopicBean() {
    }
    
    @Override
    public void onMessage(Message message) {
          String msg;
        
        try{
        if(message instanceof TextMessage)
        {
            msg = ((TextMessage) message).getText();
            
            System.out.println("FirstTopicBean has recieved : "+ msg);
        }
        }
        catch(JMSException e)
        {
            
        }
    }
    
}
