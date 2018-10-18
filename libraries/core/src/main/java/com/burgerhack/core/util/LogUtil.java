package com.burgerhack.core.util;

import android.util.Log;

/**
 * Utility class for proxy logging in Android apps. This class will handle changes between a Debug build and a Release Build. Before use, please set the debuggable flag by calling
 * All Log outputs will try to trim the tag to 23 characters as {@link Log} will throw an exception if tag is more than 23 characters
 * {@link LogUtil#setDebuggableFlag(boolean);}
 *
 * Created by Amritpal Singh on 8/29/16.
 */
public class LogUtil {

    private static final int TAG_MAX_LEN = 23;

    /**
     * Determines whether the logs should be published
     */
    private static boolean debuggable = true;

    /**
     * Sets the debuggable flag as per the current condition of the application which is using this class
     *
     * @param debuggable
     */
    public static void setDebuggableFlag(boolean debuggable) {
        LogUtil.debuggable = debuggable;
    }

    /**
     * Determine the current debuggable state of this class
     *
     * @return true if debug flag is set|false if debug flag is unset
     */
    public static boolean isDebuggable() {
        return debuggable;
    }

    /**
     * Sends a {@link Log#VERBOSE} log message and log the exception.
     * Calls {@link Log#v(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int v(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }
        return Log.v(trimToMaxLength(tag), msg);
    }

    /**
     * Send a {@link Log#VERBOSE} log message and log the exception.
     * Calls {@link Log#v(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int v(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }
        return Log.v(trimToMaxLength(tag), msg, tr);
    }

    /**
     * Send a {@link Log#DEBUG} log message.
     * Calls {@link Log#wtf(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int d(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }
        return Log.d(trimToMaxLength(tag), msg);
    }

    /**
     * Send a {@link Log#DEBUG} log message and log the exception.
     * Calls {@link Log#d(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int d(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }
        return Log.d(trimToMaxLength(tag), msg, tr);
    }

    /**
     * Send an {@link Log#INFO} log message.
     * Calls {@link Log#i(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int i(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }

        return Log.i(trimToMaxLength(tag), msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * Calls {@link Log#i(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int i(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.i(trimToMaxLength(tag), msg, tr);
    }

    /**
     * Send a {@link Log#WARN} log message.
     * Calls {@link Log#w(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int w(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }

        return Log.w(trimToMaxLength(tag), msg);
    }

    /**
     * Send a {@link Log#WARN} log message and log the exception.
     * Calls {@link Log#w(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int w(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.w(trimToMaxLength(tag), msg, tr);
    }

    /**
     * Send a {@link Log#WARN} log message and log the exception.
     * Calls {@link Log#w(String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param tr  An exception to log
     */
    public static int w(String tag, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.w(trimToMaxLength(tag), tr);
    }

    /**
     * Send an {@link Log#ERROR} log message.
     * Calls {@link Log#e(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int e(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }

        return Log.e(trimToMaxLength(tag), msg);
    }

    /**
     * Send a {@link Log#ERROR} log message and log the exception.
     * Calls {@link Log#e(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int e(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.e(trimToMaxLength(tag), msg, tr);
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     * <p/>
     * Calls {@link Log#wtf(String, String)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    public static int wtf(String tag, String msg) {
        if (!debuggable) {
            return 0;
        }

        return Log.wtf(trimToMaxLength(tag), msg);
    }


    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Calls {@link Log#wtf(String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.
     * @param tr  An exception to log.
     */
    public static int wtf(String tag, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.wtf(trimToMaxLength(tag), tr);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Calls {@link Log#wtf(String, String, Throwable)} if {@link LogUtil} is set as debuggable.
     *
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr  An exception to log.  May be null.
     */
    public static int wtf(String tag, String msg, Throwable tr) {
        if (!debuggable) {
            return 0;
        }

        return Log.wtf(trimToMaxLength(tag), msg, tr);
    }

    /**
     * Trims a string to maximum of {@link #TAG_MAX_LEN} characters
     *
     * @param s String to trim
     * @return "NULL" if null is passed to s | s if length of s <= {@link #TAG_MAX_LEN} | first 23 letters of s if length of s > {@link LogUtil#TAG_MAX_LEN}
     */
    private static final String trimToMaxLength(String s) {
        if (s == null) {
            return "NULL";
        }

        if (s.length() <= TAG_MAX_LEN) {
            return s;
        }

        return s.substring(0, TAG_MAX_LEN);
    }
}