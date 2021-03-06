var stompClient = null;

var userName = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/channel/test', function (greeting) {
            showGreeting(JSON.stringify(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/inbound/message/send", {}, JSON.stringify({
        text: $("#name").val(),
        channel: "test"
    }));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {

    while (!userName) {
        userName = prompt("Please, enter your name");
    }

    fetch('/user/authenticate', {
        method: 'PUT',
        headers: new Headers({"Content-Type": "text/plain"}),
        credentials: 'include',
        body: userName
    }).then(function() {
        $("form").on('submit', function (e) {
            e.preventDefault();
        });
        $("#connect").click(function () {
            connect();
        });
        $("#disconnect").click(function () {
            disconnect();
        });
        $("#send").click(function () {
            sendName();
        });
    });

});

