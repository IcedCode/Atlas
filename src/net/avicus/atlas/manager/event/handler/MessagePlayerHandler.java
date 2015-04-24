package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Message;
import org.bukkit.entity.Player;

public class MessagePlayerHandler extends Handler<Message, Player> {

    public MessagePlayerHandler(Manager manager) {
        super(manager, "player", Message.class, Player.class);
    }

    @Override
    public void handle(Message event, Player handle) {
        handle.sendMessage(event.getMessage());
    }

}
