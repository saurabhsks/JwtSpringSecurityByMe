package com.app.springbootmysql.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
//       private List<Topic>topics= new ArrayList<>(Arrays.asList(
//                new Topic("spring","Spring Framework","Spring Framework Description"),
//                new Topic("java","core java","core java description"),
//                new Topic("javascript","javascript","javascript description")
//        ));

       public List<Topic>getAllTopics(){
          // return topics;
           List<Topic>topics=new ArrayList<>();
           topicRepository.findAll()
                   .forEach(topics::add);
           return topics;
       }
       public Topic getTopic(Long id){
          // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
          return topicRepository.findById(id).get();
       }

    public void addTopic(Topic topic ){
       // topics.add(topic);
        topicRepository.save(topic);

    }

    public void updateTopic(Long id, Topic topic) {
           topicRepository.save(topic);
//           for(int i=0;i<topics.size();i++){
//               Topic t=topics.get(i);
//               if(t.getId().equals(id)){
//                   topics.set(i,topic);
//                   return;
//               }
//           }
    }

    public void deleteTopic(Long id) {
           topicRepository.deleteById(id);
          // topics.removeIf(t -> t.getId().equals(id));
    }
}
