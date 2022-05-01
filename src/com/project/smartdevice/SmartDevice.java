package com.project.smartdevice;

public class SmartDevice implements ISmartDevice{
    private INetworkInterface networkInterface;

    SmartDevice(){
        networkInterface = new NetworkInterface();
    }
    @Override
    public void run()
    {
        networkInterface = null;
    }
}
