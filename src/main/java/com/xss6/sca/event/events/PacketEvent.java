package com.xss6.sca.event.events;

import com.xss6.sca.event.EventStage;
import com.xss6.sca.util.Globals;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

public class PacketEvent extends EventStage implements Globals {
    private Packet<?> packet;
    public boolean hasSetPacket;

    public PacketEvent(int stage, Packet<?> packet) {
        super(stage);
        this.packet = packet;
        hasSetPacket = false;
    }

    public <T extends Packet<?>> T getPacket() {
        return (T) this.packet;
    }

    public void setPacket(Packet<?> packet){
        if(!nullCheck()){
            hasSetPacket = true;
            if(!this.isCancelled()){
                this.setCancelled(true);
            }
            mc.player.connection.sendPacket(packet);
        }
    }


    @Cancelable
    public static class Send extends PacketEvent {
        public Send(int stage, Packet<?> packet) {
            super(stage, packet);
        }
    }

    @Cancelable
    public static class Receive extends PacketEvent {
        public Receive(int stage, Packet<?> packet) {
            super(stage, packet);
        }
    }
}
