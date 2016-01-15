package com.peirr.yodaspeak;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.peirr.yodaspeak.ui.MainActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public IntentsTestRule<MainActivity> mAddNoteIntentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

}