package com.example.demo;

import java.util.List;

public class DemoApplication {
    public static void main(String[] args) {
        int maxResult = 5; //Youtubeに返事した人気動画の数です。デフォルトで5にしておきます。

        List<String> videos = YoutubeApiClient.getVideos(args[1], maxResult, "JP");

        SlackApiClient slackApiClient = new SlackApiClient();

        String incomeWebhookUrl = args[0];
        String text = "今日のHOT動画は\n";
        for (int i = 0; i < maxResult; i++) {
            text += videos.get(i) + "\n";
        }

        System.out.println(slackApiClient.postMessage(text, incomeWebhookUrl));
    }
}