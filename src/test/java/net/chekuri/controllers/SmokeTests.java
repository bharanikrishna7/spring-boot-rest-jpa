package net.chekuri.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmokeTests {
  @Autowired private SampleCustomerController sampleCustomerController;

  @Test
  void sampleControllerLoads() {
    assertThat(sampleCustomerController).isNotNull();
  }
}
