package com.project.smartdevice.utilities;

public enum Icons {
    POWEROFF("⏻"),
    ERROR("❌"),
    WARNING("⚠️"),
    SETTING("⚙️"),
    COOLING("❄️"),
    SUCCESS("✔️"),
    USER("\uD83D\uDC64 "),
    PASSWORD("\uD83D\uDDDD️ "),
    LOADING("\uD83D\uDD04"),
    WAITING("⌛"),
    COOLING2("\uD83D\uDD06"),
    NOTIFICATION("\uD83D\uDD14"),
    THERMOMETER("\uD83C\uDF21️"),
    OUTOFSERVICE("\uD83D\uDEE0️");

    public final String content;

    Icons(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
