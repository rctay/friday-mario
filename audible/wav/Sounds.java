package audible.wav;

import com.intellij.openapi.util.io.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Sounds {
    private final Map<String, byte[]> cache = new HashMap<String, byte[]>();
    public final Sound oneUp;
    public final Sound oneDown;
    public final Sound coin;
    public final Sound bowserfalls;
    public final Sound breakblock;
    public final Sound fireball;
    public final Sound fireworks;
    public final Sound gameover;
    public final Sound jumpSmall;
    public final Sound jumpSuper;
    public final Sound kick;
    public final Sound stomp;
    public final Sound powerupAppears;
    public final Sound powerup;

    public final Sound background;
    public final Sound backgroundSad;

    public Sounds() {
        try {
            oneUp = load("/audible/wav/smb_1-up.wav");
            oneDown = load("/audible/wav/smb_pipe.wav");
            coin = load("/audible/wav/smb_coin.wav");
            bowserfalls = load("/audible/wav/smb_bowserfalls.wav");
            breakblock = load("/audible/wav/smb_breakblock.wav");
            fireball = load("/audible/wav/smb_fireball.wav");
            fireworks = load("/audible/wav/smb_fireworks.wav");
            gameover = load("/audible/wav/smb_gameover.wav");
            jumpSmall = load("/audible/wav/smb_jump-small.wav");
            jumpSuper = load("/audible/wav/smb_jump-super.wav");
            kick = load("/audible/wav/smb_kick.wav");
            stomp = load("/audible/wav/smb_stomp.wav");
            powerup = load("/audible/wav/smb_powerup.wav");
            powerupAppears = load("/audible/wav/smb_powerup_appears.wav");

            background = load("/audible/wav/mario_08.wav");
            backgroundSad = load("/audible/wav/zelda_04.wav");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Sound load(String fileName) throws IOException {
        byte[] bytes = cache.get(fileName);
        if (bytes == null) {
            InputStream inputStream = Sounds.class.getResourceAsStream(fileName);
            if (inputStream == null) throw new RuntimeException("Cannot find " + fileName);

            bytes = StreamUtil.loadFromStream(inputStream);
            cache.put(fileName, bytes);
        }
        return new Sound(bytes, fileName);
    }
}

