package com.bisht.springjpa.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Java", "Java", "Introduction to Java"),
            new Topic("spring", "Java Spring", "Introduction to Spring Framework"),
            new Topic("hibernate", "Hibernate", "Introduction to Hibernate")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic updatedTopic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic topic = topics.get(i);
            if (topic.getId().equals(id)) {
                topics.set(i, updatedTopic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(new Predicate<Topic>() {
            @Override
            public boolean test(Topic topic) {
                if (topic.getId().equals(id)) {
                    return true;
                }
                return false;
            }
        });
    }
}
