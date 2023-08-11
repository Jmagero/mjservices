package com.jm.fraud.test;

import com.jm.clients.fraud.FraudCheckResponse;
import com.jm.fraud.FraudCheckHistoryRepository;
import com.jm.fraud.FraudCheckService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FraudTest {

    @Autowired
    private FraudCheckService fraudCheckService;

    @MockBean
    private FraudCheckHistoryRepository repository;


}
