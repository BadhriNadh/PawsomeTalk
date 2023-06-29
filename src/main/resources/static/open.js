document.addEventListener("DOMContentLoaded", function() {
    var joinButton = document.getElementById("join-button");
    var createButton = document.getElementById("create-button");
  
    joinButton.addEventListener("click", function(event) {
      event.preventDefault();
      var name = document.getElementById("name-input").value.trim();
      var roomID = document.getElementById("room-id-input").value.trim();
      if (name !== "" && roomID !== "") {
        storeNameAndRoom(name, roomID);
        openChatPage();
      }
    });
  
    createButton.addEventListener("click", function(event) {
      event.preventDefault();
      var name = document.getElementById("name-input").value.trim();
      if (name !== "") {
        storeName(name);
        openChatPage();
      }
    });
  
    function storeNameAndRoom(name, roomID) {
      localStorage.setItem("name", name);
      localStorage.setItem("roomID", roomID);
    }
  
    function storeName(name) {
      localStorage.setItem("name", name);
    }
  
    function openChatPage() {
      window.location.href = "chat.html";
    }
  });
  