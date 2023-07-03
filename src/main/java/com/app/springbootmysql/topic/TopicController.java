package com.app.springbootmysql.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
    public List<Topic>getAllTopics(){
        return topicService.getAllTopics();
    }

   @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

   @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic ){
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/update/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id,topic);

    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable Long id){  //not working
         topicService.deleteTopic(id);
    }
}
