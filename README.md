# More Apps in Play Store

<h4> As a individual developer i have to cope paste some common code to add "More Apps" feature in my applications. It's pathetic to add common codes in all applications and some times it makes silly mistake and have to fix it again. So i think why don't i made a library just write two/three line code and get all the features. </h4>


<p align="center">
  <img src="https://raw.githubusercontent.com/paveltech/MoreApps/master/screen%20shot.png" width="350"/>
</p>


## Install

You can download from JitPack. [![](https://jitpack.io/v/paveltech/MoreApps.svg)](https://jitpack.io/#paveltech/MoreApps)

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
		}
	}
```

```xml
dependencies {
    compile 'com.github.paveltech:MoreApps:1.2'
}
```

### Json File Ready : make your json file looks like...
    [

	{
		"name": "Your App Name",
		"rating": 5,
		"package_name": "package name",
		"image": "icon image link"
	},

	{
		"name": "Call Blocker",
		"rating": 4.8,
		"package_name": "com.playoffstudio.callblocker",
		"image": "https://lh3.googleusercontent.com/CnqXt1s12Mzu-rzMcUEQpdmsk3SlBSHCHtmc02T8pTqngJeij6hLFIgcwi1R8G-Fs-am=w300"
	},
	{
		"name": "USA Online Shopping",
		"rating": 5,
		"package_name": "com.creativeapp.usashopping",
		"image": "https://lh3.googleusercontent.com/PiGn6kwmGltl7QEgMUwHtdpCJ7sPrTZOpY-ezN5zK6OJR0GNAB7c64yTMEI497Lhb9s=w300"
	}
	
    ]


### Configuration : Now have to configure java code.

1.First make a class which can extends Application class. Looks like 

```java

public class AppController extends Application {

    App app;
    @Override
    public void onCreate() {
        super.onCreate();
	  /// initialized more app library 
        app = new App(getApplicationContext());
    }
}
```

2. Add Internet permissions and Application class in your Androidmanifest 

```xml

<uses-permission android:name="android.permission.INTERNET" />
 <application>
        android:name=".AppController"
         ......................
	 ......................
    </application>
 ```
 
 3. Now you can use it as a Activity or as a Fragment
 
 ### For Activity 
 
 ```java
 Intent intent = new Intent(YourActivity.this , MoreActivity.class);
        MoreActivity.url = "your json file link";
        startActivity(intent);
```

### For Fragment 

```java

   MoreAppFragment moreAppFragment = new MoreAppFragment();
        MoreAppFragment.url = "your json file link";
		
```		


License
=======

Licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for more details.
