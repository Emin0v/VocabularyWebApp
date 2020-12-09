package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.Group1;
import com.company.entity.GroupUser;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VocabularyDbAppJpaSpringApplication {

    @Autowired
    @Qualifier("userDao")
    UserRepositoryCustom userRepo;

    public static void main(String[] args) {
        SpringApplication.run(VocabularyDbAppJpaSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<String> list = userRepo.getGroup(1);
//               for(Group1 g : list){
//                   System.out.println(g.getName());
//               }
                for(int i=0;i<list.size();i++){
                    System.out.print(list.get(i));
                }

            }
        };
        return clr;
    }

}
