package com.burgerhack.core.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Amritpal Singh on 8/29/16.
 */

/**
 * Activity that has the responsibility of handling all base level tasks in NotesDrive Application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Replaces a fragment on activity
     *
     * @param @{@link FragmentManager}
     * @param @{@link FragmentLauncher}
     */

    public void replaceContentFragment(FragmentManager fragmentManager, FragmentLauncher fragmentLauncher) {

        // Return if fragment to be added MainActivity.java is null
        if (fragmentLauncher.getFragment() == null) {
            throw new IllegalArgumentException("Null fragment passed in " + TAG + "#replaceContentFragment");
        }

        // getting the name of the fragment class
        String mFragmentName = ((Object) fragmentLauncher.getFragment()).getClass().getSimpleName();


        // replace with new content
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Animation for above ICS
        fragmentTransaction.setCustomAnimations(fragmentLauncher.getEnterAnim(),
                fragmentLauncher.getExitAnim(), fragmentLauncher.getPopEnterAnim(),
                fragmentLauncher.getPopExitAnim());
        if (fragmentLauncher.toAdd()) {
            fragmentTransaction.add(fragmentLauncher.getContainerId(),
                    fragmentLauncher.getFragment(), mFragmentName);

        } else {
            fragmentTransaction.replace(fragmentLauncher.getContainerId(),
                    fragmentLauncher.getFragment(), mFragmentName);
        }

        if (fragmentLauncher.isAddToStackTrace()) {
            fragmentTransaction.addToBackStack(mFragmentName);
        }

        fragmentTransaction.commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    protected Fragment getFragmentInContainer(int containerId) {
        return getSupportFragmentManager().findFragmentById(containerId);
    }

}
