package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already connected");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setConnectionState(new Disconnected(this.tcpConnection));
    }

    @Override
    public void write(String data) {

    }

    @Override
    public String getCurrentState() {
        return "connected";
    }
}
// END
