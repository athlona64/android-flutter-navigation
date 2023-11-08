## Getting Started
You must build aar on flutter and then config dependencies like below example
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    String storageUrl = System.env.FLUTTER_STORAGE_BASE_URL ?: "https://storage.googleapis.com"

    repositories {
        google()
        mavenCentral()
        maven {
            url '/Users/manzer/development/devFlutter/spike/spike_widget_to_native/build/host/outputs/repo'
        }
        maven {
            url "$storageUrl/download.flutter.io"
        }
    }
}
```

then in you gradle file must implement dependencies like this

```
dependencies {
    //exists implements
    debugImplementation 'com.example.spike_widget_to_native:flutter_debug:1.0'
    profileImplementation 'com.example.spike_widget_to_native:flutter_profile:1.0'
    releaseImplementation 'com.example.spike_widget_to_native:flutter_release:1.0'
}
```
