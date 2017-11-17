# NRLSample
This is a sample application to show the statistics of one National Rugby League match. It fetches information from FoxSports server
and displays it. There are two screens in the application, the first lists the comparison between the teams' top players, and the
second screen displayes the last match stats of selected player.

Networking utility is separated in a library/module that can be used in any project. It uses Volley to request data from server.
Utility communicates with application through controller that calls utility method to get data from server. Currently I added 
only get method that is Get request.

