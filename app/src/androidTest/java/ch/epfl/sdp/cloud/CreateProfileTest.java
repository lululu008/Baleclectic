package ch.epfl.sdp.cloud;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import ch.epfl.sdp.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


public class CreateProfileTest {

    private static Intent intent = new Intent(ApplicationProvider.getApplicationContext(), CreateUserProfile.class);

    @Rule
    public ActivityScenarioRule<CreateUserProfile> activityScenarioRule = new ActivityScenarioRule<>(intent);

    @Test
    public void test_create(){

        ActivityScenario<CreateUserProfile> scenario = activityScenarioRule.getScenario();
        scenario.onActivity(new ActivityScenario.ActivityAction<CreateUserProfile>() {
            @Override
            public void perform(CreateUserProfile activity) {
                mockCloudStore mock = new mockCloudStore();
                activity.setCloudStore(mock);
            }
        });

        onView(ViewMatchers.withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_yy)).perform(typeText("1999")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_mm)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.date_dd)).perform(typeText("01")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.user_name_edit)).perform(typeText("John")).perform(closeSoftKeyboard());
        onView(withId(R.id.register_button)).perform(click());
        onView(withId(R.id.female)).perform(click());
        onView(withId(R.id.register_button)).perform(click());


    }

}
