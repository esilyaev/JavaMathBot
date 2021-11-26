package TelegramBot;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class UpdateProcessor {
    private HashMap<String, UserState> GlobalState;

    public UpdateProcessor() {
        GlobalState = new HashMap<>();
    }

    public void Process(String message, String chatId, SendMessageService sendMessageService) {
        if (message.equals("start")) {
            if (!GlobalState.containsKey(chatId)) {
                sendMessageService.SendMessage(chatId, "Game is started, try!");

                GlobalState.put(chatId, new UserState(chatId,
                        GameState.Started,
                        GenerateQuestion(chatId, sendMessageService)));
            }
        } else if (message.matches("-?\\d+")) {
            if (message.equals(GlobalState.get(chatId).answer)) {
                sendMessageService.SendMessage(chatId, "You win!");
                GlobalState.remove(chatId);
            }
        }
    }

    private String GenerateQuestion(String chatId, SendMessageService sendMessageService) {
        int expression = ThreadLocalRandom.current().nextInt(0, 5);
        StringBuilder str = new StringBuilder();
        int a = ThreadLocalRandom.current().nextInt(1, 25);
        int x = ThreadLocalRandom.current().nextInt(1, 25);
        int b = ThreadLocalRandom.current().nextInt(1, 25);
        int c;
        switch (expression) {
            case 0:
                //сконструировать expression
                c = a * x + b;
                str.append("найдите выражение: a*x+b ").append(a + "*X+" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());
                break;
            case 1:
                //сконструировать expression
                c = a * x * b;
                str.append("найдите выражение: a*x*b ").append(a + "*X*" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());

                break;
            case 2:
                //сконструировать expression
                c = a / x + b;
                str.append("найдите выражение: a/x+b ").append(a + "/X+" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());

                break;
            case 3:
                //сконструировать expression
                c = a / x - b;
                str.append("найдите выражение: a/x-b ").append(a + "/X-" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());

                break;
            case 4:
                //сконструировать expression
                c = a + x + b;

                str.append("найдите выражение: a+x+b ").append(a + "+X+" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());
                break;
            case 5:
                //сконструировать expression
                c = a - x + b;

                str.append("найдите выражение: a-x+b ").append(a + "-X+" + b + "=" + c);
                sendMessageService.SendMessage(chatId, str.toString());

                break;

            default:
                ;
        }
        return String.valueOf(x);
    }
}
