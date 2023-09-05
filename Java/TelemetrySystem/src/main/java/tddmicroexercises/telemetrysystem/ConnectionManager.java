package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class ConnectionManager implements ConnectionInterface{
    private boolean onlineStatus;

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    private final Random connectionEventsSimulator ;

    public ConnectionManager(){
        connectionEventsSimulator = new Random(42);
    }

    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || telemetryServerConnectionString.isEmpty())
        //"".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        // boolean success = connectionEventsSimulator.nextInt(10) <= 8;
        // onlineStatus = success;
        onlineStatus = connectionEventsSimulator.nextInt(10) <= 8;

    }

    public void disconnect()
    {
        onlineStatus = false;
    }
}
