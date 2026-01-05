package oncall;

import oncall.runner.OnCallRunner;

public class Application {
    public static void main(String[] args) {
        final var onCallRunner = new OnCallRunner();
        onCallRunner.run();
    }
}
