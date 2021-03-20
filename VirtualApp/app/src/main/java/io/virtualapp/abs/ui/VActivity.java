package io.virtualapp.abs.ui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.flurry.android.FlurryAgent;

import org.jdeferred.android.AndroidDeferredManager;

import io.virtualapp.abs.BaseView;

/**
 * @author Lody
 */
public class VActivity extends AppCompatActivity {

    /**
     * Implement of {@link BaseView#getActivity()}
     */
    public Activity getActivity() {
        return this;
    }

    /**
     * Implement of {@link BaseView#getContext()} ()}
     */
    public Context getContext() {
        return this;
    }

    protected AndroidDeferredManager defer() {
        return VUiKit.defer();
    }

    public Fragment findFragmentById(@IdRes int id) {
        return getSupportFragmentManager().findFragmentById(id);
    }

    public void replaceFragment(@IdRes int id, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FlurryAgent.onStartSession(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
