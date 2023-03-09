package exercise;
import java.util.List;
import java.util.ArrayList;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection implements Connection{
    private String ipAddress;
    private int port;
    private Connection status;
    private static List<String> buffer = new ArrayList<>();

    public TcpConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.status = new Disconnected(this);
    }

    public Connection getStatus() {
        return status;
    }

    public void setStatus(Connection status) {
        this.status = status;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    public void setBuffer(String data) {
        this.buffer.add(data);
    }

    @Override
    public String getCurrentState() {   
        return this.status.getCurrentState();
    }

    @Override
    public void connect() {
        this.status.connect();
    }

    @Override
    public void disconnect() {
        this.status.disconnect();
    }

    @Override
    public void write(String data) {
        this.status.write(data);
    }
}
// END
