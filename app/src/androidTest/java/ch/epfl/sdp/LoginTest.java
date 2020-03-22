package ch.epfl.sdp;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.runner.RunWith;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.android.internal.creation.AndroidByteBuddyMockMaker;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest{
    private static final int RC_SIGN_IN = 123;

    @Mock
    FirebaseAuth mockAuth = org.mockito.Mockito.mock(com.google.firebase.auth.FirebaseAuth.class);
    private AndroidByteBuddyMockMaker PowerMock;
    //AuthUI mockUI = org.mockito.Mockito.mock(com.firebase.ui.auth.AuthUI.class);

    @Before
    public void setup(){
        //PowerMock.createMock(com.firebase.ui.auth.AuthUI.class);
    }

    @Rule
    public final ActivityTestRule<LoginActivity> LoginActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void test_login(){
        assertEquals(4, 2 + 2);
        //FirebaseAuth getInstance() = mock(Instance.class);
        //when(mockAuth.getInstance()).thenReturn(null);
        //when(AuthUI.getInstance()).thenReturn(null);
        //when(new AuthUI.IdpConfig.GoogleBuilder().build()).thenReturn(null);

    }

}
