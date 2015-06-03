This app shows an login page, setting the username and the password values into a LoginUser object, then transform it to JSON (using GSon) 
then send it via POST to a given URL http://demo6655573.mockable.io/ (it is a toy app that whatever it is sent to, it returns the same JSON response)
Visually, if something goes wrong it will be shown a Toast with the message "Web Service Unreachable". 
If we have any positive response from this web servicer then it will show a toast saying the user ius already logged in

No more activities or issues shown in this app


It uses the asynk task class to make the connection and not to freeze the app. 

Still, some cleaning can be done in this project... Still working on it


compatibility:
minSdkVersion 15
targetSdkVersion 22 (Lollipop 5.0)
