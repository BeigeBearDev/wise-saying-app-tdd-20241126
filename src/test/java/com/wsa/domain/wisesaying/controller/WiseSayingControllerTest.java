package com.wsa.domain.wisesaying.controller;

import com.wsa.AppTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("등록을 입력하면 내용과 작가를 입력받는다.")
    public void t4() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(output)
                .contains("명언: ")
                .contains("작가: ");
    }

    @Test
    @DisplayName("등록이 완료되면 명언번호가 출력된다.")
    public void t5() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(output)
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("매번 생성되는 명언번호는 1씩 증가한다.")
    public void t6() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(output)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("3번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록 명령어: 입력된 명언들을 출력한다.")
    public void t7() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                목록
                """);
        assertThat(output)
                .contains("번호 / 작가 / 명언")
                .contains("---------------------")
                .contains("3 / 이순신 / 나의 죽음을 적들에게 알리지 말라")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");
    }
}
