package com.project.smartdevice;

public class Tools {
    public static void delay(int milliSeconds)
    {
        try
        {
            Thread.sleep(milliSeconds);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
    public static void delay(){
        delay(1000);
    }
    public static void awaitUser(int seconds)
    {
        for(;seconds >= 0; seconds--)
        {
            delay();
            clearScreen();
            System.out.println("Please try again in ... (" + seconds + ")");
        }
        clearScreen();
    }
    public static void clearScreen()
    {
        System.out.println("\n".repeat(15));
    }
}
