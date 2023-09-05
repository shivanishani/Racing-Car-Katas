package tddmicroexercises.telemetrysystem;



public class TelemetryDiagnosticControls implements TelemetryDiagnosticControlsInterface
{

    private final TelemetryClientInterface telemetryClient;

    private final ConnectionInterface connect;
    private String diagnosticInfo = "";


        public TelemetryDiagnosticControls(TelemetryClientInterface telemetryClient, ConnectionInterface connect)
        {
            this.telemetryClient = telemetryClient;
            this.connect = connect;
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            connect.disconnect();
    
            int retryLeft = 3;
            while (!connect.getOnlineStatus()  && retryLeft > 0)
            {
                connect.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(!connect.getOnlineStatus())
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryClient.send(telemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClient.receive();
    }
}
