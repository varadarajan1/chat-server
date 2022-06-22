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


-> POST http://end-point/messages 


 {

	"from": userId,
      "To": userId,
      Message: ""
 }




-> GET http://end-point/messages?from=userId&to=userId

 [{

	"from": userId,
      "to": userId,
      Message: ""
 }]
