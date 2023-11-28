import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MainApplication {

    public static void main(String[] args) {
        // Start Server Application
        new Thread(() -> Application.launch(Server.class)).start();

        // Wait for the server to start
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start Client Application
        Platform.runLater(() -> {
            try {
                new Client().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
