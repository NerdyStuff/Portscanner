/**
 * Portscanner;
 *
 * Copyright by @author Marcel Mertens
 * Website: https://mertens-web.ddns.net
 *
 * Date: 17.03.2019
 */

public class Portscanner
{
    private static int MULTIPLIER = 8; //Multiplier for Threads

    int zCores = Runtime.getRuntime().availableProcessors(); //Get cores for Thread calculation
    int zThreads = zCores * MULTIPLIER;

    int zPartLength = 0;;
    int zLastPart = 0;;
    int zStartPort = 0;
    int zEndPort = 0;
    String zHost = "";

    public Portscanner(String pHost, int pStartPort, int pEndPort)
    {
        zStartPort = pStartPort;
        zEndPort = pEndPort;
        zHost = pHost;

        System.out.println("The machine has " + zCores + " Cores");
        System.out.println("Use " + zThreads + " Threads");

        zPartLength = (zEndPort - zStartPort) / zThreads;
        zLastPart = (zEndPort - zStartPort) % zThreads;

        //Thread Array
        Thread[] zThreadArray = new Thread[zThreads+1];

        int zLastPort = zStartPort;

        for(int i = 0; i < zThreads; i++)
        {
            //Divide ports into equal parts on number of Threads
            zThreadArray[i] = new Thread(new Host(i, zHost, zLastPort, ((zLastPort+zPartLength)-1)));
            zThreadArray[i].start();

            zLastPort += zPartLength;
        }

        //Last Thread takes last ports
        zThreadArray[zThreads] = new Thread(new Host(zThreads, zHost, zLastPort, zEndPort));
        zThreadArray[zThreads].start();
    }
}
