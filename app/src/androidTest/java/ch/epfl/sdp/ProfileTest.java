package ch.epfl.sdp;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@RunWith(AndroidJUnit4.class)
public class ProfileTest {
    @Mock
    private ArrayList mockList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final ActivityTestRule<ProfileActivity> ProfileActivityRule =
            new ActivityTestRule<>(ProfileActivity.class);
    private static final String TAG = "TestLogin";
    private static final String DEFAULT_NAME = "[DEFAULT]";
    Instrumentation.ActivityMonitor monitor_signout = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Test
    public void test_profile(){
        assertNotNull(ProfileActivityRule.getActivity().findViewById(R.id.sign_out_button));
        onView(withId(R.id.sign_out_button)).perform(click());
        Activity MainActivity = getInstrumentation().waitForMonitorWithTimeout(monitor_signout, 5000);
        assertNotNull(MainActivity);

        Mockito.when(user.getDisplayName()).thenReturn("test_name");
        assertEquals(textName, "test_name");
    }
}
