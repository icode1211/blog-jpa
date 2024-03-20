package com.estsoft.blogjpa;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

public class JUnitTotalTest {
    Map<String, String> hashMap = new HashMap<>();

    @BeforeAll					// 전체 테스트를 시작하기 전 1회 실행
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach					// 각각의 테스트 케이스를 실행하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        hashMap.put("test1", "value1");
        System.out.println("test1" + hashMap);
    }

    @Test
    public void test2() {
        hashMap.put("test2", "value2");
        System.out.println("test2" + hashMap);
    }

    @Test
    public void test3() {
        hashMap.put("test3", "value3");
        System.out.println("test3" + hashMap);
    }

    @AfterAll						// 전체 테스트를 마치고 종료하기 전에 1회 실행
    public static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach						// 각각의 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
