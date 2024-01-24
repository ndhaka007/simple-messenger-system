package com.nikhil.chat.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class Controller {

}
// 1. Creating a user on the server: Build REST API for creating users
//        Request:
//        curl --request POST ‘http:/ localhost:8080/user’ \
//        --data-raw ‘{“username”:”johnsmith007”,”passcode”:”quirkyparrot”}’
//        Response: {“status”:”success”, “message”:”User created successfully”}
//        Request:
//        curl --request POST ‘http:/ localhost:8080/user’ \
//        --data-raw ‘{“username”:”johnsmith007”,”passcode”:”fadnodebreath”}’
//        Response: {“status”:”failure”, “message”:”User already exists”}
//        Request:
//        curl --request POST ‘http:/ localhost:8080/user’ \
//        --data-raw ‘{“username”:”dummy009”,”passcode”:”wawa009”}’
//        Response: {“status”:”success”, “message”:”User created successfully”}
//        Request:
//
//        curl --request POST ‘http:/ localhost:8080/user’ \
//        --data-raw ‘{“username”:”dummy008”,”passcode”:”cocopuff”}’
//        Response: {“status”:”success”, “message”:”User created successfully”}
// 2. Logging into user session: Build a REST API for authorizing the user. Keep implementation
//        simple and security features are not needed but can be considered a bonus. A user can
//        only perform send and receive if he/she is logged in.
//        Request:
//        curl --request POST ‘http:/ localhost:8080/login’ \
//        --data-raw ‘{“username”:”johnsmith007”,”passcode”:”quirkyparrot”}’
//        Response: {“status”:”success”}
// 3. Fetching Users on the server: Build an API to get the users on the server
//        Request:
//        curl --request GET ‘http:/ localhost:8080/user’
//        Response: {“status”:”success”, “data” : [“dummy008”, ”dummy009”]}
//
// 4. Fetch unread messages: Build REST API to fetch a user’s unread messages
//        Request:
//        curl --request GET ‘http:/ localhost:8080/user/johnsmith007/message’
//        Response: {“status”:”success”, “message”: “You have message(s)”, “data” :
//        [{“username”:”dummy009”, “texts”: [“thanks man!”]}]}
//        Request:
//        curl --request GET ‘http:/ localhost:8080/user/johnsmitth007/message’
//        Response: {“status”:”success”, “message” : “No new messages”}
// 5. Send a new message: API to send a specific user a message
//        Request:
//        curl --request POST ‘http:/ localhost:8080/user/johnsmith007/message’ \
//        --data-raw ‘{“to”:”dummy009”, ”text”:”no problem”}’
//        Response: {“status”:”success”}
// 6. Get chat history with a specific user
//        Request:
//
//        curl --request GET ‘http:/ localhost:8080/user/johnsmitth007/message?friend=dummy009
//        Response: {“status”:”success”, “texts”:[{“dummy009”:“thanks man!”},{”johnsmith007”:”no
//        problem”}]}
// 7. Logout the current client session
//        Request:
//        curl --request POST ‘http:/ localhost:8080/logout’ \
//        --data-raw ‘{“username”:”johnsmith007”}’
//        Response: {“status”:”success”}