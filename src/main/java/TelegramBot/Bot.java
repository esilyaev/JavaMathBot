package TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Bot extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;

    private final SendMessageService sendMessageService;
    private final UpdateProcessor updateProcessor;


    public Bot(String bot_name, String bot_token) {
        super();
        BOT_NAME = bot_name;
        BOT_TOKEN = bot_token;

        sendMessageService = new SendMessageServiceImpl(this);
        updateProcessor = new UpdateProcessor();


    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

           updateProcessor.Process(message, chatId, sendMessageService);
        }
    }
}
