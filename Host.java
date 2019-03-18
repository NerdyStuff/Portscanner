import java.net.Socket;

/**
 * Portscanner;
 *
 * Copyright by @author Marcel Mertens
 * Website: https://mertens-web.ddns.net
 *
 * Date: 17.03.2019
 */

public class Host implements Runnable
{
    String zHost = "";
    int zStartPort = 0;
    int zEndPort = 0;
    int zThreadNo = 0;

    public Host(int pThreadNo, String pHost, int pStartPort, int pEndPort)
    {
        zHost = pHost;
        zStartPort = pStartPort;
        zEndPort = pEndPort;
        zThreadNo = pThreadNo;
    }

    public void run()
    {
        for (int i = zStartPort; i <= zEndPort; i++)
        {
            try // Try to create Socket on given port
            {
                Socket s = new Socket(zHost, i);
                System.out.println("Thread #"+zThreadNo+": Port " + i + " at Host " + zHost + " is open!");
                s.close(); //Close Socket
            }

            catch (Exception ex) //If Port is closed throw exception
            {
                System.out.println("Thread #"+zThreadNo+": Port " + i + " at Host " + zHost + " is closed!");
            }
        }
    }
}
