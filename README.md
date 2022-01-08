# Arknights Automation
This is the Arknights UI automation for Android. For now, the only available stage is **Tactical Drill LS - 5**. 

The automation is based on cucumber testing framework, The author does aware that it isn't ideal enough to create 
automation script above the testing framework. 

The author will try to rewrite the code in python
and simplifying the code. 

---
### Running the Code
For running the code, there are some steps that should be checked

- firstly, the user has to specify the properties on the 

    `src` > `main` > `java` > `config` > `config.properties`
   
- Secondly, the user has to replace the image element of the UI if needed (the existing image element asset is based on Samsung A51) in

    `src` > `main` > `resources` > `imageElements`

    Don't forget to check the name of the image, it should be the same as the initial one.

- Lastly, after that user can execute the code via 

    `test` > `java` > `CucumberRunner.java`
---
### Note

- The code might fail because of the timeout that has been set in a certain steps. So, try to increase the timeout time
might can tackle the issue.
- If there is any inquiry or anything, don't hesitate to contact me yaa...
