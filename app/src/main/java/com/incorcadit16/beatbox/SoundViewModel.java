package com.incorcadit16.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    Sound getSound() {
        return mSound;
    }

    void setSound(Sound mSound) {
        this.mSound = mSound;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
