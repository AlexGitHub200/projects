/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.queue.QueueSend;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.naming.NamingException;

/**
 *
 * @author alex
 */
@WebService
public class WsJmsBean {
    
     @EJB
    private QueueSend queueSend;
    
    
    public String sendToJms(String message) throws JMSException, NamingException{
     queueSend.sendJMSMessageToTestJMSQueue(message + " is created");
     
     return "sent";
    
}
}
