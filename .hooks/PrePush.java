import java.lang.Process;

public class PrePush {
    public static void main(String[] args) throws Exception {
        if (!"refs/heads/dev".equals(args[1]) && !"refs/heads/stage".equals(args[1])) {
            System.exit(0);
        }

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        String command = "java -jar \"" + args[0] + "/.hooks/junit-platform-console-standalone-1.9.1.jar\" --class-path \"" + args[0] + "/target\" --scan-class-path";

        ProcessBuilder builder = new ProcessBuilder();
        if (isWindows)
            builder.command("cmd.exe", "/c", command);
        else
            builder.command("bash", "-c", command);

        Process process = builder.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Success");
            System.exit(0);
        } else {
            System.out.println("Error");
            System.exit(1);
        }
    }
}

