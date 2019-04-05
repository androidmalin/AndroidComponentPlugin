/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: frameworks/base/core/java/android/content/pm/IPackageManager.aidl
 */
package android.content.pm;
/**
 *  See {@link PackageManager} for documentation on most of the APIs
 *  here.
 *
 *  {@hide}
 */
public interface IPackageManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements android.content.pm.IPackageManager
{
private static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an android.content.pm.IPackageManager interface,
 * generating a proxy if needed.
 */
public static android.content.pm.IPackageManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.content.pm.IPackageManager))) {
return ((android.content.pm.IPackageManager)iin);
}
return new android.content.pm.IPackageManager.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_checkPackageStartable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.checkPackageStartable(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_isPackageAvailable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.isPackageAvailable(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPackageInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.PackageInfo _result = this.getPackageInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPackageInfoVersioned:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.VersionedPackage _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.VersionedPackage.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.PackageInfo _result = this.getPackageInfoVersioned(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPackageUid:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _result = this.getPackageUid(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPackageGids:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int[] _result = this.getPackageGids(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_currentToCanonicalPackageNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
java.lang.String[] _result = this.currentToCanonicalPackageNames(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_canonicalToCurrentPackageNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
java.lang.String[] _result = this.canonicalToCurrentPackageNames(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getPermissionInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.pm.PermissionInfo _result = this.getPermissionInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryPermissionsByGroup:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryPermissionsByGroup(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPermissionGroupInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.PermissionGroupInfo _result = this.getPermissionGroupInfo(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getAllPermissionGroups:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getAllPermissionGroups(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getApplicationInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ApplicationInfo _result = this.getApplicationInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getActivityInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ActivityInfo _result = this.getActivityInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_activitySupportsIntent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.Intent _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.activitySupportsIntent(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getReceiverInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ActivityInfo _result = this.getReceiverInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getServiceInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ServiceInfo _result = this.getServiceInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getProviderInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ProviderInfo _result = this.getProviderInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_checkPermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _result = this.checkPermission(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_checkUidPermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.checkUidPermission(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_addPermission:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PermissionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PermissionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.addPermission(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_removePermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.removePermission(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_grantRuntimePermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.grantRuntimePermission(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_revokeRuntimePermission:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
this.revokeRuntimePermission(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_resetRuntimePermissions:
{
data.enforceInterface(DESCRIPTOR);
this.resetRuntimePermissions();
reply.writeNoException();
return true;
}
case TRANSACTION_getPermissionFlags:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _result = this.getPermissionFlags(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_updatePermissionFlags:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
this.updatePermissionFlags(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_updatePermissionFlagsForAllApps:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.updatePermissionFlagsForAllApps(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_shouldShowRequestPermissionRationale:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.shouldShowRequestPermissionRationale(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isProtectedBroadcast:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isProtectedBroadcast(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_checkSignatures:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.checkSignatures(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_checkUidSignatures:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.checkUidSignatures(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getAllPackages:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<java.lang.String> _result = this.getAllPackages();
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_getPackagesForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String[] _result = this.getPackagesForUid(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getNameForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.getNameForUid(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getNamesForUids:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
java.lang.String[] _result = this.getNamesForUids(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getUidForSharedUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.getUidForSharedUser(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getFlagsForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getFlagsForUid(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPrivateFlagsForUid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getPrivateFlagsForUid(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isUidPrivileged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.isUidPrivileged(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAppOpPermissionPackages:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String[] _result = this.getAppOpPermissionPackages(_arg0);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_resolveIntent:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ResolveInfo _result = this.resolveIntent(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_findPersistentPreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.ResolveInfo _result = this.findPersistentPreferredActivity(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_canForwardTo:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
boolean _result = this.canForwardTo(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_queryIntentActivities:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryIntentActivities(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryIntentActivityOptions:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.Intent[] _arg1;
_arg1 = data.createTypedArray(android.content.Intent.CREATOR);
java.lang.String[] _arg2;
_arg2 = data.createStringArray();
android.content.Intent _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
java.lang.String _arg4;
_arg4 = data.readString();
int _arg5;
_arg5 = data.readInt();
int _arg6;
_arg6 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryIntentActivityOptions(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryIntentReceivers:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryIntentReceivers(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_resolveService:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ResolveInfo _result = this.resolveService(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryIntentServices:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryIntentServices(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryIntentContentProviders:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryIntentContentProviders(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstalledPackages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getInstalledPackages(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPackagesHoldingPermissions:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getPackagesHoldingPermissions(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstalledApplications:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getInstalledApplications(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getPersistentApplications:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getPersistentApplications(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_resolveContentProvider:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ProviderInfo _result = this.resolveContentProvider(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_querySyncProviders:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<java.lang.String> _arg0;
_arg0 = data.createStringArrayList();
java.util.List<android.content.pm.ProviderInfo> _arg1;
_arg1 = data.createTypedArrayList(android.content.pm.ProviderInfo.CREATOR);
this.querySyncProviders(_arg0, _arg1);
reply.writeNoException();
reply.writeStringList(_arg0);
reply.writeTypedList(_arg1);
return true;
}
case TRANSACTION_queryContentProviders:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
android.content.pm.ParceledListSlice _result = this.queryContentProviders(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstrumentationInfo:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.pm.InstrumentationInfo _result = this.getInstrumentationInfo(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_queryInstrumentation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ParceledListSlice _result = this.queryInstrumentation(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_installPackageAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageInstallObserver2 _arg1;
_arg1 = android.content.pm.IPackageInstallObserver2.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
this.installPackageAsUser(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_finishPackageInstall:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.finishPackageInstall(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setInstallerPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.setInstallerPackageName(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setApplicationCategoryHint:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.setApplicationCategoryHint(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_deletePackageAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.IPackageDeleteObserver _arg2;
_arg2 = android.content.pm.IPackageDeleteObserver.Stub.asInterface(data.readStrongBinder());
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
this.deletePackageAsUser(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_deletePackageVersioned:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.VersionedPackage _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.VersionedPackage.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.pm.IPackageDeleteObserver2 _arg1;
_arg1 = android.content.pm.IPackageDeleteObserver2.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.deletePackageVersioned(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getInstallerPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.getInstallerPackageName(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_resetApplicationPreferences:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.resetApplicationPreferences(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getLastChosenActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ResolveInfo _result = this.getLastChosenActivity(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setLastChosenActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.Intent _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.Intent.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
android.content.IntentFilter _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _arg4;
_arg4 = data.readInt();
android.content.ComponentName _arg5;
if ((0!=data.readInt())) {
_arg5 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg5 = null;
}
this.setLastChosenActivity(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_addPreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.ComponentName[] _arg2;
_arg2 = data.createTypedArray(android.content.ComponentName.CREATOR);
android.content.ComponentName _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _arg4;
_arg4 = data.readInt();
this.addPreferredActivity(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_replacePreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
android.content.ComponentName[] _arg2;
_arg2 = data.createTypedArray(android.content.ComponentName.CREATOR);
android.content.ComponentName _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _arg4;
_arg4 = data.readInt();
this.replacePreferredActivity(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_clearPackagePreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearPackagePreferredActivities(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.IntentFilter> _arg0;
_arg0 = new java.util.ArrayList<android.content.IntentFilter>();
java.util.List<android.content.ComponentName> _arg1;
_arg1 = new java.util.ArrayList<android.content.ComponentName>();
java.lang.String _arg2;
_arg2 = data.readString();
int _result = this.getPreferredActivities(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
reply.writeTypedList(_arg0);
reply.writeTypedList(_arg1);
return true;
}
case TRANSACTION_addPersistentPreferredActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.ComponentName _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
this.addPersistentPreferredActivity(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_clearPackagePersistentPreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.clearPackagePersistentPreferredActivities(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_addCrossProfileIntentFilter:
{
data.enforceInterface(DESCRIPTOR);
android.content.IntentFilter _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.IntentFilter.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
this.addCrossProfileIntentFilter(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_clearCrossProfileIntentFilters:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.clearCrossProfileIntentFilters(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setPackagesSuspendedAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
java.lang.String[] _result = this.setPackagesSuspendedAsUser(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_isPackageSuspendedForUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.isPackageSuspendedForUser(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPreferredActivityBackup:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getPreferredActivityBackup(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_restorePreferredActivities:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
int _arg1;
_arg1 = data.readInt();
this.restorePreferredActivities(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getDefaultAppsBackup:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getDefaultAppsBackup(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_restoreDefaultApps:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
int _arg1;
_arg1 = data.readInt();
this.restoreDefaultApps(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getIntentFilterVerificationBackup:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getIntentFilterVerificationBackup(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_restoreIntentFilterVerification:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
int _arg1;
_arg1 = data.readInt();
this.restoreIntentFilterVerification(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getPermissionGrantBackup:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.getPermissionGrantBackup(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_restorePermissionGrants:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
int _arg1;
_arg1 = data.readInt();
this.restorePermissionGrants(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getHomeActivities:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.content.pm.ResolveInfo> _arg0;
_arg0 = new java.util.ArrayList<android.content.pm.ResolveInfo>();
android.content.ComponentName _result = this.getHomeActivities(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
reply.writeTypedList(_arg0);
return true;
}
case TRANSACTION_setHomeActivity:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
this.setHomeActivity(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setComponentEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.setComponentEnabledSetting(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_getComponentEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _result = this.getComponentEnabledSetting(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setApplicationEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
java.lang.String _arg4;
_arg4 = data.readString();
this.setApplicationEnabledSetting(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_getApplicationEnabledSetting:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.getApplicationEnabledSetting(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_logAppProcessStartIfNeeded:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
this.logAppProcessStartIfNeeded(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
case TRANSACTION_flushPackageRestrictionsAsUser:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.flushPackageRestrictionsAsUser(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setPackageStoppedState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
this.setPackageStoppedState(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_freeStorageAndNotify:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
int _arg2;
_arg2 = data.readInt();
android.content.pm.IPackageDataObserver _arg3;
_arg3 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.freeStorageAndNotify(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_freeStorage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
long _arg1;
_arg1 = data.readLong();
int _arg2;
_arg2 = data.readInt();
android.content.IntentSender _arg3;
if ((0!=data.readInt())) {
_arg3 = android.content.IntentSender.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.freeStorage(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteApplicationCacheFiles:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageDataObserver _arg1;
_arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.deleteApplicationCacheFiles(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteApplicationCacheFilesAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.IPackageDataObserver _arg2;
_arg2 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
this.deleteApplicationCacheFilesAsUser(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_clearApplicationUserData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.IPackageDataObserver _arg1;
_arg1 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
int _arg2;
_arg2 = data.readInt();
this.clearApplicationUserData(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_clearApplicationProfileData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.clearApplicationProfileData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getPackageSizeInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.content.pm.IPackageStatsObserver _arg2;
_arg2 = android.content.pm.IPackageStatsObserver.Stub.asInterface(data.readStrongBinder());
this.getPackageSizeInfo(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getSystemSharedLibraryNames:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.getSystemSharedLibraryNames();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
case TRANSACTION_getSystemAvailableFeatures:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.ParceledListSlice _result = this.getSystemAvailableFeatures();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_hasSystemFeature:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.hasSystemFeature(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enterSafeMode:
{
data.enforceInterface(DESCRIPTOR);
this.enterSafeMode();
reply.writeNoException();
return true;
}
case TRANSACTION_isSafeMode:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isSafeMode();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_systemReady:
{
data.enforceInterface(DESCRIPTOR);
this.systemReady();
reply.writeNoException();
return true;
}
case TRANSACTION_hasSystemUidErrors:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.hasSystemUidErrors();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_performFstrimIfNeeded:
{
data.enforceInterface(DESCRIPTOR);
this.performFstrimIfNeeded();
reply.writeNoException();
return true;
}
case TRANSACTION_updatePackagesIfNeeded:
{
data.enforceInterface(DESCRIPTOR);
this.updatePackagesIfNeeded();
reply.writeNoException();
return true;
}
case TRANSACTION_notifyPackageUse:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
this.notifyPackageUse(_arg0, _arg1);
return true;
}
case TRANSACTION_notifyDexLoad:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _arg1;
_arg1 = data.createStringArrayList();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
java.lang.String _arg3;
_arg3 = data.readString();
this.notifyDexLoad(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_registerDexModule:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
android.content.pm.IDexModuleRegisterCallback _arg3;
_arg3 = android.content.pm.IDexModuleRegisterCallback.Stub.asInterface(data.readStrongBinder());
this.registerDexModule(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_performDexOptMode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
boolean _arg4;
_arg4 = (0!=data.readInt());
java.lang.String _arg5;
_arg5 = data.readString();
boolean _result = this.performDexOptMode(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_performDexOptSecondary:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
boolean _arg2;
_arg2 = (0!=data.readInt());
boolean _result = this.performDexOptSecondary(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_dumpProfiles:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.dumpProfiles(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_forceDexOpt:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.forceDexOpt(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_runBackgroundDexoptJob:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.runBackgroundDexoptJob();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_reconcileSecondaryDexFiles:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.reconcileSecondaryDexFiles(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_updateExternalMediaStatus:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.updateExternalMediaStatus(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_nextPackageToClean:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PackageCleanItem _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PackageCleanItem.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.content.pm.PackageCleanItem _result = this.nextPackageToClean(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getMoveStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.getMoveStatus(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_registerMoveCallback:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.IPackageMoveObserver _arg0;
_arg0 = android.content.pm.IPackageMoveObserver.Stub.asInterface(data.readStrongBinder());
this.registerMoveCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterMoveCallback:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.IPackageMoveObserver _arg0;
_arg0 = android.content.pm.IPackageMoveObserver.Stub.asInterface(data.readStrongBinder());
this.unregisterMoveCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_movePackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.movePackage(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_movePrimaryStorage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _result = this.movePrimaryStorage(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_addPermissionAsync:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.PermissionInfo _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.pm.PermissionInfo.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.addPermissionAsync(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setInstallLocation:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setInstallLocation(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getInstallLocation:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getInstallLocation();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_installExistingPackageAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _result = this.installExistingPackageAsUser(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_verifyPendingInstall:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.verifyPendingInstall(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_extendVerificationTimeout:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
long _arg2;
_arg2 = data.readLong();
this.extendVerificationTimeout(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_verifyIntentFilter:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
java.util.List<java.lang.String> _arg2;
_arg2 = data.createStringArrayList();
this.verifyIntentFilter(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getIntentVerificationStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.getIntentVerificationStatus(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_updateIntentVerificationStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.updateIntentVerificationStatus(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getIntentFilterVerifications:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.ParceledListSlice _result = this.getIntentFilterVerifications(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getAllIntentFilters:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.ParceledListSlice _result = this.getAllIntentFilters(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setDefaultBrowserPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.setDefaultBrowserPackageName(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getDefaultBrowserPackageName:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.getDefaultBrowserPackageName(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVerifierDeviceIdentity:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.VerifierDeviceIdentity _result = this.getVerifierDeviceIdentity();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_isFirstBoot:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isFirstBoot();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isOnlyCoreApps:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isOnlyCoreApps();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isUpgrade:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isUpgrade();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPermissionEnforced:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setPermissionEnforced(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_isPermissionEnforced:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isPermissionEnforced(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isStorageLow:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isStorageLow();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setApplicationHiddenSettingAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
boolean _result = this.setApplicationHiddenSettingAsUser(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getApplicationHiddenSettingAsUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.getApplicationHiddenSettingAsUser(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPackageInstaller:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.IPackageInstaller _result = this.getPackageInstaller();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_setBlockUninstallForUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _arg2;
_arg2 = data.readInt();
boolean _result = this.setBlockUninstallForUser(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getBlockUninstallForUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.getBlockUninstallForUser(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getKeySetByAlias:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
android.content.pm.KeySet _result = this.getKeySetByAlias(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getSigningKeySet:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.KeySet _result = this.getSigningKeySet(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_isPackageSignedByKeySet:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.KeySet _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.pm.KeySet.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.isPackageSignedByKeySet(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isPackageSignedByKeySetExactly:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.content.pm.KeySet _arg1;
if ((0!=data.readInt())) {
_arg1 = android.content.pm.KeySet.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
boolean _result = this.isPackageSignedByKeySetExactly(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_addOnPermissionsChangeListener:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.IOnPermissionsChangeListener _arg0;
_arg0 = android.content.pm.IOnPermissionsChangeListener.Stub.asInterface(data.readStrongBinder());
this.addOnPermissionsChangeListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeOnPermissionsChangeListener:
{
data.enforceInterface(DESCRIPTOR);
android.content.pm.IOnPermissionsChangeListener _arg0;
_arg0 = android.content.pm.IOnPermissionsChangeListener.Stub.asInterface(data.readStrongBinder());
this.removeOnPermissionsChangeListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_grantDefaultPermissionsToEnabledCarrierApps:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int _arg1;
_arg1 = data.readInt();
this.grantDefaultPermissionsToEnabledCarrierApps(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_grantDefaultPermissionsToEnabledImsServices:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int _arg1;
_arg1 = data.readInt();
this.grantDefaultPermissionsToEnabledImsServices(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_isPermissionRevokedByPolicy:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.isPermissionRevokedByPolicy(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPermissionControllerPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPermissionControllerPackageName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getInstantApps:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getInstantApps(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstantAppCookie:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
byte[] _result = this.getInstantAppCookie(_arg0, _arg1);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_setInstantAppCookie:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
int _arg2;
_arg2 = data.readInt();
boolean _result = this.setInstantAppCookie(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getInstantAppIcon:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
android.graphics.Bitmap _result = this.getInstantAppIcon(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_isInstantApp:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.isInstantApp(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setRequiredForSystemUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _result = this.setRequiredForSystemUser(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setUpdateAvailable:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
this.setUpdateAvailable(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getServicesSystemSharedLibraryPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getServicesSystemSharedLibraryPackageName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getSharedSystemSharedLibraryPackageName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getSharedSystemSharedLibraryPackageName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getChangedPackages:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.content.pm.ChangedPackages _result = this.getChangedPackages(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_isPackageDeviceAdminOnAnyUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.isPackageDeviceAdminOnAnyUser(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getPreviousCodePaths:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.util.List<java.lang.String> _result = this.getPreviousCodePaths(_arg0);
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_getInstallReason:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _result = this.getInstallReason(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getSharedLibraries:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.content.pm.ParceledListSlice _result = this.getSharedLibraries(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_canRequestPackageInstalls:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.canRequestPackageInstalls(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_deletePreloadsFileCache:
{
data.enforceInterface(DESCRIPTOR);
this.deletePreloadsFileCache();
reply.writeNoException();
return true;
}
case TRANSACTION_getInstantAppResolverComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getInstantAppResolverComponent();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstantAppResolverSettingsComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getInstantAppResolverSettingsComponent();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstantAppInstallerComponent:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _result = this.getInstantAppInstallerComponent();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getInstantAppAndroidId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _result = this.getInstantAppAndroidId(_arg0, _arg1);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.content.pm.IPackageManager
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void checkPackageStartable(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_checkPackageStartable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isPackageAvailable(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_isPackageAvailable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.PackageInfo getPackageInfo(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PackageInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPackageInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PackageInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.PackageInfo getPackageInfoVersioned(android.content.pm.VersionedPackage versionedPackage, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PackageInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((versionedPackage!=null)) {
_data.writeInt(1);
versionedPackage.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPackageInfoVersioned, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PackageInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getPackageUid(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPackageUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int[] getPackageGids(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPackageGids, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String[] currentToCanonicalPackageNames(java.lang.String[] names) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(names);
mRemote.transact(Stub.TRANSACTION_currentToCanonicalPackageNames, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String[] canonicalToCurrentPackageNames(java.lang.String[] names) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(names);
mRemote.transact(Stub.TRANSACTION_canonicalToCurrentPackageNames, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.PermissionInfo getPermissionInfo(java.lang.String name, java.lang.String packageName, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PermissionInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(packageName);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPermissionInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PermissionInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryPermissionsByGroup(java.lang.String group, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(group);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryPermissionsByGroup, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.PermissionGroupInfo getPermissionGroupInfo(java.lang.String name, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PermissionGroupInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPermissionGroupInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PermissionGroupInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice getAllPermissionGroups(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getAllPermissionGroups, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ApplicationInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getApplicationInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ApplicationInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ActivityInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getActivityInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ActivityInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean activitySupportsIntent(android.content.ComponentName className, android.content.Intent intent, java.lang.String resolvedType) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
mRemote.transact(Stub.TRANSACTION_activitySupportsIntent, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ActivityInfo getReceiverInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ActivityInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getReceiverInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ActivityInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ServiceInfo getServiceInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ServiceInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getServiceInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ServiceInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ProviderInfo getProviderInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ProviderInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getProviderInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ProviderInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int checkPermission(java.lang.String permName, java.lang.String pkgName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permName);
_data.writeString(pkgName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_checkPermission, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int checkUidPermission(java.lang.String permName, int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permName);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_checkUidPermission, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean addPermission(android.content.pm.PermissionInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPermission, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void removePermission(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_removePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void grantRuntimePermission(java.lang.String packageName, java.lang.String permissionName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(permissionName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_grantRuntimePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void revokeRuntimePermission(java.lang.String packageName, java.lang.String permissionName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(permissionName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_revokeRuntimePermission, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void resetRuntimePermissions() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_resetRuntimePermissions, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getPermissionFlags(java.lang.String permissionName, java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permissionName);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPermissionFlags, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void updatePermissionFlags(java.lang.String permissionName, java.lang.String packageName, int flagMask, int flagValues, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permissionName);
_data.writeString(packageName);
_data.writeInt(flagMask);
_data.writeInt(flagValues);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_updatePermissionFlags, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flagMask);
_data.writeInt(flagValues);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_updatePermissionFlagsForAllApps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean shouldShowRequestPermissionRationale(java.lang.String permissionName, java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permissionName);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_shouldShowRequestPermissionRationale, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isProtectedBroadcast(java.lang.String actionName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(actionName);
mRemote.transact(Stub.TRANSACTION_isProtectedBroadcast, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int checkSignatures(java.lang.String pkg1, java.lang.String pkg2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pkg1);
_data.writeString(pkg2);
mRemote.transact(Stub.TRANSACTION_checkSignatures, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int checkUidSignatures(int uid1, int uid2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid1);
_data.writeInt(uid2);
mRemote.transact(Stub.TRANSACTION_checkUidSignatures, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<java.lang.String> getAllPackages() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllPackages, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String[] getPackagesForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getPackagesForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getNameForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getNameForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String[] getNamesForUids(int[] uids) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(uids);
mRemote.transact(Stub.TRANSACTION_getNamesForUids, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getUidForSharedUser(java.lang.String sharedUserName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(sharedUserName);
mRemote.transact(Stub.TRANSACTION_getUidForSharedUser, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getFlagsForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getFlagsForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getPrivateFlagsForUid(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_getPrivateFlagsForUid, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isUidPrivileged(int uid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(uid);
mRemote.transact(Stub.TRANSACTION_isUidPrivileged, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String[] getAppOpPermissionPackages(java.lang.String permissionName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permissionName);
mRemote.transact(Stub.TRANSACTION_getAppOpPermissionPackages, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ResolveInfo resolveIntent(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_resolveIntent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ResolveInfo findPersistentPreferredActivity(android.content.Intent intent, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_findPersistentPreferredActivity, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean canForwardTo(android.content.Intent intent, java.lang.String resolvedType, int sourceUserId, int targetUserId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(sourceUserId);
_data.writeInt(targetUserId);
mRemote.transact(Stub.TRANSACTION_canForwardTo, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryIntentActivities(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_queryIntentActivities, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryIntentActivityOptions(android.content.ComponentName caller, android.content.Intent[] specifics, java.lang.String[] specificTypes, android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((caller!=null)) {
_data.writeInt(1);
caller.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeTypedArray(specifics, 0);
_data.writeStringArray(specificTypes);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_queryIntentActivityOptions, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryIntentReceivers(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_queryIntentReceivers, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ResolveInfo resolveService(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_resolveService, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryIntentServices(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_queryIntentServices, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryIntentContentProviders(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_queryIntentContentProviders, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * This implements getInstalledPackages via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
@Override public android.content.pm.ParceledListSlice getInstalledPackages(int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstalledPackages, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * This implements getPackagesHoldingPermissions via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
@Override public android.content.pm.ParceledListSlice getPackagesHoldingPermissions(java.lang.String[] permissions, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(permissions);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPackagesHoldingPermissions, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * This implements getInstalledApplications via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
@Override public android.content.pm.ParceledListSlice getInstalledApplications(int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstalledApplications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieve all applications that are marked as persistent.
     *
     * @return A List&lt;applicationInfo> containing one entry for each persistent
     *         application.
     */
@Override public android.content.pm.ParceledListSlice getPersistentApplications(int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getPersistentApplications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ProviderInfo resolveContentProvider(java.lang.String name, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ProviderInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_resolveContentProvider, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ProviderInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Retrieve sync information for all content providers.
     *
     * @param outNames Filled in with a list of the root names of the content
     *                 providers that can sync.
     * @param outInfo Filled in with a list of the ProviderInfo for each
     *                name in 'outNames'.
     */
@Override public void querySyncProviders(java.util.List<java.lang.String> outNames, java.util.List<android.content.pm.ProviderInfo> outInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringList(outNames);
_data.writeTypedList(outInfo);
mRemote.transact(Stub.TRANSACTION_querySyncProviders, _data, _reply, 0);
_reply.readException();
_reply.readStringList(outNames);
_reply.readTypedList(outInfo, android.content.pm.ProviderInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public android.content.pm.ParceledListSlice queryContentProviders(java.lang.String processName, int uid, int flags, java.lang.String metaDataKey) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(uid);
_data.writeInt(flags);
_data.writeString(metaDataKey);
mRemote.transact(Stub.TRANSACTION_queryContentProviders, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.InstrumentationInfo getInstrumentationInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.InstrumentationInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getInstrumentationInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.InstrumentationInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice queryInstrumentation(java.lang.String targetPackage, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(targetPackage);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_queryInstrumentation, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** @deprecated Use PackageInstaller instead */
@Override public void installPackageAsUser(java.lang.String originPath, android.content.pm.IPackageInstallObserver2 observer, int flags, java.lang.String installerPackageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(originPath);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(flags);
_data.writeString(installerPackageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_installPackageAsUser, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void finishPackageInstall(int token, boolean didLaunch) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(token);
_data.writeInt(((didLaunch)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_finishPackageInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setInstallerPackageName(java.lang.String targetPackage, java.lang.String installerPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(targetPackage);
_data.writeString(installerPackageName);
mRemote.transact(Stub.TRANSACTION_setInstallerPackageName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void setApplicationCategoryHint(java.lang.String packageName, int categoryHint, java.lang.String callerPackageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(categoryHint);
_data.writeString(callerPackageName);
mRemote.transact(Stub.TRANSACTION_setApplicationCategoryHint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/** @deprecated rawr, don't call AIDL methods directly! */
@Override public void deletePackageAsUser(java.lang.String packageName, int versionCode, android.content.pm.IPackageDeleteObserver observer, int userId, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(versionCode);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_deletePackageAsUser, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Delete a package for a specific user.
     *
     * @param versionedPackage The package to delete.
     * @param observer a callback to use to notify when the package deletion in finished.
     * @param userId the id of the user for whom to delete the package
     * @param flags - possible values: {@link #DONT_DELETE_DATA}
     */
@Override public void deletePackageVersioned(android.content.pm.VersionedPackage versionedPackage, android.content.pm.IPackageDeleteObserver2 observer, int userId, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((versionedPackage!=null)) {
_data.writeInt(1);
versionedPackage.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_deletePackageVersioned, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getInstallerPackageName(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getInstallerPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void resetApplicationPreferences(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_resetApplicationPreferences, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public android.content.pm.ResolveInfo getLastChosenActivity(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ResolveInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_getLastChosenActivity, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ResolveInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setLastChosenActivity(android.content.Intent intent, java.lang.String resolvedType, int flags, android.content.IntentFilter filter, int match, android.content.ComponentName activity) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intent!=null)) {
_data.writeInt(1);
intent.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(resolvedType);
_data.writeInt(flags);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(match);
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_setLastChosenActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void addPreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(match);
_data.writeTypedArray(set, 0);
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_addPreferredActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void replacePreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(match);
_data.writeTypedArray(set, 0);
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_replacePreferredActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void clearPackagePreferredActivities(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_clearPackagePreferredActivities, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getPreferredActivities(java.util.List<android.content.IntentFilter> outFilters, java.util.List<android.content.ComponentName> outActivities, java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getPreferredActivities, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
_reply.readTypedList(outFilters, android.content.IntentFilter.CREATOR);
_reply.readTypedList(outActivities, android.content.ComponentName.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addPersistentPreferredActivity(android.content.IntentFilter filter, android.content.ComponentName activity, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((filter!=null)) {
_data.writeInt(1);
filter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((activity!=null)) {
_data.writeInt(1);
activity.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_addPersistentPreferredActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void clearPackagePersistentPreferredActivities(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_clearPackagePersistentPreferredActivities, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void addCrossProfileIntentFilter(android.content.IntentFilter intentFilter, java.lang.String ownerPackage, int sourceUserId, int targetUserId, int flags) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((intentFilter!=null)) {
_data.writeInt(1);
intentFilter.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(ownerPackage);
_data.writeInt(sourceUserId);
_data.writeInt(targetUserId);
_data.writeInt(flags);
mRemote.transact(Stub.TRANSACTION_addCrossProfileIntentFilter, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void clearCrossProfileIntentFilters(int sourceUserId, java.lang.String ownerPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sourceUserId);
_data.writeString(ownerPackage);
mRemote.transact(Stub.TRANSACTION_clearCrossProfileIntentFilters, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String[] setPackagesSuspendedAsUser(java.lang.String[] packageNames, boolean suspended, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(packageNames);
_data.writeInt(((suspended)?(1):(0)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setPackagesSuspendedAsUser, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPackageSuspendedForUser(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_isPackageSuspendedForUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Backup/restore support - only the system uid may use these.
     */
@Override public byte[] getPreferredActivityBackup(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPreferredActivityBackup, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void restorePreferredActivities(byte[] backup, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(backup);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_restorePreferredActivities, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public byte[] getDefaultAppsBackup(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getDefaultAppsBackup, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void restoreDefaultApps(byte[] backup, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(backup);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_restoreDefaultApps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public byte[] getIntentFilterVerificationBackup(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getIntentFilterVerificationBackup, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void restoreIntentFilterVerification(byte[] backup, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(backup);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_restoreIntentFilterVerification, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public byte[] getPermissionGrantBackup(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getPermissionGrantBackup, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void restorePermissionGrants(byte[] backup, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(backup);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_restorePermissionGrants, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Report the set of 'Home' activity candidates, plus (if any) which of them
     * is the current "always use this one" setting.
     */
@Override public android.content.ComponentName getHomeActivities(java.util.List<android.content.pm.ResolveInfo> outHomeCandidates) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getHomeActivities, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
_reply.readTypedList(outHomeCandidates, android.content.pm.ResolveInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setHomeActivity(android.content.ComponentName className, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((className!=null)) {
_data.writeInt(1);
className.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setHomeActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * As per {@link android.content.pm.PackageManager#setComponentEnabledSetting}.
     */
@Override public void setComponentEnabledSetting(android.content.ComponentName componentName, int newState, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(newState);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setComponentEnabledSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getComponentEnabledSetting(android.content.ComponentName componentName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((componentName!=null)) {
_data.writeInt(1);
componentName.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getComponentEnabledSetting, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * As per {@link android.content.pm.PackageManager#setApplicationEnabledSetting}.
     */
@Override public void setApplicationEnabledSetting(java.lang.String packageName, int newState, int flags, int userId, java.lang.String callingPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(newState);
_data.writeInt(flags);
_data.writeInt(userId);
_data.writeString(callingPackage);
mRemote.transact(Stub.TRANSACTION_setApplicationEnabledSetting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getApplicationEnabledSetting(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getApplicationEnabledSetting, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Logs process start information (including APK hash) to the security log.
     */
@Override public void logAppProcessStartIfNeeded(java.lang.String processName, int uid, java.lang.String seinfo, java.lang.String apkFile, int pid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(processName);
_data.writeInt(uid);
_data.writeString(seinfo);
_data.writeString(apkFile);
_data.writeInt(pid);
mRemote.transact(Stub.TRANSACTION_logAppProcessStartIfNeeded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * As per {@link android.content.pm.PackageManager#flushPackageRestrictionsAsUser}.
     */
@Override public void flushPackageRestrictionsAsUser(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_flushPackageRestrictionsAsUser, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Set whether the given package should be considered stopped, making
     * it not visible to implicit intents that filter out stopped packages.
     */
@Override public void setPackageStoppedState(java.lang.String packageName, boolean stopped, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((stopped)?(1):(0)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setPackageStoppedState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param observer call back used to notify when
     * the operation is completed
     */
@Override public void freeStorageAndNotify(java.lang.String volumeUuid, long freeStorageSize, int storageFlags, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(volumeUuid);
_data.writeLong(freeStorageSize);
_data.writeInt(storageFlags);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_freeStorageAndNotify, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param pi IntentSender call back used to
     * notify when the operation is completed.May be null
     * to indicate that no call back is desired.
     */
@Override public void freeStorage(java.lang.String volumeUuid, long freeStorageSize, int storageFlags, android.content.IntentSender pi) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(volumeUuid);
_data.writeLong(freeStorageSize);
_data.writeInt(storageFlags);
if ((pi!=null)) {
_data.writeInt(1);
pi.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_freeStorage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Delete all the cache files in an applications cache directory
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the deletion is finished.
     */
@Override public void deleteApplicationCacheFiles(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_deleteApplicationCacheFiles, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Delete all the cache files in an applications cache directory
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param userId the user to delete application cache for
     * @param observer a callback used to notify when the deletion is finished.
     */
@Override public void deleteApplicationCacheFilesAsUser(java.lang.String packageName, int userId, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_deleteApplicationCacheFilesAsUser, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Clear the user data directory of an application.
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the operation is completed.
     */
@Override public void clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_clearApplicationUserData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Clear the profile data of an application.
     * @param packageName The package name of the application whose profile data
     * need to be deleted
     */
@Override public void clearApplicationProfileData(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_clearApplicationProfileData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get package statistics including the code, data and cache size for
     * an already installed package
     * @param packageName The package name of the application
     * @param userHandle Which user the size should be retrieved for
     * @param observer a callback to use to notify when the asynchronous
     * retrieval of information is complete.
     */
@Override public void getPackageSizeInfo(java.lang.String packageName, int userHandle, android.content.pm.IPackageStatsObserver observer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userHandle);
_data.writeStrongBinder((((observer!=null))?(observer.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getPackageSizeInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String[] getSystemSharedLibraryNames() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSystemSharedLibraryNames, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Get a list of features that are available on the
     * system.
     */
@Override public android.content.pm.ParceledListSlice getSystemAvailableFeatures() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSystemAvailableFeatures, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean hasSystemFeature(java.lang.String name, int version) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(version);
mRemote.transact(Stub.TRANSACTION_hasSystemFeature, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void enterSafeMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_enterSafeMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isSafeMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isSafeMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void systemReady() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_systemReady, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean hasSystemUidErrors() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hasSystemUidErrors, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Ask the package manager to fstrim the disk if needed.
     */
@Override public void performFstrimIfNeeded() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_performFstrimIfNeeded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Ask the package manager to update packages if needed.
     */
@Override public void updatePackagesIfNeeded() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_updatePackagesIfNeeded, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Notify the package manager that a package is going to be used and why.
     *
     * See PackageManager.NOTIFY_PACKAGE_USE_* for reasons.
     */
@Override public void notifyPackageUse(java.lang.String packageName, int reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(reason);
mRemote.transact(Stub.TRANSACTION_notifyPackageUse, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Notify the package manager that a list of dex files have been loaded.
     *
     * @param loadingPackageName the name of the package who performs the load
     * @param classLoadersNames the names of the class loaders present in the loading chain. The
     *    list encodes the class loader chain in the natural order. The first class loader has
     *    the second one as its parent and so on. The dex files present in the class path of the
     *    first class loader will be recorded in the usage file.
     * @param classPaths the class paths corresponding to the class loaders names from
     *     {@param classLoadersNames}. The the first element corresponds to the first class loader
     *     and so on. A classpath is represented as a list of dex files separated by
     *     {@code File.pathSeparator}.
     *     The dex files found in the first class path will be recorded in the usage file.
     * @param loaderIsa the ISA of the loader process
     */
@Override public void notifyDexLoad(java.lang.String loadingPackageName, java.util.List<java.lang.String> classLoadersNames, java.util.List<java.lang.String> classPaths, java.lang.String loaderIsa) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(loadingPackageName);
_data.writeStringList(classLoadersNames);
_data.writeStringList(classPaths);
_data.writeString(loaderIsa);
mRemote.transact(Stub.TRANSACTION_notifyDexLoad, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Register an application dex module with the package manager.
     * The package manager will keep track of the given module for future optimizations.
     *
     * Dex module optimizations will disable the classpath checking at runtime. The client bares
     * the responsibility to ensure that the static assumptions on classes in the optimized code
     * hold at runtime (e.g. there's no duplicate classes in the classpath).
     *
     * Note that the package manager already keeps track of dex modules loaded with
     * {@link dalvik.system.DexClassLoader} and {@link dalvik.system.PathClassLoader}.
     * This can be called for an eager registration.
     *
     * The call might take a while and the results will be posted on the main thread, using
     * the given callback.
     *
     * If the module is intended to be shared with other apps, make sure that the file
     * permissions allow for it.
     * If at registration time the permissions allow for others to read it, the module would
     * be marked as a shared module which might undergo a different optimization strategy.
     * (usually shared modules will generated larger optimizations artifacts,
     * taking more disk space).
     *
     * @param packageName the package name to which the dex module belongs
     * @param dexModulePath the absolute path of the dex module.
     * @param isSharedModule whether or not the module is intended to be used by other apps.
     * @param callback if not null,
     *   {@link android.content.pm.IDexModuleRegisterCallback.IDexModuleRegisterCallback#onDexModuleRegistered}
     *   will be called once the registration finishes.
     */
@Override public void registerDexModule(java.lang.String packageName, java.lang.String dexModulePath, boolean isSharedModule, android.content.pm.IDexModuleRegisterCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(dexModulePath);
_data.writeInt(((isSharedModule)?(1):(0)));
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerDexModule, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Ask the package manager to perform a dex-opt with the given compiler filter.
     *
     * Note: exposed only for the shell command to allow moving packages explicitly to a
     *       definite state.
     */
@Override public boolean performDexOptMode(java.lang.String packageName, boolean checkProfiles, java.lang.String targetCompilerFilter, boolean force, boolean bootComplete, java.lang.String splitName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((checkProfiles)?(1):(0)));
_data.writeString(targetCompilerFilter);
_data.writeInt(((force)?(1):(0)));
_data.writeInt(((bootComplete)?(1):(0)));
_data.writeString(splitName);
mRemote.transact(Stub.TRANSACTION_performDexOptMode, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Ask the package manager to perform a dex-opt with the given compiler filter on the
     * secondary dex files belonging to the given package.
     *
     * Note: exposed only for the shell command to allow moving packages explicitly to a
     *       definite state.
     */
@Override public boolean performDexOptSecondary(java.lang.String packageName, java.lang.String targetCompilerFilter, boolean force) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(targetCompilerFilter);
_data.writeInt(((force)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_performDexOptSecondary, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Ask the package manager to dump profiles associated with a package.
     */
@Override public void dumpProfiles(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_dumpProfiles, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void forceDexOpt(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_forceDexOpt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Execute the background dexopt job immediately.
     */
@Override public boolean runBackgroundDexoptJob() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_runBackgroundDexoptJob, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Reconcile the information we have about the secondary dex files belonging to
     * {@code packagName} and the actual dex files. For all dex files that were
     * deleted, update the internal records and delete the generated oat files.
     */
@Override public void reconcileSecondaryDexFiles(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_reconcileSecondaryDexFiles, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Update status of external media on the package manager to scan and
     * install packages installed on the external media. Like say the
     * StorageManagerService uses this to call into the package manager to update
     * status of sdcard.
     */
@Override public void updateExternalMediaStatus(boolean mounted, boolean reportStatus) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mounted)?(1):(0)));
_data.writeInt(((reportStatus)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_updateExternalMediaStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public android.content.pm.PackageCleanItem nextPackageToClean(android.content.pm.PackageCleanItem lastPackage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.PackageCleanItem _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((lastPackage!=null)) {
_data.writeInt(1);
lastPackage.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_nextPackageToClean, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.PackageCleanItem.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getMoveStatus(int moveId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(moveId);
mRemote.transact(Stub.TRANSACTION_getMoveStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void registerMoveCallback(android.content.pm.IPackageMoveObserver callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerMoveCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void unregisterMoveCallback(android.content.pm.IPackageMoveObserver callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterMoveCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int movePackage(java.lang.String packageName, java.lang.String volumeUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(volumeUuid);
mRemote.transact(Stub.TRANSACTION_movePackage, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int movePrimaryStorage(java.lang.String volumeUuid) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(volumeUuid);
mRemote.transact(Stub.TRANSACTION_movePrimaryStorage, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean addPermissionAsync(android.content.pm.PermissionInfo info) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((info!=null)) {
_data.writeInt(1);
info.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_addPermissionAsync, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setInstallLocation(int loc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(loc);
mRemote.transact(Stub.TRANSACTION_setInstallLocation, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getInstallLocation() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstallLocation, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int installExistingPackageAsUser(java.lang.String packageName, int userId, int installFlags, int installReason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
_data.writeInt(installFlags);
_data.writeInt(installReason);
mRemote.transact(Stub.TRANSACTION_installExistingPackageAsUser, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void verifyPendingInstall(int id, int verificationCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(verificationCode);
mRemote.transact(Stub.TRANSACTION_verifyPendingInstall, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void extendVerificationTimeout(int id, int verificationCodeAtTimeout, long millisecondsToDelay) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(verificationCodeAtTimeout);
_data.writeLong(millisecondsToDelay);
mRemote.transact(Stub.TRANSACTION_extendVerificationTimeout, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void verifyIntentFilter(int id, int verificationCode, java.util.List<java.lang.String> failedDomains) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(verificationCode);
_data.writeStringList(failedDomains);
mRemote.transact(Stub.TRANSACTION_verifyIntentFilter, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getIntentVerificationStatus(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getIntentVerificationStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean updateIntentVerificationStatus(java.lang.String packageName, int status, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(status);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_updateIntentVerificationStatus, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice getIntentFilterVerifications(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getIntentFilterVerifications, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice getAllIntentFilters(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getAllIntentFilters, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setDefaultBrowserPackageName(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setDefaultBrowserPackageName, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getDefaultBrowserPackageName(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getDefaultBrowserPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.VerifierDeviceIdentity getVerifierDeviceIdentity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.VerifierDeviceIdentity _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVerifierDeviceIdentity, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.VerifierDeviceIdentity.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isFirstBoot() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isFirstBoot, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isOnlyCoreApps() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isOnlyCoreApps, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isUpgrade() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isUpgrade, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setPermissionEnforced(java.lang.String permission, boolean enforced) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permission);
_data.writeInt(((enforced)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setPermissionEnforced, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isPermissionEnforced(java.lang.String permission) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permission);
mRemote.transact(Stub.TRANSACTION_isPermissionEnforced, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/** Reflects current DeviceStorageMonitorService state */
@Override public boolean isStorageLow() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isStorageLow, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setApplicationHiddenSettingAsUser(java.lang.String packageName, boolean hidden, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((hidden)?(1):(0)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setApplicationHiddenSettingAsUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean getApplicationHiddenSettingAsUser(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getApplicationHiddenSettingAsUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.IPackageInstaller getPackageInstaller() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.IPackageInstaller _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPackageInstaller, _data, _reply, 0);
_reply.readException();
_result = android.content.pm.IPackageInstaller.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setBlockUninstallForUser(java.lang.String packageName, boolean blockUninstall, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((blockUninstall)?(1):(0)));
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setBlockUninstallForUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean getBlockUninstallForUser(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getBlockUninstallForUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.KeySet getKeySetByAlias(java.lang.String packageName, java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.KeySet _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_getKeySetByAlias, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.KeySet.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.KeySet getSigningKeySet(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.KeySet _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getSigningKeySet, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.KeySet.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPackageSignedByKeySet(java.lang.String packageName, android.content.pm.KeySet ks) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
if ((ks!=null)) {
_data.writeInt(1);
ks.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isPackageSignedByKeySet, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPackageSignedByKeySetExactly(java.lang.String packageName, android.content.pm.KeySet ks) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
if ((ks!=null)) {
_data.writeInt(1);
ks.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_isPackageSignedByKeySetExactly, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addOnPermissionsChangeListener(android.content.pm.IOnPermissionsChangeListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addOnPermissionsChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeOnPermissionsChangeListener(android.content.pm.IOnPermissionsChangeListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeOnPermissionsChangeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void grantDefaultPermissionsToEnabledCarrierApps(java.lang.String[] packageNames, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(packageNames);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_grantDefaultPermissionsToEnabledCarrierApps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void grantDefaultPermissionsToEnabledImsServices(java.lang.String[] packageNames, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(packageNames);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_grantDefaultPermissionsToEnabledImsServices, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isPermissionRevokedByPolicy(java.lang.String permission, java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(permission);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_isPermissionRevokedByPolicy, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getPermissionControllerPackageName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPermissionControllerPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice getInstantApps(int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstantApps, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public byte[] getInstantAppCookie(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstantAppCookie, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setInstantAppCookie(java.lang.String packageName, byte[] cookie, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeByteArray(cookie);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_setInstantAppCookie, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.graphics.Bitmap getInstantAppIcon(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstantAppIcon, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isInstantApp(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_isInstantApp, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean setRequiredForSystemUser(java.lang.String packageName, boolean systemUserApp) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((systemUserApp)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setRequiredForSystemUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Sets whether or not an update is available. Ostensibly for instant apps
     * to force exteranl resolution.
     */
@Override public void setUpdateAvailable(java.lang.String packageName, boolean updateAvaialble) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(((updateAvaialble)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_setUpdateAvailable, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getServicesSystemSharedLibraryPackageName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getServicesSystemSharedLibraryPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getSharedSystemSharedLibraryPackageName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSharedSystemSharedLibraryPackageName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ChangedPackages getChangedPackages(int sequenceNumber, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ChangedPackages _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sequenceNumber);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getChangedPackages, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ChangedPackages.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPackageDeviceAdminOnAnyUser(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_isPackageDeviceAdminOnAnyUser, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<java.lang.String> getPreviousCodePaths(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_getPreviousCodePaths, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getInstallReason(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstallReason, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.pm.ParceledListSlice getSharedLibraries(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.pm.ParceledListSlice _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(flags);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getSharedLibraries, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.pm.ParceledListSlice.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean canRequestPackageInstalls(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_canRequestPackageInstalls, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void deletePreloadsFileCache() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_deletePreloadsFileCache, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public android.content.ComponentName getInstantAppResolverComponent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstantAppResolverComponent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.ComponentName getInstantAppResolverSettingsComponent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstantAppResolverSettingsComponent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public android.content.ComponentName getInstantAppInstallerComponent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.content.ComponentName _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getInstantAppInstallerComponent, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.content.ComponentName.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getInstantAppAndroidId(java.lang.String packageName, int userId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(userId);
mRemote.transact(Stub.TRANSACTION_getInstantAppAndroidId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_checkPackageStartable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_isPackageAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getPackageInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getPackageInfoVersioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getPackageUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getPackageGids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_currentToCanonicalPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_canonicalToCurrentPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getPermissionInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_queryPermissionsByGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getPermissionGroupInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getAllPermissionGroups = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getApplicationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_getActivityInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_activitySupportsIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getReceiverInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_getServiceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_getProviderInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_checkPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_checkUidPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_addPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_removePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_grantRuntimePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_revokeRuntimePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_resetRuntimePermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_getPermissionFlags = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_updatePermissionFlags = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_updatePermissionFlagsForAllApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_shouldShowRequestPermissionRationale = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_isProtectedBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_checkSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_checkUidSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_getAllPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_getPackagesForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_getNameForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_getNamesForUids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_getUidForSharedUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_getFlagsForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_getPrivateFlagsForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_isUidPrivileged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_getAppOpPermissionPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_resolveIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_findPersistentPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_canForwardTo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_queryIntentActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_queryIntentActivityOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_queryIntentReceivers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_resolveService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_queryIntentServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_queryIntentContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_getInstalledPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_getPackagesHoldingPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_getInstalledApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_getPersistentApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_resolveContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_querySyncProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_queryContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_getInstrumentationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_queryInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_installPackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_finishPackageInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_setInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_setApplicationCategoryHint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_deletePackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_deletePackageVersioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
static final int TRANSACTION_getInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
static final int TRANSACTION_resetApplicationPreferences = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
static final int TRANSACTION_getLastChosenActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
static final int TRANSACTION_setLastChosenActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
static final int TRANSACTION_addPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
static final int TRANSACTION_replacePreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
static final int TRANSACTION_clearPackagePreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
static final int TRANSACTION_getPreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
static final int TRANSACTION_addPersistentPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
static final int TRANSACTION_clearPackagePersistentPreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
static final int TRANSACTION_addCrossProfileIntentFilter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
static final int TRANSACTION_clearCrossProfileIntentFilters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
static final int TRANSACTION_setPackagesSuspendedAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
static final int TRANSACTION_isPackageSuspendedForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
static final int TRANSACTION_getPreferredActivityBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
static final int TRANSACTION_restorePreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
static final int TRANSACTION_getDefaultAppsBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
static final int TRANSACTION_restoreDefaultApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
static final int TRANSACTION_getIntentFilterVerificationBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
static final int TRANSACTION_restoreIntentFilterVerification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
static final int TRANSACTION_getPermissionGrantBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 85);
static final int TRANSACTION_restorePermissionGrants = (android.os.IBinder.FIRST_CALL_TRANSACTION + 86);
static final int TRANSACTION_getHomeActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 87);
static final int TRANSACTION_setHomeActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 88);
static final int TRANSACTION_setComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 89);
static final int TRANSACTION_getComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
static final int TRANSACTION_setApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 91);
static final int TRANSACTION_getApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 92);
static final int TRANSACTION_logAppProcessStartIfNeeded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 93);
static final int TRANSACTION_flushPackageRestrictionsAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 94);
static final int TRANSACTION_setPackageStoppedState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 95);
static final int TRANSACTION_freeStorageAndNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 96);
static final int TRANSACTION_freeStorage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 97);
static final int TRANSACTION_deleteApplicationCacheFiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 98);
static final int TRANSACTION_deleteApplicationCacheFilesAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 99);
static final int TRANSACTION_clearApplicationUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
static final int TRANSACTION_clearApplicationProfileData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
static final int TRANSACTION_getPackageSizeInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
static final int TRANSACTION_getSystemSharedLibraryNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 103);
static final int TRANSACTION_getSystemAvailableFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 104);
static final int TRANSACTION_hasSystemFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 105);
static final int TRANSACTION_enterSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 106);
static final int TRANSACTION_isSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 107);
static final int TRANSACTION_systemReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 108);
static final int TRANSACTION_hasSystemUidErrors = (android.os.IBinder.FIRST_CALL_TRANSACTION + 109);
static final int TRANSACTION_performFstrimIfNeeded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
static final int TRANSACTION_updatePackagesIfNeeded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
static final int TRANSACTION_notifyPackageUse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
static final int TRANSACTION_notifyDexLoad = (android.os.IBinder.FIRST_CALL_TRANSACTION + 113);
static final int TRANSACTION_registerDexModule = (android.os.IBinder.FIRST_CALL_TRANSACTION + 114);
static final int TRANSACTION_performDexOptMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 115);
static final int TRANSACTION_performDexOptSecondary = (android.os.IBinder.FIRST_CALL_TRANSACTION + 116);
static final int TRANSACTION_dumpProfiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 117);
static final int TRANSACTION_forceDexOpt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 118);
static final int TRANSACTION_runBackgroundDexoptJob = (android.os.IBinder.FIRST_CALL_TRANSACTION + 119);
static final int TRANSACTION_reconcileSecondaryDexFiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 120);
static final int TRANSACTION_updateExternalMediaStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 121);
static final int TRANSACTION_nextPackageToClean = (android.os.IBinder.FIRST_CALL_TRANSACTION + 122);
static final int TRANSACTION_getMoveStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 123);
static final int TRANSACTION_registerMoveCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 124);
static final int TRANSACTION_unregisterMoveCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 125);
static final int TRANSACTION_movePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 126);
static final int TRANSACTION_movePrimaryStorage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 127);
static final int TRANSACTION_addPermissionAsync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 128);
static final int TRANSACTION_setInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 129);
static final int TRANSACTION_getInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 130);
static final int TRANSACTION_installExistingPackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 131);
static final int TRANSACTION_verifyPendingInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 132);
static final int TRANSACTION_extendVerificationTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 133);
static final int TRANSACTION_verifyIntentFilter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 134);
static final int TRANSACTION_getIntentVerificationStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 135);
static final int TRANSACTION_updateIntentVerificationStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 136);
static final int TRANSACTION_getIntentFilterVerifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 137);
static final int TRANSACTION_getAllIntentFilters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 138);
static final int TRANSACTION_setDefaultBrowserPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 139);
static final int TRANSACTION_getDefaultBrowserPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 140);
static final int TRANSACTION_getVerifierDeviceIdentity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 141);
static final int TRANSACTION_isFirstBoot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 142);
static final int TRANSACTION_isOnlyCoreApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 143);
static final int TRANSACTION_isUpgrade = (android.os.IBinder.FIRST_CALL_TRANSACTION + 144);
static final int TRANSACTION_setPermissionEnforced = (android.os.IBinder.FIRST_CALL_TRANSACTION + 145);
static final int TRANSACTION_isPermissionEnforced = (android.os.IBinder.FIRST_CALL_TRANSACTION + 146);
static final int TRANSACTION_isStorageLow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 147);
static final int TRANSACTION_setApplicationHiddenSettingAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 148);
static final int TRANSACTION_getApplicationHiddenSettingAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 149);
static final int TRANSACTION_getPackageInstaller = (android.os.IBinder.FIRST_CALL_TRANSACTION + 150);
static final int TRANSACTION_setBlockUninstallForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 151);
static final int TRANSACTION_getBlockUninstallForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 152);
static final int TRANSACTION_getKeySetByAlias = (android.os.IBinder.FIRST_CALL_TRANSACTION + 153);
static final int TRANSACTION_getSigningKeySet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 154);
static final int TRANSACTION_isPackageSignedByKeySet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 155);
static final int TRANSACTION_isPackageSignedByKeySetExactly = (android.os.IBinder.FIRST_CALL_TRANSACTION + 156);
static final int TRANSACTION_addOnPermissionsChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 157);
static final int TRANSACTION_removeOnPermissionsChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 158);
static final int TRANSACTION_grantDefaultPermissionsToEnabledCarrierApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 159);
static final int TRANSACTION_grantDefaultPermissionsToEnabledImsServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 160);
static final int TRANSACTION_isPermissionRevokedByPolicy = (android.os.IBinder.FIRST_CALL_TRANSACTION + 161);
static final int TRANSACTION_getPermissionControllerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 162);
static final int TRANSACTION_getInstantApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 163);
static final int TRANSACTION_getInstantAppCookie = (android.os.IBinder.FIRST_CALL_TRANSACTION + 164);
static final int TRANSACTION_setInstantAppCookie = (android.os.IBinder.FIRST_CALL_TRANSACTION + 165);
static final int TRANSACTION_getInstantAppIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 166);
static final int TRANSACTION_isInstantApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 167);
static final int TRANSACTION_setRequiredForSystemUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 168);
static final int TRANSACTION_setUpdateAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 169);
static final int TRANSACTION_getServicesSystemSharedLibraryPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 170);
static final int TRANSACTION_getSharedSystemSharedLibraryPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 171);
static final int TRANSACTION_getChangedPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 172);
static final int TRANSACTION_isPackageDeviceAdminOnAnyUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 173);
static final int TRANSACTION_getPreviousCodePaths = (android.os.IBinder.FIRST_CALL_TRANSACTION + 174);
static final int TRANSACTION_getInstallReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 175);
static final int TRANSACTION_getSharedLibraries = (android.os.IBinder.FIRST_CALL_TRANSACTION + 176);
static final int TRANSACTION_canRequestPackageInstalls = (android.os.IBinder.FIRST_CALL_TRANSACTION + 177);
static final int TRANSACTION_deletePreloadsFileCache = (android.os.IBinder.FIRST_CALL_TRANSACTION + 178);
static final int TRANSACTION_getInstantAppResolverComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 179);
static final int TRANSACTION_getInstantAppResolverSettingsComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 180);
static final int TRANSACTION_getInstantAppInstallerComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 181);
static final int TRANSACTION_getInstantAppAndroidId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 182);
}
public void checkPackageStartable(java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean isPackageAvailable(java.lang.String packageName, int userId) throws android.os.RemoteException;
public android.content.pm.PackageInfo getPackageInfo(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.PackageInfo getPackageInfoVersioned(android.content.pm.VersionedPackage versionedPackage, int flags, int userId) throws android.os.RemoteException;
public int getPackageUid(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException;
public int[] getPackageGids(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException;
public java.lang.String[] currentToCanonicalPackageNames(java.lang.String[] names) throws android.os.RemoteException;
public java.lang.String[] canonicalToCurrentPackageNames(java.lang.String[] names) throws android.os.RemoteException;
public android.content.pm.PermissionInfo getPermissionInfo(java.lang.String name, java.lang.String packageName, int flags) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryPermissionsByGroup(java.lang.String group, int flags) throws android.os.RemoteException;
public android.content.pm.PermissionGroupInfo getPermissionGroupInfo(java.lang.String name, int flags) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice getAllPermissionGroups(int flags) throws android.os.RemoteException;
public android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException;
public boolean activitySupportsIntent(android.content.ComponentName className, android.content.Intent intent, java.lang.String resolvedType) throws android.os.RemoteException;
public android.content.pm.ActivityInfo getReceiverInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ServiceInfo getServiceInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ProviderInfo getProviderInfo(android.content.ComponentName className, int flags, int userId) throws android.os.RemoteException;
public int checkPermission(java.lang.String permName, java.lang.String pkgName, int userId) throws android.os.RemoteException;
public int checkUidPermission(java.lang.String permName, int uid) throws android.os.RemoteException;
public boolean addPermission(android.content.pm.PermissionInfo info) throws android.os.RemoteException;
public void removePermission(java.lang.String name) throws android.os.RemoteException;
public void grantRuntimePermission(java.lang.String packageName, java.lang.String permissionName, int userId) throws android.os.RemoteException;
public void revokeRuntimePermission(java.lang.String packageName, java.lang.String permissionName, int userId) throws android.os.RemoteException;
public void resetRuntimePermissions() throws android.os.RemoteException;
public int getPermissionFlags(java.lang.String permissionName, java.lang.String packageName, int userId) throws android.os.RemoteException;
public void updatePermissionFlags(java.lang.String permissionName, java.lang.String packageName, int flagMask, int flagValues, int userId) throws android.os.RemoteException;
public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) throws android.os.RemoteException;
public boolean shouldShowRequestPermissionRationale(java.lang.String permissionName, java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean isProtectedBroadcast(java.lang.String actionName) throws android.os.RemoteException;
public int checkSignatures(java.lang.String pkg1, java.lang.String pkg2) throws android.os.RemoteException;
public int checkUidSignatures(int uid1, int uid2) throws android.os.RemoteException;
public java.util.List<java.lang.String> getAllPackages() throws android.os.RemoteException;
public java.lang.String[] getPackagesForUid(int uid) throws android.os.RemoteException;
public java.lang.String getNameForUid(int uid) throws android.os.RemoteException;
public java.lang.String[] getNamesForUids(int[] uids) throws android.os.RemoteException;
public int getUidForSharedUser(java.lang.String sharedUserName) throws android.os.RemoteException;
public int getFlagsForUid(int uid) throws android.os.RemoteException;
public int getPrivateFlagsForUid(int uid) throws android.os.RemoteException;
public boolean isUidPrivileged(int uid) throws android.os.RemoteException;
public java.lang.String[] getAppOpPermissionPackages(java.lang.String permissionName) throws android.os.RemoteException;
public android.content.pm.ResolveInfo resolveIntent(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ResolveInfo findPersistentPreferredActivity(android.content.Intent intent, int userId) throws android.os.RemoteException;
public boolean canForwardTo(android.content.Intent intent, java.lang.String resolvedType, int sourceUserId, int targetUserId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryIntentActivities(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryIntentActivityOptions(android.content.ComponentName caller, android.content.Intent[] specifics, java.lang.String[] specificTypes, android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryIntentReceivers(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ResolveInfo resolveService(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryIntentServices(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryIntentContentProviders(android.content.Intent intent, java.lang.String resolvedType, int flags, int userId) throws android.os.RemoteException;
/**
     * This implements getInstalledPackages via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
public android.content.pm.ParceledListSlice getInstalledPackages(int flags, int userId) throws android.os.RemoteException;
/**
     * This implements getPackagesHoldingPermissions via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
public android.content.pm.ParceledListSlice getPackagesHoldingPermissions(java.lang.String[] permissions, int flags, int userId) throws android.os.RemoteException;
/**
     * This implements getInstalledApplications via a "last returned row"
     * mechanism that is not exposed in the API. This is to get around the IPC
     * limit that kicks in when flags are included that bloat up the data
     * returned.
     */
public android.content.pm.ParceledListSlice getInstalledApplications(int flags, int userId) throws android.os.RemoteException;
/**
     * Retrieve all applications that are marked as persistent.
     *
     * @return A List&lt;applicationInfo> containing one entry for each persistent
     *         application.
     */
public android.content.pm.ParceledListSlice getPersistentApplications(int flags) throws android.os.RemoteException;
public android.content.pm.ProviderInfo resolveContentProvider(java.lang.String name, int flags, int userId) throws android.os.RemoteException;
/**
     * Retrieve sync information for all content providers.
     *
     * @param outNames Filled in with a list of the root names of the content
     *                 providers that can sync.
     * @param outInfo Filled in with a list of the ProviderInfo for each
     *                name in 'outNames'.
     */
public void querySyncProviders(java.util.List<java.lang.String> outNames, java.util.List<android.content.pm.ProviderInfo> outInfo) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryContentProviders(java.lang.String processName, int uid, int flags, java.lang.String metaDataKey) throws android.os.RemoteException;
public android.content.pm.InstrumentationInfo getInstrumentationInfo(android.content.ComponentName className, int flags) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice queryInstrumentation(java.lang.String targetPackage, int flags) throws android.os.RemoteException;
/** @deprecated Use PackageInstaller instead */
public void installPackageAsUser(java.lang.String originPath, android.content.pm.IPackageInstallObserver2 observer, int flags, java.lang.String installerPackageName, int userId) throws android.os.RemoteException;
public void finishPackageInstall(int token, boolean didLaunch) throws android.os.RemoteException;
public void setInstallerPackageName(java.lang.String targetPackage, java.lang.String installerPackageName) throws android.os.RemoteException;
public void setApplicationCategoryHint(java.lang.String packageName, int categoryHint, java.lang.String callerPackageName) throws android.os.RemoteException;
/** @deprecated rawr, don't call AIDL methods directly! */
public void deletePackageAsUser(java.lang.String packageName, int versionCode, android.content.pm.IPackageDeleteObserver observer, int userId, int flags) throws android.os.RemoteException;
/**
     * Delete a package for a specific user.
     *
     * @param versionedPackage The package to delete.
     * @param observer a callback to use to notify when the package deletion in finished.
     * @param userId the id of the user for whom to delete the package
     * @param flags - possible values: {@link #DONT_DELETE_DATA}
     */
public void deletePackageVersioned(android.content.pm.VersionedPackage versionedPackage, android.content.pm.IPackageDeleteObserver2 observer, int userId, int flags) throws android.os.RemoteException;
public java.lang.String getInstallerPackageName(java.lang.String packageName) throws android.os.RemoteException;
public void resetApplicationPreferences(int userId) throws android.os.RemoteException;
public android.content.pm.ResolveInfo getLastChosenActivity(android.content.Intent intent, java.lang.String resolvedType, int flags) throws android.os.RemoteException;
public void setLastChosenActivity(android.content.Intent intent, java.lang.String resolvedType, int flags, android.content.IntentFilter filter, int match, android.content.ComponentName activity) throws android.os.RemoteException;
public void addPreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity, int userId) throws android.os.RemoteException;
public void replacePreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity, int userId) throws android.os.RemoteException;
public void clearPackagePreferredActivities(java.lang.String packageName) throws android.os.RemoteException;
public int getPreferredActivities(java.util.List<android.content.IntentFilter> outFilters, java.util.List<android.content.ComponentName> outActivities, java.lang.String packageName) throws android.os.RemoteException;
public void addPersistentPreferredActivity(android.content.IntentFilter filter, android.content.ComponentName activity, int userId) throws android.os.RemoteException;
public void clearPackagePersistentPreferredActivities(java.lang.String packageName, int userId) throws android.os.RemoteException;
public void addCrossProfileIntentFilter(android.content.IntentFilter intentFilter, java.lang.String ownerPackage, int sourceUserId, int targetUserId, int flags) throws android.os.RemoteException;
public void clearCrossProfileIntentFilters(int sourceUserId, java.lang.String ownerPackage) throws android.os.RemoteException;
public java.lang.String[] setPackagesSuspendedAsUser(java.lang.String[] packageNames, boolean suspended, int userId) throws android.os.RemoteException;
public boolean isPackageSuspendedForUser(java.lang.String packageName, int userId) throws android.os.RemoteException;
/**
     * Backup/restore support - only the system uid may use these.
     */
public byte[] getPreferredActivityBackup(int userId) throws android.os.RemoteException;
public void restorePreferredActivities(byte[] backup, int userId) throws android.os.RemoteException;
public byte[] getDefaultAppsBackup(int userId) throws android.os.RemoteException;
public void restoreDefaultApps(byte[] backup, int userId) throws android.os.RemoteException;
public byte[] getIntentFilterVerificationBackup(int userId) throws android.os.RemoteException;
public void restoreIntentFilterVerification(byte[] backup, int userId) throws android.os.RemoteException;
public byte[] getPermissionGrantBackup(int userId) throws android.os.RemoteException;
public void restorePermissionGrants(byte[] backup, int userId) throws android.os.RemoteException;
/**
     * Report the set of 'Home' activity candidates, plus (if any) which of them
     * is the current "always use this one" setting.
     */
public android.content.ComponentName getHomeActivities(java.util.List<android.content.pm.ResolveInfo> outHomeCandidates) throws android.os.RemoteException;
public void setHomeActivity(android.content.ComponentName className, int userId) throws android.os.RemoteException;
/**
     * As per {@link android.content.pm.PackageManager#setComponentEnabledSetting}.
     */
public void setComponentEnabledSetting(android.content.ComponentName componentName, int newState, int flags, int userId) throws android.os.RemoteException;
public int getComponentEnabledSetting(android.content.ComponentName componentName, int userId) throws android.os.RemoteException;
/**
     * As per {@link android.content.pm.PackageManager#setApplicationEnabledSetting}.
     */
public void setApplicationEnabledSetting(java.lang.String packageName, int newState, int flags, int userId, java.lang.String callingPackage) throws android.os.RemoteException;
public int getApplicationEnabledSetting(java.lang.String packageName, int userId) throws android.os.RemoteException;
/**
     * Logs process start information (including APK hash) to the security log.
     */
public void logAppProcessStartIfNeeded(java.lang.String processName, int uid, java.lang.String seinfo, java.lang.String apkFile, int pid) throws android.os.RemoteException;
/**
     * As per {@link android.content.pm.PackageManager#flushPackageRestrictionsAsUser}.
     */
public void flushPackageRestrictionsAsUser(int userId) throws android.os.RemoteException;
/**
     * Set whether the given package should be considered stopped, making
     * it not visible to implicit intents that filter out stopped packages.
     */
public void setPackageStoppedState(java.lang.String packageName, boolean stopped, int userId) throws android.os.RemoteException;
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param observer call back used to notify when
     * the operation is completed
     */
public void freeStorageAndNotify(java.lang.String volumeUuid, long freeStorageSize, int storageFlags, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;
/**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param pi IntentSender call back used to
     * notify when the operation is completed.May be null
     * to indicate that no call back is desired.
     */
public void freeStorage(java.lang.String volumeUuid, long freeStorageSize, int storageFlags, android.content.IntentSender pi) throws android.os.RemoteException;
/**
     * Delete all the cache files in an applications cache directory
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the deletion is finished.
     */
public void deleteApplicationCacheFiles(java.lang.String packageName, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;
/**
     * Delete all the cache files in an applications cache directory
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param userId the user to delete application cache for
     * @param observer a callback used to notify when the deletion is finished.
     */
public void deleteApplicationCacheFilesAsUser(java.lang.String packageName, int userId, android.content.pm.IPackageDataObserver observer) throws android.os.RemoteException;
/**
     * Clear the user data directory of an application.
     * @param packageName The package name of the application whose cache
     * files need to be deleted
     * @param observer a callback used to notify when the operation is completed.
     */
public void clearApplicationUserData(java.lang.String packageName, android.content.pm.IPackageDataObserver observer, int userId) throws android.os.RemoteException;
/**
     * Clear the profile data of an application.
     * @param packageName The package name of the application whose profile data
     * need to be deleted
     */
public void clearApplicationProfileData(java.lang.String packageName) throws android.os.RemoteException;
/**
     * Get package statistics including the code, data and cache size for
     * an already installed package
     * @param packageName The package name of the application
     * @param userHandle Which user the size should be retrieved for
     * @param observer a callback to use to notify when the asynchronous
     * retrieval of information is complete.
     */
public void getPackageSizeInfo(java.lang.String packageName, int userHandle, android.content.pm.IPackageStatsObserver observer) throws android.os.RemoteException;
public java.lang.String[] getSystemSharedLibraryNames() throws android.os.RemoteException;
/**
     * Get a list of features that are available on the
     * system.
     */
public android.content.pm.ParceledListSlice getSystemAvailableFeatures() throws android.os.RemoteException;
public boolean hasSystemFeature(java.lang.String name, int version) throws android.os.RemoteException;
public void enterSafeMode() throws android.os.RemoteException;
public boolean isSafeMode() throws android.os.RemoteException;
public void systemReady() throws android.os.RemoteException;
public boolean hasSystemUidErrors() throws android.os.RemoteException;
/**
     * Ask the package manager to fstrim the disk if needed.
     */
public void performFstrimIfNeeded() throws android.os.RemoteException;
/**
     * Ask the package manager to update packages if needed.
     */
public void updatePackagesIfNeeded() throws android.os.RemoteException;
/**
     * Notify the package manager that a package is going to be used and why.
     *
     * See PackageManager.NOTIFY_PACKAGE_USE_* for reasons.
     */
public void notifyPackageUse(java.lang.String packageName, int reason) throws android.os.RemoteException;
/**
     * Notify the package manager that a list of dex files have been loaded.
     *
     * @param loadingPackageName the name of the package who performs the load
     * @param classLoadersNames the names of the class loaders present in the loading chain. The
     *    list encodes the class loader chain in the natural order. The first class loader has
     *    the second one as its parent and so on. The dex files present in the class path of the
     *    first class loader will be recorded in the usage file.
     * @param classPaths the class paths corresponding to the class loaders names from
     *     {@param classLoadersNames}. The the first element corresponds to the first class loader
     *     and so on. A classpath is represented as a list of dex files separated by
     *     {@code File.pathSeparator}.
     *     The dex files found in the first class path will be recorded in the usage file.
     * @param loaderIsa the ISA of the loader process
     */
public void notifyDexLoad(java.lang.String loadingPackageName, java.util.List<java.lang.String> classLoadersNames, java.util.List<java.lang.String> classPaths, java.lang.String loaderIsa) throws android.os.RemoteException;
/**
     * Register an application dex module with the package manager.
     * The package manager will keep track of the given module for future optimizations.
     *
     * Dex module optimizations will disable the classpath checking at runtime. The client bares
     * the responsibility to ensure that the static assumptions on classes in the optimized code
     * hold at runtime (e.g. there's no duplicate classes in the classpath).
     *
     * Note that the package manager already keeps track of dex modules loaded with
     * {@link dalvik.system.DexClassLoader} and {@link dalvik.system.PathClassLoader}.
     * This can be called for an eager registration.
     *
     * The call might take a while and the results will be posted on the main thread, using
     * the given callback.
     *
     * If the module is intended to be shared with other apps, make sure that the file
     * permissions allow for it.
     * If at registration time the permissions allow for others to read it, the module would
     * be marked as a shared module which might undergo a different optimization strategy.
     * (usually shared modules will generated larger optimizations artifacts,
     * taking more disk space).
     *
     * @param packageName the package name to which the dex module belongs
     * @param dexModulePath the absolute path of the dex module.
     * @param isSharedModule whether or not the module is intended to be used by other apps.
     * @param callback if not null,
     *   {@link android.content.pm.IDexModuleRegisterCallback.IDexModuleRegisterCallback#onDexModuleRegistered}
     *   will be called once the registration finishes.
     */
public void registerDexModule(java.lang.String packageName, java.lang.String dexModulePath, boolean isSharedModule, android.content.pm.IDexModuleRegisterCallback callback) throws android.os.RemoteException;
/**
     * Ask the package manager to perform a dex-opt with the given compiler filter.
     *
     * Note: exposed only for the shell command to allow moving packages explicitly to a
     *       definite state.
     */
public boolean performDexOptMode(java.lang.String packageName, boolean checkProfiles, java.lang.String targetCompilerFilter, boolean force, boolean bootComplete, java.lang.String splitName) throws android.os.RemoteException;
/**
     * Ask the package manager to perform a dex-opt with the given compiler filter on the
     * secondary dex files belonging to the given package.
     *
     * Note: exposed only for the shell command to allow moving packages explicitly to a
     *       definite state.
     */
public boolean performDexOptSecondary(java.lang.String packageName, java.lang.String targetCompilerFilter, boolean force) throws android.os.RemoteException;
/**
     * Ask the package manager to dump profiles associated with a package.
     */
public void dumpProfiles(java.lang.String packageName) throws android.os.RemoteException;
public void forceDexOpt(java.lang.String packageName) throws android.os.RemoteException;
/**
     * Execute the background dexopt job immediately.
     */
public boolean runBackgroundDexoptJob() throws android.os.RemoteException;
/**
     * Reconcile the information we have about the secondary dex files belonging to
     * {@code packagName} and the actual dex files. For all dex files that were
     * deleted, update the internal records and delete the generated oat files.
     */
public void reconcileSecondaryDexFiles(java.lang.String packageName) throws android.os.RemoteException;
/**
     * Update status of external media on the package manager to scan and
     * install packages installed on the external media. Like say the
     * StorageManagerService uses this to call into the package manager to update
     * status of sdcard.
     */
public void updateExternalMediaStatus(boolean mounted, boolean reportStatus) throws android.os.RemoteException;
public android.content.pm.PackageCleanItem nextPackageToClean(android.content.pm.PackageCleanItem lastPackage) throws android.os.RemoteException;
public int getMoveStatus(int moveId) throws android.os.RemoteException;
public void registerMoveCallback(android.content.pm.IPackageMoveObserver callback) throws android.os.RemoteException;
public void unregisterMoveCallback(android.content.pm.IPackageMoveObserver callback) throws android.os.RemoteException;
public int movePackage(java.lang.String packageName, java.lang.String volumeUuid) throws android.os.RemoteException;
public int movePrimaryStorage(java.lang.String volumeUuid) throws android.os.RemoteException;
public boolean addPermissionAsync(android.content.pm.PermissionInfo info) throws android.os.RemoteException;
public boolean setInstallLocation(int loc) throws android.os.RemoteException;
public int getInstallLocation() throws android.os.RemoteException;
public int installExistingPackageAsUser(java.lang.String packageName, int userId, int installFlags, int installReason) throws android.os.RemoteException;
public void verifyPendingInstall(int id, int verificationCode) throws android.os.RemoteException;
public void extendVerificationTimeout(int id, int verificationCodeAtTimeout, long millisecondsToDelay) throws android.os.RemoteException;
public void verifyIntentFilter(int id, int verificationCode, java.util.List<java.lang.String> failedDomains) throws android.os.RemoteException;
public int getIntentVerificationStatus(java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean updateIntentVerificationStatus(java.lang.String packageName, int status, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice getIntentFilterVerifications(java.lang.String packageName) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice getAllIntentFilters(java.lang.String packageName) throws android.os.RemoteException;
public boolean setDefaultBrowserPackageName(java.lang.String packageName, int userId) throws android.os.RemoteException;
public java.lang.String getDefaultBrowserPackageName(int userId) throws android.os.RemoteException;
public android.content.pm.VerifierDeviceIdentity getVerifierDeviceIdentity() throws android.os.RemoteException;
public boolean isFirstBoot() throws android.os.RemoteException;
public boolean isOnlyCoreApps() throws android.os.RemoteException;
public boolean isUpgrade() throws android.os.RemoteException;
public void setPermissionEnforced(java.lang.String permission, boolean enforced) throws android.os.RemoteException;
public boolean isPermissionEnforced(java.lang.String permission) throws android.os.RemoteException;
/** Reflects current DeviceStorageMonitorService state */
public boolean isStorageLow() throws android.os.RemoteException;
public boolean setApplicationHiddenSettingAsUser(java.lang.String packageName, boolean hidden, int userId) throws android.os.RemoteException;
public boolean getApplicationHiddenSettingAsUser(java.lang.String packageName, int userId) throws android.os.RemoteException;
public android.content.pm.IPackageInstaller getPackageInstaller() throws android.os.RemoteException;
public boolean setBlockUninstallForUser(java.lang.String packageName, boolean blockUninstall, int userId) throws android.os.RemoteException;
public boolean getBlockUninstallForUser(java.lang.String packageName, int userId) throws android.os.RemoteException;
public android.content.pm.KeySet getKeySetByAlias(java.lang.String packageName, java.lang.String alias) throws android.os.RemoteException;
public android.content.pm.KeySet getSigningKeySet(java.lang.String packageName) throws android.os.RemoteException;
public boolean isPackageSignedByKeySet(java.lang.String packageName, android.content.pm.KeySet ks) throws android.os.RemoteException;
public boolean isPackageSignedByKeySetExactly(java.lang.String packageName, android.content.pm.KeySet ks) throws android.os.RemoteException;
public void addOnPermissionsChangeListener(android.content.pm.IOnPermissionsChangeListener listener) throws android.os.RemoteException;
public void removeOnPermissionsChangeListener(android.content.pm.IOnPermissionsChangeListener listener) throws android.os.RemoteException;
public void grantDefaultPermissionsToEnabledCarrierApps(java.lang.String[] packageNames, int userId) throws android.os.RemoteException;
public void grantDefaultPermissionsToEnabledImsServices(java.lang.String[] packageNames, int userId) throws android.os.RemoteException;
public boolean isPermissionRevokedByPolicy(java.lang.String permission, java.lang.String packageName, int userId) throws android.os.RemoteException;
public java.lang.String getPermissionControllerPackageName() throws android.os.RemoteException;
public android.content.pm.ParceledListSlice getInstantApps(int userId) throws android.os.RemoteException;
public byte[] getInstantAppCookie(java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean setInstantAppCookie(java.lang.String packageName, byte[] cookie, int userId) throws android.os.RemoteException;
public android.graphics.Bitmap getInstantAppIcon(java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean isInstantApp(java.lang.String packageName, int userId) throws android.os.RemoteException;
public boolean setRequiredForSystemUser(java.lang.String packageName, boolean systemUserApp) throws android.os.RemoteException;
/**
     * Sets whether or not an update is available. Ostensibly for instant apps
     * to force exteranl resolution.
     */
public void setUpdateAvailable(java.lang.String packageName, boolean updateAvaialble) throws android.os.RemoteException;
public java.lang.String getServicesSystemSharedLibraryPackageName() throws android.os.RemoteException;
public java.lang.String getSharedSystemSharedLibraryPackageName() throws android.os.RemoteException;
public android.content.pm.ChangedPackages getChangedPackages(int sequenceNumber, int userId) throws android.os.RemoteException;
public boolean isPackageDeviceAdminOnAnyUser(java.lang.String packageName) throws android.os.RemoteException;
public java.util.List<java.lang.String> getPreviousCodePaths(java.lang.String packageName) throws android.os.RemoteException;
public int getInstallReason(java.lang.String packageName, int userId) throws android.os.RemoteException;
public android.content.pm.ParceledListSlice getSharedLibraries(java.lang.String packageName, int flags, int userId) throws android.os.RemoteException;
public boolean canRequestPackageInstalls(java.lang.String packageName, int userId) throws android.os.RemoteException;
public void deletePreloadsFileCache() throws android.os.RemoteException;
public android.content.ComponentName getInstantAppResolverComponent() throws android.os.RemoteException;
public android.content.ComponentName getInstantAppResolverSettingsComponent() throws android.os.RemoteException;
public android.content.ComponentName getInstantAppInstallerComponent() throws android.os.RemoteException;
public java.lang.String getInstantAppAndroidId(java.lang.String packageName, int userId) throws android.os.RemoteException;
}
