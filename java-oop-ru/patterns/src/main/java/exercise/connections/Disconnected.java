package exercise.connections;

// BEGIN

import exercise.TcpConnection;

public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        this.tcpConnection.setConnectionState(new Connected(this.tcpConnection));
    }

    @Override
    public void disconnect() {
        System.out.println("Error");

    }

    @Override
    public void write(String data) {
        System.out.println("Error");
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }
}
// END
