package com.xss6.sca.networking.proxy;

import com.xss6.sca.ScaMod;
import com.xss6.sca.event.events.PacketEvent;
import com.xss6.sca.event.processor.CommitEvent;
import com.xss6.sca.event.processor.EventPriority;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;

public final class ScaProxy {
    public final String host;
    public final int port;
    public final Mode mode;

    public ScaProxy(final int port, @NotNull final String host, final Mode mode){
        this.port = port;
        this.host = host;
        this.mode = mode;
        ScaMod.EVENT_PROCESSOR.addEventListener(this);
    }

    public final Socket bind() throws IOException {
        return new Socket(host, port);
    }

    public static String[] getData(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        return r.readLine().split(":");
    }

    public static void sendData(Socket socket, String data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(stream, true);
        writer.println(data);
    }


    @CommitEvent(priority = EventPriority.HIGH)
    public final void cPacketEvent(PacketEvent.Send event){
        if(mode.equals(Mode.CLIENT)){
            CPacketHandler cPacketHandler = new CPacketHandler(event);
        }
    }

    public enum Mode {
        CLIENT,
        SERVER
    }
}
