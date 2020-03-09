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

//    private static ViewAction swipeFromRightToLeft() {
//        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_RIGHT,
//                GeneralLocation.CENTER_LEFT, Press.FINGER);
//    }
//
//    private static ViewAction swipeFromBottomToTop() {
//        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
//                GeneralLocation.TOP_CENTER, Press.FINGER);
//    }
//
//    private static ViewAction swipeFromLeftToRight() {
//        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_LEFT,
//                GeneralLocation.CENTER_RIGHT, Press.FINGER);
//    }

    @Before
    public void setUp() throws Exception{
        LoginActivity = LoginTestRule.getActivity();
    }

    @Test
    public void testLogin() {
        View view = LoginActivity.findViewById(R.id.button_sign_in);
        assertNotNull(view);
        // onView(withId(R.id.mainName)).perform(typeText("from my unit test")).perform(closeSoftKeyboard());
//        onView(withId(R.id.sign_in_)).perform(click());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromRightToLeft());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromBottomToTop());
//        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromLeftToRight());
        // onView(withId(R.id.greetingMessage)).check(matches(withText("Hello from my unit test!")));
    }

    @After
    public void teardown() throws Exception{
        LoginActivity = null;
    }

}