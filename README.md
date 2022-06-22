# chat-server
Chat Server


## Requirement discussion





CHAT SERVER

SLACK
 -> Text based
 -> 1:1 Chat


Secondary requirements

 -> User
     -> User Profile
     -> search
 -> Threads




Features:
 -> Users 
     -> registered users
     -> search users
    
 -> Chat  (user1+user2)
     -> create a chat (identifier)
     -> send a message to this chat
     		-> ensuring messages are sent by the participants alone
     -> Participant notification (websocket)

Java + Spring Boot



-> User

-> Chat

-> Messages


Create Message

```
curl --location --request POST 'http://localhost:8080/api/v1/message' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fromUserId": 3,
    "toUserId": 2,
    "message": "Hello 1234"
}'

```



GET Messages

```
curl --location --request GET 'http://localhost:8080/api/v1/message?fromId=1&toId=2'
```
