package ch.epfl.sdp;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.res.Resources;

import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.AuthUI.IdpConfig;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.FlowParameters;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static com.google.firebase.FirebaseApp.initializeApp;
import static org.mockito.Matchers.any;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnit4.class)
@PrepareForTest({FirebaseDatabase.class})
public class LoginActivityTest {
    private DatabaseReference mockedDatabaseReference;

    @Rule
    public final ActivityTestRule<LoginActivity> LoginTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    private LoginActivity LoginActivity = null;

    @Before
    public void setUp() throws Exception{
        LoginActivity = LoginTestRule.getActivity();
        mockedDatabaseReference = Mockito.mock(DatabaseReference.class);
    }

    @Test
    public FirebaseUser testLogin() {
        FirebaseDatabase mockedFirebaseDatabase = Mockito.mock(FirebaseDatabase.class);
        when(mockedFirebaseDatabase.getReference()).thenReturn(mockedDatabaseReference);
        PowerMockito.mockStatic(FirebaseDatabase.class);
        when(FirebaseDatabase.getInstance()).thenReturn(mockedFirebaseDatabase);
        final String TAG = "LoginTest";
        final String DEFAULT_APP_NAME = "[DEFAULT]";
        final String GOOGLE_PROVIDER = "Google.com";

        final FirebaseApp MOCK_APP;
        Context CONTEXT = ApplicationProvider.getApplicationContext();

        FirebaseApp app = mock(FirebaseApp.class);
        when(app.get(eq(FirebaseAuth.class))).thenReturn(mock(FirebaseAuth.class));
        when(app.getApplicationContext()).thenReturn(CONTEXT);
        when(app.getName()).thenReturn(DEFAULT_APP_NAME);
        MOCK_APP = app;

        //initialize
            CONTEXT = spy(CONTEXT);
            when(CONTEXT.getApplicationContext())
                    .thenReturn(CONTEXT);
            Resources spiedResources = spy(CONTEXT.getResources());
            when(CONTEXT.getResources()).thenReturn(spiedResources);

            AuthUI.setApplicationContext(CONTEXT);
            initializeApp(CONTEXT, new FirebaseOptions.Builder().setApiKey("fake").setApplicationId("fake").build());
            if (!FirebaseApp.getApps(CONTEXT).isEmpty())    return;

        //initialize Providers
            when(CONTEXT.getString(R.string.firebase_web_host)).thenReturn("abc");
            when(CONTEXT.getString(R.string.default_web_client_id)).thenReturn("abc");

        public static FirebaseUser getMockFirebaseUser() {
            FirebaseUser user = mock(FirebaseUser.class);
            when(user.getUid()).thenReturn("DEFAULT_ID");
            when(user.getEmail()).thenReturn("DEFAULT_EMAIL");
            when(user.getDisplayName()).thenReturn("DEFAULT_NAME");
            when(user.getPhotoUrl()).thenReturn(Uri.parse("DEFAULT_PhotoUrl"));

            return user;
        }

    }

    @After
    public void teardown() throws Exception{
        LoginActivity = null;
    }

}