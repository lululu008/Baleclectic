package ch.epfl.sdp;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class ToolbarTest {
    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_toolbar() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        //check toolbar tile
        onView(withId(R.id.toolbar)).check(matches(withToolbarTitle("Home")));
    }

    //check toolbar title function
    private static Matcher<View> withToolbarTitle(CharSequence title) {
        return withToolbarTitle(is(title));
    }

    private static Matcher<View> withToolbarTitle(final Matcher<CharSequence> textMatcher) {
        return new BoundedMatcher<View, Toolbar>(Toolbar.class) {
            @Override
            public boolean matchesSafely(Toolbar toolbar) {
                return textMatcher.matches(toolbar.getTitle());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
        };
    }
}
