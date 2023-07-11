var chatContainer = null;
var stompClient = null;
var messageInput = null;
var sendButton = null;
var roomNumber = null;
var userName = null;

////////////////////////////////////////////////////////////////////

document.addEventListener("DOMContentLoaded", function() {
  chatContainer = document.getElementById("chat-container");
  messageInput = document.getElementById("message-input");
  sendButton = document.getElementById("send-button");
  var roomName = document.getElementById("room-id-text");

  roomNumber = getRoom();
  userName = getUser();


  const roomNameNode = document.createTextNode(roomNumber);
  roomName.appendChild(roomNameNode);

  connect();
  sendButton.addEventListener("click", sendMessage);

  messageInput.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
      sendMessage();
    }
  });

});

//////////////////////////////////////////////////////////////////

function connect() {
  var socket = new SockJS('/pawsome-websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
      console.log('Connected: ' + frame);
      stompClient.subscribe('/pawsome-ui/receive/'+roomNumber, function (ping) {
          var data = JSON.parse(ping.body);
          addMessage(data);
      });
  });
}

//////////////////////////////////////////////////////////////////

function sendMessage() {
  var message = messageInput.value.trim();
  if (message !== "") {
    stompClient.send('/pawsome-api/send/' + roomNumber, {},
    JSON.stringify({
        'senderName': userName,
        'message': message,
        'language': 'ENG',
        'timeStamp': new Date()
      })
    );
    messageInput.value = "";
    chatContainer.scrollTop = chatContainer.scrollHeight;
  }
}

function addMessage(data) {

  var messageClass = (data.senderName === userName) ? "outgoing" : "incoming";

  var messageElement = document.createElement("div");
  messageElement.className = "message " + messageClass;
  messageElement.innerHTML = `
    <div class="message-content">
      <div class="message-name">${data.senderName}</div>
      <div class="message-text">${data.message}</div>
    </div>
  `;
  chatContainer.appendChild(messageElement);
  chatContainer.scrollTop = chatContainer.scrollHeight;
}

/////////////////////////////////////////////////////////////////////

function getUser() {
  return localStorage.getItem("name");
}

function getRoom() {
  return localStorage.getItem("roomID")
}

//////////////////////////////////////////////////////////////////////
