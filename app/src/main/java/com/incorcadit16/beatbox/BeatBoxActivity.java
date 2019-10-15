package com.incorcadit16.beatbox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeatBoxActivity extends SingleFragmentActivity {

    @Override
    Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
