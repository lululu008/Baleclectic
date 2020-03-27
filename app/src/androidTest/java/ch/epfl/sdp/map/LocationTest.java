package ch.epfl.sdp.map;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sdp.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class LocationTest {

    static Intent intent;
    static {
        MeetingPoints mp  = MapSelectionActivity.map1MeetingPoints();
        intent = new Intent(ApplicationProvider.getApplicationContext(), DistanceActivity.class);
        intent.putExtra("points", mp);
        intent.putExtra("title", "Mock Distance");
        intent.putExtra("isMock", true);
    }

    UiDevice mDevice = UiDevice
            .getInstance(InstrumentationRegistry.getInstrumentation());

    @Rule
    public ActivityScenarioRule<DistanceActivity> activityScenarioRule = new ActivityScenarioRule<>(intent);

    @Test
    public void testCanGetDistance() {

        ActivityScenario<DistanceActivity> scenario = activityScenarioRule.getScenario();
        scenario.onActivity(new ActivityScenario.ActivityAction<DistanceActivity>() {
                                @Override
                                public void perform(DistanceActivity activity) {
                                    MockLocation mockLocation = new MockLocation(activity);
                                    activity.setLocationProvider(mockLocation);
                                    activity.setLocationNecessary(false);
                                }
                            });

        onView(withId(R.id.updateLocationButton)).perform(click());

        String empty = "";
        String rlc = "Rolex Learning Center";

        onView(withId(R.id.textView)).check(matches(not(withText(empty))));
        onView(withId(R.id.textView)).check(matches(withSubstring(rlc)));

        onView(withId(R.id.updateLocationButton)).perform(click());

        onView(withId(R.id.updateLocationButton)).perform(click());
    }
}
