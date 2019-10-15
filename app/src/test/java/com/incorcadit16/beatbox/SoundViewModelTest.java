package com.incorcadit16.beatbox;

import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSubject = new SoundViewModel(mBeatBox);
        mSound = new Sound("assetPath");
        mSubject.setSound(mSound);
    }

    @Test
    public void SoundNameIsTitle() {
        assertThat(mSubject.getTitle(),is(mSound.getName()));
    }

    @Test
    public void callBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();

        verify(mBeatBox).play(mSound);
    }
}