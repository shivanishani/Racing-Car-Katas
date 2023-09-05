package tddmicroexercises.telemetrysystem;

public interface ConnectionInterface {
    public void connect(String telemetryServerConnectionString);
    public void disconnect();
    public boolean getOnlineStatus();

}
