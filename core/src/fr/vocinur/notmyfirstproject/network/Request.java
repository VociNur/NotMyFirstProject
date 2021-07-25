package fr.vocinur.notmyfirstproject.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;

public class Request {
    public Request() {
        httpRequest();
    }

    public void httpRequest(){
        HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
        Net.HttpRequest httpRequest = requestBuilder.newRequest()
                .method(Net.HttpMethods.GET)
                .url("https://www.youtube.com/")
                .build();
        Gdx.net.sendHttpRequest (httpRequest, new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                String status = httpResponse.getResultAsString();
                //do stuff here based on response
                System.out.println(status);
            }

            public void failed(Throwable t) {
                String status = "failed";
                //do stuff here based on the failed attempt
                System.out.println(status);
            }

            @Override
            public void cancelled() {
                System.out.println("Cancelled");

            }
        });
    }
}
