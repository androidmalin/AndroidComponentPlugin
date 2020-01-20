/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.content;

/**
 * Programming interface to the clipboard, which allows copying and pasting
 * between applications.
 * {@hide}
 */
public interface IClipboard extends android.os.IInterface {
    /**
     * Default implementation for IClipboard.
     */
    class Default implements android.content.IClipboard {
        @Override
        public void setPrimaryClip(ClipData clip, String callingPackage, int userId) throws android.os.RemoteException {
        }

        @Override
        public void clearPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException {
        }

        @Override
        public ClipData getPrimaryClip(String pkg, int userId) throws android.os.RemoteException {
            return null;
        }

        @Override
        public ClipDescription getPrimaryClipDescription(String callingPackage, int userId) throws android.os.RemoteException {
            return null;
        }

        @Override
        public boolean hasPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException {
            return false;
        }

        @Override
        public void addPrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException {
        }

        @Override
        public void removePrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException {
        }

        /**
         * Returns true if the clipboard contains text; false otherwise.
         */
        @Override
        public boolean hasClipboardText(String callingPackage, int userId) throws android.os.RemoteException {
            return false;
        }

        @Override
        public android.os.IBinder asBinder() {
            return null;
        }
    }

    /**
     * Local-side IPC implementation stub class.
     */
    abstract class Stub extends android.os.Binder implements android.content.IClipboard {
        private static final String DESCRIPTOR = "android.content.IClipboard";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an android.content.IClipboard interface,
         * generating a proxy if needed.
         */
        @SuppressWarnings("unused")
        public static android.content.IClipboard asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin instanceof IClipboard))) {
                return ((android.content.IClipboard) iin);
            }
            return new android.content.IClipboard.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_setPrimaryClip: {
                    data.enforceInterface(descriptor);
                    ClipData _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = ClipData.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.setPrimaryClip(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_clearPrimaryClip: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.clearPrimaryClip(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getPrimaryClip: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    ClipData _result = this.getPrimaryClip(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getPrimaryClipDescription: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    ClipDescription _result = this.getPrimaryClipDescription(_arg0, _arg1);
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_hasPrimaryClip: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.hasPrimaryClip(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                case TRANSACTION_addPrimaryClipChangedListener: {
                    data.enforceInterface(descriptor);
                    android.content.IOnPrimaryClipChangedListener _arg0;
                    _arg0 = android.content.IOnPrimaryClipChangedListener.Stub.asInterface(data.readStrongBinder());
                    String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.addPrimaryClipChangedListener(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removePrimaryClipChangedListener: {
                    data.enforceInterface(descriptor);
                    android.content.IOnPrimaryClipChangedListener _arg0;
                    _arg0 = android.content.IOnPrimaryClipChangedListener.Stub.asInterface(data.readStrongBinder());
                    String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    this.removePrimaryClipChangedListener(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_hasClipboardText: {
                    data.enforceInterface(descriptor);
                    String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    boolean _result = this.hasClipboardText(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(((_result) ? (1) : (0)));
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        private static class Proxy implements android.content.IClipboard {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            @SuppressWarnings("unused")
            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void setPrimaryClip(ClipData clip, String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((clip != null)) {
                        _data.writeInt(1);
                        clip.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_setPrimaryClip, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setPrimaryClip(clip, callingPackage, userId);
                        return;
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void clearPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_clearPrimaryClip, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().clearPrimaryClip(callingPackage, userId);
                        return;
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public ClipData getPrimaryClip(String pkg, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                ClipData _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPrimaryClip, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getPrimaryClip(pkg, userId);
                    }
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = ClipData.CREATOR.createFromParcel(_reply);
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
            public ClipDescription getPrimaryClipDescription(String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                ClipDescription _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getPrimaryClipDescription, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getPrimaryClipDescription(callingPackage, userId);
                    }
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = ClipDescription.CREATOR.createFromParcel(_reply);
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
            public boolean hasPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_hasPrimaryClip, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().hasPrimaryClip(callingPackage, userId);
                    }
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addPrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_addPrimaryClipChangedListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().addPrimaryClipChangedListener(listener, callingPackage, userId);
                        return;
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removePrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_removePrimaryClipChangedListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().removePrimaryClipChangedListener(listener, callingPackage, userId);
                        return;
                    }
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /**
             * Returns true if the clipboard contains text; false otherwise.
             */
            @Override
            public boolean hasClipboardText(String callingPackage, int userId) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                boolean _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(callingPackage);
                    _data.writeInt(userId);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_hasClipboardText, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().hasClipboardText(callingPackage, userId);
                    }
                    _reply.readException();
                    _result = (0 != _reply.readInt());
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            public static android.content.IClipboard sDefaultImpl;
        }

        static final int TRANSACTION_setPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_clearPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_getPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_getPrimaryClipDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_hasPrimaryClip = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_addPrimaryClipChangedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_removePrimaryClipChangedListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_hasClipboardText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);

        public static boolean setDefaultImpl(android.content.IClipboard impl) {
            if (Stub.Proxy.sDefaultImpl == null && impl != null) {
                Stub.Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static android.content.IClipboard getDefaultImpl() {
            return Stub.Proxy.sDefaultImpl;
        }
    }

    void setPrimaryClip(ClipData clip, String callingPackage, int userId) throws android.os.RemoteException;

    void clearPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException;

    ClipData getPrimaryClip(String pkg, int userId) throws android.os.RemoteException;

    ClipDescription getPrimaryClipDescription(String callingPackage, int userId) throws android.os.RemoteException;

    boolean hasPrimaryClip(String callingPackage, int userId) throws android.os.RemoteException;

    void addPrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException;

    void removePrimaryClipChangedListener(android.content.IOnPrimaryClipChangedListener listener, String callingPackage, int userId) throws android.os.RemoteException;

    /**
     * Returns true if the clipboard contains text; false otherwise.
     */
    boolean hasClipboardText(String callingPackage, int userId) throws android.os.RemoteException;
}
