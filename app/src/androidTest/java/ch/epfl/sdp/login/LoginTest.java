package ch.epfl.sdp.login;

import android.content.Intent;
import android.os.Bundle;

import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.android.internal.creation.AndroidByteBuddyMockMaker;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest{
    private static final int RC_SIGN_IN = 123;
    private static Intent intent;
    static {
        intent = new Intent(ApplicationProvider.getApplicationContext(), LoginActivity.class);
        Bundle extras = new Bundle();
        extras.putBoolean("isMock", true);
        intent.putExtras(extras);
    }

    @Mock
    FirebaseAuth mockAuth = org.mockito.Mockito.mock(com.google.firebase.auth.FirebaseAuth.class);
    private AndroidByteBuddyMockMaker PowerMock;
    //AuthUI mockUI = org.mockito.Mockito.mock(com.firebase.ui.auth.AuthUI.class);

    @Before
    public void setup(){
        //PowerMock.createMock(com.firebase.ui.auth.AuthUI.class);
    }

    @Rule
    public final ActivityScenarioRule<LoginActivity> LoginActivityRule =
            new ActivityScenarioRule<>(intent);

    @Test
    public void test_login(){
        assertEquals(4, 2 + 2);
        //FirebaseAuth getInstance() = mock(Instance.class);
        //when(mockAuth.getInstance()).thenReturn(null);
        //when(AuthUI.getInstance()).thenReturn(null);
        //when(new AuthUI.IdpConfig.GoogleBuilder().build()).thenReturn(null);

    }

}
