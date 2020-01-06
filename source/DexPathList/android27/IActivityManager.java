/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: frameworks/base/core/java/android/app/IActivityManager.aidl
 */
package android.app;

/**
 * System private API for talking with the activity manager service.  This
 * provides calls from the application back to the activity manager.
 * <p>
 * {@hide}
 */
public interface IActivityManager extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements android.app.IActivityManager {
        private static final java.lang.String DESCRIPTOR = "android.app.IActivityManager";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.app.IActivityManager interface,
         * generating a proxy if needed.
         */
        public static android.app.IActivityManager asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof android.app.IActivityManager))) {
                return ((android.app.IActivityManager) iin);
            }
            return new android.app.IActivityManager.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_openContentUri: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.ParcelFileDescriptor _result = this.openContentUri(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_handleApplicationCrash: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.app.ApplicationErrorReport.ParcelableCrashInfo _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.app.ApplicationErrorReport.ParcelableCrashInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.handleApplicationCrash(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    int _arg6;
                    _arg6 = data.readInt();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.app.ProfilerInfo _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    int _result = this.startActivity(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_unhandledBack: {
                    data.enforceInterface(DESCRIPTOR);
                    this.unhandledBack();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _arg3;
                    _arg3 = data.readInt();
                    boolean _result = this.finishActivity(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_registerReceiver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.IIntentReceiver _arg2;
                    _arg2 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
                    android.content.IntentFilter _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.IntentFilter.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    int _arg5;
                    _arg5 = data.readInt();
                    int _arg6;
                    _arg6 = data.readInt();
                    android.content.Intent _result = this.registerReceiver(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_unregisterReceiver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentReceiver _arg0;
                    _arg0 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
                    this.unregisterReceiver(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_broadcastIntent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    android.content.IIntentReceiver _arg3;
                    _arg3 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
                    int _arg4;
                    _arg4 = data.readInt();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    android.os.Bundle _arg6;
                    if ((0 != data.readInt())) {
                        _arg6 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg6 = null;
                    }
                    java.lang.String[] _arg7;
                    _arg7 = data.createStringArray();
                    int _arg8;
                    _arg8 = data.readInt();
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    boolean _arg10;
                    _arg10 = (0 != data.readInt());
                    boolean _arg11;
                    _arg11 = (0 != data.readInt());
                    int _arg12;
                    _arg12 = data.readInt();
                    int _result = this.broadcastIntent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_unbroadcastIntent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    int _arg2;
                    _arg2 = data.readInt();
                    this.unbroadcastIntent(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishReceiver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    android.os.Bundle _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    boolean _arg4;
                    _arg4 = (0 != data.readInt());
                    int _arg5;
                    _arg5 = data.readInt();
                    this.finishReceiver(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    return true;
                }
                case TRANSACTION_attachApplication: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    this.attachApplication(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_activityIdle: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.res.Configuration _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.res.Configuration.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    this.activityIdle(_arg0, _arg1, _arg2);
                    return true;
                }
                case TRANSACTION_activityPaused: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.activityPaused(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_activityStopped: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.os.PersistableBundle _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.PersistableBundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.CharSequence _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    this.activityStopped(_arg0, _arg1, _arg2, _arg3);
                    return true;
                }
                case TRANSACTION_getCallingPackage: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _result = this.getCallingPackage(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_getCallingActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.ComponentName _result = this.getCallingActivity(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getTasks: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.util.List<android.app.ActivityManager.RunningTaskInfo> _result = this.getTasks(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_moveTaskToFront: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.os.Bundle _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    this.moveTaskToFront(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveTaskBackwards: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.moveTaskBackwards(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getTaskForActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    int _result = this.getTaskForActivity(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getContentProvider: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    android.app.ContentProviderHolder _result = this.getContentProvider(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_publishContentProviders: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.util.List<android.app.ContentProviderHolder> _arg1;
                    _arg1 = data.createTypedArrayList(android.app.ContentProviderHolder.CREATOR);
                    this.publishContentProviders(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_refContentProvider: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _result = this.refContentProvider(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_finishSubActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.finishSubActivity(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRunningServiceControlPanel: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.ComponentName _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.app.PendingIntent _result = this.getRunningServiceControlPanel(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_startService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    int _arg5;
                    _arg5 = data.readInt();
                    android.content.ComponentName _result = this.startService(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_stopService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    int _arg3;
                    _arg3 = data.readInt();
                    int _result = this.stopService(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_bindService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.app.IServiceConnection _arg4;
                    _arg4 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
                    int _arg5;
                    _arg5 = data.readInt();
                    java.lang.String _arg6;
                    _arg6 = data.readString();
                    int _arg7;
                    _arg7 = data.readInt();
                    int _result = this.bindService(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_unbindService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IServiceConnection _arg0;
                    _arg0 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
                    boolean _result = this.unbindService(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_publishService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.os.IBinder _arg2;
                    _arg2 = data.readStrongBinder();
                    this.publishService(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_activityResumed: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.activityResumed(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setDebugApp: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    this.setDebugApp(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setAlwaysFinish: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.setAlwaysFinish(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startInstrumentation: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.ComponentName _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.os.Bundle _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    android.app.IInstrumentationWatcher _arg4;
                    _arg4 = android.app.IInstrumentationWatcher.Stub.asInterface(data.readStrongBinder());
                    android.app.IUiAutomationConnection _arg5;
                    _arg5 = android.app.IUiAutomationConnection.Stub.asInterface(data.readStrongBinder());
                    int _arg6;
                    _arg6 = data.readInt();
                    java.lang.String _arg7;
                    _arg7 = data.readString();
                    boolean _result = this.startInstrumentation(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_addInstrumentationResults: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.addInstrumentationResults(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishInstrumentation: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    int _arg1;
                    _arg1 = data.readInt();
                    android.os.Bundle _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    this.finishInstrumentation(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getConfiguration: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.res.Configuration _result = this.getConfiguration();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_updateConfiguration: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.res.Configuration _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.res.Configuration.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _result = this.updateConfiguration(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_stopServiceToken: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.ComponentName _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _result = this.stopServiceToken(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getActivityClassForToken: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.ComponentName _result = this.getActivityClassForToken(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getPackageForToken: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _result = this.getPackageForToken(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_setProcessLimit: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setProcessLimit(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getProcessLimit: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getProcessLimit();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_checkPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _result = this.checkPermission(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_checkUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    android.net.Uri _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    int _arg4;
                    _arg4 = data.readInt();
                    android.os.IBinder _arg5;
                    _arg5 = data.readStrongBinder();
                    int _result = this.checkUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_grantUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.net.Uri _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _arg3;
                    _arg3 = data.readInt();
                    int _arg4;
                    _arg4 = data.readInt();
                    this.grantUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_revokeUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.net.Uri _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _arg3;
                    _arg3 = data.readInt();
                    int _arg4;
                    _arg4 = data.readInt();
                    this.revokeUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setActivityController: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IActivityController _arg0;
                    _arg0 = android.app.IActivityController.Stub.asInterface(data.readStrongBinder());
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setActivityController(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_showWaitingForDebugger: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.showWaitingForDebugger(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_signalPersistentProcesses: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.signalPersistentProcesses(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRecentTasks: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.content.pm.ParceledListSlice _result = this.getRecentTasks(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_serviceDoneExecuting: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    this.serviceDoneExecuting(_arg0, _arg1, _arg2, _arg3);
                    return true;
                }
                case TRANSACTION_activityDestroyed: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.activityDestroyed(_arg0);
                    return true;
                }
                case TRANSACTION_getIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.os.IBinder _arg2;
                    _arg2 = data.readStrongBinder();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    int _arg4;
                    _arg4 = data.readInt();
                    android.content.Intent[] _arg5;
                    _arg5 = data.createTypedArray(android.content.Intent.CREATOR);
                    java.lang.String[] _arg6;
                    _arg6 = data.createStringArray();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.os.Bundle _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    int _arg9;
                    _arg9 = data.readInt();
                    android.content.IIntentSender _result = this.getIntentSender(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
                    reply.writeNoException();
                    reply.writeStrongBinder((((_result != null)) ? (_result.asBinder()) : (null)));
                    return true;
                }
                case TRANSACTION_cancelIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    this.cancelIntentSender(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPackageForIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _result = this.getPackageForIntentSender(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_registerIntentSenderCancelListener: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    com.android.internal.os.IResultReceiver _arg1;
                    _arg1 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
                    this.registerIntentSenderCancelListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterIntentSenderCancelListener: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    com.android.internal.os.IResultReceiver _arg1;
                    _arg1 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
                    this.unregisterIntentSenderCancelListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_enterSafeMode: {
                    data.enforceInterface(DESCRIPTOR);
                    this.enterSafeMode();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startNextMatchingActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.os.Bundle _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    boolean _result = this.startNextMatchingActivity(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_noteWakeupAlarm: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    this.noteWakeupAlarm(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeContentProvider: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.removeContentProvider(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setRequestedOrientation: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setRequestedOrientation(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRequestedOrientation: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _result = this.getRequestedOrientation(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_unbindFinished: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    this.unbindFinished(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setProcessImportant: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    this.setProcessImportant(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setServiceForeground: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.ComponentName _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.app.Notification _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.app.Notification.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    int _arg4;
                    _arg4 = data.readInt();
                    this.setServiceForeground(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveActivityTaskToBack: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    boolean _result = this.moveActivityTaskToBack(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getMemoryInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.ActivityManager.MemoryInfo _arg0;
                    _arg0 = new android.app.ActivityManager.MemoryInfo();
                    this.getMemoryInfo(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getProcessesInErrorState: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> _result = this.getProcessesInErrorState();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_clearApplicationUserData: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.content.pm.IPackageDataObserver _arg1;
                    _arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _result = this.clearApplicationUserData(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_forceStopPackage: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.forceStopPackage(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_killPids: {
                    data.enforceInterface(DESCRIPTOR);
                    int[] _arg0;
                    _arg0 = data.createIntArray();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    boolean _result = this.killPids(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getServices: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.util.List<android.app.ActivityManager.RunningServiceInfo> _result = this.getServices(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_getTaskThumbnail: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.app.ActivityManager.TaskThumbnail _result = this.getTaskThumbnail(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getTaskDescription: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.app.ActivityManager.TaskDescription _result = this.getTaskDescription(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getRunningAppProcesses: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<android.app.ActivityManager.RunningAppProcessInfo> _result = this.getRunningAppProcesses();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_getDeviceConfigurationInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.pm.ConfigurationInfo _result = this.getDeviceConfigurationInfo();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_peekService: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.Intent _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    android.os.IBinder _result = this.peekService(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result);
                    return true;
                }
                case TRANSACTION_profileControl: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    android.app.ProfilerInfo _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    int _arg4;
                    _arg4 = data.readInt();
                    boolean _result = this.profileControl(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_shutdown: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _result = this.shutdown(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_stopAppSwitches: {
                    data.enforceInterface(DESCRIPTOR);
                    this.stopAppSwitches();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_resumeAppSwitches: {
                    data.enforceInterface(DESCRIPTOR);
                    this.resumeAppSwitches();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_bindBackupAgent: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _result = this.bindBackupAgent(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_backupAgentCreated: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    this.backupAgentCreated(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unbindBackupAgent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.pm.ApplicationInfo _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.pm.ApplicationInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.unbindBackupAgent(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getUidForIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    int _result = this.getUidForIntentSender(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_handleIncomingUser: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    boolean _arg4;
                    _arg4 = (0 != data.readInt());
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    java.lang.String _arg6;
                    _arg6 = data.readString();
                    int _result = this.handleIncomingUser(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_addPackageDependency: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.addPackageDependency(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_killApplication: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    this.killApplication(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_closeSystemDialogs: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.closeSystemDialogs(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getProcessMemoryInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    int[] _arg0;
                    _arg0 = data.createIntArray();
                    android.os.Debug.MemoryInfo[] _result = this.getProcessMemoryInfo(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    return true;
                }
                case TRANSACTION_killApplicationProcess: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.killApplicationProcess(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startActivityIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    android.content.IIntentSender _arg1;
                    _arg1 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    android.os.IBinder _arg2;
                    _arg2 = data.readStrongBinder();
                    android.content.Intent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    android.os.IBinder _arg5;
                    _arg5 = data.readStrongBinder();
                    java.lang.String _arg6;
                    _arg6 = data.readString();
                    int _arg7;
                    _arg7 = data.readInt();
                    int _arg8;
                    _arg8 = data.readInt();
                    int _arg9;
                    _arg9 = data.readInt();
                    android.os.Bundle _arg10;
                    if ((0 != data.readInt())) {
                        _arg10 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg10 = null;
                    }
                    int _result = this.startActivityIntentSender(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_overridePendingTransition: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    this.overridePendingTransition(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_handleApplicationWtf: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    android.app.ApplicationErrorReport.ParcelableCrashInfo _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.app.ApplicationErrorReport.ParcelableCrashInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    boolean _result = this.handleApplicationWtf(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_killBackgroundProcesses: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.killBackgroundProcesses(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isUserAMonkey: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.isUserAMonkey();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startActivityAndWait: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    int _arg6;
                    _arg6 = data.readInt();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.app.ProfilerInfo _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    int _arg10;
                    _arg10 = data.readInt();
                    android.app.WaitResult _result = this.startActivityAndWait(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_willActivityBeVisible: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.willActivityBeVisible(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startActivityWithConfig: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    int _arg6;
                    _arg6 = data.readInt();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.content.res.Configuration _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.content.res.Configuration.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    int _arg10;
                    _arg10 = data.readInt();
                    int _result = this.startActivityWithConfig(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getRunningExternalApplications: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<android.content.pm.ApplicationInfo> _result = this.getRunningExternalApplications();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_finishHeavyWeightApp: {
                    data.enforceInterface(DESCRIPTOR);
                    this.finishHeavyWeightApp();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_handleApplicationStrictModeViolation: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.os.StrictMode.ViolationInfo _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.StrictMode.ViolationInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    this.handleApplicationStrictModeViolation(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isImmersive: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.isImmersive(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setImmersive: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setImmersive(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isTopActivityImmersive: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.isTopActivityImmersive();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_crashApplication: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    int _arg3;
                    _arg3 = data.readInt();
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    this.crashApplication(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getProviderMimeType: {
                    data.enforceInterface(DESCRIPTOR);
                    android.net.Uri _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _result = this.getProviderMimeType(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_newUriPermissionOwner: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.IBinder _result = this.newUriPermissionOwner(_arg0);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result);
                    return true;
                }
                case TRANSACTION_grantUriPermissionFromOwner: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    android.net.Uri _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    int _arg4;
                    _arg4 = data.readInt();
                    int _arg5;
                    _arg5 = data.readInt();
                    int _arg6;
                    _arg6 = data.readInt();
                    this.grantUriPermissionFromOwner(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_revokeUriPermissionFromOwner: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.net.Uri _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    int _arg2;
                    _arg2 = data.readInt();
                    int _arg3;
                    _arg3 = data.readInt();
                    this.revokeUriPermissionFromOwner(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_checkGrantUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.net.Uri _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _arg3;
                    _arg3 = data.readInt();
                    int _arg4;
                    _arg4 = data.readInt();
                    int _result = this.checkGrantUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_dumpHeap: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    boolean _arg4;
                    _arg4 = (0 != data.readInt());
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    android.os.ParcelFileDescriptor _arg6;
                    if ((0 != data.readInt())) {
                        _arg6 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg6 = null;
                    }
                    boolean _result = this.dumpHeap(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startActivities: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent[] _arg2;
                    _arg2 = data.createTypedArray(android.content.Intent.CREATOR);
                    java.lang.String[] _arg3;
                    _arg3 = data.createStringArray();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    android.os.Bundle _arg5;
                    if ((0 != data.readInt())) {
                        _arg5 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg5 = null;
                    }
                    int _arg6;
                    _arg6 = data.readInt();
                    int _result = this.startActivities(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_isUserRunning: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.isUserRunning(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_activitySlept: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.activitySlept(_arg0);
                    return true;
                }
                case TRANSACTION_getFrontActivityScreenCompatMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getFrontActivityScreenCompatMode();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setFrontActivityScreenCompatMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setFrontActivityScreenCompatMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPackageScreenCompatMode: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _result = this.getPackageScreenCompatMode(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setPackageScreenCompatMode: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setPackageScreenCompatMode(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPackageAskScreenCompat: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    boolean _result = this.getPackageAskScreenCompat(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setPackageAskScreenCompat: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setPackageAskScreenCompat(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_switchUser: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _result = this.switchUser(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setFocusedTask: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setFocusedTask(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeTask: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _result = this.removeTask(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_registerProcessObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IProcessObserver _arg0;
                    _arg0 = android.app.IProcessObserver.Stub.asInterface(data.readStrongBinder());
                    this.registerProcessObserver(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterProcessObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IProcessObserver _arg0;
                    _arg0 = android.app.IProcessObserver.Stub.asInterface(data.readStrongBinder());
                    this.unregisterProcessObserver(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isIntentSenderTargetedToPackage: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    boolean _result = this.isIntentSenderTargetedToPackage(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_updatePersistentConfiguration: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.res.Configuration _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.res.Configuration.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.updatePersistentConfiguration(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getProcessPss: {
                    data.enforceInterface(DESCRIPTOR);
                    int[] _arg0;
                    _arg0 = data.createIntArray();
                    long[] _result = this.getProcessPss(_arg0);
                    reply.writeNoException();
                    reply.writeLongArray(_result);
                    return true;
                }
                case TRANSACTION_showBootMessage: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.CharSequence _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.showBootMessage(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_killAllBackgroundProcesses: {
                    data.enforceInterface(DESCRIPTOR);
                    this.killAllBackgroundProcesses();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getContentProviderExternal: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.os.IBinder _arg2;
                    _arg2 = data.readStrongBinder();
                    android.app.ContentProviderHolder _result = this.getContentProviderExternal(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_removeContentProviderExternal: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    this.removeContentProviderExternal(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getMyMemoryState: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.ActivityManager.RunningAppProcessInfo _arg0;
                    _arg0 = new android.app.ActivityManager.RunningAppProcessInfo();
                    this.getMyMemoryState(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_killProcessesBelowForeground: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    boolean _result = this.killProcessesBelowForeground(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getCurrentUser: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.pm.UserInfo _result = this.getCurrentUser();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_shouldUpRecreateTask: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _result = this.shouldUpRecreateTask(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_navigateUpTo: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    int _arg2;
                    _arg2 = data.readInt();
                    android.content.Intent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    boolean _result = this.navigateUpTo(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setLockScreenShown: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setLockScreenShown(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishActivityAffinity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.finishActivityAffinity(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getLaunchedFromUid: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _result = this.getLaunchedFromUid(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_unstableProviderDied: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.unstableProviderDied(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isIntentSenderAnActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    boolean _result = this.isIntentSenderAnActivity(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startActivityAsUser: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    int _arg6;
                    _arg6 = data.readInt();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.app.ProfilerInfo _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    int _arg10;
                    _arg10 = data.readInt();
                    int _result = this.startActivityAsUser(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_stopUser: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    android.app.IStopUserCallback _arg2;
                    _arg2 = android.app.IStopUserCallback.Stub.asInterface(data.readStrongBinder());
                    int _result = this.stopUser(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_registerUserSwitchObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IUserSwitchObserver _arg0;
                    _arg0 = android.app.IUserSwitchObserver.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    this.registerUserSwitchObserver(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterUserSwitchObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IUserSwitchObserver _arg0;
                    _arg0 = android.app.IUserSwitchObserver.Stub.asInterface(data.readStrongBinder());
                    this.unregisterUserSwitchObserver(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRunningUserIds: {
                    data.enforceInterface(DESCRIPTOR);
                    int[] _result = this.getRunningUserIds();
                    reply.writeNoException();
                    reply.writeIntArray(_result);
                    return true;
                }
                case TRANSACTION_requestBugReport: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.requestBugReport(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_requestTelephonyBugReport: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    this.requestTelephonyBugReport(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_inputDispatchingTimedOut: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    long _result = this.inputDispatchingTimedOut(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeLong(_result);
                    return true;
                }
                case TRANSACTION_clearPendingBackup: {
                    data.enforceInterface(DESCRIPTOR);
                    this.clearPendingBackup();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getIntentForIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    android.content.Intent _result = this.getIntentForIntentSender(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getAssistContextExtras: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.os.Bundle _result = this.getAssistContextExtras(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_reportAssistContextExtras: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.app.assist.AssistStructure _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.app.assist.AssistStructure.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    android.app.assist.AssistContent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.app.assist.AssistContent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    android.net.Uri _arg4;
                    if ((0 != data.readInt())) {
                        _arg4 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg4 = null;
                    }
                    this.reportAssistContextExtras(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getLaunchedFromPackage: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    java.lang.String _result = this.getLaunchedFromPackage(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_killUid: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    this.killUid(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setUserIsMonkey: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.setUserIsMonkey(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_hang: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.hang(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveTaskToStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    this.moveTaskToStack(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_resizeStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.Rect _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    boolean _arg4;
                    _arg4 = (0 != data.readInt());
                    int _arg5;
                    _arg5 = data.readInt();
                    this.resizeStack(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getAllStackInfos: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<android.app.ActivityManager.StackInfo> _result = this.getAllStackInfos();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_setFocusedStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setFocusedStack(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getStackInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.app.ActivityManager.StackInfo _result = this.getStackInfo(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_convertFromTranslucent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.convertFromTranslucent(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_convertToTranslucent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _result = this.convertToTranslucent(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_notifyActivityDrawn: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.notifyActivityDrawn(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_reportActivityFullyDrawn: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.reportActivityFullyDrawn(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_restart: {
                    data.enforceInterface(DESCRIPTOR);
                    this.restart();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_performIdleMaintenance: {
                    data.enforceInterface(DESCRIPTOR);
                    this.performIdleMaintenance();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_takePersistableUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    android.net.Uri _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.takePersistableUriPermission(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_releasePersistableUriPermission: {
                    data.enforceInterface(DESCRIPTOR);
                    android.net.Uri _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.net.Uri.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.releasePersistableUriPermission(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPersistedUriPermissions: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    android.content.pm.ParceledListSlice _result = this.getPersistedUriPermissions(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_appNotRespondingViaProvider: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.appNotRespondingViaProvider(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getTaskBounds: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.Rect _result = this.getTaskBounds(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getActivityDisplayId: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _result = this.getActivityDisplayId(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setProcessMemoryTrimLevel: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    boolean _result = this.setProcessMemoryTrimLevel(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_getTagForIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    java.lang.String _result = this.getTagForIntentSender(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_startUserInBackground: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _result = this.startUserInBackground(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startLockTaskModeById: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.startLockTaskModeById(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startLockTaskModeByToken: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.startLockTaskModeByToken(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopLockTaskMode: {
                    data.enforceInterface(DESCRIPTOR);
                    this.stopLockTaskMode();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isInLockTaskMode: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.isInLockTaskMode();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setTaskDescription: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.app.ActivityManager.TaskDescription _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.app.ActivityManager.TaskDescription.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.setTaskDescription(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startVoiceActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.content.Intent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    android.service.voice.IVoiceInteractionSession _arg5;
                    _arg5 = android.service.voice.IVoiceInteractionSession.Stub.asInterface(data.readStrongBinder());
                    com.android.internal.app.IVoiceInteractor _arg6;
                    _arg6 = com.android.internal.app.IVoiceInteractor.Stub.asInterface(data.readStrongBinder());
                    int _arg7;
                    _arg7 = data.readInt();
                    android.app.ProfilerInfo _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    int _arg10;
                    _arg10 = data.readInt();
                    int _result = this.startVoiceActivity(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_startAssistantActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.content.Intent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    android.os.Bundle _arg5;
                    if ((0 != data.readInt())) {
                        _arg5 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg5 = null;
                    }
                    int _arg6;
                    _arg6 = data.readInt();
                    int _result = this.startAssistantActivity(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getActivityOptions: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _result = this.getActivityOptions(_arg0);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getAppTasks: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.util.List<android.os.IBinder> _result = this.getAppTasks(_arg0);
                    reply.writeNoException();
                    reply.writeBinderList(_result);
                    return true;
                }
                case TRANSACTION_startSystemLockTaskMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.startSystemLockTaskMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopSystemLockTaskMode: {
                    data.enforceInterface(DESCRIPTOR);
                    this.stopSystemLockTaskMode();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_finishVoiceTask: {
                    data.enforceInterface(DESCRIPTOR);
                    android.service.voice.IVoiceInteractionSession _arg0;
                    _arg0 = android.service.voice.IVoiceInteractionSession.Stub.asInterface(data.readStrongBinder());
                    this.finishVoiceTask(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isTopOfTask: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.isTopOfTask(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_notifyLaunchTaskBehindComplete: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.notifyLaunchTaskBehindComplete(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startActivityFromRecents: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    int _result = this.startActivityFromRecents(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_notifyEnterAnimationComplete: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.notifyEnterAnimationComplete(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startActivityAsCaller: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    android.content.Intent _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    android.os.IBinder _arg4;
                    _arg4 = data.readStrongBinder();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    int _arg6;
                    _arg6 = data.readInt();
                    int _arg7;
                    _arg7 = data.readInt();
                    android.app.ProfilerInfo _arg8;
                    if ((0 != data.readInt())) {
                        _arg8 = android.app.ProfilerInfo.CREATOR.createFromParcel(data);
                    } else {
                        _arg8 = null;
                    }
                    android.os.Bundle _arg9;
                    if ((0 != data.readInt())) {
                        _arg9 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg9 = null;
                    }
                    boolean _arg10;
                    _arg10 = (0 != data.readInt());
                    int _arg11;
                    _arg11 = data.readInt();
                    int _result = this.startActivityAsCaller(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_addAppTask: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.content.Intent _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.app.ActivityManager.TaskDescription _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.app.ActivityManager.TaskDescription.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    android.graphics.Bitmap _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    int _result = this.addAppTask(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getAppTaskThumbnailSize: {
                    data.enforceInterface(DESCRIPTOR);
                    android.graphics.Point _result = this.getAppTaskThumbnailSize();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_releaseActivityInstance: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.releaseActivityInstance(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_releaseSomeActivities: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IApplicationThread _arg0;
                    _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                    this.releaseSomeActivities(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_bootAnimationComplete: {
                    data.enforceInterface(DESCRIPTOR);
                    this.bootAnimationComplete();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getTaskDescriptionIcon: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.graphics.Bitmap _result = this.getTaskDescriptionIcon(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_launchAssistIntent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.Intent _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    int _arg3;
                    _arg3 = data.readInt();
                    android.os.Bundle _arg4;
                    if ((0 != data.readInt())) {
                        _arg4 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg4 = null;
                    }
                    boolean _result = this.launchAssistIntent(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startInPlaceAnimationOnFrontMostApplication: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.Bundle _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.startInPlaceAnimationOnFrontMostApplication(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_checkPermissionWithToken: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.os.IBinder _arg3;
                    _arg3 = data.readStrongBinder();
                    int _result = this.checkPermissionWithToken(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_registerTaskStackListener: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.ITaskStackListener _arg0;
                    _arg0 = android.app.ITaskStackListener.Stub.asInterface(data.readStrongBinder());
                    this.registerTaskStackListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_notifyCleartextNetwork: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    byte[] _arg1;
                    _arg1 = data.createByteArray();
                    this.notifyCleartextNetwork(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_createStackOnDisplay: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.createStackOnDisplay(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getFocusedStackId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getFocusedStackId();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setTaskResizeable: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.setTaskResizeable(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_requestAssistContextExtras: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    com.android.internal.os.IResultReceiver _arg1;
                    _arg1 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
                    android.os.Bundle _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    android.os.IBinder _arg3;
                    _arg3 = data.readStrongBinder();
                    boolean _arg4;
                    _arg4 = (0 != data.readInt());
                    boolean _arg5;
                    _arg5 = (0 != data.readInt());
                    boolean _result = this.requestAssistContextExtras(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_resizeTask: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.Rect _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    int _arg2;
                    _arg2 = data.readInt();
                    this.resizeTask(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getLockTaskModeState: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getLockTaskModeState();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setDumpHeapDebugLimit: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    long _arg2;
                    _arg2 = data.readLong();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    this.setDumpHeapDebugLimit(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_dumpHeapFinished: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.dumpHeapFinished(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setVoiceKeepAwake: {
                    data.enforceInterface(DESCRIPTOR);
                    android.service.voice.IVoiceInteractionSession _arg0;
                    _arg0 = android.service.voice.IVoiceInteractionSession.Stub.asInterface(data.readStrongBinder());
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setVoiceKeepAwake(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateLockTaskPackages: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    java.lang.String[] _arg1;
                    _arg1 = data.createStringArray();
                    this.updateLockTaskPackages(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_noteAlarmStart: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    this.noteAlarmStart(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_noteAlarmFinish: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    int _arg1;
                    _arg1 = data.readInt();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    this.noteAlarmFinish(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPackageProcessState: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _result = this.getPackageProcessState(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_showLockTaskEscapeMessage: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.showLockTaskEscapeMessage(_arg0);
                    return true;
                }
                case TRANSACTION_updateDeviceOwner: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.updateDeviceOwner(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_keyguardGoingAway: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.keyguardGoingAway(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getUidProcessState: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _result = this.getUidProcessState(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_registerUidObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IUidObserver _arg0;
                    _arg0 = android.app.IUidObserver.Stub.asInterface(data.readStrongBinder());
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    this.registerUidObserver(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterUidObserver: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.IUidObserver _arg0;
                    _arg0 = android.app.IUidObserver.Stub.asInterface(data.readStrongBinder());
                    this.unregisterUidObserver(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isAssistDataAllowedOnCurrentActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.isAssistDataAllowedOnCurrentActivity();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_showAssistFromActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _result = this.showAssistFromActivity(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_isRootVoiceInteraction: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.isRootVoiceInteraction(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startBinderTracking: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.startBinderTracking();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_stopBinderTrackingAndDump: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.ParcelFileDescriptor _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _result = this.stopBinderTrackingAndDump(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_positionTaskInStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.positionTaskInStack(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getActivityStackId: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _result = this.getActivityStackId(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_exitFreeformMode: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.exitFreeformMode(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_reportSizeConfigurations: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int[] _arg1;
                    _arg1 = data.createIntArray();
                    int[] _arg2;
                    _arg2 = data.createIntArray();
                    int[] _arg3;
                    _arg3 = data.createIntArray();
                    this.reportSizeConfigurations(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveTaskToDockedStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    boolean _arg3;
                    _arg3 = (0 != data.readInt());
                    android.graphics.Rect _arg4;
                    if ((0 != data.readInt())) {
                        _arg4 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg4 = null;
                    }
                    boolean _result = this.moveTaskToDockedStack(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_suppressResizeConfigChanges: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.suppressResizeConfigChanges(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveTasksToFullscreenStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.moveTasksToFullscreenStack(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveTopActivityToPinnedStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    android.graphics.Rect _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _result = this.moveTopActivityToPinnedStack(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_isAppStartModeDisabled: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    boolean _result = this.isAppStartModeDisabled(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_unlockUser: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    byte[] _arg1;
                    _arg1 = data.createByteArray();
                    byte[] _arg2;
                    _arg2 = data.createByteArray();
                    android.os.IProgressListener _arg3;
                    _arg3 = android.os.IProgressListener.Stub.asInterface(data.readStrongBinder());
                    boolean _result = this.unlockUser(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_isInMultiWindowMode: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.isInMultiWindowMode(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_isInPictureInPictureMode: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _result = this.isInPictureInPictureMode(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_killPackageDependents: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.killPackageDependents(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_enterPictureInPictureMode: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.app.PictureInPictureParams _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.app.PictureInPictureParams.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    boolean _result = this.enterPictureInPictureMode(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_setPictureInPictureParams: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.app.PictureInPictureParams _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.app.PictureInPictureParams.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.setPictureInPictureParams(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getMaxNumPictureInPictureActions: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    int _result = this.getMaxNumPictureInPictureActions(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_activityRelaunched: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.activityRelaunched(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getUriPermissionOwnerForActivity: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.IBinder _result = this.getUriPermissionOwnerForActivity(_arg0);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result);
                    return true;
                }
                case TRANSACTION_resizeDockedStack: {
                    data.enforceInterface(DESCRIPTOR);
                    android.graphics.Rect _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.graphics.Rect _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.graphics.Rect _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    android.graphics.Rect _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    android.graphics.Rect _arg4;
                    if ((0 != data.readInt())) {
                        _arg4 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg4 = null;
                    }
                    this.resizeDockedStack(_arg0, _arg1, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setVrMode: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    android.content.ComponentName _arg2;
                    if ((0 != data.readInt())) {
                        _arg2 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    int _result = this.setVrMode(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getGrantedUriPermissions: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    android.content.pm.ParceledListSlice _result = this.getGrantedUriPermissions(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_clearGrantedUriPermissions: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.clearGrantedUriPermissions(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isAppForeground: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _result = this.isAppForeground(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_startLocalVoiceInteraction: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.startLocalVoiceInteraction(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopLocalVoiceInteraction: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.stopLocalVoiceInteraction(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_supportsLocalVoiceInteraction: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = this.supportsLocalVoiceInteraction();
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_notifyPinnedStackAnimationStarted: {
                    data.enforceInterface(DESCRIPTOR);
                    this.notifyPinnedStackAnimationStarted();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_notifyPinnedStackAnimationEnded: {
                    data.enforceInterface(DESCRIPTOR);
                    this.notifyPinnedStackAnimationEnded();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeStack: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.removeStack(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_makePackageIdle: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.makePackageIdle(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getMemoryTrimLevel: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getMemoryTrimLevel();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_resizePinnedStack: {
                    data.enforceInterface(DESCRIPTOR);
                    android.graphics.Rect _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.graphics.Rect _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.resizePinnedStack(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isVrModePackageEnabled: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.ComponentName _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _result = this.isVrModePackageEnabled(_arg0);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_swapDockedAndFullscreenStack: {
                    data.enforceInterface(DESCRIPTOR);
                    this.swapDockedAndFullscreenStack();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_notifyLockedProfile: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.notifyLockedProfile(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startConfirmDeviceCredentialIntent: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.Intent _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    this.startConfirmDeviceCredentialIntent(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_sendIdleJobTrigger: {
                    data.enforceInterface(DESCRIPTOR);
                    this.sendIdleJobTrigger();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_sendIntentSender: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.IIntentSender _arg0;
                    _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
                    android.os.IBinder _arg1;
                    _arg1 = data.readStrongBinder();
                    int _arg2;
                    _arg2 = data.readInt();
                    android.content.Intent _arg3;
                    if ((0 != data.readInt())) {
                        _arg3 = android.content.Intent.CREATOR.createFromParcel(data);
                    } else {
                        _arg3 = null;
                    }
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    android.content.IIntentReceiver _arg5;
                    _arg5 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
                    java.lang.String _arg6;
                    _arg6 = data.readString();
                    android.os.Bundle _arg7;
                    if ((0 != data.readInt())) {
                        _arg7 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg7 = null;
                    }
                    int _result = this.sendIntentSender(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setVrThread: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setVrThread(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setRenderThread: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setRenderThread(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setHasTopUi: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0;
                    _arg0 = (0 != data.readInt());
                    this.setHasTopUi(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_requestActivityRelaunch: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    this.requestActivityRelaunch(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_updateDisplayOverrideConfiguration: {
                    data.enforceInterface(DESCRIPTOR);
                    android.content.res.Configuration _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.content.res.Configuration.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.updateDisplayOverrideConfiguration(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_unregisterTaskStackListener: {
                    data.enforceInterface(DESCRIPTOR);
                    android.app.ITaskStackListener _arg0;
                    _arg0 = android.app.ITaskStackListener.Stub.asInterface(data.readStrongBinder());
                    this.unregisterTaskStackListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_moveStackToDisplay: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.moveStackToDisplay(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_requestAutofillData: {
                    data.enforceInterface(DESCRIPTOR);
                    com.android.internal.os.IResultReceiver _arg0;
                    _arg0 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
                    android.os.Bundle _arg1;
                    if ((0 != data.readInt())) {
                        _arg1 = android.os.Bundle.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    android.os.IBinder _arg2;
                    _arg2 = data.readStrongBinder();
                    int _arg3;
                    _arg3 = data.readInt();
                    boolean _result = this.requestAutofillData(_arg0, _arg1, _arg2, _arg3);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_dismissKeyguard: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    com.android.internal.policy.IKeyguardDismissCallback _arg1;
                    _arg1 = com.android.internal.policy.IKeyguardDismissCallback.Stub.asInterface(data.readStrongBinder());
                    this.dismissKeyguard(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_restartUserInBackground: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.restartUserInBackground(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_cancelTaskWindowTransition: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.cancelTaskWindowTransition(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_cancelTaskThumbnailTransition: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.cancelTaskThumbnailTransition(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getTaskSnapshot: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    android.app.ActivityManager.TaskSnapshot _result = this.getTaskSnapshot(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_scheduleApplicationInfoChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<java.lang.String> _arg0;
                    _arg0 = data.createStringArrayList();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.scheduleApplicationInfoChanged(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setPersistentVrThread: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.setPersistentVrThread(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_waitForNetworkStateUpdate: {
                    data.enforceInterface(DESCRIPTOR);
                    long _arg0;
                    _arg0 = data.readLong();
                    this.waitForNetworkStateUpdate(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setDisablePreviewScreenshots: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setDisablePreviewScreenshots(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getLastResumedActivityUserId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getLastResumedActivityUserId();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_backgroundWhitelistUid: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    this.backgroundWhitelistUid(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setShowWhenLocked: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setShowWhenLocked(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_setTurnScreenOn: {
                    data.enforceInterface(DESCRIPTOR);
                    android.os.IBinder _arg0;
                    _arg0 = data.readStrongBinder();
                    boolean _arg1;
                    _arg1 = (0 != data.readInt());
                    this.setTurnScreenOn(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements android.app.IActivityManager {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }
// WARNING: when these transactions are updated, check if they are any callers on the native
// side. If so, make sure they are using the correct transaction ids and arguments.
// If a transaction which will also be used on the native side is being inserted, add it to
// below block of transactions.
// Since these transactions are also called from native code, these must be kept in sync with
// the ones in frameworks/native/include/binder/IActivityManager.h
// =============== Beginning of transactions used on native side as well ======================

            @Override
            public android.os.ParcelFileDescriptor openContentUri(java.lang.String uriString) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.ParcelFileDescriptor _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(uriString);
                    mRemote.transact(Stub.TRANSACTION_openContentUri, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// =============== End of transactions used on native side as well ============================
// Special low-level communication with activity manager.

            @Override
            public void handleApplicationCrash(android.os.IBinder app, android.app.ApplicationErrorReport.ParcelableCrashInfo crashInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(app);
                    if ((crashInfo != null)) {
                        _data.writeInt(1);
                        crashInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_handleApplicationCrash, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int startActivity(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(flags);
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unhandledBack() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_unhandledBack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean finishActivity(android.os.IBinder token, int code, android.content.Intent data, int finishTask) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(code);
                    if ((data != null)) {
                        _data.writeInt(1);
                        data.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(finishTask);
                    mRemote.transact(Stub.TRANSACTION_finishActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.content.Intent registerReceiver(android.app.IApplicationThread caller, java.lang.String callerPackage, android.content.IIntentReceiver receiver, android.content.IntentFilter filter, java.lang.String requiredPermission, int userId, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.Intent _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callerPackage);
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    if ((filter != null)) {
                        _data.writeInt(1);
                        filter.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(requiredPermission);
                    _data.writeInt(userId);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_registerReceiver, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.Intent.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unregisterReceiver(android.content.IIntentReceiver receiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterReceiver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int broadcastIntent(android.app.IApplicationThread caller, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver resultTo, int resultCode, java.lang.String resultData, android.os.Bundle map, java.lang.String[] requiredPermissions, int appOp, android.os.Bundle options, boolean serialized, boolean sticky, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder((((resultTo != null)) ? (resultTo.asBinder()) : (null)));
                    _data.writeInt(resultCode);
                    _data.writeString(resultData);
                    if ((map != null)) {
                        _data.writeInt(1);
                        map.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStringArray(requiredPermissions);
                    _data.writeInt(appOp);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((serialized) ? (1) : (0)));
                    _data.writeInt(((sticky) ? (1) : (0)));
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_broadcastIntent, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unbroadcastIntent(android.app.IApplicationThread caller, android.content.Intent intent, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_unbroadcastIntent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void finishReceiver(android.os.IBinder who, int resultCode, java.lang.String resultData, android.os.Bundle map, boolean abortBroadcast, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(who);
                    _data.writeInt(resultCode);
                    _data.writeString(resultData);
                    if ((map != null)) {
                        _data.writeInt(1);
                        map.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((abortBroadcast) ? (1) : (0)));
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_finishReceiver, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void attachApplication(android.app.IApplicationThread app) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((app != null)) ? (app.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_attachApplication, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void activityIdle(android.os.IBinder token, android.content.res.Configuration config, boolean stopProfiling) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((config != null)) {
                        _data.writeInt(1);
                        config.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((stopProfiling) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_activityIdle, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void activityPaused(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_activityPaused, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void activityStopped(android.os.IBinder token, android.os.Bundle state, android.os.PersistableBundle persistentState, java.lang.CharSequence description) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((state != null)) {
                        _data.writeInt(1);
                        state.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((persistentState != null)) {
                        _data.writeInt(1);
                        persistentState.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((description != null)) {
                        _data.writeInt(1);
                        android.text.TextUtils.writeToParcel(description, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_activityStopped, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public java.lang.String getCallingPackage(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getCallingPackage, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.content.ComponentName getCallingActivity(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.ComponentName _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getCallingActivity, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public java.util.List<android.app.ActivityManager.RunningTaskInfo> getTasks(int maxNum, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.app.ActivityManager.RunningTaskInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(maxNum);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_getTasks, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.app.ActivityManager.RunningTaskInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void moveTaskToFront(int task, int flags, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(task);
                    _data.writeInt(flags);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_moveTaskToFront, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void moveTaskBackwards(int task) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(task);
                    mRemote.transact(Stub.TRANSACTION_moveTaskBackwards, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getTaskForActivity(android.os.IBinder token, boolean onlyRoot) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((onlyRoot) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_getTaskForActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.app.ContentProviderHolder getContentProvider(android.app.IApplicationThread caller, java.lang.String name, int userId, boolean stable) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ContentProviderHolder _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(name);
                    _data.writeInt(userId);
                    _data.writeInt(((stable) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_getContentProvider, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ContentProviderHolder.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void publishContentProviders(android.app.IApplicationThread caller, java.util.List<android.app.ContentProviderHolder> providers) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeTypedList(providers);
                    mRemote.transact(Stub.TRANSACTION_publishContentProviders, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean refContentProvider(android.os.IBinder connection, int stableDelta, int unstableDelta) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(connection);
                    _data.writeInt(stableDelta);
                    _data.writeInt(unstableDelta);
                    mRemote.transact(Stub.TRANSACTION_refContentProvider, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void finishSubActivity(android.os.IBinder token, java.lang.String resultWho, int requestCode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    mRemote.transact(Stub.TRANSACTION_finishSubActivity, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.app.PendingIntent getRunningServiceControlPanel(android.content.ComponentName service) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.PendingIntent _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_getRunningServiceControlPanel, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.PendingIntent.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.content.ComponentName startService(android.app.IApplicationThread caller, android.content.Intent service, java.lang.String resolvedType, boolean requireForeground, java.lang.String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.ComponentName _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeInt(((requireForeground) ? (1) : (0)));
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startService, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int stopService(android.app.IApplicationThread caller, android.content.Intent service, java.lang.String resolvedType, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_stopService, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int bindService(android.app.IApplicationThread caller, android.os.IBinder token, android.content.Intent service, java.lang.String resolvedType, android.app.IServiceConnection connection, int flags, java.lang.String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeStrongBinder(token);
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder((((connection != null)) ? (connection.asBinder()) : (null)));
                    _data.writeInt(flags);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_bindService, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean unbindService(android.app.IServiceConnection connection) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((connection != null)) ? (connection.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unbindService, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void publishService(android.os.IBinder token, android.content.Intent intent, android.os.IBinder service) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(service);
                    mRemote.transact(Stub.TRANSACTION_publishService, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void activityResumed(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_activityResumed, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setDebugApp(java.lang.String packageName, boolean waitForDebugger, boolean persistent) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(((waitForDebugger) ? (1) : (0)));
                    _data.writeInt(((persistent) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setDebugApp, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setAlwaysFinish(boolean enabled) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((enabled) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setAlwaysFinish, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean startInstrumentation(android.content.ComponentName className, java.lang.String profileFile, int flags, android.os.Bundle arguments, android.app.IInstrumentationWatcher watcher, android.app.IUiAutomationConnection connection, int userId, java.lang.String abiOverride) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((className != null)) {
                        _data.writeInt(1);
                        className.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(profileFile);
                    _data.writeInt(flags);
                    if ((arguments != null)) {
                        _data.writeInt(1);
                        arguments.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder((((watcher != null)) ? (watcher.asBinder()) : (null)));
                    _data.writeStrongBinder((((connection != null)) ? (connection.asBinder()) : (null)));
                    _data.writeInt(userId);
                    _data.writeString(abiOverride);
                    mRemote.transact(Stub.TRANSACTION_startInstrumentation, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addInstrumentationResults(android.app.IApplicationThread target, android.os.Bundle results) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((target != null)) ? (target.asBinder()) : (null)));
                    if ((results != null)) {
                        _data.writeInt(1);
                        results.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_addInstrumentationResults, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void finishInstrumentation(android.app.IApplicationThread target, int resultCode, android.os.Bundle results) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((target != null)) ? (target.asBinder()) : (null)));
                    _data.writeInt(resultCode);
                    if ((results != null)) {
                        _data.writeInt(1);
                        results.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_finishInstrumentation, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * @return A copy of global {@link Configuration}, contains general settings for the entire
             * system. Corresponds to the configuration of the default display.
             * @throws RemoteException
             */
            @Override
            public android.content.res.Configuration getConfiguration() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.res.Configuration _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getConfiguration, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.res.Configuration.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Updates global configuration and applies changes to the entire system.
             *
             * @param values Update values for global configuration. If null is passed it will request the
             *               Window Manager to compute new config for the default display.
             * @return Returns true if the configuration was updated.
             * @throws RemoteException
             */
            @Override
            public boolean updateConfiguration(android.content.res.Configuration values) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((values != null)) {
                        _data.writeInt(1);
                        values.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_updateConfiguration, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean stopServiceToken(android.content.ComponentName className, android.os.IBinder token, int startId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((className != null)) {
                        _data.writeInt(1);
                        className.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(token);
                    _data.writeInt(startId);
                    mRemote.transact(Stub.TRANSACTION_stopServiceToken, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.content.ComponentName getActivityClassForToken(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.ComponentName _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getActivityClassForToken, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public java.lang.String getPackageForToken(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getPackageForToken, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setProcessLimit(int max) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(max);
                    mRemote.transact(Stub.TRANSACTION_setProcessLimit, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getProcessLimit() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getProcessLimit, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int checkPermission(java.lang.String permission, int pid, int uid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(permission);
                    _data.writeInt(pid);
                    _data.writeInt(uid);
                    mRemote.transact(Stub.TRANSACTION_checkPermission, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int checkUriPermission(android.net.Uri uri, int pid, int uid, int mode, int userId, android.os.IBinder callerToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(pid);
                    _data.writeInt(uid);
                    _data.writeInt(mode);
                    _data.writeInt(userId);
                    _data.writeStrongBinder(callerToken);
                    mRemote.transact(Stub.TRANSACTION_checkUriPermission, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void grantUriPermission(android.app.IApplicationThread caller, java.lang.String targetPkg, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(targetPkg);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(mode);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_grantUriPermission, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void revokeUriPermission(android.app.IApplicationThread caller, java.lang.String targetPkg, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(targetPkg);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(mode);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_revokeUriPermission, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setActivityController(android.app.IActivityController watcher, boolean imAMonkey) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((watcher != null)) ? (watcher.asBinder()) : (null)));
                    _data.writeInt(((imAMonkey) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setActivityController, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void showWaitingForDebugger(android.app.IApplicationThread who, boolean waiting) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((who != null)) ? (who.asBinder()) : (null)));
                    _data.writeInt(((waiting) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_showWaitingForDebugger, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /*
             * This will deliver the specified signal to all the persistent processes. Currently only
             * SIGUSR1 is delivered. All others are ignored.
             */
            @Override
            public void signalPersistentProcesses(int signal) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(signal);
                    mRemote.transact(Stub.TRANSACTION_signalPersistentProcesses, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.content.pm.ParceledListSlice getRecentTasks(int maxNum, int flags, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.pm.ParceledListSlice _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(maxNum);
                    _data.writeInt(flags);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_getRecentTasks, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void serviceDoneExecuting(android.os.IBinder token, int type, int startId, int res) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(type);
                    _data.writeInt(startId);
                    _data.writeInt(res);
                    mRemote.transact(Stub.TRANSACTION_serviceDoneExecuting, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void activityDestroyed(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_activityDestroyed, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public android.content.IIntentSender getIntentSender(int type, java.lang.String packageName, android.os.IBinder token, java.lang.String resultWho, int requestCode, android.content.Intent[] intents, java.lang.String[] resolvedTypes, int flags, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.IIntentSender _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(packageName);
                    _data.writeStrongBinder(token);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeTypedArray(intents, 0);
                    _data.writeStringArray(resolvedTypes);
                    _data.writeInt(flags);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_getIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = android.content.IIntentSender.Stub.asInterface(_reply.readStrongBinder());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void cancelIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_cancelIntentSender, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.lang.String getPackageForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_getPackageForIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void registerIntentSenderCancelListener(android.content.IIntentSender sender, com.android.internal.os.IResultReceiver receiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerIntentSenderCancelListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterIntentSenderCancelListener(android.content.IIntentSender sender, com.android.internal.os.IResultReceiver receiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterIntentSenderCancelListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void enterSafeMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_enterSafeMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean startNextMatchingActivity(android.os.IBinder callingActivity, android.content.Intent intent, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(callingActivity);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startNextMatchingActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void noteWakeupAlarm(android.content.IIntentSender sender, int sourceUid, java.lang.String sourcePkg, java.lang.String tag) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeInt(sourceUid);
                    _data.writeString(sourcePkg);
                    _data.writeString(tag);
                    mRemote.transact(Stub.TRANSACTION_noteWakeupAlarm, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removeContentProvider(android.os.IBinder connection, boolean stable) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(connection);
                    _data.writeInt(((stable) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_removeContentProvider, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setRequestedOrientation(android.os.IBinder token, int requestedOrientation) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(requestedOrientation);
                    mRemote.transact(Stub.TRANSACTION_setRequestedOrientation, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getRequestedOrientation(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getRequestedOrientation, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unbindFinished(android.os.IBinder token, android.content.Intent service, boolean doRebind) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((doRebind) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_unbindFinished, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setProcessImportant(android.os.IBinder token, int pid, boolean isForeground, java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(pid);
                    _data.writeInt(((isForeground) ? (1) : (0)));
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_setProcessImportant, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setServiceForeground(android.content.ComponentName className, android.os.IBinder token, int id, android.app.Notification notification, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((className != null)) {
                        _data.writeInt(1);
                        className.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(token);
                    _data.writeInt(id);
                    if ((notification != null)) {
                        _data.writeInt(1);
                        notification.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_setServiceForeground, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean moveActivityTaskToBack(android.os.IBinder token, boolean nonRoot) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((nonRoot) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_moveActivityTaskToBack, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void getMemoryInfo(android.app.ActivityManager.MemoryInfo outInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getMemoryInfo, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        outInfo.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getProcessesInErrorState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.app.ActivityManager.ProcessErrorStateInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_clearApplicationUserData, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void forceStopPackage(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_forceStopPackage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean killPids(int[] pids, java.lang.String reason, boolean secure) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeIntArray(pids);
                    _data.writeString(reason);
                    _data.writeInt(((secure) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_killPids, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public java.util.List<android.app.ActivityManager.RunningServiceInfo> getServices(int maxNum, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.app.ActivityManager.RunningServiceInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(maxNum);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_getServices, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.app.ActivityManager.RunningServiceInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.app.ActivityManager.TaskThumbnail getTaskThumbnail(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ActivityManager.TaskThumbnail _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_getTaskThumbnail, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ActivityManager.TaskThumbnail.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.app.ActivityManager.TaskDescription getTaskDescription(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ActivityManager.TaskDescription _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_getTaskDescription, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ActivityManager.TaskDescription.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Retrieve running application processes in the system

            @Override
            public java.util.List<android.app.ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.app.ActivityManager.RunningAppProcessInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getRunningAppProcesses, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.app.ActivityManager.RunningAppProcessInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Get device configuration

            @Override
            public android.content.pm.ConfigurationInfo getDeviceConfigurationInfo() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.pm.ConfigurationInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getDeviceConfigurationInfo, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.pm.ConfigurationInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.os.IBinder peekService(android.content.Intent service, java.lang.String resolvedType, java.lang.String callingPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.IBinder _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((service != null)) {
                        _data.writeInt(1);
                        service.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeString(callingPackage);
                    mRemote.transact(Stub.TRANSACTION_peekService, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readStrongBinder();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Turn on/off profiling in a particular process.

            @Override
            public boolean profileControl(java.lang.String process, int userId, boolean start, android.app.ProfilerInfo profilerInfo, int profileType) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(process);
                    _data.writeInt(userId);
                    _data.writeInt(((start) ? (1) : (0)));
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profileType);
                    mRemote.transact(Stub.TRANSACTION_profileControl, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean shutdown(int timeout) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(timeout);
                    mRemote.transact(Stub.TRANSACTION_shutdown, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void stopAppSwitches() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopAppSwitches, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void resumeAppSwitches() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_resumeAppSwitches, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean bindBackupAgent(java.lang.String packageName, int backupRestoreMode, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(backupRestoreMode);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_bindBackupAgent, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void backupAgentCreated(java.lang.String packageName, android.os.IBinder agent) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeStrongBinder(agent);
                    mRemote.transact(Stub.TRANSACTION_backupAgentCreated, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unbindBackupAgent(android.content.pm.ApplicationInfo appInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((appInfo != null)) {
                        _data.writeInt(1);
                        appInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_unbindBackupAgent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getUidForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_getUidForIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int handleIncomingUser(int callingPid, int callingUid, int userId, boolean allowAll, boolean requireFull, java.lang.String name, java.lang.String callerPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(callingPid);
                    _data.writeInt(callingUid);
                    _data.writeInt(userId);
                    _data.writeInt(((allowAll) ? (1) : (0)));
                    _data.writeInt(((requireFull) ? (1) : (0)));
                    _data.writeString(name);
                    _data.writeString(callerPackage);
                    mRemote.transact(Stub.TRANSACTION_handleIncomingUser, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addPackageDependency(java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    mRemote.transact(Stub.TRANSACTION_addPackageDependency, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void killApplication(java.lang.String pkg, int appId, int userId, java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(appId);
                    _data.writeInt(userId);
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_killApplication, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_closeSystemDialogs, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.Debug.MemoryInfo[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeIntArray(pids);
                    mRemote.transact(Stub.TRANSACTION_getProcessMemoryInfo, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArray(android.os.Debug.MemoryInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void killApplicationProcess(java.lang.String processName, int uid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(processName);
                    _data.writeInt(uid);
                    mRemote.transact(Stub.TRANSACTION_killApplicationProcess, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int startActivityIntentSender(android.app.IApplicationThread caller, android.content.IIntentSender target, android.os.IBinder whitelistToken, android.content.Intent fillInIntent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flagsMask, int flagsValues, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeStrongBinder((((target != null)) ? (target.asBinder()) : (null)));
                    _data.writeStrongBinder(whitelistToken);
                    if ((fillInIntent != null)) {
                        _data.writeInt(1);
                        fillInIntent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(flagsMask);
                    _data.writeInt(flagsValues);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startActivityIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void overridePendingTransition(android.os.IBinder token, java.lang.String packageName, int enterAnim, int exitAnim) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeString(packageName);
                    _data.writeInt(enterAnim);
                    _data.writeInt(exitAnim);
                    mRemote.transact(Stub.TRANSACTION_overridePendingTransition, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// Special low-level communication with activity manager.

            @Override
            public boolean handleApplicationWtf(android.os.IBinder app, java.lang.String tag, boolean system, android.app.ApplicationErrorReport.ParcelableCrashInfo crashInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(app);
                    _data.writeString(tag);
                    _data.writeInt(((system) ? (1) : (0)));
                    if ((crashInfo != null)) {
                        _data.writeInt(1);
                        crashInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_handleApplicationWtf, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void killBackgroundProcesses(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_killBackgroundProcesses, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isUserAMonkey() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isUserAMonkey, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.app.WaitResult startActivityAndWait(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.WaitResult _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(flags);
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startActivityAndWait, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.WaitResult.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean willActivityBeVisible(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_willActivityBeVisible, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int startActivityWithConfig(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int startFlags, android.content.res.Configuration newConfig, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(startFlags);
                    if ((newConfig != null)) {
                        _data.writeInt(1);
                        newConfig.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startActivityWithConfig, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Retrieve info of applications installed on external media that are currently
// running.

            @Override
            public java.util.List<android.content.pm.ApplicationInfo> getRunningExternalApplications() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.content.pm.ApplicationInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getRunningExternalApplications, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.content.pm.ApplicationInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void finishHeavyWeightApp() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_finishHeavyWeightApp, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// A StrictMode violation to be handled.  The violationMask is a
// subset of the original StrictMode policy bitmask, with only the
// bit violated and penalty bits to be executed by the
// ActivityManagerService remaining set.

            @Override
            public void handleApplicationStrictModeViolation(android.os.IBinder app, int violationMask, android.os.StrictMode.ViolationInfo crashInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(app);
                    _data.writeInt(violationMask);
                    if ((crashInfo != null)) {
                        _data.writeInt(1);
                        crashInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_handleApplicationStrictModeViolation, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isImmersive(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_isImmersive, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setImmersive(android.os.IBinder token, boolean immersive) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((immersive) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setImmersive, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isTopActivityImmersive() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isTopActivityImmersive, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void crashApplication(int uid, int initialPid, java.lang.String packageName, int userId, java.lang.String message) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(initialPid);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    _data.writeString(message);
                    mRemote.transact(Stub.TRANSACTION_crashApplication, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.lang.String getProviderMimeType(android.net.Uri uri, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_getProviderMimeType, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.os.IBinder newUriPermissionOwner(java.lang.String name) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.IBinder _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(name);
                    mRemote.transact(Stub.TRANSACTION_newUriPermissionOwner, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readStrongBinder();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void grantUriPermissionFromOwner(android.os.IBinder owner, int fromUid, java.lang.String targetPkg, android.net.Uri uri, int mode, int sourceUserId, int targetUserId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(owner);
                    _data.writeInt(fromUid);
                    _data.writeString(targetPkg);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(mode);
                    _data.writeInt(sourceUserId);
                    _data.writeInt(targetUserId);
                    mRemote.transact(Stub.TRANSACTION_grantUriPermissionFromOwner, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void revokeUriPermissionFromOwner(android.os.IBinder owner, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(owner);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(mode);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_revokeUriPermissionFromOwner, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int checkGrantUriPermission(int callingUid, java.lang.String targetPkg, android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(callingUid);
                    _data.writeString(targetPkg);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(modeFlags);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_checkGrantUriPermission, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Cause the specified process to dump the specified heap.

            @Override
            public boolean dumpHeap(java.lang.String process, int userId, boolean managed, boolean mallocInfo, boolean runGc, java.lang.String path, android.os.ParcelFileDescriptor fd) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(process);
                    _data.writeInt(userId);
                    _data.writeInt(((managed) ? (1) : (0)));
                    _data.writeInt(((mallocInfo) ? (1) : (0)));
                    _data.writeInt(((runGc) ? (1) : (0)));
                    _data.writeString(path);
                    if ((fd != null)) {
                        _data.writeInt(1);
                        fd.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_dumpHeap, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int startActivities(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent[] intents, java.lang.String[] resolvedTypes, android.os.IBinder resultTo, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    _data.writeTypedArray(intents, 0);
                    _data.writeStringArray(resolvedTypes);
                    _data.writeStrongBinder(resultTo);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startActivities, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean isUserRunning(int userid, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userid);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_isUserRunning, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void activitySlept(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_activitySlept, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public int getFrontActivityScreenCompatMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getFrontActivityScreenCompatMode, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setFrontActivityScreenCompatMode(int mode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(mode);
                    mRemote.transact(Stub.TRANSACTION_setFrontActivityScreenCompatMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getPackageScreenCompatMode(java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    mRemote.transact(Stub.TRANSACTION_getPackageScreenCompatMode, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setPackageScreenCompatMode(java.lang.String packageName, int mode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(mode);
                    mRemote.transact(Stub.TRANSACTION_setPackageScreenCompatMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean getPackageAskScreenCompat(java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    mRemote.transact(Stub.TRANSACTION_getPackageAskScreenCompat, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setPackageAskScreenCompat(java.lang.String packageName, boolean ask) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(((ask) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setPackageAskScreenCompat, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean switchUser(int userid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userid);
                    mRemote.transact(Stub.TRANSACTION_switchUser, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setFocusedTask(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_setFocusedTask, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean removeTask(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_removeTask, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void registerProcessObserver(android.app.IProcessObserver observer) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerProcessObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterProcessObserver(android.app.IProcessObserver observer) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterProcessObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isIntentSenderTargetedToPackage(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_isIntentSenderTargetedToPackage, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void updatePersistentConfiguration(android.content.res.Configuration values) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((values != null)) {
                        _data.writeInt(1);
                        values.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_updatePersistentConfiguration, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public long[] getProcessPss(int[] pids) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                long[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeIntArray(pids);
                    mRemote.transact(Stub.TRANSACTION_getProcessPss, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createLongArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void showBootMessage(java.lang.CharSequence msg, boolean always) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((msg != null)) {
                        _data.writeInt(1);
                        android.text.TextUtils.writeToParcel(msg, _data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((always) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_showBootMessage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void killAllBackgroundProcesses() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_killAllBackgroundProcesses, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.app.ContentProviderHolder getContentProviderExternal(java.lang.String name, int userId, android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ContentProviderHolder _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeInt(userId);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getContentProviderExternal, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ContentProviderHolder.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void removeContentProviderExternal(java.lang.String name, android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(name);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_removeContentProviderExternal, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// Get memory information about the calling process.

            @Override
            public void getMyMemoryState(android.app.ActivityManager.RunningAppProcessInfo outInfo) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getMyMemoryState, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        outInfo.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean killProcessesBelowForeground(java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_killProcessesBelowForeground, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.content.pm.UserInfo getCurrentUser() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.pm.UserInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getCurrentUser, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.pm.UserInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean shouldUpRecreateTask(android.os.IBinder token, java.lang.String destAffinity) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeString(destAffinity);
                    mRemote.transact(Stub.TRANSACTION_shouldUpRecreateTask, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean navigateUpTo(android.os.IBinder token, android.content.Intent target, int resultCode, android.content.Intent resultData) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((target != null)) {
                        _data.writeInt(1);
                        target.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(resultCode);
                    if ((resultData != null)) {
                        _data.writeInt(1);
                        resultData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_navigateUpTo, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Informs ActivityManagerService that the keyguard is showing.
             *
             * @param showing                 True if the keyguard is showing, false otherwise.
             * @param secondaryDisplayShowing The displayId of the secondary display on which the keyguard
             *                                is showing, or INVALID_DISPLAY if there is no such display. Only meaningful if
             *                                showing is true.
             */
            @Override
            public void setLockScreenShown(boolean showing, int secondaryDisplayShowing) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((showing) ? (1) : (0)));
                    _data.writeInt(secondaryDisplayShowing);
                    mRemote.transact(Stub.TRANSACTION_setLockScreenShown, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean finishActivityAffinity(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_finishActivityAffinity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int getLaunchedFromUid(android.os.IBinder activityToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(activityToken);
                    mRemote.transact(Stub.TRANSACTION_getLaunchedFromUid, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unstableProviderDied(android.os.IBinder connection) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(connection);
                    mRemote.transact(Stub.TRANSACTION_unstableProviderDied, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isIntentSenderAnActivity(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_isIntentSenderAnActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int startActivityAsUser(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(flags);
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startActivityAsUser, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int stopUser(int userid, boolean force, android.app.IStopUserCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userid);
                    _data.writeInt(((force) ? (1) : (0)));
                    _data.writeStrongBinder((((callback != null)) ? (callback.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_stopUser, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void registerUserSwitchObserver(android.app.IUserSwitchObserver observer, java.lang.String name) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    _data.writeString(name);
                    mRemote.transact(Stub.TRANSACTION_registerUserSwitchObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterUserSwitchObserver(android.app.IUserSwitchObserver observer) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterUserSwitchObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int[] getRunningUserIds() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getRunningUserIds, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createIntArray();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Deprecated - This method is only used by a few internal components and it will soon be
// replaced by a proper bug report API (which will be restricted to a few, pre-defined apps).
// No new code should be calling it.

            @Override
            public void requestBugReport(int bugreportType) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(bugreportType);
                    mRemote.transact(Stub.TRANSACTION_requestBugReport, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Takes a telephony bug report and notifies the user with the title and description
             * that are passed to this API as parameters
             *
             * @param shareTitle       should be a valid legible string less than 50 chars long
             * @param shareDescription should be less than 91 bytes when encoded into UTF-8 format
             * @throws IllegalArgumentException if shareTitle or shareDescription is too big or if the
             *                                  paremeters cannot be encoding to an UTF-8 charset.
             */
            @Override
            public void requestTelephonyBugReport(java.lang.String shareTitle, java.lang.String shareDescription) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(shareTitle);
                    _data.writeString(shareDescription);
                    mRemote.transact(Stub.TRANSACTION_requestTelephonyBugReport, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public long inputDispatchingTimedOut(int pid, boolean aboveSystem, java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                long _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(pid);
                    _data.writeInt(((aboveSystem) ? (1) : (0)));
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_inputDispatchingTimedOut, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void clearPendingBackup() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_clearPendingBackup, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.content.Intent getIntentForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.Intent _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_getIntentForIntentSender, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.Intent.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.os.Bundle getAssistContextExtras(int requestType) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.Bundle _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(requestType);
                    mRemote.transact(Stub.TRANSACTION_getAssistContextExtras, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.os.Bundle.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void reportAssistContextExtras(android.os.IBinder token, android.os.Bundle extras, android.app.assist.AssistStructure structure, android.app.assist.AssistContent content, android.net.Uri referrer) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((extras != null)) {
                        _data.writeInt(1);
                        extras.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((structure != null)) {
                        _data.writeInt(1);
                        structure.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((content != null)) {
                        _data.writeInt(1);
                        content.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((referrer != null)) {
                        _data.writeInt(1);
                        referrer.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_reportAssistContextExtras, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.lang.String getLaunchedFromPackage(android.os.IBinder activityToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(activityToken);
                    mRemote.transact(Stub.TRANSACTION_getLaunchedFromPackage, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void killUid(int appId, int userId, java.lang.String reason) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(appId);
                    _data.writeInt(userId);
                    _data.writeString(reason);
                    mRemote.transact(Stub.TRANSACTION_killUid, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setUserIsMonkey(boolean monkey) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((monkey) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setUserIsMonkey, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void hang(android.os.IBinder who, boolean allowRestart) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(who);
                    _data.writeInt(((allowRestart) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_hang, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void moveTaskToStack(int taskId, int stackId, boolean toTop) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(stackId);
                    _data.writeInt(((toTop) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_moveTaskToStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Resizes the input stack id to the given bounds.
             *
             * @param stackId                 Id of the stack to resize.
             * @param bounds                  Bounds to resize the stack to or {@code null} for fullscreen.
             * @param allowResizeInDockedMode True if the resize should be allowed when the docked stack is
             *                                active.
             * @param preserveWindows         True if the windows of activities contained in the stack should be
             *                                preserved.
             * @param animate                 True if the stack resize should be animated.
             * @param animationDuration       The duration of the resize animation in milliseconds or -1 if the
             *                                default animation duration should be used.
             * @throws RemoteException
             */
            @Override
            public void resizeStack(int stackId, android.graphics.Rect bounds, boolean allowResizeInDockedMode, boolean preserveWindows, boolean animate, int animationDuration) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    if ((bounds != null)) {
                        _data.writeInt(1);
                        bounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((allowResizeInDockedMode) ? (1) : (0)));
                    _data.writeInt(((preserveWindows) ? (1) : (0)));
                    _data.writeInt(((animate) ? (1) : (0)));
                    _data.writeInt(animationDuration);
                    mRemote.transact(Stub.TRANSACTION_resizeStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.util.List<android.app.ActivityManager.StackInfo> getAllStackInfos() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.app.ActivityManager.StackInfo> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getAllStackInfos, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(android.app.ActivityManager.StackInfo.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setFocusedStack(int stackId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    mRemote.transact(Stub.TRANSACTION_setFocusedStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.app.ActivityManager.StackInfo getStackInfo(int stackId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ActivityManager.StackInfo _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    mRemote.transact(Stub.TRANSACTION_getStackInfo, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ActivityManager.StackInfo.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean convertFromTranslucent(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_convertFromTranslucent, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean convertToTranslucent(android.os.IBinder token, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_convertToTranslucent, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void notifyActivityDrawn(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_notifyActivityDrawn, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void reportActivityFullyDrawn(android.os.IBinder token, boolean restoredFromBundle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((restoredFromBundle) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_reportActivityFullyDrawn, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void restart() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_restart, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void performIdleMaintenance() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_performIdleMaintenance, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void takePersistableUriPermission(android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(modeFlags);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_takePersistableUriPermission, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void releasePersistableUriPermission(android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((uri != null)) {
                        _data.writeInt(1);
                        uri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(modeFlags);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_releasePersistableUriPermission, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.content.pm.ParceledListSlice getPersistedUriPermissions(java.lang.String packageName, boolean incoming) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.pm.ParceledListSlice _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(((incoming) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_getPersistedUriPermissions, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void appNotRespondingViaProvider(android.os.IBinder connection) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(connection);
                    mRemote.transact(Stub.TRANSACTION_appNotRespondingViaProvider, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.graphics.Rect getTaskBounds(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.graphics.Rect _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_getTaskBounds, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.graphics.Rect.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int getActivityDisplayId(android.os.IBinder activityToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(activityToken);
                    mRemote.transact(Stub.TRANSACTION_getActivityDisplayId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean setProcessMemoryTrimLevel(java.lang.String process, int uid, int level) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(process);
                    _data.writeInt(uid);
                    _data.writeInt(level);
                    mRemote.transact(Stub.TRANSACTION_setProcessMemoryTrimLevel, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public java.lang.String getTagForIntentSender(android.content.IIntentSender sender, java.lang.String prefix) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.lang.String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeString(prefix);
                    mRemote.transact(Stub.TRANSACTION_getTagForIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean startUserInBackground(int userid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userid);
                    mRemote.transact(Stub.TRANSACTION_startUserInBackground, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void startLockTaskModeById(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_startLockTaskModeById, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void startLockTaskModeByToken(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_startLockTaskModeByToken, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void stopLockTaskMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopLockTaskMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isInLockTaskMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isInLockTaskMode, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setTaskDescription(android.os.IBinder token, android.app.ActivityManager.TaskDescription values) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((values != null)) {
                        _data.writeInt(1);
                        values.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_setTaskDescription, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int startVoiceActivity(java.lang.String callingPackage, int callingPid, int callingUid, android.content.Intent intent, java.lang.String resolvedType, android.service.voice.IVoiceInteractionSession session, com.android.internal.app.IVoiceInteractor interactor, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(callingPid);
                    _data.writeInt(callingUid);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder((((session != null)) ? (session.asBinder()) : (null)));
                    _data.writeStrongBinder((((interactor != null)) ? (interactor.asBinder()) : (null)));
                    _data.writeInt(flags);
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startVoiceActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int startAssistantActivity(java.lang.String callingPackage, int callingPid, int callingUid, android.content.Intent intent, java.lang.String resolvedType, android.os.Bundle options, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(callingPid);
                    _data.writeInt(callingUid);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startAssistantActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.os.Bundle getActivityOptions(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.Bundle _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getActivityOptions, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.os.Bundle.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public java.util.List<android.os.IBinder> getAppTasks(java.lang.String callingPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<android.os.IBinder> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    mRemote.transact(Stub.TRANSACTION_getAppTasks, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createBinderArrayList();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void startSystemLockTaskMode(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_startSystemLockTaskMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void stopSystemLockTaskMode() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopSystemLockTaskMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void finishVoiceTask(android.service.voice.IVoiceInteractionSession session) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((session != null)) ? (session.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_finishVoiceTask, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isTopOfTask(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_isTopOfTask, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void notifyLaunchTaskBehindComplete(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_notifyLaunchTaskBehindComplete, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int startActivityFromRecents(int taskId, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startActivityFromRecents, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void notifyEnterAnimationComplete(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_notifyEnterAnimationComplete, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int startActivityAsCaller(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, boolean ignoreTargetSecurity, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((caller != null)) ? (caller.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder(resultTo);
                    _data.writeString(resultWho);
                    _data.writeInt(requestCode);
                    _data.writeInt(flags);
                    if ((profilerInfo != null)) {
                        _data.writeInt(1);
                        profilerInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(((ignoreTargetSecurity) ? (1) : (0)));
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_startActivityAsCaller, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int addAppTask(android.os.IBinder activityToken, android.content.Intent intent, android.app.ActivityManager.TaskDescription description, android.graphics.Bitmap thumbnail) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(activityToken);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((description != null)) {
                        _data.writeInt(1);
                        description.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((thumbnail != null)) {
                        _data.writeInt(1);
                        thumbnail.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_addAppTask, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public android.graphics.Point getAppTaskThumbnailSize() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.graphics.Point _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getAppTaskThumbnailSize, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.graphics.Point.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean releaseActivityInstance(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_releaseActivityInstance, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void releaseSomeActivities(android.app.IApplicationThread app) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((app != null)) ? (app.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_releaseSomeActivities, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void bootAnimationComplete() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_bootAnimationComplete, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.graphics.Bitmap getTaskDescriptionIcon(java.lang.String filename, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.graphics.Bitmap _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(filename);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_getTaskDescriptionIcon, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean launchAssistIntent(android.content.Intent intent, int requestType, java.lang.String hint, int userHandle, android.os.Bundle args) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(requestType);
                    _data.writeString(hint);
                    _data.writeInt(userHandle);
                    if ((args != null)) {
                        _data.writeInt(1);
                        args.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_launchAssistIntent, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void startInPlaceAnimationOnFrontMostApplication(android.os.Bundle opts) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((opts != null)) {
                        _data.writeInt(1);
                        opts.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startInPlaceAnimationOnFrontMostApplication, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int checkPermissionWithToken(java.lang.String permission, int pid, int uid, android.os.IBinder callerToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(permission);
                    _data.writeInt(pid);
                    _data.writeInt(uid);
                    _data.writeStrongBinder(callerToken);
                    mRemote.transact(Stub.TRANSACTION_checkPermissionWithToken, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void registerTaskStackListener(android.app.ITaskStackListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerTaskStackListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// Start of M transactions

            @Override
            public void notifyCleartextNetwork(int uid, byte[] firstPacket) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeByteArray(firstPacket);
                    mRemote.transact(Stub.TRANSACTION_notifyCleartextNetwork, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int createStackOnDisplay(int displayId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(displayId);
                    mRemote.transact(Stub.TRANSACTION_createStackOnDisplay, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public int getFocusedStackId() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getFocusedStackId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setTaskResizeable(int taskId, int resizeableMode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(resizeableMode);
                    mRemote.transact(Stub.TRANSACTION_setTaskResizeable, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean requestAssistContextExtras(int requestType, com.android.internal.os.IResultReceiver receiver, android.os.Bundle receiverExtras, android.os.IBinder activityToken, boolean focused, boolean newSessionId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(requestType);
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    if ((receiverExtras != null)) {
                        _data.writeInt(1);
                        receiverExtras.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(activityToken);
                    _data.writeInt(((focused) ? (1) : (0)));
                    _data.writeInt(((newSessionId) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_requestAssistContextExtras, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void resizeTask(int taskId, android.graphics.Rect bounds, int resizeMode) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    if ((bounds != null)) {
                        _data.writeInt(1);
                        bounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(resizeMode);
                    mRemote.transact(Stub.TRANSACTION_resizeTask, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getLockTaskModeState() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getLockTaskModeState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setDumpHeapDebugLimit(java.lang.String processName, int uid, long maxMemSize, java.lang.String reportPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(processName);
                    _data.writeInt(uid);
                    _data.writeLong(maxMemSize);
                    _data.writeString(reportPackage);
                    mRemote.transact(Stub.TRANSACTION_setDumpHeapDebugLimit, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void dumpHeapFinished(java.lang.String path) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(path);
                    mRemote.transact(Stub.TRANSACTION_dumpHeapFinished, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setVoiceKeepAwake(android.service.voice.IVoiceInteractionSession session, boolean keepAwake) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((session != null)) ? (session.asBinder()) : (null)));
                    _data.writeInt(((keepAwake) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setVoiceKeepAwake, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void updateLockTaskPackages(int userId, java.lang.String[] packages) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeStringArray(packages);
                    mRemote.transact(Stub.TRANSACTION_updateLockTaskPackages, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteAlarmStart(android.content.IIntentSender sender, int sourceUid, java.lang.String tag) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeInt(sourceUid);
                    _data.writeString(tag);
                    mRemote.transact(Stub.TRANSACTION_noteAlarmStart, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteAlarmFinish(android.content.IIntentSender sender, int sourceUid, java.lang.String tag) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((sender != null)) ? (sender.asBinder()) : (null)));
                    _data.writeInt(sourceUid);
                    _data.writeString(tag);
                    mRemote.transact(Stub.TRANSACTION_noteAlarmFinish, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getPackageProcessState(java.lang.String packageName, java.lang.String callingPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeString(callingPackage);
                    mRemote.transact(Stub.TRANSACTION_getPackageProcessState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void showLockTaskEscapeMessage(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_showLockTaskEscapeMessage, _data, null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void updateDeviceOwner(java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    mRemote.transact(Stub.TRANSACTION_updateDeviceOwner, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Notify the system that the keyguard is going away.
             *
             * @param flags See {@link android.view.WindowManagerPolicy#KEYGUARD_GOING_AWAY_FLAG_TO_SHADE}
             *              etc.
             */
            @Override
            public void keyguardGoingAway(int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_keyguardGoingAway, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getUidProcessState(int uid, java.lang.String callingPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeString(callingPackage);
                    mRemote.transact(Stub.TRANSACTION_getUidProcessState, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void registerUidObserver(android.app.IUidObserver observer, int which, int cutpoint, java.lang.String callingPackage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    _data.writeInt(which);
                    _data.writeInt(cutpoint);
                    _data.writeString(callingPackage);
                    mRemote.transact(Stub.TRANSACTION_registerUidObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterUidObserver(android.app.IUidObserver observer) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((observer != null)) ? (observer.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterUidObserver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isAssistDataAllowedOnCurrentActivity() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_isAssistDataAllowedOnCurrentActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean showAssistFromActivity(android.os.IBinder token, android.os.Bundle args) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((args != null)) {
                        _data.writeInt(1);
                        args.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_showAssistFromActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean isRootVoiceInteraction(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_isRootVoiceInteraction, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Start of N transactions
// Start Binder transaction tracking for all applications.

            @Override
            public boolean startBinderTracking() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_startBinderTracking, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Stop Binder transaction tracking for all applications and dump trace data to the given file
// descriptor.

            @Override
            public boolean stopBinderTrackingAndDump(android.os.ParcelFileDescriptor fd) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((fd != null)) {
                        _data.writeInt(1);
                        fd.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_stopBinderTrackingAndDump, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Try to place task to provided position. The final position might be different depending on
             * current user and stacks state. The task will be moved to target stack if it's currently in
             * different stack.
             */
            @Override
            public void positionTaskInStack(int taskId, int stackId, int position) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(stackId);
                    _data.writeInt(position);
                    mRemote.transact(Stub.TRANSACTION_positionTaskInStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getActivityStackId(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getActivityStackId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void exitFreeformMode(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_exitFreeformMode, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void reportSizeConfigurations(android.os.IBinder token, int[] horizontalSizeConfiguration, int[] verticalSizeConfigurations, int[] smallestWidthConfigurations) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeIntArray(horizontalSizeConfiguration);
                    _data.writeIntArray(verticalSizeConfigurations);
                    _data.writeIntArray(smallestWidthConfigurations);
                    mRemote.transact(Stub.TRANSACTION_reportSizeConfigurations, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean moveTaskToDockedStack(int taskId, int createMode, boolean toTop, boolean animate, android.graphics.Rect initialBounds) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(createMode);
                    _data.writeInt(((toTop) ? (1) : (0)));
                    _data.writeInt(((animate) ? (1) : (0)));
                    if ((initialBounds != null)) {
                        _data.writeInt(1);
                        initialBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_moveTaskToDockedStack, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void suppressResizeConfigChanges(boolean suppress) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((suppress) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_suppressResizeConfigChanges, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void moveTasksToFullscreenStack(int fromStackId, boolean onTop) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(fromStackId);
                    _data.writeInt(((onTop) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_moveTasksToFullscreenStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean moveTopActivityToPinnedStack(int stackId, android.graphics.Rect bounds) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    if ((bounds != null)) {
                        _data.writeInt(1);
                        bounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_moveTopActivityToPinnedStack, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean isAppStartModeDisabled(int uid, java.lang.String packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeString(packageName);
                    mRemote.transact(Stub.TRANSACTION_isAppStartModeDisabled, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean unlockUser(int userid, byte[] token, byte[] secret, android.os.IProgressListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userid);
                    _data.writeByteArray(token);
                    _data.writeByteArray(secret);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unlockUser, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean isInMultiWindowMode(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_isInMultiWindowMode, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public boolean isInPictureInPictureMode(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_isInPictureInPictureMode, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void killPackageDependents(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_killPackageDependents, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean enterPictureInPictureMode(android.os.IBinder token, android.app.PictureInPictureParams params) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((params != null)) {
                        _data.writeInt(1);
                        params.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_enterPictureInPictureMode, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void setPictureInPictureParams(android.os.IBinder token, android.app.PictureInPictureParams params) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((params != null)) {
                        _data.writeInt(1);
                        params.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_setPictureInPictureParams, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getMaxNumPictureInPictureActions(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_getMaxNumPictureInPictureActions, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void activityRelaunched(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_activityRelaunched, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public android.os.IBinder getUriPermissionOwnerForActivity(android.os.IBinder activityToken) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.os.IBinder _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(activityToken);
                    mRemote.transact(Stub.TRANSACTION_getUriPermissionOwnerForActivity, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readStrongBinder();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Resizes the docked stack, and all other stacks as the result of the dock stack bounds change.
             *
             * @param dockedBounds              The bounds for the docked stack.
             * @param tempDockedTaskBounds      The temporary bounds for the tasks in the docked stack, which
             *                                  might be different from the stack bounds to allow more
             *                                  flexibility while resizing, or {@code null} if they should be the
             *                                  same as the stack bounds.
             * @param tempDockedTaskInsetBounds The temporary bounds for the tasks to calculate the insets.
             *                                  When resizing, we usually "freeze" the layout of a task. To
             *                                  achieve that, we also need to "freeze" the insets, which
             *                                  gets achieved by changing task bounds but not bounds used
             *                                  to calculate the insets in this transient state
             * @param tempOtherTaskBounds       The temporary bounds for the tasks in all other stacks, or
             *                                  {@code null} if they should be the same as the stack bounds.
             * @param tempOtherTaskInsetBounds  Like {@code tempDockedTaskInsetBounds}, but for the other
             *                                  stacks.
             * @throws RemoteException
             */
            @Override
            public void resizeDockedStack(android.graphics.Rect dockedBounds, android.graphics.Rect tempDockedTaskBounds, android.graphics.Rect tempDockedTaskInsetBounds, android.graphics.Rect tempOtherTaskBounds, android.graphics.Rect tempOtherTaskInsetBounds) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((dockedBounds != null)) {
                        _data.writeInt(1);
                        dockedBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((tempDockedTaskBounds != null)) {
                        _data.writeInt(1);
                        tempDockedTaskBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((tempDockedTaskInsetBounds != null)) {
                        _data.writeInt(1);
                        tempDockedTaskInsetBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((tempOtherTaskBounds != null)) {
                        _data.writeInt(1);
                        tempOtherTaskBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((tempOtherTaskInsetBounds != null)) {
                        _data.writeInt(1);
                        tempOtherTaskInsetBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_resizeDockedStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int setVrMode(android.os.IBinder token, boolean enabled, android.content.ComponentName packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((enabled) ? (1) : (0)));
                    if ((packageName != null)) {
                        _data.writeInt(1);
                        packageName.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_setVrMode, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Gets the URI permissions granted to an arbitrary package.
// NOTE: this is different from getPersistedUriPermissions(), which returns the URIs the package
// granted to another packages (instead of those granted to it).

            @Override
            public android.content.pm.ParceledListSlice getGrantedUriPermissions(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.content.pm.ParceledListSlice _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_getGrantedUriPermissions, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Clears the URI permissions granted to an arbitrary package.

            @Override
            public void clearGrantedUriPermissions(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_clearGrantedUriPermissions, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isAppForeground(int uid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    mRemote.transact(Stub.TRANSACTION_isAppForeground, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void startLocalVoiceInteraction(android.os.IBinder token, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startLocalVoiceInteraction, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void stopLocalVoiceInteraction(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_stopLocalVoiceInteraction, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean supportsLocalVoiceInteraction() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_supportsLocalVoiceInteraction, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void notifyPinnedStackAnimationStarted() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_notifyPinnedStackAnimationStarted, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void notifyPinnedStackAnimationEnded() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_notifyPinnedStackAnimationEnded, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removeStack(int stackId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    mRemote.transact(Stub.TRANSACTION_removeStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void makePackageIdle(java.lang.String packageName, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_makePackageIdle, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getMemoryTrimLevel() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getMemoryTrimLevel, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Resizes the pinned stack.
             *
             * @param pinnedBounds         The bounds for the pinned stack.
             * @param tempPinnedTaskBounds The temporary bounds for the tasks in the pinned stack, which
             *                             might be different from the stack bounds to allow more
             *                             flexibility while resizing, or {@code null} if they should be the
             *                             same as the stack bounds.
             */
            @Override
            public void resizePinnedStack(android.graphics.Rect pinnedBounds, android.graphics.Rect tempPinnedTaskBounds) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((pinnedBounds != null)) {
                        _data.writeInt(1);
                        pinnedBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((tempPinnedTaskBounds != null)) {
                        _data.writeInt(1);
                        tempPinnedTaskBounds.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_resizePinnedStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isVrModePackageEnabled(android.content.ComponentName packageName) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((packageName != null)) {
                        _data.writeInt(1);
                        packageName.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_isVrModePackageEnabled, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Moves all tasks from the docked stack in the fullscreen stack and puts the top task of the
             * fullscreen stack into the docked stack.
             */
            @Override
            public void swapDockedAndFullscreenStack() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_swapDockedAndFullscreenStack, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void notifyLockedProfile(int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_notifyLockedProfile, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void startConfirmDeviceCredentialIntent(android.content.Intent intent, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_startConfirmDeviceCredentialIntent, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendIdleJobTrigger() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_sendIdleJobTrigger, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int sendIntentSender(android.content.IIntentSender target, android.os.IBinder whitelistToken, int code, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver finishedReceiver, java.lang.String requiredPermission, android.os.Bundle options) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((target != null)) ? (target.asBinder()) : (null)));
                    _data.writeStrongBinder(whitelistToken);
                    _data.writeInt(code);
                    if ((intent != null)) {
                        _data.writeInt(1);
                        intent.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(resolvedType);
                    _data.writeStrongBinder((((finishedReceiver != null)) ? (finishedReceiver.asBinder()) : (null)));
                    _data.writeString(requiredPermission);
                    if ((options != null)) {
                        _data.writeInt(1);
                        options.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_sendIntentSender, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
// Start of N MR1 transactions

            @Override
            public void setVrThread(int tid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(tid);
                    mRemote.transact(Stub.TRANSACTION_setVrThread, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setRenderThread(int tid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(tid);
                    mRemote.transact(Stub.TRANSACTION_setRenderThread, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Lets activity manager know whether the calling process is currently showing "top-level" UI
             * that is not an activity, i.e. windows on the screen the user is currently interacting with.
             *
             * <p>This flag can only be set for persistent processes.
             *
             * @param hasTopUi Whether the calling process has "top-level" UI.
             */
            @Override
            public void setHasTopUi(boolean hasTopUi) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(((hasTopUi) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setHasTopUi, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// Start of O transactions

            @Override
            public void requestActivityRelaunch(android.os.IBinder token) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    mRemote.transact(Stub.TRANSACTION_requestActivityRelaunch, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Updates override configuration applied to specific display.
             *
             * @param values    Update values for display configuration. If null is passed it will request the
             *                  Window Manager to compute new config for the specified display.
             * @param displayId Id of the display to apply the config to.
             * @return Returns true if the configuration was updated.
             * @throws RemoteException
             */
            @Override
            public boolean updateDisplayOverrideConfiguration(android.content.res.Configuration values, int displayId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((values != null)) {
                        _data.writeInt(1);
                        values.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(displayId);
                    mRemote.transact(Stub.TRANSACTION_updateDisplayOverrideConfiguration, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unregisterTaskStackListener(android.app.ITaskStackListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterTaskStackListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void moveStackToDisplay(int stackId, int displayId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(stackId);
                    _data.writeInt(displayId);
                    mRemote.transact(Stub.TRANSACTION_moveStackToDisplay, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean requestAutofillData(com.android.internal.os.IResultReceiver receiver, android.os.Bundle receiverExtras, android.os.IBinder activityToken, int flags) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((receiver != null)) ? (receiver.asBinder()) : (null)));
                    if ((receiverExtras != null)) {
                        _data.writeInt(1);
                        receiverExtras.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeStrongBinder(activityToken);
                    _data.writeInt(flags);
                    mRemote.transact(Stub.TRANSACTION_requestAutofillData, _data, _reply, 0);
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void dismissKeyguard(android.os.IBinder token, com.android.internal.policy.IKeyguardDismissCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeStrongBinder((((callback != null)) ? (callback.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_dismissKeyguard, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int restartUserInBackground(int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_restartUserInBackground, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Cancels the window transitions for the given task.
             */
            @Override
            public void cancelTaskWindowTransition(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_cancelTaskWindowTransition, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Cancels the thumbnail transitions for the given task.
             */
            @Override
            public void cancelTaskThumbnailTransition(int taskId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    mRemote.transact(Stub.TRANSACTION_cancelTaskThumbnailTransition, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * @param taskId            the id of the task to retrieve the sAutoapshots for
             * @param reducedResolution if set, if the snapshot needs to be loaded from disk, this will load
             *                          a reduced resolution of it, which is much faster
             * @return a graphic buffer representing a screenshot of a task
             */
            @Override
            public android.app.ActivityManager.TaskSnapshot getTaskSnapshot(int taskId, boolean reducedResolution) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                android.app.ActivityManager.TaskSnapshot _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(taskId);
                    _data.writeInt(((reducedResolution) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_getTaskSnapshot, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = android.app.ActivityManager.TaskSnapshot.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void scheduleApplicationInfoChanged(java.util.List<java.lang.String> packageNames, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStringList(packageNames);
                    _data.writeInt(userId);
                    mRemote.transact(Stub.TRANSACTION_scheduleApplicationInfoChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setPersistentVrThread(int tid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(tid);
                    mRemote.transact(Stub.TRANSACTION_setPersistentVrThread, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void waitForNetworkStateUpdate(long procStateSeq) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeLong(procStateSeq);
                    mRemote.transact(Stub.TRANSACTION_waitForNetworkStateUpdate, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * See {@link android.app.Activity#setDisablePreviewScreenshots}
             */
            @Override
            public void setDisablePreviewScreenshots(android.os.IBinder token, boolean disable) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((disable) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setDisablePreviewScreenshots, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getLastResumedActivityUserId() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getLastResumedActivityUserId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            /**
             * Add a bare uid to the background restrictions whitelist.  Only the system uid may call this.
             */
            @Override
            public void backgroundWhitelistUid(int uid) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(uid);
                    mRemote.transact(Stub.TRANSACTION_backgroundWhitelistUid, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
// WARNING: when these transactions are updated, check if they are any callers on the native
// side. If so, make sure they are using the correct transaction ids and arguments.
// If a transaction which will also be used on the native side is being inserted, add it
// alongside with other transactions of this kind at the top of this file.

            @Override
            public void setShowWhenLocked(android.os.IBinder token, boolean showWhenLocked) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((showWhenLocked) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setShowWhenLocked, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setTurnScreenOn(android.os.IBinder token, boolean turnScreenOn) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(token);
                    _data.writeInt(((turnScreenOn) ? (1) : (0)));
                    mRemote.transact(Stub.TRANSACTION_setTurnScreenOn, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_openContentUri = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_handleApplicationCrash = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_startActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_unhandledBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_finishActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_registerReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_unregisterReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_broadcastIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
        static final int TRANSACTION_unbroadcastIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
        static final int TRANSACTION_finishReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
        static final int TRANSACTION_attachApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
        static final int TRANSACTION_activityIdle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
        static final int TRANSACTION_activityPaused = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
        static final int TRANSACTION_activityStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
        static final int TRANSACTION_getCallingPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
        static final int TRANSACTION_getCallingActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
        static final int TRANSACTION_getTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
        static final int TRANSACTION_moveTaskToFront = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
        static final int TRANSACTION_moveTaskBackwards = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
        static final int TRANSACTION_getTaskForActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
        static final int TRANSACTION_getContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
        static final int TRANSACTION_publishContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
        static final int TRANSACTION_refContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
        static final int TRANSACTION_finishSubActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
        static final int TRANSACTION_getRunningServiceControlPanel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
        static final int TRANSACTION_startService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
        static final int TRANSACTION_stopService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
        static final int TRANSACTION_bindService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
        static final int TRANSACTION_unbindService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
        static final int TRANSACTION_publishService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
        static final int TRANSACTION_activityResumed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
        static final int TRANSACTION_setDebugApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
        static final int TRANSACTION_setAlwaysFinish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
        static final int TRANSACTION_startInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
        static final int TRANSACTION_addInstrumentationResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
        static final int TRANSACTION_finishInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
        static final int TRANSACTION_getConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
        static final int TRANSACTION_updateConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
        static final int TRANSACTION_stopServiceToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
        static final int TRANSACTION_getActivityClassForToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
        static final int TRANSACTION_getPackageForToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
        static final int TRANSACTION_setProcessLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
        static final int TRANSACTION_getProcessLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
        static final int TRANSACTION_checkPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
        static final int TRANSACTION_checkUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
        static final int TRANSACTION_grantUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
        static final int TRANSACTION_revokeUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
        static final int TRANSACTION_setActivityController = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
        static final int TRANSACTION_showWaitingForDebugger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
        static final int TRANSACTION_signalPersistentProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
        static final int TRANSACTION_getRecentTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
        static final int TRANSACTION_serviceDoneExecuting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
        static final int TRANSACTION_activityDestroyed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
        static final int TRANSACTION_getIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
        static final int TRANSACTION_cancelIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
        static final int TRANSACTION_getPackageForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
        static final int TRANSACTION_registerIntentSenderCancelListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
        static final int TRANSACTION_unregisterIntentSenderCancelListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
        static final int TRANSACTION_enterSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
        static final int TRANSACTION_startNextMatchingActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
        static final int TRANSACTION_noteWakeupAlarm = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
        static final int TRANSACTION_removeContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
        static final int TRANSACTION_setRequestedOrientation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
        static final int TRANSACTION_getRequestedOrientation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
        static final int TRANSACTION_unbindFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
        static final int TRANSACTION_setProcessImportant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
        static final int TRANSACTION_setServiceForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
        static final int TRANSACTION_moveActivityTaskToBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
        static final int TRANSACTION_getMemoryInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
        static final int TRANSACTION_getProcessesInErrorState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
        static final int TRANSACTION_clearApplicationUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
        static final int TRANSACTION_forceStopPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
        static final int TRANSACTION_killPids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
        static final int TRANSACTION_getServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
        static final int TRANSACTION_getTaskThumbnail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
        static final int TRANSACTION_getTaskDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
        static final int TRANSACTION_getRunningAppProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
        static final int TRANSACTION_getDeviceConfigurationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
        static final int TRANSACTION_peekService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
        static final int TRANSACTION_profileControl = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
        static final int TRANSACTION_shutdown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
        static final int TRANSACTION_stopAppSwitches = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
        static final int TRANSACTION_resumeAppSwitches = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
        static final int TRANSACTION_bindBackupAgent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
        static final int TRANSACTION_backupAgentCreated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
        static final int TRANSACTION_unbindBackupAgent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 85);
        static final int TRANSACTION_getUidForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 86);
        static final int TRANSACTION_handleIncomingUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 87);
        static final int TRANSACTION_addPackageDependency = (android.os.IBinder.FIRST_CALL_TRANSACTION + 88);
        static final int TRANSACTION_killApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 89);
        static final int TRANSACTION_closeSystemDialogs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
        static final int TRANSACTION_getProcessMemoryInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 91);
        static final int TRANSACTION_killApplicationProcess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 92);
        static final int TRANSACTION_startActivityIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 93);
        static final int TRANSACTION_overridePendingTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 94);
        static final int TRANSACTION_handleApplicationWtf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 95);
        static final int TRANSACTION_killBackgroundProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 96);
        static final int TRANSACTION_isUserAMonkey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 97);
        static final int TRANSACTION_startActivityAndWait = (android.os.IBinder.FIRST_CALL_TRANSACTION + 98);
        static final int TRANSACTION_willActivityBeVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 99);
        static final int TRANSACTION_startActivityWithConfig = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
        static final int TRANSACTION_getRunningExternalApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
        static final int TRANSACTION_finishHeavyWeightApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
        static final int TRANSACTION_handleApplicationStrictModeViolation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 103);
        static final int TRANSACTION_isImmersive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 104);
        static final int TRANSACTION_setImmersive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 105);
        static final int TRANSACTION_isTopActivityImmersive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 106);
        static final int TRANSACTION_crashApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 107);
        static final int TRANSACTION_getProviderMimeType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 108);
        static final int TRANSACTION_newUriPermissionOwner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 109);
        static final int TRANSACTION_grantUriPermissionFromOwner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
        static final int TRANSACTION_revokeUriPermissionFromOwner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
        static final int TRANSACTION_checkGrantUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
        static final int TRANSACTION_dumpHeap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 113);
        static final int TRANSACTION_startActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 114);
        static final int TRANSACTION_isUserRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 115);
        static final int TRANSACTION_activitySlept = (android.os.IBinder.FIRST_CALL_TRANSACTION + 116);
        static final int TRANSACTION_getFrontActivityScreenCompatMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 117);
        static final int TRANSACTION_setFrontActivityScreenCompatMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 118);
        static final int TRANSACTION_getPackageScreenCompatMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 119);
        static final int TRANSACTION_setPackageScreenCompatMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 120);
        static final int TRANSACTION_getPackageAskScreenCompat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 121);
        static final int TRANSACTION_setPackageAskScreenCompat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 122);
        static final int TRANSACTION_switchUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 123);
        static final int TRANSACTION_setFocusedTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 124);
        static final int TRANSACTION_removeTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 125);
        static final int TRANSACTION_registerProcessObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 126);
        static final int TRANSACTION_unregisterProcessObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 127);
        static final int TRANSACTION_isIntentSenderTargetedToPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 128);
        static final int TRANSACTION_updatePersistentConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 129);
        static final int TRANSACTION_getProcessPss = (android.os.IBinder.FIRST_CALL_TRANSACTION + 130);
        static final int TRANSACTION_showBootMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 131);
        static final int TRANSACTION_killAllBackgroundProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 132);
        static final int TRANSACTION_getContentProviderExternal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 133);
        static final int TRANSACTION_removeContentProviderExternal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 134);
        static final int TRANSACTION_getMyMemoryState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 135);
        static final int TRANSACTION_killProcessesBelowForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 136);
        static final int TRANSACTION_getCurrentUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 137);
        static final int TRANSACTION_shouldUpRecreateTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 138);
        static final int TRANSACTION_navigateUpTo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 139);
        static final int TRANSACTION_setLockScreenShown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 140);
        static final int TRANSACTION_finishActivityAffinity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 141);
        static final int TRANSACTION_getLaunchedFromUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 142);
        static final int TRANSACTION_unstableProviderDied = (android.os.IBinder.FIRST_CALL_TRANSACTION + 143);
        static final int TRANSACTION_isIntentSenderAnActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 144);
        static final int TRANSACTION_startActivityAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 145);
        static final int TRANSACTION_stopUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 146);
        static final int TRANSACTION_registerUserSwitchObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 147);
        static final int TRANSACTION_unregisterUserSwitchObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 148);
        static final int TRANSACTION_getRunningUserIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 149);
        static final int TRANSACTION_requestBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 150);
        static final int TRANSACTION_requestTelephonyBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 151);
        static final int TRANSACTION_inputDispatchingTimedOut = (android.os.IBinder.FIRST_CALL_TRANSACTION + 152);
        static final int TRANSACTION_clearPendingBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 153);
        static final int TRANSACTION_getIntentForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 154);
        static final int TRANSACTION_getAssistContextExtras = (android.os.IBinder.FIRST_CALL_TRANSACTION + 155);
        static final int TRANSACTION_reportAssistContextExtras = (android.os.IBinder.FIRST_CALL_TRANSACTION + 156);
        static final int TRANSACTION_getLaunchedFromPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 157);
        static final int TRANSACTION_killUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 158);
        static final int TRANSACTION_setUserIsMonkey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 159);
        static final int TRANSACTION_hang = (android.os.IBinder.FIRST_CALL_TRANSACTION + 160);
        static final int TRANSACTION_moveTaskToStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 161);
        static final int TRANSACTION_resizeStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 162);
        static final int TRANSACTION_getAllStackInfos = (android.os.IBinder.FIRST_CALL_TRANSACTION + 163);
        static final int TRANSACTION_setFocusedStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 164);
        static final int TRANSACTION_getStackInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 165);
        static final int TRANSACTION_convertFromTranslucent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 166);
        static final int TRANSACTION_convertToTranslucent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 167);
        static final int TRANSACTION_notifyActivityDrawn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 168);
        static final int TRANSACTION_reportActivityFullyDrawn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 169);
        static final int TRANSACTION_restart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 170);
        static final int TRANSACTION_performIdleMaintenance = (android.os.IBinder.FIRST_CALL_TRANSACTION + 171);
        static final int TRANSACTION_takePersistableUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 172);
        static final int TRANSACTION_releasePersistableUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 173);
        static final int TRANSACTION_getPersistedUriPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 174);
        static final int TRANSACTION_appNotRespondingViaProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 175);
        static final int TRANSACTION_getTaskBounds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 176);
        static final int TRANSACTION_getActivityDisplayId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 177);
        static final int TRANSACTION_setProcessMemoryTrimLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 178);
        static final int TRANSACTION_getTagForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 179);
        static final int TRANSACTION_startUserInBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 180);
        static final int TRANSACTION_startLockTaskModeById = (android.os.IBinder.FIRST_CALL_TRANSACTION + 181);
        static final int TRANSACTION_startLockTaskModeByToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 182);
        static final int TRANSACTION_stopLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 183);
        static final int TRANSACTION_isInLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 184);
        static final int TRANSACTION_setTaskDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 185);
        static final int TRANSACTION_startVoiceActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 186);
        static final int TRANSACTION_startAssistantActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 187);
        static final int TRANSACTION_getActivityOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 188);
        static final int TRANSACTION_getAppTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 189);
        static final int TRANSACTION_startSystemLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 190);
        static final int TRANSACTION_stopSystemLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 191);
        static final int TRANSACTION_finishVoiceTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 192);
        static final int TRANSACTION_isTopOfTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 193);
        static final int TRANSACTION_notifyLaunchTaskBehindComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 194);
        static final int TRANSACTION_startActivityFromRecents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 195);
        static final int TRANSACTION_notifyEnterAnimationComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 196);
        static final int TRANSACTION_startActivityAsCaller = (android.os.IBinder.FIRST_CALL_TRANSACTION + 197);
        static final int TRANSACTION_addAppTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 198);
        static final int TRANSACTION_getAppTaskThumbnailSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 199);
        static final int TRANSACTION_releaseActivityInstance = (android.os.IBinder.FIRST_CALL_TRANSACTION + 200);
        static final int TRANSACTION_releaseSomeActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 201);
        static final int TRANSACTION_bootAnimationComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 202);
        static final int TRANSACTION_getTaskDescriptionIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 203);
        static final int TRANSACTION_launchAssistIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 204);
        static final int TRANSACTION_startInPlaceAnimationOnFrontMostApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 205);
        static final int TRANSACTION_checkPermissionWithToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 206);
        static final int TRANSACTION_registerTaskStackListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 207);
        static final int TRANSACTION_notifyCleartextNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 208);
        static final int TRANSACTION_createStackOnDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 209);
        static final int TRANSACTION_getFocusedStackId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 210);
        static final int TRANSACTION_setTaskResizeable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 211);
        static final int TRANSACTION_requestAssistContextExtras = (android.os.IBinder.FIRST_CALL_TRANSACTION + 212);
        static final int TRANSACTION_resizeTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 213);
        static final int TRANSACTION_getLockTaskModeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 214);
        static final int TRANSACTION_setDumpHeapDebugLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 215);
        static final int TRANSACTION_dumpHeapFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 216);
        static final int TRANSACTION_setVoiceKeepAwake = (android.os.IBinder.FIRST_CALL_TRANSACTION + 217);
        static final int TRANSACTION_updateLockTaskPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 218);
        static final int TRANSACTION_noteAlarmStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 219);
        static final int TRANSACTION_noteAlarmFinish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 220);
        static final int TRANSACTION_getPackageProcessState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 221);
        static final int TRANSACTION_showLockTaskEscapeMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 222);
        static final int TRANSACTION_updateDeviceOwner = (android.os.IBinder.FIRST_CALL_TRANSACTION + 223);
        static final int TRANSACTION_keyguardGoingAway = (android.os.IBinder.FIRST_CALL_TRANSACTION + 224);
        static final int TRANSACTION_getUidProcessState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 225);
        static final int TRANSACTION_registerUidObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 226);
        static final int TRANSACTION_unregisterUidObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 227);
        static final int TRANSACTION_isAssistDataAllowedOnCurrentActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 228);
        static final int TRANSACTION_showAssistFromActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 229);
        static final int TRANSACTION_isRootVoiceInteraction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 230);
        static final int TRANSACTION_startBinderTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 231);
        static final int TRANSACTION_stopBinderTrackingAndDump = (android.os.IBinder.FIRST_CALL_TRANSACTION + 232);
        static final int TRANSACTION_positionTaskInStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 233);
        static final int TRANSACTION_getActivityStackId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 234);
        static final int TRANSACTION_exitFreeformMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 235);
        static final int TRANSACTION_reportSizeConfigurations = (android.os.IBinder.FIRST_CALL_TRANSACTION + 236);
        static final int TRANSACTION_moveTaskToDockedStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 237);
        static final int TRANSACTION_suppressResizeConfigChanges = (android.os.IBinder.FIRST_CALL_TRANSACTION + 238);
        static final int TRANSACTION_moveTasksToFullscreenStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 239);
        static final int TRANSACTION_moveTopActivityToPinnedStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 240);
        static final int TRANSACTION_isAppStartModeDisabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 241);
        static final int TRANSACTION_unlockUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 242);
        static final int TRANSACTION_isInMultiWindowMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 243);
        static final int TRANSACTION_isInPictureInPictureMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 244);
        static final int TRANSACTION_killPackageDependents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 245);
        static final int TRANSACTION_enterPictureInPictureMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 246);
        static final int TRANSACTION_setPictureInPictureParams = (android.os.IBinder.FIRST_CALL_TRANSACTION + 247);
        static final int TRANSACTION_getMaxNumPictureInPictureActions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 248);
        static final int TRANSACTION_activityRelaunched = (android.os.IBinder.FIRST_CALL_TRANSACTION + 249);
        static final int TRANSACTION_getUriPermissionOwnerForActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 250);
        static final int TRANSACTION_resizeDockedStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 251);
        static final int TRANSACTION_setVrMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 252);
        static final int TRANSACTION_getGrantedUriPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 253);
        static final int TRANSACTION_clearGrantedUriPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 254);
        static final int TRANSACTION_isAppForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 255);
        static final int TRANSACTION_startLocalVoiceInteraction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 256);
        static final int TRANSACTION_stopLocalVoiceInteraction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 257);
        static final int TRANSACTION_supportsLocalVoiceInteraction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 258);
        static final int TRANSACTION_notifyPinnedStackAnimationStarted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 259);
        static final int TRANSACTION_notifyPinnedStackAnimationEnded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 260);
        static final int TRANSACTION_removeStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 261);
        static final int TRANSACTION_makePackageIdle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 262);
        static final int TRANSACTION_getMemoryTrimLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 263);
        static final int TRANSACTION_resizePinnedStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 264);
        static final int TRANSACTION_isVrModePackageEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 265);
        static final int TRANSACTION_swapDockedAndFullscreenStack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 266);
        static final int TRANSACTION_notifyLockedProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 267);
        static final int TRANSACTION_startConfirmDeviceCredentialIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 268);
        static final int TRANSACTION_sendIdleJobTrigger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 269);
        static final int TRANSACTION_sendIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 270);
        static final int TRANSACTION_setVrThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 271);
        static final int TRANSACTION_setRenderThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 272);
        static final int TRANSACTION_setHasTopUi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 273);
        static final int TRANSACTION_requestActivityRelaunch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 274);
        static final int TRANSACTION_updateDisplayOverrideConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 275);
        static final int TRANSACTION_unregisterTaskStackListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 276);
        static final int TRANSACTION_moveStackToDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 277);
        static final int TRANSACTION_requestAutofillData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 278);
        static final int TRANSACTION_dismissKeyguard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 279);
        static final int TRANSACTION_restartUserInBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 280);
        static final int TRANSACTION_cancelTaskWindowTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 281);
        static final int TRANSACTION_cancelTaskThumbnailTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 282);
        static final int TRANSACTION_getTaskSnapshot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 283);
        static final int TRANSACTION_scheduleApplicationInfoChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 284);
        static final int TRANSACTION_setPersistentVrThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 285);
        static final int TRANSACTION_waitForNetworkStateUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 286);
        static final int TRANSACTION_setDisablePreviewScreenshots = (android.os.IBinder.FIRST_CALL_TRANSACTION + 287);
        static final int TRANSACTION_getLastResumedActivityUserId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 288);
        static final int TRANSACTION_backgroundWhitelistUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 289);
        static final int TRANSACTION_setShowWhenLocked = (android.os.IBinder.FIRST_CALL_TRANSACTION + 290);
        static final int TRANSACTION_setTurnScreenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 291);
    }
// WARNING: when these transactions are updated, check if they are any callers on the native
// side. If so, make sure they are using the correct transaction ids and arguments.
// If a transaction which will also be used on the native side is being inserted, add it to
// below block of transactions.
// Since these transactions are also called from native code, these must be kept in sync with
// the ones in frameworks/native/include/binder/IActivityManager.h
// =============== Beginning of transactions used on native side as well ======================

    public android.os.ParcelFileDescriptor openContentUri(java.lang.String uriString) throws android.os.RemoteException;
// =============== End of transactions used on native side as well ============================
// Special low-level communication with activity manager.

    public void handleApplicationCrash(android.os.IBinder app, android.app.ApplicationErrorReport.ParcelableCrashInfo crashInfo) throws android.os.RemoteException;

    public int startActivity(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options) throws android.os.RemoteException;

    public void unhandledBack() throws android.os.RemoteException;

    public boolean finishActivity(android.os.IBinder token, int code, android.content.Intent data, int finishTask) throws android.os.RemoteException;

    public android.content.Intent registerReceiver(android.app.IApplicationThread caller, java.lang.String callerPackage, android.content.IIntentReceiver receiver, android.content.IntentFilter filter, java.lang.String requiredPermission, int userId, int flags) throws android.os.RemoteException;

    public void unregisterReceiver(android.content.IIntentReceiver receiver) throws android.os.RemoteException;

    public int broadcastIntent(android.app.IApplicationThread caller, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver resultTo, int resultCode, java.lang.String resultData, android.os.Bundle map, java.lang.String[] requiredPermissions, int appOp, android.os.Bundle options, boolean serialized, boolean sticky, int userId) throws android.os.RemoteException;

    public void unbroadcastIntent(android.app.IApplicationThread caller, android.content.Intent intent, int userId) throws android.os.RemoteException;

    public void finishReceiver(android.os.IBinder who, int resultCode, java.lang.String resultData, android.os.Bundle map, boolean abortBroadcast, int flags) throws android.os.RemoteException;

    public void attachApplication(android.app.IApplicationThread app) throws android.os.RemoteException;

    public void activityIdle(android.os.IBinder token, android.content.res.Configuration config, boolean stopProfiling) throws android.os.RemoteException;

    public void activityPaused(android.os.IBinder token) throws android.os.RemoteException;

    public void activityStopped(android.os.IBinder token, android.os.Bundle state, android.os.PersistableBundle persistentState, java.lang.CharSequence description) throws android.os.RemoteException;

    public java.lang.String getCallingPackage(android.os.IBinder token) throws android.os.RemoteException;

    public android.content.ComponentName getCallingActivity(android.os.IBinder token) throws android.os.RemoteException;

    public java.util.List<android.app.ActivityManager.RunningTaskInfo> getTasks(int maxNum, int flags) throws android.os.RemoteException;

    public void moveTaskToFront(int task, int flags, android.os.Bundle options) throws android.os.RemoteException;

    public void moveTaskBackwards(int task) throws android.os.RemoteException;

    public int getTaskForActivity(android.os.IBinder token, boolean onlyRoot) throws android.os.RemoteException;

    public android.app.ContentProviderHolder getContentProvider(android.app.IApplicationThread caller, java.lang.String name, int userId, boolean stable) throws android.os.RemoteException;

    public void publishContentProviders(android.app.IApplicationThread caller, java.util.List<android.app.ContentProviderHolder> providers) throws android.os.RemoteException;

    public boolean refContentProvider(android.os.IBinder connection, int stableDelta, int unstableDelta) throws android.os.RemoteException;

    public void finishSubActivity(android.os.IBinder token, java.lang.String resultWho, int requestCode) throws android.os.RemoteException;

    public android.app.PendingIntent getRunningServiceControlPanel(android.content.ComponentName service) throws android.os.RemoteException;

    public android.content.ComponentName startService(android.app.IApplicationThread caller, android.content.Intent service, java.lang.String resolvedType, boolean requireForeground, java.lang.String callingPackage, int userId) throws android.os.RemoteException;

    public int stopService(android.app.IApplicationThread caller, android.content.Intent service, java.lang.String resolvedType, int userId) throws android.os.RemoteException;

    public int bindService(android.app.IApplicationThread caller, android.os.IBinder token, android.content.Intent service, java.lang.String resolvedType, android.app.IServiceConnection connection, int flags, java.lang.String callingPackage, int userId) throws android.os.RemoteException;

    public boolean unbindService(android.app.IServiceConnection connection) throws android.os.RemoteException;

    public void publishService(android.os.IBinder token, android.content.Intent intent, android.os.IBinder service) throws android.os.RemoteException;

    public void activityResumed(android.os.IBinder token) throws android.os.RemoteException;

    public void setDebugApp(java.lang.String packageName, boolean waitForDebugger, boolean persistent) throws android.os.RemoteException;

    public void setAlwaysFinish(boolean enabled) throws android.os.RemoteException;

    public boolean startInstrumentation(android.content.ComponentName className, java.lang.String profileFile, int flags, android.os.Bundle arguments, android.app.IInstrumentationWatcher watcher, android.app.IUiAutomationConnection connection, int userId, java.lang.String abiOverride) throws android.os.RemoteException;

    public void addInstrumentationResults(android.app.IApplicationThread target, android.os.Bundle results) throws android.os.RemoteException;

    public void finishInstrumentation(android.app.IApplicationThread target, int resultCode, android.os.Bundle results) throws android.os.RemoteException;

    /**
     * @return A copy of global {@link Configuration}, contains general settings for the entire
     * system. Corresponds to the configuration of the default display.
     * @throws RemoteException
     */
    public android.content.res.Configuration getConfiguration() throws android.os.RemoteException;

    /**
     * Updates global configuration and applies changes to the entire system.
     *
     * @param values Update values for global configuration. If null is passed it will request the
     *               Window Manager to compute new config for the default display.
     * @return Returns true if the configuration was updated.
     * @throws RemoteException
     */
    public boolean updateConfiguration(android.content.res.Configuration values) throws android.os.RemoteException;

    public boolean stopServiceToken(android.content.ComponentName className, android.os.IBinder token, int startId) throws android.os.RemoteException;

    public android.content.ComponentName getActivityClassForToken(android.os.IBinder token) throws android.os.RemoteException;

    public java.lang.String getPackageForToken(android.os.IBinder token) throws android.os.RemoteException;

    public void setProcessLimit(int max) throws android.os.RemoteException;

    public int getProcessLimit() throws android.os.RemoteException;

    public int checkPermission(java.lang.String permission, int pid, int uid) throws android.os.RemoteException;

    public int checkUriPermission(android.net.Uri uri, int pid, int uid, int mode, int userId, android.os.IBinder callerToken) throws android.os.RemoteException;

    public void grantUriPermission(android.app.IApplicationThread caller, java.lang.String targetPkg, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException;

    public void revokeUriPermission(android.app.IApplicationThread caller, java.lang.String targetPkg, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException;

    public void setActivityController(android.app.IActivityController watcher, boolean imAMonkey) throws android.os.RemoteException;

    public void showWaitingForDebugger(android.app.IApplicationThread who, boolean waiting) throws android.os.RemoteException;

    /*
     * This will deliver the specified signal to all the persistent processes. Currently only
     * SIGUSR1 is delivered. All others are ignored.
     */
    public void signalPersistentProcesses(int signal) throws android.os.RemoteException;

    public android.content.pm.ParceledListSlice getRecentTasks(int maxNum, int flags, int userId) throws android.os.RemoteException;

    public void serviceDoneExecuting(android.os.IBinder token, int type, int startId, int res) throws android.os.RemoteException;

    public void activityDestroyed(android.os.IBinder token) throws android.os.RemoteException;

    public android.content.IIntentSender getIntentSender(int type, java.lang.String packageName, android.os.IBinder token, java.lang.String resultWho, int requestCode, android.content.Intent[] intents, java.lang.String[] resolvedTypes, int flags, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public void cancelIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException;

    public java.lang.String getPackageForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException;

    public void registerIntentSenderCancelListener(android.content.IIntentSender sender, com.android.internal.os.IResultReceiver receiver) throws android.os.RemoteException;

    public void unregisterIntentSenderCancelListener(android.content.IIntentSender sender, com.android.internal.os.IResultReceiver receiver) throws android.os.RemoteException;

    public void enterSafeMode() throws android.os.RemoteException;

    public boolean startNextMatchingActivity(android.os.IBinder callingActivity, android.content.Intent intent, android.os.Bundle options) throws android.os.RemoteException;

    public void noteWakeupAlarm(android.content.IIntentSender sender, int sourceUid, java.lang.String sourcePkg, java.lang.String tag) throws android.os.RemoteException;

    public void removeContentProvider(android.os.IBinder connection, boolean stable) throws android.os.RemoteException;

    public void setRequestedOrientation(android.os.IBinder token, int requestedOrientation) throws android.os.RemoteException;

    public int getRequestedOrientation(android.os.IBinder token) throws android.os.RemoteException;

    public void unbindFinished(android.os.IBinder token, android.content.Intent service, boolean doRebind) throws android.os.RemoteException;

    public void setProcessImportant(android.os.IBinder token, int pid, boolean isForeground, java.lang.String reason) throws android.os.RemoteException;

    public void setServiceForeground(android.content.ComponentName className, android.os.IBinder token, int id, android.app.Notification notification, int flags) throws android.os.RemoteException;

    public boolean moveActivityTaskToBack(android.os.IBinder token, boolean nonRoot) throws android.os.RemoteException;

    public void getMemoryInfo(android.app.ActivityManager.MemoryInfo outInfo) throws android.os.RemoteException;

    public java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() throws android.os.RemoteException;

    public boolean clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer, int userId) throws android.os.RemoteException;

    public void forceStopPackage(java.lang.String packageName, int userId) throws android.os.RemoteException;

    public boolean killPids(int[] pids, java.lang.String reason, boolean secure) throws android.os.RemoteException;

    public java.util.List<android.app.ActivityManager.RunningServiceInfo> getServices(int maxNum, int flags) throws android.os.RemoteException;

    public android.app.ActivityManager.TaskThumbnail getTaskThumbnail(int taskId) throws android.os.RemoteException;

    public android.app.ActivityManager.TaskDescription getTaskDescription(int taskId) throws android.os.RemoteException;
// Retrieve running application processes in the system

    public java.util.List<android.app.ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() throws android.os.RemoteException;
// Get device configuration

    public android.content.pm.ConfigurationInfo getDeviceConfigurationInfo() throws android.os.RemoteException;

    public android.os.IBinder peekService(android.content.Intent service, java.lang.String resolvedType, java.lang.String callingPackage) throws android.os.RemoteException;
// Turn on/off profiling in a particular process.

    public boolean profileControl(java.lang.String process, int userId, boolean start, android.app.ProfilerInfo profilerInfo, int profileType) throws android.os.RemoteException;

    public boolean shutdown(int timeout) throws android.os.RemoteException;

    public void stopAppSwitches() throws android.os.RemoteException;

    public void resumeAppSwitches() throws android.os.RemoteException;

    public boolean bindBackupAgent(java.lang.String packageName, int backupRestoreMode, int userId) throws android.os.RemoteException;

    public void backupAgentCreated(java.lang.String packageName, android.os.IBinder agent) throws android.os.RemoteException;

    public void unbindBackupAgent(android.content.pm.ApplicationInfo appInfo) throws android.os.RemoteException;

    public int getUidForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException;

    public int handleIncomingUser(int callingPid, int callingUid, int userId, boolean allowAll, boolean requireFull, java.lang.String name, java.lang.String callerPackage) throws android.os.RemoteException;

    public void addPackageDependency(java.lang.String packageName) throws android.os.RemoteException;

    public void killApplication(java.lang.String pkg, int appId, int userId, java.lang.String reason) throws android.os.RemoteException;

    public void closeSystemDialogs(java.lang.String reason) throws android.os.RemoteException;

    public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) throws android.os.RemoteException;

    public void killApplicationProcess(java.lang.String processName, int uid) throws android.os.RemoteException;

    public int startActivityIntentSender(android.app.IApplicationThread caller, android.content.IIntentSender target, android.os.IBinder whitelistToken, android.content.Intent fillInIntent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flagsMask, int flagsValues, android.os.Bundle options) throws android.os.RemoteException;

    public void overridePendingTransition(android.os.IBinder token, java.lang.String packageName, int enterAnim, int exitAnim) throws android.os.RemoteException;
// Special low-level communication with activity manager.

    public boolean handleApplicationWtf(android.os.IBinder app, java.lang.String tag, boolean system, android.app.ApplicationErrorReport.ParcelableCrashInfo crashInfo) throws android.os.RemoteException;

    public void killBackgroundProcesses(java.lang.String packageName, int userId) throws android.os.RemoteException;

    public boolean isUserAMonkey() throws android.os.RemoteException;

    public android.app.WaitResult startActivityAndWait(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public boolean willActivityBeVisible(android.os.IBinder token) throws android.os.RemoteException;

    public int startActivityWithConfig(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int startFlags, android.content.res.Configuration newConfig, android.os.Bundle options, int userId) throws android.os.RemoteException;
// Retrieve info of applications installed on external media that are currently
// running.

    public java.util.List<android.content.pm.ApplicationInfo> getRunningExternalApplications() throws android.os.RemoteException;

    public void finishHeavyWeightApp() throws android.os.RemoteException;
// A StrictMode violation to be handled.  The violationMask is a
// subset of the original StrictMode policy bitmask, with only the
// bit violated and penalty bits to be executed by the
// ActivityManagerService remaining set.

    public void handleApplicationStrictModeViolation(android.os.IBinder app, int violationMask, android.os.StrictMode.ViolationInfo crashInfo) throws android.os.RemoteException;

    public boolean isImmersive(android.os.IBinder token) throws android.os.RemoteException;

    public void setImmersive(android.os.IBinder token, boolean immersive) throws android.os.RemoteException;

    public boolean isTopActivityImmersive() throws android.os.RemoteException;

    public void crashApplication(int uid, int initialPid, java.lang.String packageName, int userId, java.lang.String message) throws android.os.RemoteException;

    public java.lang.String getProviderMimeType(android.net.Uri uri, int userId) throws android.os.RemoteException;

    public android.os.IBinder newUriPermissionOwner(java.lang.String name) throws android.os.RemoteException;

    public void grantUriPermissionFromOwner(android.os.IBinder owner, int fromUid, java.lang.String targetPkg, android.net.Uri uri, int mode, int sourceUserId, int targetUserId) throws android.os.RemoteException;

    public void revokeUriPermissionFromOwner(android.os.IBinder owner, android.net.Uri uri, int mode, int userId) throws android.os.RemoteException;

    public int checkGrantUriPermission(int callingUid, java.lang.String targetPkg, android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException;
// Cause the specified process to dump the specified heap.

    public boolean dumpHeap(java.lang.String process, int userId, boolean managed, boolean mallocInfo, boolean runGc, java.lang.String path, android.os.ParcelFileDescriptor fd) throws android.os.RemoteException;

    public int startActivities(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent[] intents, java.lang.String[] resolvedTypes, android.os.IBinder resultTo, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public boolean isUserRunning(int userid, int flags) throws android.os.RemoteException;

    public void activitySlept(android.os.IBinder token) throws android.os.RemoteException;

    public int getFrontActivityScreenCompatMode() throws android.os.RemoteException;

    public void setFrontActivityScreenCompatMode(int mode) throws android.os.RemoteException;

    public int getPackageScreenCompatMode(java.lang.String packageName) throws android.os.RemoteException;

    public void setPackageScreenCompatMode(java.lang.String packageName, int mode) throws android.os.RemoteException;

    public boolean getPackageAskScreenCompat(java.lang.String packageName) throws android.os.RemoteException;

    public void setPackageAskScreenCompat(java.lang.String packageName, boolean ask) throws android.os.RemoteException;

    public boolean switchUser(int userid) throws android.os.RemoteException;

    public void setFocusedTask(int taskId) throws android.os.RemoteException;

    public boolean removeTask(int taskId) throws android.os.RemoteException;

    public void registerProcessObserver(android.app.IProcessObserver observer) throws android.os.RemoteException;

    public void unregisterProcessObserver(android.app.IProcessObserver observer) throws android.os.RemoteException;

    public boolean isIntentSenderTargetedToPackage(android.content.IIntentSender sender) throws android.os.RemoteException;

    public void updatePersistentConfiguration(android.content.res.Configuration values) throws android.os.RemoteException;

    public long[] getProcessPss(int[] pids) throws android.os.RemoteException;

    public void showBootMessage(java.lang.CharSequence msg, boolean always) throws android.os.RemoteException;

    public void killAllBackgroundProcesses() throws android.os.RemoteException;

    public android.app.ContentProviderHolder getContentProviderExternal(java.lang.String name, int userId, android.os.IBinder token) throws android.os.RemoteException;

    public void removeContentProviderExternal(java.lang.String name, android.os.IBinder token) throws android.os.RemoteException;
// Get memory information about the calling process.

    public void getMyMemoryState(android.app.ActivityManager.RunningAppProcessInfo outInfo) throws android.os.RemoteException;

    public boolean killProcessesBelowForeground(java.lang.String reason) throws android.os.RemoteException;

    public android.content.pm.UserInfo getCurrentUser() throws android.os.RemoteException;

    public boolean shouldUpRecreateTask(android.os.IBinder token, java.lang.String destAffinity) throws android.os.RemoteException;

    public boolean navigateUpTo(android.os.IBinder token, android.content.Intent target, int resultCode, android.content.Intent resultData) throws android.os.RemoteException;

    /**
     * Informs ActivityManagerService that the keyguard is showing.
     *
     * @param showing                 True if the keyguard is showing, false otherwise.
     * @param secondaryDisplayShowing The displayId of the secondary display on which the keyguard
     *                                is showing, or INVALID_DISPLAY if there is no such display. Only meaningful if
     *                                showing is true.
     */
    public void setLockScreenShown(boolean showing, int secondaryDisplayShowing) throws android.os.RemoteException;

    public boolean finishActivityAffinity(android.os.IBinder token) throws android.os.RemoteException;

    public int getLaunchedFromUid(android.os.IBinder activityToken) throws android.os.RemoteException;

    public void unstableProviderDied(android.os.IBinder connection) throws android.os.RemoteException;

    public boolean isIntentSenderAnActivity(android.content.IIntentSender sender) throws android.os.RemoteException;

    public int startActivityAsUser(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public int stopUser(int userid, boolean force, android.app.IStopUserCallback callback) throws android.os.RemoteException;

    public void registerUserSwitchObserver(android.app.IUserSwitchObserver observer, java.lang.String name) throws android.os.RemoteException;

    public void unregisterUserSwitchObserver(android.app.IUserSwitchObserver observer) throws android.os.RemoteException;

    public int[] getRunningUserIds() throws android.os.RemoteException;
// Deprecated - This method is only used by a few internal components and it will soon be
// replaced by a proper bug report API (which will be restricted to a few, pre-defined apps).
// No new code should be calling it.

    public void requestBugReport(int bugreportType) throws android.os.RemoteException;

    /**
     * Takes a telephony bug report and notifies the user with the title and description
     * that are passed to this API as parameters
     *
     * @param shareTitle       should be a valid legible string less than 50 chars long
     * @param shareDescription should be less than 91 bytes when encoded into UTF-8 format
     * @throws IllegalArgumentException if shareTitle or shareDescription is too big or if the
     *                                  paremeters cannot be encoding to an UTF-8 charset.
     */
    public void requestTelephonyBugReport(java.lang.String shareTitle, java.lang.String shareDescription) throws android.os.RemoteException;

    public long inputDispatchingTimedOut(int pid, boolean aboveSystem, java.lang.String reason) throws android.os.RemoteException;

    public void clearPendingBackup() throws android.os.RemoteException;

    public android.content.Intent getIntentForIntentSender(android.content.IIntentSender sender) throws android.os.RemoteException;

    public android.os.Bundle getAssistContextExtras(int requestType) throws android.os.RemoteException;

    public void reportAssistContextExtras(android.os.IBinder token, android.os.Bundle extras, android.app.assist.AssistStructure structure, android.app.assist.AssistContent content, android.net.Uri referrer) throws android.os.RemoteException;

    public java.lang.String getLaunchedFromPackage(android.os.IBinder activityToken) throws android.os.RemoteException;

    public void killUid(int appId, int userId, java.lang.String reason) throws android.os.RemoteException;

    public void setUserIsMonkey(boolean monkey) throws android.os.RemoteException;

    public void hang(android.os.IBinder who, boolean allowRestart) throws android.os.RemoteException;

    public void moveTaskToStack(int taskId, int stackId, boolean toTop) throws android.os.RemoteException;

    /**
     * Resizes the input stack id to the given bounds.
     *
     * @param stackId                 Id of the stack to resize.
     * @param bounds                  Bounds to resize the stack to or {@code null} for fullscreen.
     * @param allowResizeInDockedMode True if the resize should be allowed when the docked stack is
     *                                active.
     * @param preserveWindows         True if the windows of activities contained in the stack should be
     *                                preserved.
     * @param animate                 True if the stack resize should be animated.
     * @param animationDuration       The duration of the resize animation in milliseconds or -1 if the
     *                                default animation duration should be used.
     * @throws RemoteException
     */
    public void resizeStack(int stackId, android.graphics.Rect bounds, boolean allowResizeInDockedMode, boolean preserveWindows, boolean animate, int animationDuration) throws android.os.RemoteException;

    public java.util.List<android.app.ActivityManager.StackInfo> getAllStackInfos() throws android.os.RemoteException;

    public void setFocusedStack(int stackId) throws android.os.RemoteException;

    public android.app.ActivityManager.StackInfo getStackInfo(int stackId) throws android.os.RemoteException;

    public boolean convertFromTranslucent(android.os.IBinder token) throws android.os.RemoteException;

    public boolean convertToTranslucent(android.os.IBinder token, android.os.Bundle options) throws android.os.RemoteException;

    public void notifyActivityDrawn(android.os.IBinder token) throws android.os.RemoteException;

    public void reportActivityFullyDrawn(android.os.IBinder token, boolean restoredFromBundle) throws android.os.RemoteException;

    public void restart() throws android.os.RemoteException;

    public void performIdleMaintenance() throws android.os.RemoteException;

    public void takePersistableUriPermission(android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException;

    public void releasePersistableUriPermission(android.net.Uri uri, int modeFlags, int userId) throws android.os.RemoteException;

    public android.content.pm.ParceledListSlice getPersistedUriPermissions(java.lang.String packageName, boolean incoming) throws android.os.RemoteException;

    public void appNotRespondingViaProvider(android.os.IBinder connection) throws android.os.RemoteException;

    public android.graphics.Rect getTaskBounds(int taskId) throws android.os.RemoteException;

    public int getActivityDisplayId(android.os.IBinder activityToken) throws android.os.RemoteException;

    public boolean setProcessMemoryTrimLevel(java.lang.String process, int uid, int level) throws android.os.RemoteException;

    public java.lang.String getTagForIntentSender(android.content.IIntentSender sender, java.lang.String prefix) throws android.os.RemoteException;

    public boolean startUserInBackground(int userid) throws android.os.RemoteException;

    public void startLockTaskModeById(int taskId) throws android.os.RemoteException;

    public void startLockTaskModeByToken(android.os.IBinder token) throws android.os.RemoteException;

    public void stopLockTaskMode() throws android.os.RemoteException;

    public boolean isInLockTaskMode() throws android.os.RemoteException;

    public void setTaskDescription(android.os.IBinder token, android.app.ActivityManager.TaskDescription values) throws android.os.RemoteException;

    public int startVoiceActivity(java.lang.String callingPackage, int callingPid, int callingUid, android.content.Intent intent, java.lang.String resolvedType, android.service.voice.IVoiceInteractionSession session, com.android.internal.app.IVoiceInteractor interactor, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public int startAssistantActivity(java.lang.String callingPackage, int callingPid, int callingUid, android.content.Intent intent, java.lang.String resolvedType, android.os.Bundle options, int userId) throws android.os.RemoteException;

    public android.os.Bundle getActivityOptions(android.os.IBinder token) throws android.os.RemoteException;

    public java.util.List<android.os.IBinder> getAppTasks(java.lang.String callingPackage) throws android.os.RemoteException;

    public void startSystemLockTaskMode(int taskId) throws android.os.RemoteException;

    public void stopSystemLockTaskMode() throws android.os.RemoteException;

    public void finishVoiceTask(android.service.voice.IVoiceInteractionSession session) throws android.os.RemoteException;

    public boolean isTopOfTask(android.os.IBinder token) throws android.os.RemoteException;

    public void notifyLaunchTaskBehindComplete(android.os.IBinder token) throws android.os.RemoteException;

    public int startActivityFromRecents(int taskId, android.os.Bundle options) throws android.os.RemoteException;

    public void notifyEnterAnimationComplete(android.os.IBinder token) throws android.os.RemoteException;

    public int startActivityAsCaller(android.app.IApplicationThread caller, java.lang.String callingPackage, android.content.Intent intent, java.lang.String resolvedType, android.os.IBinder resultTo, java.lang.String resultWho, int requestCode, int flags, android.app.ProfilerInfo profilerInfo, android.os.Bundle options, boolean ignoreTargetSecurity, int userId) throws android.os.RemoteException;

    public int addAppTask(android.os.IBinder activityToken, android.content.Intent intent, android.app.ActivityManager.TaskDescription description, android.graphics.Bitmap thumbnail) throws android.os.RemoteException;

    public android.graphics.Point getAppTaskThumbnailSize() throws android.os.RemoteException;

    public boolean releaseActivityInstance(android.os.IBinder token) throws android.os.RemoteException;

    public void releaseSomeActivities(android.app.IApplicationThread app) throws android.os.RemoteException;

    public void bootAnimationComplete() throws android.os.RemoteException;

    public android.graphics.Bitmap getTaskDescriptionIcon(java.lang.String filename, int userId) throws android.os.RemoteException;

    public boolean launchAssistIntent(android.content.Intent intent, int requestType, java.lang.String hint, int userHandle, android.os.Bundle args) throws android.os.RemoteException;

    public void startInPlaceAnimationOnFrontMostApplication(android.os.Bundle opts) throws android.os.RemoteException;

    public int checkPermissionWithToken(java.lang.String permission, int pid, int uid, android.os.IBinder callerToken) throws android.os.RemoteException;

    public void registerTaskStackListener(android.app.ITaskStackListener listener) throws android.os.RemoteException;
// Start of M transactions

    public void notifyCleartextNetwork(int uid, byte[] firstPacket) throws android.os.RemoteException;

    public int createStackOnDisplay(int displayId) throws android.os.RemoteException;

    public int getFocusedStackId() throws android.os.RemoteException;

    public void setTaskResizeable(int taskId, int resizeableMode) throws android.os.RemoteException;

    public boolean requestAssistContextExtras(int requestType, com.android.internal.os.IResultReceiver receiver, android.os.Bundle receiverExtras, android.os.IBinder activityToken, boolean focused, boolean newSessionId) throws android.os.RemoteException;

    public void resizeTask(int taskId, android.graphics.Rect bounds, int resizeMode) throws android.os.RemoteException;

    public int getLockTaskModeState() throws android.os.RemoteException;

    public void setDumpHeapDebugLimit(java.lang.String processName, int uid, long maxMemSize, java.lang.String reportPackage) throws android.os.RemoteException;

    public void dumpHeapFinished(java.lang.String path) throws android.os.RemoteException;

    public void setVoiceKeepAwake(android.service.voice.IVoiceInteractionSession session, boolean keepAwake) throws android.os.RemoteException;

    public void updateLockTaskPackages(int userId, java.lang.String[] packages) throws android.os.RemoteException;

    public void noteAlarmStart(android.content.IIntentSender sender, int sourceUid, java.lang.String tag) throws android.os.RemoteException;

    public void noteAlarmFinish(android.content.IIntentSender sender, int sourceUid, java.lang.String tag) throws android.os.RemoteException;

    public int getPackageProcessState(java.lang.String packageName, java.lang.String callingPackage) throws android.os.RemoteException;

    public void showLockTaskEscapeMessage(android.os.IBinder token) throws android.os.RemoteException;

    public void updateDeviceOwner(java.lang.String packageName) throws android.os.RemoteException;

    /**
     * Notify the system that the keyguard is going away.
     *
     * @param flags See {@link android.view.WindowManagerPolicy#KEYGUARD_GOING_AWAY_FLAG_TO_SHADE}
     *              etc.
     */
    public void keyguardGoingAway(int flags) throws android.os.RemoteException;

    public int getUidProcessState(int uid, java.lang.String callingPackage) throws android.os.RemoteException;

    public void registerUidObserver(android.app.IUidObserver observer, int which, int cutpoint, java.lang.String callingPackage) throws android.os.RemoteException;

    public void unregisterUidObserver(android.app.IUidObserver observer) throws android.os.RemoteException;

    public boolean isAssistDataAllowedOnCurrentActivity() throws android.os.RemoteException;

    public boolean showAssistFromActivity(android.os.IBinder token, android.os.Bundle args) throws android.os.RemoteException;

    public boolean isRootVoiceInteraction(android.os.IBinder token) throws android.os.RemoteException;
// Start of N transactions
// Start Binder transaction tracking for all applications.

    public boolean startBinderTracking() throws android.os.RemoteException;
// Stop Binder transaction tracking for all applications and dump trace data to the given file
// descriptor.

    public boolean stopBinderTrackingAndDump(android.os.ParcelFileDescriptor fd) throws android.os.RemoteException;

    /**
     * Try to place task to provided position. The final position might be different depending on
     * current user and stacks state. The task will be moved to target stack if it's currently in
     * different stack.
     */
    public void positionTaskInStack(int taskId, int stackId, int position) throws android.os.RemoteException;

    public int getActivityStackId(android.os.IBinder token) throws android.os.RemoteException;

    public void exitFreeformMode(android.os.IBinder token) throws android.os.RemoteException;

    public void reportSizeConfigurations(android.os.IBinder token, int[] horizontalSizeConfiguration, int[] verticalSizeConfigurations, int[] smallestWidthConfigurations) throws android.os.RemoteException;

    public boolean moveTaskToDockedStack(int taskId, int createMode, boolean toTop, boolean animate, android.graphics.Rect initialBounds) throws android.os.RemoteException;

    public void suppressResizeConfigChanges(boolean suppress) throws android.os.RemoteException;

    public void moveTasksToFullscreenStack(int fromStackId, boolean onTop) throws android.os.RemoteException;

    public boolean moveTopActivityToPinnedStack(int stackId, android.graphics.Rect bounds) throws android.os.RemoteException;

    public boolean isAppStartModeDisabled(int uid, java.lang.String packageName) throws android.os.RemoteException;

    public boolean unlockUser(int userid, byte[] token, byte[] secret, android.os.IProgressListener listener) throws android.os.RemoteException;

    public boolean isInMultiWindowMode(android.os.IBinder token) throws android.os.RemoteException;

    public boolean isInPictureInPictureMode(android.os.IBinder token) throws android.os.RemoteException;

    public void killPackageDependents(java.lang.String packageName, int userId) throws android.os.RemoteException;

    public boolean enterPictureInPictureMode(android.os.IBinder token, android.app.PictureInPictureParams params) throws android.os.RemoteException;

    public void setPictureInPictureParams(android.os.IBinder token, android.app.PictureInPictureParams params) throws android.os.RemoteException;

    public int getMaxNumPictureInPictureActions(android.os.IBinder token) throws android.os.RemoteException;

    public void activityRelaunched(android.os.IBinder token) throws android.os.RemoteException;

    public android.os.IBinder getUriPermissionOwnerForActivity(android.os.IBinder activityToken) throws android.os.RemoteException;

    /**
     * Resizes the docked stack, and all other stacks as the result of the dock stack bounds change.
     *
     * @param dockedBounds              The bounds for the docked stack.
     * @param tempDockedTaskBounds      The temporary bounds for the tasks in the docked stack, which
     *                                  might be different from the stack bounds to allow more
     *                                  flexibility while resizing, or {@code null} if they should be the
     *                                  same as the stack bounds.
     * @param tempDockedTaskInsetBounds The temporary bounds for the tasks to calculate the insets.
     *                                  When resizing, we usually "freeze" the layout of a task. To
     *                                  achieve that, we also need to "freeze" the insets, which
     *                                  gets achieved by changing task bounds but not bounds used
     *                                  to calculate the insets in this transient state
     * @param tempOtherTaskBounds       The temporary bounds for the tasks in all other stacks, or
     *                                  {@code null} if they should be the same as the stack bounds.
     * @param tempOtherTaskInsetBounds  Like {@code tempDockedTaskInsetBounds}, but for the other
     *                                  stacks.
     * @throws RemoteException
     */
    public void resizeDockedStack(android.graphics.Rect dockedBounds, android.graphics.Rect tempDockedTaskBounds, android.graphics.Rect tempDockedTaskInsetBounds, android.graphics.Rect tempOtherTaskBounds, android.graphics.Rect tempOtherTaskInsetBounds) throws android.os.RemoteException;

    public int setVrMode(android.os.IBinder token, boolean enabled, android.content.ComponentName packageName) throws android.os.RemoteException;
// Gets the URI permissions granted to an arbitrary package.
// NOTE: this is different from getPersistedUriPermissions(), which returns the URIs the package
// granted to another packages (instead of those granted to it).

    public android.content.pm.ParceledListSlice getGrantedUriPermissions(java.lang.String packageName, int userId) throws android.os.RemoteException;
// Clears the URI permissions granted to an arbitrary package.

    public void clearGrantedUriPermissions(java.lang.String packageName, int userId) throws android.os.RemoteException;

    public boolean isAppForeground(int uid) throws android.os.RemoteException;

    public void startLocalVoiceInteraction(android.os.IBinder token, android.os.Bundle options) throws android.os.RemoteException;

    public void stopLocalVoiceInteraction(android.os.IBinder token) throws android.os.RemoteException;

    public boolean supportsLocalVoiceInteraction() throws android.os.RemoteException;

    public void notifyPinnedStackAnimationStarted() throws android.os.RemoteException;

    public void notifyPinnedStackAnimationEnded() throws android.os.RemoteException;

    public void removeStack(int stackId) throws android.os.RemoteException;

    public void makePackageIdle(java.lang.String packageName, int userId) throws android.os.RemoteException;

    public int getMemoryTrimLevel() throws android.os.RemoteException;

    /**
     * Resizes the pinned stack.
     *
     * @param pinnedBounds         The bounds for the pinned stack.
     * @param tempPinnedTaskBounds The temporary bounds for the tasks in the pinned stack, which
     *                             might be different from the stack bounds to allow more
     *                             flexibility while resizing, or {@code null} if they should be the
     *                             same as the stack bounds.
     */
    public void resizePinnedStack(android.graphics.Rect pinnedBounds, android.graphics.Rect tempPinnedTaskBounds) throws android.os.RemoteException;

    public boolean isVrModePackageEnabled(android.content.ComponentName packageName) throws android.os.RemoteException;

    /**
     * Moves all tasks from the docked stack in the fullscreen stack and puts the top task of the
     * fullscreen stack into the docked stack.
     */
    public void swapDockedAndFullscreenStack() throws android.os.RemoteException;

    public void notifyLockedProfile(int userId) throws android.os.RemoteException;

    public void startConfirmDeviceCredentialIntent(android.content.Intent intent, android.os.Bundle options) throws android.os.RemoteException;

    public void sendIdleJobTrigger() throws android.os.RemoteException;

    public int sendIntentSender(android.content.IIntentSender target, android.os.IBinder whitelistToken, int code, android.content.Intent intent, java.lang.String resolvedType, android.content.IIntentReceiver finishedReceiver, java.lang.String requiredPermission, android.os.Bundle options) throws android.os.RemoteException;
// Start of N MR1 transactions

    public void setVrThread(int tid) throws android.os.RemoteException;

    public void setRenderThread(int tid) throws android.os.RemoteException;

    /**
     * Lets activity manager know whether the calling process is currently showing "top-level" UI
     * that is not an activity, i.e. windows on the screen the user is currently interacting with.
     *
     * <p>This flag can only be set for persistent processes.
     *
     * @param hasTopUi Whether the calling process has "top-level" UI.
     */
    public void setHasTopUi(boolean hasTopUi) throws android.os.RemoteException;
// Start of O transactions

    public void requestActivityRelaunch(android.os.IBinder token) throws android.os.RemoteException;

    /**
     * Updates override configuration applied to specific display.
     *
     * @param values    Update values for display configuration. If null is passed it will request the
     *                  Window Manager to compute new config for the specified display.
     * @param displayId Id of the display to apply the config to.
     * @return Returns true if the configuration was updated.
     * @throws RemoteException
     */
    public boolean updateDisplayOverrideConfiguration(android.content.res.Configuration values, int displayId) throws android.os.RemoteException;

    public void unregisterTaskStackListener(android.app.ITaskStackListener listener) throws android.os.RemoteException;

    public void moveStackToDisplay(int stackId, int displayId) throws android.os.RemoteException;

    public boolean requestAutofillData(com.android.internal.os.IResultReceiver receiver, android.os.Bundle receiverExtras, android.os.IBinder activityToken, int flags) throws android.os.RemoteException;

    public void dismissKeyguard(android.os.IBinder token, com.android.internal.policy.IKeyguardDismissCallback callback) throws android.os.RemoteException;

    public int restartUserInBackground(int userId) throws android.os.RemoteException;

    /**
     * Cancels the window transitions for the given task.
     */
    public void cancelTaskWindowTransition(int taskId) throws android.os.RemoteException;

    /**
     * Cancels the thumbnail transitions for the given task.
     */
    public void cancelTaskThumbnailTransition(int taskId) throws android.os.RemoteException;

    /**
     * @param taskId            the id of the task to retrieve the sAutoapshots for
     * @param reducedResolution if set, if the snapshot needs to be loaded from disk, this will load
     *                          a reduced resolution of it, which is much faster
     * @return a graphic buffer representing a screenshot of a task
     */
    public android.app.ActivityManager.TaskSnapshot getTaskSnapshot(int taskId, boolean reducedResolution) throws android.os.RemoteException;

    public void scheduleApplicationInfoChanged(java.util.List<java.lang.String> packageNames, int userId) throws android.os.RemoteException;

    public void setPersistentVrThread(int tid) throws android.os.RemoteException;

    public void waitForNetworkStateUpdate(long procStateSeq) throws android.os.RemoteException;

    /**
     * See {@link android.app.Activity#setDisablePreviewScreenshots}
     */
    public void setDisablePreviewScreenshots(android.os.IBinder token, boolean disable) throws android.os.RemoteException;

    public int getLastResumedActivityUserId() throws android.os.RemoteException;

    /**
     * Add a bare uid to the background restrictions whitelist.  Only the system uid may call this.
     */
    public void backgroundWhitelistUid(int uid) throws android.os.RemoteException;
// WARNING: when these transactions are updated, check if they are any callers on the native
// side. If so, make sure they are using the correct transaction ids and arguments.
// If a transaction which will also be used on the native side is being inserted, add it
// alongside with other transactions of this kind at the top of this file.

    public void setShowWhenLocked(android.os.IBinder token, boolean showWhenLocked) throws android.os.RemoteException;

    public void setTurnScreenOn(android.os.IBinder token, boolean turnScreenOn) throws android.os.RemoteException;
}
