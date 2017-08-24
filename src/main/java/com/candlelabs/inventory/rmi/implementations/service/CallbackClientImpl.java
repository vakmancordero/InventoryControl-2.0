package com.candlelabs.inventory.rmi.implementations.service;

import com.candlelabs.inventory.rmi.interfaces.service.MessageResponder;
import com.candlelabs.inventory.rmi.interfaces.service.ServerResponder;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author VakSF
 */
public class CallbackClientImpl extends UnicastRemoteObject
     implements MessageResponder {
    
    private String name;
    private ServerResponder server;
    
    public CallbackClientImpl(
            ServerResponder serverResponder, String name) throws RemoteException {
        
        super();
        
        this.name = name;
        
        this.server = serverResponder;
        
        System.out.println("New Callback Client");
    }

    public ServerResponder getServer() {
        return server;
    }

    @Override
    public void sendMessageToClient(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public String getName() throws RemoteException {
        return null;
    }

    @Override
    public void renameIfExist(String name) throws RemoteException {
        this.name = name;
    }
    
    @Override
    public void exit() throws RemoteException {
        if (!server.isOnline(this))
            System.exit(0);
    }
    
}