# deque-Automation
deque automation framework

## Java Version 
### supported java version - java 11

## How to run Test case : 
### Run following command to run test cases :
* **For chrome :**
    ```
        mvn clean verify -Dtags=@yourTagName -Ddevice=chrome
    ```
* **For Firefox :** 
    ```
        mvn clean verify -Dtags=@yourTagName -Ddevice=firefox
    ```

##### By default the test will run on chrome browser if we dont mention -Ddevice parameter:
* Command to run is as follows :
    ``` 
       mvn clean verify -Dtags=@yourTag
    ```

##### We can also pass wait time through command line :

* Command to run : 
    ```
        mvn clean verify -Dtags=@tagName -DwaitTime=40
    ```
* The mentioned wait time is in seconds.
* This makes your test case more smooth

##### We can also run test cases in parallel as shown below :
* Command to run : 
    ```
        mvn clean verify -Dtags=@tagName -DwaitTime=40 -Dthreads=2
    ```
* Here two test cases will run in parallel as we mentioned threads as 2 in above cammand

#### Run the test cases in assignment
```
     mvn clean verify -Dtags=@deque
```
```
     mvn clean verify -Dtags=@accessibility
```

#### Where to find Generated Report :
* The report will be generated in /target/Automation-Report/ folder 
* Inside ***Automation-Report*** folder, **index.html** file is present.
* Open ***index.html*** file in browser
