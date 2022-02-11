package dp.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.addChannel(new MediaOne());
        agency.addChannel(new ReporterTv());

        agency.updateNews("Election results announced");

        agency.updateNews("Modi passed away");
    }
}

interface Channel{

    void update(String news);

}

class MediaOne implements Channel{

    private String news;

    @Override
    public void update(String news) {
        this.news = news;
        broascast();
    }

    private void broascast() {
        System.out.println("Media One: Received news:"+this.news);
    }
}

class ReporterTv implements Channel{

    private String news;

    @Override
    public void update(String news) {
        this.news = news;
        broascast();
    }

    private void broascast() {
        System.out.println("Reporter TV: Received news:"+this.news);
    }
}

class NewsAgency{

    private List<Channel> channels = new ArrayList<>();

    public void addChannel(Channel channel)
    {
        this.channels.add(channel);
    }

    public void updateNews(String news)
    {
        channels.forEach(ch->ch.update(news));
    }
 }
