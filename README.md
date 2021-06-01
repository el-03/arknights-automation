# Arknights Automation
This is the Arknights UI automation for Android. For now, the only available stage is Tactical Drill LS - 5.

---
### Running the Code
For running the code, there are some steps that should be checked

- firstly, the user has to specify the properties on the 

    `src` > `main` > `java` > `config` > `config.properties`
    
    The variables that user might only need to change are
    `deviceName` and `udid`
    
- Secondly, the user has to replace the image element of the UI if needed (the existing is using the image element on Samsung A51) in

    `src` > `main` > `resources` > `imageElements`

    Don't forget to check the name of the image, it should be the same as the initial one.

- Lastly, after that user can execute the code via 

    `test` > `java` > `CucumberRunner.java`
---
I will try to maintain this code and adding new stages. If there is any inquiry or any thing, don't hestitate to contact me.