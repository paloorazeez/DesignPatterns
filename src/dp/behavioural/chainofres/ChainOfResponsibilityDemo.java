package dp.behavioural.chainofres;

public class ChainOfResponsibilityDemo {

    public static void main(String[] args) {

        RequestHandler requestHandler = new FrontDesk( new Supervisor( new Manager(null)));
        Request request = new Request(RequestType.LEVEL2);
        request.setDescreption("Mouse is not working");
        requestHandler.handle(request);
    }
}

enum RequestType{
    LEVEL1,LEVEL2,LEVEL3,LEVEL4,INVALID_REQUEST
}

abstract class  RequestHandler{
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler=nextHandler;
    }

    abstract void handle(Request request);

    public RequestHandler getNextHandler() {
        return nextHandler;
    }
}

class FrontDesk extends RequestHandler{



    public FrontDesk(RequestHandler nextHandler) {
        super(nextHandler);
    }



    @Override
    public void handle(Request request) {

        if(request.getType() == RequestType.LEVEL1)
        {
            System.out.println("Request: "+request.getDescreption()+" /n handled by front desk ");
        }
        else {
            getNextHandler().handle(request);
        }
    }
}


class Supervisor extends RequestHandler{


    public Supervisor(RequestHandler nextHandler) {
        super(nextHandler);
    }



    @Override
    public void handle(Request request) {

        if(request.getType() == RequestType.LEVEL2)
        {
            System.out.println("Request: "+request.getDescreption()+" /n handled by supervisor ");
        }
        else {
            getNextHandler().handle(request);
        }
    }
}


class Manager extends RequestHandler{

    public Manager(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handle(Request request) {
        if(request.getType() == RequestType.LEVEL3)
        {
            System.out.println("Request: "+request.getDescreption()+" /n handled by manager ");
        }
        else {
            System.out.println("no more handlers");
        }

    }
}

class Request{

    public Request(RequestType type) {
        this.type = type;
    }

    private RequestType type;
    private String descreption;
    private String conclusion;

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
