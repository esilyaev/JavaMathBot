

import TelegramBot.Bot;
import TelegramBot.SendMessageService;
import TelegramBot.SendMessageServiceImpl;
import TelegramBot.UpdateProcessor;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MentalCalculationApplication {





    public static void main(String[] args) {
        try {
            // read config and setup environment
            PropertiesConfiguration pg = new PropertiesConfiguration();
            pg.load("application.properties");
            String bot_name = pg.getString("bot.username");
            String bot_token = pg.getString("bot.token");

            // create and setup bot
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            Bot bot = new Bot(bot_name, bot_token);
            botsApi.registerBot(bot);

            // and global service for send message



        } catch (TelegramApiException | ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
