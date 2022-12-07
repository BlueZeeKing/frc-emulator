package dev.blueish.frcemulator.ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.blueish.frcemulator.events.CommandEvents;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Core {
    public static void init() {
        Gson gson = new GsonBuilder().registerTypeAdapter().create();

        CommandEvents.START.register(() -> {
            HttpClient client = HttpClient.newHttpClient();
            CompletableFuture<WebSocket> ws = client.newWebSocketBuilder().buildAsync(URI.create("ws://localhost:3300/wpilibws"), new WebSocket.Listener(){
                public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                    assert last;

                    gson.fromJson

                    return null;
                }
            });
        });
    }
}
