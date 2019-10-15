package com.incorcadit16.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;
    private float mSpeed = 1f;

    BeatBox(Context context) {
       mAssets = context.getAssets();
       // Конструктор считается устаревшим, но используется для совместимости
       mSoundPool = new SoundPool(MAX_SOUNDS,AudioManager.STREAM_MUSIC,0);
       loadSounds();
    }

    private void loadSounds() {
        String[] soundsNames;

        try {
            soundsNames = mAssets.list(SOUNDS_FOLDER);
        } catch (IOException e) {
            Log.e(TAG,"Could not list assets",e);
            return;
        }


        for (String name : soundsNames) {
            try {
            String assetPath = SOUNDS_FOLDER + "/" + name;
            Sound sound = new Sound(assetPath);
            load(sound);
            mSounds.add(sound);
            } catch (IOException e) {
                Log.e(TAG,"Could not load sound " + name,e);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor descriptor = mAssets.openFd(sound.getAssetPath());
        int id = mSoundPool.load(descriptor,1);
        sound.setSoundId(id);
    }

    void play(Sound sound) {
        if (sound.getSoundId() == null) return;
        if (mSpeed == 0f) return;
        mSoundPool.play(sound.getSoundId(),1f,1f,1,0,mSpeed);
    }

    void setSpeed(float speed) {
        mSpeed=speed;
    }

    void release() {
        mSoundPool.release();
    }

    List<Sound> getSounds() {
        return mSounds;
    }
}
