package com.project.smartdevice.utilities;

public enum Icons {
    POWER("⏻"),
    ERROR("❌"),
    SETTING("⚙️"),
    COOLING("❄️"),
    WARNING("⚠️"),
    SUCCESS("✔️"),
    USER("\uD83D\uDC64 "),
    LOADING("\uD83D\uDD04"),
    COOLING2("\uD83D\uDD06"),
    PASSWORD("\uD83D\uDDDD️ "),
    NOTIFICATION("\uD83D\uDD14"),
    THERMOMETER("\uD83C\uDF21️"),
    OUTOFSERVICE("\uD83D\uDEE0️");

    public String content;

    Icons(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
