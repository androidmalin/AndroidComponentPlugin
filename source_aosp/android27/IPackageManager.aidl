<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta name="robots" content="noindex,nofollow" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="generator" content="0.11.1 (2b48ae40ea1b)" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<link rel="icon" href="/8.1.0_r33/default/img/icon.png" type="image/png" />
<link rel="stylesheet" type="text/css" media="all"
    title="Default" href="/8.1.0_r33/default/style.css" />
<link rel="alternate stylesheet" type="text/css" media="all"
    title="Paper White" href="/8.1.0_r33/default/print.css" />
<link rel="stylesheet" type="text/css" href="/8.1.0_r33/default/print.css" media="print" />
<link rel="stylesheet" type="text/css" href="/8.1.0_r33/default/jquery.tooltip.css" />

<link rel="search" href="/8.1.0_r33/opensearch"
    type="application/opensearchdescription+xml"
    title="OpenGrok Search for current project(s)" />
<script type="text/javascript" src="/8.1.0_r33/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/8.1.0_r33/jquery.tooltip-1.3.pack.js"></script>

<script type="text/javascript" src="/8.1.0_r33/utils.js"></script>
<title>Cross Reference: /frameworks/base/core/java/android/content/pm/IPackageManager.aidl</title>
    <script type="text/javascript">
      var _gaq = _gaq || [];
      var pluginUrl = 
      '//www.google-analytics.com/plugins/ga/inpage_linkid.js';
      _gaq.push(['_require', 'inpage_linkid', pluginUrl]);
      _gaq.push(['_setAccount', 'UA-37941318-1']);
      _gaq.push(['_setDomainName', 'androidxref.com']);
      _gaq.push(['_trackPageview']);
      
      (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();      
    </script>
</head><body>
<script type="text/javascript">/* <![CDATA[ */
    document.hash = 'null';document.rev = '';document.link = '/8.1.0_r33/xref/frameworks/base/core/java/android/content/pm/IPackageManager.aidl';document.annotate = false;
    document.domReady.push(function() {domReadyMast();});
    document.pageReady.push(function() { pageReadyMast();});
/* ]]> */</script>
<div id="page">
    <div id="whole_header">
        <form action="/8.1.0_r33/search">
<div id="header">
<a href="/8.1.0_r33/"><span id="MastheadLogo"></span></a>



    <div id="pagetitle"><span id="filename"
                    >Cross Reference: IPackageManager.aidl</span></div>
</div>
<div id="Masthead">
    <tt><a href="/8.1.0_r33/xref/">xref</a>: /<a href="/8.1.0_r33/xref/frameworks/">frameworks</a>/<a href="/8.1.0_r33/xref/frameworks/base/">base</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/">core</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/java/">java</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/java/android/">android</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/java/android/content/">content</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/java/android/content/pm/">pm</a>/<a href="/8.1.0_r33/xref/frameworks/base/core/java/android/content/pm/IPackageManager.aidl">IPackageManager.aidl</a></tt>
</div>
<div id="bar">
    <ul>
        <li><a href="/8.1.0_r33/"><span id="home"></span>Home</a></li><li><a href="/8.1.0_r33/history/frameworks/base/core/java/android/content/pm/IPackageManager.aidl"><span id="history"></span>History</a></li><li><a href="#" onclick="javascript:get_annotations(); return false;"
            ><span class="annotate"></span>Annotate</a></li><li><a href="#" onclick="javascript:lntoggle();return false;"
            title="Show or hide line numbers (might be slower if file has more than 10 000 lines)."><span id="line"></span>Line#</a></li><li><a
            href="#" onclick="javascript:lsttoggle();return false;"
            title="Show or hide symbol list."><span id="defbox"></span>Navigate</a></li><li><a href="/8.1.0_r33/raw/frameworks/base/core/java/android/content/pm/IPackageManager.aidl"><span id="download"></span>Download</a></li><li><input type="text" id="search" name="q" class="q" />
            <input type="submit" value="Search" class="submit" /></li><li><input type="checkbox" name="path" value="/frameworks/base/core/java/android/content/pm/" /> only in <b>IPackageManager.aidl</b></li>
        
    </ul>
    <input type="hidden" name="project" value="frameworks" />
</div>
        </form>
    </div>
<div id="content">
<script type="text/javascript">/* <![CDATA[ */
document.pageReady.push(function() { pageReadyList();});
/* ]]> */</script>

<div id="src">
    <pre><script type="text/javascript">/* <![CDATA[ */
function get_sym_list(){return [];} /* ]]> */</script><a class="l" name="1" href="#1">1</a><span class="c">/*
<a class="l" name="2" href="#2">2</a>**
<a class="l" name="3" href="#3">3</a>** Copyright 2007, The Android Open Source Project
<a class="l" name="4" href="#4">4</a>**
<a class="l" name="5" href="#5">5</a>** Licensed under the Apache License, Version 2.0 (the "License");
<a class="l" name="6" href="#6">6</a>** you may not use this file except in compliance with the License.
<a class="l" name="7" href="#7">7</a>** You may obtain a copy of the License at
<a class="l" name="8" href="#8">8</a>**
<a class="l" name="9" href="#9">9</a>**     <a href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a>
<a class="hl" name="10" href="#10">10</a>**
<a class="l" name="11" href="#11">11</a>** Unless required by applicable law or agreed to in writing, software
<a class="l" name="12" href="#12">12</a>** distributed under the License is distributed on an "AS IS" BASIS,
<a class="l" name="13" href="#13">13</a>** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
<a class="l" name="14" href="#14">14</a>** See the License for the specific language governing permissions and
<a class="l" name="15" href="#15">15</a>** limitations under the License.
<a class="l" name="16" href="#16">16</a>*/</span>
<a class="l" name="17" href="#17">17</a>
<a class="l" name="18" href="#18">18</a><b>package</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>;
<a class="l" name="19" href="#19">19</a>
<a class="hl" name="20" href="#20">20</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a>;
<a class="l" name="21" href="#21">21</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a>;
<a class="l" name="22" href="#22">22</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a>;
<a class="l" name="23" href="#23">23</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ActivityInfo&amp;project=frameworks">ActivityInfo</a>;
<a class="l" name="24" href="#24">24</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ApplicationInfo&amp;project=frameworks">ApplicationInfo</a>;
<a class="l" name="25" href="#25">25</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ChangedPackages&amp;project=frameworks">ChangedPackages</a>;
<a class="l" name="26" href="#26">26</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=InstantAppInfo&amp;project=frameworks">InstantAppInfo</a>;
<a class="l" name="27" href="#27">27</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=FeatureInfo&amp;project=frameworks">FeatureInfo</a>;
<a class="l" name="28" href="#28">28</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IDexModuleRegisterCallback&amp;project=frameworks">IDexModuleRegisterCallback</a>;
<a class="l" name="29" href="#29">29</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageInstallObserver2&amp;project=frameworks">IPackageInstallObserver2</a>;
<a class="hl" name="30" href="#30">30</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageInstaller&amp;project=frameworks">IPackageInstaller</a>;
<a class="l" name="31" href="#31">31</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageDeleteObserver&amp;project=frameworks">IPackageDeleteObserver</a>;
<a class="l" name="32" href="#32">32</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageDeleteObserver2&amp;project=frameworks">IPackageDeleteObserver2</a>;
<a class="l" name="33" href="#33">33</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageDataObserver&amp;project=frameworks">IPackageDataObserver</a>;
<a class="l" name="34" href="#34">34</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageMoveObserver&amp;project=frameworks">IPackageMoveObserver</a>;
<a class="l" name="35" href="#35">35</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IPackageStatsObserver&amp;project=frameworks">IPackageStatsObserver</a>;
<a class="l" name="36" href="#36">36</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IOnPermissionsChangeListener&amp;project=frameworks">IOnPermissionsChangeListener</a>;
<a class="l" name="37" href="#37">37</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=IntentFilterVerificationInfo&amp;project=frameworks">IntentFilterVerificationInfo</a>;
<a class="l" name="38" href="#38">38</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=InstrumentationInfo&amp;project=frameworks">InstrumentationInfo</a>;
<a class="l" name="39" href="#39">39</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=KeySet&amp;project=frameworks">KeySet</a>;
<a class="hl" name="40" href="#40">40</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=PackageInfo&amp;project=frameworks">PackageInfo</a>;
<a class="l" name="41" href="#41">41</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=PackageCleanItem&amp;project=frameworks">PackageCleanItem</a>;
<a class="l" name="42" href="#42">42</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a>;
<a class="l" name="43" href="#43">43</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ProviderInfo&amp;project=frameworks">ProviderInfo</a>;
<a class="l" name="44" href="#44">44</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=PermissionGroupInfo&amp;project=frameworks">PermissionGroupInfo</a>;
<a class="l" name="45" href="#45">45</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=PermissionInfo&amp;project=frameworks">PermissionInfo</a>;
<a class="l" name="46" href="#46">46</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a>;
<a class="l" name="47" href="#47">47</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=ServiceInfo&amp;project=frameworks">ServiceInfo</a>;
<a class="l" name="48" href="#48">48</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=UserInfo&amp;project=frameworks">UserInfo</a>;
<a class="l" name="49" href="#49">49</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=VerifierDeviceIdentity&amp;project=frameworks">VerifierDeviceIdentity</a>;
<a class="hl" name="50" href="#50">50</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=pm&amp;project=frameworks">pm</a>.<a href="/8.1.0_r33/s?defs=VersionedPackage&amp;project=frameworks">VersionedPackage</a>;
<a class="l" name="51" href="#51">51</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=graphics&amp;project=frameworks">graphics</a>.<a href="/8.1.0_r33/s?defs=Bitmap&amp;project=frameworks">Bitmap</a>;
<a class="l" name="52" href="#52">52</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=net&amp;project=frameworks">net</a>.<a href="/8.1.0_r33/s?defs=Uri&amp;project=frameworks">Uri</a>;
<a class="l" name="53" href="#53">53</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=os&amp;project=frameworks">os</a>.<a href="/8.1.0_r33/s?defs=Bundle&amp;project=frameworks">Bundle</a>;
<a class="l" name="54" href="#54">54</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=os&amp;project=frameworks">os</a>.<a href="/8.1.0_r33/s?defs=ParcelFileDescriptor&amp;project=frameworks">ParcelFileDescriptor</a>;
<a class="l" name="55" href="#55">55</a><b>import</b> <a href="/8.1.0_r33/s?defs=android&amp;project=frameworks">android</a>.<a href="/8.1.0_r33/s?defs=content&amp;project=frameworks">content</a>.<a href="/8.1.0_r33/s?defs=IntentSender&amp;project=frameworks">IntentSender</a>;
<a class="l" name="56" href="#56">56</a>
<a class="l" name="57" href="#57">57</a><span class="c">/**
<a class="l" name="58" href="#58">58</a> *  See {<strong>@link</strong> PackageManager} for documentation on most of the APIs
<a class="l" name="59" href="#59">59</a> *  here.
<a class="hl" name="60" href="#60">60</a> *
<a class="l" name="61" href="#61">61</a> *  {<strong>@hide</strong>}
<a class="l" name="62" href="#62">62</a> */</span>
<a class="l" name="63" href="#63">63</a><b>interface</b> <a href="/8.1.0_r33/s?defs=IPackageManager&amp;project=frameworks">IPackageManager</a> {
<a class="l" name="64" href="#64">64</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=checkPackageStartable&amp;project=frameworks">checkPackageStartable</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="65" href="#65">65</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPackageAvailable&amp;project=frameworks">isPackageAvailable</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="66" href="#66">66</a>    <a href="/8.1.0_r33/s?defs=PackageInfo&amp;project=frameworks">PackageInfo</a> <a href="/8.1.0_r33/s?defs=getPackageInfo&amp;project=frameworks">getPackageInfo</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="67" href="#67">67</a>    <a href="/8.1.0_r33/s?defs=PackageInfo&amp;project=frameworks">PackageInfo</a> <a href="/8.1.0_r33/s?defs=getPackageInfoVersioned&amp;project=frameworks">getPackageInfoVersioned</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=VersionedPackage&amp;project=frameworks">VersionedPackage</a> <a href="/8.1.0_r33/s?defs=versionedPackage&amp;project=frameworks">versionedPackage</a>,
<a class="l" name="68" href="#68">68</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="69" href="#69">69</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getPackageUid&amp;project=frameworks">getPackageUid</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="hl" name="70" href="#70">70</a>    <b>int</b>[] <a href="/8.1.0_r33/s?defs=getPackageGids&amp;project=frameworks">getPackageGids</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="71" href="#71">71</a>
<a class="l" name="72" href="#72">72</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=currentToCanonicalPackageNames&amp;project=frameworks">currentToCanonicalPackageNames</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=names&amp;project=frameworks">names</a>);
<a class="l" name="73" href="#73">73</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=canonicalToCurrentPackageNames&amp;project=frameworks">canonicalToCurrentPackageNames</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=names&amp;project=frameworks">names</a>);
<a class="l" name="74" href="#74">74</a>
<a class="l" name="75" href="#75">75</a>    <a href="/8.1.0_r33/s?defs=PermissionInfo&amp;project=frameworks">PermissionInfo</a> <a href="/8.1.0_r33/s?defs=getPermissionInfo&amp;project=frameworks">getPermissionInfo</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=name&amp;project=frameworks">name</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="76" href="#76">76</a>
<a class="l" name="77" href="#77">77</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryPermissionsByGroup&amp;project=frameworks">queryPermissionsByGroup</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=group&amp;project=frameworks">group</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="78" href="#78">78</a>
<a class="l" name="79" href="#79">79</a>    <a href="/8.1.0_r33/s?defs=PermissionGroupInfo&amp;project=frameworks">PermissionGroupInfo</a> <a href="/8.1.0_r33/s?defs=getPermissionGroupInfo&amp;project=frameworks">getPermissionGroupInfo</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=name&amp;project=frameworks">name</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="hl" name="80" href="#80">80</a>
<a class="l" name="81" href="#81">81</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getAllPermissionGroups&amp;project=frameworks">getAllPermissionGroups</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="82" href="#82">82</a>
<a class="l" name="83" href="#83">83</a>    <a href="/8.1.0_r33/s?defs=ApplicationInfo&amp;project=frameworks">ApplicationInfo</a> <a href="/8.1.0_r33/s?defs=getApplicationInfo&amp;project=frameworks">getApplicationInfo</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a> ,<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="84" href="#84">84</a>
<a class="l" name="85" href="#85">85</a>    <a href="/8.1.0_r33/s?defs=ActivityInfo&amp;project=frameworks">ActivityInfo</a> <a href="/8.1.0_r33/s?defs=getActivityInfo&amp;project=frameworks">getActivityInfo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="86" href="#86">86</a>
<a class="l" name="87" href="#87">87</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=activitySupportsIntent&amp;project=frameworks">activitySupportsIntent</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="88" href="#88">88</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>);
<a class="l" name="89" href="#89">89</a>
<a class="hl" name="90" href="#90">90</a>    <a href="/8.1.0_r33/s?defs=ActivityInfo&amp;project=frameworks">ActivityInfo</a> <a href="/8.1.0_r33/s?defs=getReceiverInfo&amp;project=frameworks">getReceiverInfo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="91" href="#91">91</a>
<a class="l" name="92" href="#92">92</a>    <a href="/8.1.0_r33/s?defs=ServiceInfo&amp;project=frameworks">ServiceInfo</a> <a href="/8.1.0_r33/s?defs=getServiceInfo&amp;project=frameworks">getServiceInfo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="93" href="#93">93</a>
<a class="l" name="94" href="#94">94</a>    <a href="/8.1.0_r33/s?defs=ProviderInfo&amp;project=frameworks">ProviderInfo</a> <a href="/8.1.0_r33/s?defs=getProviderInfo&amp;project=frameworks">getProviderInfo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="95" href="#95">95</a>
<a class="l" name="96" href="#96">96</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=checkPermission&amp;project=frameworks">checkPermission</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permName&amp;project=frameworks">permName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=pkgName&amp;project=frameworks">pkgName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="97" href="#97">97</a>
<a class="l" name="98" href="#98">98</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=checkUidPermission&amp;project=frameworks">checkUidPermission</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permName&amp;project=frameworks">permName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="l" name="99" href="#99">99</a>
<a class="hl" name="100" href="#100">100</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=addPermission&amp;project=frameworks">addPermission</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=PermissionInfo&amp;project=frameworks">PermissionInfo</a> <a href="/8.1.0_r33/s?defs=info&amp;project=frameworks">info</a>);
<a class="l" name="101" href="#101">101</a>
<a class="l" name="102" href="#102">102</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=removePermission&amp;project=frameworks">removePermission</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=name&amp;project=frameworks">name</a>);
<a class="l" name="103" href="#103">103</a>
<a class="l" name="104" href="#104">104</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=grantRuntimePermission&amp;project=frameworks">grantRuntimePermission</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="105" href="#105">105</a>
<a class="l" name="106" href="#106">106</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=revokeRuntimePermission&amp;project=frameworks">revokeRuntimePermission</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="107" href="#107">107</a>
<a class="l" name="108" href="#108">108</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=resetRuntimePermissions&amp;project=frameworks">resetRuntimePermissions</a>();
<a class="l" name="109" href="#109">109</a>
<a class="hl" name="110" href="#110">110</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getPermissionFlags&amp;project=frameworks">getPermissionFlags</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="111" href="#111">111</a>
<a class="l" name="112" href="#112">112</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=updatePermissionFlags&amp;project=frameworks">updatePermissionFlags</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flagMask&amp;project=frameworks">flagMask</a>,
<a class="l" name="113" href="#113">113</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=flagValues&amp;project=frameworks">flagValues</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="114" href="#114">114</a>
<a class="l" name="115" href="#115">115</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=updatePermissionFlagsForAllApps&amp;project=frameworks">updatePermissionFlagsForAllApps</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=flagMask&amp;project=frameworks">flagMask</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flagValues&amp;project=frameworks">flagValues</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="116" href="#116">116</a>
<a class="l" name="117" href="#117">117</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=shouldShowRequestPermissionRationale&amp;project=frameworks">shouldShowRequestPermissionRationale</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>,
<a class="l" name="118" href="#118">118</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="119" href="#119">119</a>
<a class="hl" name="120" href="#120">120</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isProtectedBroadcast&amp;project=frameworks">isProtectedBroadcast</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=actionName&amp;project=frameworks">actionName</a>);
<a class="l" name="121" href="#121">121</a>
<a class="l" name="122" href="#122">122</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=checkSignatures&amp;project=frameworks">checkSignatures</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=pkg1&amp;project=frameworks">pkg1</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=pkg2&amp;project=frameworks">pkg2</a>);
<a class="l" name="123" href="#123">123</a>
<a class="l" name="124" href="#124">124</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=checkUidSignatures&amp;project=frameworks">checkUidSignatures</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid1&amp;project=frameworks">uid1</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=uid2&amp;project=frameworks">uid2</a>);
<a class="l" name="125" href="#125">125</a>
<a class="l" name="126" href="#126">126</a>    <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=getAllPackages&amp;project=frameworks">getAllPackages</a>();
<a class="l" name="127" href="#127">127</a>
<a class="l" name="128" href="#128">128</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=getPackagesForUid&amp;project=frameworks">getPackagesForUid</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="l" name="129" href="#129">129</a>
<a class="hl" name="130" href="#130">130</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getNameForUid&amp;project=frameworks">getNameForUid</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="l" name="131" href="#131">131</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=getNamesForUids&amp;project=frameworks">getNamesForUids</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b>[] <a href="/8.1.0_r33/s?defs=uids&amp;project=frameworks">uids</a>);
<a class="l" name="132" href="#132">132</a>
<a class="l" name="133" href="#133">133</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getUidForSharedUser&amp;project=frameworks">getUidForSharedUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=sharedUserName&amp;project=frameworks">sharedUserName</a>);
<a class="l" name="134" href="#134">134</a>
<a class="l" name="135" href="#135">135</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getFlagsForUid&amp;project=frameworks">getFlagsForUid</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="l" name="136" href="#136">136</a>
<a class="l" name="137" href="#137">137</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getPrivateFlagsForUid&amp;project=frameworks">getPrivateFlagsForUid</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="l" name="138" href="#138">138</a>
<a class="l" name="139" href="#139">139</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isUidPrivileged&amp;project=frameworks">isUidPrivileged</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>);
<a class="hl" name="140" href="#140">140</a>
<a class="l" name="141" href="#141">141</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=getAppOpPermissionPackages&amp;project=frameworks">getAppOpPermissionPackages</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permissionName&amp;project=frameworks">permissionName</a>);
<a class="l" name="142" href="#142">142</a>
<a class="l" name="143" href="#143">143</a>    <a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a> <a href="/8.1.0_r33/s?defs=resolveIntent&amp;project=frameworks">resolveIntent</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="144" href="#144">144</a>
<a class="l" name="145" href="#145">145</a>    <a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a> <a href="/8.1.0_r33/s?defs=findPersistentPreferredActivity&amp;project=frameworks">findPersistentPreferredActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="146" href="#146">146</a>
<a class="l" name="147" href="#147">147</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=canForwardTo&amp;project=frameworks">canForwardTo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=sourceUserId&amp;project=frameworks">sourceUserId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=targetUserId&amp;project=frameworks">targetUserId</a>);
<a class="l" name="148" href="#148">148</a>
<a class="l" name="149" href="#149">149</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryIntentActivities&amp;project=frameworks">queryIntentActivities</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="hl" name="150" href="#150">150</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="151" href="#151">151</a>
<a class="l" name="152" href="#152">152</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryIntentActivityOptions&amp;project=frameworks">queryIntentActivityOptions</a>(
<a class="l" name="153" href="#153">153</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=caller&amp;project=frameworks">caller</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a>[] <a href="/8.1.0_r33/s?defs=specifics&amp;project=frameworks">specifics</a>,
<a class="l" name="154" href="#154">154</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=specificTypes&amp;project=frameworks">specificTypes</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="155" href="#155">155</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="156" href="#156">156</a>
<a class="l" name="157" href="#157">157</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryIntentReceivers&amp;project=frameworks">queryIntentReceivers</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="158" href="#158">158</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="159" href="#159">159</a>
<a class="hl" name="160" href="#160">160</a>    <a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a> <a href="/8.1.0_r33/s?defs=resolveService&amp;project=frameworks">resolveService</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="161" href="#161">161</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="162" href="#162">162</a>
<a class="l" name="163" href="#163">163</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryIntentServices&amp;project=frameworks">queryIntentServices</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="164" href="#164">164</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="165" href="#165">165</a>
<a class="l" name="166" href="#166">166</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryIntentContentProviders&amp;project=frameworks">queryIntentContentProviders</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="167" href="#167">167</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="168" href="#168">168</a>
<a class="l" name="169" href="#169">169</a>    <span class="c">/**
<a class="hl" name="170" href="#170">170</a>     * This implements getInstalledPackages via a "last returned row"
<a class="l" name="171" href="#171">171</a>     * mechanism that is not exposed in the API. This is to get around the IPC
<a class="l" name="172" href="#172">172</a>     * limit that kicks in when flags are included that bloat up the data
<a class="l" name="173" href="#173">173</a>     * returned.
<a class="l" name="174" href="#174">174</a>     */</span>
<a class="l" name="175" href="#175">175</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getInstalledPackages&amp;project=frameworks">getInstalledPackages</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="176" href="#176">176</a>
<a class="l" name="177" href="#177">177</a>    <span class="c">/**
<a class="l" name="178" href="#178">178</a>     * This implements getPackagesHoldingPermissions via a "last returned row"
<a class="l" name="179" href="#179">179</a>     * mechanism that is not exposed in the API. This is to get around the IPC
<a class="hl" name="180" href="#180">180</a>     * limit that kicks in when flags are included that bloat up the data
<a class="l" name="181" href="#181">181</a>     * returned.
<a class="l" name="182" href="#182">182</a>     */</span>
<a class="l" name="183" href="#183">183</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getPackagesHoldingPermissions&amp;project=frameworks">getPackagesHoldingPermissions</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=permissions&amp;project=frameworks">permissions</a>,
<a class="l" name="184" href="#184">184</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="185" href="#185">185</a>
<a class="l" name="186" href="#186">186</a>    <span class="c">/**
<a class="l" name="187" href="#187">187</a>     * This implements getInstalledApplications via a "last returned row"
<a class="l" name="188" href="#188">188</a>     * mechanism that is not exposed in the API. This is to get around the IPC
<a class="l" name="189" href="#189">189</a>     * limit that kicks in when flags are included that bloat up the data
<a class="hl" name="190" href="#190">190</a>     * returned.
<a class="l" name="191" href="#191">191</a>     */</span>
<a class="l" name="192" href="#192">192</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getInstalledApplications&amp;project=frameworks">getInstalledApplications</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="193" href="#193">193</a>
<a class="l" name="194" href="#194">194</a>    <span class="c">/**
<a class="l" name="195" href="#195">195</a>     * Retrieve all applications that are marked as persistent.
<a class="l" name="196" href="#196">196</a>     *
<a class="l" name="197" href="#197">197</a>     * <strong>@return</strong> A List&amp;lt;applicationInfo&gt; containing one entry for each persistent
<a class="l" name="198" href="#198">198</a>     *         application.
<a class="l" name="199" href="#199">199</a>     */</span>
<a class="hl" name="200" href="#200">200</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getPersistentApplications&amp;project=frameworks">getPersistentApplications</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="201" href="#201">201</a>
<a class="l" name="202" href="#202">202</a>    <a href="/8.1.0_r33/s?defs=ProviderInfo&amp;project=frameworks">ProviderInfo</a> <a href="/8.1.0_r33/s?defs=resolveContentProvider&amp;project=frameworks">resolveContentProvider</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=name&amp;project=frameworks">name</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="203" href="#203">203</a>
<a class="l" name="204" href="#204">204</a>    <span class="c">/**
<a class="l" name="205" href="#205">205</a>     * Retrieve sync information for all content providers.
<a class="l" name="206" href="#206">206</a>     *
<a class="l" name="207" href="#207">207</a>     * <strong>@param</strong> <em>outNames</em> Filled in with a list of the root names of the content
<a class="l" name="208" href="#208">208</a>     *                 providers that can sync.
<a class="l" name="209" href="#209">209</a>     * <strong>@param</strong> <em>outInfo</em> Filled in with a list of the ProviderInfo for each
<a class="hl" name="210" href="#210">210</a>     *                name in 'outNames'.
<a class="l" name="211" href="#211">211</a>     */</span>
<a class="l" name="212" href="#212">212</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=querySyncProviders&amp;project=frameworks">querySyncProviders</a>(<a href="/8.1.0_r33/s?defs=inout&amp;project=frameworks">inout</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=outNames&amp;project=frameworks">outNames</a>,
<a class="l" name="213" href="#213">213</a>            <a href="/8.1.0_r33/s?defs=inout&amp;project=frameworks">inout</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=ProviderInfo&amp;project=frameworks">ProviderInfo</a>&gt; <a href="/8.1.0_r33/s?defs=outInfo&amp;project=frameworks">outInfo</a>);
<a class="l" name="214" href="#214">214</a>
<a class="l" name="215" href="#215">215</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryContentProviders&amp;project=frameworks">queryContentProviders</a>(
<a class="l" name="216" href="#216">216</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=processName&amp;project=frameworks">processName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=metaDataKey&amp;project=frameworks">metaDataKey</a>);
<a class="l" name="217" href="#217">217</a>
<a class="l" name="218" href="#218">218</a>    <a href="/8.1.0_r33/s?defs=InstrumentationInfo&amp;project=frameworks">InstrumentationInfo</a> <a href="/8.1.0_r33/s?defs=getInstrumentationInfo&amp;project=frameworks">getInstrumentationInfo</a>(
<a class="l" name="219" href="#219">219</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="hl" name="220" href="#220">220</a>
<a class="l" name="221" href="#221">221</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=queryInstrumentation&amp;project=frameworks">queryInstrumentation</a>(
<a class="l" name="222" href="#222">222</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=targetPackage&amp;project=frameworks">targetPackage</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="223" href="#223">223</a>
<a class="l" name="224" href="#224">224</a>    <span class="c">/** <strong>@deprecated</strong> Use PackageInstaller instead */</span>
<a class="l" name="225" href="#225">225</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=installPackageAsUser&amp;project=frameworks">installPackageAsUser</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=originPath&amp;project=frameworks">originPath</a>,
<a class="l" name="226" href="#226">226</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IPackageInstallObserver2&amp;project=frameworks">IPackageInstallObserver2</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>,
<a class="l" name="227" href="#227">227</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>,
<a class="l" name="228" href="#228">228</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=installerPackageName&amp;project=frameworks">installerPackageName</a>,
<a class="l" name="229" href="#229">229</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="hl" name="230" href="#230">230</a>
<a class="l" name="231" href="#231">231</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=finishPackageInstall&amp;project=frameworks">finishPackageInstall</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=token&amp;project=frameworks">token</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=didLaunch&amp;project=frameworks">didLaunch</a>);
<a class="l" name="232" href="#232">232</a>
<a class="l" name="233" href="#233">233</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setInstallerPackageName&amp;project=frameworks">setInstallerPackageName</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=targetPackage&amp;project=frameworks">targetPackage</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=installerPackageName&amp;project=frameworks">installerPackageName</a>);
<a class="l" name="234" href="#234">234</a>
<a class="l" name="235" href="#235">235</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setApplicationCategoryHint&amp;project=frameworks">setApplicationCategoryHint</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=categoryHint&amp;project=frameworks">categoryHint</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=callerPackageName&amp;project=frameworks">callerPackageName</a>);
<a class="l" name="236" href="#236">236</a>
<a class="l" name="237" href="#237">237</a>    <span class="c">/** <strong>@deprecated</strong> rawr, don't call AIDL methods directly! */</span>
<a class="l" name="238" href="#238">238</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=deletePackageAsUser&amp;project=frameworks">deletePackageAsUser</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=versionCode&amp;project=frameworks">versionCode</a>,
<a class="l" name="239" href="#239">239</a>            <a href="/8.1.0_r33/s?defs=IPackageDeleteObserver&amp;project=frameworks">IPackageDeleteObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="hl" name="240" href="#240">240</a>
<a class="l" name="241" href="#241">241</a>    <span class="c">/**
<a class="l" name="242" href="#242">242</a>     * Delete a package for a specific user.
<a class="l" name="243" href="#243">243</a>     *
<a class="l" name="244" href="#244">244</a>     * <strong>@param</strong> <em>versionedPackage</em> The package to delete.
<a class="l" name="245" href="#245">245</a>     * <strong>@param</strong> <em>observer</em> a callback to use to notify when the package deletion in finished.
<a class="l" name="246" href="#246">246</a>     * <strong>@param</strong> <em>userId</em> the id of the user for whom to delete the package
<a class="l" name="247" href="#247">247</a>     * <strong>@param</strong> <em>flags</em> - possible values: {<strong>@link</strong> #DONT_DELETE_DATA}
<a class="l" name="248" href="#248">248</a>     */</span>
<a class="l" name="249" href="#249">249</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=deletePackageVersioned&amp;project=frameworks">deletePackageVersioned</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=VersionedPackage&amp;project=frameworks">VersionedPackage</a> <a href="/8.1.0_r33/s?defs=versionedPackage&amp;project=frameworks">versionedPackage</a>,
<a class="hl" name="250" href="#250">250</a>            <a href="/8.1.0_r33/s?defs=IPackageDeleteObserver2&amp;project=frameworks">IPackageDeleteObserver2</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="251" href="#251">251</a>
<a class="l" name="252" href="#252">252</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getInstallerPackageName&amp;project=frameworks">getInstallerPackageName</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="253" href="#253">253</a>
<a class="l" name="254" href="#254">254</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=resetApplicationPreferences&amp;project=frameworks">resetApplicationPreferences</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="255" href="#255">255</a>
<a class="l" name="256" href="#256">256</a>    <a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a> <a href="/8.1.0_r33/s?defs=getLastChosenActivity&amp;project=frameworks">getLastChosenActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>,
<a class="l" name="257" href="#257">257</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="258" href="#258">258</a>
<a class="l" name="259" href="#259">259</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setLastChosenActivity&amp;project=frameworks">setLastChosenActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=Intent&amp;project=frameworks">Intent</a> <a href="/8.1.0_r33/s?defs=intent&amp;project=frameworks">intent</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=resolvedType&amp;project=frameworks">resolvedType</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>,
<a class="hl" name="260" href="#260">260</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a> <a href="/8.1.0_r33/s?defs=filter&amp;project=frameworks">filter</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=match&amp;project=frameworks">match</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=activity&amp;project=frameworks">activity</a>);
<a class="l" name="261" href="#261">261</a>
<a class="l" name="262" href="#262">262</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=addPreferredActivity&amp;project=frameworks">addPreferredActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a> <a href="/8.1.0_r33/s?defs=filter&amp;project=frameworks">filter</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=match&amp;project=frameworks">match</a>,
<a class="l" name="263" href="#263">263</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a>[] <a href="/8.1.0_r33/s?defs=set&amp;project=frameworks">set</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=activity&amp;project=frameworks">activity</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="264" href="#264">264</a>
<a class="l" name="265" href="#265">265</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=replacePreferredActivity&amp;project=frameworks">replacePreferredActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a> <a href="/8.1.0_r33/s?defs=filter&amp;project=frameworks">filter</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=match&amp;project=frameworks">match</a>,
<a class="l" name="266" href="#266">266</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a>[] <a href="/8.1.0_r33/s?defs=set&amp;project=frameworks">set</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=activity&amp;project=frameworks">activity</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="267" href="#267">267</a>
<a class="l" name="268" href="#268">268</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=clearPackagePreferredActivities&amp;project=frameworks">clearPackagePreferredActivities</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="269" href="#269">269</a>
<a class="hl" name="270" href="#270">270</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getPreferredActivities&amp;project=frameworks">getPreferredActivities</a>(<a href="/8.1.0_r33/s?defs=out&amp;project=frameworks">out</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a>&gt; <a href="/8.1.0_r33/s?defs=outFilters&amp;project=frameworks">outFilters</a>,
<a class="l" name="271" href="#271">271</a>            <a href="/8.1.0_r33/s?defs=out&amp;project=frameworks">out</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a>&gt; <a href="/8.1.0_r33/s?defs=outActivities&amp;project=frameworks">outActivities</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="272" href="#272">272</a>
<a class="l" name="273" href="#273">273</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=addPersistentPreferredActivity&amp;project=frameworks">addPersistentPreferredActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a> <a href="/8.1.0_r33/s?defs=filter&amp;project=frameworks">filter</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=activity&amp;project=frameworks">activity</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="274" href="#274">274</a>
<a class="l" name="275" href="#275">275</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=clearPackagePersistentPreferredActivities&amp;project=frameworks">clearPackagePersistentPreferredActivities</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="276" href="#276">276</a>
<a class="l" name="277" href="#277">277</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=addCrossProfileIntentFilter&amp;project=frameworks">addCrossProfileIntentFilter</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentFilter&amp;project=frameworks">IntentFilter</a> <a href="/8.1.0_r33/s?defs=intentFilter&amp;project=frameworks">intentFilter</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=ownerPackage&amp;project=frameworks">ownerPackage</a>,
<a class="l" name="278" href="#278">278</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=sourceUserId&amp;project=frameworks">sourceUserId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=targetUserId&amp;project=frameworks">targetUserId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>);
<a class="l" name="279" href="#279">279</a>
<a class="hl" name="280" href="#280">280</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=clearCrossProfileIntentFilters&amp;project=frameworks">clearCrossProfileIntentFilters</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=sourceUserId&amp;project=frameworks">sourceUserId</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=ownerPackage&amp;project=frameworks">ownerPackage</a>);
<a class="l" name="281" href="#281">281</a>
<a class="l" name="282" href="#282">282</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=setPackagesSuspendedAsUser&amp;project=frameworks">setPackagesSuspendedAsUser</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=packageNames&amp;project=frameworks">packageNames</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=suspended&amp;project=frameworks">suspended</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="283" href="#283">283</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPackageSuspendedForUser&amp;project=frameworks">isPackageSuspendedForUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="284" href="#284">284</a>
<a class="l" name="285" href="#285">285</a>    <span class="c">/**
<a class="l" name="286" href="#286">286</a>     * <a href="/8.1.0_r33/s?path=Backup/">Backup</a>/<a href="/8.1.0_r33/s?path=Backup/restore">restore</a> support - only the system uid may use these.
<a class="l" name="287" href="#287">287</a>     */</span>
<a class="l" name="288" href="#288">288</a>    <b>byte</b>[] <a href="/8.1.0_r33/s?defs=getPreferredActivityBackup&amp;project=frameworks">getPreferredActivityBackup</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="289" href="#289">289</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=restorePreferredActivities&amp;project=frameworks">restorePreferredActivities</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>byte</b>[] <a href="/8.1.0_r33/s?defs=backup&amp;project=frameworks">backup</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="hl" name="290" href="#290">290</a>    <b>byte</b>[] <a href="/8.1.0_r33/s?defs=getDefaultAppsBackup&amp;project=frameworks">getDefaultAppsBackup</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="291" href="#291">291</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=restoreDefaultApps&amp;project=frameworks">restoreDefaultApps</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>byte</b>[] <a href="/8.1.0_r33/s?defs=backup&amp;project=frameworks">backup</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="292" href="#292">292</a>    <b>byte</b>[] <a href="/8.1.0_r33/s?defs=getIntentFilterVerificationBackup&amp;project=frameworks">getIntentFilterVerificationBackup</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="293" href="#293">293</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=restoreIntentFilterVerification&amp;project=frameworks">restoreIntentFilterVerification</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>byte</b>[] <a href="/8.1.0_r33/s?defs=backup&amp;project=frameworks">backup</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="294" href="#294">294</a>    <b>byte</b>[] <a href="/8.1.0_r33/s?defs=getPermissionGrantBackup&amp;project=frameworks">getPermissionGrantBackup</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="295" href="#295">295</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=restorePermissionGrants&amp;project=frameworks">restorePermissionGrants</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>byte</b>[] <a href="/8.1.0_r33/s?defs=backup&amp;project=frameworks">backup</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="296" href="#296">296</a>
<a class="l" name="297" href="#297">297</a>    <span class="c">/**
<a class="l" name="298" href="#298">298</a>     * Report the set of 'Home' activity candidates, plus (if any) which of them
<a class="l" name="299" href="#299">299</a>     * is the current "always use this one" setting.
<a class="hl" name="300" href="#300">300</a>     */</span>
<a class="l" name="301" href="#301">301</a>     <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=getHomeActivities&amp;project=frameworks">getHomeActivities</a>(<a href="/8.1.0_r33/s?defs=out&amp;project=frameworks">out</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=ResolveInfo&amp;project=frameworks">ResolveInfo</a>&gt; <a href="/8.1.0_r33/s?defs=outHomeCandidates&amp;project=frameworks">outHomeCandidates</a>);
<a class="l" name="302" href="#302">302</a>
<a class="l" name="303" href="#303">303</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setHomeActivity&amp;project=frameworks">setHomeActivity</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=className&amp;project=frameworks">className</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="304" href="#304">304</a>
<a class="l" name="305" href="#305">305</a>    <span class="c">/**
<a class="l" name="306" href="#306">306</a>     * As per {<strong>@link</strong> android.content.pm.PackageManager#setComponentEnabledSetting}.
<a class="l" name="307" href="#307">307</a>     */</span>
<a class="l" name="308" href="#308">308</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setComponentEnabledSetting&amp;project=frameworks">setComponentEnabledSetting</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=componentName&amp;project=frameworks">componentName</a>,
<a class="l" name="309" href="#309">309</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b> <a href="/8.1.0_r33/s?defs=newState&amp;project=frameworks">newState</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="hl" name="310" href="#310">310</a>
<a class="l" name="311" href="#311">311</a>    <span class="c">/**
<a class="l" name="312" href="#312">312</a>     * As per {<strong>@link</strong> android.content.pm.PackageManager#getComponentEnabledSetting}.
<a class="l" name="313" href="#313">313</a>     */</span>
<a class="l" name="314" href="#314">314</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getComponentEnabledSetting&amp;project=frameworks">getComponentEnabledSetting</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=componentName&amp;project=frameworks">componentName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="315" href="#315">315</a>
<a class="l" name="316" href="#316">316</a>    <span class="c">/**
<a class="l" name="317" href="#317">317</a>     * As per {<strong>@link</strong> android.content.pm.PackageManager#setApplicationEnabledSetting}.
<a class="l" name="318" href="#318">318</a>     */</span>
<a class="l" name="319" href="#319">319</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setApplicationEnabledSetting&amp;project=frameworks">setApplicationEnabledSetting</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b> <a href="/8.1.0_r33/s?defs=newState&amp;project=frameworks">newState</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>,
<a class="hl" name="320" href="#320">320</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=callingPackage&amp;project=frameworks">callingPackage</a>);
<a class="l" name="321" href="#321">321</a>
<a class="l" name="322" href="#322">322</a>    <span class="c">/**
<a class="l" name="323" href="#323">323</a>     * As per {<strong>@link</strong> android.content.pm.PackageManager#getApplicationEnabledSetting}.
<a class="l" name="324" href="#324">324</a>     */</span>
<a class="l" name="325" href="#325">325</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getApplicationEnabledSetting&amp;project=frameworks">getApplicationEnabledSetting</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="326" href="#326">326</a>
<a class="l" name="327" href="#327">327</a>    <span class="c">/**
<a class="l" name="328" href="#328">328</a>     * Logs process start information (including APK hash) to the security log.
<a class="l" name="329" href="#329">329</a>     */</span>
<a class="hl" name="330" href="#330">330</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=logAppProcessStartIfNeeded&amp;project=frameworks">logAppProcessStartIfNeeded</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=processName&amp;project=frameworks">processName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=uid&amp;project=frameworks">uid</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=seinfo&amp;project=frameworks">seinfo</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=apkFile&amp;project=frameworks">apkFile</a>,
<a class="l" name="331" href="#331">331</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=pid&amp;project=frameworks">pid</a>);
<a class="l" name="332" href="#332">332</a>
<a class="l" name="333" href="#333">333</a>    <span class="c">/**
<a class="l" name="334" href="#334">334</a>     * As per {<strong>@link</strong> android.content.pm.PackageManager#flushPackageRestrictionsAsUser}.
<a class="l" name="335" href="#335">335</a>     */</span>
<a class="l" name="336" href="#336">336</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=flushPackageRestrictionsAsUser&amp;project=frameworks">flushPackageRestrictionsAsUser</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="337" href="#337">337</a>
<a class="l" name="338" href="#338">338</a>    <span class="c">/**
<a class="l" name="339" href="#339">339</a>     * Set whether the given package should be considered stopped, making
<a class="hl" name="340" href="#340">340</a>     * it not visible to implicit intents that filter out stopped packages.
<a class="l" name="341" href="#341">341</a>     */</span>
<a class="l" name="342" href="#342">342</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setPackageStoppedState&amp;project=frameworks">setPackageStoppedState</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=stopped&amp;project=frameworks">stopped</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="343" href="#343">343</a>
<a class="l" name="344" href="#344">344</a>    <span class="c">/**
<a class="l" name="345" href="#345">345</a>     * Free storage by deleting LRU sorted list of cache files across
<a class="l" name="346" href="#346">346</a>     * all applications. If the currently available free storage
<a class="l" name="347" href="#347">347</a>     * on the device is greater than or equal to the requested
<a class="l" name="348" href="#348">348</a>     * free storage, no cache files are cleared. If the currently
<a class="l" name="349" href="#349">349</a>     * available storage on the device is less than the requested
<a class="hl" name="350" href="#350">350</a>     * free storage, some or all of the cache files across
<a class="l" name="351" href="#351">351</a>     * all applications are deleted (based on last accessed time)
<a class="l" name="352" href="#352">352</a>     * to increase the free storage space on the device to
<a class="l" name="353" href="#353">353</a>     * the requested value. There is no guarantee that clearing all
<a class="l" name="354" href="#354">354</a>     * the cache files from all applications will clear up
<a class="l" name="355" href="#355">355</a>     * enough storage to achieve the desired value.
<a class="l" name="356" href="#356">356</a>     * <strong>@param</strong> <em>freeStorageSize</em> The number of bytes of storage to be
<a class="l" name="357" href="#357">357</a>     * freed by the system. Say if freeStorageSize is XX,
<a class="l" name="358" href="#358">358</a>     * and the current free storage is YY,
<a class="l" name="359" href="#359">359</a>     * if XX is less than YY, just return. if not free XX-YY number
<a class="hl" name="360" href="#360">360</a>     * of bytes if possible.
<a class="l" name="361" href="#361">361</a>     * <strong>@param</strong> <em>observer</em> call back used to notify when
<a class="l" name="362" href="#362">362</a>     * the operation is completed
<a class="l" name="363" href="#363">363</a>     */</span>
<a class="l" name="364" href="#364">364</a>     <b>void</b> <a href="/8.1.0_r33/s?defs=freeStorageAndNotify&amp;project=frameworks">freeStorageAndNotify</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=volumeUuid&amp;project=frameworks">volumeUuid</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>long</b> <a href="/8.1.0_r33/s?defs=freeStorageSize&amp;project=frameworks">freeStorageSize</a>,
<a class="l" name="365" href="#365">365</a>             <b>int</b> <a href="/8.1.0_r33/s?defs=storageFlags&amp;project=frameworks">storageFlags</a>, <a href="/8.1.0_r33/s?defs=IPackageDataObserver&amp;project=frameworks">IPackageDataObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>);
<a class="l" name="366" href="#366">366</a>
<a class="l" name="367" href="#367">367</a>    <span class="c">/**
<a class="l" name="368" href="#368">368</a>     * Free storage by deleting LRU sorted list of cache files across
<a class="l" name="369" href="#369">369</a>     * all applications. If the currently available free storage
<a class="hl" name="370" href="#370">370</a>     * on the device is greater than or equal to the requested
<a class="l" name="371" href="#371">371</a>     * free storage, no cache files are cleared. If the currently
<a class="l" name="372" href="#372">372</a>     * available storage on the device is less than the requested
<a class="l" name="373" href="#373">373</a>     * free storage, some or all of the cache files across
<a class="l" name="374" href="#374">374</a>     * all applications are deleted (based on last accessed time)
<a class="l" name="375" href="#375">375</a>     * to increase the free storage space on the device to
<a class="l" name="376" href="#376">376</a>     * the requested value. There is no guarantee that clearing all
<a class="l" name="377" href="#377">377</a>     * the cache files from all applications will clear up
<a class="l" name="378" href="#378">378</a>     * enough storage to achieve the desired value.
<a class="l" name="379" href="#379">379</a>     * <strong>@param</strong> <em>freeStorageSize</em> The number of bytes of storage to be
<a class="hl" name="380" href="#380">380</a>     * freed by the system. Say if freeStorageSize is XX,
<a class="l" name="381" href="#381">381</a>     * and the current free storage is YY,
<a class="l" name="382" href="#382">382</a>     * if XX is less than YY, just return. if not free XX-YY number
<a class="l" name="383" href="#383">383</a>     * of bytes if possible.
<a class="l" name="384" href="#384">384</a>     * <strong>@param</strong> <em>pi</em> IntentSender call back used to
<a class="l" name="385" href="#385">385</a>     * notify when the operation is completed.May be null
<a class="l" name="386" href="#386">386</a>     * to indicate that no call back is desired.
<a class="l" name="387" href="#387">387</a>     */</span>
<a class="l" name="388" href="#388">388</a>     <b>void</b> <a href="/8.1.0_r33/s?defs=freeStorage&amp;project=frameworks">freeStorage</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=volumeUuid&amp;project=frameworks">volumeUuid</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>long</b> <a href="/8.1.0_r33/s?defs=freeStorageSize&amp;project=frameworks">freeStorageSize</a>,
<a class="l" name="389" href="#389">389</a>             <b>int</b> <a href="/8.1.0_r33/s?defs=storageFlags&amp;project=frameworks">storageFlags</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IntentSender&amp;project=frameworks">IntentSender</a> <a href="/8.1.0_r33/s?defs=pi&amp;project=frameworks">pi</a>);
<a class="hl" name="390" href="#390">390</a>
<a class="l" name="391" href="#391">391</a>    <span class="c">/**
<a class="l" name="392" href="#392">392</a>     * Delete all the cache files in an applications cache directory
<a class="l" name="393" href="#393">393</a>     * <strong>@param</strong> <em>packageName</em> The package name of the application whose cache
<a class="l" name="394" href="#394">394</a>     * files need to be deleted
<a class="l" name="395" href="#395">395</a>     * <strong>@param</strong> <em>observer</em> a callback used to notify when the deletion is finished.
<a class="l" name="396" href="#396">396</a>     */</span>
<a class="l" name="397" href="#397">397</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=deleteApplicationCacheFiles&amp;project=frameworks">deleteApplicationCacheFiles</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=IPackageDataObserver&amp;project=frameworks">IPackageDataObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>);
<a class="l" name="398" href="#398">398</a>
<a class="l" name="399" href="#399">399</a>    <span class="c">/**
<a class="hl" name="400" href="#400">400</a>     * Delete all the cache files in an applications cache directory
<a class="l" name="401" href="#401">401</a>     * <strong>@param</strong> <em>packageName</em> The package name of the application whose cache
<a class="l" name="402" href="#402">402</a>     * files need to be deleted
<a class="l" name="403" href="#403">403</a>     * <strong>@param</strong> <em>userId</em> the user to delete application cache for
<a class="l" name="404" href="#404">404</a>     * <strong>@param</strong> <em>observer</em> a callback used to notify when the deletion is finished.
<a class="l" name="405" href="#405">405</a>     */</span>
<a class="l" name="406" href="#406">406</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=deleteApplicationCacheFilesAsUser&amp;project=frameworks">deleteApplicationCacheFilesAsUser</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>, <a href="/8.1.0_r33/s?defs=IPackageDataObserver&amp;project=frameworks">IPackageDataObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>);
<a class="l" name="407" href="#407">407</a>
<a class="l" name="408" href="#408">408</a>    <span class="c">/**
<a class="l" name="409" href="#409">409</a>     * Clear the user data directory of an application.
<a class="hl" name="410" href="#410">410</a>     * <strong>@param</strong> <em>packageName</em> The package name of the application whose cache
<a class="l" name="411" href="#411">411</a>     * files need to be deleted
<a class="l" name="412" href="#412">412</a>     * <strong>@param</strong> <em>observer</em> a callback used to notify when the operation is completed.
<a class="l" name="413" href="#413">413</a>     */</span>
<a class="l" name="414" href="#414">414</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=clearApplicationUserData&amp;project=frameworks">clearApplicationUserData</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=IPackageDataObserver&amp;project=frameworks">IPackageDataObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="415" href="#415">415</a>
<a class="l" name="416" href="#416">416</a>    <span class="c">/**
<a class="l" name="417" href="#417">417</a>     * Clear the profile data of an application.
<a class="l" name="418" href="#418">418</a>     * <strong>@param</strong> <em>packageName</em> The package name of the application whose profile data
<a class="l" name="419" href="#419">419</a>     * need to be deleted
<a class="hl" name="420" href="#420">420</a>     */</span>
<a class="l" name="421" href="#421">421</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=clearApplicationProfileData&amp;project=frameworks">clearApplicationProfileData</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="422" href="#422">422</a>
<a class="l" name="423" href="#423">423</a>   <span class="c">/**
<a class="l" name="424" href="#424">424</a>     * Get package statistics including the code, data and cache size for
<a class="l" name="425" href="#425">425</a>     * an already installed package
<a class="l" name="426" href="#426">426</a>     * <strong>@param</strong> <em>packageName</em> The package name of the application
<a class="l" name="427" href="#427">427</a>     * <strong>@param</strong> <em>userHandle</em> Which user the size should be retrieved for
<a class="l" name="428" href="#428">428</a>     * <strong>@param</strong> <em>observer</em> a callback to use to notify when the asynchronous
<a class="l" name="429" href="#429">429</a>     * retrieval of information is complete.
<a class="hl" name="430" href="#430">430</a>     */</span>
<a class="l" name="431" href="#431">431</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=getPackageSizeInfo&amp;project=frameworks">getPackageSizeInfo</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userHandle&amp;project=frameworks">userHandle</a>, <a href="/8.1.0_r33/s?defs=IPackageStatsObserver&amp;project=frameworks">IPackageStatsObserver</a> <a href="/8.1.0_r33/s?defs=observer&amp;project=frameworks">observer</a>);
<a class="l" name="432" href="#432">432</a>
<a class="l" name="433" href="#433">433</a>    <span class="c">/**
<a class="l" name="434" href="#434">434</a>     * Get a list of shared libraries that are available on the
<a class="l" name="435" href="#435">435</a>     * system.
<a class="l" name="436" href="#436">436</a>     */</span>
<a class="l" name="437" href="#437">437</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=getSystemSharedLibraryNames&amp;project=frameworks">getSystemSharedLibraryNames</a>();
<a class="l" name="438" href="#438">438</a>
<a class="l" name="439" href="#439">439</a>    <span class="c">/**
<a class="hl" name="440" href="#440">440</a>     * Get a list of features that are available on the
<a class="l" name="441" href="#441">441</a>     * system.
<a class="l" name="442" href="#442">442</a>     */</span>
<a class="l" name="443" href="#443">443</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getSystemAvailableFeatures&amp;project=frameworks">getSystemAvailableFeatures</a>();
<a class="l" name="444" href="#444">444</a>
<a class="l" name="445" href="#445">445</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=hasSystemFeature&amp;project=frameworks">hasSystemFeature</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=name&amp;project=frameworks">name</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=version&amp;project=frameworks">version</a>);
<a class="l" name="446" href="#446">446</a>
<a class="l" name="447" href="#447">447</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=enterSafeMode&amp;project=frameworks">enterSafeMode</a>();
<a class="l" name="448" href="#448">448</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isSafeMode&amp;project=frameworks">isSafeMode</a>();
<a class="l" name="449" href="#449">449</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=systemReady&amp;project=frameworks">systemReady</a>();
<a class="hl" name="450" href="#450">450</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=hasSystemUidErrors&amp;project=frameworks">hasSystemUidErrors</a>();
<a class="l" name="451" href="#451">451</a>
<a class="l" name="452" href="#452">452</a>    <span class="c">/**
<a class="l" name="453" href="#453">453</a>     * Ask the package manager to fstrim the disk if needed.
<a class="l" name="454" href="#454">454</a>     */</span>
<a class="l" name="455" href="#455">455</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=performFstrimIfNeeded&amp;project=frameworks">performFstrimIfNeeded</a>();
<a class="l" name="456" href="#456">456</a>
<a class="l" name="457" href="#457">457</a>    <span class="c">/**
<a class="l" name="458" href="#458">458</a>     * Ask the package manager to update packages if needed.
<a class="l" name="459" href="#459">459</a>     */</span>
<a class="hl" name="460" href="#460">460</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=updatePackagesIfNeeded&amp;project=frameworks">updatePackagesIfNeeded</a>();
<a class="l" name="461" href="#461">461</a>
<a class="l" name="462" href="#462">462</a>    <span class="c">/**
<a class="l" name="463" href="#463">463</a>     * Notify the package manager that a package is going to be used and why.
<a class="l" name="464" href="#464">464</a>     *
<a class="l" name="465" href="#465">465</a>     * See PackageManager.NOTIFY_PACKAGE_USE_* for reasons.
<a class="l" name="466" href="#466">466</a>     */</span>
<a class="l" name="467" href="#467">467</a>    <a href="/8.1.0_r33/s?defs=oneway&amp;project=frameworks">oneway</a> <b>void</b> <a href="/8.1.0_r33/s?defs=notifyPackageUse&amp;project=frameworks">notifyPackageUse</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=reason&amp;project=frameworks">reason</a>);
<a class="l" name="468" href="#468">468</a>
<a class="l" name="469" href="#469">469</a>    <span class="c">/**
<a class="hl" name="470" href="#470">470</a>     * Notify the package manager that a list of dex files have been loaded.
<a class="l" name="471" href="#471">471</a>     *
<a class="l" name="472" href="#472">472</a>     * <strong>@param</strong> <em>loadingPackageName</em> the name of the package who performs the load
<a class="l" name="473" href="#473">473</a>     * <strong>@param</strong> <em>classLoadersNames</em> the names of the class loaders present in the loading chain. The
<a class="l" name="474" href="#474">474</a>     *    list encodes the class loader chain in the natural order. The first class loader has
<a class="l" name="475" href="#475">475</a>     *    the second one as its parent and so on. The dex files present in the class path of the
<a class="l" name="476" href="#476">476</a>     *    first class loader will be recorded in the usage file.
<a class="l" name="477" href="#477">477</a>     * <strong>@param</strong> <em>classPaths</em> the class paths corresponding to the class loaders names from
<a class="l" name="478" href="#478">478</a>     *     {<strong>@param</strong> <em>classLoadersNames</em>}. The the first element corresponds to the first class loader
<a class="l" name="479" href="#479">479</a>     *     and so on. A classpath is represented as a list of dex files separated by
<a class="hl" name="480" href="#480">480</a>     *     {<strong>@code</strong> File.pathSeparator}.
<a class="l" name="481" href="#481">481</a>     *     The dex files found in the first class path will be recorded in the usage file.
<a class="l" name="482" href="#482">482</a>     * <strong>@param</strong> <em>loaderIsa</em> the ISA of the loader process
<a class="l" name="483" href="#483">483</a>     */</span>
<a class="l" name="484" href="#484">484</a>    <a href="/8.1.0_r33/s?defs=oneway&amp;project=frameworks">oneway</a> <b>void</b> <a href="/8.1.0_r33/s?defs=notifyDexLoad&amp;project=frameworks">notifyDexLoad</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=loadingPackageName&amp;project=frameworks">loadingPackageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=classLoadersNames&amp;project=frameworks">classLoadersNames</a>,
<a class="l" name="485" href="#485">485</a>            <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=classPaths&amp;project=frameworks">classPaths</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=loaderIsa&amp;project=frameworks">loaderIsa</a>);
<a class="l" name="486" href="#486">486</a>
<a class="l" name="487" href="#487">487</a>    <span class="c">/**
<a class="l" name="488" href="#488">488</a>     * Register an application dex module with the package manager.
<a class="l" name="489" href="#489">489</a>     * The package manager will keep track of the given module for future optimizations.
<a class="hl" name="490" href="#490">490</a>     *
<a class="l" name="491" href="#491">491</a>     * Dex module optimizations will disable the classpath checking at runtime. The client bares
<a class="l" name="492" href="#492">492</a>     * the responsibility to ensure that the static assumptions on classes in the optimized code
<a class="l" name="493" href="#493">493</a>     * hold at runtime (e.g. there's no duplicate classes in the classpath).
<a class="l" name="494" href="#494">494</a>     *
<a class="l" name="495" href="#495">495</a>     * Note that the package manager already keeps track of dex modules loaded with
<a class="l" name="496" href="#496">496</a>     * {<strong>@link</strong> dalvik.system.DexClassLoader} and {<strong>@link</strong> dalvik.system.PathClassLoader}.
<a class="l" name="497" href="#497">497</a>     * This can be called for an eager registration.
<a class="l" name="498" href="#498">498</a>     *
<a class="l" name="499" href="#499">499</a>     * The call might take a while and the results will be posted on the main thread, using
<a class="hl" name="500" href="#500">500</a>     * the given callback.
<a class="l" name="501" href="#501">501</a>     *
<a class="l" name="502" href="#502">502</a>     * If the module is intended to be shared with other apps, make sure that the file
<a class="l" name="503" href="#503">503</a>     * permissions allow for it.
<a class="l" name="504" href="#504">504</a>     * If at registration time the permissions allow for others to read it, the module would
<a class="l" name="505" href="#505">505</a>     * be marked as a shared module which might undergo a different optimization strategy.
<a class="l" name="506" href="#506">506</a>     * (usually shared modules will generated larger optimizations artifacts,
<a class="l" name="507" href="#507">507</a>     * taking more disk space).
<a class="l" name="508" href="#508">508</a>     *
<a class="l" name="509" href="#509">509</a>     * <strong>@param</strong> <em>packageName</em> the package name to which the dex module belongs
<a class="hl" name="510" href="#510">510</a>     * <strong>@param</strong> <em>dexModulePath</em> the absolute path of the dex module.
<a class="l" name="511" href="#511">511</a>     * <strong>@param</strong> <em>isSharedModule</em> whether or not the module is intended to be used by other apps.
<a class="l" name="512" href="#512">512</a>     * <strong>@param</strong> <em>callback</em> if not null,
<a class="l" name="513" href="#513">513</a>     *   {<strong>@link</strong> android.content.pm.IDexModuleRegisterCallback.IDexModuleRegisterCallback#onDexModuleRegistered}
<a class="l" name="514" href="#514">514</a>     *   will be called once the registration finishes.
<a class="l" name="515" href="#515">515</a>     */</span>
<a class="l" name="516" href="#516">516</a>     <a href="/8.1.0_r33/s?defs=oneway&amp;project=frameworks">oneway</a> <b>void</b> <a href="/8.1.0_r33/s?defs=registerDexModule&amp;project=frameworks">registerDexModule</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=dexModulePath&amp;project=frameworks">dexModulePath</a>,
<a class="l" name="517" href="#517">517</a>             <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>boolean</b> <a href="/8.1.0_r33/s?defs=isSharedModule&amp;project=frameworks">isSharedModule</a>, <a href="/8.1.0_r33/s?defs=IDexModuleRegisterCallback&amp;project=frameworks">IDexModuleRegisterCallback</a> <a href="/8.1.0_r33/s?defs=callback&amp;project=frameworks">callback</a>);
<a class="l" name="518" href="#518">518</a>
<a class="l" name="519" href="#519">519</a>    <span class="c">/**
<a class="hl" name="520" href="#520">520</a>     * Ask the package manager to perform a dex-opt with the given compiler filter.
<a class="l" name="521" href="#521">521</a>     *
<a class="l" name="522" href="#522">522</a>     * Note: exposed only for the shell command to allow moving packages explicitly to a
<a class="l" name="523" href="#523">523</a>     *       definite state.
<a class="l" name="524" href="#524">524</a>     */</span>
<a class="l" name="525" href="#525">525</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=performDexOptMode&amp;project=frameworks">performDexOptMode</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=checkProfiles&amp;project=frameworks">checkProfiles</a>,
<a class="l" name="526" href="#526">526</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=targetCompilerFilter&amp;project=frameworks">targetCompilerFilter</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=force&amp;project=frameworks">force</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=bootComplete&amp;project=frameworks">bootComplete</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=splitName&amp;project=frameworks">splitName</a>);
<a class="l" name="527" href="#527">527</a>
<a class="l" name="528" href="#528">528</a>    <span class="c">/**
<a class="l" name="529" href="#529">529</a>     * Ask the package manager to perform a dex-opt with the given compiler filter on the
<a class="hl" name="530" href="#530">530</a>     * secondary dex files belonging to the given package.
<a class="l" name="531" href="#531">531</a>     *
<a class="l" name="532" href="#532">532</a>     * Note: exposed only for the shell command to allow moving packages explicitly to a
<a class="l" name="533" href="#533">533</a>     *       definite state.
<a class="l" name="534" href="#534">534</a>     */</span>
<a class="l" name="535" href="#535">535</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=performDexOptSecondary&amp;project=frameworks">performDexOptSecondary</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>,
<a class="l" name="536" href="#536">536</a>            <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=targetCompilerFilter&amp;project=frameworks">targetCompilerFilter</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=force&amp;project=frameworks">force</a>);
<a class="l" name="537" href="#537">537</a>
<a class="l" name="538" href="#538">538</a>    <span class="c">/**
<a class="l" name="539" href="#539">539</a>     * Ask the package manager to dump profiles associated with a package.
<a class="hl" name="540" href="#540">540</a>     */</span>
<a class="l" name="541" href="#541">541</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=dumpProfiles&amp;project=frameworks">dumpProfiles</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="542" href="#542">542</a>
<a class="l" name="543" href="#543">543</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=forceDexOpt&amp;project=frameworks">forceDexOpt</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="544" href="#544">544</a>
<a class="l" name="545" href="#545">545</a>    <span class="c">/**
<a class="l" name="546" href="#546">546</a>     * Execute the background dexopt job immediately.
<a class="l" name="547" href="#547">547</a>     */</span>
<a class="l" name="548" href="#548">548</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=runBackgroundDexoptJob&amp;project=frameworks">runBackgroundDexoptJob</a>();
<a class="l" name="549" href="#549">549</a>
<a class="hl" name="550" href="#550">550</a>    <span class="c">/**
<a class="l" name="551" href="#551">551</a>     * Reconcile the information we have about the secondary dex files belonging to
<a class="l" name="552" href="#552">552</a>     * {<strong>@code</strong> packagName} and the actual dex files. For all dex files that were
<a class="l" name="553" href="#553">553</a>     * deleted, update the internal records and delete the generated oat files.
<a class="l" name="554" href="#554">554</a>     */</span>
<a class="l" name="555" href="#555">555</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=reconcileSecondaryDexFiles&amp;project=frameworks">reconcileSecondaryDexFiles</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="556" href="#556">556</a>
<a class="l" name="557" href="#557">557</a>    <span class="c">/**
<a class="l" name="558" href="#558">558</a>     * Update status of external media on the package manager to scan and
<a class="l" name="559" href="#559">559</a>     * install packages installed on the external media. Like say the
<a class="hl" name="560" href="#560">560</a>     * StorageManagerService uses this to call into the package manager to update
<a class="l" name="561" href="#561">561</a>     * status of sdcard.
<a class="l" name="562" href="#562">562</a>     */</span>
<a class="l" name="563" href="#563">563</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=updateExternalMediaStatus&amp;project=frameworks">updateExternalMediaStatus</a>(<b>boolean</b> <a href="/8.1.0_r33/s?defs=mounted&amp;project=frameworks">mounted</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=reportStatus&amp;project=frameworks">reportStatus</a>);
<a class="l" name="564" href="#564">564</a>
<a class="l" name="565" href="#565">565</a>    <a href="/8.1.0_r33/s?defs=PackageCleanItem&amp;project=frameworks">PackageCleanItem</a> <a href="/8.1.0_r33/s?defs=nextPackageToClean&amp;project=frameworks">nextPackageToClean</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=PackageCleanItem&amp;project=frameworks">PackageCleanItem</a> <a href="/8.1.0_r33/s?defs=lastPackage&amp;project=frameworks">lastPackage</a>);
<a class="l" name="566" href="#566">566</a>
<a class="l" name="567" href="#567">567</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getMoveStatus&amp;project=frameworks">getMoveStatus</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=moveId&amp;project=frameworks">moveId</a>);
<a class="l" name="568" href="#568">568</a>
<a class="l" name="569" href="#569">569</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=registerMoveCallback&amp;project=frameworks">registerMoveCallback</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IPackageMoveObserver&amp;project=frameworks">IPackageMoveObserver</a> <a href="/8.1.0_r33/s?defs=callback&amp;project=frameworks">callback</a>);
<a class="hl" name="570" href="#570">570</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=unregisterMoveCallback&amp;project=frameworks">unregisterMoveCallback</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IPackageMoveObserver&amp;project=frameworks">IPackageMoveObserver</a> <a href="/8.1.0_r33/s?defs=callback&amp;project=frameworks">callback</a>);
<a class="l" name="571" href="#571">571</a>
<a class="l" name="572" href="#572">572</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=movePackage&amp;project=frameworks">movePackage</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=volumeUuid&amp;project=frameworks">volumeUuid</a>);
<a class="l" name="573" href="#573">573</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=movePrimaryStorage&amp;project=frameworks">movePrimaryStorage</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=volumeUuid&amp;project=frameworks">volumeUuid</a>);
<a class="l" name="574" href="#574">574</a>
<a class="l" name="575" href="#575">575</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=addPermissionAsync&amp;project=frameworks">addPermissionAsync</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=PermissionInfo&amp;project=frameworks">PermissionInfo</a> <a href="/8.1.0_r33/s?defs=info&amp;project=frameworks">info</a>);
<a class="l" name="576" href="#576">576</a>
<a class="l" name="577" href="#577">577</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setInstallLocation&amp;project=frameworks">setInstallLocation</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=loc&amp;project=frameworks">loc</a>);
<a class="l" name="578" href="#578">578</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getInstallLocation&amp;project=frameworks">getInstallLocation</a>();
<a class="l" name="579" href="#579">579</a>
<a class="hl" name="580" href="#580">580</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=installExistingPackageAsUser&amp;project=frameworks">installExistingPackageAsUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=installFlags&amp;project=frameworks">installFlags</a>,
<a class="l" name="581" href="#581">581</a>            <b>int</b> <a href="/8.1.0_r33/s?defs=installReason&amp;project=frameworks">installReason</a>);
<a class="l" name="582" href="#582">582</a>
<a class="l" name="583" href="#583">583</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=verifyPendingInstall&amp;project=frameworks">verifyPendingInstall</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=id&amp;project=frameworks">id</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=verificationCode&amp;project=frameworks">verificationCode</a>);
<a class="l" name="584" href="#584">584</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=extendVerificationTimeout&amp;project=frameworks">extendVerificationTimeout</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=id&amp;project=frameworks">id</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=verificationCodeAtTimeout&amp;project=frameworks">verificationCodeAtTimeout</a>, <b>long</b> <a href="/8.1.0_r33/s?defs=millisecondsToDelay&amp;project=frameworks">millisecondsToDelay</a>);
<a class="l" name="585" href="#585">585</a>
<a class="l" name="586" href="#586">586</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=verifyIntentFilter&amp;project=frameworks">verifyIntentFilter</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=id&amp;project=frameworks">id</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=verificationCode&amp;project=frameworks">verificationCode</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=failedDomains&amp;project=frameworks">failedDomains</a>);
<a class="l" name="587" href="#587">587</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getIntentVerificationStatus&amp;project=frameworks">getIntentVerificationStatus</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="588" href="#588">588</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=updateIntentVerificationStatus&amp;project=frameworks">updateIntentVerificationStatus</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=status&amp;project=frameworks">status</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="589" href="#589">589</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getIntentFilterVerifications&amp;project=frameworks">getIntentFilterVerifications</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="hl" name="590" href="#590">590</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getAllIntentFilters&amp;project=frameworks">getAllIntentFilters</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="591" href="#591">591</a>
<a class="l" name="592" href="#592">592</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setDefaultBrowserPackageName&amp;project=frameworks">setDefaultBrowserPackageName</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="593" href="#593">593</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getDefaultBrowserPackageName&amp;project=frameworks">getDefaultBrowserPackageName</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="594" href="#594">594</a>
<a class="l" name="595" href="#595">595</a>    <a href="/8.1.0_r33/s?defs=VerifierDeviceIdentity&amp;project=frameworks">VerifierDeviceIdentity</a> <a href="/8.1.0_r33/s?defs=getVerifierDeviceIdentity&amp;project=frameworks">getVerifierDeviceIdentity</a>();
<a class="l" name="596" href="#596">596</a>
<a class="l" name="597" href="#597">597</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isFirstBoot&amp;project=frameworks">isFirstBoot</a>();
<a class="l" name="598" href="#598">598</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isOnlyCoreApps&amp;project=frameworks">isOnlyCoreApps</a>();
<a class="l" name="599" href="#599">599</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isUpgrade&amp;project=frameworks">isUpgrade</a>();
<a class="hl" name="600" href="#600">600</a>
<a class="l" name="601" href="#601">601</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setPermissionEnforced&amp;project=frameworks">setPermissionEnforced</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permission&amp;project=frameworks">permission</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=enforced&amp;project=frameworks">enforced</a>);
<a class="l" name="602" href="#602">602</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPermissionEnforced&amp;project=frameworks">isPermissionEnforced</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permission&amp;project=frameworks">permission</a>);
<a class="l" name="603" href="#603">603</a>
<a class="l" name="604" href="#604">604</a>    <span class="c">/** Reflects current DeviceStorageMonitorService state */</span>
<a class="l" name="605" href="#605">605</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isStorageLow&amp;project=frameworks">isStorageLow</a>();
<a class="l" name="606" href="#606">606</a>
<a class="l" name="607" href="#607">607</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setApplicationHiddenSettingAsUser&amp;project=frameworks">setApplicationHiddenSettingAsUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=hidden&amp;project=frameworks">hidden</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="608" href="#608">608</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=getApplicationHiddenSettingAsUser&amp;project=frameworks">getApplicationHiddenSettingAsUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="609" href="#609">609</a>
<a class="hl" name="610" href="#610">610</a>    <a href="/8.1.0_r33/s?defs=IPackageInstaller&amp;project=frameworks">IPackageInstaller</a> <a href="/8.1.0_r33/s?defs=getPackageInstaller&amp;project=frameworks">getPackageInstaller</a>();
<a class="l" name="611" href="#611">611</a>
<a class="l" name="612" href="#612">612</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setBlockUninstallForUser&amp;project=frameworks">setBlockUninstallForUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=blockUninstall&amp;project=frameworks">blockUninstall</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="613" href="#613">613</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=getBlockUninstallForUser&amp;project=frameworks">getBlockUninstallForUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="614" href="#614">614</a>
<a class="l" name="615" href="#615">615</a>    <a href="/8.1.0_r33/s?defs=KeySet&amp;project=frameworks">KeySet</a> <a href="/8.1.0_r33/s?defs=getKeySetByAlias&amp;project=frameworks">getKeySetByAlias</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=alias&amp;project=frameworks">alias</a>);
<a class="l" name="616" href="#616">616</a>    <a href="/8.1.0_r33/s?defs=KeySet&amp;project=frameworks">KeySet</a> <a href="/8.1.0_r33/s?defs=getSigningKeySet&amp;project=frameworks">getSigningKeySet</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="617" href="#617">617</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPackageSignedByKeySet&amp;project=frameworks">isPackageSignedByKeySet</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=KeySet&amp;project=frameworks">KeySet</a> <a href="/8.1.0_r33/s?defs=ks&amp;project=frameworks">ks</a>);
<a class="l" name="618" href="#618">618</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPackageSignedByKeySetExactly&amp;project=frameworks">isPackageSignedByKeySetExactly</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=KeySet&amp;project=frameworks">KeySet</a> <a href="/8.1.0_r33/s?defs=ks&amp;project=frameworks">ks</a>);
<a class="l" name="619" href="#619">619</a>
<a class="hl" name="620" href="#620">620</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=addOnPermissionsChangeListener&amp;project=frameworks">addOnPermissionsChangeListener</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IOnPermissionsChangeListener&amp;project=frameworks">IOnPermissionsChangeListener</a> <a href="/8.1.0_r33/s?defs=listener&amp;project=frameworks">listener</a>);
<a class="l" name="621" href="#621">621</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=removeOnPermissionsChangeListener&amp;project=frameworks">removeOnPermissionsChangeListener</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=IOnPermissionsChangeListener&amp;project=frameworks">IOnPermissionsChangeListener</a> <a href="/8.1.0_r33/s?defs=listener&amp;project=frameworks">listener</a>);
<a class="l" name="622" href="#622">622</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=grantDefaultPermissionsToEnabledCarrierApps&amp;project=frameworks">grantDefaultPermissionsToEnabledCarrierApps</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=packageNames&amp;project=frameworks">packageNames</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="623" href="#623">623</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=grantDefaultPermissionsToEnabledImsServices&amp;project=frameworks">grantDefaultPermissionsToEnabledImsServices</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>[] <a href="/8.1.0_r33/s?defs=packageNames&amp;project=frameworks">packageNames</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="624" href="#624">624</a>
<a class="l" name="625" href="#625">625</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPermissionRevokedByPolicy&amp;project=frameworks">isPermissionRevokedByPolicy</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=permission&amp;project=frameworks">permission</a>, <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="626" href="#626">626</a>
<a class="l" name="627" href="#627">627</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getPermissionControllerPackageName&amp;project=frameworks">getPermissionControllerPackageName</a>();
<a class="l" name="628" href="#628">628</a>
<a class="l" name="629" href="#629">629</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getInstantApps&amp;project=frameworks">getInstantApps</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="hl" name="630" href="#630">630</a>    <b>byte</b>[] <a href="/8.1.0_r33/s?defs=getInstantAppCookie&amp;project=frameworks">getInstantAppCookie</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="631" href="#631">631</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setInstantAppCookie&amp;project=frameworks">setInstantAppCookie</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <b>byte</b>[] <a href="/8.1.0_r33/s?defs=cookie&amp;project=frameworks">cookie</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="632" href="#632">632</a>    <a href="/8.1.0_r33/s?defs=Bitmap&amp;project=frameworks">Bitmap</a> <a href="/8.1.0_r33/s?defs=getInstantAppIcon&amp;project=frameworks">getInstantAppIcon</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="633" href="#633">633</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isInstantApp&amp;project=frameworks">isInstantApp</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="634" href="#634">634</a>
<a class="l" name="635" href="#635">635</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=setRequiredForSystemUser&amp;project=frameworks">setRequiredForSystemUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=systemUserApp&amp;project=frameworks">systemUserApp</a>);
<a class="l" name="636" href="#636">636</a>
<a class="l" name="637" href="#637">637</a>    <span class="c">/**
<a class="l" name="638" href="#638">638</a>     * Sets whether or not an update is available. Ostensibly for instant apps
<a class="l" name="639" href="#639">639</a>     * to force exteranl resolution.
<a class="hl" name="640" href="#640">640</a>     */</span>
<a class="l" name="641" href="#641">641</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=setUpdateAvailable&amp;project=frameworks">setUpdateAvailable</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>boolean</b> <a href="/8.1.0_r33/s?defs=updateAvaialble&amp;project=frameworks">updateAvaialble</a>);
<a class="l" name="642" href="#642">642</a>
<a class="l" name="643" href="#643">643</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getServicesSystemSharedLibraryPackageName&amp;project=frameworks">getServicesSystemSharedLibraryPackageName</a>();
<a class="l" name="644" href="#644">644</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getSharedSystemSharedLibraryPackageName&amp;project=frameworks">getSharedSystemSharedLibraryPackageName</a>();
<a class="l" name="645" href="#645">645</a>
<a class="l" name="646" href="#646">646</a>    <a href="/8.1.0_r33/s?defs=ChangedPackages&amp;project=frameworks">ChangedPackages</a> <a href="/8.1.0_r33/s?defs=getChangedPackages&amp;project=frameworks">getChangedPackages</a>(<b>int</b> <a href="/8.1.0_r33/s?defs=sequenceNumber&amp;project=frameworks">sequenceNumber</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="647" href="#647">647</a>
<a class="l" name="648" href="#648">648</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=isPackageDeviceAdminOnAnyUser&amp;project=frameworks">isPackageDeviceAdminOnAnyUser</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="649" href="#649">649</a>
<a class="hl" name="650" href="#650">650</a>    <a href="/8.1.0_r33/s?defs=List&amp;project=frameworks">List</a>&lt;<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a>&gt; <a href="/8.1.0_r33/s?defs=getPreviousCodePaths&amp;project=frameworks">getPreviousCodePaths</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>);
<a class="l" name="651" href="#651">651</a>
<a class="l" name="652" href="#652">652</a>    <b>int</b> <a href="/8.1.0_r33/s?defs=getInstallReason&amp;project=frameworks">getInstallReason</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="653" href="#653">653</a>
<a class="l" name="654" href="#654">654</a>    <a href="/8.1.0_r33/s?defs=ParceledListSlice&amp;project=frameworks">ParceledListSlice</a> <a href="/8.1.0_r33/s?defs=getSharedLibraries&amp;project=frameworks">getSharedLibraries</a>(<a href="/8.1.0_r33/s?defs=in&amp;project=frameworks">in</a> <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=flags&amp;project=frameworks">flags</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="655" href="#655">655</a>
<a class="l" name="656" href="#656">656</a>    <b>boolean</b> <a href="/8.1.0_r33/s?defs=canRequestPackageInstalls&amp;project=frameworks">canRequestPackageInstalls</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="657" href="#657">657</a>
<a class="l" name="658" href="#658">658</a>    <b>void</b> <a href="/8.1.0_r33/s?defs=deletePreloadsFileCache&amp;project=frameworks">deletePreloadsFileCache</a>();
<a class="l" name="659" href="#659">659</a>
<a class="hl" name="660" href="#660">660</a>    <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=getInstantAppResolverComponent&amp;project=frameworks">getInstantAppResolverComponent</a>();
<a class="l" name="661" href="#661">661</a>
<a class="l" name="662" href="#662">662</a>    <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=getInstantAppResolverSettingsComponent&amp;project=frameworks">getInstantAppResolverSettingsComponent</a>();
<a class="l" name="663" href="#663">663</a>
<a class="l" name="664" href="#664">664</a>    <a href="/8.1.0_r33/s?defs=ComponentName&amp;project=frameworks">ComponentName</a> <a href="/8.1.0_r33/s?defs=getInstantAppInstallerComponent&amp;project=frameworks">getInstantAppInstallerComponent</a>();
<a class="l" name="665" href="#665">665</a>
<a class="l" name="666" href="#666">666</a>    <a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=getInstantAppAndroidId&amp;project=frameworks">getInstantAppAndroidId</a>(<a href="/8.1.0_r33/s?defs=String&amp;project=frameworks">String</a> <a href="/8.1.0_r33/s?defs=packageName&amp;project=frameworks">packageName</a>, <b>int</b> <a href="/8.1.0_r33/s?defs=userId&amp;project=frameworks">userId</a>);
<a class="l" name="667" href="#667">667</a>}
<a class="l" name="668" href="#668">668</a></pre>
</div>
    <div id="footer">
<p><a href="http://www.opensolaris.org/os/project/opengrok/"
 title="Served by OpenGrok"><span id="fti"></span></a></p>
<p>Indexes created Tue Jun 19 19:05:46 CEST 2018</p>
    
    </div>
    </div>
</div>
</body>
</html>

