package exercise;

import exercise.connections.Connection;

// BEGIN
import exercise.connections.Disconnected;

public class TcpConnection implements Connection {
    private String ip;
    private int port;
    private Connection connectionState;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connectionState = new Disconnected(this);
    }

    public void setConnectionState(Connection connectionState) {
        this.connectionState = connectionState;
    }

    @Override
    public void connect() {
        this.connectionState.connect();
    }

    @Override
    public void disconnect() {
        this.connectionState.disconnect();

    }

    @Override
    public void write(String data) {
        this.connectionState.write(data);
    }

    @Override
    public String getCurrentState() {
        return this.connectionState.getCurrentState();
    }
}
// END
