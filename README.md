# todo

[![Download](http://img.shields.io/badge/APK-Download-green)](https://github.com/Husseinfo/todo/releases/latest)

~~16KB~~ 12 KB To-do list native Android application

![alt todo](https://github.com/Husseinfo/todo/blob/main/todo.png?raw=true)

# 1 - Gradle

Wait for gradle build to complete, gradle is a building system (tool) responsible for building all
of the project in order to generate an apk (compile java, add xml, convert to dalvik code... =>
produce apk)

Normally it will start automatically, to make sure everything is okay:
from menu => Build => Make Project (first item)

# 2 - Source code

## 2a - Java

Java files:

- Activities:
    - MainActivity
        - Main activity of the app => to be launched when app starts
        - It shows a list of to do items
    - AddItemActivity
        - Activity to add new item to the list
        - Started from MainActivity when Add button is clicked

- Other files:
    - Helper
        - Contains helpers methods for
            - Reading the items list from storage
            - Adding new item to the list and save to storage

## 2b - XML

Screens in android (the view of the Activity) is represented by an XML file.

In `res/layout/` there is a layout file for each activity

- activity_main contains:
    - List view for the items
    - Button to launch `AddItemActivity`
- activity_add_item contains:
    - EditText view to get the text from the user
    - Button to save the new item 




