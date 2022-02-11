package dp.behavioural.command;

/**
 * Client
 */
public class CommandDemo {


    public static void main(String[] args) {

        TextFileOperationExecutor invoker = new TextFileOperationExecutor();
        TextFile receiver = new TextFile("1.txt");
        invoker.invoke(new OpenCommand(receiver));

        invoker.invoke(new CloseCommand(receiver));

    }
}

/**
 * Receiver
 */
class TextFile{

    private String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
    }

    public void open()
    {
        System.out.println("Opening file: "+this.fileName);
    }

    public void close()
    {
        System.out.println("closing file: "+ this.fileName);
    }
}

/**
 * Invoker
 */
class TextFileOperationExecutor{


    public void invoke(Command command)
    {
        command.execute();
    }


}

/**
 * Command
 */
interface Command{
    void execute();
}

class OpenCommand implements Command{

    private TextFile textFile;

    public OpenCommand(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        this.textFile.open();
    }
}


class CloseCommand implements Command{

    private TextFile textFile;

    public CloseCommand(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {

        this.textFile.close();
    }
}
