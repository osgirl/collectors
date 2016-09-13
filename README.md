[![Release](https://jitpack.io/v/rightmove/collectors.svg)](https://jitpack.io/#rightmove/collectors) [![Build Status](https://travis-ci.org/rightmove/collectors.svg?branch=master)](https://travis-ci.org/rightmove/collectors) [![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/rightmove/collectors/master/LICENSE.txt)

# Collectors

Collectors is a collection of Stream Collectors for Java 8, developed by Rightmove.

## Goal of the library
The current aim of the library is to remove superfluous filter and map actions on Streams to handle Optional values. 

The longer term aim is to have numerous sub-libraries to handle different use cases; such as ImmutableCollections.

##How to use with Gradle
Add the following to your projects repository section.
```groovy
repositories {
    ...
    maven { url "https://jitpack.io" }
}
```

And add the following to your dependencies section for the desired artifacts defined below.
 ```groovy
 dependencies {
    compile 'com.github.rightmove:collectors:{artifact id}:{version}'
}
 ```


| Module     | Artifact Id      | Version                                                                                                                                 |
|------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Core       | collectors       | [![Release](https://jitpack.io/v/rightmove/collectors/collectors.svg)](https://jitpack.io/#rightmove/collectors/collectors)             |
| Guava      | collectors-guava | [![Release](https://jitpack.io/v/rightmove/collectors/collectors-guava.svg)](https://jitpack.io/#rightmove/collectors/collectors-guava) |

## Documentation
The official documentation for Collectors will be located [here](https://rightmove.github.io/collectors); however, is still under development.

In the interim, please use the Javadoc on the OptionalCollectors class.