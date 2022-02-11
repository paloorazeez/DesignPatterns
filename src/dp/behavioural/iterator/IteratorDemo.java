package dp.behavioural.iterator;

import java.util.Iterator;

public class IteratorDemo {


    public static void main(String[] args) {
        TopicList list = new TopicList(new Topic[]{
                new Topic("Programming"), new Topic("Testing"), new Topic("Devops")
        });

        Iterator<Topic> iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().getName());
        }
    }
}

class Topic{
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class TopicList{

    private Topic[] topicList;

    public TopicList(Topic[] topicList) {
        this.topicList = topicList;
    }

    public Iterator<Topic> iterator()
    {
        return new TopicIterator(this.topicList);
    }


}

class TopicIterator implements Iterator<Topic>{

    private Topic[] topics;

    private int position;

    public TopicIterator(Topic[] topics) {
        this.topics = topics;
    }

    @Override
    public boolean hasNext() {
        return (topics.length != position);
    }

    @Override
    public Topic next() {
        return topics[position++];
    }
}