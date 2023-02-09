package com.matchroom.web.pages;

public enum videoDuration {
    Short("durationMax=299"),
    Medium("durationMin=300&durationMax=600"),
    Long("durationMin=601");


    private final String duration;

    public String getDuration() {
        return this.duration;
    }

    private videoDuration(String duration) {
        this.duration = duration;
    }
}
