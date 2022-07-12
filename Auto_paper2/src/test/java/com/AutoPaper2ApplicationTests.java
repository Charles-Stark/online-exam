package com;

import com.Service.OB1Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoPaper2ApplicationTests {

    @Autowired
    OB1Service ob1Service;

    @Test
    void Getcount() {
        System.out.println(ob1Service.selectdata_number());
    }

    @Test
    void paper_question(){
        System.out.println(ob1Service.paper_question());

    }


}
