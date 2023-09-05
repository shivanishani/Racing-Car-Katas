package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TelemetryDiagnosticControlsTest
{

    static TelemetryClientInterface client;
    static ConnectionInterface connection;
    static TelemetryDiagnosticControlsInterface telemetryDiagnosticControls;

    @BeforeAll
    public static void prep(){
        client = new TelemetryClient();
        connection = new ConnectionManager();
        telemetryDiagnosticControls = new TelemetryDiagnosticControls(client, connection);

    }
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
        try {
            telemetryDiagnosticControls.checkTransmission();
        }catch (Exception e){
            System.out.print("Exception");
        }
        client.send("hi");
        String s = client.receive();
        System.out.printf(s);

        //client.send("AT#UD");
    }

}
