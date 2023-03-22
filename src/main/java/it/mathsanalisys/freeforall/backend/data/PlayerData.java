package it.mathsanalisys.freeforall.backend.data;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class PlayerData {

    @Getter
    public static Map<UUID, PlayerData> datas = new HashMap<>();
    private String name;
    private UUID uuid;
    private int kills, deaths, killStreak, maxStreak, goldenAppleConsumed, arrowHit, rodHit;

    public PlayerData(UUID uuid, String name){
        this.uuid = uuid;
        this.name = name;
        datas.put(uuid, this);
    }

    public PlayerData(UUID uuid){

    }



}
