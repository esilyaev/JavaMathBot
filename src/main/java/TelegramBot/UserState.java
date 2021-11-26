package TelegramBot;

public class UserState {
    public String chatId;
    public GameState gameState;
    public String answer;

    public UserState(String chatId, GameState gameState, String answer) {
        this.chatId = chatId;
        this.gameState = gameState;
        this.answer = answer;
    }
}
