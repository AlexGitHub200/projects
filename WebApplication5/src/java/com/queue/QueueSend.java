/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queue;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alex
 */
@Stateless
public class QueueSend {

    
    @Resource(mappedName="TestJMSQueue")
    private Queue queue;
    
    @Resource(mappedName="AlexConnectionFactory")
    private ConnectionFactory cf;
    
    private Message createJMSMessageFortestJMSQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    public void sendJMSMessageToTestJMSQueue(Object messageData) throws JMSException, NamingException {
        Context c = new InitialContext();
        //ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/AlexConnectionFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            
            //Destination destination = (Destination) c.lookup("java:comp/env/TestJMSQueue");
            MessageProducer mp = s.createProducer(queue);
            mp.send(createJMSMessageFortestJMSQueue(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    
    
}
