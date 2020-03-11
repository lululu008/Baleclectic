package ch.epfl.sdp;

import android.util.Log;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public final ActivityTestRule<LoginActivity> LoginTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity LoginActivity = null;

    @Before
    public void setUp() throws Exception{
        LoginActivity = LoginTestRule.getActivity();
    }

    @Test
    public void testLogin() {
        View view = LoginActivity.findViewById(R.id.button_sign_in);
        assertNotNull(view);
//        onView(withId(R.id.sign_in_)).perform(click());
    }

    @After
    public void teardown() throws Exception{
        LoginActivity = null;
    }

}