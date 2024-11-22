package net.thevpc.gaming.atom.examples.kombla.main.shared.model;

import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.model.Player;
import net.thevpc.gaming.atom.model.Sprite;

import java.util.List;

/**
 * Created by vpc on 10/7/16.
 */
public class DynamicGameModel {
    long frame; List<Sprite> sprites; java.util.List<Player> players;

    public DynamicGameModel() {

    }
    public DynamicGameModel(long frame, List<Sprite> sprites, List<Player> players) {
        this.frame = frame;
        this.sprites = sprites;
        this.players = players;
    }

    public DynamicGameModel setFrame(long frame) {
        this.frame = frame;
        return this;
    }

    public DynamicGameModel setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
        return this;
    }

    public DynamicGameModel setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public long getFrame() {
        return frame;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void movePlayerLeft(int playerId) {
        Player player = getPlayerById(playerId);

        if (player != null) {
            ModelPoint currentPosition = (ModelPoint) player.getPosition();
            int newX = currentPosition.getIntX() - 1;
            player.setPosition(new ModelPoint(newX, currentPosition.getIntY()));

            System.out.println("Moved player " + playerId + " to the left to position: (" + newX + ", " + currentPosition.getIntY() + ")");
        } else {
            System.out.println("Player with ID " + playerId + " not found.");
        }
    }
    public Player getPlayerById(int playerId) {
        for (Player player : players) {
            if (player.getId() == playerId) {
                return player;
            }
        }
        return null;
    }
    public void movePlayerRight(int playerId) {
        Player player = getPlayerById(playerId);

        if (player != null) {
            ModelPoint currentPosition = (ModelPoint) player.getPosition();
            int newX = currentPosition.getIntX() + 1;
            player.setPosition(new ModelPoint(newX, currentPosition.getIntY()));

            System.out.println("Moved player " + playerId + " to the right to position: (" + newX + ", " + currentPosition.getIntY() + ")");
        } else {
            System.out.println("Player with ID " + playerId + " not found.");
        }
    }
    public void movePlayerUp(int playerId) {
        Player player = getPlayerById(playerId);

        if (player != null) {
            ModelPoint currentPosition = (ModelPoint) player.getPosition();
            int newY = currentPosition.getIntY() - 1;
            player.setPosition(new ModelPoint(currentPosition.getIntX(), newY));

            System.out.println("Moved player " + playerId + " up to position: (" + currentPosition.getIntX() + ", " + newY + ")");
        } else {
            System.out.println("Player with ID " + playerId + " not found.");
        }
    }
    public void movePlayerDown(int playerId) {
        Player player = getPlayerById(playerId);

        if (player != null) {
            ModelPoint currentPosition = (ModelPoint) player.getPosition();
            int newY = currentPosition.getIntY() + 1;

            // Update the position
            player.setPosition(new ModelPoint(currentPosition.getIntX(), newY));

            System.out.println("Moved player " + playerId + " down to position: (" + currentPosition.getIntX() + ", " + newY + ")");
        } else {
            System.out.println("Player with ID " + playerId + " not found.");
        }
    }
    public void fireAction(int playerId) {
        Player player = getPlayerById(playerId);  // Retrieve the player object by ID

        if (player != null) {
            ModelPoint currentPosition = (ModelPoint) player.getPosition();
            String direction = player.getSelection().toString();

            System.out.println("Player " + playerId + " fired from position: (" + currentPosition.getIntX() + ", " + currentPosition.getIntY() + ") in direction: " + direction);


        } else {
            System.out.println("Player with ID " + playerId + " not found.");
        }
    }



}
