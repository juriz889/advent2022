package day22;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstructorTest {
    @Test
    void instructions_get_instructions() {
        Instructor cut = new Instructor("10R5L5R10L4R5L5");
        assertThat(cut.getInstructions()).isEqualTo(List.of("10", "R", "5", "L", "5", "R", "10", "L", "4", "R", "5", "L", "5"));
    }
}