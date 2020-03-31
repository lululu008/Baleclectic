package ch.epfl.sdp;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sdp.timetable.Timetable;

@RunWith(AndroidJUnit4.class)
public class TimetableTest {
    @Rule
    public final ActivityTestRule<Timetable> mActivityRule =
            new ActivityTestRule<>(Timetable.class);

    private static ViewAction swipeFromRightToLeft() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_RIGHT,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }

    private static ViewAction swipeFromBottomToTop() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    private static ViewAction swipeFromLeftToRight() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.CENTER_LEFT,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    @Test
    public void testCanGreetUsers() {
        // onView(withId(R.id.mainName)).perform(typeText("from my unit test")).perform(closeSoftKeyboard());
        //onView(withId(R.id.timetableBtn)).perform(click());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromRightToLeft());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromBottomToTop());
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(swipeFromLeftToRight());
        // onView(withId(R.id.greetingMessage)).check(matches(withText("Hello from my unit test!")));
    }

}
