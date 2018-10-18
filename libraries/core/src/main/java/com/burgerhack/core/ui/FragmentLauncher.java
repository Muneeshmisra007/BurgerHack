package com.burgerhack.core.ui;

/**
 * Created by Amritpal Singh on 5/27/17.
 */

public class FragmentLauncher {

    int mContainerId;
    BaseFragment mFragment;
    boolean mToAdd;
    boolean mIsAddToStackTrace;
    int mEnterAnim;
    int mExitAnim;
    int mPopEnterAnim;
    int mPopExitAnim;

    private FragmentLauncher() {
    }

    public static class FragmentLaunchBuilder {

        FragmentLauncher mFragmentLauncher;

        public FragmentLaunchBuilder() {
            mFragmentLauncher = new FragmentLauncher();
        }

        public FragmentLaunchBuilder setContainerId(int containerId) {
            mFragmentLauncher.mContainerId = containerId;
            return this;
        }

        public FragmentLaunchBuilder setFragment(BaseFragment fragment) {
            mFragmentLauncher.mFragment = fragment;
            return this;
        }

        public FragmentLaunchBuilder setAddReplace(boolean toAdd) {
            mFragmentLauncher.mToAdd = toAdd;
            return this;
        }

        public FragmentLaunchBuilder setAddToBackStack(boolean toAdd) {
            mFragmentLauncher.mIsAddToStackTrace = toAdd;
            return this;
        }

        public FragmentLaunchBuilder setEnterAnim(int enterAnim) {
            mFragmentLauncher.mEnterAnim = enterAnim;
            return this;
        }

        public FragmentLaunchBuilder setExitAnim(int exitAnim) {
            mFragmentLauncher.mExitAnim = exitAnim;
            return this;
        }

        public FragmentLaunchBuilder setPopAnim(int popEnterAnim) {
            mFragmentLauncher.mPopEnterAnim = popEnterAnim;
            return this;
        }

        public FragmentLaunchBuilder setPopExitAnim(int popExitAnim) {
            mFragmentLauncher.mPopExitAnim = popExitAnim;
            return this;
        }

        public FragmentLauncher build() {
            return mFragmentLauncher;
        }
    }


    public int getContainerId() {
        return mContainerId;
    }

    public BaseFragment getFragment() {
        return mFragment;
    }

    public boolean toAdd() {
        return mToAdd;
    }

    public boolean isAddToStackTrace() {
        return mIsAddToStackTrace;
    }

    public int getEnterAnim() {
        return mEnterAnim;
    }

    public int getExitAnim() {
        return mExitAnim;
    }

    public int getPopEnterAnim() {
        return mPopEnterAnim;
    }

    public int getPopExitAnim() {
        return mPopExitAnim;
    }

}
